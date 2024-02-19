import { createApp } from 'vue'
import router from './index.js'
import App from './App.vue'
import mitt from 'mitt';
import axios from 'axios';

axios.interceptors.request.use((config)=>{
    const token = localStorage.getItem('token');
    if(token){
        config.headers.Authorization=`Bearer ${token}`
    }
    return config;
});

const emitter = mitt();
const app=createApp(App);
app.config.globalProperties.emitter=emitter;
app.config.globalProperties.$axios=axios;
app.use(router);
app.mount('#app');



