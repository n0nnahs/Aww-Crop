import axios from 'axios';

export default {

  getPlots(userId) {
    return axios.get(`/plot/user/${userId}`)
  },
  getPlotById(plotId) {
    return axios.get(`/plot/${plotId}`)
  },  
  getPlotCoordId(plotId) {
    return axios.get(`/crops/myplot?plotId=${plotId}`)
  },
  createNewPlot(plot) {
    return axios.post(`/plot`, plot)
  },
  createNewNote(note){
      return axios.post('/plot/notes', note)
  },
  getNotes(userId){
      return axios.get(`/plot/notes/${userId}`)
  },
  updateNote(note, note_id){
      return axios.put(`/plot/notes/update/${note_id}, note`)
  },
  plantNewCrop(crop){
    return axios.post(`/crops/myplot?plotId=${crop.plotId}`, crop)
  },
  updateCrop(crop){
    return axios.put(`/crops/myplot?plotId=${crop.plotId}`, crop)

}
