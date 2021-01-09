import axios from "axios";

const API_URL = 'http://localhost:8080';
const mapboxToken = process.env.REACT_APP_ACCESS_TOKEN_MAP_BOX;

//aqui faz uma requisição no products
export function fetchProducts(){
    return axios(`${API_URL}/products`);
}


export function fetchLocalMapBox(local: string){
    return axios(`https://api.mapbox.com/geocoding/v5/mapbox.places/${local}.json?access_token=${mapboxToken}`)
}