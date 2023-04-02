<template>
  <div class="row">
      <div class="col-12">
          <Header/>
      </div>
      <div class="col-12">
          <GroupTabs/>
      </div>
  </div>
</template>

<script>
import GroupTabs from "../GroupTabs/GroupTabs.vue";
import Header from "./Header.vue";

export default {
    name: "GroupHeader",
    components: {Header, GroupTabs}
}
</script>

<style scoped>

</style>