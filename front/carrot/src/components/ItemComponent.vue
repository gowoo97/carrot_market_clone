<template>
    <div v-on:click="moveDetail">
        <img :src="`http://localhost:8080/images/${item.photos[0]}`" />
        <h5>{{ item.title}}</h5>
        <h6>{{ item.price }} </h6>
    </div>
</template>

<script>
export default{
    props:{
        item:{
            type:Object
        }
    },
    methods:{
        moveDetail:function(){
            this.$router.push({path:`/fleamarket/detail/${this.item.id}`});
            
        }
    }

}
</script>

<style scoped>
img{
    width: 223px;
    height: 223px;
    border-radius: 10px;
}
</style>