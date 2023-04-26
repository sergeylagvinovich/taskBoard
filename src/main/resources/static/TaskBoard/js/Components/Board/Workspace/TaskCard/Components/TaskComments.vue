<template>
    <div class="row">
        <div class="col-1" style="font-size: 20px; font-weight: bold">

        </div>
        <div class="col-10">
            <div class="row">
                <TaskComment v-for="(comment,index) in comments" :key="index" :id="index"/>
                <div class="col-12 text-center" v-show="loadingComments">
                    <b-icon icon="three-dots" class="text-primary" animation="fade" font-scale="4"></b-icon>
                </div>
            </div>
        </div>
        <div class="col-1">
        </div>
    </div>
</template>

<script>
import TaskComment from "./TaskComment.vue";

export default {
    name: "TaskComments",
    components: {TaskComment},
    props:{
        loadingComments:{
            type:Boolean,
            default: false,
        },
        comments:{
            type:Array,
            default:[]
        }
    },
}
</script>

<style scoped>


</style>