<template>
  <div>
    <h1>Plot List</h1>
    <button v-on:click.prevent="retrievePlots">retrievePlots()</button>
    <button v-on:click.prevent="retrievePlotById">retrievePlotById()</button>
  </div>
</template>

<script>
import PlotService from '../services/PlotService';
export default {
    data() {
        return {
           //id: this.$store.state.user
        };
    },
    created() {
        //PlotService.getPlots(this.id).then((x) => console.log(x.data));
    },
    methods: {
        retrievePlots() {
            PlotService.getPlots(this.$store.state.user.id).then((x) => console.log(x.data));
            //console.log(this.$store.state.user.id);
        },
        retrievePlotById() {
            PlotService.getPlotById(101).then((x) => console.log(x.data));
        }
    },
};
</script>

<style>

</style>