<template>
  <div class="home">
    <h1 id="school-name">Welcome to Thwin Secondary School</h1>

    <div>
    <teacher-portal-buttons id="teacher-buttons"/>
    </div>
    
    <course-list id="course-list"/>
  </div>
</template>

<script>
import CourseList from '../components/CourseList.vue';
import TeacherPortalButtons from '../components/TeacherPortalButtons.vue';
// import PortalServices from '../services/PortalServices';

export default {
  
  components: { CourseList, TeacherPortalButtons },
  name: "home"
};
</script>

<style scoped>
.home {
  display: grid;
  grid-auto-columns: 1fr 1fr 1fr;
  grid-auto-rows: 1fr 1fr;
  grid-template-areas: 
  'school-name school-name teacher-buttons'
  'course-list course-list course-list';
}
#school-name {
  grid-area: school-name;
}
#teacher-buttons {
  grid-area: teacher-buttons;
  padding: 25px;
}
#course-list {
  grid-area: course-list;
}
</style>
