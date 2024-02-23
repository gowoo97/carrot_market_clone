<template>
    <div class="box">
        <div class="images">
            <div v-for="(photo,index) in item.photos" :key="index">
                <img :src="`http://localhost:8080/images/${photo}`" class="image" />
            </div>
        </div>
        <hr/>
        <div class="profile">
            <div class="user">
                <div class="photo" >
                    <img  :src="`http://localhost:8080/images/${item?.publisher?.profile}`" />
                </div>
                <div>
                   <span> {{ item?.publisher?.userId }} </span>
                </div>
            </div>

            <div>
                
            </div>
        </div>
        <hr/>
        <div>
            <h2>{{ item.title }}</h2>
                <h3>{{ item.price }}</h3>
                <p>
                    {{ item.content }}
                </p>
        </div>

    </div>
</template>



<script>

export default{

    data(){
        return{
            item:{},
            user:{}
            
        }
    },
    mounted(){
        this.$axios.get(`http://localhost:8080/item/${this.$router.currentRoute._value.params.id}`)
        .then((response)=>{
           this.item=response.data;
           console.log(this.item.publisher.userId);
        });
        
    },
    



}
</script>



<style scoped>
.photo{
    border: 1px solid black;
    border-radius: 50%;
     width: 50px;
     height: 50px;
     overflow: hidden;
}
.images{
    width: 729px;
    height: 502px;
    display: flex;
    flex-direction: row;
    overflow: hidden;
}

.photo img{
    width:100%;
    
    height: 100%;

}

.images img{
    width: 100%;
    height: 100%;
    position:relative;
    min-width: 729px;

}
.box{
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
  
}
.user{
    display: flex;
}
.profile{
    display: flex;
   
    width:729px;
}
</style>