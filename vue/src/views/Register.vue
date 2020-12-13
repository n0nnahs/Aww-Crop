<template>
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">
            <i class="fas fa-seedling"></i>
            Come grow with us!
            <i class="fas fa-seedling"></i>
            <br>Create your new account below.</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="email"
        id="username"
        class="user-input"
        placeholder="Email"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="user-input"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <input
        type="password"
        id="confirmPassword"
        class="user-input"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      </br>
      <button id="create" class="create-account-button" type="submit">
        Create Account
      </button>
      </br>
      <router-link style="color: #83a126;" v-bind:to="{ name: 'login' }">Already have an account? Click here to sign in.</router-link>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
            if(response.status === 409){
              this.registrationErrorMsg = 'This email is already registered!'
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style>

.create-account-button {
  margin-bottom: 10px;
}
#create{
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
#create:hover{
  background-color: #83a126;
}
i{
  color:#83a126;
}
</style>
