<template>
  <section id="notes-section">
    <div>
      <form class="new-note-form" v-on:submit.prevent="saveNote">
        <textarea class="message-input" placeholder="Note" v-model="newNote.note" required></textarea>
      <div id="medvitz">
        <button id="tom">Save Note</button>
      </div>
      </form>
    </div>
    <div class="notes-list">      
      <div
        id="createdNote"
        class="alert alert-success"
        role="alert"
        v-if="noteWasCreated"
       >Romaine calm, your note was created! 
        </div>
        <div
        id="notCreatedNote"
        class="alert alert-danger"
        role="alert"
        v-if="noteWasNotCreated"
       >Oh my gourd!  Something went wrong! We'll do better next thyme.
        </div>
      <note-card v-for="note in plotNotes" v-bind:note="note" v-bind:key="note.plotId" />
    </div>
  </section>
</template>
 
<script>
import NoteCard from '@/components/NoteCard.vue';
 import PlotService from '../services/PlotService';

export default {
  name: "notes",
  data() {
    return {
      noteWasCreated: false,
      noteWasnotCreated: false,
      newNote: {
        plot_id: parseInt(this.$route.params.plotId),
        note: '',
      }
    }
  },
  computed: {
    plotNotes() {
      let plot_id = this.$route.params.plotId;
      return this.$store.state.notes.filter((note) => {
        return note.plot_id == plot_id;
      });
    }
  },
  components: {
    NoteCard
  },
  created(){

  },
  methods: {
    saveNote() {
      PlotService.createNewNote(this.newNote).then(response => {
        if(response.status == 201){
          this.$parent.$router.go("/");
          this.noteWasCreated = true;
        }else{
          this.noteWasNotCreated = true;
        }
        })
      //I wasn't sure what the best action was here, so I just commented
      //the code out for now and put in the new, formatted error message.

      //I could always make a larger variety of messages for specific errors.
      //While I do think it's important to give error messages to users if it's
      //something they did wrong so that they can correct it, I thought a generic
      //message might be enough in this instance.
       
      //.catch(error => {
      //     this.noteWasNotCreated = true;
      //     if (error.response) {
      //       this.errorMsg = "Error submitting new board. Response received was '" + error.response.statusText + "'.";
      //     } else if (error.request) {
      //       this.errorMsg = "Error submitting new note. Server could not be reached.";
      //   } else {
      //       this.errorMsg = "Error submitting new note. Request could not be created.";
      //   }
      // })
      this.note = {
        plot_id: parseInt(this.$route.params.plotId),
        note: '',
      };
    }
  }
}
</script>
 
<style scoped>
textarea{
  width: 100%;
  border-radius: 3px;
}
#notes-h2{
  font-size: 32px !important;
  text-align: center;
  color: white;
  background-color: #fe6f15;
  padding: 10px;
  border-radius: 3px;
}

.notes-list {
  display:flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
}
 
#notes-section {
  color: white;
  background-color: #a53b58;;
  border-radius: 3px;
}

.new-note-form {
    margin: 20px;
}

.new-note-form input, .new-note-form button {
    margin: 10px;
    font-size: 1rem;
}
#tom{
  width: 30%;
  font-size: 18px;
  border-radius: 3px;
  text-align: center;
  padding: 3px;
  border-radius: 3px;
  background-color: #83a126;
  color: white;
  border-style: none;
}
#tom:hover{
  width: 30%;
  font-size: 18px;
  border-radius: 3px;
  text-align: center;
  border-radius: 3px;
  color: #83a126;
  background-color: white;
  border-style: none;
}
#tom:focus{
  outline:none;
}
#medvitz{
  display: flex;
  justify-content: space-around;
}
.message-input{
  outline-color:#83a126 !important;
}
#createdNote{
  color:white ;
  background-color: #83a126;
  outline: none;
}
#notCreatedNote{
  color:white ;
  background-color: rgb(228, 86, 86);
  outline: none;
}
</style>