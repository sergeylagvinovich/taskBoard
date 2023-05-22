<template>
  <div class="container-fluid">
      <b-skeleton-wrapper :loading="loading">
          <template #loading>
              <div class="text-center" style="height: 90vh">
                  <b-spinner variant="primary" label="Text Centered"></b-spinner>
              </div>
          </template>
              <div class="row">
                  <div class="col-12">
                      <p style="color: #5e6c84; font-weight: bold"><b-icon-clock-history/> {{lang['recently_viewed']}}</p>
                  </div>
              </div>
              <div class="row">
                  <div class="col-12 mb-3 pr-0">
                      <div class="row">
                          <div class="col-12 pl-0">
                              <div class="row">
                                  <div class="col-3" v-for="(item,itemIndex) in historyBoards" :key="itemIndex">
                                      <board :board="item" :key="itemIndex"></board>
                                  </div>
                              </div>
                          </div>
                      </div>
                  </div>
              </div>
              <div class="row">
                  <div class="col-12">
                      <p style="color: #5e6c84; font-weight: bold; text-transform: uppercase">{{ lang['your_groups'] }}</p>
                  </div>
              </div>
<!--          <div class="row p-0">-->
<!--              <div class="col-12">-->
                  <virtual-list class="container-fluid scroll"
                      :data-component="itemComponent"
                      :data-sources="groups"
                      v-on:tobottom="loadData"
                      :data-key="'id'"
                  >
                      <div slot="footer" class="loader loading-spinner text-center">
                          <b-icon v-if="infiniteLoading" icon="three-dots" class="text-primary" animation="fade" font-scale="4"></b-icon>
                      </div>
                  </virtual-list>
<!--                  <BoardGroup v-for="(item,itemIndex) in boards" :source="item" :key="itemIndex"></BoardGroup>-->
<!--              </div>-->
<!--          </div>-->

      </b-skeleton-wrapper>
  </div>
</template>

<script>
import VirtualList from 'vue-virtual-scroll-list'
import BoardGroup from "./BoardGroup.vue";
import groups from "../Groups/Groups.vue";
import Board from "./Board.vue";
import {mapActions, mapGetters} from "vuex";

export default {
    name: "Boards",
    computed: {
        ...mapGetters({
            'getLang':'languageModule/getLang'
        }),
        lang(){
            return this.getLang;
        },
    },
    components: {Board, BoardGroup},
    data(){
        return{
            itemComponent:BoardGroup,
            loading: false,
            infiniteLoading:false,
            groups:[],
            totalPages:0,
            currentPage:0,

            historyBoards:[
                {
                    name:'Доска 1'
                },
                {
                    name:'Доска 2'
                },
                {
                    name:'Доска 3'
                },
                {
                    name:'Доска 4'
                }
            ],
        }
    },
    created() {
        this.$on('expandValueChange', (id, value) => {
            let targetItem = this.groups.find((item) => item.id === id);
            if (targetItem) {
                targetItem.expand = value
            }
        })
    },
    mounted() {
        this.init();
    },
    methods: {
        async loadData(){
            if(this.currentPage>this.totalPages){
                this.infiniteLoading = false;
                return;
            }
            if(this.infiniteLoading)
                return;
            this.currentPage++;
            this.infiniteLoading = true;
            let dataGroups = await this.fetchGroups({page:this.currentPage, size:10});
            this.groups = this.groups.concat(dataGroups.groups);
            this.totalPages = dataGroups.page.total;
            this.infiniteLoading = false;
        },
        async init(){
            this.loading = true;
            let dataGroups = await this.fetchGroups({page:0, size:10});
            this.groups = dataGroups.groups;
            this.totalPages = dataGroups.page.total;
            this.loading = false;
        },
        ...mapActions({
            'fetchGroups':'GroupsModule/fetchGroups'
        }),
    }
}
</script>

<style scoped>
.scroll{
    height: 67.5vh;
    overflow-y: auto;
    -ms-overflow-style: scrollbar;
    scrollbar-width: thin;
    /*scrollbar-color: #007bff white;*/
    scroll-margin-left: 5px;
    scroll-padding-left: 15px;
}

.scroll::-webkit-scrollbar {
    display: block;
    border-radius: 100px;
    background-color: #666b7a;
    border: 6px solid rgba(0, 0, 0, 0.18);
}

</style>