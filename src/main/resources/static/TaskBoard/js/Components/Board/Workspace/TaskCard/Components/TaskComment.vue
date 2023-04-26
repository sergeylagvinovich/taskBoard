<template>
    <div class="col-12" v-if="id!=null">
        <div class="comment mt-4 text-justify float-left w-100">
            <img src="https://i.imgur.com/yTFUilP.jpg" alt="" class="rounded-circle" width="40" height="40">
            <h4>Jhon Doe</h4>
            <span>- 20 October, 2018</span>
            <br>
            <p v-show="!isEdit" style="white-space: pre-line">{{comment}}</p>
            <div :class="['row']" v-show="isEdit">
                <div class="col">
                    <textarea
                        ref="editComment"
                        autofocus
                        class="textAreaComment"
                        v-model="comment"
                        placeholder="Напишите комментарий"
                        @input="autoResize"
                    ></textarea>
                </div>
            </div>
            <div class="row">
                <div class="col">
<!--                    <span v-if="!myComment" class="text-primary pointer">Ответить <b-icon-arrow-return-left/></span>-->
                    <button class="btn btn-outline-primary" v-if="myComment && !isEdit" @click="startEdit">Изменить</button>
                    <button class="btn btn-primary" v-else @click="isEdit=false">Сохранить</button>

                    <button class="btn btn-outline-danger" v-if="myComment && !isEdit">Удалить</button>
                    <button class="btn btn-outline-primary" v-else @click="isEdit=false">Отмена</button>

                    <button class="btn btn-outline-primary" v-if="!myComment">Ответить</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: "TaskComment",
    props:{
        id:{
            type:Number,
            default:null
        },
        myComment:{
            type:Boolean,
            default:true
        }
    },
    data(){
        return{
            comment:'Lorem ipsum dolor sit, amet consectetur adipisicing elit. Accusamus numquam assumenda hic aliquam vero sequi velit molestias doloremque molestiae dicta?',
            isEdit:false,
        }
    },
    methods:{
        autoResize(event){
            event.target.style.height = "auto";
            event.target.style.height = `${event.target.scrollHeight}px`;
        },
        startEdit(){
            this.isEdit=true;
            this.$nextTick(() => {
                this.$refs.editComment.focus();
            })
        }
    }
}
</script>

<style scoped>
textarea.textAreaComment {
    height: 80px;
    border: 1px solid #ccc;
    border-radius: 10px;
    padding: 15px;
    resize: none;
    font-size: 1rem;
    text-align: left;
    line-height: 1.5;
    font-weight: 400;
    scrollbar-width: none;
}

.comment{
    float: left;
    padding-left: 40px;
    padding-right: 30px;
    padding-top: 10px;

}
.comment h4,.comment span,.darker h4,.darker span{
    display: inline;
}

.comment p,.comment span,.darker p,.darker span{
    color: black;
}
.comment p{
    border: 1px solid #ccc;
    padding: 15px;
    border-radius: 10px;
}

h4{
    font-weight: bold;
}
</style>