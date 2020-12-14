<template>
    <section id="active-plots-sections">
      <div id="active">
        <h2 id="raspberries">Active Plots</h2>
        <div class="active-plots-list">
          <plot-card v-for="plot in activePlots" v-bind:plot="plot" v-bind:key="plot.id" />
        </div>
      </div>
    </section>
</template>
 
<script>
import PlotService from '../services/PlotService';
import PlotCard from '@/components/PlotCard.vue';
 
export default {
  name: "active-plots",
  methods:{
      
  },
  computed: {
    activePlots() {
      return this.$store.state.plots.filter((plot) => {
        return plot.active === true;
      });
    }
  },
  components: {
    PlotCard
  },
  created() {
        PlotService.getPlots(this.$store.state.user.id).then(response => {
          this.$store.commit("SET_PLOTS", response.data);
        });
  }
};
</script>
 
<style scoped>

#active-plots-sections {
  column-gap: 50px;
  border-radius: 10px;
}
#active{
  text-align: center;
  font-size: 32px !important;
  font-weight: bold !important;
  color: white;
  background-color: #a53b58;
  border-radius: 3px;
  margin-bottom: 20px;
}
#raspberries{
  background-color: #FE6F15;
  padding: 10px;
  border-radius: 3px; 
}
.active-plots-list {
  display:flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
}



</style>