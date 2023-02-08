<template>
  <div class="home">
    <h1 id="school-name">Thwin's Secondary School</h1>
    <teacher-portal-buttons id="teacher-buttons" />
    <student-progress id="progress" v-if="$store.state.user.authorities[0].name === 'ROLE_USER'"/>

    <course-list id="course-list"/>
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
    "school-name progress teacher-buttons "
    "course-list course-list course-list";
  background-color: #f5f5f5;
}
#school-name {
  grid-area: school-name;
  justify-content: left;
  margin: 50px;
  text-decoration: underline;
  white-space: nowrap;
}
#progress {
  grid-area: progress;
  justify-content: right;
  margin: 50px;
}
#teacher-buttons {
  grid-area: teacher-buttons;
  justify-content: center;
  padding-right: 50px;
  margin-top: 33px;
}
#course-list {
  grid-area: course-list;
  margin-bottom: 150px;
}
</style>
