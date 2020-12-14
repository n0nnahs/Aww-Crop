<template>
  <div class="plot-component">
      <header id="garden-plot-header">
          Garden Plot
      </header>
      <div id="plot-grid">
      <table id="plot-grid-table" v-bind="grid" v-if="!isLoading">
        
        <tr v-for="cropRow in this.plotGrid" v-bind:key="cropRow">
            <td id="crop" v-for="cropCell in cropRow" v-bind:key="cropCell.name">
                <!--<img  id="plant" src="@/assets/dirt.jpg" />
                <img v-if='croppy.name !==""' id="plant" src="../assets/peas.jpeg" />{{cropCell.name}}-->
                <img id="plant" :src="require(`@/assets/${cropCell.name}.jpeg`)"  />
                
            </td>
        </tr>
      </table>
      <div id="error" v-show="plotNotFound === true">Whoopsie!</div>
      </div>
  </div>
</template>

<script>
//import PlotCrop from './PlotCrop.vue';
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
                name: "dirt",
                xCoordinate: 0,
                yCoordinate: 0,
                plotId: 0
            }
        }
    },
    props: [
        'croppy'    
    ],
    components:{
        //PlotCrop
        
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
                            this.plotGrid.push(new Array(width).fill(this.cropSquare))
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
        assignNewCrop(y, x){
            console.log(x, y);
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
  border-radius: 10px;
}

#error{
    color: red;
}

template{
    background-color: #4e2409;
}

.plot-component{
  color: white;
  background-color: #a53b58;;
  border-radius: 10px;
  height: 100vh;
}

#plot-grid-table{
    display: absolute;
    table-layout: fixed;
    justify-content: center;
    margin: 10px;
    max-width: 100%;
    height: auto;
}

#crop{
    border: .5vw solid rgb(87, 53, 22);
    height: 3vw;
    width: 3vw;
}

#plot-grid{
  display: flex;
  justify-content: center;
  color: white;
  background-color: #a53b58;;
  border-radius: 10px;
  height: 100vh;
}

#plant{
  height:3.25vw;
  width: 3.25vw;
}



</style>