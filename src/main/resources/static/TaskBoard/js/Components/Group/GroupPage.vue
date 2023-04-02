<template>
      <div class="container scroll-page" id="container_home">
          <GroupSidebar/>
          <div class="row pt-4">
              <div class="col-12">
                  <div class="row">
                      <div class="col-12">
                            <GroupHeader/>
                      </div>
                  </div>
                  <div class="row">
                      <div class="col-12 scroll">
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
import GroupSidebar from "./GroupSidebar.vue";
import GroupHeader from "./GroupHeader/GroupHeader.vue";

export default {
    name: "GroupPage",
    components: {GroupHeader, GroupSidebar},
}
</script>

<style scoped>
.scroll{
    height: 60vh;
}
.scroll-page{
    overflow: auto;
    height: 90vh;
    -ms-overflow-style: none;
    scrollbar-width: none;
}
.scroll-page::-webkit-scrollbar {
    display: none;
}
</style>