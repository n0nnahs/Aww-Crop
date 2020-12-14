<template>
    <section id="inactive-plots-section">
      <div id="inactive">
        <h2 id="blueberries">Inactive Plots</h2>
      </div>
        <div class="inactive-plots-list">
          <plot-card v-for="plot in inactivePlots" v-bind:plot="plot" v-bind:key="plot.id" />
      </div>
    </section>
</template>

<script>
import PlotCard from '@/components/PlotCard.vue';

export default {
  name: "inactive-plots",
  computed: {
    inactivePlots() {
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

<style scoped>
#inactive-plots-section {
  column-gap: 50px;
  border-radius: 10px;
}
#inactive{
  text-align: center;
  font-size: 32px !important;
  font-weight: bold !important;
  color: white;
  background-color: #a53b58;
  border-radius: 10px;
  margin-bottom: 20px;
}
#blueberries{
  background-color: #FE6F15;
  padding: 10px;
  border-radius: 10px; 
}
.inactive-plots-list {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}

</style>