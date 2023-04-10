<template>
      <div class="container-fluid scroll-page">
          <BoardSidebar/>
          <div class="row pt-4">
              <div class="col-12">
                  <div class="row">
                      <div class="col-12">

                      </div>
                  </div>
                  <div class="row">
                      <div class="col-12">
                          <transition name="fade" mode="out-in">
                              <router-view/>
                          </transition>
                      </div>
                  </div>
              </div>
          </div>
      </div>
</template>

<script>
import BoardSidebar from "./BoardSidebar.vue";

export default {
    name: "BoardPage",
    components: {BoardSidebar},
}
</script>

<style scoped>
.scroll{
    height: 94vh;
    min-height: 94vh;
}
.scroll-page{
    overflow: auto;
    height: 94vh;
    -ms-overflow-style: none;
    scrollbar-width: none;
}
.scroll-page::-webkit-scrollbar {
    display: none;
}
</style>