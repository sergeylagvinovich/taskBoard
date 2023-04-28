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
                          <div class="col-3 pr-0" v-for="(item,itemIndex) in historyBoards" :key="itemIndex">
                              <board :board="item" :key="itemIndex"></board>
                          </div>
                      </div>
                  </div>
              </div>
              <div class="row">
                  <div class="col-12">
                      <p style="color: #5e6c84; font-weight: bold; text-transform: uppercase">{{ lang['your_groups'] }}</p>
                  </div>
              </div>
              <BoardGroup v-for="(item,itemIndex) in boards" :group="item" :key="itemIndex"></BoardGroup>
      </b-skeleton-wrapper>
  </div>
</template>

<script>
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
        groups() {
            return groups
        }
    },
    components: {Board, BoardGroup},
    data(){
        return{
            loading: false,
            boards:[],
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
    mounted() {
        this.init();
    },
    methods: {
        async init(){
            this.loading = true;
            this.boards = await this.fetchBoards();
            this.loading = false;
        },
        ...mapActions({
            'fetchBoards':'GroupsModule/fetchGroups'
        }),
    }
}
</script>

<style scoped>

</style>