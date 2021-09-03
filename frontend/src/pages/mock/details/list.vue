<template>
  <div class="app-container">
    <!-- 列表 -->
    <div style="margin-top: 10px">
      <el-button @click="deleteDetails" style="margin-bottom: 10px">批量删除</el-button>
      <el-table :data="detailsList" ref="multipleTable" @selection-change="handleSelectionChange" highlight-current-row border>
        <el-table-column
          type="selection"
          width="55">
        </el-table-column>
        <el-table-column label="拦截路径" align="center" prop="interceptPath" show-overflow-tooltip />
        <el-table-column label="转发host" align="center" prop="forwardHost" show-overflow-tooltip />
        <el-table-column label="mock条件" align="center">
          <template scope="{ row }">
            {{ `${row.mockRequir}` }}
          </template>
        </el-table-column>
        <el-table-column label="请求参数" align="center" show-overflow-tooltip>
          <template scope="{ row }">
            <div @click="showJson(row.requestJson,'请求参数')">{{row.requestJson}}</div>
          </template>
        </el-table-column>
        <el-table-column label="mock返回" align="center" show-overflow-tooltip>
          <template scope="{ row }">
            <div @click="showJson(row.responseJson,'mock返回')">{{row.responseJson}}</div>
          </template>
        </el-table-column>
        <el-table-column label="回调URL" align="center" show-overflow-tooltip>
          <template scope="{ row }">
            {{ `${row.callbackUrl}` }}
          </template>
        </el-table-column>
        <el-table-column label="回调方法" align="center" prop="callbackMethod" show-overflow-tooltip/>
        <el-table-column label="回调请求参数" align="center" show-overflow-tooltip>
          <template scope="{ row }">
            <div @click="showJson(row.callbackRequestJson,'回调请求参数')">{{row.callbackRequestJson}}</div>
          </template>
        </el-table-column>
        <el-table-column label="回调返回参数" align="center" show-overflow-tooltip>
          <template scope="{ row }">
            <div @click="showJson(row.callbackResponseJson,'回调返回参数')">{{row.callbackResponseJson}}</div>
          </template>
        </el-table-column>
        <el-table-column label="创建时间" align="center" width="200" show-overflow-tooltip>
          <template scope="{ row }">
            {{ `${row.creatTime}` }}
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" width="120">
          <template scope="{ row }">
            <el-button type="danger" class="el-icon-delete" @click="deleteDetail(row)" />
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
import { getDetailsList, deleteDetail } from '@/api/details'
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
      detailsList: [],
      total: 0,
      jsonView:{},
      dialog:{
        title:'',
        dialogVisible:false
      },
      ids:[],
      queryForm: {
        pageNum: 1,
        pageSize: 10,
        projectId:this.$store.state.project.id,
        platform: null
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
    deleteDetail(detail) {
      this.ids = []
      this.ids.push(detail.id)
      this.$confirm(`删除`, '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteDetail(this.ids).then(resp => {
          this.$notify.success(resp.msg)
          this.fetchProjectList()
        })
        this.ids = []
      })
    },
    deleteDetails(){
      if (this.ids.length < 1){
        this.$alert(`请选择要删除的行`, '提示', {
          confirmButtonText: '确定'
        })
        return
      }
      this.$confirm(`批量删除`, '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteDetail(this.ids).then(resp => {
          this.$notify.success(resp.msg)
          this.fetchProjectList()
        })
        this.ids = []
      })

    },
    handleSelectionChange(val){
      this.ids = []
      val.forEach(v=>{
        this.ids.push(v.id)
      });
    },
    fetchProjectList() {
      getDetailsList(this.queryForm).then(resp => {
        this.detailsList = resp.data.data
        this.total = resp.data.total
      })
    },
    showJson(row,title){
      if (row){
        try {
          this.jsonView = JSON.parse(row)
          this.jsonPrettyFormat.visible = true
          this.jsonPrettyFormat.title = title
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
