<template>
  <div id="teacher-right-view">
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

    <div
      id="difficulty"
      v-bind:to="{ name: 'courses', params: { id: course.id } }"
    >
      <label id="difficulty-labelID" for="difficulty-label">Difficulty:</label>
      <br />
      {{ course.difficulty }}
    </div>
    <br />

    <div id="enrolled-students">
      <label id="enrolled-labelID" for="enrolled-label">Enrolled Students:</label>
      <p v-for="student in enrolledStudents" v-bind:key="student.id">
        {{student.name}}
      </p>
    </div>
    <br />

    <div id="homework-notification">
      <label id="hw-notification-labelID" for="hw-notification-label"
        >Homework Notification:</label>
    </div>
  </div>
</template>

<script>
import PortalServices from "../services/PortalServices";
export default {
  name: "teacher-right-side-bar",
  data() {
    return {
      enrolledStudents: [],
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
    PortalServices.getStudentByCourseId(this.$route.params.id).then(
      (response) => {
        this.enrolledStudents = response.data;
      }
    )
  },
};
</script>

<style scoped>
* {
  background-color: #75b9be;
}
label {
  background-color: white;
}
#teacher-right-view {
  display: grid;
  grid-template-rows: 1fr 1fr 1fr 1fr;
  grid-template-areas:
    "description"
    "difficulty"
    "enrolled-students"
    "homework-notification";
}
#description {
  border: solid;
  border-radius: 20px;
  background-color: white;
  padding: 15px;
  grid-area: description;
}
#difficulty {
  border: solid;
  border-radius: 20px;
  background-color: white;
  padding: 15px;
  grid-area: difficulty;
}
#enrolled-students {
  border: solid;
  border-radius: 20px;
  background-color: white;
  padding: 15px;
  grid-area: enrolled-students;
}
#homework-notification {
  border: solid;
  border-radius: 20px;
  background-color: white;
  padding: 15px;
  grid-area: homework-notification;
}
p {
  background-color: white;
}
</style>