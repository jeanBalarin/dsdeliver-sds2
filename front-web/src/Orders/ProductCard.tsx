import Product from './types';

type Props = {
    product: Product; 
}


function ProductsCard( { product }: Props){
    return (
        <div className="order-card-container">
            <h3 className="order-card-title">
                {product.name}
            </h3>
            <img 
                src={product.imageUri} 
                className="order-card-image"
                alt={product.name}
            ></img>
            
            <h3 className="order-card-price" >
               R${product.price}
            </h3>
            <div className="order-card-description">
                <h3>Descrição</h3>
                {product.description}
            </div>
        </div>       
    )
}

export default ProductsCard;