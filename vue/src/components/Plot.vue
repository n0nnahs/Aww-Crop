<template>
  <div class="plot-component">
      <img v-if="isLoading === true" src="../assets/loadingPlant.gif"/>
      <header>
          Garden Plot
      </header>
      <div id="plot-grid">
      <table id="plot-grid-table" v-bind="grid" v-if="!isLoading">
        
        <tr v-for="cropRow in this.plotGrid" v-bind:key="cropRow">
            <td id="crop" v-for="croppy in cropRow" v-bind:key="croppy">
                <img v-if="croppy ===undefined" id="plant" src="../assets/dirt.jpg" />
                <img v-if="croppy !==undefined" id="plant" src="../assets/plotPlant.jpg" />
            </td>
        </tr>
      </table>
      </div>
  </div>
</template>

<script>


export default {
    data(){
        return{
            isLoading: true,
            plotGrid: []
        }
    },
    components:{
        
        
    },
    methods: {
        grid(){
            //take in height and create number of arrays in plotGrid
            //take in width and create length of arrays in plotGrid
            // assignCrops()
            let width = this.$store.state.plotSize.width;
            let height = this.$store.state.plotSize.height;
            // for(let i = 0; i < width; i++){
            //     row.push("0");
            // }
            for(let i = 0; i < height; i++){
                this.plotGrid.push(new Array(width))
            }
            this.assignCrops();
            this.isLoading = false;
            console.log(this.plotGrid);
        },
        assignCrops(){
            //go through all of the locations in grid & assign crops to locations in grid & assign empty locations
            //sort information coming in
            let arr = this.$store.state.plotGrid;
            arr.forEach(element => {
                let x = element.x;
                let y = element.y;
                this.plotGrid[x] [y] = (element.id);
            });
        }
    },
    created(){
        this.grid();
    },
    computed:{

    }
}

</script>

<style>

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
}

#crop{
    border: 10px solid rgb(87, 53, 22);
    height: 50px;
    width: 50px;
}

#plot-grid{
    display: flex;
    justify-content: center;
}

#plant{
  height:50px;
  width: 50px;
}

td{

}

</style>