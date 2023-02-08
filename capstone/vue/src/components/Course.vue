<template>
  <div id="course-style">
    <div id="course-card">
      <div id="course-name-card">
        <router-link
          id="course-name-card-link"
          v-bind:to="{ name: 'courseDetails', params: { id: course.courseId } }"
        >
          <h2 id="course-name-card-title">{{ course.courseName }}</h2>
        </router-link>
      </div>
      <br />
      <div id="course-card-description">
        {{ course.description }}
      </div>
      <br>
    <!-- <img id="books-image" src="../assets/books2.jpg" alt="school-books"> -->
    <br>
      <div id="course-card-difficulty">
          {{ course.difficulty }}
        </div>
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
#course-card {
 
   background-color: white;
   justify-content: flex-start; 
}
#books-image {
  display: flex;
  justify-content: center;
  height: 75px;
  width: 75px;
  border-radius: 25px;
}
/* #course-name-card-title {
  background-color: white;
} */
#course-name-card-link {
  display: flex;
  justify-content: center;
 /* background-color: white; */
}
#course-card-difficulty {
  display: flex;
  justify-content: center;
  /* background-color: white; */
  border: solid lightgrey;
  border-radius: 25px;
}
#course-card-description {
  display: flex;
  justify-content: center;
  /* background-color: white; */
}
/* #course-name-card {
  background-color: white;
} */
#course-style {
  border: 2px solid;
  border-color: #75b9be;
  background-color: white;
  border-radius: 10px;
  width: 200px;
  height: 300px;
  margin: 20px;
  padding: 30px;
  /* background-image: url("../assets/books2.jpg"); */
  background-image: url("../assets/notebook.png");
  background-size: 300px;
  display: flex;
  flex-direction: column;
  

 
}
</style>