<template>
<div class="container">
    <div>
    <input type="file" id="images" multiple />
    <br/>
    <label for="title">제목</label>
    <br/>
    <input type="text" id="title" v-model="title"  placeholder="제목"/>
    <br/>
    <label>거래방식</label>
    <br/>
    <input class="sellOrGive" type="button" value="판매하기" />
    <input class="sellOrGive" type="button" value="나눔하기"/>
    <br/>
    <input type="number" v-model="price" placeholder="₩ 가격을 입력해주세요"/>
    <br/>
    <label>자세한 설명</label>
    <br/>
    <textarea style="width: 300px; box-sizing: border-box; resize: none; height: 200px;" v-model="content" placeholder="우리동네에 올릴 게시글 내용을 작성해 주세요.(판매 금지 물품은 게시가 제한될 수 있어요.) &#10;신뢰할 수 있는 거래를 위해 자세히 적어주세요."></textarea>
    <br/> 
    <label>거래 희망 장소</label>
    <br/>
    <input type="text" v-model="place" placeholder="장소 입력"/>
    <br/>
    <input type="button" value="작성완료" v-on:click="postItem">
</div>
</div>
</template>


<script>

export default{
    data(){
        return{
            title:'',
            price:'',
            content:'',
            place:''
        }
    },
    methods:{
        postItem:function(){
            const formData = new FormData();
            const images=document.getElementById("images");
            const item={
                title:this.$data.title,
                price:this.$data.price,
                content:this.$data.content,
                place:this.$data.place
            }

            for(const file of images.files){
                formData.append("images",file);
            }

            formData.append("itemDTO",new Blob([JSON.stringify(item)],{type:'application/json'}));
            
            this.$axios.post("http://localhost:8080/item",formData)
                .then((response)=>{
                    console.log(response);
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
    height: 100vh;
}

input{
    box-sizing: border-box;
    width: 300px;
    height: 30px;
}

.sellOrGive{
    width: 80px;
}
</style>