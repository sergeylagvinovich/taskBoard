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
                            <p>Все участники рабочего пространства могут создавать публичные доски.</p>

                            <p>Все участники рабочего пространства могут создавать доски, доступные для него.</p>

                            <p>Все участники рабочего пространства могут создавать приватные доски.</p>
                        </div>
                        <div class="col-2 mx-auto">
                            <button class="btn btn-outline-primary">Изменить</button>
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
</style>