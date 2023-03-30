export default {
    namespaced: true,
    state:{
        test:"Hello vuex",
    },
    getters:{
        getTest(state){
            return state.test;
        }
    }
}

