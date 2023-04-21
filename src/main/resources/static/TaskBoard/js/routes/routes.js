import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from "../Components/Home/Home.vue";
import BoardsPage from "../Components/Home/Boards/BoardsPage.vue";
import Groups from "../Components/Home/Groups/Groups.vue";
import About from "../Components/About/About.vue";
import GroupPage from "../Components/Group/GroupPage.vue";
import GroupBoards from "../Components/Group/GroupTabs/Boards/GroupBoards.vue";
import GroupSettings from "../Components/Group/GroupTabs/Settings/GroupSettings.vue";
import GroupUsers from "../Components/Group/GroupTabs/Members/GroupUsers.vue";
import PageNotFound from "../Components/PageNotFound.vue";
import BoardPage from "../Components/Board/BoardPage.vue";
import Workspace from "../Components/Board/Workspace/Workspace.vue";
import TaskCard from "../Components/Board/Workspace/TaskCard/TaskCard.vue";

Vue.use(VueRouter);
const baseUrl = '/taskBoard'
const routes = [
    {
        path: baseUrl+'/',
        redirect: baseUrl+"/home"
    },
    {
        path: baseUrl+'/home',
        name: 'Home',
        component:Home,
        children: [
            {
                path: '',
                name: "HomeBoards",
                component: BoardsPage,
            },
            {
                path: '',
                name: "HomeGroups",
                component: Groups,
            },
        ],
    },
    {
        path: baseUrl+'/about',
        name: 'About',
        component: About
    },
    {
        path: baseUrl+'/groups/:id',
        name: 'Group',
        component: GroupPage,
        children: [
            {
                path: 'boards',
                name: "GroupBoards",
                component: GroupBoards,
            },
            {
                path: 'options',
                name: "GroupSettings",
                component: GroupSettings,
            },
            {
                path: 'members',
                name: "GroupUsers",
                component: GroupUsers,
            },
        ],
    },
    {
        path: baseUrl+'/boards',
        name: 'Board',
        component: BoardPage,
        children: [
            {
                path: ':boardId',
                name: "BoardWorkspace",
                component: Workspace,
                children: [
                    {
                        path: 'tasks/:taskId',
                        name: "TaskCard",
                        component: TaskCard,
                    }
                ]
            },
            {
                path: 'options',
                name: "GroupSettings",
                component: GroupSettings,
            },
            {
                path: 'members',
                name: "GroupUsers",
                component: GroupUsers,
            },
        ],
    },
    {
        path: '/:catchAll(.*)',
        name: 'NotFound',
        component: PageNotFound,
    }
];

export const router = new VueRouter({
    mode: 'history',
    routes,
});

// export default router;