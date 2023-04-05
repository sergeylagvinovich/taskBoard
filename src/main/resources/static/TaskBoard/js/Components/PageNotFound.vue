<template>
    <div class="container-fluid w-50 mt-5" style="color: rgb(94, 108, 132)">
        <div class="row align-items-center">
            <div class="col-12 mx-auto text-center">
                <h1>Страница не найдена.</h1>
                <p>Возможно, это приватная страница. Попросите того, кто поделился ссылкой, дать доступ к доске или пригласить вас в рабочее пространство.</p>
            </div>
        </div>
    </div>
</template>

<script>
import MemberList from "./Group/GroupTabs/Members/MemberList.vue";

export default {
    name: "PageNotFound",
    components: {MemberList}
}
</script>

<style scoped>

</style>