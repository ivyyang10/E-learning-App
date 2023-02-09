<template>
  <div>
     <div id="grading-div">
        <form class="grade-homework-form" id = "gradeform" v-on:submit.prevent = "postGrade">
            <select id="grading-options" name="grading" v-on:change="onChange($event)" class="form-select">
            <option value = ""> Grade Submission Here</option>
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
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>
#grading-div {
   display: flex;
   justify-content: flex-end;
   margin: 50px
}
#grading-options {
   padding: 35px;
   border-radius: 25px;
   font-weight: bold;
   font-size: 1rem;
}
</style>
