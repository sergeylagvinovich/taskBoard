import {router} from "../../routes/routes";
import instance from "../../../../js/modules/axiosBase";
export default {
    namespaced:true,
    state:{

    },
    getters:{

    },
    mutations:{

    },
    actions:{
        fetchGroups(){
            return instance.get("/groups/v1/").then((resp)=>{
                return resp.data.data;
            }).catch((err)=>{
                return [];
            });
        },
    }

}