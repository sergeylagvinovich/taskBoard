<template>
      <div class="container" id="container_home">
          <GroupSidebar/>
          <div class="row pt-4">
              <div class="col-12">
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

export default {
    name: "GroupPage",
    components: {GroupSidebar},
}
</script>

<style scoped>

</style>