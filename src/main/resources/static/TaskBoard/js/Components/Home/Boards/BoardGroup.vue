<template>
    <div class="row">
        <div class="col-12 mb-3">
            <div class="boardGroup row bg-primary align-items-center ">
                <div class="col-6 mx-auto">
                    <label class="font-weight-bold pointer" @click="goTo({name:'GroupBoards',params:{id:source.id}})" style="color: white">{{ source.name }}</label>
                </div>
                <div class="col-6 text-right mx-auto" style="color: white; font-size: 20px">
                    <span
                        class="pointer pr-2"
                        :id="source.id+'-'+'group-board-window-dock'"
                        @click="goTo({name:'GroupBoards',params:{id:source.id}})"
                        v-on:mouseover="tooltip='group-board-window-dock'"
                        v-on:mouseleave="tooltip=null"
                    >
                        <b-icon-window-dock/>
                    </span>
                    <span
                        class="pointer pr-2"
                        :id="source.id+'-'+'group-board-person'"
                        @click="goTo({name:'GroupUsers',params:{id:source.id}})"
                        v-on:mouseover="tooltip='group-board-person'"
                        v-on:mouseleave="tooltip=null"
                    >
                        <b-icon-person />
                    </span>
                    <span
                        class="pointer pr-2"
                        :id="source.id+'-'+'group-board-wrench'"
                        @click="goTo({name:'GroupSettings',params:{id:source.id}})"
                        v-on:mouseover="tooltip='group-board-wrench'"
                        v-on:mouseleave="tooltip=null"
                    >
                        <b-icon-tools/>
                    </span>
                    <span
                        class="pointer pr-2"
                        :id="expand?source.id+'-group-board-arrow-bar-up':source.id+'-group-board-arrow-bar-down'"
                        @click="expandValueChange"

                        v-on:mouseover="tooltip=expand?'group-board-arrow-bar-up':'group-board-arrow-bar-down'"
                        v-on:mouseleave="tooltip=null"
                    >
<!--                        v-b-toggle="source.id+'-boards-collapse'"-->
                        <b-icon-arrow-bar-down v-show="!expand"/>
                        <b-icon-arrow-bar-up v-show="expand"/>
                    </span>
                    <b-tooltip :target="source.id+'-'+tooltip" placement="top" triggers="hover" v-if="tooltip">
                        {{lang[tooltip]}}
                    </b-tooltip>
                </div>
            </div>
        </div>
        <b-collapse :visible="expand" :appear="false" :id="source.id+'-boards-collapse'" class="col-12 ">
            <div class="row">
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
                <div class="col-3 pr-0" v-for="(item,itemIndex) in source.boards" :key="itemIndex">
                    <board :board="item" :key="itemIndex"></board>
                </div>
            </div>
         </b-collapse>
    </div>
</template>

<script>
import {mapGetters, mapMutations} from "vuex";
import Board from "./Board.vue";
import mixins from "../../../../../js/modules/Mixins";

export default {
    mixins:[mixins],
    name: "BoardGroup",
    components: {Board},
    props:{
        source:{
            type:Object,
        }
    },
    data(){
        return{
            expand:false,
            tooltip:null,
        }
    },
    created() {
        this.expand = this.source.expand === undefined?false:this.source.expand;
    },
    mounted() {

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
            'goTo':'routerModule/goToWithParams',
        }),
        expandValueChange(){
            this.expand=!this.expand;
            this.dispatch('Boards', 'expandValueChange', this.source.id, this.expand);
        }
    }

}
</script>

<style scoped>

</style>