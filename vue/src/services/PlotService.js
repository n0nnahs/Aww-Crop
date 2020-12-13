import axios from 'axios';

export default {

  getPlots(userID) {
    return axios.get(`/plot/${userID}`)
  },
  getPlotById(plotId) {
    return axios.get(`/plot?plotId=${plotId}`)
  },
  getPlotCoordId(plotId) {
    return axios.get(`/crops/myplot?plotId=${plotId}`)
  }

}
