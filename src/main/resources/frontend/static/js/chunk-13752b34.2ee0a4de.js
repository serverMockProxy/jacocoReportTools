(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-13752b34"],{"477b":function(e,t,i){"use strict";i("5aee")},"5aee":function(e,t,i){},c974:function(e,t,i){"use strict";i.r(t);var l=function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",[i("sticky",{attrs:{"z-index":10,"class-name":"sub-navbar"}},[i("el-dropdown",{attrs:{trigger:"click"}},[i("el-button",{attrs:{plain:""}},[e._v("\n        Platform"),i("i",{staticClass:"el-icon-caret-bottom el-icon--right"})]),e._v(" "),i("el-dropdown-menu",{staticClass:"no-border",attrs:{slot:"dropdown"},slot:"dropdown"},[i("el-checkbox-group",{staticStyle:{padding:"5px 15px"},model:{value:e.platforms,callback:function(t){e.platforms=t},expression:"platforms"}},e._l(e.platformsOptions,(function(t){return i("el-checkbox",{key:t.key,attrs:{label:t.key}},[e._v("\n            "+e._s(t.name)+"\n          ")])})),1)],1)],1),e._v(" "),i("el-dropdown",{attrs:{trigger:"click"}},[i("el-button",{attrs:{plain:""}},[e._v("\n        Link"),i("i",{staticClass:"el-icon-caret-bottom el-icon--right"})]),e._v(" "),i("el-dropdown-menu",{staticClass:"no-padding no-border",staticStyle:{width:"300px"},attrs:{slot:"dropdown"},slot:"dropdown"},[i("el-input",{attrs:{placeholder:"Please enter the content"},model:{value:e.url,callback:function(t){e.url=t},expression:"url"}},[i("template",{slot:"prepend"},[e._v("\n            Url\n          ")])],2)],1)],1),e._v(" "),i("div",{staticClass:"time-container"},[i("el-date-picker",{attrs:{type:"datetime",format:"yyyy-MM-dd HH:mm:ss",placeholder:"Release time"},model:{value:e.time,callback:function(t){e.time=t},expression:"time"}})],1),e._v(" "),i("el-button",{staticStyle:{"margin-left":"10px"},attrs:{type:"success"}},[e._v("\n      publish\n    ")])],1),e._v(" "),i("div",{staticClass:"components-container"},[i("aside",[e._v("\n      Sticky header, When the page is scrolled to the preset position will be sticky on the top.\n    ")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("sticky",{attrs:{"sticky-top":200}},[i("el-button",{attrs:{type:"primary"}},[e._v(" placeholder")])],1),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")]),e._v(" "),i("div",[e._v("placeholder")])],1)],1)},d=[],o=function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{style:{height:e.height+"px",zIndex:e.zIndex}},[i("div",{class:e.className,style:{top:e.isSticky?e.stickyTop+"px":"",zIndex:e.zIndex,position:e.position,width:e.width,height:e.height+"px"}},[e._t("default",[i("div",[e._v("sticky")])])],2)])},v=[],a=(i("c5f6"),{name:"Sticky",props:{stickyTop:{type:Number,default:0},zIndex:{type:Number,default:1},className:{type:String,default:""}},data:function(){return{active:!1,position:"",width:void 0,height:void 0,isSticky:!1}},mounted:function(){this.height=this.$el.getBoundingClientRect().height,window.addEventListener("scroll",this.handleScroll),window.addEventListener("resize",this.handleResize)},activated:function(){this.handleScroll()},destroyed:function(){window.removeEventListener("scroll",this.handleScroll),window.removeEventListener("resize",this.handleResize)},methods:{sticky:function(){this.active||(this.position="fixed",this.active=!0,this.width=this.width+"px",this.isSticky=!0)},handleReset:function(){this.active&&this.reset()},reset:function(){this.position="",this.width="auto",this.active=!1,this.isSticky=!1},handleScroll:function(){var e=this.$el.getBoundingClientRect().width;this.width=e||"auto";var t=this.$el.getBoundingClientRect().top;t<this.stickyTop?this.sticky():this.handleReset()},handleResize:function(){this.isSticky&&(this.width=this.$el.getBoundingClientRect().width+"px")}}}),n=a,r=i("2877"),c=Object(r["a"])(n,o,v,!1,null,null,null),s=c.exports,p={name:"StickyDemo",components:{Sticky:s},data:function(){return{time:"",url:"",platforms:["a-platform"],platformsOptions:[{key:"a-platform",name:"platformA"},{key:"b-platform",name:"platformB"},{key:"c-platform",name:"platformC"}],pickerOptions:{disabledDate:function(e){return e.getTime()>Date.now()}}}}},h=p,_=(i("477b"),Object(r["a"])(h,l,d,!1,null,"37d00a3b",null));t["default"]=_.exports}}]);