<template>
    <div class="container-fluid h-100 container_board">
        <b-skeleton-wrapper :loading="loading">
            <template #loading>
                <div class="text-center" style="height: 90vh">
                    <b-spinner variant="primary" label="Text Centered"></b-spinner>
                </div>
            </template>
            <div class="row h-100">
                <div class="col-12 pr-0">
                        <draggable
                            :list="list"
                            class="row overflowX"
                            tag="div"
                            @start="drag = true"
                            @end="drag = false"
                            @change="log"
                        >
<!--                            <transition-group type="transition" :name="!drag ? 'flip-list' : null" tag="div" class="row">-->
                                <Tasks v-for="item in list" :key="item.id" class="list-group" :group-name="item.name" :tasks="item.tasks"></Tasks>
<!--                            </transition-group>-->
                        </draggable>
                </div>
            </div>
        </b-skeleton-wrapper>
    </div>
</template>

<script>
import draggable from "vuedraggable";
import Tasks from "./Tasks.vue";

const message = [
    "vue.js 2.0",
    "based",
    "on",
    "Sortablejs"
];


export default {
    name: "Workspace",
    display: "Transitions",
    components: {
        Tasks,
        draggable
    },
    computed: {
        dragOptions() {
            return {
                animation: 100,
                group: "description",
                disabled: false,
                ghostClass: "ghost"
            };
        }
    },
    data() {
        return {
            loading: false,
            loadingTime: 0,
            maxLoadingTime: 3,
            list: [
                {
                  id:1,
                  name:"Группа 1",
                  tasks:[
                      {
                          id:1,
                          name:"asdddddddssssssssssssssssssssssssssssssssssssssssssssssssssssasdddddddssssssssssssssssssssssssssssssssssssssssssssssssssssasdddddddssssssssssssssssssssssssssssssssssssssssssssssssssssasdddddddssssssssssssssssssssssssssssssssssssssssssssssssssssasdddddddssssssssssssssssssssssssssssssssssssssssssssssssssssasdddddddssssssssssssssssssssssssssssssssssssssssssssssssssssasdddddddssssssssssssssssssssssssssssssssssssssssssssssssssssasdddddddssssssssssssssssssssssssssssssssssssssssssssssssssssasdddddddssssssssssssssssssssssssssssssssssssssssssssssssssssasdddddddssssssssssssssssssssssssssssssssssssssssssssssssssssasdddddddssssssssssssssssssssssssssssssssssssssssssssssssssssasdddddddssssssssssssssssssssssssssssssssssssssssssssssssssssasdddddddssssssssssssssssssssssssssssssssssssssssssssssssssssasdddddddssssssssssssssssssssssssssssssssssssssssssssssssssssasdddddddssssssssssssssssssssssssssssssssssssssssssssssssssssasdddddddssssssssssssssssssssssssssssssssssssssssssssssssssssasdddddddssssssssssssssssssssssssssssssssssssssssssssssssssssasdddddddssssssssssssssssssssssssssssssssssssssssssssssssssssasdddddddssssssssssssssssssssssssssssssssssssssssssssssssssssasdddddddssssssssssssssssssssssssssssssssssssssssssssssssssssasdddddddssssssssssssssssssssssssssssssssssssssssssssssssssssasdddddddssssssssssssssssssssssssssssssssssssssssssssssssssssasdddddddssssssssssssssssssssssssssssssssssssssssssssssssssssasdddddddssssssssssssssssssssssssssssssssssssssssssssssssssssasdddddddssssssssssssssssssssssssssssssssssssssssssssssssssss",
                      },
                      {
                          id:2,
                          name:"Страница с участниками группы sadasdasdsadsdfsdfsdfdsfs asdw ssss",
                      },
                      {
                          id:3,
                          name:"component",
                      },
                      {
                          id:4,
                          name:"for",
                      },
                  ]
                },
                {
                    id:2,
                    name:"Группа 2",
                    tasks:[
                        {
                            id:5,
                            name:"vue.js 2.0",
                        },
                        {
                            id:6,
                            name:"based",
                        },
                        {
                            id:7,
                            name:"on",
                        },
                        {
                            id:8,
                            name:"Sortablejs",
                        },
                    ]
                },
                {
                    id:3,
                    name:"Группа 3",
                    tasks:[
                        {
                            id:9,
                            name:"vue.js 2.0",
                        },
                        {
                            id:10,
                            name:"based",
                        },
                        {
                            id:11,
                            name:"on",
                        },
                        {
                            id:12,
                            name:"Sortablejs",
                        },
                    ]
                },
                {
                    id:4,
                    name:"Группа 3",
                    tasks:[
                        {
                            id:13,
                            name:"vue.js 2.0",
                        },
                        {
                            id:14,
                            name:"based",
                        },
                        {
                            id:15,
                            name:"on",
                        },
                        {
                            id:16,
                            name:"Sortablejs",
                        },
                    ]
                },
                {
                    id:5,
                    name:"Группа 3",
                    tasks:[
                        {
                            id:17,
                            name:"vue.js 2.0",
                        },
                        {
                            id:18,
                            name:"based",
                        },
                        {
                            id:19,
                            name:"on",
                        },
                        {
                            id:20,
                            name:"Sortablejs",
                        },
                    ]
                },
                {
                    id:6,
                    name:"Группа 3",
                    tasks:[
                        {
                            id:21,
                            name:"vue.js 2.0",
                        },
                        {
                            id:22,
                            name:"based",
                        },
                        {
                            id:23,
                            name:"on",
                        },
                        {
                            id:24,
                            name:"Sortablejs",
                        },
                    ]
                },
            ],

            drag: false
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
        },
        log(evt){
            console.log(evt);
        }
    }
}
</script>

<style scoped>
.flip-list-move {
    transition: transform 0.5s;
}

.no-move {
    transition: transform 0s;
}

.ghost {
    opacity: 0.5;
    background: #c8ebfb;
}

.list-group {
    min-height: 50px;
    border: 1px solid rgba(0,0,0,.125);
    padding: 10px;
    background-color: #e9ecef;
    text-align: justify;
    word-wrap: anywhere;
}

.list-group-item i {
    cursor: pointer;
}

.overflowX{
    overflow-x: auto;
    flex-wrap: nowrap;
    min-height: 90vh;
    /*scrollbar-width: none;*/
}
.container_board{
    padding: 0;
}

.overflowX::-webkit-scrollbar {
    width: 20px;
}

.overflowX::-webkit-scrollbar-track {
    background-color: #666b7a;
    opacity: 0.8;
    border-radius: 100px;
}

.overflowX::-webkit-scrollbar-thumb {
    border-radius: 100px;
    border: 6px solid rgba(0, 0, 0, 0.18);
    border-left: 0;
    border-right: 0;
    background-color: #8070d4;
}
</style>