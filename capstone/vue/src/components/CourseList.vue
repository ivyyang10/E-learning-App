<template>
  <div>
    <div id="course-list">
      <course
        v-for="course in $store.state.courses"
        v-bind:key="course.id"
        v-bind:course="course"
      />
      <course
        v-for="course in studentCourses"
        v-bind:key="course.id"
        v-bind:course="course"
      />
    </div>
  </div>
</template>

<script>
import Course from "../components/Course.vue";
import PortalServices from "../services/PortalServices.js";

export default {
  name: "course-list",
  components: {
    Course,
  },
  data() {
    return {
      courses: [],
      studentCourses: []
    };
  },
  methods: {
    getAllCourses() {
      PortalServices.getAllCourses().then((response) => {
        this.courses = response.data;
        this.$store.commit("SAVE_COURSE", this.courses);
      });
    },
  },
  created() {
    this.getAllCourses();
    PortalServices.getCourseByStudentId().then(
      (response) => {
        this.studentCourses = response.data;
      }
    )
  },
};
</script>

<style scoped>
#course-list {
  display: flex;
  justify-content: flex-start;
  flex-wrap: wrap;
  margin: 1rem;
}
</style>