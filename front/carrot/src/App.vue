<template>
  <div>
    <HeaderComponent></HeaderComponent>
    <router-view></router-view>
  </div>
</template>

<script>
import HeaderComponent from './components/HeaderComponent.vue';

export default {


  name: 'App',
  components: {
    HeaderComponent,
  }
}
</script>

<style>
body{
  margin: 0px;
}
</style>
