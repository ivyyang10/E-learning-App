<template>
  <div id="course-style">

    


<button v-on:click="addStudentToCourse()">{{userObject.username}}</button>

    <!-- <p>
    {{userObject.username}}
    </p> -->
    <!-- v-bind:to="{name: 'studentDetails', params:{id: $store.state.userObject.id}}" -->
  </div>
  
</template>

<script>
export default {
  name: "student",
  props: {
    userObject: Object,
  }

};
</script>

<style>
#course-style {
  border: 2px solid black;
  border-radius: 10px;
  padding: 15px;
}
</style>