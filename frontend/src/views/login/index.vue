<template>
  <div class="app-container">
    <div style="margin-top: 150px">
      <div align="center" style="margin-bottom: 10px">
        <img :src="logo" style="width: 80px;height: 80px">
      </div>
      <div style="width: 300px; margin: auto;">
        <el-input v-model="loginForm.username" tabindex="1" clearable style="margin-bottom: 20px">
          <template slot="prepend">账号</template>
        </el-input>
        <el-input v-model="loginForm.password" tabindex="2" show-password clearable style="margin-bottom: 20px" @keyup.enter.native="handleLogin">
          <template slot="prepend">密码</template>
        </el-input>
        <el-button style="width: 100%" type="primary" @click.native.prevent="handleLogin">登录</el-button>
      </div>
    </div>
  </div>
</template>

<script>
import logo from '@/assets/logo.png'
export default {
  name: 'Login',
  data() {
    return {
      loginForm: {
        username: '',
        password: ''
      },
      redirect: undefined,
      logo: logo
    }
  },
  watch: {
    $route: {
      handler: function(route) {
        this.redirect = route.query && route.query.redirect
      },
      immediate: true
    }
  },
  methods: {
    handleLogin() {
      // var regex = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/g;
      // if (regex.test(this.loginForm.username)){
      //   this.$message.error('请使用邮箱前缀或手机号登录');
      // }else {
      //   var regexPhone = /^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\d{8}$/;
      //   var login = JSON.parse(JSON.stringify(this.loginForm))
      //   if (!regexPhone.test(login.username)){
      //     login.username = login.username+"@yoozoo.com";
      //   }
      //   this.$store.dispatch('user/login', login).then(() => {
      //     this.$router.push({ path: this.redirect || '/' })
      //   })
      // }
      var login = JSON.parse(JSON.stringify(this.loginForm))
      this.$store.dispatch('user/login', login).then(() => {
        this.$router.push({ path: this.redirect || '/' })
      })
    }
  }
}
</script>
