<template>
  <div>
    
  <div v-bind:value="croppy">
    <img v-on:click="assignNewCrop(this.cropRow.getIndex(), this.croppy.getIndex())" v-if="croppy ===0" id="plant" src="../assets/dirt.jpg" />
    <img v-if="croppy !==0" id="plant" src="../assets/plotPlant.jpg" />
  </div>
  </div>
</template>

<script>
export default {
    name: "plot-crop",
        props: [
        'CropRows',
        'croppy'    
            ],
}
</script>

<style>


</style>