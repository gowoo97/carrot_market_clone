<template>
    <div class="header">
        <div class="content">
            <img src="../assets/carrot.png" />
            <div>
                <h3>중고거래</h3>
            </div>
        </div>
        <div class="inputs">
            <input type="text" placeholder="물품이나 동네를 검색해보세요" style="height: 80%; width: 288px;background-color: #F2F3F6;
            border:none"/>
            <input type="button" value="채팅하기" style="height: 80%;width: 97px; margin-right: 10px; background-color: white; "/>
            <input type="button" value="로그인" style="height: 80%;width: 97px; margin-right: 10px; background-color: white;" />
        </div>
    </div>



</template>

<script>
export default{

}
</script>


<style scoped>
    .header{
        width: 100vw;
        display: flex;
        justify-content: flex-start;
        flex-direction: row;
        position: static;
        margin: 0;
    }

    .content{
        display: flex;
        justify-content: flex-start;
        margin-right: auto;
    }



    .inputs>input{
        box-sizing: content-box;
        margin: 5px;
        font-size: 20px;
    }
</style>