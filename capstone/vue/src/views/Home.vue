<template>
  <div class="home">
    <h1 id="school-name">Inquisit Course Page</h1>

    <teacher-portal-buttons id="teacher-buttons" />
    <student-progress v-show="$store.state.user.authorities[0].name === 'ROLE_USER'"/>

    <course-list id="course-list" />
  </div>
</template>

<script>
import CourseList from "../components/CourseList.vue";
import TeacherPortalButtons from "../components/TeacherPortalButtons.vue";
import StudentProgress from "../components/StudentProgress.vue"

export default {
  components: { CourseList, TeacherPortalButtons, StudentProgress },
  name: "home",
};
</script>

<style scoped>
.home {
  display: grid;
  padding-bottom: 100px;
  grid-auto-columns: 1fr 1fr 1fr;
  grid-auto-rows: 150px 1fr;
  grid-template-areas:
    "school-name school-name teacher-buttons"
    "course-list course-list course-list";
}
#school-name {
  grid-area: school-name;
  justify-content: left;
  padding: 10px;
  margin-left: 0px;
}
#teacher-buttons {
  grid-area: teacher-buttons;
  padding: 35px;
  padding-right: 50px;
  margin-top: 20px;
}
#course-list {
  grid-area: course-list;
  margin-bottom: 150px;
}
</style>
