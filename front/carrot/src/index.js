import {createRouter, createWebHistory} from "vue-router";
import MainComponent from './components/MainComponent.vue';
import FleamarketPage from './pages/FleamarketPage.vue';
import LoginPage from './pages/LoginPage.vue';
import RegisterPage from './pages/RegisterPage.vue';
import SellingPage from './pages/SellingPage'
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
        component:SellingPage
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router;