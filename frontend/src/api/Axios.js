import axios from 'axios';


export default axios.create({
    baseUrl: process.env.BACKEND_BASE_URL
})
