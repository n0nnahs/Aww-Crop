<template>
  <div>
      <table>
        <tr>
            <td>
<button v-on:click="grid" />
            </td>
        </tr>
      </table>
  </div>
</template>

<script>


export default {
    data(){
        return{
            plotGrid:[[]]
        }
    },
    components:{
        
    },
    methods: {
        grid(){
            //take in height and create number of arrays in plotGrid
            //take in width and create length of arrays in plotGrid
            // assignCrops()
            let height = this.$store.state.plotSize.height - 1;
            let width = this.$store.state.plotSize.width;
            let row = [];
            for(let i = 0; i < width; i++){
                row.push(0);
            }
            for(let i = 0; i < height; i++){
                this.plotGrid.push(row)
            }
            this.assignCrops();
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
    }
}

</script>

<style>
table{
    border-color: black;
}
</style>