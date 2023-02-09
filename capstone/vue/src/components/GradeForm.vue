<template>
  <div>
    <div id="grading-div">
      <form
        class="grade-homework-form"
        v-bind:key="homework.homeworkId"
        id="gradeform"
        v-on:submit.prevent="postGrade"
      >
        <select
          id="grading-options"
          name="grading"
          v-on:change="onChange($event)"
          class="form-select"
        >
          <option value="">Grade Homework</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option value="7">7</option>
          <option value="8">8</option>
          <option value="9">9</option>
          <option value="10">10</option>
        </select>
        <button type="submit">Submit Grade</button>
      </form>
    </div>
  </div>
</template>

<script>
import PortalServices from "../services/PortalServices";
export default {
  name: "homework-grader-form",
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
  methods: {
    onChange(event) {
      if (event.target.value == "1") {
        this.homework.grade = 1;
      } else if (event.target.value == "2") {
        this.homework.grade = 2;
      } else if (event.target.value == "3") {
        this.homework.grade = 3;
      } else if (event.target.value == "4") {
        this.homework.grade = 4;
      } else if (event.target.value == "5") {
        this.homework.grade = 5;
      } else if (event.target.value == "6") {
        this.homework.grade = 6;
      } else if (event.target.value == "7") {
        this.homework.grade = 7;
      } else if (event.target.value == "8") {
        this.homework.grade = 8;
      } else if (event.target.value == "9") {
        this.homework.grade = 9;
      } else if (event.target.value == "10") {
        this.homework.grade = 10;
      }
    },

    postGrade() {
      PortalServices.postGrade(this.homework)
        .then((response) => {
          if (response.status === 201) {
            alert("Your grade has been submitted");
          }
        })
        .catch((error) => {
          console.error(error);
          alert("Please submit a grade");
        });
    },
  },
};
</script>

<style scoped>
#grading-div {
  display: flex;
  justify-content: flex-end;
  margin: 50px;
}
#grading-options {
  padding: 35px;
  border-radius: 25px;
  font-weight: bold;
  font-size: 1rem;
}
button {
   margin-left: 50px;
}
</style>
