<template>
  <div>
      <form class="grade-homework-form" id = "gradeform" v-on:submit.prevent = "postGrade">
            <select name="Difficulty" v-on:change="onChange($event)" class="form-select">
            <option value = ""> Select Difficulty Level</option>
            <option value ="1"> 1</option>
            <option value ="2"> 2</option>
            <option value ="3"> 3</option>
               <option value ="4"> 4</option>
            <option value ="5"> 5</option>
            <option value ="6"> 6</option>
               <option value ="7"> 7</option>
            <option value ="8"> 8</option>
            <option value ="9"> 9</option>
            <option value ="10"> 10</option>
        </select>
      </form>
  </div>
</template>

<script>
export default {

}
</script>

<style>

</style>