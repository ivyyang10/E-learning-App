<template>
  <div id="all-homework">
    <br />
    <h1>Homework Submissions:</h1>
    <div id ="hwcomp">
      <div id="resp">Student's Response: {{ homework.hwSubmission }}</div>
    <grade-homework /></div>
    
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
#hwcomp {
  display: flex;
  align-items: center;
  flex-direction: column;
  padding: 70px;
}
#resp {
  border-style: solid;
  padding: 100px;
  border-radius: 20px;
}


</style>