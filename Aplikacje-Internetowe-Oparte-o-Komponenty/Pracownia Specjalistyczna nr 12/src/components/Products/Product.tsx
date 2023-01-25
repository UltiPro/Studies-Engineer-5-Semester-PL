
import { ProductType } from "../../types/Product";

import classes from './Product.module.css'

type ProductProps = {
	product: ProductType;
	addToDiet: (prod: ProductType) => void;
};
const Product = (props: ProductProps) => {
	const addToDietHandler=()=>{
		props.addToDiet(props.product)
	}
	return (
		<div className={classes.product}>
			<p>{props.product.name}: </p>
            <p><span>E:</span>{props.product.kcal}kcal </p>
            <p><span>W:</span>{props.product.carbo}g </p>
            <p><span>T:</span>{props.product.fat}g </p>
            <p><span>B:</span>{props.product.protein}g</p>
			<button onClick={addToDietHandler}>+</button>
			<button>edytuj</button>
		</div>
	);
};
export default Product;
