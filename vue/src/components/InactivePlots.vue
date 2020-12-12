<template>
    <section>
        <h2>Inactive Plots</h2>
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
.inactive-plots-list {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}
</style>