<template>
    <div id="main-grid" class="crop">
      <img id="crop-image" :src="require(`../assets/${crop.name}.jpeg`)">  
      <h3 id="crop-name">{{crop.name}}</h3>
      <h3 id="crop-amount">{{crop.amount}} plants</h3>
      <h3 id="cost">${{crop.yield}}</h3>
  </div>
</template>

<script>

export default {
    name: 'shop-item',
  props: {
    crop: Object
  }
}
</script>

<style scoped>

#main-grid{
  display: grid;
  grid-auto-flow:row;
  grid-template-columns:1fr 2fr 2fr 2fr;
  grid-template-areas:
    "image crop-name crop-amount cost";
  padding: 10px;
  color: white;
  background-color: #BA7331;
  margin: 10px;
  background-color:#ba7331;
  border-radius: 3px;
}
#main-grid:hover{
    background-color: #83a126;
    text-decoration: none !important; 
}

img {
  grid-area: image;
  max-height: 50px;
  border-radius: 3px;
}
#crop-name{
  grid-area: crop-name;
  color:white;
  font-size: 20px;
  padding-top: 7px;
  padding-left: 5px;
  align-self:center;
  justify-self: center;
}
/* #crop-name:hover {
  background-color: #83a126;
  color: white;
  border-radius: 3px;
  font-weight: bold !important;
  padding: 10px;
} */
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
#cost{
  grid-area: cost;
  background: none;
  color:white;
  font-size: 20px;
  padding-top: 7px;
  padding-left: 20px;
  text-align: center;
}
</style>