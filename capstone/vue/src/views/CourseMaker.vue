<template>
  <div class="coursemaker">
      <h1 id="page-title">Course Maker</h1>
    <course-maker-form/>
  </div>
</template>

<script>
import CourseMakerForm from "../components/CourseMakerForm.vue"


export default {
    // name: "coursemaker",
    components: {
        CourseMakerForm
    }
};
</script>

<style>
.coursemaker {
  padding: 10px;
}
h1 {
  display: flex;
  justify-content: center;
}
</style>