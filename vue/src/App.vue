<template>
  <div id="app">
    <div id="nav" v-show="$route.name !== 'welcome'">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <header class="header" v-show="$route.name !== 'welcome'">
<<<<<<< HEAD
    </header> 
=======
    </header>
>>>>>>> bb094f765770bce3b91b079e082534a69d69e010
    <router-view />
  </div>
</template>

<style scoped>
#app{
  background-color: #4e2409;
  color: white;
  font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
  height: 100vh;
}
<<<<<<< HEAD
#nav{
  background-color: #81e5fc;
}
=======

#nav {
  background-color: #81e5fc;
}

>>>>>>> bb094f765770bce3b91b079e082534a69d69e010
header {
  background-image: url("./assets/veggies-fixed-clouds.jpg");
  background-repeat: repeat-x;
  background-size: contain;
  height: 100px;
  width: 100%;
}

</style>
 