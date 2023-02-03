<template>
  <div id="course-style">
    <div>
      <router-link v-bind:to="{name: 'courseDetails', params:{id: course.courseId}}">
     {{course.courseName}}
     </router-link>
     <br>
     {{course.description}}
     <br>
     {{course.difficulty}}
    </div>
  </div>
</template>

<script>
export default {
  name: "course",
  props: {
    course: Object,
  },

};
</script>

<style>
#course-style {
  border: 2px solid black;
  border-radius: 10px;
  padding: 15px;
}
</style>