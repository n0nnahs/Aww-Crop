<template>
  <div v-bind="cropSquare"  >
      <form v-on:submit.prevent="submitNewCropToDatabase" class="cardForm" >
            <select id="vegetables" name="vegetable" v-model="vName">
                <option value="">Select a vegetable</option>
                <option value="beets">Beets</option>
                <option value="broccoli">Broccoli</option>
                <option value="brussels-sprouts">Brussels-Sprouts</option>
                <option value="cabbage">Cabbage</option>
                <option value="carrots">Carrots</option>
                <option value="cauliflower">Cauliflower</option>
                <option value="celery">Celery</option>
                <option value="corn">Corn</option>
                <option value="cucumbers">Cucumbers</option>
                <option value="lettuce">Lettuce</option>
                <option value="onions">Onions</option>
                <option value="peas">Peas</option>
                <option value="peppers">Peppers</option>
                <option value="potatoes">Potatoes</option>
                <option value="radishes">Radishes</option>
                <option value="spinach">Spinach</option>
                <option value="tomatoes">Tomatoes</option>
                <option value="turnips">Turnips</option>
                <option value="dirt">Dirt</option>
            </select>
            <button class="btn btn-submit" v-on:click="assignPlotInfo">Submit</button>
            <button class="btn btn-cancel" type="cancel">Cancel</button>
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
            vName: "",
            vegetable: {
                name: "",
                plotId: "",
                xCoordinate: "",
                yCoordinate: ""
            },
            errorMsg: "",
            isLoading: false
        }
    },
    methods: {
        onChange: function(e){
            let name = e.target.value;
            console.log('name ', name );
            this.vegetable.name = name;
        },
        assignName(){
            console.log(this.vegetable)
            
        },        
        assignPlotInfo(){
            console.log("assignplotinfor");
            this.vegetable.name = this.vName;
            this.vegetable.plotId = this.$attrs.plotId;
            this.vegetable.xCoordinate = this.$attrs.xCoordinate;
            this.vegetable.yCoordinate = this.$attrs.yCoordinate;
        },
        submitNewCropToDatabase(){
            this.assignPlotInfo();
            console.log(this.vegetable);
            PlotService.plantNewCrop(this.vegetable).then(response => {
                if(response.status === 201){
                    console.log("win");
                    this.$parent.$router.push(`/myplot/${this.$route.params.plotId}`);;
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
    computed: {

    },
    created(){
        this.assignPlotInfo();
        }
    }
}
</script>

<style>

</style>