<template>
  <div id="course-style">
    <h2 id="course-name">{{course.coursename}}</h2>
    <p id="description">{{course.description}}</p>
    <p id="difficulty">{{course.difficulty}}</p>
  </div>
</template>

<script>
export default {
    name: 'course',
    props: {
      course: Object
    }
    
}
</script>

<style>
#course-style {
    border: 2px solid black;
    border-radius: 10px;
    padding: 15px;

}
</style>