<template>
  <section id="notes-section">
    <div>
      <h2 id="notes-h2">Notes</h2>
    </div>
    <div>
      <form class="new-note-form" v-on:submit.prevent="saveNote">
        <textarea class="message-input" placeholder="Note" v-model="note.message" />
        <button class="wendy">Save Note</button>
      </form>
    </div>
    <div class="notes-list">
      <note-card v-for="note in notes" v-bind:note="note" v-bind:key="note.plotId" />
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
      note: {
        plotId: this.$route.params.plotId,
        message: '',
        date: Date().toISOString().slice(0,10),
      }
    }
  },
  computed: {
    notes() {
      return this.$store.state.notes.filter((note) => {
        return note.plotId === "202";
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
      this.$store.commit('SAVE_NOTE', this.note);
      this.note = {
        message: '',
        date: '',
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
  height: 100vh;
}
 
#notes-section {
  color: white;
  background-color: #a53b58;;
  border-radius: 3px;
}

.new-note-form {
    margin: 20px;
}

.new-note-form input{
    margin: 10px;
    font-size: 1rem;
}
.wendy{
  text-align: center;
  color: white;
  background-color: #fe6f15;
  padding: 10px;
  border-radius: 3px;
}
</style>