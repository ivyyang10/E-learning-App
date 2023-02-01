<template>
  <div class="home">
    <h1>Welcome to Thwin Secondary School</h1>
    <p>This is the home portal page for students and teachers</p>
    <teacher-portal-buttons/>
    <course-list/>
  </div>
</template>

<script>
import CourseList from '../components/CourseList.vue';
import TeacherPortalButtons from '../components/TeacherPortalButtons.vue';

export default {
  components: { CourseList, TeacherPortalButtons },
  name: "home"
};
</script>
