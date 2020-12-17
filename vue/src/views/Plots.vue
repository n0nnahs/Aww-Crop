<template>
  <div id="plot-page">
    <h1 id="my-plot">
      <i class="fas fa-seedling"></i>
        {{this.myPlot.name}}
      <i class="fas fa-seedling"></i>
    </h1>
    <div class="loading" v-if="isLoading">
        <img src="../assets/loadingPlant.gif" />
    </div>
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
          <button id="view-notes" v-on:click="toggleNotes">
            <i class="fas fa-seedling"></i>
              View Notes 
            <i class="fas fa-seedling"></i>
          </button><br/>
        <notes v-show="showNotes"></notes>
      </div>
      <div id="shopping-list">
        <shopping-list></shopping-list>
      </div>
    </div>
      <button id="back-button" @click="$router.go(-1)">
      <i class="fas fa-seedling"></i>
      Go Back
      <i class="fas fa-seedling"></i>
    </button>
  </div>
</template>

<script>
import plotGrid from "../components/PlotGrid";
import Notes from "../components/Notes.vue" 
import plotCrop from '../components/PlotCrop.vue';
import shoppingList from '../components/ShoppingList.vue';
import PlotService from "../services/PlotService";

export default {
  components: { 
    plotGrid,
    plotCrop,
    Notes,
    shoppingList
  },
  data(){
    return {
      isLoading: true,
      active:true,
      showNotes: false,
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
    getNotes(){
    PlotService.getNotes(this.$store.state.user.id).then(response => {
      this.$store.commit("SET_NOTES", response.data);
    });
    },
    getPlotName(){
     let urlPlotId = this.$route.params.plotId;
            PlotService.getPlotById(urlPlotId)
                .then(response => {
                    if(response.status === 200){      
                        this.$store.commit("SET_PLOT", response.data);
                        this.myPlot.name = this.$store.state.plot.name;
                    }
                })     
                .catch(error => {
                    console.log(error.status)
                });
          },

    toggleNotes() {
          if(this.showNotes == false) {
            this.showNotes = true;
          } else {
            this.showNotes = false;
          }
    },
        isItActive() {
          if(this.$store.state.plot.active === true){
            this.active = true;
          }else{
            this.active = false;
          }
    },

  },
  created(){
    this.getPlotName();
    this.getNotes();
    this.isLoading = false;
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
    "plots-body-grid everything-else"
    "go-back go-back";
}
#my-plot{
  grid-area: my-plot;
  text-align: center;
  padding-bottom: 10px;
  padding-top: 10px;
  background-color:#ba7331;
  border-radius: 3px;
  margin-top: 10px;
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
#plot-crops{
  margin-top:10px;
  margin-bottom:20px;
}
#notes-area{
  grid-area: notes-area;
  overflow:auto;
  background-color: #a53b58;
}
#shopping-list{
  margin-top:20px;
}
#view-notes{
  width: 100%;
  font-size: 32px !important;
  text-align: center;
  color: #83a126;
  background-color: white;
  padding: 8px;
  border-radius: 3px;
}
#view-notes:hover{
  width: 100%;
  font-size: 32px !important;
  text-align: center;
  background-color: #83a126;
  color: white;
  padding: 8px;
  border-radius: 3px;
}
#view-notes:focus{
  outline:none;

}
#back-button {
  width: 100%;
  height: 65px;
  font-size: 32px;
  align-content: bottom;
  border-radius: 3px;
  text-align: center;
  padding: 0px;
  color: #83a126 !important;
  background-color: white;
  border-style: none;
  margin-top:20px;
  grid-area: go-back;
}
#back-button:hover {
  width: 100%;
  height: 65px;
  margin-bottom: 0px;
  font-size: 32px;
  align-content: bottom;
  text-align: center;
  padding: 10px;
  border-radius: 3px;
  color: white !important;
  background-color: #83a126;

}
#back-button:focus{
  outline:none;

}
@media (max-width: 800px){

#plot-page {
  padding: 0 20px 20px 20px;
  background-color: #4e2409;
  display:grid;
  grid-template-columns:100%;
  padding: 0 20px 20px 20px;
  column-gap: 20px;
  grid-template-areas:
    "my-plot"
    "plots-body-grid"
    "everything-else"
    "go-back"
    ;
  }
  #my-plot{
    grid-area: my-plot;
  }
  #plots-body-grid{
    grid-area: plots-body-grid;
  }
  #plot-crops{
    grid-area: plot-crops;
  }
  #notes-area{
    grid-area: notes-area;
  }
  #shopping-list{
    grid-area: shopping-list;
  }
}
@media (max-width: 400px){
#my-plot{
  font-size: 32px;
}
}


</style>