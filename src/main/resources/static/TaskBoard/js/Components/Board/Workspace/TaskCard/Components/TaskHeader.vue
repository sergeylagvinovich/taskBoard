<template>
    <div class="container-fluid">
        <div class="row">
            <div class="col-1" style="font-size: 20px">
                <b-icon-card-heading/>
            </div>
            <div class="col-10 text-center">
                <textarea ref="textarea" class="textAreaHeader" @keyup="checkLength" style="min-height: 60px; overflow-wrap: break-word; overflow: hidden;" v-model="title"></textarea>
            </div>
            <div class="col-1 float-right">
                <b-button-close @click="$emit('close')"/>
            </div>
        </div>
    </div>
</template>

<script>
import {mapActions} from "vuex";

export default {
    name: "TaskHeader",
    props:{
        title:{
            type:String,
            default:""
        }
    },
    data(){
        return{

        }
    },
    methods:{
        ...mapActions({
            'showToast':'ToastModule/showToast'
        }),
        checkLength(){
            if(this.title.length>100){
                this.title = this.title.substring(0,100);
                this.showToast({
                    message:'Длинна не должна превышать 100 символов',
                    variant:'info',
                    title:'Карточка'
                });
            }
        },
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
    height: 80px;
    line-height: 24px;
    margin: -4px -8px;
    min-height: 24px;
    padding: 4px 8px;
    resize: none;
}
.textAreaHeader:focus{
    border-radius: 10px;
    border: solid #0079bf 1px;
}
</style>