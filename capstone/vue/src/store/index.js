import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: 
  {
    token: currentToken || '',
    user: currentUser || {},
    courses: [
      {
        coursename: "Math 101",
        description: "Yay math stuff!",
        difficulty: "Hard",
        courseid: 2001,
        cost: 0,
        teacherid: 10
      },
      {
        coursename: "Science 101",
        description: "Science!",
        difficulty: "Hard",
        courseid: 2002,
        cost: 0,
        teacherid: 10
      },
      {
        coursename: "Java 101",
        description: "Sweet dude!",
        difficulty: "Easy",
        courseid: 2003,
        cost: 0,
        teacherid: 10
      }
    ]
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    }
  }
})
