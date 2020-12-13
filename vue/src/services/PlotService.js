import axios from 'axios';

export default {

  getPlots(username) {
    return axios.get(`/plot/user/${username}`)
  },
  getPlotById(plotId) {
    return axios.get(`/plot?plotId=${plotId}`)
  }

}
