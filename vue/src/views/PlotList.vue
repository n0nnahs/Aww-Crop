<template>
  <h1>Plot List</h1>
</template>

<script>
import PlotService from '../services/PlotService';
export default {
    created() {
        //let id = 101;
        PlotService.getPlots(101).then((x) => console.log(x.data));
  }
}
</script>

<style>

</style>