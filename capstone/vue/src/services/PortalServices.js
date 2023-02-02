import axios from 'axios';

export default {
    createCourse(course) {
        return axios.post(`/createcourse`, course)
    },
    getAllCourses() {
        return axios.get(`/courses`)
    },
    getCourses(id){
        return axios.get(`/course/${id}`)
    }
}