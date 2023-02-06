<template>
  <div>
    <h1>Quiz</h1>
    <section class="quiz" v-if="!quizCompleted">
      <div class="quiz-info">
        <span class="question">{{ getCurrentQuestion.questionText }}</span>
        <span class="score"
          >Score {{ calculateScore }}/{{ $store.state.questions.length }}</span
        >
      </div>

      <!-- <div>
        <label
          v-for="(option, index) in getCurrentQuestion.options"
          v-bind:key="'option' + index"
          :class="`option ${
            getCurrentQuestion.selected == index
              ? index == getCurrentQuestion.CorrectAnswer
                ? 'correct'
                : 'wrong'
              : ''
          } ${
            getCurrentQuestion.selected != null &&
            index != getCurrentQuestion.selected
              ? 'disabled'
              : ''
          }`" -->
      <!-- > -->
      <!-- <input
        type="radio"
        :id="'option' + index"
        :name="getCurrentQuestion.index"
        :value="index"
        v-model="getCurrentQuestion.selected"
        :disabled="getCurrentQuestion.selected"
        v-on:change="SetAnswer"
      />
      <span>{{ $store.state.questions.answer1 }}</span> -->
      <!-- </label> -->
      <!-- </div> -->

      <button
        v-on:click="NextQuestion, SetNextQuestion"
        :disabled="!getCurrentQuestion.selected"
      >
        {{
          getCurrentQuestion.index == this.$store.questions.length - 1
            ? "Finish"
            : getCurrentQuestion.selected == null
            ? "Select an option"
            : "Next question"
        }}
      </button>
    </section>

    <section v-else>
      <h2>You have finished the quiz!</h2>
      <p>
        Your score is {{ calculateScore }}/{{ $store.state.questions.length }}
      </p>
    </section>
  </div>
</template>

<script>
import PortalServices from "../services/PortalServices";
export default {
  data() {
    return {
      quizCompleted: false,
      currentQuestion: 0,
      score: 0,
    };
  },
  computed: {
    calculateScore() {
      let value = 0;
      this.$store.state.questions.map((q) => {
        if (q.selected != null && q.correctAnswer == q.selected) {
          console.log("correct");
          value++;
        }
      });
      return value;
    },
    getCurrentQuestion() {
      let question = this.$store.state.questions[this.currentQuestion];
      // question.index = this.currentQuestion;
      return question;
    },
  },
  methods: {
    SetAnswer(evt) {
      this.$store.state.questions[this.currentQuestion].selected =
        evt.target.value;
      evt.target.value = null;
    },
    NextQuestion() {
      if (this.currentQuestion < this.questions.length - 1) {
        this.currentQuestion++;
      } else {
        this.quizCompleted = true;
      }
    },
  },
  SetNextQuestion() {
    this.currentQuestion++;
  },
  created() {
    PortalServices.getQuiz(this.$route.params.id).then((response) => {
      this.$store.state.quiz = response.data;
      
    }),
      PortalServices.getQuizQuestions(this.$route.params.id).then(
        (response) => {
          this.$store.state.questions = response.data;
          
        }
      );
  },
};
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: "Montserrat", sans-serif;
}
</style>