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
        fetchBoardsByGroupUUID({dispatch},group_uuid){
            return instance.get(`/v1/groups/${group_uuid}/boards`)
                .then((resp)=>{
                    return resp.data.data;
            }).catch((err)=>{
                dispatch("ResponseHandling/showError",err,{ root: true });
            });
        },
        fetchBoardsByGroup(){
            // return axios.get("api_v1/").then((resp)=>{
            //     return resp.data;
            // }).catch((err)=>{
            //     console.log(err);
            //     return [];
            // })
        }
    }

}