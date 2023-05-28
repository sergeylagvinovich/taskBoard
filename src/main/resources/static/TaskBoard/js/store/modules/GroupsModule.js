import {router} from "../../routes/routes";
import instance from "../../../../js/modules/axiosBase";
import baseInstance from "../../api/baseInstance";
import axios from "axios";
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
            console.log(baseInstance);
            let instance = axios.create(
                {
                    baseURL: baseInstance.baseURL + "/v1/groups/c400683f-8c1b-4418-beaf-083e62cdf7c1",
                    timeout: baseInstance.timeout,
                    headers: baseInstance.headers
                }
            );
            instance.get();
            return [];
            // return instance.get("/v1/home/groups/",{params:{
            //         page:data.page,
            //         size:data.size
            //     }}).then((resp)=>{
            //     return resp.data.data;
            // }).catch((err)=>{
            //     dispatch("ResponseHandling/showError",err,{ root: true });
            // });
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
    }

}