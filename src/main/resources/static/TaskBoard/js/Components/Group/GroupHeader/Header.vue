<template>
    <div class="row mb-3" style="min-height: 150px">
        <div class="col-6" v-show="!edit">
            <p class="mb-0"><label class="font-weight-bold">Name group</label> <b-icon-pencil class="pointer" @click="edit=true"/></p>
            <p class="mb-0" style="font-size: 14px; color: rgb(94, 108, 132)"><label class="font-weight-bold">URL site</label></p>
            <p class="mb-0" style="font-size: 14px; color: rgb(94, 108, 132)"><label class="font-weight-bold">Описание</label></p>
        </div>
        <div class="col-6" v-show="edit">
            <b-form>
                <b-form-group
                    id="input-group-1"
                    label="Название"
                    label-for="input-1"
                    description="Придумайте название группы"
                >
                    <b-form-input
                        id="input-1"
                        type="text"
                        placeholder="Введите название"
                        required
                    ></b-form-input>
                </b-form-group>

                <b-form-group id="input-group-2" label="Краткое название" label-for="input-2">
                    <b-form-input
                        id="input-2"
                        placeholder="Введите краткое название"
                        required
                    ></b-form-input>
                </b-form-group>

                <b-form-group id="input-group-3" label="Сайт(необязательно)" label-for="input-3">
                    <b-form-input
                        id="input-3"
                        placeholder=""
                    ></b-form-input>
                </b-form-group>

                <b-form-group id="input-group-3" label="Описание" label-for="input-4">
                    <b-textarea
                        id="input-4"
                        placeholder="Описание группы"
                    >
                    </b-textarea>
                </b-form-group>
                <b-button type="submit" @click.prevent="edit=false"  variant="primary">Сохранить</b-button>
                <b-button type="reset" @click.prevent="edit=false" variant="danger">Отмена</b-button>
            </b-form>
        </div>
        <div class="col-6 text-right pr-0">
            <b-button variant="primary" class="m-auto"><b-icon-plus-circle/> Пригласите пользователей в рабочее пространство</b-button>
        </div>
    </div>
</template>

<script>
export default {
    name: "Header",
    data(){
        return{
            edit:false
        }
    }
}
</script>

<style scoped>

</style>