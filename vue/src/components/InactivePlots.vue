<template>
    <section id="inactive-plots-section">
      <div id="inactive">
        <h2>Inactive Plots</h2>
      </div>
        <div class="inactive-plots-list">
          <plot-card v-for="plot in plots" v-bind:plot="plot" v-bind:key="plot.name" />
      </div>
    </section>
</template>

<script>
import PlotCard from '@/components/PlotCard.vue';

export default {
  name: "inactive-plots",
  computed: {
    plots() {
      return this.$store.state.plots.filter((plot) => {
        return plot.active === false;
      });
    }
  },
  components: {
    PlotCard
  }
}
</script>

<style>
#inactive-plots-section {
  background-color: #a53b58;
  display: grid;
  column-gap: 50px;
  border-radius: 10px;
}
#inactive{
  text-align: center;
  font-size: 32px !important;
  font-weight: bold !important;
  color: white;
  background-color: #fe6f15;
  padding: 10px;
  padding-bottom: 5px;
  border-radius: 10px;
}
.inactive-plots-list {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}
</style>