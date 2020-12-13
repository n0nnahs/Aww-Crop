import axios from 'axios';

export default {

  getPlots(username) {
    return axios.get(`/plot/user/${username}`)
  },
  getPlotById(plotId) {
    return axios.get(`/plot?plotId=${plotId}`)
  },
<<<<<<< HEAD
  getPlotCoordId(plotId) {
    return axios.get(`/crops/myplot?plotId=${plotId}`)
=======
  createNewPlot(plot) {
    return axios.post(`/plot`, plot)
>>>>>>> 245c37e9faf4e8471331541bdefb8da8759be25c
  }

}
