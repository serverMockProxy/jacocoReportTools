<template>
  <div class="app-container">
    <div style="padding: 10px">
      <div>
        <div class="title">
          <div>父模块gitLab仓库信息</div>
        </div>
        <div class="parent">
          <el-form :model="jacocoConfig" :inline="true">
            <el-form-item label="git仓库Id:" :rules="[{required: true}]">
              <div style="width: 300px">
                <span class="tag" v-if="isShow">{{jacocoConfig.gitId}}</span>
                <el-input v-else v-model="jacocoConfig.gitId" type="number"></el-input>
              </div>
            </el-form-item>
            <el-form-item label="描述:">
              <div style="width: 300px">
                <span v-if="isShow">{{jacocoConfig.description}}</span>
                <el-input v-else v-model="jacocoConfig.description"></el-input>
              </div>
            </el-form-item>
          </el-form>
        </div>
      </div>
      <div v-show="jacocoConfig.children.length != 0">
        <div class="title">
          <div>子模块gitLab仓库信息</div>
        </div>
        <div class="children" v-for="(child,index) in jacocoConfig.children">
          <el-form :model="child" :inline="true">
            <el-form-item label="git仓库Id:" :rules="[{required: true}]">
              <div style="width: 300px">
                <span class="tag" v-if="isShow">{{child.gitId}}</span>
                <el-input v-else v-model="child.gitId" type="number"></el-input>
              </div>
            </el-form-item>
            <el-form-item label="描述:">
              <div style="width: 300px;display: flex">
                <span v-if="isShow">{{child.description}}</span>
                <el-input v-else v-model="child.description"></el-input>
                <el-button v-if="!isShow" style="margin-left: 5px" @click="deletChild(index)">删除</el-button>
              </div>
            </el-form-item>
          </el-form>
        </div>
      </div>
      <el-button @click="edit()" style="margin-left: 45px">{{buttonName}}</el-button>
      <el-button @click="addChild()" style="margin-left: 30px" v-show="!isShow">添加子模块</el-button>
    </div>

  </div>
</template>

<script>
import { creatOrUpdate,getJacocoConfig } from '@/api/jacocoConfig'
export default {
  data() {
    return {
      isShow:true,
      buttonName:'编辑',
      jacocoConfig:{
        projectId:this.$store.state.project.id,
        gitId:'',
        description:'',
        children:[]
      }
    }
  },
  created() {
    this.fetchConfig()
  },
  methods:{
    fetchConfig(){
      getJacocoConfig(this.jacocoConfig.projectId).then(res=>{
        if (res.data){
          this.jacocoConfig = res.data
        }
      })
    },
    edit(){
      this.isShow = this.isShow ? false :true
      if (this.isShow){
        this.buttonName = '编辑'
        creatOrUpdate(this.jacocoConfig).then(resp =>{
          this.$notify.success(resp.msg)
        }).finally(re=>{
          this.fetchConfig()
        })
      }else {
        this.buttonName = '保存'
      }
    },
    addChild(){
      this.jacocoConfig.children.push({
        gitId:null,
        description:''
      })
    },
    deletChild(index){
      this.jacocoConfig.children.splice(index,1)
    }
  }

}
</script>

<style lang="scss" scoped>
.title {
  position: relative;
  padding: 5px 15px 5px 25px;
  font-size: 16px;
  height: 40px;
  line-height: 30px;
  font-weight: normal;
&:before {
   content: "";
   position: absolute;
   left: 15px;
   top: 50%;
   transform: translate(0, -50%);
   width: 5px;
   height: 20px;
   background-color: #42b983;
 }
}
.parent{
  padding: 5px 5px 5px 45px;
  display: flex;
}

.children {
  padding: 5px 5px 5px 45px;
  display: flex;
}
.tag{
  background: #ecf5ff;
  border-radius: 5px;
  padding: 5px;
  border: 1px solid #d9ecff;
  color: #409eff
}

</style>
