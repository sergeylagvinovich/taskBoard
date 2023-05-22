<template>
    <div class="container-fluid">
        <b-skeleton-wrapper :loading="loading">
            <template #loading>
                <div class="text-center" style="height: 60vh">
                    <b-spinner variant="primary" label="Text Centered"></b-spinner>
                </div>
            </template>
            <div class="row">
                <div class="col-12">
                    <p style="color: #5e6c84; font-weight: bold"><b-icon-clock-history/> {{lang['recently_viewed']}}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-12 mb-3">
                    <div class="row">
                        <div class="col-3 pr-0" v-for="(item,itemIndex) in historyBoards" :key="itemIndex">
                            <board :board="item" :key="itemIndex"></board>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <p style="color: #5e6c84; font-weight: bold; text-transform: uppercase">{{ lang['boards'] }}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-12 mb-3">
                    <div class="row">
                        <div class="col-3 pr-0" v-if="canEdit">
                            <div class="boardCardAdd pointer" style="height: 125px; max-width: 225px; max-height: 125px; width: 100%;">
                                <div>
                                    <label class="col-form-label">{{lang['addBoard']}}</label>
                                </div>
                                <div style="font-size: 30px">
                                    <b-icon-plus-circle style="color: black"></b-icon-plus-circle>
                                </div>
                            </div>
                        </div>
                        <div class="col-3 pr-0" v-for="(item,itemIndex) in boards" :key="itemIndex">
                            <board :board="item" :key="itemIndex"></board>
                        </div>
                    </div>
                </div>
            </div>
        </b-skeleton-wrapper>
    </div>
</template>

<script>
import BoardGroup from "../../../Home/Boards/BoardGroup.vue";
import Board from "../../../Home/Boards/Board.vue";
import {mapActions, mapGetters} from "vuex";
import groups from "../../../Home/Groups/Groups.vue";
import groupMixin from "../../../../../../js/modules/Mixins/groupMixin";

export default {
    name: "GroupBoards",
    components: {Board, BoardGroup},
    mixins:[groupMixin],
    data(){
        return{
            loading: false,
            expand:false,
            boards:[],
            historyBoards:[
                {
                    name:'Доска 1'
                },
                {
                    name:'Доска 2'
                },
                {
                    name:'Доска 3'
                },
                {
                    name:'Доска 4'
                },
            ],
        }
    },
    computed: {
        ...mapGetters({
            'getLang':'languageModule/getLang',
        }),
        lang(){
            return this.getLang;
        },
        groups() {
            return groups
        }
    },
    watch: {
    },
    mounted() {
        this.init()
    },
    methods: {
        ...mapActions({
            "fetchBoards":"BoardsModule/fetchBoardsByGroupUUID",
        }),
        async init() {
            this.loading = true;
            this.boards = await this.fetchBoards(this.$route.params.id);
            this.loading = false;
        }
    }
}
</script>

<style scoped>

</style>