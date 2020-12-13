<template>
  <section id="active-plots-section">
    <h2>Active Plots</h2>
    <div class="active-plots-list">
      <plot-card v-for="plot in plots" v-bind:plot="plot" v-bind:key="plot.name" />
    </div>
  </section>
</template>
 
<script>
import PlotCard from '@/components/PlotCard.vue';
 
export default {
  name: "active-plots",
  computed: {
    plots() {
      return this.$store.state.plots.filter((plot) => {
        return plot.active === true;
      });
    }
  },
  components: {
    PlotCard
  }
}
</script>
 
<style>
.active-plots-list {
  display:flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
}
 
#active-plots-section {
  justify-content: center !important;
  justify-items: center !important;
}
 
</style>