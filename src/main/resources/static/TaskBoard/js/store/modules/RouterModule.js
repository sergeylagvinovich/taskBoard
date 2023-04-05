import {router} from "../../routes/routes";
export default {
    namespaced:true,
    mutations:{
        goTo(state,value){
            if(router.re!==value)
                router.push({name:value});
        }
    }
}