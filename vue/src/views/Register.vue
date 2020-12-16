<template>
  <div id="registerpage" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">
            <i class="fas fa-seedling"></i>
            Come grow with us!
            <i class="fas fa-seedling"></i>
            <br>Create your new account below.</h1>
      <div id="ohno" class="alert alert-danger" role="alert" v-if="registrationErrors">
        <img id="mrYuck" src ="../assets/error.jpeg" >
        {{ registrationErrorMsg }}
        <img id="mrYucks" src ="../assets/error.jpeg" >
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
      registrationErrorMsg: 'Oh my gourd! There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Oh my gourd!! Password & Confirm Password do not match. Try again!';
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
              this.registrationErrorMsg = 'Oh my gourd! Bad Request: Validation Errors';
            }
            if(response.status === 409){
              this.registrationErrorMsg = 'Oh my gourd! This email is already registered!'
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'Oh my gourd! There were problems registering this user.';
    },
  },
};
</script>

<style>
#registerpage{
  background-color: #4e2409;

}
.create-account-button {
  margin-bottom: 10px;
  margin-top: 10px;
}
.create-account-button:focus {
  border-style: none;
  outline: none;
}
#create{
  font-size: 24px !important;
  text-align: center;
  color: white;
  background-color: #fe6f15;
  padding: 5px;
  padding-right: 20px;
  padding-left: 20px;
  border-radius: 3px;
  margin-bottom: 10px;
}
#create:hover{
  background-color: #83a126;
}
i{
  color:#83a126;
}
button{
  outline: none;
}
button:focus{
  border-style: none;
  outline: none;
}
#ohno{
  padding:20px;
  margin: 20px;
  margin-bottom: 20px;
  background-color: white;
  color:#4e2409;

}
#mrYuck{
  -webkit-transform: scaleX(-1);
  transform: scaleX(-1);
  height: 100px;
  padding: 5px;
}
#mrYucks{
  height: 100px;
  padding: 5px;
}
#confirmPassword:focus {
  outline-color: #83a126 !important;
}
</style>
