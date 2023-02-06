<template>
  <div>
    <h2>Courses List</h2>
    <div id="course-list">
      <course
        v-for="course in $store.state.courses"
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
  },
};
</script>

<style scoped>
#course-list {
  display: flex;
  justify-content: space-between;
  flex-wrap: wrap;
}
h2 {
  display: flex;
  justify-content: center;
}
</style>