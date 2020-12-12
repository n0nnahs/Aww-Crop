<template>
  <div class="card">
    <div id="plot-name-div">
      <h3 class="plot-name">{{ plot.name }}</h3>
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
    background-color: #a53b58 !important;
    display: flex;
    flex-direction: column;
    justify-content: flex-end;
    align-items: center;
}

.card .plot-name {
  font-size: 100%;
  text-align: center;
  margin: 5px;
}

#plot-name-div {
  display: flex;
  align-items: center;
  justify-content: center;
}

#pic-and-button {
  display: flex;
  flex-direction: column;
  justify-content: flex-end;
}

#manage-plot-button {
  font-size: 15px;
  margin: 5px;
  align-content: bottom;
}

#manage-plot-button:hover {
  font-size: 15px;
  background-color: #83a126;
  margin: 5px;
  color: white;
  align-content: bottom;
}

#crop-image {
  height: 90px;
  width: 90px;
  object-fit: contain;
  align-self: center;
}

</style>