<template>
  <div>
    <h1>List of Students Goes Here</h1>


    

      <student 
    v-for="userObject in $store.state.users"
    v-bind:key="userObject.id"
    v-bind:userObject="userObject"
    />


    <!-- <student 
    v-for="userObject in $store.state.users"
    v-bind:key="userObject.id"
    v-bind:userObject="userObject"
    /> -->

  </div>
</template>

<script>
import PortalServices from "../services/PortalServices";
import Student from "../components/Student.vue";

export default {
  name: "add-students-to-course",
  components: {
    Student,
  },
  data() {
    return {
      users: [],
    };
  },
  methods: {
    listAllUsers() {
      PortalServices.listAllUsers().then((response) => {
        this.users = response.data;
        this.$store.commit("SAVE_USERS", this.users);
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