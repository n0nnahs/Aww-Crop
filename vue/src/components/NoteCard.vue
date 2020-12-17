<template>
  <div class="notecard">

        <div
        id="deletedNote"
        class="alert alert-success"
        role="alert"
        v-if="wasDeleted"
       >It's party thyme, your note was deleted! 
        </div>

    <h3 id="note-date">{{ note.date }}</h3>
    <p id="note-body">{{ note.note }}</p>
    <button v-show="showDelete" id="edit-note-button" v-on:click="showAreYouSure=true">Delete Note</button>
    <div id="thinkTwice" v-show="showAreYouSure">
         <div
        id="deletedNote"
        class="alert alert-success"
        role="alert"
        v-if="wasDeleted"
       >It's party thyme, this note was deleted! 
        </div>
    <button id="imSure" v-on:click="deleteNote">Do it!</button>
    <button id="nevermind" v-on:click="showAreYouSure=false">Nope.</button>
    </div>
        <div
        id="deletedNote"
        class="alert alert-success"
        role="alert"
        v-if="wasDeleted"
       >It's party thyme, your note was deleted! 
        </div>
  </div>
</template>
 
<script>
import PlotService from '../services/PlotService'
export default {
  name: 'note-card',
  props: {
    note: Object
  }, 
  data(){
    return{
      showDelete: true,
      showAreYouSure: false,
      wasDeleted: false
    }
  },
  methods: {
    deleteNote(){PlotService.deleteNote(this.note.note_id).then(response => {
            if(response.status === 202){
              // alert("Note successfully deleted");
               this.$router.go('/');
            }
            this.wasDeleted = true;
          })

    }

    // deleteNote(){
    //   if(confirm("Are you sure you want to delete this note? This action cannot be undone!")){
    //      PlotService.deleteNote(this.note.note_id).then(response => {
    //        if(response.status === 202){
    //          alert("Note successfully deleted");
    //           this.$router.go('/');
    //        }
    //      })
    //   }
    // }
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
#edit-note-button:focus{
  outline:none;
}

 #imSure{
  font-size: 15px;
  margin: 5px;
  border-radius: 3px;
  color: white;
  background-color: #83a126;
  width:45%
 }
 #imSure:focus{
   outline:none;
 }
 #nevermind{
  font-size: 15px;
  margin: 5px;
  border-radius: 3px;
  color: white;
  background-color: #83a126;
  width:45%
 }
 #nevermind:focus{
   outline: none;
 }
 #deletedNote{
  color:#fe6f15;
  background-color: white;
  outline: none;
  padding: 25px;
  border-style: solid;
  border-color:#fe6f15;
  border-width:3px;
}
</style>