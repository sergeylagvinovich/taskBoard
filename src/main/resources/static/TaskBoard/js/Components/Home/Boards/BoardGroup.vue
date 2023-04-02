<template>
    <div class="row">
        <div class="col-12 mb-3 pr-0">
            <div class="boardGroup row bg-primary">
                <div class="col-6">
                    <label class="font-weight-bold pointer" @click="goTo('GroupBoards')" style="color: white">{{ group.name }}</label>
                </div>
                <div class="col-6 text-right" style="color: white; font-size: 20px">
                    <span
                        class="pointer pr-2"
                        :id="group.id+'-'+'group-board-window-dock'"
                        v-on:mouseover="tooltip='group-board-window-dock'"
                        v-on:mouseleave="tooltip=null"
                    >
                        <b-icon-window-dock/>
                    </span>
                    <span
                        class="pointer pr-2"
                        :id="group.id+'-'+'group-board-person'"
                        v-on:mouseover="tooltip='group-board-person'"
                        v-on:mouseleave="tooltip=null"
                    >
                        <b-icon-person />(2)
                    </span>
                    <span
                        class="pointer pr-2"
                        :id="group.id+'-'+'group-board-wrench'"
                        v-on:mouseover="tooltip='group-board-wrench'"
                        v-on:mouseleave="tooltip=null"
                    >
                        <b-icon-wrench/>
                    </span>
                    <span
                        class="pointer pr-2"
                        :id="expand?group.id+'-group-board-arrow-bar-up':group.id+'-group-board-arrow-bar-down'"
                        @click="expand=!expand"
                        v-b-toggle="group.id+'-boards-collapse'"
                        v-on:mouseover="tooltip=expand?'group-board-arrow-bar-up':'group-board-arrow-bar-down'"
                        v-on:mouseleave="tooltip=null"
                    >
                        <b-icon-arrow-bar-down v-show="expand"/>
                        <b-icon-arrow-bar-up v-show="!expand"/>
                    </span>
                    <b-tooltip :target="group.id+'-'+tooltip" placement="top" triggers="hover" v-if="tooltip!==null">
                        {{lang[tooltip]}}
                    </b-tooltip>
                </div>
            </div>
        </div>
        <b-collapse :id="group.id+'-boards-collapse'" class="col-12 ">
            <div class="row">
                <div class="col-3 pr-0" v-for="(item,itemIndex) in group.boards" :key="itemIndex">
                    <board :board="item" :key="itemIndex"></board>
                </div>
                <div class="col-3 pr-0" >
                    <div class="boardCardAdd pointer">
                        <div>
                            <label class="col-form-label">{{lang['addBoard']}}</label>
                        </div>
                        <div style="font-size: 30px">
                            <b-icon-plus-circle style="color: black"></b-icon-plus-circle>
                        </div>
                    </div>
                </div>
            </div>
         </b-collapse>
    </div>
</template>

<script>
import {mapGetters, mapMutations} from "vuex";
import Board from "./Board.vue";

export default {
    name: "BoardGroup",
    components: {Board},
    props:{
        group:{
            type:Object,
        }
    },
    data(){
        return{
            expand:false,
            tooltip:null,
        }
    },
    computed:{
        lang(){
            return this.getLang;
        },
        ...mapGetters({
            'getLang':"languageModule/getLang",
        })
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