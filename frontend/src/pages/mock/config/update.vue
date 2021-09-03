<template>
  <div class="app-container">
    <save-config :is-add="false" />
  </div>
</template>

<script>
import SaveConfig from './components/SaveConfig'
export default {
  name: 'UpdateConfig',
  components: {
    SaveConfig
  }
}
</script>

<style scoped>

</style>
