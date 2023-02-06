<template>
  <div v-show="$store.state.user.authorities[0].name === 'ROLE_ADMIN'" id="teacherPermission"> 
 <router-link v-bind:to="{ name: 'createcourse' }"><button>Create New Course</button></router-link>
 <router-link v-bind:to="{ name: 'viewallstudents' }"><button>View All Students</button></router-link>
 <router-link v-bind:to="{ name: 'homeworkview' }"><button>View All Student Homework</button></router-link>
  </div>
  
</template>

<script>
import PortalServices from '../services/PortalServices';

export default {
  name: "teacher-portal-buttons",
    created(){
      PortalServices.getUser()
      .then((response) =>{
        this.$store.state.users = response.data;
      })
  }

}
</script>

<style>

</style>