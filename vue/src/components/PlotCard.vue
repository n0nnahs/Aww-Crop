<template>
  <div class="card">
    <div id="plot-name-div">
      <h3 id="plot-name" style="color: #4e2409;">{{ plot.name }}</h3>
    </div>
    <div id="pic-and-button">
      <img id="crop-image" :src="require(`../assets/${plot.topCrop}.jpeg`)">
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
background-color: rgba(255, 255, 255, 0.8);
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
background-color: rgba(67, 184, 13, 0.8);
position: absolute;
left: -5%;
top:-5%;
height: 120px;
width: 120px;
border-radius: 3px;
font-size: 15px;
text-align: center;
margin: 5px; 
display:flex;
flex-direction: column;
justify-content: space-around;
padding:10px;
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