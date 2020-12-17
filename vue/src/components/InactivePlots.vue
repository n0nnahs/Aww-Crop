<template>
    <section id="inactive-plots-section">
      <div id="inactive">
        <h2 id="blueberries">Inactive Plots</h2>
        <div class="inactive-plots-list" v-for="plot in inactivePlots" v-bind:key="plot">
          <router-link :to="`myplot/${plot.id}`" >
            <plot-card v-bind:plot="plot" v-bind:key="plot.id" />
          </router-link>
        </div>
        </div>
    </section>
</template>

<script>

import PlotCard from '@/components/PlotCard.vue';

export default {
  name: "inactive-plots",
  props: {
    inactiveArray: Array
  },
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
  border-radius: 3px;
}
#inactive{
  text-align: center;
  font-size: 32px !important;
  font-weight: bold !important;
  color: white;
  background-color: #a53b58;
  border-radius: 3px;
}
#blueberries{
  font-size: 32px !important;
  text-align: center;
  color: white;
  background-color: #fe6f15;
  padding: 10px;
  border-radius: 3px;
}
.inactive-plots-list {
  display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
  display: inline-block;
}

</style>