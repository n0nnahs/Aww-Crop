<template>
  <div id="details-body">
    <h1 id="crop-details-h1">
      <i class="fas fa-seedling"></i>
      Crop Details
      <i class="fas fa-seedling"></i>
    </h1>
    <crop-details-individual />
    <button id="back-button" @click="$router.go(-1)">
      <i class="fas fa-seedling"></i>
      Go Back
      <i class="fas fa-seedling"></i>
    </button>
  </div>
</template>

<script>
import CropDetailsIndividual from "../components/CropDetailsIndividual"

export default {
  components: {
    CropDetailsIndividual
  }
}
</script>

<style scoped>
#back-button:focus{
  outline:none;

}
#details-body {
  padding: 20px;
  /* height: 100vh; */
  background-color: #4e2409;
}

#crop-details-h1 {
  text-align: center;
  padding-bottom: 20px;
  padding-top: 20px;
  margin-bottom: 10px;
  background-color:#ba7331;
  border-radius: 3px;
}

/* crop-details-individual {
    overflow: scroll;
    height: 100vh; 
} */

#back-button {
  width: 100%;
  height: 65px;
  font-size: 32px;
  align-content: bottom;
  border-radius: 3px;
  text-align: center;
  padding: 10px;
  color: #83a126 !important;
  background-color: white;
  border-style: none;
}
#back-button:hover {
  width: 100%;
  height: 65px;
  margin-bottom: 0px;
  font-size: 32px;
  align-content: bottom;
  text-align: center;
  padding: 10px;
  border-radius: 3px;
  color: white !important;
  background-color: #83a126;

}


</style>