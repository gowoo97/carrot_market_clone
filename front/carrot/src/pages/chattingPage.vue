<template>
    <div class="page">
        <div class="side">
            <div class="profile">

                <span style="font-weight: bolder;">{{ user.userId }}</span>

            </div>

            <div class="friend" v-for="(profile,i) in user.friendList" :key="i">
                <ProfileComponent :profile="profile" v-on:click="subscribe(profile.room_no)" ></ProfileComponent>
            </div>

        </div>
        <div class="content">
            <div class="chat">
                <div class="message" v-for="(msg,i) in receiveList" :key="i">
                    <div class="mine" v-if="JSON.parse(msg).userName === user.userId">
                        <span  class="myName" >{{ JSON.parse(msg).userName }}</span><br/>
                        <span style="display: inline-block; background-color: #ff6f0f; border-radius: 10px; padding: 10px;">{{ JSON.parse(msg).content }}</span>    
                    </div>

                    <div class="yours" v-else>
                        <span>{{ JSON.parse(msg).userName }}</span><br/>
                        <span style="display: inline-block; background-color: #ff6f0f; border-radius: 10px; padding: 10px;">{{ JSON.parse(msg).content }}</span>    
                    </div>
                    
                </div>
            </div>
            <div class="inputArea">
                <textarea v-model="message"></textarea>
                <button v-on:click="send">전송</button>
            </div>
        </div>
    </div>
</template>


<script lang="js">
import ProfileComponent from '../components/ProfileComponent.vue';
import Stomp from 'webstomp-client'
import SockJS from 'sockjs-client'
export default{

    data:function(){
        return{
            user:{},
            message:'',
            roomNo:0,
            subscription:null,
            receiveList:[]
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
        send:function(){
            const msg = {
                userName: this.user.userId,
                content: this.message
            }
            this.stompClient.send("/app/"+this.roomNo,JSON.stringify(msg),{});
        },
        connect:function(){
            const token = "Bearer "+localStorage.getItem('token');
            console.log(token);
            let socket = new SockJS('http://localhost:8080/ws');
            this.stompClient = Stomp.over(socket);
            console.log('소켓 연결을 시도합니다.');
            this.stompClient.connect({},frame=>{
                console.log('소켓연결 성공',frame);
            });
        },
        subscribe:function(id){
            this.roomNo=id;
            if(this.subscription != null){
                console.log("dsfsdf");
                this.subscription.unsubscribe();
            }
            this.receiveList=[];

            this.$axios.get("http://localhost:8080/message/"+id)
                .then((response)=>{
                    for(let msg of response.data){
                        this.receiveList.push(JSON.stringify(msg));
                    }
                });

            this.subscription=this.stompClient.subscribe("/topic/"+id,res=>{
                console.log(res.body);
                this.receiveList.push(res.body);
                console.log(this.receiveList);
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

.mine{
    margin-left: auto;

}



.message{
    display: flex;
}


</style>