import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:8080"
});

export default {

  getTopics() {
    return http.get('/topics')
  },

}