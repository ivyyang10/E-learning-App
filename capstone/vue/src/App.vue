<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }"><img src="./assets/schoolLogo.png" alt="School Logo"/></router-link>&nbsp;&nbsp;
       <span id="nav-right"><router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      <p id="viewerName">{{$store.state.user.username}}</p></span>
    </div>
    <router-view />
    <footer></footer>
  </div>
</template>

<style scoped>
img{
    width: 100px;
    
}
#nav {
    border-bottom: solid;
    border-color: #75b9be;
    display: flex;
    justify-content: space-between;
}
#viewerName {
  display: flex;
  justify-content: right;
}
#nav-right {
  margin-right: 25px;
  margin-top: 25px;
}
footer {
  border-top: solid;
  border-color: #75b9be;
}

</style>