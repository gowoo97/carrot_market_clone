<template>
    <div class="container">
        <div class="imageDiv"   v-on:click="clickDiv">
            <img src="" id="preview"/>
            <input type="file" id="image" v-on:change="previewChange" style="visibility: hidden;"/>
        </div>
        <input type="text" placeholder="아이디" v-model="userId"/>
        <input type="password"  placeholder="패스워드" v-model="password"/>
        <input type="button" value="회원가입" v-on:click="signup" />
    </div>
</template>


<script>
import axios from 'axios';
export default{
    data(){
        return{
            userId:"",
            password:"",
            profile:""
        };
    },
    methods:{
        clickDiv:function(){
            const image=document.getElementById('image');
            image.click();
        },
        previewChange:function(){
            const preview=document.getElementById('preview');
            const image=document.getElementById('image');
            const reader=new FileReader();
            if(image.files[0] ==null){
                return;
            }

            reader.onloadend=()=>{
                preview.src=reader.result;
            }

            console.log(image.files[0]);
            this.$data.profile=image.files[0];
            reader.readAsDataURL(image.files[0]);

        },
        signup:function(){
            const formData =new FormData();
            const request = {
                userId:this.$data.userId,
                password:this.$data.password
            }


            formData.append('profile',this.$data.profile);
            formData.append('memberDTO',new Blob([JSON.stringify(request)],{type:'application/json'}));
            console.log(this.$data.profile);
            axios.post('http://localhost:8080/auth/signup',formData)
                .then(response =>{
                    if(response.data.register_stat === true){
                        this.$router.push({path:'/'});
                    }
                    else{
                        alert('회원가입 실패!');
                    }
                })
        }


    }
}

</script>


<style scoped>
.container{
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    height: 400px;
}
input{
    box-sizing: content-box;
    width: 200px;
    padding: 0;
}

.imageDiv{
    border: 1px solid black;
    border-radius: 50%;
    width: 100px;
    height: 100px;
    overflow: hidden;
}

.imageDiv>img{
    width: 100%;
    height: 100%;
}
</style>