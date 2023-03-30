<template>
    <div class="container min-vh-100">
        <div class="row min-vh-100">
            <div class="col-2">
                <vertical-menu></vertical-menu>
            </div>
            <div class="col-10">
                <div class="row">

                </div>
                <div class="row">
                    <div class="col-12">
                        <router-view></router-view>
                    </div>
                </div>
            </div>
        </div>

    </div>
</template>

<script>
import VerticalMenu from "./VerticalMenu.vue";
export default {
    name: "TaskBoardApp",
    components: {VerticalMenu},
};
</script>

<style>

</style>

