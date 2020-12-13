<template>
  <div class="card">
    <h3 id="note-date">{{ note.date }}</h3>
    <p id="note-body">{{ note.message }}</p>
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
 
<style>
.card {
  border: 2px solid black;
  border-radius: 10px;
  width: 220px;
  height: 200px;
  margin: 20px;
  background-color: #a53b58 !important;
  display: flex;
  flex-direction: column;
  justify-content: flex-end;
  align-items: center;
}
 
#note-date {
  font-size: 100%;
  text-align: center;
  margin: 5px;
}
 
#edit-note-button {
  font-size: 15px;
  margin: 5px;
  align-content: bottom;
  border-radius: 10px;
}
 
#edit-note-button:hover {
  font-size: 15px;
  background-color: #83a126;
  margin: 5px;
  color: white;
  align-content: bottom;
}
 
</style>