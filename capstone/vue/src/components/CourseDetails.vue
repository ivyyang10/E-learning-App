<template>
    <div>
      <h1>Course Details</h1>
       <router-link v-bind:to ="{name: 'createcourse'}">
      <button type="submit">Create Course</button></router-link>
       <button type="submit">View All Students</button>
        <h2 class ="course-name">{{course.courseName}}</h2>
    </div>

</template>

<script>
export default {

}
</script>

<style>

</style>