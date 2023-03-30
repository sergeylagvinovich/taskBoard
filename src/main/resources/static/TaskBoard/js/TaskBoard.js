import Vue from 'vue'
import store from "./store/taskBoardStore";
import { BootstrapVue, BootstrapVueIcons  } from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import 'bootstrap-vue/dist/bootstrap-vue-icons.min.css'
import 'bootstrap/dist/css/bootstrap.min.css';
Vue.use(BootstrapVue)
Vue.use(BootstrapVueIcons)

import {router} from "./routes/routes";


Vue.component('app',require('./Components/App.vue').default);
const app = new Vue({
    el: '#taskBoardApp',
    router,
    store:store
})