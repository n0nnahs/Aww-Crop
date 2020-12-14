<template>
  <div id="loginpage" class="text-center">
    <form class="form-signin" @submit.prevent="login">  
      <h1 class="h3 mb-3 font-weight-normal">
        <i class="fas fa-seedling"></i>
        Welcome, farmer!
        <i class="fas fa-seedling"></i>
        <br/>Please sign in below.</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username or password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="user-input"
        placeholder="Email"
        v-model="user.username"
        required
        autofocus
      />
      <br/>
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="user-input"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <br/>
      <button id=loginbutton type="submit">Sign in</button>
      <br/>
      <router-link style="color: #83a126;" v-bind:to="{ name: 'register' }">Register for new account</router-link>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style>
#loginpage{
  background-color: #4e2409;

}
.user-input {
  align-content: center;
  width: 50%;
  margin: 10px;
}

form {
  height: 100%;
  margin-top: 10px;
}
#loginbutton{
  font-size: 24px !important;
  text-align: center;
  color: white;
  background-color: #fe6f15;
  padding: 5px;
  padding-right: 20px;
  padding-left: 20px;
  border-radius: 10px;
  outline: none;
  margin-bottom: 10px;
}
#loginbutton:hover{
  background-color: #83a126;
}
button{
  outline: none;
}
button:focus{
  border-style: none;
  outline: none;
}
</style>
