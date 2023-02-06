<template>
  <div id="course-maker-all">
  <form class="course-maker-form" id="courseform" v-on:submit.prevent="saveCourse">
    <h2>Course Description</h2>
    <input 
    class="courseName" 
    type="text" 
    placeholder="Course Name" 
    v-model="course.courseName"
    required 
    />
   <br>
    <div id="all-description">
        
        <input class="description" type="text" placeholder="Description" v-model="course.description" required/>
        
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
    <div id="buttons">    
    <button type="submit">Create Course</button>
    <router-link v-bind:to="{ name: 'home' }"><button>Discard Course</button></router-link>
    </div>
  </form>
  </div>
</template>

<script>

import PortalService from "../services/PortalServices.js"
export default {

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
#courseform {
align-items: center;
      border-style: solid;
  border-radius: 25px;
  padding: 20px;
  padding-right: 100px;
  padding-left: 100px;
  margin: 10px;
}
.description {
    padding-top: 30px;
padding-bottom: 30px;
}
input, label {
  display: block;
}
label {
  padding-top: 15px;
}
input {
    padding: 8px;
  border-radius: 25px;
  border-bottom: solid 3px;
  display: grid;
  justify-content: center;
}
#buttons {
    display: inline-block;
}
button {
margin-right: 20px;
}
</style>