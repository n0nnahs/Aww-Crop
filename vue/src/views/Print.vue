<template>
  <div class="shopping-list">
    <div id="back-button">
      <button id="icecream" @click="$router.go(-1)">Go Back</button>
    </div>
    <h1 id=pineapples>
      <i class="fas fa-seedling" style="color: black"></i>
      My Shopping List
      <i class="fas fa-seedling" style="color: black"></i>
    </h1>
    <div id="labels">
      <h3 id="carp">Crop</h3>
      <h3 id="amount">Quantity</h3>
      <h3 id="cost">Cost</h3>
    </div>
    <div id="cropbox">
    <div id="crop-list" v-for="crop in cropsForPlot" v-bind:key="crop">
         <shop-item v-bind:crop="crop" v-bind:key="crop.name"></shop-item>
    </div>
    </div>
  </div>
</template>

<script>
import CropService from '../services/CropService';
import ShopItem from '@/components/ShopItem.vue';

export default {
    name: 'shopping-list',
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
        
        ShopItem
    },
    methods: {
      getCrops() {
        
      }
    }

};
</script>

<style scoped>
#app {
    background-color: white;
}
#labels h3{
  padding: 0px;
  margin: 0px;
}
.shopping-list{
  color: black;
  background-color: white;
  border-radius: 3px;
  height: 100vh;
}
#pineapples{
  font-size: 32px !important;
  text-align: center;
  color: black;
  background-color: white;
  padding: 10px;
  border-radius: 3px;
  margin-bottom: 50px;
}
#labels{
  display: grid;
  grid-template-columns:1fr 1fr 1fr;
  grid-template-areas:
    "carp amount cost";
  margin-top: 10px;
  margin-left: 10px;
  margin-right: 10px;
  padding: 5px;
  padding-right: 10px;
  background-color: white;
  color: black;
  border-radius: 3px 3px 0px 0px;
  margin-bottom: 0px !important;
  align-items: center;
}

#carp{
  grid-area: carp;
  text-align: center;
  font-size: 20px !important;
  font-weight: bold !important;
  margin-left: 40px!important;
}
#amount{
  grid-area: amount;
  text-align: center;
  font-size: 20px !important;
  font-weight: bold !important;
  margin-left: 23px !important;
}
#cost{
  grid-area: cost;
  text-align: center;
  font-size: 20px !important;
  font-weight: bold !important;
  margin-left: 10x !important;
}
#crop-list{
  margin-top: 0px;
  border-radius: 3px;
  color:black;
  background-color: white;
  border-bottom-style: solid;
  border-bottom-color: black;
  border-bottom-width: 1px;
}
#cropbox{
  border-style: solid;
  border-color: black;
  border-width: 1px;
  border-bottom: none;
  margin: 20px;
  margin-top: 10px;
}
#item {
  color:black;
  background-color: white;
}
button {
  margin: 10px;
  border-radius: 3px;
  align-self:center;
}
button:focus{
  outline:none;
}
#back-button {
  display: flex;
  justify-content: left;
}
#icecream{
  border-color:black;
  border-style: solid;
  border-width: 1px;
}
</style>