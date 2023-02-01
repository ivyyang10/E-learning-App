<template>
  <div>
      <h2>Courses List</h2>
      <div id="course-list">
          <course v-for="course in $store.state.courses" v-bind:course="course" v-bind:key="course.id" />
      </div>
  </div>
</template>

<script>
import Course from './Course.vue'
export default {
    name: "course-list",
    components: {
        Course
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