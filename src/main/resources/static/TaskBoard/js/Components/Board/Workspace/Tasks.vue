<template>
    <div class="col-2 align-self-start mr-2 ml-2" style="display: inline-block; opacity: 0.8">
        <div class="row">
            <div class="col-12">
                <h5>{{ groupName }}</h5>
            </div>
            <div class="col-12">
                <h6>Карточек: {{ tasks.length }}</h6>
            </div>
        </div>
        <div class="row" style="margin-right: -10px">
            <div class="col-12 tasksScroll">
                <draggable
                        class="list-group"
                        tag="ul"
                        :list="tasks"
                        draggable=".item"
                        :group="{ name: 'tasks'}"
                        v-bind="dragOptions"
                        @start="drag = true"
                        @end="drag = false"
                >
                        <li
                                class="list-group-item text-justify item"
                                v-for="(element,index) in tasks"
                                :key="element.id"
                        >
                            <i
                                    :class="element.fixed ? 'fa fa-anchor' : 'glyphicon glyphicon-pushpin'"
                                    @click="element.fixed = !element.fixed"
                                    aria-hidden="true"
                            ></i>
                            {{ element.name }}
                        </li>
                </draggable>pm
            </div>
        </div>
        <div class="row mt-3" style="min-height: 40px">
            <div class="col-12">
                <div class="row align-items-center">
                    <div class="col-9 pr-0 pl-0 pointer btn btn-outline-primary" style="margin-left: 15px; border-radius: 5px">
                        <b-icon-plus-square/> Добавить карточку
                    </div>
                    <div class="col-2 p-0 text-center pointer btn btn-outline-primary" style="font-size: 24px;">
                        <b-icon-card-list class="pointer" />
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import draggable from "vuedraggable";
import header from "../../Group/GroupHeader/Header.vue";

export default {
    name: "Tasks",
    components: {draggable},
    props: {
        tasks: {
            type: Array,
        },
        groupName: {
            type: String,
        }
    },
    data() {
        return {
            drag: false
        }
    },
    computed: {
        header() {
            return header
        },
        dragOptions() {
            return {
                animation: 100,
                group: "tasks",
                disabled: false,
                ghostClass: "ghost"
            };
        }
    }
}
</script>

<style scoped>
.pointEvent:hover {
    transition: background-color 0.5s;
    background-color: #6c757d;
}

.pointEvent{
    -webkit-transition: background-color 0.5s;
}

.flip-list-move {
    transition: transform 0.5s;
}

.no-move {
    transition: transform 0s;
}

.ghost {
    opacity: 0.5;
    background: #c8ebfb;
}

.list-group {

}
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


.tasksScroll{
    overflow: auto;
    height: auto;
    max-height: 75vh;
}

.tasksScroll::-webkit-scrollbar {
    width: 20px;
}

.tasksScroll::-webkit-scrollbar-track {
    background-color: #666b7a;
    opacity: 0.8;
    border-radius: 100px;
}

.tasksScroll::-webkit-scrollbar-thumb {
    border-radius: 100px;
    border: 6px solid rgba(0, 0, 0, 0.18);
    border-left: 0;
    border-right: 0;
    background-color: #8070d4;
}
</style>