<template>
    <div class="member row bg-transparent mb-3 align-items-center mt-2 mb-2">
        <div class="col-3 mx-auto">
            <label class="font-weight-bold mb-0" style="color: black">{{ member.firstName }}</label>
            <br>
            <label class="font-weight-bold mb-0" style="font-size: 14px;color: rgb(94, 108, 132)">{{
                member.email
                }}</label>
        </div>
        <div class="col-3 mx-auto text-center">
            <b-badge class="h-75" :variant="variantStatus">{{ member.status }}</b-badge>
        </div>
        <div class="col-6 text-right mx-auto" style="color: #0069d9; font-size: 20px">
            <span
                   class="pr-2 btn btn-outline-primary"
                   style="min-width: 150px"
                   @click="editRole"
                   :id="member.userUUID+'-member-role'"
           >
              {{ member.role }}
            </span>
            <span
                    class="pr-2 btn btn-outline-primary"
                    :id="member.userUUID+'-member-boards'"
                    @click="$root.$emit('bv::hide::popover');popoverMemberBoardsShow=true;"
                    style="min-width: 150px"
            >
              Доски ({{ member.boards.length }})
            </span>
            <span
                    class="pointer pr-2"
                    v-if="canEdit"
                    @click="saveUser(member.role,member.status==='BLOCKED'?'ACTIVE':'BLOCKED')"
            >
              <b-icon-dash-circle-fill v-show="member.status !== 'BLOCKED'" class="text-danger"/>
              <b-icon-check-circle-fill v-show="member.status === 'BLOCKED'" class="text-primary"/>
            </span>
            <b-popover
                    placement="bottom"
                    triggers="focus"
                    :show.sync="popoverRolesShow"
                    :ref="member.userUUID+'-member-role'"
                    custom-class="popoverForm"
                    :target="member.userUUID+'-member-role'"
            >
                <template #title>
                    Права рабочего пространства
                </template>
                <div class="container">
                    <div class="row align-items-center mb-2">
                        <div class="col-12 mx-auto text-center">
                            <select class="form-control" v-model="role">
                                <option value="ADMIN">Администратор</option>
                                <option value="PARTICIPANT">Участник</option>
                                <option value="GUEST">Гость</option>
                            </select>
                        </div>
                    </div>
                    <div class="row align-items-center">
                        <div class="col-12 mx-auto text-center">
                            <button class="btn btn-primary" @click="saveUser(role,member.status)">Сохранить</button>
                            <button class="btn btn-outline-danger" @click="popoverRolesShow=!popoverRolesShow">Закрыть</button>
                        </div>
                    </div>
                </div>
            </b-popover>
            <b-popover placement="bottom"
                       triggers="focus"
                       :show.sync="popoverMemberBoardsShow"
                       :ref="member.userUUID+'-member-boards'"
                       custom-class="popoverForm"
                       :target="member.userUUID+'-member-boards'"
            >
                <template #title>
                    Доски рабочего пространства
                </template>
                <div class="container">
                    <div v-for="(board, boardIndex) in member.boards" :key="boardIndex" class="row list align-items-center pointer">
                        <div class="col-12 mx-auto text-center">{{ board.name }}</div>
                    </div>
                    <div class="row align-items-center pointer mt-2">
                        <div class="col-12 mx-auto text-center">
                            <button class="btn btn-outline-danger" @click="popoverMemberBoardsShow=!popoverMemberBoardsShow">Закрыть</button>
                        </div>
                    </div>
                </div>
            </b-popover>
        </div>
    </div>
</template>

<script>
import groupMixin from "../../../../../../js/modules/Mixins/groupMixin";
import {mapActions} from "vuex";

export default {
    name: "Member",
    mixins:[groupMixin],
    props: {
        member: {
            type: Object
        }
    },
    data(){
        return {
            role:null,
            popoverRolesShow: false,
            popoverMemberBoardsShow:false,
        }
    },
    computed: {
        variantStatus() {
            if (this.member.status === 'BLOCKED' || this.member.status === 'LEAVE') {
                return 'danger';
            }
            return 'primary';
        }
    },
    methods:{
        ...mapActions({
            'putUser':"GroupUserModule/saveUser"
        }),
        async saveUser(role, status){
            let data = {
                group_uuid:this.$route.params.id,
                user_uuid:this.member.userUUID,
                edit:{
                    roleGroup:role,
                    statusUser:status
                }
            }
            let result = await this.putUser(data);
            if(result){
                this.member.role = role;
                this.member.status = status;
                this.popoverRolesShow = false;
            }
        },
        editRole(){
            if(this.canEdit){
                this.$root.$emit('bv::hide::popover');
                this.popoverRolesShow=true;
                this.role = this.member.role
            }
        }
    }
}
</script>

<style scoped>

</style>