<template>
  <div class="home">
    <h1>Welcome to Thwin Secondary School</h1>
    <p>This is the home portal page for students and teachers</p>
    <course-list />
  </div>
</template>

<script>
import CourseList from '../components/CourseList.vue';

export default {
  components: { CourseList },
  name: "home"
};
</script>
