<template>
    <div>
        <b-navbar toggleable="lg" type="dark" variant="primary">
            <b-navbar-brand :to="{name:'HomeBoards'}">Like trello</b-navbar-brand>

            <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

            <b-collapse id="nav-collapse" is-nav v-if="!isRegisterLogin">
                <b-navbar-nav>
                    <b-nav-item :to="{ name: 'HomeBoards' }" exact exact-active-class="active">{{lang['home']}}</b-nav-item>
                    <b-nav-item :to="{ name: 'About' }" exact exact-active-class="active">{{lang['about']}}</b-nav-item>
                </b-navbar-nav>

                <b-navbar-nav class="ml-auto">
                    <b-nav-form class="form-in">
                        <b-form-input size="sm" class="mr-sm-2" :placeholder="lang['placeholderSearchNavbar']"></b-form-input>
                        <b-button size="sm" class="my-2 my-sm-0" type="submit">{{lang['search']}}</b-button>
                    </b-nav-form>

                    <b-nav-item-dropdown :text="lang['lang']" right>
                        <b-dropdown-item @click="selectedLang='en'" :active="selectedLang==='en'">EN</b-dropdown-item>
                        <b-dropdown-item @click="selectedLang='ru'" :active="selectedLang==='ru'">RU</b-dropdown-item>
                    </b-nav-item-dropdown>

                    <b-nav-item-dropdown right>
                        <template #button-content>
                            <b-icon-emoji-sunglasses></b-icon-emoji-sunglasses>
                        </template>
                        <b-dropdown-item href="#">{{lang['profile']}}</b-dropdown-item>
                        <b-dropdown-item href="#">{{lang['singOut']}}</b-dropdown-item>
                    </b-nav-item-dropdown>
                </b-navbar-nav>
            </b-collapse>
        </b-navbar>
    </div>
</template>

<script>
import {mapGetters, mapMutations} from "vuex";

export default {
    name: "Navbar",
    computed:{
        isRegisterLogin(){
          return this.$route.name.includes("Auth");
        },
        lang(){
            return this.getLang;
        },
        selectedLang:{
            get(){
                return this.getSelectedLang;
            },
            set(value){
                this.setSelectedLang(value)
            }
        },
        ...mapGetters({
            'getLang':"languageModule/getLang",
            'getSelectedLang':"languageModule/getSelectedLang",
        })
    },
    methods:{

        ...mapMutations({
            'goTo':'routerModule/goTo',
            'setSelectedLang':'languageModule/setSelectedLang'
        })
    }
}
</script>

<style scoped>

</style>