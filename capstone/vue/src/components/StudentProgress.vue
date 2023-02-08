<template>
  <div>
    {{ calculateProgress }}
  </div>
</template>

<script>
import PortalServices from "../services/PortalServices";
export default {
  name: "student-progress",
  data() {
    return {
      progressArr: [],
    };
  },
  computed: {
    calculateProgress() {
      let score = 0;
      if (this.progressArr.length === 0) {
        return 0 + "%";
      }
      for (let i = 0; i < this.progressArr.length; i++) {
        if (this.progressArr[i].completed == true) {
          score++;
        }
      }
      return (score / this.progressArr.length) * 100 + "%";
    },
  },
  created() {
    PortalServices.studentProgress().then((response) => {
      this.progressArr = response.data;
    });
  },
};
</script>

<style>
</style>