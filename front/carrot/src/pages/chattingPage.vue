<template>
    <div class="page">
        <div class="side">
            <div class="profile">

                <span style="font-weight: bolder;">{{ user.userId }}</span>

            </div>

            <div class="friend" v-for="(profile,i) in user.friendList" :key="i">
                <ProfileComponent :profile="profile" v-on:click="send(profile.room_no)" ></ProfileComponent>
            </div>

        </div>
        <div class="content">
            <div class="chat">

            </div>
            <div class="inputArea">
                <textarea></textarea>
                <button>전송</button>
            </div>
        </div>
    </div>
</template>


<script>
import ProfileComponent from '../components/ProfileComponent.vue';
import Stomp from 'webstomp-client'
import SockJS from 'sockjs-client'
export default{

    data:function(){
        return{
            user:{}
        }
    },
    created(){
        this.connect();
    }
    ,
    mounted(){
        this.$axios.get("http://localhost:8080/member")
        .then((response)=>{
            this.user=response.data;
            console.log(this.user);
        });
    },components:{
        ProfileComponent
    },
    methods:{
        send:function(e){
            console.log(e);
        },
        connect:function(){
            const token = "Bearer "+localStorage.getItem('token');
            console.log(token);
            let socket = new SockJS('http://localhost:8080/ws');
            this.stompClient = Stomp.over(socket);
            console.log('소켓 연결을 시도합니다.');
            this.stompClient.connect({Authorization:token}, ()=>{
               // console.log('Connected: '+frame);
                
            });
        }
    }


}
</script>




<style scoped>

.page{
    height: 100vh;
    border: 1px solid black;
    display: flex;

}

.side{
    width: 200px;
    height: 100%;
    border: 1px solid black;
}
.profile{
   padding-top: 20px;
   padding-left: 10px;
   padding-bottom: 20px;
    border-bottom: 1px solid lightgray;
}
.content{
    height: 100%;
    width: 100%;
    border: 1px solid black;
}

.chat{
    height: 90%;
    border:1px solid black;
}

.friend{
    height: 100px;
}

.inputArea{
    border: 1px solid black;
    display: flex;
    justify-content: center;
    height: 10%;
}

.inputArea textarea{
    width: 90%;
    resize: none;
}
.inputArea button{
    width:10%;
}

</style>