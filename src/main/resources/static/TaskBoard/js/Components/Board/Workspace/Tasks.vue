<template>
    <div class="col-3">
        <div class="row">
            <div class="col-12">
                <h3>{{ groupName }}</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <draggable
                        class="list-group"
                        tag="ul"
                        :list="tasks"
                        v-bind="dragOptions"
                        @start="drag = true"
                        @end="drag = false"
                >
                    <transition-group type="transition" :name="!drag ? 'flip-list' : null">
                        <li
                                class="list-group-item"
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
                    </transition-group>
                    <!--            <template :slot="header">-->
                    <!--                <div-->
                    <!--                        slot="header"-->
                    <!--                        class="btn-group list-group-item"-->
                    <!--                        role="group"-->
                    <!--                        aria-label="Basic example"-->
                    <!--                >-->
                    <!--                    <h1>{{groupName}}</h1>-->
                    <!--                </div>-->
                    <!--            </template>-->
                </draggable>
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
                group: "description",
                disabled: false,
                ghostClass: "ghost"
            };
        }
    }
}
</script>

<style scoped>
.columnTasks {

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
    padding: 10px;
}

.list-group-item {
    cursor: move;
}

.list-group-item i {
    cursor: pointer;
}
</style>