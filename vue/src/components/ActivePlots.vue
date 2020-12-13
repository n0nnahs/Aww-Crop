<template>
    <section id="active-plots-section">
      <div id="active">
        <h2>Active Plots</h2>
        <div class="active-plots-list">
          <plot-card v-for="plot in this.$store.state.plots" v-bind:plot="plot" v-bind:key="plot.id" />
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
    plots() {
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

#active-plots-section {
  background-color: #a53b58;;
  display: grid;
  column-gap: 50px;
  border-radius: 10px;
}
#active{
  text-align: center;
  font-size: 32px !important;
  font-weight: bold !important;
  color: white;
  background-color: #fe6f15;
  padding: 10px;
  padding-bottom: 5px;
  border-radius: 10px;
}
.active-plots-list {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}



</style>