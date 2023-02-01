<template>
  <div>
  <form class="course-maker-form" v-on:submit.prevent="saveCourse">
    <input class="courseName" type="text" placeholder="Course Name" v-model="course.courseName" />
    <br>
    <div>
        <h3>Description</h3>
        <input class="description" type="text" placeholder="Description" v-model="course.description" />
        <input class="difficulty" type="text" placeholder="Difficulty Level" v-model="course.difficulty" />
        <input class="cost" type="text" placeholder="Cost" v-model="course.cost" />
        </div>
    <div id="curricula">
        <h2>Curricula</h2>

    <div>
  <form class="curricula-maker-form" v-on:submit.prevent="saveCourse">
    <input class="dailyInstruction" type="text" placeholder="Daily Instruction" v-model="course.dailyInstruction" />
    <input class="link" type="text" placeholder="Classroom Resources" v-model="course.links" />
    <input class="hwAssignment" type="text" placeholder="HW Assignments" v-model="course.hwAssignment" />
  </form>
  </div>

    </div>
    <br>
    <div>    
    <button type="submit">Create Course</button>
    </div>
  </form>
  </div>
</template>

<script>
// import CurriculaMakerForm from './CurriculaMakerForm.vue';
import PortalService from "../services/PortalServices.js"
export default {
//   components: { CurriculaMakerForm },
    name: "course-maker-form",
    data(){
        return {
            course: {
                courseName: '',
                description: '',
                difficulty: '',
                cost: '',
                dailyInstruction: '',
                links: '',
                hwAssignment: ''
            }
        }
    },
    methods: {
        saveCourse() {
            // this.$store.commit('SAVE_COURSE', this.course);
            // this.course = {
            //     courseId: '',
            //     courseName: '',
            //     description: '',
            //     difficulty: '',
            //     cost: '',
            //     dailyInstruction: '',
            //     links: '',
            //     hwAssignment: ''
            // };
            // this.$router.push({course: 'newCourse'})

            PortalService
            .createCourse(this.course)
            .then(response => {
                if(response.status === 201) {
                    this.$router.push("/home");
                }
            })
            .catch(error => {
                console.error(error);
            });
        }
    }

}
</script>

<style>

</style>