<template>
<!-- TODO:: Изменить id на тот который будет приходить для доски-->
    <div class="boardCard pointer" @click="goTo({name:'BoardWorkspace',params:{boardId: 1}})">
        <label class="col-form-label">{{ board.name }}</label>
    </div>
</template>

<script>
import {mapActions, mapMutations} from "vuex";

export default {
    name: "Board",
    props:{
        board:{
            type:Object,
        }
    },
    methods:{
        ...mapMutations({
            'goTo':'routerModule/goToWithParams',
        })
    }
}
</script>

<style scoped>
.boardCard{
    text-align: center;
    margin-bottom: 10px;
    padding: 10px;
    border: 1px solid rgba(0,0,0,.125);
    border-radius: 10px;
    height: 125px;
    max-width: 225px;
    max-height: 125px;
    width: 100%;
    background-color: white;
}
.boardCard:hover{
    transition:background-color 0.5s;
    background-color: #e9ecef;
}
.boardCard:not(:hover){
    transition:background-color 0.5s;
}
</style>