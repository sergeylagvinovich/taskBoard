import Vue from 'vue';
import Vuex from 'vuex';
Vue.use(Vuex);
import testModule from "./modules/testModule";
import languageModule from "../../../js/modules/LanguageModule";
import routerModule from "./modules/RouterModule";
const store = new Vuex.Store({
    modules:{
        languageModule,
        routerModule,
        testModule,
    }
})
export default store;

