<template>
  <div>
    <div>
      <div class="interface-title">拦截配置</div>
      <el-form :data="proxyConfig" :inline="true" label-width="120px">
        <el-form-item label="拦截路径" :rules="[{required: true}]">
          <el-input v-model.trim="proxyConfig.interceptPath" clearable style="width: 300px" />
        </el-form-item>
        <el-form-item label="转发host" :rules="[{required: true}]">
          <el-input v-model.trim="proxyConfig.forwardHost" clearable style="width: 300px" />
        </el-form-item>
      </el-form>
      <el-form :data="proxyConfig" :inline="true" label-width="120px">
        <el-form-item label="mock条件" :rules="[{required: false}]">
          <el-input v-model.trim="proxyConfig.mockRequir" clearable style="width: 300px" />
        </el-form-item>
        <el-form-item label="mock返回" :rules="[{required: false}]">
          <el-input v-model.trim="proxyConfig.mockResponse" clearable style="width: 300px"/>
        </el-form-item>
      </el-form>
      <el-form :data="proxyConfig" :inline="true" label-width="120px">
        <el-form-item label="是否回调" :rules="[{required: true}]">
          <el-switch
            v-model="proxyConfig.isCallback"
            active-color="#13ce66"
            inactive-color="#ff4949">
          </el-switch>
        </el-form-item>
      </el-form>
      <div style="width: 100%" v-if="proxyConfig.isCallback">
        <div class="interface-title">回调信息</div>
        <div class="base_row_edit">
          <el-form :model="proxyConfig" :inline="true" ref="form1" label-width="120px">
            <el-form-item label="回调host":rules="[{required: true}]">
              <el-input style="width: 300px" v-model="proxyConfig.callbackHost"></el-input>
            </el-form-item>
            <el-form-item label="回调路径" style="width: 615px" :rules="[{required: true}]">
              <el-input style="width: 300px" v-model="proxyConfig.callbackPath">
                <el-select v-model="proxyConfig.callbackMethod" slot="prepend" placeholder="请选择" style="width: 90px;margin: -10px -30px">
                  <el-option label="get" value="get"></el-option>
                  <el-option label="post" value="post"></el-option>
                  <el-option label="put" value="put"></el-option>
                  <el-option label="delete" value="delete"></el-option>
                </el-select>
              </el-input>
            </el-form-item>
          </el-form>
          <el-form :model="proxyConfig" :inline="true" label-width="120px">
            <el-form-item label="sign方式" :rules="[{required: true}]">
              <el-select v-model="proxyConfig.signType" style="width: 300px"  filterable placeholder="请选择">
                <el-option label="无sign" :value="1"></el-option>
                <el-option label="md5加密,请求体添加sign" :value="2"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="clientSecret">
              <el-input style="width: 300px" v-model="proxyConfig.clientSecret"></el-input>
            </el-form-item>
          </el-form>
        </div>
        <div class="interface-title" style="margin-top:30px">请求参数</div>
        <div style="width: 90%;margin-left: 40px;text-align: center">
          <el-radio-group v-model="proxyConfig.callbackBodyType">
            <el-radio-button label="Json"></el-radio-button>
            <el-radio-button label="Query"></el-radio-button>
            <el-radio-button label="Form"></el-radio-button>
          </el-radio-group>
        </div>
        <div class="quest_edit">
          <el-tabs>
            <el-tab-pane label="请求头">
              <el-table
                :data="proxyConfig.callbackHeaders"
                size="mini"
                style="width: 100%">
                <el-table-column align="center" fixed="left" width="95">
                  <template slot="header" slot-scope="scope">
                    <el-button size="small" type="primary" plain icon="el-icon-plus"
                               @click="addHeader">新增</el-button>
                  </template>
                  <template slot-scope="scope">
                    <el-button size="small" type="danger" plain circle icon="el-icon-minus" @click="deleteHeader(scope.$index)"></el-button>
                  </template>
                </el-table-column>
                <el-table-column
                  label="Header">
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.headerKey" placeholder="Header"></el-input>
                  </template>
                </el-table-column>
                <el-table-column
                  label="Value">
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.headerValue" placeholder="Value"></el-input>
                  </template>
                </el-table-column>
                <el-table-column
                  label="备注">
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.description" placeholder="备注"></el-input>
                  </template>
                </el-table-column>
              </el-table>
            </el-tab-pane>
            <el-tab-pane v-if="proxyConfig.callbackBodyType === 'Json'" label="Json参数">
              <el-button @click="jsonImport">json导入</el-button>
              <object-list v-bind:list="proxyConfig.callbackRequestJson" :depth="0"></object-list>
            </el-tab-pane>
            <el-tab-pane v-if="proxyConfig.callbackBodyType === 'Query'"label="Query参数">
              <el-table
                :data="proxyConfig.callbackRequestQuery"
                size="mini"
                style="width: 100%">
                <el-table-column align="center" fixed="left" width="95">
                  <template slot="header" slot-scope="scope">
                    <el-button size="small" type="primary" plain icon="el-icon-plus"
                               @click="addBody">新增</el-button>
                  </template>
                  <template slot-scope="scope">
                    <el-button size="small" type="danger" plain circle icon="el-icon-minus" @click="deleteBody(scope.$index)"></el-button>
                  </template>
                </el-table-column>
                <el-table-column
                  label="参数名称">
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.key" placeholder="参数名称"></el-input>
                  </template>
                </el-table-column>
                <el-table-column
                  label="参数值">
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.value" placeholder="参数值"></el-input>
                  </template>
                </el-table-column>
                <el-table-column
                  label="备注">
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.description" placeholder="备注"></el-input>
                  </template>
                </el-table-column>
              </el-table>
            </el-tab-pane>
            <el-tab-pane v-if="proxyConfig.callbackBodyType === 'Form'"label="Form参数">
              <el-table
                :data="proxyConfig.callbackRequestForm"
                size="mini"
                style="width: 100%">
                <el-table-column align="center" fixed="left" width="95">
                  <template slot="header" slot-scope="scope">
                    <el-button size="small" type="primary" plain icon="el-icon-plus"
                               @click="addBody">新增</el-button>
                  </template>
                  <template slot-scope="scope">
                    <el-button size="small" type="danger" plain circle icon="el-icon-minus" @click="deleteBody(scope.$index)"></el-button>
                  </template>
                </el-table-column>
                <el-table-column
                  label="参数名称">
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.key" placeholder="参数名称"></el-input>
                  </template>
                </el-table-column>
                <el-table-column
                  label="参数值">
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.value" placeholder="参数值"></el-input>
                  </template>
                </el-table-column>
                <el-table-column
                  label="备注">
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.description" placeholder="备注"></el-input>
                  </template>
                </el-table-column>
              </el-table>
            </el-tab-pane>
          </el-tabs>
        </div>
      </div>
      <el-dialog width="950px" :title="'导入json'" :visible.sync="importJson.visibleapi">
        <el-input type="textarea" :rows="10" v-model="importJson.jsonString"></el-input>
        <el-button style="margin-top: 5px" @click="importJ()">导入</el-button>
      </el-dialog>
      <el-button type="primary" @click="saveConfig" style="margin: 20px">保存</el-button>
    </div>
  </div>
