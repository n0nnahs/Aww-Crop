<template>
  <div class="my-crops">
    <h2 id="pineapples">My Crops</h2>
    <div id="crop-list">
        <crop v-for="crop in crops" v-bind:crop="crop" v-bind:key="crop.name"/>
    </div>
  </div>
</template>

<script>
import CropService from '../services/CropService';
import Crop from '@/components/Crop.vue';

export default {
    name: 'my-crops',
    components: {
        Crop
    },
    data(){
      return{
      crops: [],
      }
    },
created() {
    CropService.listAllCropsForUser(this.$store.state.user.id).then(response => {
      this.crops = response.data;
    });
  }
};
</script>

<style>


#pineapples{
  font-size: 32px !important;
  font-weight: bold !important;
  text-align: center;
  color: #b24747;
  border-width: 5px;
  border-bottom-width: 0px;
  border-color: #53856d;
  border-style:solid;
  background-color: #f9cece;
  padding: 10px;
  margin-top: 10px !important;
  margin-bottom: 0px !important;
}
#crop-list{
  margin-top:0px;
  padding: 10px; 
  color: #b24747;
  background-color:	#ffeeb9;
  border-width: 5px;
  border-color: #53856d;
  border-style:solid;
  height: 100vh;
}

</style>