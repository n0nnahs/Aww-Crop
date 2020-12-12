import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    plotGrid: [
          {
            id: "",
            x: 0,
            y: 0
          },

    ],
    plotSize: {
      height: 10,
      width: 10
    },
    plots: [
      {
        name: "Sample Plot",
        plant: "broccoli",
        active: true
      },
      {
        name: "Sample Plot 2",
        plant: "cauliflower",
        active: true
      },
      {
        name: "Raised bed, front yard",
        plant: "tomatoes",
        active: true
      },
      {
        name: "Vegetable garden, side yard",
        plant: "potatoes",
        active: false
      },
      {
        name: "Raised bed by patio",
        plant: "radishes",
        active: false
      },
      {
        name: "35CharactersIsMaximumPlotNameSize!!",
        plant: "peas",
        active: false
      },
    ],
    header: false
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    SET_HEADER(state, boolean){
      state.header = boolean;
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    }
  }
})
