<template>
  <div class="card">
    <h2 class="plot-name">{{ plot.name }}</h2>
    <img id="crop-image" :src="require(`../assets/${plot.plant}.jpeg`)">
    <button id="manage-plot-button">Manage Plot</button>
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
    width: 100px;
    height: 200px;
    margin: 20px;
    background-color: #a53b58 !important;
}

.card .plot-name {
  font-size: 1.5rem;
}

#manage-plot-button {
  font-size: 15px;
  background-color: #83a126;
  margin-top: 10px;
}

#crop-image {
  height: 90px;
  width: 90px;
  object-fit: contain;
  align-self: center;
}

</style>