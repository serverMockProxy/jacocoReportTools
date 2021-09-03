<template>
  <div class="app-container">
    <div>
      <el-button @click="creatJacoco()">生成jacoco报告</el-button>
    </div>
    <!-- 列表 -->
    <div style="margin-top: 10px">
      <el-table :data="detailsList" highlight-current-row border>
        <el-table-column label="项目名称" align="center" prop="jacocoProjectName" show-overflow-tooltip />
        <el-table-column label="比较类型" align="center">
          <template scope="{ row }">
            <span v-if="row.compareType == 1">分支比较</span>
            <span v-else-if="row.compareType == 2">commit比较</span>
            <span v-else>全量比较</span>
          </template>
        </el-table-column>
        <el-table-column label="当前分支" align="center" prop="currentBranch"/>
        <el-table-column label="对比分支" align="center" prop="compareBranch"/>
        <el-table-column label="当前commit" align="center" prop="currentCommit" show-overflow-tooltip/>
        <el-table-column label="对比commit" align="center" prop="compareCommit" show-overflow-tooltip/>
        <el-table-column label="开始时间" align="center" prop="startTime"/>
        <el-table-column label="结束时间" align="center" prop="endTime"/>
        <el-table-column label="任务状态" align="center">
          <template scope="{ row }">
            <span v-if="row.taskStatus == 0">未开始</span>
            <span v-else-if="row.taskStatus == 1">进行中</span>
            <span v-else>已完成</span>
          </template>
        </el-table-column>
        <el-table-column label="报告地址" align="center">
          <template scope="{ row }">
            <div v-if="row.reportPath === '' || row.reportPath === null">无</div>
            <el-link v-else :href="row.reportPath" type="primary" target="_blank">
              查看
            </el-link>
          </template>
        </el-table-column>
        <el-table-column label="描述" align="center" prop="description" show-overflow-tooltip/>
        <el-table-column label="操作" align="center" width="120">
          <template scope="{ row }">
            <el-button type="danger" class="el-icon-delete" @click="deleteJacoco(row)" />
          </template>
        </el-table-column>
      </el-table>
    </div>
    <el-dialog :title="dialog.title" :visible.sync="dialog.visible">
      <span>父模块----->{{jacocoConfig.description}}</span>
      <el-form :data="jacocoCommit" ref="form" label-width="100px">
        <el-form-item label="比较类型:" :rules="[{required: true}]">
          <el-radio v-model="jacocoCommit.compareType" label="1" border>branch</el-radio>
          <el-radio v-model="jacocoCommit.compareType" label="2" border>commit</el-radio>
          <el-radio v-model="jacocoCommit.compareType" label="3" border>全量</el-radio>
        </el-form-item>
        <el-form-item label="时间段:" :rules="[{required: true}]">
          <el-date-picker
            v-model="time"
            style="width: 340px"
            format="yyyy-MM-dd HH:mm:ss"
            value-format="yyyy-MM-dd HH:mm:ss"
            type="datetimerange"
            range-separator="至"
            start-placeholder="开始日期"
            end-placeholder="结束日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="当前分支:" :rules="[{required: true}]">
          <el-select v-model="jacocoCommit.currentBranch" @visible-change="getBranche($event,jacocoConfig.gitId)" placeholder="请选择" style="width: 340px">
            <el-option
              v-for="item in branches"
              :key="item.name"
              :label="item.name"
              :value="item.name">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-if="jacocoCommit.compareType == 1">
          <el-form-item label="对比分支:" :rules="[{required: true}]">
            <el-select v-model="jacocoCommit.compareBranch" @visible-change="getBranche($event,jacocoConfig.gitId)" placeholder="请选择" style="width: 340px">
              <el-option
                v-for="item in branches"
                :key="item.name"
                :label="item.name"
                :value="item.name">
              </el-option>
            </el-select>
          </el-form-item>
        </div>
        <div v-if="jacocoCommit.compareType == 2">
          <el-form-item label="当前commit:" :rules="[{required: true}]">
            <el-select v-model="jacocoCommit.currentCommit" @visible-change="getCommitId($event,jacocoConfig.gitId,jacocoCommit.currentBranch)" placeholder="请选择" style="width: 340px">
              <el-option
                v-for="item in commits"
                :key="item.id"
                :label="item.id"
                :value="item.id">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="对比commit:" :rules="[{required: true}]">
            <el-select v-model="jacocoCommit.compareCommit" @visible-change="getCommitId($event,jacocoConfig.gitId,jacocoCommit.currentBranch)" placeholder="请选择" style="width: 340px">
              <el-option
                v-for="item in commits"
                :key="item.id"
                :label="item.id"
                :value="item.id">
              </el-option>
            </el-select>
          </el-form-item>
        </div>
      </el-form>
      <div v-for="(commit,index) in jacocoCommit.childrens">
        <span>子模块{{index+1}}----->{{commit.description}}</span>
        <div>
          <el-form :data="commit" ref="form" label-width="100px">
            <el-form-item label="当前分支:" :rules="[{required: true}]">
              <el-select v-model="commit.currentBranch" @visible-change="getBranche($event,commit.gitlabId)" placeholder="请选择" style="width: 340px">
                <el-option
                  v-for="item in branches"
                  :key="item.name"
                  :label="item.name"
                  :value="item.name">
                </el-option>
              </el-select>
            </el-form-item>
            <div v-if="jacocoCommit.compareType == 1">
              <el-form-item label="对比分支:" :rules="[{required: true}]">
                <el-select v-model="commit.compareBranch" @visible-change="getBranche($event,commit.gitlabId)" placeholder="请选择" style="width: 340px">
                  <el-option
                    v-for="item in branches"
                    :key="item.name"
                    :label="item.name"
                    :value="item.name">
                  </el-option>
                </el-select>
              </el-form-item>
            </div>
            <div v-if="jacocoCommit.compareType == 2">
              <el-form-item label="当前commit:" :rules="[{required: true}]">
                <el-select v-model="commit.currentCommit" @visible-change="getCommitId($event,commit.gitlabId,commit.currentBranch)" placeholder="请选择" style="width: 340px">
                  <el-option
                    v-for="item in commits"
                    :key="item.id"
                    :label="item.id"
                    :value="item.id">
                  </el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="对比commit:" :rules="[{required: true}]">
                <el-select v-model="commit.compareCommit" @visible-change="getCommitId($event,commit.gitlabId,commit.currentBranch)" placeholder="请选择" style="width: 340px">
                  <el-option
                    v-for="item in commits"
                    :key="item.id"
                    :label="item.id"
                    :value="item.id">
                  </el-option>
                </el-select>
              </el-form-item>
            </div>
          </el-form>
        </div>
      </div>
      <el-button @click="creatReport">提交任务</el-button>
    </el-dialog>
    <!--分页-->
    <div>
      <pagination v-show="total>0" :total="total" :page.sync="queryForm.pageNum" :limit.sync="queryForm.pageSize" @pagination="fetchProjectList" />
    </div>
  </div>
