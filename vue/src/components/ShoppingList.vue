<template>
  <div class="shopping-list">
    <h2 id="pineapples">Need to buy:</h2>
    <div id="labels">
      <h3 id="icon">
        <i class="fas fa-seedling"></i>
      </h3>
      <h3 id="carp">Crop</h3>
      <h3 id="amount">Amount Needed</h3>
      <h3 id="cost">Approximate Cost</h3>
    </div>
    <div id="crop-list" v-for="crop in $store.state.crops" v-bind:key="crop">

         <shop-item  v-bind:crop="crop" v-bind:key="crop.name"></shop-item>

    </div>
  </div>
</template>

<script>
import CropService from '../services/CropService';
// import Crop from '@/components/Crop.vue';
import ShopItem from '@/components/ShopItem.vue';
// import ShopItem from './ShopItem.vue';

export default {
    name: 'shopping-list',
    created () {
      CropService.listAllCropsForUser(this.$store.state.user.id).then(response => {
        this.$store.commit("SET_CROPS", response.data);
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

#labels h3{
  padding: 0px;
  margin: 0px;
}
.shopping-list{
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
    "icon carp amount cost";
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
#cost{
  grid-area: cost;
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