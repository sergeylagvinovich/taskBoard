
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
            dispatch("ToastModule/showToast",toastData,{root:true})
        },
    }

}