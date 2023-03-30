
import taskBoardApp from "./Components/TaskBoardApp.vue";
import { createApp } from 'vue'
import taskBoardStore from './store/taskBoardStore'
import { createVuetify } from 'vuetify'
import 'vuetify/styles'
const vuetify = createVuetify();

const app = createApp(taskBoardApp)
app.use(taskBoardStore).use(vuetify).mount("#taskBoardApp");