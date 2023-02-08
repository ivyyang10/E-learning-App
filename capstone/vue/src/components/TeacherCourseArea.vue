<template>
  <div id="teacher-center-view">
    <div id="teacher-area-header">
      <h1 v-bind:to="{ name: 'courses', params: { id: course.courseId } }">
        {{ course.courseName }}
      </h1>
    </div>
    <div id="row-two">
      <label id="instruction-label" for="instruction">Daily Instruction</label>

      <p id="instruction">
        {{ course.dailyInstruction }}
      </p>

      <label id="resources-label" for="resources">Class Resources</label>

      <p id="resources">{{ course.links }}</p>
      <br />

      <div id="button-div">
        <button id="show-form-button" v-on:click.prevent="showForm = !showForm">
        Add Students to Class
      </button>
      </div>
      
    </div>

    <add-students-to-course id="add-students" v-if="showForm === true" />
  </div>
</template>

<script>
import PortalServices from "../services/PortalServices";
import AddStudentsToCourse from "../components/AddStudentsToCourse.vue";

export default {
  components: { AddStudentsToCourse },
  data() {
    return {
      showForm: false,
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
    });
  },
};
</script>

<style>
#teacher-center-view {
  display: grid;
  grid-auto-columns: 1fr;
  grid-auto-rows: 1fr 1fr;
  grid-template-areas:
    "teacher-area-header"
    "row-two";
}
#teacher-area-header {
  grid-area: teacher-area-header;
}
#row-two {
  grid-area: row-two;
  padding: 10px;
}
#instruction {
  padding: 25px;
  border: solid 2px;
  border-color: #75b9be;
  border-radius: 25px;
}
#resources {
  padding: 25px;
  border: solid 2px;
  border-color: #75b9be;
  border-radius: 25px;
}
#create-quiz-button {
  padding: 10px;
}

#add-students {
  display: flex;
  justify-content: center;
  padding: 20px;
  border: solid 2px #75b9be;
  border-radius: 25px;
}
#button-div {
  display: flex;
  justify-content: center;
}
</style>