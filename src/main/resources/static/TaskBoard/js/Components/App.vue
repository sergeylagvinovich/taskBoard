<template>
    <span>
        <navbar></navbar>
        <div class="container min-vh-100">
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
import TaskBoardApp from "./Home.vue";

export default {
    name: "App",
    components: {TaskBoardApp, Navbar}
}
</script>

<style scoped>
.fade-enter-active,
.fade-leave-active {
    transition: opacity 0.5s ease;
}
.fade-enter-from,
.fade-leave-to {
    opacity: 0;
}
</style>