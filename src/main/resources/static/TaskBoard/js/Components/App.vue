<template>
    <span>
        <navbar></navbar>
        <div class="container min-vh-100">
            <div class="row">
                <div class="col-12">
                    <TaskBoardApp></TaskBoardApp>
                </div>
            </div>
        </div>
    </span>
</template>

<script>
import Navbar from "./Navbar.vue";
import TaskBoardApp from "./TaskBoardApp.vue";

export default {
    name: "App",
    components: {TaskBoardApp, Navbar}
}
</script>

<style scoped>

</style>