import Vue from 'vue';
import Vuex from 'vuex';
Vue.use(Vuex);
import testModule from "./modules/testModule";
import languageModule from "../../../js/modules/LanguageModule";
import routerModule from "./modules/RouterModule";
import ToastModule from "./modules/ToastModule";
import GroupsModule from "./modules/GroupsModule";
import ResponseHandling from "../../../js/modules/ResponseHandling";
import BoardsModule from "./modules/BoardsModule";
const store = new Vuex.Store({
    modules:{
        languageModule,
        routerModule,
        ResponseHandling,
        testModule,
        ToastModule,

        GroupsModule,
        BoardsModule
    }
})
export default store;

