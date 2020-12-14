<template>
  <div>
    <img id="plant" src="../assets/dirt.jpg" />
    <div v-bind:value="cropCell">
      
      <img v-if='cropCell.name !==""' id="plant" :src="require(`@/assets/${cropCell.name}.jpeg`)" />
    </div>
  </div>
</template>

<script>
export default {
    name: "plot-crop",
    data(){
      return{
        cropCell: Object
      }
    },
    props: [
         
      ],
    methods: {
      cropIcon(){
        let iconImg = "../assets/broccoli.jpeg";
        return iconImg;
      }
    }
    
}
</script>

<style scoped>


</style>