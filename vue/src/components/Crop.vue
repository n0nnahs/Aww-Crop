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
    data(){
      return {
        crop: {
          name: "broccoli",
          amount:"69",
          yield:"420"
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

#main-grid{
  display: grid;
  grid-auto-flow:row;
  grid-template-columns:1fr 3fr 3fr 3fr;
  grid-template-areas:
    "image crop-name crop-amount expected-yield";
  padding: 10px;
  color: white;
  margin-top: 5px;
  padding-bottom: 0px;
}
img {
  grid-area: image;
  max-height: 50px;
  border-radius: 10px;
}
#crop-name{
  grid-area: crop-name;
  background: none;
  border: none;
  color:white;
  font-size: 16px;
  font-weight: bold !important;
  padding-left: 0px;
}
#crop-name:hover {
  background-color: #83a126;
  color: white;
  border-radius: 10px;
  font-weight: bold !important;
  padding: 10px;
}
#crop-amount{
  grid-area: crop-amount;
  background: none;
  color:white;
  font-size: 16px;
  padding-top: 7px;
  padding-left: 5px;
  align-self:center;
  justify-self: center;
  font-weight: bold !important;
}
#expected-yield{
  grid-area: expected-yield;
  background: none;
  color:white;
  font-size: 16px;
  padding-top: 7px;
  padding-left: 5px;
  align-self:center;
  justify-self: flex-end;
  font-weight: bold !important;
}
</style>