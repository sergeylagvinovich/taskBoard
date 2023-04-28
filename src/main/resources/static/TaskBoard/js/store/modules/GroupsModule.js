import {router} from "../../routes/routes";
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
            return axios.get("api_v1/groups").then((resp)=>{
                return resp.data;
            }).catch((err)=>{
                console.log(err);
                return [];
            })
        },
    }

}