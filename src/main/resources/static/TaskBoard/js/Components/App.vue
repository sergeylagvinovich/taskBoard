<template>
    <span>
        <navbar></navbar>
        <b-toast/>
        <div class="container-fluid">
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
import {mapMutations} from "vuex";

export default {
    name: "App",
    components: {TaskBoardApp, Navbar},
    methods:{
        ...mapMutations({
            'setToast':'ToastModule/setToast',
        }),
        init(){
            this.setToast(this.$bvToast);
        }
    },
    mounted(){
        this.init();
    }
}
</script>

<style scoped>
</style>