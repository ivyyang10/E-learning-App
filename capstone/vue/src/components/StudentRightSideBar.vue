<template>
  <div id="student-right-view">
    <h2 id="student-class-details-title">Class Details</h2>
    <br />
    <div
      id="description"
      v-bind:to="{ name: 'courses', params: { id: course.id } }"
    >
      <label id="description-labelID" for="description-label"
        >Class Description:</label
      >
      <br />
      {{ course.description }}
    </div>
    <br />
    <div id="curricula-side">
      <label id="class-instructions-labelID" for="instruction"
        >Class Instructions:</label
      >
      <br />
      <div id="instruction-student">{{ course.dailyInstruction }}</div>
      <br />
      <label id="links-labelID" for="links-label">Class Resources:</label>
      <br />
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
    });
  },
};
</script>

<style scoped>

#student-class-details-title {
  display: flex;
  justify-content: center;
  text-decoration: underline;
}
label {
  background-color: white;
  text-decoration: underline;
}
#links {
  background-color: white;
  text-align: center;
}
#instruction-student {
  background-color: white;
  text-align: center;
}
#student-right-view {
  display: grid;
  grid-template-rows: 1fr 1fr;
  grid-template-areas:
    "description"
    "curricula";
}
#description {
  border: solid;
  border-radius: 20px;
  background-color: white;
  border-color: rgb(221, 221, 221);
  padding: 15px;
  grid-area: description;
  text-align: center;
}
#curricula-side {
  border: solid;
  border-radius: 20px;
  background-color: white;
  border-color: rgb(221, 221, 221);
  padding: 15px;
  grid-area: curricula;
}
</style>