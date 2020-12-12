<template>
  <div class="home">
    <h1>My Garden</h1>
    <active-plots></active-plots>
    <my-crops></my-crops>
  </div>
</template>

<script>
import ActivePlots from '../components/ActivePlots.vue';
import MyCrops from '@/components/MyCrops.vue';

export default {
  name: "home",
  components: {
        ActivePlots,
        MyCrops
    },
}

</script>

<style scoped>

.home{
  background-color: #4e2409;
  display: grid;
  grid-template-columns:1fr 1fr;
  grid-template-areas:
    "active-plots my-crops";
}

active-plots{
  grid-area: active-plots;
}

my-crops{
  grid-area: my-crops;
}


</style>
