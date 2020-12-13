<template>
    <div id="main-grid" class="crop">
       <img id="crop-image" :src="require(`../assets/${crop.name}.jpeg`)">  
      <button id="crop-name">{{crop.name}}</button>
      <h3 id="crop-amount">{{crop.amount}} ft²</h3>
      <h3 id="expected-yield">{{crop.yield}} lbs</h3>
  </div>
</template>

<script>

export default {
    name: 'crop',
    props: {
      crop: Object
    },
    methods: {
        showDetails() {
        
        }
    }
}
</script>

<style scoped>

#main-grid{
  display: grid;
  grid-auto-flow:row;
  grid-template-columns:1fr 2fr 2fr 2fr;
  grid-template-areas:
    "image crop-name crop-amount expected-yield";
  padding: 10px;
  color: white;
  margin: 10px;

}
img {
  grid-area: image;
  max-height: 50px;
  border-radius: 10px;
  padding-right:8px;
}
#crop-name{
  grid-area: crop-name;
  background: none;
  border: none;
  color:white;
  font-size: 20px;
  padding-left: 0px;
  text-align:center !important;
}
#crop-name:hover {
  background-color: #83a126;
  color: white;
  border-radius: 20px;
  font-weight: bold !important;
  padding: 10px;
}
#crop-amount{
  grid-area: crop-amount;
  background: none;
  color:white;
  font-size: 20px;
  padding-top: 7px;
  padding-left: 5px;
  align-self:center;
  justify-self: center;

}
#expected-yield{
  grid-area: expected-yield;
  background: none;
  color:white;
  font-size: 20px;
  padding-top: 7px;
  padding-left: 20px;
  text-align: center;
}
</style>