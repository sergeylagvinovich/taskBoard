import {router} from "../../routes/routes";
export default {
    namespaced:true,
    mutations:{
        goTo(state,value){
            if(router.app.$route.name!==value)
                router.push({name:value});
        }
    }
}