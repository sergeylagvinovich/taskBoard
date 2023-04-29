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
        fetchGroups(ctx,data){
            console.log(data)
            return instance.get("/groups/v1/",{params:{
                    page:data.page,
                    size:data.size
                }}).then((resp)=>{
                return resp.data.data;
            }).catch((err)=>{
                return [];
            });
        },
    }

}