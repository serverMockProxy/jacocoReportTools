(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-3638cede"],{"24d2":function(e,t,s){"use strict";s.d(t,"a",(function(){return a})),s.d(t,"b",(function(){return i})),s.d(t,"d",(function(){return n})),s.d(t,"c",(function(){return l}));var r=s("b775");function a(e){return Object(r["a"])({method:"post",url:"/project/add",data:e})}function i(e){return Object(r["a"])({method:"delete",url:"/project/".concat(e)})}function n(e){return Object(r["a"])({method:"post",url:"/project/update",data:e})}function l(e){return Object(r["a"])({method:"post",url:"/project/list",params:e})}},"409c":function(e,t,s){"use strict";var r=function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("el-form",{attrs:{data:e.user,"label-width":"80px"}},[s("el-form-item",{attrs:{label:"用户名",rules:[{required:!0}]}},[s("el-input",{staticStyle:{width:"300px"},attrs:{disabled:!e.isAdd,clearable:""},model:{value:e.user.username,callback:function(t){e.$set(e.user,"username","string"===typeof t?t.trim():t)},expression:"user.username"}})],1),e._v(" "),s("el-form-item",{attrs:{label:"密码",rules:[{required:!0}]}},[s("el-input",{staticStyle:{width:"300px"},attrs:{clearable:""},model:{value:e.user.password,callback:function(t){e.$set(e.user,"password","string"===typeof t?t.trim():t)},expression:"user.password"}})],1),e._v(" "),s("el-form-item",{attrs:{label:"昵称",rules:[{required:!0}]}},[s("el-input",{staticStyle:{width:"300px"},attrs:{clearable:""},model:{value:e.user.nickName,callback:function(t){e.$set(e.user,"nickName","string"===typeof t?t.trim():t)},expression:"user.nickName"}})],1),e._v(" "),s("el-form-item",{attrs:{label:"状态",rules:[{required:!0}]}},[s("el-radio",{attrs:{label:1},model:{value:e.user.status,callback:function(t){e.$set(e.user,"status",t)},expression:"user.status"}},[e._v("启用")]),e._v(" "),s("el-radio",{attrs:{label:0},model:{value:e.user.status,callback:function(t){e.$set(e.user,"status",t)},expression:"user.status"}},[e._v("禁用")])],1),e._v(" "),s("el-form-item",{attrs:{label:"角色",rules:[{required:!0}]}},[s("el-select",{attrs:{multiple:"","value-key":"id"},on:{"visible-change":e.roleSelectVisibleChange},model:{value:e.user.roles,callback:function(t){e.$set(e.user,"roles",t)},expression:"user.roles"}},e._l(e.roleList,(function(e){return s("el-option",{key:e.id,attrs:{label:e.alias,value:e}})})),1)],1),e._v(" "),s("el-form-item",{attrs:{label:"项目"}},[s("el-select",{attrs:{multiple:"","value-key":"id"},on:{"visible-change":e.projectSelectVisibleChange},model:{value:e.user.projects,callback:function(t){e.$set(e.user,"projects",t)},expression:"user.projects"}},e._l(e.projectList,(function(e){return s("el-option",{key:e.id,attrs:{label:e.name,value:e}})})),1)],1),e._v(" "),s("el-form-item",[s("el-button",{attrs:{type:"primary"},on:{click:e.saveUser}},[e._v("保 存")])],1)],1)},a=[],i=s("c24f"),n=s("b775");function l(){return Object(n["a"])({url:"/role/list",method:"get"})}var u=s("24d2"),c={props:{isAdd:Boolean},data:function(){return{user:{id:void 0,username:"",password:"",nickName:"",status:1,roles:[],projects:[]},roleList:[],projectList:[]}},created:function(){var e=this;this.fetchRoleList(),this.fetchProjectList(),this.isAdd||Object(i["d"])({id:this.$route.params.userId}).then((function(t){e.user=t.data[0]}))},methods:{saveUserSuccess:function(e){var t=this;this.$notify.success(e),this.$store.dispatch("tagsView/delView",this.$store.state.tagsView.visitedViews.filter((function(e){return e.path===t.$route.path}))[0]),this.$router.back()},saveUser:function(){var e=this;this.isAdd?Object(i["a"])(this.user).then((function(t){e.saveUserSuccess(t.msg)})):Object(i["g"])(this.user).then((function(t){e.saveUserSuccess(t.msg)}))},fetchRoleList:function(){var e=this;l().then((function(t){e.roleList=t.data}))},fetchProjectList:function(){var e=this;Object(u["c"])().then((function(t){e.projectList=t.data}))},roleSelectVisibleChange:function(e){e&&this.fetchRoleList()},projectSelectVisibleChange:function(e){e&&this.fetchProjectList()}}},o=c,d=s("2877"),p=Object(d["a"])(o,r,a,!1,null,null,null);t["a"]=p.exports},"86f6":function(e,t,s){"use strict";s.r(t);var r=function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("div",{staticClass:"app-container"},[s("save-user",{attrs:{"is-add":!1}})],1)},a=[],i=s("409c"),n={name:"UpdateUser",components:{SaveUser:i["a"]}},l=n,u=s("2877"),c=Object(u["a"])(l,r,a,!1,null,"812b0884",null);t["default"]=c.exports}}]);