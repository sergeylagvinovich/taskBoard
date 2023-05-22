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
        fetchGroups({commit,dispatch},data){
            console.log(data)
            return instance.get("/home/groups/v1/",{params:{
                    page:data.page,
                    size:data.size
                }}).then((resp)=>{
                return resp.data.data;
            }).catch((err)=>{
                dispatch("ResponseHandling/showError",err,{ root: true });
            });
        },
    }

}