<template>
  <div id="course-style">

    <button v-on:click="addStudentToCourse">{{userObject.username}}</button>

  </div>
</template>

<script>
import PortalServices from "../services/PortalServices";

export default {
  name: "student",
  props: {
    userObject: Object,
  },
  methods: {
    addStudentToCourse() {
      console.log(this.userObject)
      PortalServices.addStudentToCourse(this.$route.params.id, this.userObject)
      .then((response) => {
          if(response.status === 201) {
            alert('Student has been added');
          }
        })
        .catch(error => {
          console.error(error);
          alert('Sorry, this student has not been added');
        })
    }
  }
};
</script>

<style>
/* #course-style {
  border: 2px solid black;
  border-radius: 10px;
  padding: 15px;
} */
</style>