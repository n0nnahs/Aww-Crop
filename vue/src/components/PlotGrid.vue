<template>
  <div class="plot-component">
      <header>
          Garden Plot
      </header>
      <div id="plot-grid">
      <table id="plot-grid-table" v-bind="grid" v-if="!isLoading">
        
        <tr v-for="cropRow in this.plotGrid" v-bind:key="cropRow">
            <td id="crop" v-for="croppy in cropRow" v-bind:key="croppy">
                <plot-crop v-on:click="assignNewCrop(this.croppy.xCoordinate, this.croppy.yCoordinate)" v-bind='croppy'></plot-crop>
            </td>
        </tr>
      </table>
      <div id="error" v-if="plotNotFound === true">Whoopsie!</div>
      </div>
  </div>
</template>

<script>
import PlotCrop from './PlotCrop.vue';
import plotService from "../services/PlotService";

export default {
    name: "plot-grid",
    data(){
        return{
            plotNotFound: false,
            isLoading: true,
            plotGrid: [],
            cropSquare: {
                name: "",
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
        PlotCrop
        
    },
    methods: {
        grid(){
            //take in height and create number of arrays in plotGrid
            //take in width and create length of arrays in plotGrid
            // assignCrops()

            // for(let i = 0; i < width; i++){
            //     row.push("0");
            // }

            this.assignCrops();
        },
        assignCrops(){
            let urlPlotId = this.$route.query.plotId
            plotService.getPlotCoordId(urlPlotId)
                .then(response => {
                    if (response.status == 200) {
                    this.$store.commit("SET_PLOT_GRID", response.data);
                    this.$store.commit("SET_ACTIVE_PLOT", response.data.plotId);
                    
                    let width = this.$store.state.activePlotSize.width;
                    let height = this.$store.state.activePlotSize.length;
                    
                    for(let i = 0; i < height; i++){
                        this.plotGrid.push(new Array(width).fill(this.cropSquare))
                    }

                    let arr = this.$store.state.plotGrid;
                    console.log(arr);
                    
                    arr.forEach(element => {
                        let x = element.xCoordinate;
                        let y = element.yCoordinate;
                        this.plotGrid[x][y].name = (element.name);
                        this.plotGrid[x][y].xCoordinate = (element.xCoordinate);
                        this.plotGrid[x][y].yCoordinate = (element.yCoordinate);
                        this.plotGrid[x][y].plotId = (element.plotId);
                    });
                    this.isLoading = false;
                    console.log(this.plotGrid);
                    }
                })
                .catch(error => {
                    const response = error.response;
                    if (response.status === 401) {
                        this.plotNotFound = true;
                    }
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

#error{
    color: red;
}

template{
    background-color: #4e2409;
}

header{
    text-align: center;
}

.plot-component{
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-content: center; 
    background-color: #4e2409;
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

}

#plant{
  height:3.25vw;
  width: 3.25vw;
}



</style>