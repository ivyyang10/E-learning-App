import axios from 'axios';

const http = axios.create(
    {baseURL: "http://localhost:9000"}
);

export default {
    createCourse(course) {
        return http.post(`/createcourse`, course)
    }
}