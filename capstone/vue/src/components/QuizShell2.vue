<template>
  <div>
    <h1 class="title"></h1>
    <main class="main-box">
      <p class="question">{{ getCurrentQuestion.questionText }}</p>
      <blockquote class="answers">
        <br />
        <input
          type="radio"
          id="answer1"
          value="1"
          v-model="checked"
          :disabled="getCurrentQuestion.selected"
        />
        <label for="answer1">{{ getCurrentQuestion.answer1 }}</label> <br />
        <input type="radio" id="answer2" value="2" v-model="checked" />
        <label for="answer2">{{ getCurrentQuestion.answer2 }}</label> <br />
        <input type="radio" id="answer3" value="3" v-model="checked" />
        <label for="answer3">{{ getCurrentQuestion.answer3 }}</label> <br />
        <input type="radio" id="answer4" value="4" v-model="checked" />
        <label for="answer4">{{ getCurrentQuestion.answer4 }}</label> <br />
        <input type="radio" id="answer5" value="5" v-model="checked" />
        <label for="answer5">{{ getCurrentQuestion.answer5 }}</label> <br />
        <input type="radio" id="answer6" value="6" v-model="checked" />
        <label for="answer6">{{ getCurrentQuestion.answer6 }}</label> <br />
      </blockquote>
    </main>
  </div>
</template>

<script>
import PortalServices from "../services/PortalServices";
export default {
  data() {
    return {
      currentIndex: 0,
      checked: "",
    };
  },
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
  computed: {
    getCurrentQuestion() {
      let question = this.$store.state.questions[this.currentIndex];
      return question;
    },
  },
  methods: {
    setNextQuestion() {
      if (this.currentIndex < this.$state.store.questions.length - 1) {
        this.currentIndex++;
      }
    },
  },
};
</script>


<style>
</style>