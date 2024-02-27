<template>
    <div class="page">
        <div class="side">
            <div class="profile">

                <span style="font-weight: bolder;">{{ user.userId }}</span>

            </div>

            

        </div>
        <div class="content">
            <div class="chat">

            </div>
            <div class="inputArea">

            </div>
        </div>
    </div>
</template>


<script>
export default{

    data:function(){
        return{
            user:{}
        }
    },
    mounted(){
        this.$axios.get("http://localhost:8080/member")
        .then((response)=>{
            this.user=response.data;
        });
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
    height: 95%;
    border:1px solid black;
}

.inputArea{
    border: 1px solid black;
}

</style>