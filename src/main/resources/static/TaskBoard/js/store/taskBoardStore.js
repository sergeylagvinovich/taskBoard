import {createStore} from "vuex";
import testModule from "./modules/testModule";
const taskBoardStore = createStore({
    modules: {
        testModule: testModule
    }
})

export default taskBoardStore;

