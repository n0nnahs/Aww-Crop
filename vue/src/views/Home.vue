<template>
  <div class="home">
    <h1 id=my-garden>
      <i class="fas fa-seedling"></i>
      My Garden
      <i class="fas fa-seedling"></i>
      </h1>
    <div id="home-grid">
      <div id="plots">
          <div id="aplots">
              <active-plots></active-plots>
          </div>

          <button id="add-new-plot-button">
                       <i class="fas fa-seedling"></i>
                       Add New Plot 
                       <i class="fas fa-seedling"></i>
          </button>
           
         <div id="iplots">
             <inactive-plots></inactive-plots>
          </div>
      </div>
      <my-crops id="my-crops"></my-crops>
    </div>
  </div>
</template>

<script>
import ActivePlots from '../components/ActivePlots.vue';
import MyCrops from '@/components/MyCrops.vue';
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

.home {
  padding: 20px;
  background-color: #4e2409;
}
#home-grid {
  background-color: #4e2409;
  display: grid;
  column-gap: 20px;
  grid-template-columns:1fr 1fr;
  grid-template-areas:
    "plots my-crops";
}
#my-garden{
  text-align: center;
  padding-bottom: 20px;
  padding-top: 20px;
  background-color:#ba7331;
  border-radius: 10px;
}
#plots {
  grid-area: plots;
  margin-top: 10px;
  background-color:#4e2409
}
#my-crops{
  grid-area: my-crops;
  margin-top: 10px;
}
#add-new-plot-button {
  grid-area: button;
  width: 100%;
  height: 65px;
  margin-bottom: 20px;
  margin-top: 20px;
  font-size: 32px;
  align-content: bottom;
  border-radius: 10px;
  text-align: center;
  padding: 10px;
  border-radius: 10px;
  color: #83a126;
  background-color: white;
}
#add-new-plot-button:hover {
  grid-area: button;
  width: 100%;
  height: 65px;
  margin-bottom: 20px;
  font-size: 32px;
  align-content: bottom;
  border-radius: 10px;
  text-align: center;
  padding: 10px;
  border-radius: 10px;
  color: white;
  background-color: #83a126;
}
</style>
