import {createRouter, createWebHistory} from "vue-router";
import MainComponent from './components/MainComponent.vue';
import FleamarketPage from './pages/FleamarketPage.vue';
import LoginPage from './pages/LoginPage.vue';
import RegisterPage from './pages/RegisterPage.vue';
import SellingPage from './pages/SellingPage.vue'
import DetailPage from './pages/DetailPage.vue';
import chattingPage from './pages/chattingPage.vue';
const routes = [
    {
        path:'/',
        component:MainComponent
    },
    {
        path:'/fleamarket',
        component:FleamarketPage
    },
    {
        path:'/login',
        component:LoginPage
    },
    {
        path:'/register',
        component:RegisterPage
    },
    {
        path:'/selling',
        component:SellingPage,
        meta:{requiredAuth: true}

    },
    {
        path:'/fleamarket/detail/:id',
        component:DetailPage
    },
    {
        path:'/chatting',
        component:chattingPage,
        meta:{requiredAuth: true}
    }
]

const router = createRouter({
    mode:'history',
    history: createWebHistory(),
    routes
});

router.beforeEach(function (to,_,next){
    const access_token = localStorage.getItem('token');
    if(!access_token){
        if(to.meta.requiredAuth){
            alert('로그인 후 이용해 주세요');
            next('/');
        }else{
            next();
        }
    }else{
        next();
    }
});


export default router;