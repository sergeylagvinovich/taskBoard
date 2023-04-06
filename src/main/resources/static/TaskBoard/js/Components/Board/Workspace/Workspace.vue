<template>
    <div class="container-fluid">
        <b-skeleton-wrapper :loading="loading">
            <template #loading>
                <div class="text-center" style="height: 90vh">
                    <b-spinner variant="primary" label="Text Centered"></b-spinner>
                </div>
            </template>
            <div class="row">
                <div class="col-12" style="border: 1px solid black">
                    Я доска
                </div>
            </div>
        </b-skeleton-wrapper>
    </div>
</template>

<script>


export default {
    name: "Workspace",
    components: {},
    data(){
        return{
            loading: false,
            loadingTime: 0,
            maxLoadingTime: 3,
        }
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

</style>