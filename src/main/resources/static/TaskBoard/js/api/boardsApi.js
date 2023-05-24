import axios from 'axios'

const instance = axios.create({
    baseURL: `/api/groups`,
    timeout: 1000,
    headers: { 'Content-Type': 'application/json' }
});


export default {
    get(group_uuid){
        return instance.get(`/${group_uuid}/boards`);
    },
    getOne(group_uuid,board_uuid){
        return instance.get(`/${group_uuid}/boards/${board_uuid}`);
    }
}