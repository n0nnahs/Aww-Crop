<template>
  <div id="app">
    <div id="nav" v-show="$route.name !== 'welcome' && $route.name !== 'print'">
      <router-link style="color:  #a53b58;" v-bind:to="{ name: 'home' }">Home</router-link> 
      <span v-if="$store.state.token != ''">&nbsp;|&nbsp;</span>
      <router-link style="color:  #a53b58;" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <header class="header" v-show="$route.name !== 'welcome' && $route.name !== 'print'">
    </header>
    <router-view />
  </div>
</template>

<style>
#app{
  background-color: #4e2409;
  color: white;
  font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
  height: 100vh;
  overflow: auto;

}

#nav {
  background-color: #81e5fc;
  padding-left: 20px;
  padding-top: 10px;
}

header {
  background-image: url("./assets/veggies-fixed-clouds.jpg");
  background-repeat: repeat-x;
  background-size: contain;
  height: 25%;
  width: 100%;
}

button{
  border-style:none;
}

</style>
 