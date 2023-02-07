<template>
  <div id="student-center-view">
    <div id="student-area-header" >
      <h1 v-bind:to="{ name: 'courses', params: { id: course.courseId } }">
        {{ course.courseName }}

        <!-- <router-link v-bind:to="{ name: 'quizview' }"
          ><button>Go To Quiz</button>
          </router-link> -->
      </h1>
    </div>
    <div class="flex-container-column flex-container-center">
      <h3 class="u-text-center u-margin-top">
        {{ course.hwAssignment }}
      </h3>
      <form id="homework-submission" v-on:submit.prevent="saveHomework">
        <label id="hw-label" for="homework" class="u-text-center"
          >Homework Submission Area</label
        >
        <br />
        <br />
        <input
          placeholder="Please write your essay here"
          id="homework-textbox"
          type="text"
          v-model="homeworkObject.hwSubmission"
          required
        />
        <br />

        <div id="button-div-2">
          <button type="submit" class="u-margin-y">Submit Homework</button>
        </div>
        
      </form>
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
      homeworkObject: {
        homeworkId: "",
        courseId: "",
        studentId: "",
        hwSubmission: "",
      },
    };
  },
  methods: {
    saveHomework() {
      console.log(this.homeworkObject);
      PortalServices.submitHomework(this.$route.params.id, this.homeworkObject)
        .then((response) => {
          if (response.status === 201) {
            alert("Your homework has been submitted!");
          }
        })
        .catch((error) => {
          console.error(error);
          alert("Uh oh, please try to submit your homework again!");
        });
    },
  },
  created() {
    PortalServices.getCourses(this.$route.params.id).then((response) => {
      this.course = response.data;
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
    "student-area-header"
    "homework-submission";
}
#student-area-header {
  display: flex;
  justify-content: center;
  grid-area: student-area-header;
}
#homework-submission {
  display: block;
  justify-content: center;
  grid-area: homework-submission;
}
#homework-textbox {
  padding: 150px;
}
#button-div-2 {
  display: flex;
  justify-content: center;
}
</style>