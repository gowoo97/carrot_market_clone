<template>
    <div class="container">

        <div class="box">
            <h1 style="text-align:center">로그인</h1>
            <input type="text" placeholder="아이디를 입력하세요"/>
            <input type="password" placeholder="패스워드를 입력하세요"/>
            <input type="button" value="로그인"/>
            <p>
                아직 회원이 아니신가요?
              <RouterLink to="/register"><span style="color: aqua;">회원가입</span></RouterLink>
            </p>
        </div>
    </div>
</template>

<script>
export default{

}
</script>

<style scoped>
.container{
    display: flex;
    justify-content: center;
    align-items: center;
    height:400px;
    border:1px solid black;
}
.box{
    display:flex;
    justify-content:center;
    align-items:center;
    flex-direction:column;
    border:1px solid black;
    padding:30px;
}
input{
    box-sizing:content-box;
    width:200px;
    padding:0;
    margin-bottom:10px;
}
</style>