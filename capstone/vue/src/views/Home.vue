<template>
  <div class="home">
    <h1>Welcome to Thwin Secondary School</h1>
    <p>This is the home portal page for students and teachers</p>

    <div>
    <teacher-portal-buttons/>
    </div>
    
    <course-list/>
  </div>
</template>

<script>
import CourseList from '../components/CourseList.vue';
import TeacherPortalButtons from '../components/TeacherPortalButtons.vue';
// import PortalServices from '../services/PortalServices';

export default {
  
  components: { CourseList, TeacherPortalButtons },
  name: "home",
  // created(){
  //     PortalServices.getUser()
  //     .then((response) =>{
  //       this.$store.state.users = response.data;
  //       console.log(response)
  //     })
  // },
  // methods: {
  //   toggleTeacherView(){
  //     if(this.$store.state.users.authorities === "ROLE_ADMIN"){
  //       this.isAdmin = true;
  //     }
  //   }
  // }
};
</script>
