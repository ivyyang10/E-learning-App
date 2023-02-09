<template>
  <body>
    <div id="middle-grid">
      <div id="image-container">
        <img
          id="login-photo"
          src="../assets/pexels-pixabay-207684.jpg"
          alt="login school photo"
        />
      </div>

      <div id="form-container">
        <div id="login" class="text-center">
          <form class="form-signin" @submit.prevent="login">
            <h1 id="sign-in-text" class="h3 mb-3 font-weight-normal">Please Sign In</h1>
            <br>
            <div
              class="alert alert-danger"
              role="alert"
              v-if="invalidCredentials"
            >
              Sorry, invalid username and password.
            </div>
            
            <div
              class="alert alert-success"
              role="alert"
              v-if="this.$route.query.registration"
            >
              Thank you for registering! Please sign in.
            </div>
            <br>
            <label id="username-prompt" for="username" class="sr-only"></label>
            <input
              type="text"
              id="username"
              class="form-control"
              placeholder="Username"
              v-model="user.username"
              required
              autofocus
            />
            <br>
            <label id="password-prompt" for="password" class="sr-only"></label>
            <input
              type="password"
              id="password"
              class="form-control"
              placeholder="Password"
              v-model="user.password"
              required
            />
            <br>
            <div id ="loginbutton">
            <button id="submit-button" type="submit">Sign In</button>
          
           <br>
            <div id="need-account">
      <router-link :to="{ name: 'register' }">Need an account?</router-link>
    </div>
    </div>
          </form>
        </div>
      </div>
    </div>
  </body>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>


<style scoped>

#middle-grid {
  display: grid;
  grid-template-columns: 1fr 1fr;
 
  row-gap: 20px;
  column-gap: 35px;
  /* align-items: vertical;
  align-items: center; */
  grid-template-areas:
 
  'image-container form-container';
}
#login-photo {
  display: grid;
  height: 100%;
  width: 100%;
}
#sign-in-text {
  display: flex;
  justify-content: center;
}
#login {
  padding: 50px;
}
input, label {
  display: block;
}
input {
  border-radius: 25px;
  border-bottom: solid 3px;
  padding: 15px;
}
#image-container {
  display: grid;
  /* padding-top: 10px; */
  justify-content: center;
  /* max-width: 35%; */
  
}
#form-container {
  display: grid;
  justify-content: center;
  padding: 50px;
  align-items: center;
  padding-bottom: 20px;
}
#username {
  text-align: center;
}
#password {
  text-align: center;
}
#need-account {
  padding: 7px;
  padding-top: 10px;
}
#loginbutton {
  display: flex;
  justify-content: center;
  padding-top: 20px;;
}
.form-signin {
  display: flex;
  justify-content: center;
  flex-direction: column;
}
</style>


