<template>
    <div>
        <div class="banner">
            <div>
                <h1>믿을만한 <br>
                이웃 간 중고거래
                </h1>
                <p>동네 주민들과 가깝고 따뜻한 거래를<br>
                    지금 경험해보세요.
                </p>
            </div>
            <div>
                <img src="../assets/fleamarket.png"/>
            </div>
        </div>
        <h1 style="text-align:center">중고거래 인기매몰</h1>
        <div class="itemBox">
            <ItemComponent  v-for="item in items" v-bind:key="item.id" :item="item"/>
        </div>
    </div>
</template>

<script>
import ItemComponent from '../components/ItemComponent.vue';
export default{
    data:function(){
        return{
            items:[]
        }
    },
    components:{
       ItemComponent
    },
    created(){
        this.$axios.get("http://localhost:8080/item?count=14").then((response)=>{
            this.$data.items=response.data;
            console.log(this.$data.items[0]);
        });
    }
}
</script>

<style scoped>
.banner{
    height: 315px;
    background-color: #FFF1AA;
    display:flex;
    justify-content:center;
    align-items:center;
}
.banner img{
    max-height:300px;
}

.itemBox{
    display: flex;
    justify-content: center;
    align-items: center;
}
</style>