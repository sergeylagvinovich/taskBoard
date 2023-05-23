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
        saveUser({commit,dispatch},data){
            return instance.put(`/v1/groups/${data.group_uuid}/members/${data.user_uuid}`,data.edit).then((resp)=>{
               return true;
            }).catch((err)=>{
                return false;
            });
        },
        fetchGroupUsersByUUID({commit,dispatch},group_uuid){
            return instance.get(`/v1/groups/${group_uuid}/members`).then((resp)=>{
                return resp.data.data;
            }).catch((err)=>{
                dispatch("ResponseHandling/showError",err,{ root: true });
                return null;
            });
        },
    }

}