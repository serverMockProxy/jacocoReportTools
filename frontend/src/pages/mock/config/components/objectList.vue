<template>
  <div>
    <div v-for="(item, index) in list" class="list-item">
<!--      <el-button v-if="item.type ==='object' || item.type ==='array'"></el-button>-->
      <div style="display: flex;text-align: right" v-show="item.key=== '#root' ? true:isShow">
        <div class="key-input" style="width: 50%">
          <div>
            <i v-if="(item.type ==='object' || item.type ==='array')&&(item.key !== '#root')" @click="fold(item,item.show)" v-bind:class="item.show == false? foldcon : unfoldcon"></i>
            <el-input size="mini" v-model="item.key" :style="indent" :disabled="item.key === '#root' || item.key === '#items'" />
          </div>
        </div>
        <div style="width: 95px;margin-left: 5px;margin-top: 5px">
          <el-select slot="prepend" v-model="item.type" @change="changeSelect(item)">
            <el-option label="object" value="object" />
            <el-option label="array" value="array" />
            <el-option label="string" value="string" />
            <el-option label="int" value="int" />
            <el-option label="boolean" value="boolean" />
          </el-select>
        </div>
        <div style="width: 20%;margin-left: 5px;margin-top: 5px">
          <el-input v-model="item.value" placeholder="value" :disabled="item.type === 'object' || item.type ==='array'" />
        </div>
        <div style="width: 20%;margin-left: 5px;margin-top: 5px">
          <el-input v-model="item.description" placeholder="描述" />
        </div>
        <div style="width: 10%;display: flex;margin-left: 5px;margin-top: 12px">
          <div v-if="item.key !== '#root'" style="margin-right: 5px">
            <el-button class="el-icon-delete-solid" @click="del(item.key,item.num)" />
          </div>
          <div>
            <el-button v-if="item.type ==='object' || item.type ==='array'" class="el-icon-plus" @click="add(item,index)" />
          </div>
          <div>
            <el-button v-if="(item.type ==='object')&&(item.key !== '#root')" @click="copy(item)" class="el-icon-document-copy" />
          </div>
        </div>
      </div>
      <div v-if="item.children" class="children-item">
        <object-list :list="item.children" :depth="depth+1" :isShow="item.show == null ? true:item.show"/>
        <!-- props: 父组件向子组件传递参数，这里父组件将item.childern 传递给了子组件的list变量 -->
      </div>
    </div>
  </div>
</template>

<script>
var num = 1
export default {
  name: 'ObjectList',
  props: ['list', 'depth','isShow'],
  computed: {
    indent() {
      return { width: 100 - (this.depth * 6) + '%' }
    }
  },
  data() {
    return {
      unfoldcon:"el-icon-caret-bottom",
      foldcon:"el-icon-caret-right"
    }

  },  
  methods: {
    changeSelect(item) {
      if (item.children != null) {
        this.$delete(item, 'children')
      }
      if (item.type === 'array') {
        // 没有children的添加children属性，但是要保证新加进来的数据也可以被劫持--->this.$set()
        // this.$set(要改变的对象，要改变对象里的属性，属性的值)三个参数
        !item.children && this.$set(item, 'children', [])
        item.children && item.children.push({ num: Math.floor(Math.random() * 100000) + num, key: '#items', value: '', type: 'object', description: '', children: [] })
      }
    },
    del(key, id) {
      // 删除--->根据id找相应的数组下标
      for (const i in this.list) {
        if (this.list.length > 1 || key != '#items') {
          if (this.list[i].num == id) {
            this.list.splice(i, 1)
          }
        }
      }
    },
    add(item, index) {
      // 没有children的添加children属性，但是要保证新加进来的数据也可以被劫持--->this.$set()
      // this.$set(要改变的对象，要改变对象里的属性，属性的值)三个参数
      if (item.type === 'array') {
        !item.children && this.$set(item, 'children', [])
        item.children && item.children.push({ num: Math.floor(Math.random() * 100000) + num, key: '#items', value: '', type: 'object', description: '', children: [] })
      } else {
        !item.children && this.$set(item, 'children', [])
        item.children && item.children.push({ num: Math.floor(Math.random() * 100000) + num, key: 'test' + num++, value: '', type: 'string', description: '', children: [] })
      }
    },

    fold(item,s) {
      // 需要用一个globalS变量接收最上层父item的show值，这个globalS在递归时才不会发生变化
      var globalS = s == null? true:s
      if(item.children){
        for(var i of item.children){
          // 从最上层父item开始，递归将所有childrend的状态，改为globalS指代的show状态
          this.fold(i,globalS)
        }
      }
      this.$set(item, 'show',!globalS)
  
    },
    copy(item) {
      //先将item对象深拷贝到另一个变量上，再去push进父list数组
      var itemCopy=JSON.parse(JSON.stringify(item))
      //复制的item需要有新的id，重新给num复制
      itemCopy.num=Math.floor(Math.random() * 100000) + num
      this.list.push(itemCopy)
    }
  }
}
</script>

<style lang="scss" scoped>
.key-input{
  width: 30%;
  text-align: right;
  margin-top: 5px
}

.el-icon-plus,.el-icon-document-copy,.el-icon-delete-solid{
  padding: 5px;
}

</style>