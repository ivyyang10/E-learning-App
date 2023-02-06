<template>
  <div id="course-style">
    <div v-bind:to="{name: 'studentDetails', params:{id: userObject.id}}">
     {{userObject.username}}
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