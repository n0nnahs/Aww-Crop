import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:8080"
});

export default {

  listAllCropsForUser() {
    return http.get('/home/mycrops')
  },

  listCropsForOnePlot() {
    return http.get('/plot/myplot')
  }

}