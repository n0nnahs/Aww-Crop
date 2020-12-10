<template>
  <div id="app">
    <header class="header">
    </header> 
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>

<style>

#app {
  background-color: #4e2409;
  color: white;
  font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
  height: 100vh;
}

header {
  background-image: url("./assets/veggies-fixed-clouds.jpg");
  background-repeat: repeat-x;
  background-size: contain;
  height: 100px;
  width: 100%;
}

nav {
  background-color: #81e5fc;
}

</style>
