import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from "../Components/Home.vue";
import Boards from "../Components/Boards.vue";
import Groups from "../Components/Groups.vue";
import About from "../Components/About.vue";

Vue.use(VueRouter);
const baseUrl = '/taskBoard'
const routes = [
    {
        path: baseUrl+'/',
        redirect: baseUrl+"/home/boards"
    },
    {
        path: baseUrl+'/home',
        name: 'Home',
        component:Home,
        children: [
            {
                // UserProfile will be rendered inside User's <router-view>
                // when /user/:id/profile is matched
                path: 'boards',
                name: "HomeBoards",
                component: Boards,
            },
            {
                // UserPosts will be rendered inside User's <router-view>
                // when /user/:id/posts is matched
                path: 'groups',
                name: "HomeGroups",
                component: Groups,
            },
        ],
    },
    {
        path: baseUrl+'/about',
        name: 'About',
        component: About
    }
];

export const router = new VueRouter({
    mode: 'history',
    routes,
});

// export default router;