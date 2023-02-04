<template>
  <div>
    <h1>Quiz</h1>
    <section class="quiz" v-if="!quizCompleted">
      <div class="quiz-info">
        <span class="question">{{getCurrentQuestion.question}}</span>
        <span class="score">Score {{ score }}/{{ questions.length }}</span>
      </div>

      <div>
        <label
          v-for="(option, index) in getCurrentQuestion.options"
          v-bind:key="'option' + index"
          :class="`option ${
            getCurrentQuestion.selected == index
              ? index == getCurrentQuestion.answer
                ? 'correct'
                : 'wrong'
              : ''
          } ${
            getCurrentQuestion.selected != null &&
            index != getCurrentQuestion.selected
              ? 'disabled'
              : ''
          }`"
        >
          <input
            type="radio"
            :id="'option' + index"
            :name="getCurrentQuestion.index"
            :value="index"
            v-model="getCurrentQuestion.selected"
            :disabled="getCurrentQuestion.selected"
            v-on:change="SetAnswer"
          />
          <span>{{ option }}</span>
        </label>
      </div>

      <button v-on:click="NextQuestion" :disabled="!getCurrentQuestion.selected">
        {{
          getCurrentQuestion.index == questions.length - 1
            ? "Finish"
            : getCurrentQuestion.selected == null
            ? "Select an option"
            : "Next question"
        }}
      </button>
    </section>

    <section v-else>
      <h2>You have finished the quiz!</h2>
      <p>Your score is {{ score }}/{{ questions.length }}</p>
    </section>
  </div>
</template>

<script>
export default {
  data() {
    return {
      questions: [
        {
          question: "What is Vue?",
          answer: 0,
          options: ["A framework", "A library", "A type of hat"],
          selected: null,
        },
        {
          question: "What is Vuex used for?",
          answer: 2,
          options: [
            "Eating a delicious snack",
            "Viewing things",
            "State management",
          ],
          selected: null,
        },
        {
          question: "What is Vue Router?",
          answer: 1,
          options: [
            "An ice cream maker",
            "A routing library for Vue",
            "Burger sauce",
          ],
          selected: null,
        },
      ],
      quizCompleted: false,
      currentQuestion: [0],
      score: 0,
      
    };
  },
  computed: {
    calculateScore() {
      let value = 0;
      this.questions.value.map((q) => {
        if (q.selected != null && q.answer == q.selected) {
          console.log("correct");
          value++;
        }
      });
      return value;
    },
    getCurrentQuestion() {
      let question = this.questions[this.currentQuestion];
      question.index = this.currentQuestion;
      return question;
    },
  },
  methods: {
    chooseAnswer(evt) {
      this.questions[this.currentQuestion].selected =
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