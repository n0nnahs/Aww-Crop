import axios from 'axios';

export default {

  plots(plotID) {
    return axios.get(`/plots/${plotID}`, )
  }
}