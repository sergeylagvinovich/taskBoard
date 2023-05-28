import baseInstance from './baseInstance'
import axios  from "axios";

const instance = axios.create({
        baseURL: baseInstance.baseURL + "/auth",
        timeout: baseInstance.timeout,
        headers: baseInstance.headers
    }
);

export default {
    login(dataLogin){
        return instance.post("/login",dataLogin);
    },
    registration(dataRegistration){
        return instance.post("/registration",dataRegistration);
    },
    refreshToken(dataToken){
        return instance.post("/token",dataToken);
    }
}
