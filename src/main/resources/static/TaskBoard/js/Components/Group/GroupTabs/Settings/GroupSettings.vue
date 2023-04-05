<template>
    <div class="container-fluid">
        <b-skeleton-wrapper :loading="loading">
            <template #loading>
                <div class="text-center" style="height: 60vh">
                    <b-spinner variant="primary" label="Text Centered"></b-spinner>
                </div>
            </template>
            <div class="row">
                <div class="col-12 sectionSettings">
                    <div class="row headerSetting">
                        <div class="col-12">
                            Ограничения участия в рабочем пространстве
                        </div>
                    </div>
                    <div class="row itemSetting align-items-center">
                        <div class="col-10">
                            В это рабочее пространство можно добавлять любых пользователей.
                        </div>
                        <div class="col-2 mx-auto">
                            <button class="btn btn-outline-primary">Изменить</button>
                        </div>
                    </div>
                </div>
                <div class="col-12 sectionSettings">
                    <div class="row headerSetting">
                        <div class="col-12">
                            Ограничения создания досок
                        </div>
                    </div>
                    <div class="row itemSetting align-items-center">
                        <div class="col-10">
                            <p>Все участники рабочего пространства могут создавать доски.</p>
                        </div>
                        <div class="col-2 mx-auto">
                            <button class="btn btn-outline-primary">Изменить</button>
                        </div>
                    </div>
                </div>
                <div class="col-12 sectionSettings">
                    <div class="row headerSetting">
                        <div class="col-12">
                            Ограничения на удаления досок
                        </div>
                    </div>
                    <div class="row itemSetting align-items-center">
                        <div class="col-10">
                            <p>Все участники рабочего пространства могут удалять доски.</p>
                        </div>
                        <div class="col-2 mx-auto">
                            <button class="btn btn-outline-primary">Изменить</button>
                        </div>
                    </div>
                </div>
                <div class="col-12 sectionSettings">
                    <div class="row headerSetting">
                        <div class="col-12">
                            Гостевой доступ к доске
                        </div>
                    </div>
                    <div class="row itemSetting align-items-center">
                        <div class="col-10">
                            <p>Отправлять и получать приглашения в доски этого рабочего пространства могут только его участники.</p>
                        </div>
                        <div class="col-2 mx-auto">
                            <button class="btn btn-outline-primary">Изменить</button>
                        </div>
                    </div>
                </div>
                <div class="col-12 sectionDelete">
                    <div class="row itemSetting align-items-end">
                        <div class="col-10">
                            <label class="text-danger pointer deleteLabel" style="text-decoration: underline">Удалить раболее пространство?</label>
                        </div>
                    </div>
                </div>
            </div>
        </b-skeleton-wrapper>
    </div>
</template>

<script>
import {mapGetters} from "vuex";

export default {
    name: "GroupSettings",
    components: {},
    data(){
        return{
            loading: false,
            loadingTime: 0,
            maxLoadingTime: 3,
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
.headerSetting{
    margin-bottom: 15px;
    font-size: 20px;
    font-weight: bold;
    border-bottom: 1px solid #e9ecef;
}
.itemSetting{
    font-size: 15px;

}
.sectionSettings{
    margin-bottom: 20px;
}
.sectionDelete{
    margin-top: 50px;
}
.deleteLabel:hover{
    color: black !important;
}
</style>