<template>
  <div id="main-grid" class="home">
    <div id="home-grid">
        <shopping-list></shopping-list>
    </div>
  </div>
</template>

<script>
import ShoppingList from '../components/ShoppingList.vue';

export default {
  name: "home",
  components: {
      ShoppingList
  },
  data() {
      return {
          showForm: true,
      };
  },
  created() {
      this.showForm = false;
  },
  methods: {
      toggleForm() {
          if(this.showForm == false) {
            this.showForm = true;
          } else {
            this.showForm = false;
          }
      },
  },
}

</script>


<style >

.home {
  padding: 0 20px 20px 20px;
  background-color: #4e2409;
}
#home-grid {
  background-color: #4e2409;
  display: grid;
  column-gap: 20px;
  grid-template-columns:1fr;
  grid-template-areas:
    "shopping-list";
}
#my-garden{
  text-align: center;
  padding-bottom: 10px;
  padding-top: 10px;
  background-color:#ba7331;
  border-radius: 3px;
}
#plots {
  grid-area: plots;
  margin-top: 10px;
  background-color:#4e2409
}
#new-plot-section {
  background-color: #a53b58;
  margin-top: 0px;
  margin-bottom: 20px;
  column-gap: 50px;
  border-radius: 3px;
}
#add-new-plot-button {
  width: 100%;
  height: 55px;
  font-size: 32px;
  border-radius: 3px;
  text-align: center;
  color: #83a126;
  background-color: white;
  border-style: none;
}
#add-new-plot-button:hover, #add-new-plot-button:focus {
  border-style: none;
  outline: none;
  color: white !important;
  background-color: #83a126;
}
#my-crops{
  grid-area: my-crops;
  margin-top: 10px;
}
button:focus{
  border-style: none;
  outline: none;
}
@media (max-width: 800px){
      #main-grid {
        grid-template-columns: 100px;
        grid-template-areas:
            "my-garden"
            "new-plot-section"
            "aplots"
            "my-crops"
            "iplots";
      } 
      #my-garden{
        grid-area: my-garden;
      }
      #new-plot-section{
        grid-area: new-plot-section;
      }
      #aplots{
        grid-area: aplots;
      }
      #my-crops{
        grid-area: my-crops;
      }
      #iplots{
        grid-area: iplots;
      }
}
</style>
