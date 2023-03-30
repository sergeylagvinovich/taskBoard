import {router} from "../../routes/routes";
export default {
    namespaced:true,
    mutations:{
        goTo(value){
            console.log(value);
            router.push({name:value});
        }
    }
}