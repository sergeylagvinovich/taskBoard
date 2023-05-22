import {router} from "../../routes/routes";
import instance from "../../../../js/modules/axiosBase";
export default {
    namespaced:true,
    state:{
        group:null,
    },
    getters:{
        getGroup(state){
            return state.group;
        }
    },
    mutations:{
        setGroup(state, value){
            state.group = value;
        }
    },
    actions:{
        fetchGroups({commit,dispatch},data){
            return instance.get("/v1/home/groups/",{params:{
                    page:data.page,
                    size:data.size
                }}).then((resp)=>{
                return resp.data.data;
            }).catch((err)=>{
                dispatch("ResponseHandling/showError",err,{ root: true });
            });
        },
        fetchGroupByUUID({commit,dispatch},group_uuid){
            return instance.get(`/v1/groups/${group_uuid}`).then((resp)=>{
                commit('setGroup',resp.data.data);
                return resp.data.data;
            }).catch((err)=>{
                dispatch("ResponseHandling/showError",err,{ root: true });
                return null;
            });
        },
        fetchGroupUsersByUUID({commit,dispatch},group_uuid){
            return instance.get(`/v1/groups/${group_uuid}/users`).then((resp)=>{
                return resp.data.data;
            }).catch((err)=>{
                dispatch("ResponseHandling/showError",err,{ root: true });
                return null;
            });
        },

    }

}