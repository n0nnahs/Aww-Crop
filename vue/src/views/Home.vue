<template>
  <div class="home">
    <h1>My Garden</h1>
    <my-crops></my-crops>
  </div>
</template>

<script>
import MyCrops from '@/components/MyCrops.vue';

export default {
  name: "home",
  components: {
        MyCrops
    },
}

</script>
