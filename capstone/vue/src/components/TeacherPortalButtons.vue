<template>

  <div v-show="$store.state.user.authorities[0].name === 'ROLE_ADMIN'" id="teacherPermission"> 
 <router-link id="router-link" v-bind:to="{ name: 'createcourse' }"><button>Create New Course</button></router-link>
 <router-link id="router-link" v-bind:to="{ name: 'viewallstudents' }"><button>View All Students</button></router-link>
  </div>
  
</template>

<script>


export default {
  name: "teacher-portal-buttons",
  
}
</script>

<style>
button {
  padding: 15px;
  border-radius: 15px;
    border-radius: 25px;
  border-color: white;
  padding: 15px;
  background-color: #75b9be;
}
</style>