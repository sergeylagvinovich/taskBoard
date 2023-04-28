<template>
    <!-- TODO:: Изменить id на тот который будет приходить для группы-->
    <div class="row">
        <div class="col-12 mb-3 pr-0">
            <div class="boardGroup row bg-primary align-items-center ">
                <div class="col-6 mx-auto">
                    <label class="font-weight-bold pointer" @click="goTo({name:'GroupBoards',params:{id:group.id}})" style="color: white">{{ group.name }}</label>
                </div>
                <div class="col-6 text-right mx-auto" style="color: white; font-size: 20px">
                    <span
                        class="pointer pr-2"
                        :id="group.id+'-'+'group-board-window-dock'"
                        @click="goTo({name:'GroupBoards',params:{id:1}})"
                        v-on:mouseover="tooltip='group-board-window-dock'"
                        v-on:mouseleave="tooltip=null"
                    >
                        <b-icon-window-dock/>
                    </span>
                    <span
                        class="pointer pr-2"
                        :id="group.id+'-'+'group-board-person'"
                        @click="goTo({name:'GroupUsers',params:{id:1}})"
                        v-on:mouseover="tooltip='group-board-person'"
                        v-on:mouseleave="tooltip=null"
                    >
                        <b-icon-person />
                    </span>
                    <span
                        class="pointer pr-2"
                        :id="group.id+'-'+'group-board-wrench'"
                        @click="goTo({name:'GroupSettings',params:{id:1}})"
                        v-on:mouseover="tooltip='group-board-wrench'"
                        v-on:mouseleave="tooltip=null"
                    >
                        <b-icon-tools/>
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
                    <b-tooltip :target="group.id+'-'+tooltip" placement="top" triggers="hover" v-if="tooltip">
                        {{lang[tooltip]}}
                    </b-tooltip>
                </div>
            </div>
        </div>
        <b-collapse :id="group.id+'-boards-collapse'" class="col-12 ">
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
                <div class="col-3 pr-0" v-for="(item,itemIndex) in group.boards" :key="itemIndex">
                    <board :board="item" :key="itemIndex"></board>
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
            'goTo':'routerModule/goToWithParams',
        })
    }

}
</script>

<style scoped>

</style>