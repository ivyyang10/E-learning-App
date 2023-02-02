<template>
  <div id="StudentRightView">
    <p v-bind:to="{name: 'courses', params:{id: course.id}}">
     {{course.description}}
     {{course.dailyInstruction}}
     {{course.links}}
     {{course.hwAssignment}}</p>
     <p> Enroll Student </p>
    <p> Student Homework Notification</p>
  </div>
</template>

<script>
import PortalServices from "../services/PortalServices"
export default {
     name: 'Student-right-side-bar',
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