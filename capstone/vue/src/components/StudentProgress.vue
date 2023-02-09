<template>
  <div>
    <p id="calculate-progress-show">
      Course Progress: {{ calculateProgress }}
    </p>
    
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
      let length=this.progressArr.length;
      if (this.progressArr.length === 0) {
        return 0 + "%";
      }
      for (let i = 0; i < this.progressArr.length -1; i++) {
        if(this.progressArr[i].grade === 0){
         length=length-1;
        }
        score = this.progressArr[i].grade + score;   
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
#calculate-progress-show {
  display: flex;
  justify-content: center;
  font-weight: bold;
  font-size: 30px;
  border: solid;
  padding: 10px;
  border-radius: 25px;
}
</style>