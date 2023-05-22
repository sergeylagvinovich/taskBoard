import {mapGetters} from "vuex";
export default {
    computed:{
        ...mapGetters({
            'group':"GroupsModule/getGroup",
        }),
        canEdit(){
            return this.group?.role === "ADMIN"

        }
    },
}