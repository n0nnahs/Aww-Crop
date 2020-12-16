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
  deleteNote(note_id){
      return axios.delete(`/plot/notes/delete?noteId=${note_id}`)
  },
  plantNewCrop(crop){
    return axios.post(`/crops/myplot?plotId=${crop.plotId}`, crop)
  },
  updateCrop(crop){
    return axios.put(`/crops/myplot?plotId=${crop.plotId}`, crop)
  }
}
