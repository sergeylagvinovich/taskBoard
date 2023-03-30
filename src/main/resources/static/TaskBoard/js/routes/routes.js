import Vue from 'vue';
import VueRouter from 'vue-router';


Vue.use(VueRouter);

const routes = [
    {
        path: '/',
        redirect: '/boards',
    },
    {
        path: '/boards',
        name: 'boards',
    },
    {
        path: '/boards/:id',
        name: 'board',
        props: true,
    },
];

const router = new VueRouter({
    mode: 'history',
    routes,
});

export default router;