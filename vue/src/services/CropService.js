import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:8080"
});

export default {

  listAllCropsForUser(userId) {
    return http.get(`/crops?user_id=${userId}`)
  },

  listCropsForOnePlot() {
    return http.get('/plot/myplot')
  }

}