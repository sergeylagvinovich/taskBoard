<template>
    <div>
       <b-button @click="loginAction">Логин</b-button>
    </div>
</template>

<script>
import {mapActions, mapMutations} from "vuex";

export default {
  name: "Login",
  methods:{
      ...mapMutations({
        'goTo':'routerModule/goTo',
      }),
      ...mapActions({
        "login":"AuthModule/login"
      }),
      async loginAction(){
          let dataLogin = {
            "email":"sergeylagvinovich@gmail.com",
            "password":"123"
          }
          let result = await this.login(dataLogin);
          if(result){
              this.goTo("Home");
          }else{
              alert("Что-то пошло не так");
          }
      }
  }
}
</script>


<style scoped>

</style>