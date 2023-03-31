<template>
    <b-nav vertical class="w-100 navbar navbar-dark" >
        <b-nav-item :to="{name:'HomeBoards'}">
            <b-icon-card-list></b-icon-card-list> {{lang['boards']}}
        </b-nav-item>
        <b-nav-item :to="{name:'HomeGroups'}">
            <b-icon-people></b-icon-people> {{lang['groups']}}
        </b-nav-item>
    </b-nav>
</template>

<script>
import {mapGetters} from "vuex";

export default {
    name: "VerticalMenu",
    data(){
        return{

        }
    },
    computed:{
        lang(){
            return this.getLang;
        },
        ...mapGetters({
            'getLang':"languageModule/getLang",
        })
    }
}
</script>

<style scoped>

</style>