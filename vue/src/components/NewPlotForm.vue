<template>
    <div id="form-section">
        <form class="new-plot-form" @submit.prevent="createNewPlot" align="center">
            <label for="name" class="sr-only">Plot Name</label>
            <input
                type="text"
                maxlength="35"
                id="name"
                class="user-input"
                placeholder="Plot Name"
                v-model="plot.name"
                required
                autofocus
            />
            <br/>
            <label for="width" class="sr-only">Plot Width</label>
            <input
                type="number"
                max="20"
                id="width"
                class="user-input"
                placeholder="Width (max 20 feet)"
                v-model="plot.width"
                required
                autofocus
            />
            <br/>
            <label for="length" class="sr-only">Plot Length</label>
            <input
                type="number"
                id="length"
                class="user-input"
                placeholder="Length (feet)"
                v-model="plot.length"
                required
                autofocus
            />
            <br/>
            <button id="newPlotSubmit" type="submit">Let's Start Planting!</button>
        </form>
    </div>
</template>

<script>
import plotService from "../services/PlotService";

export default {
    name: 'new-plot-form',
    data() {
    return {
      plot: {
        name: "",
        width: "",
        length: ""
      },
    };
    },
    methods: {
     createNewPlot() {
        plotService
            .createNewPlot(this.plot)
            .then(response => {
                if (response.status == 201) {
                    this.$router.go("/");
                }
            })
            .catch(error => {
                const response = error.response;
                console.log(response.status);
            });
        }
    }
}
</script>

<style scoped>
form {
  background-color: #a53b58;
  margin: 0px;
  margin-bottom: 20px;
  column-gap: 50px;
  border-radius: 3px;
}
input {
    border-radius: 3px;
    height: 35px;
    border-style: none;
}
#newPlotSubmit {
    margin-top: 10px;
    padding: 5px;
    padding-right: 10px;
    color: #fe6f15;
    border-radius: 3px;
    margin-bottom: 10px;
    width: 90%;
    color: white;
    background-color: #83a126;
    font-size: 20px;
    font-weight: bold;
}
button{
    border-style: none;
}
button:focus{
    border-style: none;
    outline: none;
}
#name:focus{
  outline-color: #83a126 !important;
}
#length:focus{
  outline-color: #83a126;
}
#width:focus{
  outline-color: #83a126;
}
</style>