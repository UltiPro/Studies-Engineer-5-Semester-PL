import { useState } from "react";
import ProductList from "./components/Products/ProductList";
import Card from "./components/UI/Card";

import styles from "./App.module.css";
import { ProductType } from "./types/Product";
import Validate from "./components/UI/Validate";

function App() {
	const products = [
		{id:'1', name: "Mleko", kcal: 100, carbo: 13, fat: 30, protein: 43 },
		{id:'2', name: "Chleb", kcal: 250, carbo: 57, fat: 10, protein: 5 },
		{ id:'3',name: "Jajko", kcal: 150, carbo: 2, fat: 2, protein: 65 },
	];
	const [productList, setProductList] = useState(products);

	const addProductHandler = (product: ProductType): void => {
		console.log(product);
		setProductList((prev) => {
			return [...prev, product];
		});
	};
	return (
		<div className={styles.app}>
			<Card>
				<ProductList products={productList}></ProductList>
			</Card>
			<Card>
				{/* <AddProduct onAdd={addProductHandler}></AddProduct> */}
				<Validate products={productList} onAddProduct={addProductHandler}></Validate>
			</Card>
		</div>
	);
}

export default App;
