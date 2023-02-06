<template>
  <div>
      <input type="checkbox" name="add-user" id="add-user-checkbox"/>
      {{user.name}}
    <h1>Student Object Here</h1>
  </div>
</template>

<script>
export default {
    name: "student",
    props: {
        student: Object
    }
}
</script>

<style>

</style>