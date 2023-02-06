<template>
  <div id="users=list">
      <student-object v-for="users in $store.state.users" v-bind:key="users.id"/>
  </div>
</template>

<script>
import PortalServices from '../services/PortalServices'
import StudentObject from './StudentObject.vue'
export default {
  components: { StudentObject },
    data(){
        return {
           Students:[]
        }
    },
    methods: {
        listAllUsers() {
            PortalServices.listAllUsers().then(response =>{
                this.$store.state.users = response.data
            })
        }
    }
}
</script>

<style>

</style>