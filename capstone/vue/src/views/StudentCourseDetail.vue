<template>
  <div id="student-working-area">
    <div id="course-show">
      <student-course-area
        id="student-course-area"
        v-show="$store.state.user.authorities[0].name === 'ROLE_USER'"
      />
      <teacher-course-area
        id="teacher-course-area"
        v-show="$store.state.user.authorities[0].name === 'ROLE_ADMIN'"
      />
    </div>

    <div id="side-bar-show">
      <student-right-side-bar
        id="student-side-bar"
        v-show="$store.state.user.authorities[0].name === 'ROLE_USER'"
      />
      <teacher-right-side-bar
        id="teacher-side-bar"
        v-show="$store.state.user.authorities[0].name === 'ROLE_ADMIN'"
      />
    </div>
  </div>
</template>

<script>
import StudentRightSideBar from "../components/StudentRightSideBar.vue";
import StudentCourseArea from "../components/StudentCourseArea.vue";
import TeacherCourseArea from "../components/TeacherCourseArea.vue";
import TeacherRightSideBar from "../components/TeacherRightSideBar.vue";

export default {
  components: {
    StudentRightSideBar,
    StudentCourseArea,
    TeacherCourseArea,
    TeacherRightSideBar,
  },
};
</script>

<style scoped>
#student-working-area {
  display: grid;
  grid-template-columns: 2fr 1fr;
  grid-template-areas: "student-course-area student-side-bar";
  grid-column-gap: 3em;
   padding-left: 50px;
}
#teacher-working-area {
  display: grid;
  grid-template-columns: 2fr 1fr;
  grid-template-areas: "teacher-course-area teacher-side-bar";
  grid-column-gap: 3em;
  padding-left: 50px;
}
#class-title-header {
  grid-area: class-title-header;
}
#student-working-area {
  grid-area: student-working-area;
}
#student-course-area {
  /* border-right: solid; */
  padding: 15px;
  border-color: #75b9be;
  grid-area: student-course-area;
}
#student-side-bar {
  grid-area: student-side-bar;
  padding: 10px;
  height: 100%;
   padding-top: 30px;
  margin: 20px;
   width: 50%;
     padding-left: 80px;
}
#teacher-course-area {
  /* border-right: solid; */
  padding: 15px;
  border-color: #75b9be;
  grid-area: teacher-course-area;
}
#teacher-side-bar {
  grid-area: teacher-side-bar;
  padding: 10px;
  padding-top: 30px;
  height: 100%;
  width: 50%;
    padding-left: 80px;
}
</style>