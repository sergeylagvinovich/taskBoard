import {router} from "../../routes/routes";
export default {
    namespaced:true,
    mutations:{
        goTo(state,value){
            if(router.app.$route.name!==value)
                router.push({name:value});
        },
        goToWithParams(state,data){
            if(router.app.$route.name!==data.name)
                router.push({name:data.name,params:data.params});
        }
    }
}