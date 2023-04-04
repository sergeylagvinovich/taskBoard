<template>
    <div class="col-12">
        <member v-for="(item, itemIndex) in members" :key="itemIndex" :member="item"></member>
    </div>
</template>

<script>
import Member from "./Member.vue";

export default {
    name: "MemberList",
    components: {Member},
    props:{
        members:{
            type:Array,
        }
    }
}
</script>

<style scoped>

</style>