<template>
    <div id="main-grid" class="crop">
      <img :src='this.imageUrl()'/>  
      <button id="crop-name" v-onclick="showDetails()">crop.name</button>
      <h3 id="crop-amount">crop.amount</h3>
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

            
        },
        imageUrl () {
        return `~src/assets/${this.crop.name}.jpg`;
      }

    }
}
</script>

<style scoped>

#main-grid{
  display: grid;
  grid-auto-flow:row;
  grid-template-columns:1fr 1fr 2fr;
  grid-template-areas:
    "image crop-name crop-amount crop amount";

  padding: 10px;
  color: #b24747;

}
img {
  align-self:center;
  justify-self: center;
  grid-area: image;
  max-height: 50px;
}
#crop-name{
  grid-area: crop-name;
  background: none;
  border: none;
  color:#b24747;
  font-size: 16px;
  align-self:center;
  justify-self: flex-start;
}
#crop-amount{
  padding-top: 7px;
  padding-left: 5px;
  grid-area: crop-amount;
  font-size: 16px;
  align-self:center;
  justify-self: flex-start;
}
#crop-name:hover {
  border-width: 3px;
  border-color: #53856d;
  border-style:solid;
  background-color: #a5e79b;
  color: #53856d;
}

</style>