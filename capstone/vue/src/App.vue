<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }"><img src="src\assets\StockLogo.webp" alt="School Logo"/></router-link>&nbsp;|&nbsp;
       <span><router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      <p id="viewerName">{{$store.state.user.username}}</p></span>
    </div>
    <router-view />
  </div>
</template>

<style scoped>
img{
    width: 100px;
    height: 100px;
}
#nav {
    border-bottom: solid;
    display: flex;
    justify-content: space-between;
}
#viewerName {
  display: flex;
  justify-content: right;
}

</style>