<template>
    <div>
        <img src="../assets/kim.JPG"/>
        <h5>{{ title }}</h5>
        <h6>{{ price }} </h6>
        <h6>{{ address }}</h6>
        <span>관심 {{ like }}.채팅{{ chat }}</span>
    </div>
</template>

<script>
export default{
    props:['title','price','address','like','chat']
}
</script>

<style scoped>

</style>