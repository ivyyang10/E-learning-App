<template>
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="name" class="sr-only">Name</label>
      <input
        type="text"
        id="name"
        class="form-control"
        placeholder="Name"
        v-model="user.name"
        required
        autofocus
      />
      <label for="email" class="sr-only">Email</label>
      <input
        type="email"
        id="email"
        class="form-control"
        placeholder="email"
        v-model="user.email"
        required
        autofocus
      />

      <!-- <h3>Role:</h3>
  <input type="radio" v-model="color" value="0">Student
  <input type="radio" v-model="color" value="1">Teacher
  <br /> <br> -->

      <label for="role" class="sr-only">Teacher?</label>
      <input
        v-on:click="setRole(checked)"
        type="checkbox"
        value="teacher"
        id="role"
        class="form-control"
        placeholder="role"
        v-model="checked"
        autofocus
      />

      <!-- <button id="teacher-button">Teacher</button>
      <button id="student-button" v-on:click="">Student</button> -->

      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      <router-link :to="{ name: 'login' }">Have an account?</router-link>
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "register",
  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        name: "",
        email: "",
        role: "user",
      },
      checked: false,
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: "/login",
                query: { registration: "success" },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
    },
    setRole(checked) {
      if (!checked) {
        this.user.role = "admin";
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  },
};
</script>

<style></style>
