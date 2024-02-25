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
                   <span> {{ item?.publisher?.userId }} </span><br/>
                   <span>{{ item.place }}</span>
                </div>
            </div>

            <div>
                <button class="addBtt" v-on:click="addFriend">친구추가</button>
            </div>
        </div>
        <hr/>
        <div class="content">
            <h2>{{ item.title }}</h2>
                <h3>{{ item.price }}</h3>
                <p>
                    {{ item.content }}
                </p>
        </div>

        <div style="width: 729px;">
            <span style="float: left;">조회수:{{ item.visit }}</span>

        </div>

    </div>
</template>



<script>

export default{

    data(){
        return{
            item:{
                publisher:{
                    userId:""
                }
            },
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
    methods:{
        addFriend:function(){
            this.$axios.post(`http://localhost:8080/friend`,{
                to:this.item.publisher.userId
            })
            .then((response)=>{
                console.log(response.data);
            })
            .catch(function(err){
                console.log(err);
                alert("이미 친구입니다.");
            });
        }
    }
    



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

.content{
    width: 729px;
}
.addBtt{
    background-color: #ff6f0f;
    width: 150px;
    height: 50px;
    border-radius: 10px;
    border: none;
    color: white;
    cursor: pointer;
    font-weight: bold;
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
    margin-right: auto;
}
.profile{
    display: flex;
   
    width:729px;
}
</style>