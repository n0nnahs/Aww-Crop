import axios from 'axios';

const http = axios.create({
  baseURL: "https://openfarm.cc/"
});

export default {

  list() {
    return http.get('api/v1/crops')
  },
 
  get(name) {
    return http.get(`api/v1/crops/${name}`)
  }
}