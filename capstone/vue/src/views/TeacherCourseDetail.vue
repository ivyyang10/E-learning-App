<template>
  <div>
    <h1>Teacher Right Side Bar</h1>
    <teacher-right-side-bar />
    <teacher-course-area />
  </div>
</template>

<script>
import TeacherCourseArea from "../components/TeacherCourseArea.vue";
import TeacherRightSideBar from "../components/TeacherRightSideBar.vue";

export default {
  components: {
    TeacherCourseArea,
    TeacherRightSideBar,
  },
};
</script>

<style>
</style>