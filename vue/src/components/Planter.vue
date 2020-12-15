<template>
  <div v-bind="cropSquare">
      <form v-on:submit.prevent="assignName" class="cardForm">
            <label for="cars">Choose a vegetable:</label>
            <select id="vegetables" name="Vegetables">               
                <option value="beets">{{value}}</option>
                <option value="broccoli">{{value}}</option>
                <option value="brussels-sprouts">{{value}}</option>
                <option value="cabbage">{{value}}</option>
                <option value="carrots">{{value}}</option>
                <option value="cauliflower">{{value}}</option>
                <option value="celery">{{value}}</option>
                <option value="corn">{{value}}</option>
                <option value="cucumbers">{{value}}</option>
                <option value="lettuce">{{value}}</option>
                <option value="onions">{{value}}</option>
                <option value="peas">{{value}}</option>
                <option value="peppers">{{value}}</option>
                <option value="potatoes">{{value}}</option>
                <option value="radishes">{{value}}</option>
                <option value="spinach">{{value}}</option>
                <option value="tomatoes">{{value}}</option>
                <option value="turnips">{{value}}</option>
                <option value="dirt">{{value}}</option>
            </select>
            <button class="btn btn-submit">Submit</button>
            <button class="btn btn-cancel" v-on:click.prevent="cancelForm" type="cancel">Cancel</button>
      </form>
  </div>
</template>

<script>
import PlotService from "../services/PlotService"

export default {
    name: "planter",
    props: [ 'cropSquare' ],
    data(){
        return {
            vegetable: {
                name: "",
                plotId: "",
                xCoordinate: "",
                yCoordinate: ""
            },
            errorMsg: ""
        }
    },
    methods: {
        assignPlotInfo(){
            this.vegetable.name = this.cropSquare.name;
            this.vegetable.plotId = this.cropSquare.plotId;
            this.vegetable.xCoordinate = this.cropSquare.xCoordinate;
            this.vegetable.yCoordinate = this.cropSquare.yCoordinate;
        },
        assignName(plantName){
            this.vegetable.name = plantName;
            if(this.vegetable.name !== ""){
                this.submitNewCropToDatabase();
            }
        },
        submitNewCropToDatabase(){
            PlotService.plantNewCrop(this.vegetable).then(response => {
                if(response.status === 201){
                    //route back
                }
            })
            .catch((error) => {
                this.errorMsg = "";

                if(error.response) {
                    if(error.response.status===500) {
                        this.errorMsg = "Error submitting form. An internal server error occurred.";
                    } else if(error.response.status === 404) {
                        this.errorMsg = "Error submitting form. URL could not be found.";
                    } else {
                        this.errorMsg = "Error submitting form. Response received was code " + error.response.status + " '" + error.response.statusText + "'.";
                    }
                } else if (error.request){
                    this.errorMsg = "Error submitting form. Server could not be reached."
                } else {
                    this.errorMsg = "Error submitting form. Request could not be created."
                }
                console.log(this.errorMsg);
            })
    },
    created(){

        }
    }
}
</script>

<style>

</style>