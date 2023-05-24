import axios from 'axios'

const instance = axios.create({
    baseURL: `/api/groups`,
    timeout: 1000,
    headers: { 'Content-Type': 'application/json' }
});


export default {
    get(params){
        return instance.get("",{params});
    },
    getOne(group_uuid){
        return instance.get(`/${group_uuid}`);
    }
}