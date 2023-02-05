<template>
  <div id="student-center-view">
    <div id="working-area-header">
      <h1 v-bind:to="{ name: 'courses', params: { id: course.courseId } }">
        {{ course.courseName }}
        <router-link v-bind:to="{ name: 'quizview' }"
          ><button>Go To Quiz</button></router-link
        >
      </h1>
    </div>
    <div id="homework-submission">
      <label id="hw-label" for="homework">Homework Submission Area</label>
      <br />
      <br />
      <input id="homework-textbox" type="text" />
      <br />
      <br />
      <button>Submit Homework</button>
    </div>
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

<style scoped>
#student-center-view {
  display: grid;
  grid-auto-columns: 1fr;
  grid-auto-rows: 1fr 1fr;
  grid-template-areas:
    "working-area-header"
    "homework-submission";
}
#working-area-header {
  display: flex;
  justify-content: center;
  grid-area: working-area-header;
}
#homework-submission {
  display: block;
  justify-content: center;
  grid-area: homework-submission;
}
#homework-textbox {
  padding: 150px;
}
</style>