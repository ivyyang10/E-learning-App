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
    getQuiz(id) {
        return axios.get(`/viewquiz/${id}`)
    },
    getQuizQuestions(id) {
        return axios.get(`/quiz/${id}`)
    },
    listAllUsers() {
        return axios.get(`/users`)
    },
    addStudentToCourse(id, userObject) {
        return axios.post(`/course/${id}`, userObject)
    },
    submitHomework(id, homeworkObject) {
        return axios.post(`/course/${id}/homework`, homeworkObject)
    },
    getCourseByStudentId() {
        return axios.get(`/studentcourses`)
    },
    getStudentByCourseId(id) {
        return axios.get(`/students/${id}`)
    },
    hwSubmissionNotificationTeacher(id) {
        return axios.get(`/homework/${id}`)
    },
    studentProgress() {
        return axios.get(`/homework`)
    }
}