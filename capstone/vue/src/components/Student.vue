<template>
  <div id="course-style">
    <div v-bind:to="{name: 'studentDetails', params:{id: $store.state.users.id}}">
     {{$store.state.users.username}}
    </div>
  </div>
</template>

<script>
export default {
  name: "student",
  props: {
    student: Object,
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