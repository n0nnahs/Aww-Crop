<template>
    <section id="active-plots-section">
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
.active-plots-list {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}

#active-plots-section {
  justify-items: center !important;
}

</style>