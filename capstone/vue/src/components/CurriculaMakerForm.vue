<template>
    <div>
  <form class="course-maker-form" v-on:submit.prevent="saveCourse">
    <input class="courseName" type="text" placeholder="Course Name" v-model="course.name" />
    <input class="description" type="text" placeholder="Description" v-model="course.description" />
    <input class="difficulty" type="text" placeholder="Difficulty Level" v-model="course.difficulty" />
    <input class="cost" type="text" placeholder="Cost" v-model="course.cost" />    
    <button>Save</button>
  </form>
  </div>
</template>

<script>
export default {

}
</script>

<style>

</style>