<template>
  <div id="card"> 
    <h3>
          {{userObject.username}}
    </h3>
  </div>
</template>

<script>
export default {
name: "studentCard",
props: {
  userObject: Object 
}
}
</script>

<style>
#card {
    border: 2px solid black;
  border-radius: 10px;
    width: 100px;
  height: 150px;
  margin: 20px;
  padding: 15px;
  display: inline-block;
}
</style>