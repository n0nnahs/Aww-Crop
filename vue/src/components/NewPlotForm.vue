<template>
    <div id="newPlot">
        <form class="new-plot-form" @submit.prevent="createNewPlot">
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
            <button type="submit">Add</button>
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
                    this.$router.push("/plots");
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

<style>

</style>