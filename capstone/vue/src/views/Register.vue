<template>
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div id="registerform">
        <label for="username" class="sr-only"></label>
        <input
          type="text"
          id="username"
          class="form-control"
          placeholder="Username"
          v-model="user.username"
          required
          autofocus
        />
        <label for="name" class="sr-only"></label>
        <input
          type="text"
          id="name"
          class="form-control"
          placeholder="Name"
          v-model="user.name"
          required
          autofocus
        />
        <label for="email" class="sr-only"></label>
        <input
          type="email"
          id="email"
          class="form-control"
          placeholder="Email"
          v-model="user.email"
          required
          autofocus
        />

        <!-- <h3>Role:</h3>
  <input type="radio" v-model="color" value="0">Student
  <input type="radio" v-model="color" value="1">Teacher
  <br /> <br> -->
        <br />
        <label for="role" class="sr-only">Are you an educator?</label>
        <input
          v-on:click="checked = !checked"
          type="checkbox"
          value="teacher"
          id="role"
          class="form-control"
          placeholder="role"
          v-model="checked"
          v-bind:role="setRole"
          autofocus
        />

        <!-- <button id="teacher-button">Teacher</button>
      <button id="student-button" v-on:click="">Student</button> -->

        <label for="password" class="sr-only"></label>
        <input
          type="password"
          id="password"
          class="form-control"
          placeholder="Password"
          v-model="user.password"
          required
        />
        <br />
        <input
          type="password"
          id="confirmPassword"
          class="form-control"
          placeholder="Confirm Password"
          v-model="user.confirmPassword"
          required
        />
        <br />
        <br />
        <div id="createbutton">
          <button
            v-on:click="setRole"
            class="btn btn-lg btn-primary btn-block"
            type="submit"
          >
            Create Account
          </button>
          <br />
          <br />
          <router-link id="haveaccount" :to="{ name: 'login' }"
            >Have an account?</router-link
          >
        </div>
      </div>
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
    setRole() {
      if (this.checked==true) {
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

<style scoped>
* {
  font-family: Roboto, Verdana, Segoe, sans-serif;
}
#register {
  grid-area: register;
  display: flex;
  justify-content: center;
  background: linear-gradient(90deg, #75b9be 0%, #c7d66d 100%);

  /* border-style: solid;
  border-color: #75b9be; */
  padding-bottom: 20px;
  padding-top: 20px;
}
.form-register {
  background-color: transparent;
}
#registerform {
  border-style: solid;
  border-radius: 25px;
  padding: 20px;
  padding-right: 100px;
  padding-left: 100px;
  margin: 25px 50px;
  background-color: white;
}
input,
label {
  display: block;
}
label {
  padding: 5px;
  padding-top: 15px;
}
input {
  border-radius: 25px;
  border-bottom: solid 3px;
  padding: 15px;
}
#createbutton {
  display: flex;
  justify-content: center;
}
#haveaccount {
  padding-left: 30px;
  padding-top: 10px;
}
</style>
