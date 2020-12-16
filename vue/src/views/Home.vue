<template>
  <div id="main-gridz" class="home">
    <h1 id=my-garden>
      <i class="fas fa-seedling"></i>
      My Garden
      <i class="fas fa-seedling"></i>
    </h1>
    <div id="home-grid">
      <div id="plots">
          <div id="new-plot-section">
            <button id="add-new-plot-button" v-on:click="toggleForm">
                        <i class="fas fa-seedling"></i>
                        Add New Plot 
                        <i class="fas fa-seedling"></i>
            </button><br/>
            <div id="newPlotForm" v-show="showForm">
              <new-plot-form id="newplotform"></new-plot-form>
           </div>
          </div> 
          <div id="aplots">
              <active-plots id="activeplots" ></active-plots>
          </div>
          <div id="iplots" v-show="showInactivePlots">
             <inactive-plots id="inactiveplots" :inactiveArray="inactiveArray"></inactive-plots>
          </div>
      </div>
      <my-crops id="my-crops"></my-crops>
    </div>
  </div>
</template>

<script>
import PlotService from '../services/PlotService';
import ActivePlots from '../components/ActivePlots.vue';
import MyCrops from '@/components/MyCrops.vue';
import InactivePlots from '../components/InactivePlots.vue';
import NewPlotForm from '../components/NewPlotForm.vue';

export default {
  name: "home",
  components: {
      MyCrops,
      ActivePlots,
      InactivePlots,
      NewPlotForm 
  },
  data() {
      return {
          showForm: true,
          showInactivePlots: true,
          inactiveArray : []
      };
  },
  created() {
          PlotService.getPlots(this.$store.state.user.id).then(response => {
          this.$store.commit("SET_PLOTS", response.data);
          this.showForm = false;
          this.toShowOrNotToShow();
        });


  },
  methods: {
    toggleForm() {
          if(this.showForm == false) {
            this.showForm = true;
          } else {
            this.showForm = false;
          }
    },
    toShowOrNotToShow() {
      this.inactiveArray = this.$store.state.plots.filter((plot) => {
      return plot.active === false;
      });
      console.log(this.inactiveArray);
      console.log("goodbye world");
        if (this.inactiveArray.length > 0) {
          this.showInactivePlots = true; 
        } else {
          this.showInactivePlots = false; 
        }
    }
  }
}

</script>


<style scoped>

@media (min-width: 801px){
      #main-gridz {
        grid-template-columns: 1fr 1fr;
        grid-template-areas:
            "my-garden my garden"
            "new-plot-section"
            "activeplots my-crops"
            "inactiveplots my-crops";
      } 
  
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
  border-radius: 3px;
  margin-top: 10px;
}
#plots {
  grid-area: plots;
  background-color:#4e2409;
}
#new-plot-section {
  background-color: #a53b58;
  margin-top: 0px;
  margin-bottom: 20px;
  column-gap: 50px;
  border-radius: 10px;
}
#iplots{
  background-color: #a53b58;
}
#inactiveplots.plotcard:empty{
  display:none;
}
#add-new-plot-button {
  width: 100%;
  height: 65px;
  font-size: 32px;
  align-content: bottom;
  border-radius: 3px;
  text-align: center;
  padding: 8px;
  border-radius: 3px;
  color: #83a126;
  background-color: white;
  border-style: none;
}
#add-new-plot-button:hover {
  width: 100%;
  height: 65px;
  margin-bottom: 0px;
  font-size: 32px;
  align-content: bottom;
  border-radius: 3px;
  text-align: center;
  padding: 10px;
  color: white !important;
  background-color: #83a126;
}
#new-plot-section {
  background-color: #a53b58;
  margin-top: 10px;
  margin-bottom: 20px;
  column-gap: 50px;
  border-radius: 10px;
}
#my-crops{
  grid-area: my-crops;
  margin-top: 10px;
  height: 100vh;
}
button:focus{
  border-style: none;
  outline: none;
}
}
@media (max-width: 800px){
#main-gridz {
  grid-template-columns: 100%;
  grid-template-areas:
    "my-garden"
    "new-plot-section"
    "activeplots"
    "my-crops"
    "inactiveplots";
  background-color: #4e2409;
  padding:10px;
} 
#my-garden{
  grid-area: my-garden;
}
#new-plot-section{
  grid-area: new-plot-section;
}
#aplots{
  grid-area: activeplots;
}
#my-crops{
  grid-area: my-crops;
}
#iplots{
  grid-area: inactiveplots;
  display: none;
}

#my-garden{
  text-align: center;
  padding-bottom: 10px;
  padding-top: 10px;
  background-color:#ba7331;
  border-radius: 3px;
  margin-bottom: 10px;
  margin-top: 10px;
}
#new-plot-section {
  background-color: #4e2409 !important;
  margin-top: 0px;
  margin-bottom: 20px;
  column-gap: 50px;
  border-radius: 3px;
}
#add-new-plot-button {
  width: 100%;
  height: 55px;
  font-size: 32px;
  border-radius: 3px;
  text-align: center;
  color: #83a126;
  background-color: white;
  border-style: none;
  margin-top: 10px;
}
#add-new-plot-button:hover, #add-new-plot-button:focus {
  border-style: none;
  outline: none;
  color: white !important;
  background-color: #83a126;
}
#plots{
  background-color: #4e2409;
}
#iplots{
  background-color: #a53b58;
}
#aplots{
  background-color: #a53b58;
}
#my-crops{
  padding-bottom: 5px;
}
}
@media (max-width: 400px){
#my-garden{
  font-size: 32px;
}
#add-new-plot-button{
  font-size: 24px;
}
#add-new-plot-button:hover{
  font-size: 24px;
}
}
</style>
