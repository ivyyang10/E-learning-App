<template>
  <div id="teacherCenterView">
    <p v-bind:to="{ name: 'courses', params: { id: course.id } }">
      {{ course.name }}
      {{ course.dailyInstruction }}
      {{ course.links }}
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