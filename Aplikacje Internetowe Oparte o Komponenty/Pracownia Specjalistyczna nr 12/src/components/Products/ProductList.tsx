import { ProductType } from "../../types/Product";
import Product from "./Product";
import classes from "./ProductList.module.css";

type MyProps = {
	products: ProductType[];
	onAddProduct: (prod: ProductType) => void;
};
const ProductList = (props: MyProps) => {
	const addToDietHandler = (product: ProductType) => {
		props.onAddProduct(product);
	};
	return (
		<div className={classes["product-list-box"]}>
			<h2 className={classes.heading}>Lista produktów</h2>
			<ul className={classes["product-list"]}>
				{props.products.map((prod: ProductType) => {
					return (
						<li key={prod.id}>
							<Product
								product={prod}
								addToDiet={addToDietHandler}></Product>
						</li>
					);
				})}
			</ul>
		</div>
	);
};
export default ProductList;
