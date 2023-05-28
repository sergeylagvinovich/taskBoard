<template>
    <span>
        <navbar></navbar>
        <b-toast/>
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                     <transition name="fade" v-if="login || isRegisterLogin">
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
import {mapActions, mapMutations} from "vuex";

export default {
    name: "App",
    components: {TaskBoardApp, Navbar},
    data(){
      return{
        login:false,
      }
    },
    computed:{
      isRegisterLogin(){
        return this.$route.name.includes("Auth");
      },
    },
    methods:{
        ...mapMutations({
            'setToast':'ToastModule/setToast',
            'goTo':'routerModule/goTo',
        }),
        ...mapActions({
            "checkCookie":"AuthModule/checkCookie",
            "getNewToken":"AuthModule/token",
        }),
        async init(){

            this.setToast(this.$bvToast);
            let cookie = await this.checkCookie();
            console.log(cookie);
            if(cookie){
               let token = await this.getNewToken();
               console.log(token);
               if(token){
                 this.login = true;
               }else{
                 this.goTo("AuthLogin");
               }
            }
        }
    },
    mounted(){
        this.init();
    }
}
</script>

<style scoped>
</style>