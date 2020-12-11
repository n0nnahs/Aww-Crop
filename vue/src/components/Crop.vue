<template>
    <div class="crop">
      <img src="bind to crop name and call api somehow? i have no idea"/> 
      <button id="crop-name" v-onclick="showDetails()">{{crop.name}}</button>
      <h3 id="crop-amount">{{crop.amount}}</h3>
  </div>
</template>

<script>
export default {
    name: 'crop',
    data(){
      return {

        crop: {
          name: "",
          amount:""
        }

      }
    },
    methods: {
        showDetails() {

            
        }
    }
}
</script>

<style scoped>

.crop{
  display: grid;
  grid-template-columns:3fr;
  grid-template-areas:
    "image"
    "crop-name"
    "crop-amount";
  padding: 10px;
  color: #b24747;
  background-color:	#ffeeb9;
}

img {
  grid-area: image;
  size:50px;
  display:flex;
  align-content: space-around;
}
#crop-name{
  background: none;
  border: none;
  grid-area: crop-name;
  font-size: 16px;
  text-align: center;
  display:flex;
  align-content: space-around;
}
#crop-amount{
  grid-area: crop-amount;
  font-size: 16px;
  text-align: center;
  display:flex;
  align-content: space-around;
}

</style>