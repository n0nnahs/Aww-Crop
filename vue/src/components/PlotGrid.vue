<template>
  <div class="plot-component">
      <header>
          Garden Plot
      </header>
      <div id="plot-grid">
      <table id="plot-grid-table" v-bind="grid" v-if="!isLoading">
        
        <tr v-for="cropRow in this.plotGrid" v-bind:key="cropRow">
            <td id="crop" v-for="croppy in cropRow" v-bind:key="croppy">
                <plot-crop v-on:click="assignNewCrop(this.croppy.xCoordinate, this.croppy.yCoordinate)" v-bind='croppy.name'>{{croppy.name}}</plot-crop>
            </td>
        </tr>
      </table>
      <div id="error" v-show="plotNotFound === true">Whoopsie!</div>
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
            let urlPlotId = this.$route.params.plotId;
            console.log(urlPlotId);
            plotService.getPlotCoordId(urlPlotId)
                .then(response => {
                    if (response.status == 200) {
                        console.log(response.status);
                        this.$store.commit("SET_PLOT_GRID", response.data);
                        console.log("SET_PLOT_GRID");
                        //this.$store.commit("SET_ACTIVE_PLOT", response.data.plotId);
                        //console.log("SET_ACTIVE_GRID");
                        
                        let width = this.$store.state.activePlotSize.width;
                        let height = this.$store.state.activePlotSize.length;
                        
                        for(let i = 0; i < height; i++){
                            this.plotGrid.push(new Array(width).fill(this.cropSquare))
                        }
                        console.log("broke the indexing");
                        this.plotGrid.forEach(row => {
                            row.forEach(object => {
                                object.xCoordinate = row.indexOf(object);
                                object.yCoordinate = this.plotGrid.indexOf(row);
                            });
                        });
                        console.log(this.plotGrid);
                        let arr = this.$store.state.plotGrid;
                        
                        
                        arr.forEach(element => {
                            let x = element.xCoordinate;
                            console.log(x)
                            let y = element.yCoordinate;
                            console.log(y);
                            this.plotGrid[x][y] = element;
                            console.log(element);
                        });
                        console.log(this.plotGrid);
                        this.isLoading = false;
                        console.log(this.plotGrid);
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