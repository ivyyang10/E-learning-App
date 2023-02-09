<template>
  <div id="course-maker-all">
  <form class="course-maker-form" id="courseform" v-on:submit.prevent="saveCourse">

   
    <div id="all-description">
            <input 
    class="courseName" 
    type="text" 
    placeholder="Course Name" 
    v-model="course.courseName"
    required 
    />
    <br>
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
        <div id="togglelevel">
        <select name="Difficulty" v-on:change="onChange($event)" class="form-select">
            <option value = ""> Select Difficulty Level</option>
            <option value ="Easy"> Easy</option>
            <option value ="Medium"> Medium</option>
            <option value ="Difficult"> Difficult</option>
        </select>
        </div>
        <br>
        <br>
        </div>
    <div id="curricula">
      

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
  padding-top: 30px;
   padding-bottom: 175px;
   justify-items: center;
}
#courseform {
 display: grid;
grid-template-columns: 1fr 1fr;
grid-template-areas: 
"description curricula"
"button button" ;
grid-column-gap: 3em;
border-style: solid;
border-radius: 25px;
padding: 3em;

}
.description {
    padding-top: 35px;
padding-bottom: 35px;
}
#all-description {
        grid-area: description;
}
#curricula {
    grid-area: curricula;
}
.hwAssignment {
    padding-top: 35px;
padding-bottom: 35px;
}
input, label {
  display: block;
}
label {
  padding-top: 15px;
}
input {
    padding: 18px;
    padding-right: 30px;
    border-radius: 25px;
  border-bottom: solid 3px;
  display: grid;
  justify-content: center;

}
#buttons {
 display: flex;
justify-content:space-around ;
grid-area: button;
margin-top: 1em;
}
#togglelevel{
    display: flex;
    justify-content: center;
}
/* button {
margin-right: 20px;
} */
/* .course-maker-form {
      background-color: transparent;
} */
</style>