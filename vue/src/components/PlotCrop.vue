<template>
  <div>
    <div v-bind:value="croppy">
      <img v-if='croppy.name === ""' id="plant" src="../assets/dirt.jpg" />
      <img v-if='croppy.name !==""' id="plant" src='cropIcon()' />
    </div>
  </div>
</template>

<script>
export default {
    name: "plot-crop",
    data(){
      return{

      }
    },
    props: [
      'croppy'    
      ],
    methods: {
      cropIcon(){
        let iconImg = "../assets/broccoli.jpeg";
        return iconImg;
      }
    }
    
}
</script>

<style>


</style>