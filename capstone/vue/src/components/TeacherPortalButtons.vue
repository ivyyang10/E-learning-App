<template>
  <div> 
 <router-link v-bind:to="{ name: 'createcourse' }"><button>Create New Course</button></router-link>
 <router-link v-bind:to="{ name: 'viewallstudents' }"><button>View All Students</button></router-link>
 <router-link v-bind:to="{ name: 'homeworkview' }"><button>View All Student Homework</button></router-link>
  </div>
  
</template>

<script>
export default {
  name: "teacher-portal-buttons"
}
</script>

<style>

</style>