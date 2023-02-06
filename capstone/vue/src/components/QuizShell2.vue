<template>
  <div>
    <h1 class="title"></h1>

    <main class="main-box">
      <p class="question">{{ getCurrentQuestion.questionText }}</p>
      <span class="score"
        >Score {{ calculateScore }}/{{ $store.state.questions.length }}</span
      >

      <input
        type="radio"
        v-for="answer in answersArray"
        v-bind:key="answer.index"
        value="answer"
        v-model="getCurrentQuestion.checked"
      />{{ getCurrentQuestion.answers }} 
      <!-- <div class="answers">
        <input type="radio" id="answer1" value="1" v-model="checked" />
        <label for="answer1">{{ getCurrentQuestion.answer1 }}</label> <br />
        <input type="radio" id="answer2" value="2" v-model="checked" />
        <label for="answer2">{{ getCurrentQuestion.answer2 }}</label> <br />
        <input type="radio" id="answer3" value="3" v-model="checked" />
        <label for="answer3">{{ getCurrentQuestion.answer3 }}</label> <br />
        <input type="radio" id="answer4" value="4" v-model="checked" />
        <label for="answer4">{{ getCurrentQuestion.answer4 }}</label> <br />
      </div> -->
      <button v-on:click="setNextQuestion">Next Question</button>
    </main>
  </div>
</template>

<script>
import PortalServices from "../services/PortalServices";
export default {
  data() {
    return {
      // questionObject: {
      //     questionId: 999,
      //     questionText: 'How much wood could a wood chuck chuck?',
      //     correctAnswer: 2,
      //     answers: [
      //       90, 10, 50, 1
      //     ]
      // },

      currentIndex: 0,
      checked: "",
      quizCompleted: false,
      answersArray: [],
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
      ),
    this.sortAnswer();
  },
  computed: {
    getCurrentQuestion() {
      let question = this.$store.state.questions[this.currentIndex];
      return question;
    },
    calculateScore() {
      let value = 0;
      this.$store.state.questions.map((q) => {
        if (q.checked != null && q.correctAnswer == q.checked) {
          console.log("correct");
          value++;
        }
      });
      return value;
    },
  },
  methods: {
    setNextQuestion() {
      if (this.currentIndex < this.$store.state.questions.length - 1) {
        this.currentIndex++;
      } else {
        this.quizCompleted = true;
      }
    },
    sortAnswer() {
      this.answersArray = this.getCurrentQuestion.answers.split(",");
       console.log('pass')
     },

    // checkAnswer(){
    //   if (this.checked == this.getCurrentQuestion.correctAnswer){

    //   }
  },
  // },
};
</script>


<style>
</style>