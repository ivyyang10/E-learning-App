<template>
  <div id="teacherRightView">
    <p v-bind:to="{name: 'courses', params:{id: course.id}}">
     {{course.description}}
     {{course.difficulty}}</p>
     <p> Enroll Student </p>
    <p> Student Homework Notification</p>
  </div>
</template>

<script>
import PortalServices from "../services/PortalServices"
export default {
     name: 'teacher-right-side-bar',
    data(){
        return{
        course:{
        courseId: "",
        courseName: "",
       description: "",
       difficulty: "",
       cost: "",
       dailyInstruction: "",
       links: "",
       hwAssignment: "",
       teacherId: ""

            }
        }

    },

    
         created(){
             PortalServices.getCourses(this.$route.params.id)
             .then((response) =>{
                 this.course =response.data;
                 console.log(response)

             })
         }
      
    

   

}
</script>

<style>

</style>