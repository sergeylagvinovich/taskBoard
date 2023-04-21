<template>
    <div class="row">
        <div class="col-1 my-auto text-center" style="font-size: 20px; font-weight: bold">

        </div>
        <div class="col-10">
            <div class="row">
                <div class="col-12">
                    <div class="comment-form">
                <textarea
                        class="textAreaComment"
                        v-model="comment"
                        placeholder="Напишите комментарий"
                        @input="autoResize"
                ></textarea>
                        <div>
                            <button :class="['btn btn-primary', comment.length>0?'':'disabled']" @click="">Сохранить</button>
                            <button class="btn btn-outline-primary" @click="">Прикрепить ссылку</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-2">
        </div>
    </div>
</template>

<script>
export default {
    name: "TaskNewComment",
    data(){
        return{
            comment:'',
        }
    },
    methods:{
        autoResize(event){
            event.target.style.height = "auto";
            event.target.style.height = `${event.target.scrollHeight}px`;
        },
    }
}
</script>

<style scoped>
.comment-form {
    display: flex;
    flex-direction: column;
    margin-bottom: 20px;
}

textarea.textAreaComment {
    height: 80px;
    border: 1px solid #ccc;
    border-radius: 5px;
    padding: 10px;
    font-size: 16px;
    resize: none;
    scrollbar-width: none;
}
</style>