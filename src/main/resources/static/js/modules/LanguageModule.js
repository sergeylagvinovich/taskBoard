import en from './../languages/en'
import ru from './../languages/ru'

export default {
    namespaced:true,
    state:{
        lang:ru,
        selected:"ru",
    },
    getters:{
        getLang(state){
            return state.lang;
        },
        getSelectedLang(state){
            return state.selected;
        }
    },
    mutations:{
        setSelectedLang(state,value){
            state.selected = value;
            state.lang = value==='ru'?ru:en;
        }
    }
}