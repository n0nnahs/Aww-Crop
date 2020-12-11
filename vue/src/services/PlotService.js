import axios from 'axios';

export default {

  getPlots(userID) {
    return axios.get(`/plot/${userID}`)
  }

}
