<template>

    <div id="student-working-area">  
      <student-course-area id="student-course-area" />
      <student-right-side-bar id="student-side-bar" />
    </div>

</template>

<script>
import StudentRightSideBar from "../components/StudentRightSideBar.vue";
import StudentCourseArea from "../components/StudentCourseArea.vue";

export default {
  components: {
    StudentRightSideBar,
    StudentCourseArea,
  },
};
</script>

<style scoped>
#student-working-area {
  display: grid;
  grid-template-columns: 4fr 1fr;
  grid-template-areas: 
  "student-course-area student-side-bar";
}
#class-title-header {
  grid-area: class-title-header;
}
#student-working-area {
  grid-area: student-working-area;
}
#student-course-area {
    border-right: solid;
    padding-right: 15px;
  border-color: black;
  grid-area: student-course-area;
}
#student-side-bar {
  grid-area: student-side-bar;
  padding: 10px;
}
</style>