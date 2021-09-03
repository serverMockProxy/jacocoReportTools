<template>
  <div style="padding: 20px">
    <div style="display: flex">
      <el-row class="row">
        <el-col class="col" v-for="(row, index) in tools" :key="index">
          <div @click="openTools(row.path)">
            <el-card >
              <div >
                <div class="card-icon" >
                  <img src="@/assets/mxm.png" width="100px">
                </div>
                <div class="card-name" style="text-align: center">
                  {{row.toolName}}
                </div>
              </div>
            </el-card>
          </div>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      tools:[
        {
          toolName:'分库工具',
          path:'demo'
        }
      ]
    }
  },
  methods: {
    openTools(path){
      console.log(path)
      this.$router.push({path:path})
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

.col {
  width: 150px;
  margin: 10px;
}
.el-card {
  height: 150px;
  width: 140px;
  display: flex;
}

</style>
