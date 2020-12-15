<template>
  <div id="details-container">
    <h2 id="crop-name-h2">{{ crop.name }}</h2>
    <textarea v-model="crop" />
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
      this.crop.name = response.data.data.attributes.name;
      this.crop.description = response.data.data.attributes.description;
    });
  }
};
</script>

<style scoped>
textarea {
  width: 100%;
  height: 300px;
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
</style>
