
import { ProductType } from "../../types/Product";

import classes from './Product.module.css'

type ProductProps = {
	product: ProductType;
};
const Product = (props: ProductProps) => {
	return (
		<div className={classes.product}>
			<p>{props.product.name}: </p>
            <p><span>E:</span>{props.product.kcal}kcal </p>
            <p><span>W:</span>{props.product.carbo}g </p>
            <p><span>T:</span>{props.product.fat}g </p>
            <p><span>B:</span>{props.product.protein}g</p>
		</div>
	);
};
export default Product;
