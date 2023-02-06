<template>
  <div id="course-style">
    <!-- <p>
      {{ userObject.username }}
    </p> -->

    <button v-on:click="addStudentToCourse">{{userObject.username}}</button>

    <!-- v-bind:to="{name: 'studentDetails', params:{id: $store.state.userObject.id}}" -->
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
#course-style {
  border: 2px solid black;
  border-radius: 10px;
  padding: 15px;
}
</style>