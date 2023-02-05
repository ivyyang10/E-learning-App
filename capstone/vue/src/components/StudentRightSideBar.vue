<template>
  <div id="student-right-view">
    <div id="description"
      v-bind:to="{ name: 'courses', params: { id: course.id } }"
    >
    <label id="description-labelID" for="description-label">Class Description:</label>
    <br>
      {{ course.description }}
    </div>
    <br>
    <div id="curricula">
      <label id="class-instructions-labelID" for="instruction">Class Instructions:</label>
      <div id="instruction">{{ course.dailyInstruction }}</div>
      <br>
      <label id="links-labelID" for="links-label">Class Resources:</label>
      <div id="links">{{ course.links }}</div>
    </div>
  </div>
</template>

<script>
import PortalServices from "../services/PortalServices";
export default {
  name: "Student-right-side-bar",
  data() {
    return {
      course: {
        courseId: "",
        courseName: "",
        description: "",
        difficulty: "",
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
#student-right-view {
  display: grid;
  grid-template-rows: 1fr 1fr;
  grid-template-areas: 
  'description'
  'curricula';
}
#description {
  border: solid;
  border-radius: 20px;
  padding: 15px;
  grid-area: description;
}
#curricula {
  border: solid;
  border-radius: 20px;
  padding: 15px;
  grid-area: curricula;
}
</style>