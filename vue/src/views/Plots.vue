<template>
  <div id="plot-page">
    <h1 id="my-plot">
      <i class="fas fa-seedling"></i>
      My Plot
      <i class="fas fa-seedling"></i>
    </h1>
    <div id="plots-body-grid">
      <div id="plot-visual">
        <plot-grid></plot-grid>
      </div>
      <div id="notes-area">
        <notes></notes>
      </div>
    </div>
  </div>
</template>

<script>
import plotGrid from "../components/PlotGrid";
import Notes from "../components/Notes.vue" 

export default {
  components: { 
    plotGrid,
    Notes
  },
}
</script>

<style scoped>

#plot-page {
  padding: 0 20px 20px 20px;
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
  padding-bottom: 10px;
  padding-top: 10px;
  background-color:#ba7331;
  border-radius: 3px;
}
#plot-visual {
  grid-area: plot-visual;
  margin-top: 10px;
  background-color:#4e2409;
}
#notes-area{
  grid-area: notes-area;
  margin-top: 10px;
}


</style>