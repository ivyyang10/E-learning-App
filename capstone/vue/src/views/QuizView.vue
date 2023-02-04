<template>
  <div>
    <h1>Quiz View</h1>
    <quiz-shell />
  </div>
</template>

<script>
import PortalServices from "../services/PortalServices";
import QuizShell from "../components/QuizShell.vue";
export default {
  components: { QuizShell },
  created() {
    PortalServices.getQuiz(this.$route.params.id).then((response) => {
      this.$store.state.quiz = response.data;
      console.log(response);
    }),
      PortalServices.getQuizQuestions(this.$route.params.id).then(
        (response) => {
          this.$store.state.questions = response.data;
          console.log(response);
        }
      );
  },
};
</script>

<style>
</style>