<template>
  <div>
  <form class="course-maker-form" v-on:submit.prevent="saveCourse">
    <input class="courseName" type="text" placeholder="Course Name" v-model="course.courseName" />
    <br>
    <div>
        <h3>Description</h3>
        <input class="description" type="text" placeholder="Description" v-model="course.description" />
        <!-- <input class="difficulty" type="text" placeholder="Difficulty Level" v-model="course.difficulty" /> -->
        <select name="Difficulty" @Change="onChange($event)" class="form-select">
            <option value =" "> Select Difficulty Level</option>
            <option value ="Easy"> Easy</option>
            <option value ="Medium "> Medium</option>
            <option value ="Difficult"> Difficult</option>
        </select>

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
    <div>    
    <router-link v-bind:to="{ name: 'home' }"><button>Discard Course</button></router-link>
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

        onChange(e){
            this.difficulty=e.target.value;
        },
    
        
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
                    this.$router.push("/")
                    alert('Your course has been submitted');
                }
            })
            .catch(error => {
                console.error(error);
                alert('Please check submission boxes');
            });
        }
    }

}
</script>

<style>

</style>