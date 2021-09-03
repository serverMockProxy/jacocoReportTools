<template>
  <div class="app-container">
    <div>
      <el-button @click="$router.push({ name: 'AddConfig' })">添加配置</el-button>
    </div>
    <!-- 列表 -->
    <div style="margin-top: 10px">
      <el-table :data="configList" highlight-current-row border>
        <el-table-column label="拦截路径" align="center" prop="interceptPath" show-overflow-tooltip />
        <el-table-column label="转发host" align="center" prop="forwardHost" show-overflow-tooltip />
        <el-table-column label="mock条件" align="center">
          <template scope="{ row }">
            {{ `${row.mockRequir}` }}
          </template>
        </el-table-column>
        <el-table-column label="mock返回" align="center" show-overflow-tooltip>
          <template scope="{ row }">
            <div @click="showJson(row.mockResponse)">{{row.mockResponse}}</div>
          </template>
        </el-table-column>
        <el-table-column label="是否回调" align="center">
          <template scope="{ row }">
            {{ `${row.isCallback}` }}
          </template>
        </el-table-column>
        <el-table-column label="描述" align="center" prop="description" show-overflow-tooltip/>
        <el-table-column label="创建时间" align="center" width="200" show-overflow-tooltip>
          <template scope="{ row }">
            {{ `${row.createTime}` }}
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" width="120">
          <template scope="{ row }">
            <el-button type="primary" class="el-icon-edit" @click="updateConfig(row)" />
            <el-button type="danger" class="el-icon-delete" @click="deleteProject(row)" />
          </template>
        </el-table-column>
      </el-table>
    </div>
    <el-dialog :title="jsonPrettyFormat.title" :visible.sync="jsonPrettyFormat.visible">
      <json-view :data="jsonView"></json-view>
    </el-dialog>
    <!--分页-->
    <div>
      <pagination v-show="total>0" :total="total" :page.sync="queryForm.pageNum" :limit.sync="queryForm.pageSize" @pagination="fetchProjectList" />
    </div>
  </div>
</template>

<script>
import { getConfigList, deleteConfig } from '@/api/config'
import Pagination from '@/components/Pagination'
import jsonView from 'vue-json-views'
export default {
  components: {
    Pagination,
    jsonView
  },
  data() {
    return {
      jsonPrettyFormat:{
        visible:false,
        title:"json-PrettyFormat"
      },
      configList: [],
      total: 0,
      jsonView:{},
      dialog:{
        title:'',
        dialogVisible:false
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
  },
  methods: {
    onQueryBtnClick() {
      this.queryForm.pageNum = 1
      this.fetchProjectList()
    },
    updateConfig(configId) {
      this.$router.push({ name: 'UpdateConfig', params: { configId: configId.id }})
    },
    deleteProject(project) {
      this.$confirm(`删除${project.name}`, '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteConfig(project.id).then(resp => {
          this.$notify.success(resp.msg)
          this.fetchProjectList()
        })
      })
    },
    fetchProjectList() {
      getConfigList(this.queryForm).then(resp => {
        this.configList = resp.data.data
        this.total = resp.data.total
      })
    },
    showJson(row){
      if (row){
        try {
          this.jsonView = JSON.parse(row);
          this.jsonPrettyFormat.visible = true;
        }catch (e) {
        }
      }
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
