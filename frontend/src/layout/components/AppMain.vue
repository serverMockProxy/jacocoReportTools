<template>
  <section class="app-main">
    <div :style="leftStyle" style="height: 100%; overflow: auto">
      <!--<transition name="fade-transform" mode="out-in">-->
      <keep-alive :include="cachedViews">
        <router-view :key="key" />
      </keep-alive>
      <!--</transition>-->
    </div>
  </section>
</template>

<script>
export default {
  name: 'AppMain',
  components: {
  },
  computed: {
    leftStyle() {
      // todo 先写死
      if (this.$store.state.mobile.show) {
        return 'width: calc(100% - 360px)'
      } else if (this.$store.state.browser.show) {
        return 'width: calc(100% - 110px)'
      } else {
        return ''
      }
    },
    routes() {
      return this.$store.getters.permission_routes
    },
    cachedViews() {
      return this.$store.state.tagsView.cachedViews
    },
    key() {
      return this.$route.fullPath
    }
  },
  created() {
  }
}
</script>

<style lang="scss" scoped>
.app-main {
  height: 100%;
  width: 100%;
  position: relative;
  overflow: hidden;
}

.fixed-header+.app-main {
  padding-top: 50px;
}

.hasTagsView {
  .app-main {
    /* 84 = navbar + tags-view = 50 + 34 */
    min-height: calc(100vh - 84px);
  }

  .fixed-header+.app-main {
    padding-top: 84px;
  }
}
</style>

<style lang="scss">
// fix css style bug in open el-dialog
.el-popup-parent--hidden {
  .fixed-header {
    padding-right: 15px;
  }
}
</style>
