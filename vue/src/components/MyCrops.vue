<template>
  <div class="my-crops">
    <h2 id="pineapples">My Crops</h2>
    <div id="labels">
      <h3 id="icon">
        <i class="fas fa-seedling"></i>
      </h3>
      <h3 id="carp">Crop</h3>
      <h3 id="amount">Planted</h3>
      <h3 id="yield">Harvest</h3>
    </div>
    <div id="crop-list">
        <crop v-for="crop in $store.state.crops" v-bind:crop="crop" v-bind:key="crop.name"></crop>
    </div>
  </div>
</template>

<script>
import CropService from '../services/CropService';
import Crop from '@/components/Crop.vue';

export default {
    name: 'my-crops',
    created () {
      CropService.listAllCropsForUser(this.$store.state.user.id).then(response => {
        this.$store.commit("SET_CROPS", response.data);
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
.my-crops{
  color: white;
  background-color: #a53b58;
  border-radius: 3px;
}
#pineapples{
  font-size: 32px !important;
  text-align: center;
  color: white;
  background-color: #fe6f15;
  padding: 10px;
  border-radius: 3px;
}
#labels{
  display: grid;
  grid-template-columns:1fr 2fr 2fr 2fr;
  grid-template-areas:
    "icon carp amount yield";
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
#carp{
  grid-area: carp;
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
  border-radius: 10px;
  color:white;
}

</style>