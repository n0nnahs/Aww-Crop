<template>
  <div class="plot-component" v-if="this.plotIsLoading">
      <h2 id="garden-plot-header">
          Find Your Inner Peas 
      </h2>
      <planter id="planter-choice" v-if="!this.planterViewable" v-bind="cropSquare"></planter>
      <div id="plot-grid">
      <table id="plot-grid-table" v-bind="grid" >       
        <tr v-for="cropRow in this.plotGrid" v-bind:key="cropRow">
            <td id="crop" class="square" v-for="cropCell in cropRow" v-bind:key="cropCell.name">
                <a class="tile" href="#" onclick="this.focus()">
                <img class="content" v-on:click="clickCrop(cropCell.xCoordinate, cropCell.yCoordinate, cropCell.plotId, cropCell.name)" id="plant" :src="require(`@/assets/${cropCell.name}.jpeg`)"  />     
                </a>
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
            planterViewable: true,
            plotIsLoading: false,
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
                        console.log(response.status, "crops came in");
                        this.$store.commit("SET_PLOT_GRID", response.data);

                        let arr = this.$store.state.plotGrid;

                        arr.forEach(element => {
                            let x = element.yCoordinate;
                            let y = element.xCoordinate;
                            this.plotGrid[x][y] = element;
                        });
                        console.log("still working")
                        this.plotIsLoading = true;
                        console.log("should show")
                    }
                })
                .catch(error => {
                    console.log(error.status);
                    });
            
            //go through all of the locations in grid & assign crops to locations in grid & assign empty locations
            //sort information coming in

        },
        clickCrop(y, x, plotId, name){
            this.planterViewable = false;
            if(name === "dirt"){
                console.log(x, y, plotId, "empty plot");
                this.cropSquare.name = "dirt";
                this.cropSquare.xCoordinate = y;
                this.cropSquare.yCoordinate = x;
                this.cropSquare.plotId = this.$route.params.plotId;
            } else {
                console.log(x, y, name)
                this.cropSquare.name = name;
                this.cropSquare.xCoordinate = y;
                this.cropSquare.yCoordinate = x;
                this.cropSquare.plotId = this.$route.params.plotId;
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

#planter-choice{
    text-align: center;
}

#error{
    color: red;
}

template{
    background-color: #4e2409;
}

.plot-component{
    display: flex;
    flex-direction: column;
    justify-content: center;
    color: white;
    background-color: #a53b58;;
    border-radius: 3px;
    padding-bottom: 10%;
}

#plot-grid-table{
    table-layout: fixed;
    margin-bottom: 20%;
    background-color: #4e2409;
    padding-bottom: 30%;
}

.tile:focus img{
    border: 1vh solid red !important;
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