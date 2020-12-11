<template>
  <div>
      <button v-on:click="grid">Button</button>
      <table v-bind="grid" v-if="!isLoading">
        <thead>Plot</thead>
        <tr v-for="cropRow in this.plotGrid" v-bind:key="cropRow">
            <td v-for="crop in cropRow" v-bind:key="crop">
                {{crop}}
            </td>
        </tr>
      </table>
  </div>
</template>

<script>
import Crop from './Crop.vue';


export default {
    data(){
        return{
            isLoading: true,
            plotGrid:[[]]
        }
    },
    components:{
        Crop
        
    },
    methods: {
        grid(){
            //take in height and create number of arrays in plotGrid
            //take in width and create length of arrays in plotGrid
            // assignCrops()
            let width = this.$store.state.plotSize.width - 1;
            let height = this.$store.state.plotSize.height - 1;
            let row = [];
            for(let i = 0; i < width; i++){
                row.push(0);
            }
            for(let i = 0; i < height; i++){
                this.plotGrid.push(row)
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
                this.plotGrid[x][y] = (element.id);
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
div{
    justify-content: center;
}
table{
    border-color: black;
    table-layout: fixed;
    justify-content: center;
}
td{
    border: 1px solid black;
}
thead{
    color:antiquewhite;
    border: 1px solid black;
}
button{
    color: white;
    background-color: blue;
}
</style>