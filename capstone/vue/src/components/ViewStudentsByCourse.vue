<template>
  <div>
    <br>
    <h1>Enrolled Students:</h1>
  
    <div id="student-list">
      <student-card v-for="userObject in studentCourseArray"
        v-bind:key="userObject.id"
        v-bind:userObject="userObject"/>
    </div>


  </div>
</template>

<script>
import StudentCard from './StudentCard.vue'
import PortalServices from '../services/PortalServices'
export default {
  components: { StudentCard },
  name: "view-students-by-course",
  data(){
    return {
      studentCourseArray: []
    }
  },
  created() {
    PortalServices.listAllUsers().then(
      (response) => {
        this.studentCourseArray = response.data;
      }
    )
  }
  // methods: {
  //   getAllStudentsByCourseId() {
  //     PortalServices.getAllStudentsByCourseId().then(response => {
  //       this.$store.
  //     })
  //   }
  // }
  
}
</script>

<style>

</style>