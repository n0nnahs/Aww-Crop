<template>
  <div id="plot-page">
    <h1 id="my-plot">
      <i class="fas fa-seedling"></i>
      My Plot
      <i class="fas fa-seedling"></i>
    </h1>
    <div id="plots-body-grid">
      <div id="plot-visual" >
        <plot-grid></plot-grid>
      </div>
      <div id="notes-area">
        <notes></notes>
        <my-crops></my-crops>
      </div>
    </div>
  </div>
</template>

<script>
import plotGrid from "../components/PlotGrid";
import Notes from "../components/Notes.vue" 
import MyCrops from '../components/MyCrops.vue';

export default {
  components: { 
    plotGrid,
    Notes,
    MyCrops
  },
  data(){
    return{
      isLoading: true
    }
  },
  created(){

    return this.isLoading
  }
}
</script>

<style scoped>

#plot-page {
  padding: 20px;
  background-color: #4e2409;
  
  
}
#plots-body-grid {
  background-color: #4e2409;
  display: grid;
  column-gap: 20px;
  grid-template-columns:1fr 1fr;
  grid-template-areas:
    "plot-visual notes-area";
  
}
#my-plot{
  text-align: center;
  padding-bottom: 20px;
  padding-top: 20px;
  background-color:#ba7331;
  border-radius: 3px;
}
#plot-visual {
  grid-area: plot-visual;
  margin-top: 10px;
  background-color:#a53b58;
  overflow: scroll;
  scrollbar-color: rgba(67, 184, 13, 0.8);
}
#notes-area{
  grid-area: notes-area;
  margin-top: 10px;
}


</style>