<template>
  <div id="all-homework">
    <br />
    <h1>Homework Submissions:</h1>
    {{ homework.hwSubmission }}
    <grade-homework />
  </div>
</template>

<script>
import PortalServices from "../services/PortalServices";
import GradeHomework from "./GradeForm.vue";

export default {
  components: {
    GradeHomework,
  },
  data() {
    return {
      homework: {},
    };
  },

  created() {
    PortalServices.getHWByCourseStudentId(
      this.$route.params.courseId,
      this.$route.params.studentId
    ).then((response) => {
      this.homework = response.data;
    });
  },
};
</script>

<style scoped>
</style>