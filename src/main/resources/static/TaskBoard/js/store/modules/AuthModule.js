import authApi from "../../api/authApi";
import baseInstance from "../../api/baseInstance";
import Cookies from "js-cookie";
export default {
    namespaced:true,
    state:{
        accessToken:"",
        type:"",
        refreshToken:"",
    },
    getters:{

    },
    mutations:{
        setDataToken(state,token){
            state.accessToken = token.accessToken;
            state.type = token.type;
            state.refreshToken = token.refreshToken;
        },
        setCookie(state){
            Cookies.set("taskBoardType",state.type);
            Cookies.set("taskBoardAccessToken",state.accessToken);
            Cookies.set("taskBoardRefreshToken",state.refreshToken);
        }
    },
    actions:{
        login({commit,state},data){
           return authApi.login(data).then((resp)=>{
               commit("setDataToken",resp.data);
               commit("setCookie",resp.data);
               baseInstance.headers = {
                   'Content-Type': 'application/json',
                   'Authorization': resp.data.type+" "+resp.data.accessToken,
               }
               return true;
           }).catch((err)=>{
               return false;
           })
        },
        checkCookie({state}){
            let type = Cookies.get("taskBoardType");
            let accessToken = Cookies.get("taskBoardAccessToken");
            let refreshToken = Cookies.get("taskBoardRefreshToken");
            if(type && accessToken && refreshToken){
                state.type = type;
                state.accessToken = accessToken;
                state.refreshToken = refreshToken;
                baseInstance.headers = {
                    'Content-Type': 'application/json',
                    'Authorization': state.type+" "+state.accessToken,
                }
                return true;
            }
            return false;
        },
        token({state, commit}){
            return authApi.refreshToken({refreshToken:state.refreshToken}).then((resp)=>{
                state.accessToken = resp.data.accessToken;
                commit("setCookie");
                baseInstance.headers = {
                    'Content-Type': 'application/json',
                    'Authorization': resp.data.type+" "+resp.data.accessToken,
                }
                return true;
            }).catch((err)=>{
                return false;
            });
        }
    }

}