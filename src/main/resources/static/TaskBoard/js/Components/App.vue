<template>
    <span>
        <navbar></navbar>
        <div class="container">
            <div class="row">
                <div class="col-12">
                     <transition name="fade" mode="out-in">
                        <router-view/>
                     </transition>
                </div>
            </div>
        </div>
    </span>
</template>

<script>
import Navbar from "./Navbar.vue";
import TaskBoardApp from "./Home/Home.vue";

export default {
    name: "App",
    components: {TaskBoardApp, Navbar}
}
</script>

<style scoped>
</style>