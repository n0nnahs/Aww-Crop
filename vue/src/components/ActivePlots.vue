<template>
    <section id="active-plots-sections">
      <div id="active">
        <h2 id="raspberries">Active Plots</h2>
        <div class="active-plots-list" v-for="plot in activePlots" v-bind:key="plot">
          <router-link :to="`myplot/${plot.id}`" >
            <plot-card v-bind:plot="plot" v-bind:key="plot.id" />
          </router-link>
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
 
<style>

#active-plots-sections {
  column-gap: 50px;
  border-radius: 3px;
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
  font-size: 32px !important;
  text-align: center;
  color: white;
  background-color: #fe6f15;
  padding: 10px;
  border-radius: 3px;
}
.active-plots-list {
  display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
  display: inline-block;
}



</style>