(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-18b31f28"],{9334:function(t,i,e){"use strict";e("b738")},b738:function(t,i,e){},b828:function(t,i,e){"use strict";e.d(i,"a",(function(){return o})),e.d(i,"b",(function(){return c}));var n=e("b775");function o(t){return Object(n["a"])({method:"post",url:"/jacocoConfig/creatOrUpdate",data:t})}function c(t){return Object(n["a"])({method:"get",url:"/jacocoConfig/getConfig/".concat(t)})}},fde6:function(t,i,e){"use strict";e.r(i);var n=function(){var t=this,i=t.$createElement,e=t._self._c||i;return e("div",{staticClass:"app-container"},[e("div",{staticStyle:{padding:"10px"}},[e("div",[t._m(0),t._v(" "),e("div",{staticClass:"parent"},[e("el-form",{attrs:{model:t.jacocoConfig,inline:!0}},[e("el-form-item",{attrs:{label:"git仓库Id:",rules:[{required:!0}]}},[e("div",{staticStyle:{width:"300px"}},[t.isShow?e("span",{staticClass:"tag"},[t._v(t._s(t.jacocoConfig.gitId))]):e("el-input",{attrs:{type:"number"},model:{value:t.jacocoConfig.gitId,callback:function(i){t.$set(t.jacocoConfig,"gitId",i)},expression:"jacocoConfig.gitId"}})],1)]),t._v(" "),e("el-form-item",{attrs:{label:"描述:"}},[e("div",{staticStyle:{width:"300px"}},[t.isShow?e("span",[t._v(t._s(t.jacocoConfig.description))]):e("el-input",{model:{value:t.jacocoConfig.description,callback:function(i){t.$set(t.jacocoConfig,"description",i)},expression:"jacocoConfig.description"}})],1)])],1)],1)]),t._v(" "),e("div",{directives:[{name:"show",rawName:"v-show",value:0!=t.jacocoConfig.children.length,expression:"jacocoConfig.children.length != 0"}]},[t._m(1),t._v(" "),t._l(t.jacocoConfig.children,(function(i,n){return e("div",{staticClass:"children"},[e("el-form",{attrs:{model:i,inline:!0}},[e("el-form-item",{attrs:{label:"git仓库Id:",rules:[{required:!0}]}},[e("div",{staticStyle:{width:"300px"}},[t.isShow?e("span",{staticClass:"tag"},[t._v(t._s(i.gitId))]):e("el-input",{attrs:{type:"number"},model:{value:i.gitId,callback:function(e){t.$set(i,"gitId",e)},expression:"child.gitId"}})],1)]),t._v(" "),e("el-form-item",{attrs:{label:"描述:"}},[e("div",{staticStyle:{width:"300px",display:"flex"}},[t.isShow?e("span",[t._v(t._s(i.description))]):e("el-input",{model:{value:i.description,callback:function(e){t.$set(i,"description",e)},expression:"child.description"}}),t._v(" "),t.isShow?t._e():e("el-button",{staticStyle:{"margin-left":"5px"},on:{click:function(i){return t.deletChild(n)}}},[t._v("删除")])],1)])],1)],1)}))],2),t._v(" "),e("el-button",{staticStyle:{"margin-left":"45px"},on:{click:function(i){return t.edit()}}},[t._v(t._s(t.buttonName))]),t._v(" "),e("el-button",{directives:[{name:"show",rawName:"v-show",value:!t.isShow,expression:"!isShow"}],staticStyle:{"margin-left":"30px"},on:{click:function(i){return t.addChild()}}},[t._v("添加子模块")])],1)])},o=[function(){var t=this,i=t.$createElement,e=t._self._c||i;return e("div",{staticClass:"title"},[e("div",[t._v("父模块gitLab仓库信息")])])},function(){var t=this,i=t.$createElement,e=t._self._c||i;return e("div",{staticClass:"title"},[e("div",[t._v("子模块gitLab仓库信息")])])}],c=e("b828"),s={data:function(){return{isShow:!0,buttonName:"编辑",jacocoConfig:{projectId:this.$store.state.project.id,gitId:"",description:"",children:[]}}},created:function(){this.fetchConfig()},methods:{fetchConfig:function(){var t=this;Object(c["b"])(this.jacocoConfig.projectId).then((function(i){i.data&&(t.jacocoConfig=i.data)}))},edit:function(){var t=this;this.isShow=!this.isShow,this.isShow?(this.buttonName="编辑",Object(c["a"])(this.jacocoConfig).then((function(i){t.$notify.success(i.msg)})).finally((function(i){t.fetchConfig()}))):this.buttonName="保存"},addChild:function(){this.jacocoConfig.children.push({gitId:null,description:""})},deletChild:function(t){this.jacocoConfig.children.splice(t,1)}}},a=s,l=(e("9334"),e("2877")),r=Object(l["a"])(a,n,o,!1,null,"813538ee",null);i["default"]=r.exports}}]);