<template>
  <div> 
    <p>
      Hello?
    </p>
    {{userObject.username}}
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

</style>