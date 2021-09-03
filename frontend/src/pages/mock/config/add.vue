<template>
  <div class="app-container">
    <save-config :is-add="true" />
  </div>
</template>

<script>
import SaveConfig from './components/SaveConfig'
export default {
  name: 'AddConfig',
  components: {
    SaveConfig
  }
}
</script>

<style scoped>

</style>
