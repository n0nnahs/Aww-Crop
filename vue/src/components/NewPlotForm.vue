<template>
    <div id="newPlot">
        <h1 >Create New Plot</h1>
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
        <label for="width" class="sr-only">Plot Width (Max 20)</label>
        <input
            type="number"
            max="20"
            id="width"
            class="user-input"
            placeholder="Plot Width (feet)"
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
            placeholder="Plot Length (feet)"
            v-model="plot.length"
            required
            autofocus
        />
        <br/>
        <button type="submit">Sign in</button>
    </div>
</template>

<script>
export default {

}
</script>

<style>

</style>