<template>
  <div>
    <div class="container" id="details-list">
    </div>
  </div>
</template>

<script>
import CropDetailService from "../services/CropDetailService"

export default {
  name: "crop-details-list",
  data() {
    return {
      crops: []
    };
  },
  methods: {
  viewCropDetails(name) {
    this.$router.push(`/crop-details/${name}`);
    }
  },
  created() {
    CropDetailService.list().then((response) => {
      this.crops = response.data;
    });
  }
}
</script>

<style scoped>

</style>