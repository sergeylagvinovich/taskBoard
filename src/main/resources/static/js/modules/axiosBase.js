import axios from "axios";

const instance = axios.create({
    baseURL: 'http://localhost:9999/api/',
    timeout: 0,
    withCredentials: false,
    headers: {
        'Content-Type':'application/json',
        'Accept':'*/*',
        'Accept-Encoding':'gzip, deflate, br',
        'Connection':'keep-alive'
    }
});


export default instance;