<template>
  <div class="welcome">
    <div id="nav">
      <router-link v-bind:to="{ name: 'login' }">Have an account already?</router-link>&nbsp;
      <router-link v-bind:to="{ name: 'register' }">If not, create an account!</router-link>&nbsp;
    </div>

    <h1>Welcome</h1>
    <p>Use our app</p>
  </div>
</template>

<script>
export default {
  name: "home"
};
</script>