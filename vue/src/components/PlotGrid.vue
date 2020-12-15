<template>
  <div class="plot-component" v-if="!isLoading">
      <h2 id="garden-plot-header">Garden Plot</h2>
      <planter></planter>
      <div id="plot-grid">
      <table id="plot-grid-table" v-bind="grid" >       
        <tr v-for="cropRow in this.plotGrid" v-bind:key="cropRow">
            <td id="crop" class="square" v-for="cropCell in cropRow" v-bind:key="cropCell.name">
                <img class="content" v-on:click="clickCrop(cropCell.xCoordinate, cropCell.yCoordinate, cropCell.plotId, cropCell.name)" id="plant" :src="require(`@/assets/${cropCell.name}.jpeg`)"  />     
            </td>
        </tr>
      </table>
      <div id="error" v-show="plotNotFound === true">Whoopsie!</div>
      </div>
  </div>
</template>

<script>
import Planter from './Planter.vue';
import plotService from "../services/PlotService";

export default {
    name: "plot-grid",
    data(){
        return{
            //defaultImg: 'require("../assets/dirt.jpg")',
            plotNotFound: false,
            isLoading: true,
            plotGrid: [],
            cropSquare: {
                name: "",
                xCoordinate: "",
                yCoordinate: "",
                plotId: ""
            }
        }
    },
    props: [
        'croppy'    
    ],
    components:{
        Planter  
    },
    methods: {
        //imgError(){this.src = this.defaultImg;},
        grid(){
            //take in height and create number of arrays in plotGrid
            //take in width and create length of arrays in plotGrid

            let urlPlotId = this.$route.params.plotId;
            plotService.getPlotById(urlPlotId)
                .then(response => {
                    if(response.status === 200){    
                        this.$store.commit("SET_ACTIVE_PLOT", response.data);
                        let width = this.$store.state.activePlotSize.width;
                        let height = this.$store.state.activePlotSize.length;

                        for(let i = 0; i < height; i++){
                            
                            let array = [];
                            for(let j = 0; j < width; j++){
                               let newPlant = {
                                name: "dirt",
                                xCoordinate: j,
                                yCoordinate: i,
                                plotId: urlPlotId
                            };
                               array.push(newPlant)
                            }                                                
                            this.plotGrid.push(array);                            
                        }                       
                        this.assignCrops(); 
                    }
                })
                .catch(error => {
                    console.log(error.status)
                });

        },
        assignCrops(){
            let urlPlotId = this.$route.params.plotId;
            console.log(urlPlotId);
            plotService.getPlotCoordId(urlPlotId)
                .then(response => {
                    if (response.status == 200) {
                        console.log(response.status);
                        this.$store.commit("SET_PLOT_GRID", response.data);

                        let arr = this.$store.state.plotGrid;

                        arr.forEach(element => {
                            let x = element.xCoordinate;
                            let y = element.yCoordinate;
                            this.plotGrid[x][y] = element;
                        });
                        this.isLoading = false;
                    }
                })
                .catch(error => {
                    console.log(error.status);
                    });
            
            //go through all of the locations in grid & assign crops to locations in grid & assign empty locations
            //sort information coming in

        },
        clickCrop(y, x, plotId, name){
            if(name === "dirt"){
                console.log(x, y, plotId, "empty plot");
            } else {
                console.log(x, y, name)
            }
            
        },

    },
    created(){
        this.grid();
    },
    computed:{

    }
}

</script>

<style>

#garden-plot-header{
  font-size: 32px !important;
  text-align: center;
  color: white;
  background-color: #fe6f15;
  padding: 10px;
  border-radius: 3px;
}

#error{
    color: red;
}

template{
    background-color: #4e2409;
}

.plot-component{
    display: flex;
    justify-content: center;
    color: white;
    background-color: #a53b58;;
    border-radius: 3px;
    padding-top: 10%;
    padding-right: 5%;
    padding-left: 5%;
    padding-bottom: 10%;
}

#plot-grid-table{
    table-layout: fixed;
    margin-bottom: 20%;
    background-color: #4e2409;
    padding-bottom: 30%;
}

#crop{
    border: .5vw solid rgb(87, 53, 22);
    height: 3.25vh;
    width: 3.25vh;
    padding: 0vw;
}

#plot-grid{
  display: flex;
  justify-content: center;
  color: white;
  background-color: #a53b58;;
  border-radius: 3px;
  height: 100vh;
}

#plant{
  height:3.25vw;
  width: 3.25vw;
  padding: 0vw;
}



</style>