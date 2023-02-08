<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }"
        ><img id="logo1" src="./assets/inquisitlogo.png" alt="School Logo" /></router-link
      >&nbsp;&nbsp;&nbsp;
     
<div id="right-user">
<router-link v-bind:to="{ name: 'home' }"
        ><img id="logo2" src="./assets/textlogo.png" alt="School Logo2" align="right" /></router-link>
    <br>
      <span id="nav-right">
        <router-link
          v-bind:to="{ name: 'logout' }"
          v-if="$store.state.token != ''"
          >Logout</router-link>
          
        <p id="viewerName">{{ $store.state.user.username }}</p>
        </span>
</div>

    </div>
    <router-view />
    <footer></footer>
  </div>
</template>

<style scoped>
#right-user {
  display: flex;
  justify-content: right;
}
#app {
  height: 100%;
}
#logo1 {
  margin-left: 10px;
  width: 60px;
}
#logo2 {
  width: 60px;
  padding-right: 20px;;
}
#nav {
  border-bottom: solid;
  border-color: #75b9be;
  display: flex;
  justify-content: space-between;
  background-color: #f5f5f5;
}
#viewerName {
  display: flex;
  justify-content: right;
}
#nav-right {
  margin-right: 25px;
  margin-top: 25px;
}
/* footer {
  border-top: solid;
  border-color: #75b9be;
  height: 35px;
} */
#app {
  height: 100%;
}

#logo2 {
  width:20%
}


</style>