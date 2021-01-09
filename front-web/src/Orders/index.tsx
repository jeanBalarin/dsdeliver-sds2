import './styles.css';
import StepsHeader from "./StepsHeader";
import ProductsList from "./ProductsList";
import OrderLocation from "./OrderLocation";
import { useEffect, useState } from 'react';
import {fetchProducts} from '../api';
import { OrderLocationData, Product } from './types';


function Orders(){

    const[products, setProducts] = useState<Product[]>([]);
    const[orderLocation, setOrderLocation] = useState<OrderLocationData>();


    useEffect(() =>{
        fetchProducts()
            .then(response => setProducts(response.data))
            .catch(error => console.log(error))
        }, []);




    return (
        <div className="orders-cantainer">
            <StepsHeader />
            <ProductsList products={products}/>
            <OrderLocation onChangeLocation={location =>setOrderLocation(location)} />
        </div>
    )
}

export default Orders;