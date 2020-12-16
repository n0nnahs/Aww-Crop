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
 
</style>