</template>
<script>
import { addConfig, updateConfig, getConfigList, importJson} from '@/api/config'
import ObjectList from "./objectList";
export default {
  props: {
    isAdd: Boolean
  },
  components:{
    ObjectList
  },
  data() {
    return {
      importJson:{
        visibleapi:false,
        jsonString:''
      },
      proxyConfig:{
        id:undefined,
        projectId: this.$store.state.project.id,
        description:'',
        interceptPath:'',
        forwardHost:'',
        status:true,
        mockRequir:'',
        mockResponse:'',
        isCallback:false,
        callbackHost:'',
        callbackPath:'',
        callbackMethod:'get',
        signType:1,
        clientSecret:'',
        clientId:'',
        callbackHeaders:[
          {
            headerKey:'Content-Type',
            headerValue:'application/json',
            description:''
          }
        ],
        callbackBodyType:'Json',
        callbackRequestJson:[
          {
            num:1,
            type:'object',
            value:'',
            key:"#root",
            description:'',
            children:[]
          }
        ],
        callbackRequestQuery:[],
        callbackRequestForm:[]
      }
    }
  },
  created() {
    if (!this.isAdd) {
      getConfigList({ id: this.$route.params.configId }).then(response => {
        this.proxyConfig = response.data[0]
      })
    }
  },
  methods: {
    saveProjectSuccess(msg) {
      this.$notify.success(msg)
      // 关闭当前tagview
      this.$store.dispatch('tagsView/delView', this.$store.state.tagsView.visitedViews.filter(item => item.path === this.$route.path)[0])
      this.$router.back()
    },
    saveConfig() {
      if (this.isAdd) {
        addConfig(this.proxyConfig).then(response => {
          this.saveProjectSuccess(response.msg)
        })
      } else {
        updateConfig(this.proxyConfig).then(response => {
          this.saveProjectSuccess(response.msg)
        })
      }
    },
    addHeader(){
      this.proxyConfig.callbackHeaders.push(
        {
          headerKey:'',
          headerValue:'',
          description:''
        }
      )
    },
    deleteHeader(index){
      this.proxyConfig.callbackHeaders.splice(index,1);
    },
    jsonImport(){
      this.importJson.visibleapi = true;
    },
    importJ(){
      importJson(this.importJson).then(response => {
        // this.formData.jsonBody = response.data;
        this.$set(this.proxyConfig.callbackRequestJson, 0, response.data)
        this.$message({ message: response.msg, type: 'success' })
        this.importJson.visibleapi = false;
      })
    },
    addBody(){
      if (this.proxyConfig.callbackBodyType === 'Query'){
        this.proxyConfig.callbackRequestQuery.push(
          {
            key:'',
            value:'',
            description:''
          }
        )
      }

      if (this.proxyConfig.callbackBodyType === 'Form'){
        this.proxyConfig.callbackRequestForm.push(
          {
            key:'',
            value:'',
            description:''
          }
        )
      }
    },
    deleteBody(index){
      if (this.proxyConfig.callbackBodyType === 'Query'){
        this.proxyConfig.callbackRequestQuery.splice(index,1);
      }
      if (this.proxyConfig.callbackBodyType === 'Form'){
        this.proxyConfig.callbackRequestForm.splice(index,1);
      }
    }
  }
}
</script>
<style lang="scss" scoped>
.interface-title{
  position: relative;
  padding: 1px 1px 1px 20px;
  font-size: 16px;
  height: 30px;
  line-height: 20px;
  font-weight: normal;
  display: flex;
  &:before {
    content: "";
    position: absolute;
    left: 15px;
    top: 40%;
    transform: translate(0, -50%);
    width: 3px;
    height: 20px;
    background-color: #10a296	 ;
  }
}

.base_row_edit{
  /*margin-left: 10%;*/
  /*padding: 0px 10px 0px 40px;*/
}

.quest_edit{
  padding: 0px 10px 0px 40px;
}
.rq-header-edit{
  /*padding: 20px;*/
  font-size: 12px;
}
.bodytype{
  border: 5px;
  border-color: blue;
}
.heade-row{
  display: flex;
  margin-top: 10px;
  .el-input{
    margin-right: 10px;
  }
}

</style>
