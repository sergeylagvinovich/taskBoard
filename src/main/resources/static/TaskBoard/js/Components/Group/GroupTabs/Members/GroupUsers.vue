<template>
    <div class="container-fluid">
        <b-skeleton-wrapper :loading="loading">
            <template #loading>
                <div class="text-center" style="height: 60vh">
                    <b-spinner variant="primary" label="Text Centered"></b-spinner>
                </div>
            </template>
            <div class="row">
                <MemberList :members="memberList"/>
            </div>
        </b-skeleton-wrapper>
    </div>
</template>

<script>
import {mapGetters} from "vuex";
import Board from "../../../Home/Boards/Board.vue";
import MemberList from "./MemberList.vue";

export default {
    name: "GroupUsers",
    components: {MemberList, Board},
    data(){
        return {
            loading: false,
            loadingTime: 0,
            maxLoadingTime: 3,
            memberList:null,
            members: [
                {
                    id: 1,
                    name: "John Smith",
                    username: "johnsmith",
                    status:'Leave',
                    boards: [
                        { id: 1, name: "Board 1", role: "Администратор" },
                        { id: 2, name: "Board 2", role: "Участник" },
                        { id: 3, name: "Board 3", role: "Гость" },
                        { id: 4, name: "Board 4", role: "Гость" }
                    ],
                    groupRole: "Администратор"
                },
                {
                    id: 2,
                    name: "Jane Doe",
                    username: "janedoe",
                    status:'Blocked',
                    boards: [
                        { id: 5, name: "Board 5", role: "Администратор" },
                        { id: 6, name: "Board 6", role: "Участник" },
                    ],
                    groupRole: "Участник"
                },
                {
                    id: 3,
                    name: "Bob Johnson",
                    username: "bobjohnson",
                    status:'Active',
                    boards: [
                        { id: 7, name: "Board 7", role: "Участник" },
                    ],
                    groupRole: "Администратор"
                },
            ],
        }
    },
    computed: {
        ...mapGetters({
            'getLang':'languageModule/getLang'
        }),
        lang(){
            return this.getLang;
        },
    },
    watch: {
        loading(newValue, oldValue) {
            if (newValue !== oldValue) {
                this.clearLoadingTimeInterval()

                if (newValue) {
                    this.$_loadingTimeInterval = setInterval(() => {
                        this.loadingTime++
                    }, 1000)
                }
            }
        },
        loadingTime(newValue, oldValue) {
            if (newValue !== oldValue) {
                if (newValue === this.maxLoadingTime) {
                    this.loading = false
                    this.memberList = this.members
                }
            }
        }
    },
    created() {
        this.$_loadingTimeInterval = null
    },
    mounted() {
        this.startLoading()
    },
    methods: {
        clearLoadingTimeInterval() {
            clearInterval(this.$_loadingTimeInterval)
            this.$_loadingTimeInterval = null
        },
        startLoading() {
            this.loading = true
            this.loadingTime = 0
        }
    }
}
</script>

<style scoped>

</style>