</template>

<script>
import { getBranches, getCommits,creatReport,getjacocoList,deleteJacocos} from '@/api/jacoco'
import { getJacocoConfig} from '@/api/jacocoConfig'
import Pagination from '@/components/Pagination'
import Link from "../../../layout/components/Sidebar/Link";
export default {
  components: {
    Link,
    Pagination
  },
  data() {
    return {
      detailsList: [],
      total: 0,
      projectId:this.$store.state.project.id,
      jsonView:{},
      branches: [],
      commits: [],
      dialog:{
        title:'生成jacoco报告',
        visible:false
      },
      time:'',
      jacocoConfig:{
        projectId:'',
        gitId:'',
        description:'',
        children:[]
      },
      jacocoCommit:{
        projectId:'',
        compareType:'1',
        currentBranch:'',
        compareBranch:'',
        currentCommit:'',
        compareCommit:'',
        startTime:Date,
        endTime:Date,
        childrens:[]
      },
      queryForm: {
        pageNum: 1,
        pageSize: 10,
        projectId: this.$store.state.project.id
      }
    }
  },
  created() {
    this.fetchProjectList()
    this.getConfig()
  },
  methods: {
    onQueryBtnClick() {
      this.queryForm.pageNum = 1
      this.fetchProjectList()
    },
    updateConfig(configId) {
      this.$router.push({ name: 'UpdateConfig', params: { configId: configId.id }})
    },
    deleteJacoco(detail) {
      var ids=[]
      ids.push(detail.id)
      this.$confirm(`删除`, '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteJacocos(ids).then(resp => {
          this.$notify.success(resp.msg)
          this.fetchProjectList()
        })
      })
    },
    fetchProjectList() {
      getjacocoList(this.queryForm).then(resp => {
        this.detailsList = resp.data.data
        this.total = resp.data.total
      })
    },
    getConfig(){
      getJacocoConfig(this.projectId).then(res =>{
        this.jacocoConfig = res.data
        this.jacocoCommit.gitlabId = this.jacocoConfig.gitId
        if (this.jacocoConfig.children){
          this.jacocoConfig.children.forEach(config=>{
            var comit = {
              gitlabId:config.gitId,
              description: config.description,
              compareType:'',
              currentBranch:'',
              compareBranch:'',
              currentCommit:'',
              compareCommit:''
            }
            this.jacocoCommit.childrens.push(comit)
          })
        }
      })
    },
    creatJacoco(){
      this.dialog.visible = true
    },
    async getBranche(event,gitId){
      if (event){
        await getBranches(gitId).then(resp =>{
          this.branches = resp.data
        })
      }
    },
    async getCommitId(event,gitId,branch){
      if (event && branch){
        var query = {
          branch: branch
        }
        await getCommits(gitId,query).then(resp =>{
          this.commits = resp.data
        })
      }
    },
    creatReport(){
      this.jacocoCommit.startTime = this.time[0]
      this.jacocoCommit.endTime = this.time[1]
      this.jacocoCommit.projectId = this.$store.state.project.id;
      this.jacocoCommit.childrens.forEach(jacoco=>{
        jacoco.compareType = this.jacocoCommit.compareType
      })
      creatReport(this.jacocoCommit).then(resp =>{
        this.$notify.success(resp.msg)
      })
      this.dialog.visible = false;
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
