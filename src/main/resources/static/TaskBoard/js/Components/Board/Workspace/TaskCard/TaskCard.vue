<template>

    <b-modal
        id="modal-TaskCard"
        size="xl"
        scrollable
        title="Name task"
        no-close-on-esc
        no-close-on-backdrop
        no-enforce-focus
        v-model="show"
        @close="goTo({name:'BoardWorkspace',params:{boardId:2}})"
    >
        <!--    TODO:: изменить пропс title, на тот который придет в карточке-->
        <template #modal-header="{ close }" v-show="!loading">
            <task-header :title="text" @close="close"/>
        </template>
        <b-skeleton-wrapper :loading="loading">
            <template #loading>
                <div class="text-center">
                    <b-spinner variant="primary" label="Text Centered"></b-spinner>
                </div>
            </template>
            <div class="container-fluid">
                <!--    TODO:: изменить пропс note, на тот который придет в карточке-->
                <task-note :note="content"/>
                <div class="row">
                    <div class="col-1" style="font-size: 20px; font-weight: bold">
                        <b-icon-chat-right-text/>
                    </div>
                    <div class="col-10">
                        <div class="row">

                        </div>
                    </div>
                    <div class="col-1">
                    </div>
                </div>
                <task-new-comment/>
                <task-comments/>
            </div>
        </b-skeleton-wrapper>
        <template #modal-footer="{ close }">
            <span class="btn btn-outline-primary float-right" @click="close">
                Закрыть
            </span>
        </template>
    </b-modal>
</template>

<script>
import {mapActions, mapMutations} from "vuex";
import TaskHeader from "./Components/TaskHeader.vue";
import TaskNote from "./Components/TaskNote.vue";
import TaskNewComment from "./Components/TaskNewComment.vue";
import TaskComments from "./Components/TaskComments.vue";
export default {
    name: "TaskCard",
    components: {TaskComments, TaskNewComment, TaskNote, TaskHeader},
    data(){
        return{
            comment:'',
            showButton:false,
            showCommentEditor:false,
            text:"asdadasdasdas",
            show:true,
            editNote:false,
            content:"",
            loading: false,
            loadingTime: 0,
            maxLoadingTime: 1,
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
        ...mapMutations({
            'goTo':'routerModule/goToWithParams'
        }),
        clearLoadingTimeInterval() {
            clearInterval(this.$_loadingTimeInterval)
            this.$_loadingTimeInterval = null
        },
        startLoading() {
            this.loading = true
            this.loadingTime = 0
        },
    }
}
</script>

<style scoped>


</style>