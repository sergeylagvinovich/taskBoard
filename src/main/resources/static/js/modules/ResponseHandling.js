import {router} from "../../TaskBoard/js/routes/routes";

export default {
    namespaced:true,
    state:{

    },
    getters:{

    },
    mutations:{

    },
    actions:{
        showError({commit,dispatch},data){
            let response = data.response.data;
            let toastData = {
                message:response.message,
                variant:'danger',
                title:'Ошибка запроса',
            }
            dispatch("ToastModule/showToast",toastData,{root:true});
            if(data.response.status === 404){
                router.push({
                    name: 'NotFound',
                    // preserve current path and remove the first char to avoid the target URL starting with `//`
                    params: { pathMatch: router.app.$route.path.substring(1).split('/') },
                    // preserve existing query and hash if any
                    query: router.app.$route.query,
                    hash: router.app.$route.hash,
                })
            }
        },
    }

}