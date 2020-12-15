import axios from 'axios';

export default {

  getPlots(userId) {
    return axios.get(`/plot/user/${userId}`)
  },
  getPlotById(plotId) {
    return axios.get(`/plot?plotId=${plotId}`)
  },  
  getPlotCoordId(plotId) {
    return axios.get(`/crops/myplot?plotId=${plotId}`)
  },
    createNewPlot(plot) {
    return axios.post(`/plot`, plot)
  }

}
