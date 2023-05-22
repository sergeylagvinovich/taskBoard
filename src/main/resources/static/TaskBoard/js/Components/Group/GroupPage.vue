<template>
      <div class="container scroll-page" id="container_home">
          <GroupSidebar/>
          <b-skeleton-wrapper :loading="loading">
              <template #loading>
                  <div class="row pt-4">
                      <div class="col-12">
                          <div class="text-center" style="height: 50vh">
                              <b-spinner variant="primary" label="Text Centered"></b-spinner>
                          </div>
                      </div>
                  </div>
              </template>
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
          </b-skeleton-wrapper>
      </div>
</template>

<script>
import GroupSidebar from "./GroupSidebar.vue";
import GroupHeader from "./GroupHeader/GroupHeader.vue";
import {mapActions} from "vuex";

export default {
    name: "GroupPage",
    data(){
        return{
            group:null,
            loading:true,
        }
    },
    components: {GroupHeader, GroupSidebar},
    methods:{
        ...mapActions({
            "fetchGroup":"GroupsModule/fetchGroupByUUID"
        }),
        async init(){
            this.loading = true;
            this.group = await this.fetchGroup(this.$route.params.id);
            this.loading = false;
        }
    },
    mounted() {
        this.init();
    }
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