<template>
  <div class="home">
    <h1>My Garden</h1>
    <div id="home-grid">
      <div id="plots">
        <active-plots></active-plots>
        <button id="add-new-plot-button">Add New Plot</button>
        <inactive-plots></inactive-plots>
      </div>
      <my-crops id="my-crops"></my-crops>
    </div>
  </div>
</template>

<script>
import MyCrops from '@/components/MyCrops.vue';
import ActivePlots from '../components/ActivePlots.vue';
import InactivePlots from '../components/InactivePlots.vue';

export default {
  name: "home",
  components: {
        MyCrops,
        ActivePlots,
        InactivePlots, 
    },
}

</script>

<style>
  
#home-grid {
  background-color: #4e2409;
  display: grid;
  column-gap: 50px;
  grid-template-columns:1fr 1fr;
  grid-template-areas:
    "plots my-crops";
}

#plots {
  grid-area: plots;
}

#add-new-plot-button {
  display: block;
  width: 100%;
  margin: 20px;
  font-size: 15px;
  align-content: bottom;
}

#add-new-plot-button:hover {
  display: block;
  width: 100%;
  margin: 20px;
  font-size: 15px;
  align-content: bottom;
  color: white;
  background-color: #83a126;
}

#my-crops{
  grid-area: my-crops;
}

.home {
  padding: 20px;
  background-color: #4e2409;
}

</style>
