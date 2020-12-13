<template>
  <div class="home">
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
              <new-plot-form></new-plot-form>
           </div>
          </div> 
          <div id="aplots">
              <active-plots></active-plots>
          </div>

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
      };
  },
  created() {
      this.showForm = false;
  },
  methods: {
      toggleForm() {
          if(this.showForm == false) {
            this.showForm = true;
          } else {
            this.showForm = false;
          }
      },
  },
}

</script>


<style scoped>

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
#new-plot-section {
  background-color: #a53b58;
  margin-top: 0px;
  margin-bottom: 20px;
  column-gap: 50px;
  border-radius: 10px;
}
#add-new-plot-button {
  width: 100%;
  height: 65px;
  font-size: 32px;
  align-content: bottom;
  border-radius: 10px;
  text-align: center;
  padding: 10px;
  border-radius: 10px;
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
  border-radius: 10px;
  text-align: center;
  padding: 10px;
  border-radius: 10px;
  color: white !important;
  background-color: #83a126;
}
#my-crops{
  grid-area: my-crops;
  margin-top: 10px;
}
</style>
