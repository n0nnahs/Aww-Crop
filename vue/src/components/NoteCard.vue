<template>
  <div class="notecard">
    <h3 id="note-date">{{ note.date }}</h3>
    <p id="note-body">{{ note.note }}</p>
    <button id="edit-note-button" v-on:click="deleteNote">Delete Note</button>
  </div>
</template>
 
<script>
import PlotService from '../services/PlotService'
export default {
  name: 'note-card',
  props: {
    note: Object
  }, 
  methods: {
    deleteNote(){
      if(confirm("Are you sure you want to delete this note? This action cannot be undone!")){
         PlotService.deleteNote(this.note.note_id).then(response => {
           if(response.status === 202){
             alert("Note successfully deleted");
              this.$router.go('/');
           }
         })
      }
    }
  }
}
 
 </script>
 
<style scoped>

.notecard {
  border-radius: 3px;
  width: 220px;
  height: 200px;
  margin: 20px;
  background-color: #ba7331 !important;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  padding: 5px;

} 
#note-date {
  font-size: 100%;
  text-align: center;
  margin: 5px;
  background-color: #fe6f15;
  color: white;
  padding: 5px;
}

#note-body {
   text-align: center;
  
}

#edit-note-button {
  font-size: 15px;
  margin: 5px;
  border-radius: 3px;
  color: white;
  background-color: #83a126;

}
 
#edit-note-button:hover {
  grid-area: button;
  font-size: 15px;
  color: #83a126;
  background-color: white;
  margin: 5px;
}
 
</style>