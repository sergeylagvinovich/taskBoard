export default {
    namespaced: true,
    state:{
        toast:null,

    },
    getters:{
        getToast(state){
            return state.toast;
        },
    },
    mutations:{
        setToast(state,value){
            state.toast = value;
        },
    },
    actions:{
        showToast({commit,state},data){
            state.toast.toast(data.message,{
                title: data.title,
                variant: data.variant,
                autoHideDelay: 5000,
                appendToast: false
            })
        }
    }
}