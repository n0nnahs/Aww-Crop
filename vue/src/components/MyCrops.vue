<template>
  <div class="my-crops">
    <h2 id="pineapples">My Crops</h2>
    <div id="labels">
      <h3 id="icon">🥒 🥦 🥬</h3>
      <h3 id="carp">Crop</h3>
      <h3 id="amount">Planted</h3>
      <h3 id="yield">Harvest</h3>
    </div>
    <div id="crop-list">
        <crop v-for="crop in crops" v-bind:crop="crops" v-bind:key="crop.name"></crop>
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
    methods: {
        getCrops() {
          CropService.listAllCropsForUser(this.$store.state.user.id).then(response => {
          this.crops = response.data;
          });
        }
    }
};
</script>

<style>

.my-crops{
  margin: 20px;
  padding: 10px; 
  color: white;
  background-color:	 #a53b58;
  border-radius: 10px;
  height: 100vh;
}
#pineapples{
  font-size: 32px !important;
  font-weight: bold !important;
  text-align: center;
  color: white;
  background-color: #fe6f15;
  padding: 10px;
  border-radius: 10px;
}
#labels{
  display: grid;
  grid-template-columns:1fr 1fr 1fr 1fr;
  grid-template-areas:
    "icon carp amount yield";
  margin-top: 10px;
  padding: 5px;
  padding-right: 10px;
  background-color: white;
  color: #fe6f15;
  border-radius: 10px;
}
#icon{
  grid-area: icon;
  text-align: center;
  font-size: 16px !important;
  font-weight: bold !important;
  padding-top: 5px;
}
#carp{
  grid-area: carp;
  text-align: center;
  font-size: 20px !important;
  font-weight: bold !important;
}
#amount{
  grid-area: amount;
  text-align: center;
  font-size: 20px !important;
  font-weight: bold !important;
}
#yield{
  grid-area: yield;
  text-align: right;
  font-size: 20px !important;
  font-weight: bold !important;
}

</style>