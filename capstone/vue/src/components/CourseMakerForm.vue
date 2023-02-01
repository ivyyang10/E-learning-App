<template>
  <div>
  <form class="course-maker-form" v-on:submit.prevent="saveCourse">
    <input class="courseName" type="text" placeholder="Course Name" v-model="course.name" />
    <br>
    <div>
        <h3>Description</h3>
        <input class="description" type="text" placeholder="Description" v-model="course.description" />
        <input class="difficulty" type="text" placeholder="Difficulty Level" v-model="course.difficulty" />
        <input class="cost" type="text" placeholder="Cost" v-model="course.cost" />
        </div>
    <div id="curricula">
        <h2>Curricula</h2>
        <curricula-maker-form/>
    </div>
    <br>
    <div>    
    <button>Create Course</button>
    </div>
  </form>
  </div>
</template>

<script>
import CurriculaMakerForm from './CurriculaMakerForm.vue';
export default {
  components: { CurriculaMakerForm },
    name: "course-maker-form",
    data(){
        return {
            course: {
                courseId: '',
                courseName: '',
                description: '',
                difficulty: '',
                cost: ''
            }
        }
    },
    methods: {
        saveCourse() {
            this.$store.commit('SAVE_COURSE', this.course);
            this.course = {
                  courseId: '',
                courseName: '',
                description: '',
                difficulty: '',
                cost: ''
            };
            this.$router.push({course: 'newCourse'})
        }
    }

}
</script>

<style>

</style>