<template>
    <div>
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