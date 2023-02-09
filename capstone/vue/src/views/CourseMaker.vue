<template>
  <div class="coursemaker">
      <h1 id="page-title">Create A Course</h1>
    <course-maker-form />

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
   background-color: #f5f5f5;
  padding: 20px;
}
h1 {
  display: flex;
  justify-content: center;
}

</style>