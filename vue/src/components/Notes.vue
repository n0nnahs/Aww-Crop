<template>
  <section id="notes-section">
    <h2>Notes</h2>
    <form class="new-note-form" v-on:submit.prevent="saveNote">
      <input class="plotId-input" type="text" placeholder="Plot ID" v-model="note.plotId" />
      <input class="message-input" type="text" placeholder="Note" v-model="note.message" />
      <input class="date-input" type="text" placeholder="Date" v-model="note.date" />
      <button>Save Note</button>
    </form>
    <div class="notes-list">
      <note-card v-for="note in notes" v-bind:note="note" v-bind:key="note.plotId" />
    </div>
  </section>
</template>
 
<script>
import NoteCard from '@/components/NoteCard.vue';
 
export default {
  name: "notes",
  data() {
    return {
      note: {
        plotId: '',
        message: '',
        date: '',
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
  methods: {
    saveNote() {
      this.$store.commit('SAVE_NOTE', this.note);
      this.note = {
        plotId: '',
        message: '',
        date: '',
      };
    }
  }
}
</script>
 
<style>
.notes-list {
  display:flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
}
 
#notes-section {
  justify-content: center !important;
  justify-items: center !important;
}

.new-note-form {
    margin: 20px;
}

.new-note-form input, .new-note-form button {
    margin: 10px;
    font-size: 1rem;
}
</style>