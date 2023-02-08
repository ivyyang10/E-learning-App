<template>
  <div id="teacher-right-view">
    <h2 id="class-details">Class Details</h2>
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

    <div
      id="difficulty"
      v-bind:to="{ name: 'courses', params: { id: course.id } }"
    >
      <label id="difficulty-labelID" for="difficulty-label">Difficulty:</label>
      <br />
      <div id="difficulty-div">
        {{ course.difficulty }}
      </div>
    </div>
    <br />

    <div id="enrolled-students">
      <label id="enrolled-labelID" for="enrolled-label"
        >Homework Progress:</label
      >

      <br />
      <tr v-for="student in hwNotificationArr" v-bind:key="student.id">
        <td>{{ student.name }}</td>
        <td id="submitted" v-if="student.completed == true">Submitted</td>
        <td id="notsubmitted" v-else-if="student.completed == false">
          Not Submitted
        </td>
      </tr>
      <br>
       <router-link v-bind:to="{ name: 'homework' }"><button>View Homework Submissions</button></router-link>
    </div>
    <br />
  </div>
</template>

<script>
import PortalServices from "../services/PortalServices";
export default {
  name: "teacher-right-side-bar",
  data() {
    return {
      hwNotificationArr: [],
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
    );
    PortalServices.hwSubmissionNotificationTeacher(this.$route.params.id).then(
      (response) => {
        this.hwNotificationArr = response.data;
      }
    );
  },
};
</script>

<style scoped>
/* * {
  background-color: #75b9be;
} */
td {
  background-color: white;
}
label {
  background-color: white;
  text-decoration: underline;
  white-space: nowrap;
}
#class-details {
  display: flex;
  justify-content: center;
  text-decoration: underline;
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
  border-color: rgb(221, 221, 221);
}
#difficulty {
  border: solid;
  border-radius: 20px;
  background-color: white;
  padding: 15px;
  grid-area: difficulty;
  border-color: rgb(221, 221, 221);
}
#difficulty-div {
  display: flex;
  justify-content: center;
  font-weight: bold;
  background-color: white;
}
td {
  padding: 0 15px;
}
#enrolled-students {
  border: solid;
  border-radius: 20px;
  background-color: white;
  padding: 15px;
  grid-area: enrolled-students;
  border-color: rgb(221, 221, 221);

  /* display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-rows: 1fr 1fr;
  grid-template-areas: 
  'enrolled-labelID enrolled-labelID'
  'student-para hw-completed'; */
}
/* #enrolled-labelID {
  grid-area: enrolled-labelID;
}
#hw-completed {
  grid-area: hw-completed;
}
#student-para {
  grid-area: student-para;
  white-space: nowrap;
} */
#hw-completed {
  display: flex;
  justify-content: right;
}
/* #student-para {
  display: flex;
  justify-content: left;
} */

#homework-notification {
  border: solid;
  border-radius: 20px;
  background-color: white;
  padding: 15px;
  grid-area: homework-notification;
}
p,
span {
  background-color: white;
}

#submitted {
  color: rgb(22, 141, 22);
}
#notsubmitted {
  color: red;
}
</style>