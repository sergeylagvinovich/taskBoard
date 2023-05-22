<template>
    <div class="container-fluid">
        <b-skeleton-wrapper :loading="loading">
            <template #loading>
                <div class="text-center" style="height: 60vh">
                    <b-spinner variant="primary" label="Text Centered"></b-spinner>
                </div>
            </template>
            <div class="row">
                <MemberList :members="members"/>
            </div>
        </b-skeleton-wrapper>
    </div>
</template>

<script>
import {mapActions, mapGetters} from "vuex";
import Board from "../../../Home/Boards/Board.vue";
import MemberList from "./MemberList.vue";

export default {
    name: "GroupUsers",
    components: {MemberList, Board},
    data(){
        return {
            loading: false,
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
    mounted() {
        this.init()
    },
    methods: {
        ...mapActions({
          'fetchUsers':'GroupsModule/fetchGroupUsersByUUID'
        }),
        async init() {
           this.loading = true;
           this.members = await this.fetchUsers(this.$route.params.id);
           this.loading = false;
        },
    }
}
</script>

<style scoped>

</style>