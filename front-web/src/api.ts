import axios from "axios";

const API_URL = 'http://localhost:8080';

//aqui faz uma requisição no products
export function fetchProducts(){
    return axios(`${API_URL}/products`);
}