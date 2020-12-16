<template>
  <div id="plot-page">
    <h1 id="my-plot">
      <i class="fas fa-seedling"></i>
        {{this.myPlot.name}}
      <i class="fas fa-seedling"></i>
    </h1>
    <div id="plots-body-grid">
      <div id="plot-visual">
        <plot-grid id="sean"></plot-grid>
      </div>
    </div>
    <div id="everything-else">
      <div id="plot-crops">
        <plot-crop></plot-crop>
      </div>
      <div id="notes-area">
        <notes></notes>
      </div>
      <div id="notes-area">
        <shopping-list></shopping-list>
      </div>
    </div>
  </div>
</template>

<script>
import plotGrid from "../components/PlotGrid";
import plotCrop from "../components/PlotCrop";
import Notes from "../components/Notes.vue";
import shoppingList from "../components/ShoppingList.vue";
import plotService from "../services/PlotService";

export default {
  components: { 
    plotGrid,
    plotCrop,
    Notes,
    shoppingList
  },
  data(){
    return {
      myPlot: {
        id: "",
        name: "",
        length: "",
        width: "",
        active: ""
      }
    }
  },
  methods: {

    getPlotName(){
     let urlPlotId = this.$route.params.plotId;
            plotService.getPlotById(urlPlotId)
                .then(response => {
                    if(response.status === 200){      
                        this.$store.commit("SET_PLOT", response.data);
                        this.myPlot.name = this.$store.state.plot.name;
                    }
                })     
                .catch(error => {
                    console.log(error.status)
                });
          }

  },
  created(){
    this.getPlotName();
  }
}
</script>

<style scoped>

#plot-page {
  padding: 0 20px 20px 20px;
  background-color: #4e2409;
  display:grid;
  grid-template-columns:1fr 1fr;
  column-gap: 20px;
  grid-template-areas:
    "my-plot my-plot"
    "plots-body-grid everything-else";
}
#my-plot{
  grid-area: my-plot;
  text-align: center;
  padding-bottom: 10px;
  padding-top: 10px;
  background-color:#ba7331;
  border-radius: 3px;
}
#plots-body-grid {
  grid-area: plots-body-grid;
  background-color: #a53b58;
  margin-top:10px;
}
#plot-visual {
  background-color:#4e2409;
}
#everything-else{
  grid-area:everything-else;
}
#notes-area{
  grid-area: notes-area;
  margin-top: 10px;
}


</style>