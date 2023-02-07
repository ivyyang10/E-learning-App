<template>
  <div id="student-right-view">
    <h2 id="student-class-details-title">Class Details</h2>
    <br>
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
    });
  },
};
</script>

<style scoped>
/* * {
  background-color: #75b9be;
} */
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
}
#instruction {
  background-color: white;
    
}
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
  background-color: white;
  border-color: rgb(221, 221, 221);
  padding: 15px;
  grid-area: description;
}
#curricula {
  border: solid;
  border-radius: 20px;
  background-color: white;
  border-color: rgb(221, 221, 221);
  padding: 15px;
  grid-area: curricula;
}
</style>