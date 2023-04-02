import {router} from "../../routes/routes";
export default {
    namespaced:true,
    mutations:{
        goTo(state,value){
            console.log(value);
            router.push({name:value});
        }
    }
}