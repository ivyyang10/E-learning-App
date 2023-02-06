<template>
  <div>
    <h1>List of Students Goes Here</h1>
    <student v-for="userObject in $store.state.users" v-bind:key="userObject.id"/>
  </div>
</template>

<script>
import PortalServices from "../services/PortalServices";
import Student from "../components/Student.vue"

export default {
  name: "add-students-to-course",
  components: {
      Student
  },
  data() {
    return {
      allUsers: [],
    };
  },
  methods: {
    listAllUsers() {
      PortalServices.listAllUsers().then((response) => {
        this.$store.state.users = response.data;
        console.log(response);
      });
    },
  },
  created() {
    this.listAllUsers();
  },
};
</script>

<style>
</style>