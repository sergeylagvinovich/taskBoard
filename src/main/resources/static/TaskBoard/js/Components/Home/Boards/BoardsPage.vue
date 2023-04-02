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
import {mapGetters} from "vuex";

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
            loadingTime: 0,
            maxLoadingTime: 3,

            expand:false,
            boards:[
                {
                    name:"Тестовая группа 1",
                    boards:[
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
                    ]
                },
            ],
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
            testData:[
                {
                    id:1,
                    name:"Тестовая группа 1",
                    boards:[
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
                    ]
                },
                {
                    id:2,
                    name:"Тестовая группа 2",
                    boards:[
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
                        },
                        {
                            name:'Доска 5'
                        },
                        {
                            name:'Доска 6'
                        },
                    ]
                },
                {
                    id:3,
                    name:"Тестовая группа 3",
                    boards:[
                        {
                            name:'Доска 1'
                        },
                        {
                            name:'Доска 2'
                        },
                    ]
                }

            ]
        }
    },
    watch: {
        loading(newValue, oldValue) {
            if (newValue !== oldValue) {
                this.clearLoadingTimeInterval()

                if (newValue) {
                    this.$_loadingTimeInterval = setInterval(() => {
                        this.loadingTime++
                    }, 1000)
                }
            }
        },
        loadingTime(newValue, oldValue) {
            if (newValue !== oldValue) {
                if (newValue === this.maxLoadingTime) {
                    this.boards = this.testData;
                    this.loading = false
                }
            }
        }
    },
    created() {
        this.$_loadingTimeInterval = null
    },
    mounted() {
        this.startLoading()
    },
    methods: {
        clearLoadingTimeInterval() {
            clearInterval(this.$_loadingTimeInterval)
            this.$_loadingTimeInterval = null
        },
        startLoading() {
            this.loading = true
            this.loadingTime = 0
        }
    }
}
</script>

<style scoped>

</style>