<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }"
        ><img id="logo1" src="./assets/inquisitlogo.png" alt="School Logo" /></router-link
      >&nbsp;&nbsp;&nbsp;
     
      <router-link v-bind:to="{ name: 'home' }"
        ><img id="logo2" src="./assets/leftspacelogo.png" alt="School Logo2" align="left" /></router-link
      >
    
      <span id="nav-right"
        ><router-link
          v-bind:to="{ name: 'logout' }"
          v-if="$store.state.token != ''"
          >Logout</router-link
        >
        <p id="viewerName">{{ $store.state.user.username }}</p></span
      >
    </div>
    <router-view />
    <footer></footer>
  </div>
</template>

<style scoped>
#app {
  height: 100%;
}
#logo1 {
  width: 60px;
}
#nav {
  border-bottom: solid;
  border-color: #75b9be;
  display: flex;
  justify-content: space-between;
  background-color:#FFFF;
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
  width:50%
}


</style>