<template>
  <div class="plot-crop-container">
    <h2 id="crops-planted-h2">
      Crops in This Plot</h2>
    <div id="labels">
      <h3 id="icon">
        <i class="fas fa-seedling"></i>
      </h3>
      <h3 id="crop-name">Crop</h3>
      <h3 id="amount">Planted</h3>
      <h3 id="square">Plants/ft&sup2;</h3>
      <h3 id="yield">Harvest</h3>
    </div>
    <div id="crop-list" v-for="crop in cropsForPlot" v-bind:key="crop">
      <router-link style="text-decoration: none;" :to="{ name: 'crop-details', params: { name: crop.api_name }}" >
         <crop  v-bind:crop="crop" v-bind:key="crop.name"></crop>
      </router-link>
    </div>
  </div>
</template>

<script>
import CropService from '../services/CropService';
import Crop from '@/components/Crop.vue';

export default {
    name: 'my-crops',
    data(){
      return{
        cropsForPlot:[],
      }
    },
    created () {
      CropService.listCropsForOnePlot(this.$route.params.plotId).then(response => {
        this.cropsForPlot = response.data;
      });
    },
    components: {
        Crop
    },
    methods: {
      getCrops() {
        
      }
    }
};
</script>

<style scoped>

#labels h3{
  padding: 0px;
  margin: 0px;
}
.plot-crop-container{
  color: white;
  background-color: #a53b58;
  border-radius: 3px;
  padding-bottom:5px;
}
#crops-planted-h2{
  font-size: 32px !important;
  text-align: center;
  color: white;
  background-color: #fe6f15;
  padding: 10px;
  border-radius: 3px;
}
#labels{
  display: grid;
  grid-template-columns:1fr 2fr 2fr 2fr 2fr;
  grid-template-areas:
    "icon carp amount square yield";
  margin-top: 10px;
  margin-left: 10px;
  margin-right: 10px;
  padding: 5px;
  padding-right: 10px;
  background-color: white;
  color: #fe6f15;
  border-radius: 3px;
  margin-bottom: 0px !important;
  align-items: center;
}
#icon{
  grid-area: icon;
  text-align: center;
  font-size: 25px !important;
  font-weight: bold !important;
  padding-top: 5px;
  padding-left:30px;
  color: #83a126;
}
#crop-name{
  grid-area: carp;
  text-align: center;
  font-size: 20px !important;
  font-weight: bold !important;
  padding-left: 20px;
}
#square{
  grid-area: square;
  text-align: center;
  font-size: 20px !important;
  font-weight: bold !important;
  padding-left: 20px;
}
#amount{
  grid-area: amount;
  text-align: center;
  font-size: 20px !important;
  font-weight: bold !important;
  padding-left: 15px;
}
#yield{
  grid-area: yield;
  text-align: center;
  font-size: 20px !important;
  font-weight: bold !important;
}
#crop-list{
  margin-top: 0px;
  border-radius: 3px;
  color:white;
}

</style>