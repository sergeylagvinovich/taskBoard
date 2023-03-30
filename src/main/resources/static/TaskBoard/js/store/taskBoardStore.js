import Vue from 'vue';
import Vuex from 'vuex';
Vue.use(Vuex);
import testModule from "./modules/testModule";
const store = new Vuex.Store({
    modules:{
        testModule
    }
})
export default store;

