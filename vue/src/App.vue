<template>
  <div id="app">
    <header class="header">
    </header> 
    <div id="nav" v-if="this.class!=welcome" >
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>

<style scoped>
#app{
  background-color: #4e2409;
  color: white;
  font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;

}
</style>
