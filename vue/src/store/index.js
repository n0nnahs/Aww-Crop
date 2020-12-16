import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'
// import CropService from '../services/CropService';

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));
// const userCrops = new Array(CropService.listAllCropsForUser('userId'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    // crops: [],
    // crops: userCrops,
    plotGrid: [],
    activePlotSize: {
      plotId: 0,
      length: 0,
      width: 0
    },
    crops: [],
    plots: [],
    header: false,
    notes: [],
    note:{
      date: '',
      note: '',
      note_id: '',
      plot_id: ''
    },
    plot: {
      id: "",
      name: "",
      length: "",
      width: "",
      active: ""
    }

  },
  mutations: {
    SET_PLOT(state, data) {
      state.plot = data;
    },
    SET_PLOTS(state, data) {
      state.plots = data;
    },
    SET_CROPS(state, data){
      state.crops = data;
    },
    SET_NOTES(state, data){
      state.notes = data;
    },
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
    },
    SAVE_NOTE(state, note) {
      state.notes.push(note)
    },
    SET_PLOT_GRID(state, plotGrid){
        state.plotGrid = plotGrid;
    },
    SET_ACTIVE_PLOT(state, activePlot){
        state.activePlotSize = activePlot;
    },
  },
  actions: {
    fetchCrops (store) {
      return fetch(`/home/mycrops?userId=${this.userId}`)
        .then(data => {
          store.commit('setCrops', data.crops)
          return store.state.crops
        })
    }
  }
})

