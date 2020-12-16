<template>
  <div id="details-container">
    <h2 id="crop-name-h2">{{ crop.name }}</h2>
    <div id="details-grid">
      <div id="left-column">
        <img id="crop-image" :src="crop.main_image_path" />
      </div>
      <div id="right-column">
        <h5 v-bind="crop.description">{{ crop.description }}</h5>
        <h5 v-bind="crop.sun_requirements">SUN REQUIREMENTS: {{ crop.sun_requirements }}</h5>
        <h5 v-bind="crop.sowing_method">SOWING METHOD: {{ crop.sowing_method }}</h5>
      </div>
    </div>
  </div>
</template>

<script>
import CropDetailService from '../services/CropDetailService';

export default {
  name: 'crop-detail',
  data() {
    return {
      crop: Object
    };
  },
  created() {
    CropDetailService.get(this.$route.params.name).then((response) => {
      this.crop = response.data.data.attributes;
    });
  }
};
</script>

<style scoped>
#details-grid {
  display: grid;
  grid-template-columns:1fr 1fr;
  grid-template-areas:
    "left-column right-column";
}
#left-column {
  margin: 10px;
  text-align: center;
}
#right-column {
  margin: 10px;
}
h5 {
  background-color: #BA7331;
  border-radius: 3px;
  padding: 10px;
}

.back {
  margin-top: 20px;
}
#details-container{
  color: white;
  background-color: #a53b58;
  border-radius: 3px;
}
#crop-name-h2{
  font-size: 32px !important;
  text-align: center;
  color: white;
  background-color: #fe6f15;
  padding: 10px;
  border-radius: 3px;
}
#crop-image {
  max-width:100%;
  max-height: 300px;
  border-radius: 3px;
}
</style>
