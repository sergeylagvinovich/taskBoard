<template>
    <li
            class="list-group-item text-justify item"
            @click="goTo({name:'TaskCard',params:{taskId:task.id}})"
    >
        <i
                :class="task.fixed ? 'fa fa-anchor' : 'glyphicon glyphicon-pushpin'"
                @click="task.fixed = !task.fixed"
                aria-hidden="true"
        ></i>
        {{ task.name }}
    </li>
</template>

<script>
import {mapMutations} from "vuex";

export default {
    name: "Task",
    props:{
        task:{
            type:Object
        }
    },
    methods:{
        ...mapMutations({
            'goTo':'routerModule/goToWithParams'
        }),
    }
}
</script>

<style scoped>
.list-group-item:hover {
    transition: opacity 0.5s;
    opacity: 0.7;
}


.list-group-item {
    cursor: pointer;
    -webkit-transition: opacity 0.5s;
    margin-bottom: 10px;
    border-radius: 15px;
}

.list-group-item i {
    cursor: pointer;
}
</style>