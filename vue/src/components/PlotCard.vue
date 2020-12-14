<template>
  <div class="card">
    <div id="plot-name-div">
      <h3 id="plot-name">{{ plot.name }}</h3>
    </div>
    <div id="pic-and-button">
      <img id="crop-image" :src="require(`../assets/${plot.topCrop}.jpeg`)">
      <button id="manage-plot-button">Manage Plot</button>
    </div>
  </div>
</template>
 
<script>
export default {
  name: 'plot-card',
  props: {
    plot: Object
  }
}
 
 </script>
 
<style scoped>
.card {
    border-radius: 3px;
    width: 110px;
    height: 200px;
    margin: 20px;
    background-color: #ba7331 !important;
    display: grid;
    grid-template-rows:50px 100px 50px;
    grid-template-areas:
          "plot-name image button";
    display: flex;
    flex-direction: column;
    justify-content: space-around;

}
#plot-name {
  grid-area: plot-name;
  font-size: 15px;
  text-align: center;
  margin: 5px; 
  display:flex;
  flex-direction: column;
  justify-content: space-around;
} 
#plot-name-div {
  display: flex;
  flex-direction: column;
  align-content: center !important;
  flex-grow: 1;
  justify-content: space-evenly;
}
#pic-and-button {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content:flex-end;
}
#manage-plot-button {
  grid-area: button;
  font-size: 15px;
  margin: 5px;
  border-radius: 2px;
  background-color: #83a126;
  color: white;
}
#manage-plot-button:hover {
  grid-area: button;
  font-size: 15px;
  background-color: white;
  margin: 5px;
  margin-top: 10px;
  color: #83a126;
}
#crop-image {
  grid-area: image;
  height: 90px;
  width: 90px;
  object-fit: contain;
  align-self: center;
  border-radius: 3px;
  background-color: white;
}
#manage-plot-button{
  grid-area: button;
  margin-top: 10px;
}
button:focus{
  border-style: none;
  outline: none;
}
button{
  border-style: none;
  outline: none;
}
</style>