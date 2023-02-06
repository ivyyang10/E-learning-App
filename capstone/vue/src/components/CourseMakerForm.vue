<template>
  <div id="course-maker-all">
  <form class="course-maker-form" v-on:submit.prevent="saveCourse">
    <input 
    class="courseName" 
    type="text" 
    placeholder="Course Name" 
    v-model="course.courseName"
    required 
    />
    <br>
    <div id="all-description">
        <h2>Course Description</h2>
        <input class="description" type="text" placeholder="Description" v-model="course.description" required/>
        <!-- <input class="difficulty" type="text" placeholder="Difficulty Level" v-model="course.difficulty" /> -->
        <br>
        <input 
        class="cost" 
        type="number" 
        placeholder="Cost" 
        step="0.01"
        MIN="0" 
        v-model="course.cost"
        required 
        />
        <br>
        <select name="Difficulty" v-on:change="onChange($event)" class="form-select">
            <option value = ""> Select Difficulty Level</option>
            <option value ="Easy"> Easy</option>
            <option value ="Medium"> Medium</option>
            <option value ="Difficult"> Difficult</option>
        </select>
        <br>
        </div>
    <div id="curricula">
        <h2>Curricula</h2>

    <div>
  
    <input class="dailyInstruction" type="text" placeholder="Daily Instruction" v-model="course.dailyInstruction" required/>
    <br>
    <input class="link" type="text" placeholder="Classroom Resources" v-model="course.links" required/>
    <br>
    <input class="hwAssignment" type="text" placeholder="HW Assignments" v-model="course.hwAssignment" required/>
  
  </div>

    </div>
    <br>
    <div>    
    <button type="submit">Create Course</button>
    </div>
    <br>
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

        onChange(event){
            if(event.target.value === "Easy") {
                this.course.difficulty = "Easy";
            } else if (event.target.value === "Medium") {
                this.course.difficulty = "Medium";
            } else if (event.target.value === "Difficult") {
                this.course.difficulty = "Difficult";
            }
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
                alert('Please Select a Course Difficulty');
            });
        }
    }

}
</script>

<style>

#course-maker-all {
  display: flex;
  justify-content: center;
  padding-bottom: 20px;
}
.description {
    padding: 30px;
}
input, label {
  display: block;
}
label {
  padding-top: 15px;
}
input {
  border-radius: 25px;
  border-bottom: solid 3px;
}
</style>