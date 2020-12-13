<template>
    <section id="active-plots-section">
      <div id="active">
        <h2>Active Plots</h2>
      </div>
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