<template>
  <div v-show="toggleTeacherView" id="teacherPermission"> 
 <router-link v-bind:to="{ name: 'createcourse' }"><button>Create New Course</button></router-link>
 <router-link v-bind:to="{ name: 'viewallstudents' }"><button>View All Students</button></router-link>
 <router-link v-bind:to="{ name: 'homeworkview' }"><button>View All Student Homework</button></router-link>
  </div>
  
</template>

<script>
import PortalServices from '../services/PortalServices';

export default {
  isAdmin: false,
  name: "teacher-portal-buttons",
    created(){
      PortalServices.getUser()
      .then((response) =>{
        this.$store.state.users = response.data;
        console.log(response)
      })
  },
  methods: {
    toggleTeacherView(){
      if(this.$store.state.users.authorities === "ROLE_ADMIN"){
        this.isAdmin = true;
      }
    }
  }
}
</script>

<style>

</style>