<template>
    <div class="container">
        <div class="imageDiv"   v-on:click="clickDiv">
            <img src="" id="preview"/>
            <input type="file" id="image" v-on:change="previewChange" style="visibility: hidden;"/>
        </div>
        <input type="text" placeholder="아이디"/>
        <input type="password"  placeholder="패스워드"/>
        <input type="button" value="회원가입"/>
    </div>
</template>


<script>
export default{
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

            reader.readAsDataURL(image.files[0]);

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