<template>
  <div class="farm">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <main>
      <active-plots />
    </main>
  </div>
</template>

<script>
import ActivePlots from '../components/ActivePlots.vue';

export default {
  components: { 
    ActivePlots 
  },
  name: "farm"
};
</script>
