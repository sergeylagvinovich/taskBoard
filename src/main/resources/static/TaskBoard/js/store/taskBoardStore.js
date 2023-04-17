import Vue from 'vue';
import Vuex from 'vuex';
Vue.use(Vuex);
import testModule from "./modules/testModule";
import languageModule from "../../../js/modules/LanguageModule";
import routerModule from "./modules/RouterModule";
import ToastModule from "./modules/ToastModule";
const store = new Vuex.Store({
    modules:{
        languageModule,
        routerModule,
        testModule,
        ToastModule,
    }
})
export default store;

