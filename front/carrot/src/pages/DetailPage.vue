<template>
    <div class="box">

        <div class="images">
            <img :src="`http://localhost:8080/images/20db8238-924a-4a56-adad-347adf294eaf_winter-260817_1280.jpg`" />
        </div>
        <hr/>
        <div class="profile">

            <div class="user">
                <div class="photo">
                    
                </div>
                <div>
                    <span>불가사리뚱이</span><br/>
                    <span>김포시 장기동</span>
                </div>
            </div>

            <div>

            </div>
        </div>
        <hr/>
        <div>
            <h1>s23울트라 256g 자급제 새상품</h1>
            <h3>400,000원</h3>
            <p>
                s23울트라 256G 자급제 새상품 판매합니다. 
            </p>
        </div>

    </div>
</template>



<script>
export default{

}
</script>



<style scoped>
.photo{
    border: 1px solid black;
    border-radius: 50%;
     width: 50px;
     height: 50px;
}
.images{
    width: 729px;
    height: 502px;
}
.images img{
    width: 100%;
    height: 100%;
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