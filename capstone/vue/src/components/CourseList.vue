<template>
  <div>
      <h2>Courses List</h2>
      <div id="course-list">
          <course v-for="course in courses" v-bind:key="course.id" />
      </div>
  </div>
</template>

<script>
import Course from './Course.vue'
import PortalServices from '../services/PortalServices.js'

export default {
    name: "course-list",
    components: {
        Course
    },
    data () {
        return {
            courses: []
    } 
},
    created() {
        PortalServices.getAllCourses().then(response => {
            this.courses = response.data
        })
    }
}
</script>

<style scoped>
#course-list {
    display:flex;
    justify-content: space-around;
    flex-wrap: wrap;
}
h2 {
    display: flex;
    justify-content: center;
}
</style>