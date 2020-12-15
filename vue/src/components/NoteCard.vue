<template>
  <div class="notecard">
    <h3 id="note-date">{{ note.date }}</h3>
    <p id="note-body">{{ note.note }}</p>
    <button id="edit-note-button">Edit Note</button>
  </div>
</template>
 
<script>
export default {
  name: 'note-card',
  props: {
    note: Object
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
  display: grid;
  grid-template-rows:1fr 2fr 1fr;
  grid-template-areas:
    "date body button";
}
 
#note-date {
  font-size: 100%;
  text-align: center;
  margin: 5px;
  grid-area: date;
  display:flex;
  flex-direction: column;
  flex-flow: column wrap;
}

#note-body {
  grid-area: body;  
  display: flex;
  flex-direction: column;
  align-items: center;
}

#edit-note-button {
  grid-area: button;
  font-size: 15px;
  margin: 5px;
  align-content: bottom;
  border-radius: px;
}
 
#edit-note-button:hover {
  grid-area: button;
  font-size: 15px;
  background-color: #83a126;
  margin: 5px;
  color: white;
  align-content: bottom;
}
 
</style>