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
                    <div class="col-2" style="font-size: 20px">
                        <b-icon-card-heading/>
                    </div>
                    <div class="col-8 text-center">
                        <textarea ref="textarea" class="textAreaHeader" @keyup="resize" style="min-height: 60px; overflow-wrap: break-word; overflow: hidden;" v-model="text"></textarea>
<!--                        <b-textarea v-model="text" class="textAreaHeader"/>-->
                    </div>
                    <div class="col-2">
                        <b-button-close @click="close"/>
                    </div>
                </div>
            </div>
        </template>
        <template #modal-footer="{ close }">
            <b-button
                variant="primary"
                size="sm"
                class="float-right"
                @click="close"
            >
                Close
            </b-button>
        </template>
    </b-modal>
</template>

<script>
import {mapActions, mapMutations} from "vuex";

export default {
    name: "TaskCard",
    data(){
        return{
            text:"asdadasdasdas",
            show:true,
        }
    },
    methods:{
        ...mapMutations({
            'goTo':'routerModule/goToWithParams'
        }),
        resize() {
            const { textarea } = this.$refs;
            textarea.style.height = textarea.scrollHeight - 4 + 'px';
        }
    }
}
</script>

<style scoped>
textarea.textAreaHeader{
    overflow: hidden;
    background: #0000;
    border-radius: 3px;
    box-shadow: none;
    font-size: 20px;
    font-weight: 600;
    height: 32px;
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