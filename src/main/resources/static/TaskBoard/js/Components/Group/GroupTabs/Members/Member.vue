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
                   @click="$root.$emit('bv::hide::popover');popoverRolesShow=true;"
                   :id="member.id+'-member-role'"
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
            >
              <b-icon-dash-circle-fill style="color: #dc3545"/>
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
                            <select class="form-control">
                                <option value="Admin">Администратор</option>
                                <option value="Admin">Участник</option>
                            </select>
                        </div>
                    </div>
                    <div class="row align-items-center">
                        <div class="col-12 mx-auto text-center">
                            <button class="btn btn-success">Сохранить</button>
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
export default {
    name: "Member",
    props: {
        member: {
            type: Object
        }
    },
    data(){
        return {
            popoverRolesShow: false,
            popoverMemberBoardsShow:false,
        }
    },
    computed: {
        variantStatus() {
            if (this.member.status === 'BLOCKED' || this.member.status === 'LEAVE') {
                return 'danger';
            }
            return 'success';
        }
    }
}
</script>

<style scoped>

</style>