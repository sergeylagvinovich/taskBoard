<template>
    <div class="row">
        <div class="col-1" style="font-size: 20px; font-weight: bold">
            <b-icon-card-text/>
        </div>
        <div class="col-10">
            <div class="row">
                <div class="col-12 text-left">
                    <label class="font-weight-bold">Описание</label>
                    <span class="btn btn-primary" @click="editNote=!editNote">{{editNote?'Отмена':'Изменить'}}</span>
                    <span class="btn btn-outline-primary">Действия</span>
                    <span class="btn btn-outline-primary">Прикрепить документы</span>
                </div>
                <div class="col-12 text-left">
                    <vue-editor v-model="note" v-show="editNote"></vue-editor>
                    <div class="ql-snow" v-show="!editNote">
                        <div class="ql-editor" v-html="note">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-1">
        </div>
    </div>
</template>

<script>
import { VueEditor } from 'vue2-editor'
export default {
    name: "TaskNote",
    components: {VueEditor},
    props:{
        note:{
            type:String,
            default:"",
        }
    },
    data(){
        return{
            editNote:false,
        }
    }
}
</script>

<style scoped>
@import "vue2-editor/dist/vue2-editor.css";
@import "quill/dist/quill.bubble.css";
@import "quill/dist/quill.core.css";
@import "quill/dist/quill.snow.css";

.ql-editor{
    min-height: 0px;
}
</style>