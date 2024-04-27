import axios from "axios";

export const BASE_URL = 'http://localhost:8081';

// create a object od axios by usisng create funnction
//
export const MyAxios = axios.create({

    baseURL: BASE_URL
});