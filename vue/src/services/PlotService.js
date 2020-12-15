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
  getNotesForPlot(plotId){
      return axios.get(`/plot/notes/${plotId}`)
  },
  updateNote(note, note_id){
      return axios.put(`/plot/notes/update/${note_id}, note`)
  }

}
