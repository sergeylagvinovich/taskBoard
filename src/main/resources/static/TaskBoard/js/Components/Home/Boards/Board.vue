<template>
    <div class="boardCard pointer">
        <label class="col-form-label">{{ board.name }}</label>
    </div>
</template>

<script>
export default {
    name: "Board",
    props:{
        board:{
            type:Object,
        }
    }
}
</script>

<style scoped>
.boardCard{
    text-align: center;
    margin-bottom: 10px;
    padding: 10px;
    border: 1px solid rgba(0,0,0,.125);
    border-radius: 10px;
    height: 125px;
    max-height: 125px;
    width: 100%;
    background-color: white;
}
.boardCard:hover{
    transition:background-color 0.5s;
    background-color: #e9ecef;
}
.boardCard:not(:hover){
    transition:background-color 0.5s;
}
</style>