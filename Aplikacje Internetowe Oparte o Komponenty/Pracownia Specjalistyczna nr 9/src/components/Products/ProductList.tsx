import { ProductType } from '../../types/Product';
import Product from './Product';
import classes from './ProductList.module.css';

type MyProps = {
	products: ProductType[];
};

const ProductList = (props: MyProps) => {
	return (
		<div className={classes['product-list-box']}>
			<h2 className={classes.heading}>Lista produktów</h2>
			<ul className={classes['product-list']}>
				{props.products.map((prod: ProductType) => {
					return (
						<li key={Math.round(Math.random() * 1000)}>
							<Product product={prod}></Product>
						</li>
					);
				})}
			</ul>
		</div>
	);
};
export default ProductList;
