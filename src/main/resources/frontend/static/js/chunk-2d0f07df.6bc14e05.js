(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0f07df"],{"9d31":function(e,t,n){"use strict";n.r(t);var r=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticStyle:{padding:"20px"}},[n("el-form",{attrs:{model:e.form,"label-width":"100px"}},[n("el-form-item",{attrs:{label:"请输入WID",rules:{required:!0}}},[n("el-input",{staticStyle:{width:"200px"},model:{value:e.form.wid,callback:function(t){e.$set(e.form,"wid",t)},expression:"form.wid"}})],1),e._v(" "),n("el-form-item",[n("el-button",{on:{click:function(t){return e.requestApi()}}},[e._v("确定")])],1),e._v(" "),n("el-form-item",[n("div",[e._v("\n        "+e._s(e.responseValue)+"\n      ")])])],1)],1)},o=[],i=n("b775");function s(e){return Object(i["a"])({method:"post",url:"/tools/query",data:e})}var l={data:function(){return{form:{wid:""},responseValue:""}},methods:{requestApi:function(){var e=this;this.responseValue="",s(this.form).then((function(t){e.responseValue=t.data}))}}},a=l,u=n("2877"),d=Object(u["a"])(a,r,o,!1,null,"1a16c5d4",null);t["default"]=d.exports}}]);