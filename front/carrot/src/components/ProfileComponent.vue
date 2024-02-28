<template>
    <div class="container">
        <div class="profiles">
            <img :src="`http://localhost:8080/images/${profile.profile}`"/>
        </div>
        <div>
            <span>{{ profile.userId }}</span>
        </div>
    </div>
</template>


<script>
export default{
    props:{
        profile:Object
    }
}
</script>




<style scoped>
.profiles{
    border: 1px solid black;
    border-radius: 50%;
     width: 50px;
     height: 50px;
     overflow: hidden;
}

.container{
    height: 100%;
    width: 100%;
    display: flex;
    align-items: center;
}
</style>