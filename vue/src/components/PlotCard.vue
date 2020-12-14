<template>
  <div class="card">
    <div id="plot-name-div">
      <h3 id="plot-name" style="color: #4e2409;">{{ plot.name }}</h3>
    </div>
    <div id="pic-and-button">
      <img id="crop-image" :src="require(`../assets/${plot.topCrop}.jpeg`)">
      <!-- <button id="manage-plot-button">Manage Plot</button> -->
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
.card{
    width: 120px;
    height: 120px;
    margin: 20px;
    background-color: white !important;
}
#crop-image{
    grid-area: image;
    height: 90px;
    width: 90px;
    object-fit: contain;
    margin-top: 14px;
    border-radius: 10px;
    background-color: white;
}

#plot-name{
background-color: rgba(255, 255, 255, 0.6);
font-size: 18px !important;
position: absolute;
left: -5%;
top:-5%;
height: 120px;
width: 120px;
border-radius: 3px;
font-size: 15px;
font-weight: bold;
text-align: center;
margin: 5px; 
display:flex;
flex-direction: column;
justify-content: space-around;
padding:10px;
}
#plot-name:hover {
background-color: rgba(67, 184, 13, 0.6);
font-size: 20px !important;
position: absolute;
left: -5%;
top:-5%;
height: 120px;
width: 120px;
border-radius: 3px;
font-size: 15px;
font-weight: bold;
text-align: center;
margin: 5px; 
display:flex;
flex-direction: column;
justify-content: space-around;
padding:10px;
}
/* .card {
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

} */
/* #plot-name {
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
} */
/* #pic-and-button {
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
  border-radius: 10px;
  background-color: white;
}
#manage-plot-button{
  grid-area: button;
  margin-top: 10px;
} */
button:focus{
  border-style: none;
  outline: none;
}
button{
  border-style: none;
  outline: none;
}
</style>