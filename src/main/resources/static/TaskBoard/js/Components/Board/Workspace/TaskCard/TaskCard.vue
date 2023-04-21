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
        <template #modal-header="{ close }">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-1" style="font-size: 20px">
                        <b-icon-card-heading/>
                    </div>
                    <div class="col-10 text-center" v-show="loading">
                    </div>
                    <div class="col-10 text-center" v-show="!loading">
                        <textarea ref="textarea" class="textAreaHeader" @keyup="checkLength" style="min-height: 60px; overflow-wrap: break-word; overflow: hidden;" v-model="text"></textarea>
                    </div>
                    <div class="col-1 float-right">
                        <b-button-close @click="close"/>
                    </div>
                </div>
            </div>
        </template>
        <b-skeleton-wrapper :loading="loading">
            <template #loading>
                <div class="text-center">
                    <b-spinner variant="primary" label="Text Centered"></b-spinner>
                </div>
            </template>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-1" style="font-size: 20px; font-weight: bold">
                        <b-icon-card-text/>
                    </div>
                    <div class="col-10">
                        <div class="row">
                            <div class="col-12 text-left">
                                <label class="font-weight-bold">Описание</label>
                                <span class="btn btn-outline-primary" @click="editNote=!editNote">{{editNote?'Отмена':'Изменить'}}</span>
                                <span class="btn btn-outline-primary">Действия</span>
                            </div>
                            <div class="col-12 text-left">
                                <vue-editor v-model="content" v-show="editNote"></vue-editor>
                                <div class="ql-snow" v-show="!editNote">
                                    <div class="ql-editor" v-html="content">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-1">
                    </div>
                </div>
                <div class="row">
                    <div class="col-1" style="font-size: 20px; font-weight: bold">
                        <b-icon-chat-right-text/>
                    </div>
                    <div class="col-9">
                        <div class="row">
                           тут создание сообщения
                        </div>
                    </div>
                    <div class="col-2">
                    </div>
                </div>
                <div class="row">
                    <div class="col-1" style="font-size: 20px; font-weight: bold">

                    </div>
                    <div class="col-9">
                        <div class="row">
                            а тут отображение сообщений
                        </div>
                    </div>
                    <div class="col-2">
                    </div>
                </div>
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
import { VueEditor } from 'vue2-editor'
export default {
    name: "TaskCard",
    components: {VueEditor},
    data(){
        return{
            text:"asdadasdasdas",
            show:true,
            editNote:false,
            content:"",
            loading: false,
            loadingTime: 0,
            maxLoadingTime: 3,
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
        ...mapActions({
            'showToast':'ToastModule/showToast'
        }),
        checkLength(){
            if(this.text.length>100){
                this.text = this.text.substring(0,100);
                this.showToast({
                    message:'Длинна не должна превышать 100 символов',
                    variant:'info',
                    title:'Карточка'
                });
            }
        },
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
@import "vue2-editor/dist/vue2-editor.css";
@import "quill/dist/quill.bubble.css";
@import "quill/dist/quill.core.css";
@import "quill/dist/quill.snow.css";
textarea.textAreaHeader{
    overflow: hidden;
    background: #0000;
    border-radius: 3px;
    box-shadow: none;
    font-size: 20px;
    font-weight: 600;
    height: 80px;
    line-height: 24px;
    margin: -4px -8px;
    min-height: 24px;
    padding: 4px 8px;
    resize: none;
}

textarea{
    -webkit-appearance: none;
    background-color: #fafbfc;
    border: none;
    border-radius: 3px;
    box-shadow: inset 0 0 0 2px #dfe1e6;
    box-sizing: border-box;
    display: block;
    line-height: 20px;
    margin-bottom: 12px;
    outline: none;
    padding: 8px 12px;
    transition-duration: 85ms;
    transition-property: background-color,border-color,box-shadow;
    transition-timing-function: ease;
    width: 100%;
}
.textAreaHeader:focus{
    border-radius: 10px;
    border: solid #0079bf 1px;
}
</style>