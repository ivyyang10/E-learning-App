<template>
  <div>View All Students Component
    <div id="student-list">
      <student-card v-for="userObject in $store.state.users"
        v-bind:key="userObject.id"
        v-bind:userObject="userObject"/>
    </div>


  </div>
</template>

<script>
import StudentCard from './StudentCard.vue'
// import PortalServices from '../services/PortalServices'
export default {
  components: { StudentCard },
  name: "view-students-by-course",
  data(){
    return {
      studentCourseArray: []
    }
  },
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