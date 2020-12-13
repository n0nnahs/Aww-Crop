<template>
  <div class="card">
    <div id="plot-name-div">
      <h3 id="plot-name">{{ plot.name }}</h3>
    </div>
    <div id="pic-and-button">
      <img id="crop-image" :src="require(`../assets/${plot.plant}.jpeg`)">
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
 
<style>
.card {
    border: 2px solid black;
    border-radius: 10px;
    width: 110px;
    height: 200px;
    margin: 20px;
    background-color: #ba7331 !important;
    display: grid;
    grid-template-rows:1fr 2fr 1fr;
    grid-template-areas:
          "plot-name image button";

    /* display: flex;
    flex-direction: column;
    justify-content: space-between;
    align-items: center; */
}

#plot-name {
  font-size: 15px;
  text-align: center;
  margin: 5px; 
  grid-area: plot-name;
  display:flex;
  flex-direction: column;
  flex-flow: column wrap;
} 

#plot-name-div {
  display: flex;
  flex-direction: column;
  align-content: center !important;
  justify-content: center;
}
 
#pic-and-button {
  display: flex;
  flex-direction: column;
  align-items: center;
}
 
#manage-plot-button {
  font-size: 15px;
  margin: 5px;
  border-radius: 4px;
  color: #4a7623;
  background-color: white;
}
 
#manage-plot-button:hover {
  font-size: 15px;
  background-color: #83a126;
  margin: 5px;
  color: white;
}
 
#crop-image {
  grid-area: image;
  height: 90px;
  width: 90px;
  object-fit: contain;
  align-self: center;
  border-radius: 10px;
}
#manage-plot-button{
  grid-area: button;
}

button{
  border-style: none;
}

</style>