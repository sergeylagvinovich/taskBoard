<template>
    <b-tabs fill>
        <b-tab :title="lang['boards']" @click="goTo('GroupBoards')" :active="activeTab==='GroupBoards'"></b-tab>
        <b-tab :title="lang['users']" @click="goTo('GroupUsers')" :active="activeTab==='GroupUsers'"></b-tab>
        <b-tab :title="lang['settings']" @click="goTo('GroupSettings')" :active="activeTab==='GroupSettings'"></b-tab>
    </b-tabs>
</template>

<script>
import {mapGetters, mapMutations} from "vuex";

export default {
    name: "GroupTabs",
    data(){
        return{

        }
    },
    computed: {
        activeTab(){
            console.log(this.$route.name)
            return this.$route.name;
        },
        ...mapGetters({
            'getLang': 'languageModule/getLang'
        }),
        lang() {
            return this.getLang;
        },
    },
    methods:{
        ...mapMutations({
            'goTo':'routerModule/goTo',
        })
    }
}
</script>

<style scoped>

</style>