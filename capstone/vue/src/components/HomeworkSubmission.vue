<template>
  <div>
    <h1>Homework Submissions:</h1>
    {{ homework.hwSubmission }}
  </div>
</template>

<script>
import PortalServices from "../services/PortalServices";
export default {
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
      console.log(response);
    });
  },
};
</script>

<style>
</style>