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
    },
    getUser(){
        return axios.get('/')
    },
    getQuiz(id) {
        return axios.get(`/viewquiz/${id}`)
    },
    getQuizQuestions(id) {
        return axios.get(`/quiz/${id}`)
    },
    listAllUsers() {
        return axios.get(`/users`)
    },
    addStudentToCourse(userObject) {
        return axios.post(`/enrollStudent`, userObject)
    }
}