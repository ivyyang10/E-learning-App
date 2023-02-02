<template>
  <div id="course-style">
    <div v-for="course in $store.state.courses" v-bind:key="course.id">
      <router-link v-bind:to="{name: 'courses', params:{id: course.id}}">
     {{course.courseName}}
     {{course.description}}
     {{course.difficulty}}
    </router-link>
    </div>
  </div>
</template>

<script>


export default {
    name: 'course',
    props: {
      course: Object
    },
    
}
</script>

<style>
#course-style {
    border: 2px solid black;
    border-radius: 10px;
    padding: 15px;

}
</style>