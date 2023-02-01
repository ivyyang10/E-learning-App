<template>
    <div>
  <form class="curricula-maker-form" v-on:submit.prevent="saveCurricula">
    <input class="dailyInstruction" type="text" placeholder="Daily Instruction" v-model="curricula.dailyInstruction" />
    <input class="link" type="text" placeholder="Classroom Resources" v-model="curricula.link" />
    <input class="hwAssignment" type="text" placeholder="HW Assignments" v-model="curricula.hwAssignment" />
    <button>Save</button>
  </form>
  </div>
</template>

<script>
export default {
    name: "curricula-maker-form",
    data(){
        return {
            curricula: {
                dailyInstruction: '',
                link: '',
                hwAssignment: ''
            }
        }
    },
    methods: {
        saveCurricula(){
            this.$store.commit('SAVE_CURRICULA', this.curricula);
            this.curricula = {
                dailyInstruction: '',
                link: '',
                hwAssignment: ''
            };
            this.$router.push({curricula: 'newCurricula'})
        }
    }

}
</script>

<style>

</style>