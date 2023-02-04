<template>
  <main>
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
            <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
            <div
              class="alert alert-danger"
              role="alert"
              v-if="invalidCredentials"
            >
              Invalid username and password!
            </div>
            <div
              class="alert alert-success"
              role="alert"
              v-if="this.$route.query.registration"
            >
              Thank you for registering, please sign in.
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
            <label for="password" class="sr-only">Password</label>
            <input
              type="password"
              id="password"
              class="form-control"
              placeholder="Password"
              v-model="user.password"
              required
            />
            <button type="submit">Sign in</button>
          </form>
        </div>
      </div>
    </div>
    <footer>
      <router-link :to="{ name: 'register' }">Need an account?</router-link>
    </footer>
  </main>
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


<style>
#middle-grid {
  display: flex;
  grid-template-columns: 1fr 1fr;
  row-gap: 20px;
  column-gap: 35px;
  /* align-items: vertical;
  align-items: center; */
  grid-template-areas: "image-container form-container";
}
#login-photo {
  display: flex;
  height: 500px;
}
#image-container {
  display: flex;
  justify-content: flex-start;
  /* max-width: 35%; */
}

#form-container {
  display: flex;
  justify-content: right;
  padding: 50px;
  align-items: center;
}
#footer {
  display: flex;
  justify-content: center;
}
</style>

// #main-grid {
//   width: 90%;
//   margin: auto;
//   display: grid; 
//   grid-template-columns: repeat(3, 1fr); 
//   grid-template-rows: 1fr; 
//   gap: 20px; 
//   grid-template-areas: 
//     'image-container image-container login-container'; 
// }
// #image-container {
//   grid-area: image-container;
// }
// #login-container {
//   grid-area: login-container;
// }
