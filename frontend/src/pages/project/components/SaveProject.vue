<template>
  <el-form :data="project" label-width="100px">
    <el-form-item label="名称" :rules="[{required: true}]">
      <el-input v-model.trim="project.name" clearable style="width: 300px" />
    </el-form-item>
    <el-form-item label="默认请求host" :rules="[{required: false}]">
      <el-input v-model.trim="project.defaultForwardHost" clearable style="width: 300px" />
    </el-form-item>
    <el-form-item label="描述">
      <el-input v-model.trim="project.description" type="textarea" style="width: 300px" />
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="saveProject">保 存</el-button>
    </el-form-item>
  </el-form>
</template>
<script>
import { addProject, updateProject, getProjectList } from '@/api/project'
import { platforms } from '@/utils/common'
import 'codemirror/theme/base16-dark.css'
import 'codemirror/mode/javascript/javascript.js'
export default {
  props: {
    isAdd: Boolean
  },
  data() {
    return {
      project: {
        id: null,
        name: '',
        defaultForwardHost:'',
        description: '',
      },
      cmOptions: {
        mode: 'application/json',
        theme: 'base16-dark',
        tabSize: 2,
        lineNumbers: true
      }
    }
  },
  created() {
    if (!this.isAdd) {
      getProjectList({ id: this.$route.params.projectId }).then(response => {
        this.project = response.data[0]
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
    saveProject() {
      if (this.isAdd) {
        addProject(this.project).then(response => {
          this.saveProjectSuccess(response.msg)
        })
      } else {
        updateProject(this.project).then(response => {
          this.saveProjectSuccess(response.msg)
        })
      }
    }
  }
}
</script>
