<template>
  <div id="studentCenterView">
    <p v-bind:to="{ name: 'courses', params: { id: course.courseId } }">
      {{ course.name }}
      {{ course.dailyInstruction }}
      {{ course.links }}
    <router-link v-bind:to="{ name: 'quizview' }"><button>Go To Quiz</button></router-link>
    <label for="homework">Homework Submission Area</label>
    <input type="text">
    <button>Submit Homework</button>
    </p>
  </div>
</template>

<script>
import PortalServices from "../services/PortalServices";

export default {
  data() {
    return {
      course: {
        courseId: "",
        courseName: "",
        cost: "",
        dailyInstruction: "",
        links: "",
        hwAssignment: "",
        teacherId: "",
      },
    };
  },
  created() {
    PortalServices.getCourses(this.$route.params.id).then((response) => {
      this.course = response.data;
      console.log(response);
    });
  },
};
</script>

<style>
</style>