<template>
    <span>
      <div class="sidebar-line">
            <b-icon-arrow-right-circle class="sidebar-button pointer h5" v-b-toggle.sidebar-1/>
      </div>
       <b-sidebar id="sidebar-1" title="Sidebar" shadow>
            <div class="px-3 py-2">
                <p>
                    Cras mattis consectetur purus sit amet fermentum. Cras justo odio, dapibus ac facilisis
                    in, egestas eget quam. Morbi leo risus, porta ac consectetur ac, vestibulum at eros.
                </p>
                <b-img src="https://picsum.photos/500/500/?image=54" fluid thumbnail></b-img>
            </div>
        </b-sidebar>
    </span>
</template>

<script>
export default {
    name: "GroupSidebar"
}
</script>

<style scoped>
.sidebar-line{
    position: absolute;
    left: -380px;
    height: 90vh;
    border-right: 1px solid rgba(0,0,0,.125);
}
.sidebar-button{
    position: absolute;
    left: -9px;
    z-index: 1;
    color: rgb(94, 108, 132);
    background-color: white;
    top: 18px;
}
</style>