<template>
  <div style="padding: 20px">
    <el-form :model="form" label-width="100px">
      <el-form-item label="请输入WID" :rules="{ required: true}">
        <el-input v-model="form.wid" style="width: 200px"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="requestApi()">确定</el-button>
      </el-form-item>
      <el-form-item>
        <div>
          {{responseValue}}
        </div>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { query } from '@/api/toolsApi'
export default {
  data() {
    return {
      form:{
        wid:''
      },
      responseValue:''
    }
  },
  methods: {
    requestApi(){
      this.responseValue = ''
      query(this.form).then(resp => {
        this.responseValue = resp.data
      })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>


</style>
