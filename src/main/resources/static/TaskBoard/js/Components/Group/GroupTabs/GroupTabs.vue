<template>
    <b-tabs fill>
        <b-tab :title="lang['boards']" @click="()=>{activeTab = 'GroupBoards'; goTo('GroupBoards');}" :active="activeTab==='GroupBoards'"></b-tab>
        <b-tab :title="lang['users']" @click="()=>{activeTab = 'GroupUsers'; goTo('GroupUsers');}" :active="activeTab==='GroupUsers'"></b-tab>
        <b-tab :title="lang['settings']" @click="()=>{activeTab = 'GroupSettings'; goTo('GroupSettings');}" :active="activeTab==='GroupSettings'"></b-tab>
    </b-tabs>
</template>

<script>
import {mapGetters, mapMutations} from "vuex";

export default {
    name: "GroupTabs",
    data(){
        return{
            activeTab:'GroupBoards'
        }
    },
    computed: {
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