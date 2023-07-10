import { useEffect, useState } from 'react';
// import axios from "axios";
import api from './api/posts';
import { Route, Routes } from 'react-router-dom';
import ProductList from './components/Products/ProductList';
import Card from './components/UI/Card';

import { ProductType } from './types/Product';
import Validate from './components/UI/Validate';
import styles from './App.module.css';
import DietList from './components/Diet/DistList';
import Navbar from './components/Navbar/Navbar';

function App() {
	const products = [
		{ id: '1', name: 'Mleko', kcal: 100, carbo: 13, fat: 30, protein: 43 },
	];
	let dietItems: ProductType[] = [];
	const [productList, setProductList] = useState(products);
	const [dietList, setDietList] = useState(dietItems);

	useEffect(() => {
		const fetchPosts = async () => {
			try {
				const response = await api.get('./products');
				setProductList(response.data);
			} catch (err: any) {
				console.log(err.response.data);
				console.log(err.response.status);
				console.log(err.response.headers);
			}
		};
		fetchPosts();
	}, []);

	const addProductHandler = async (product: ProductType) => {
		try {
			const response = await api.post('./products', product);
			setProductList((prev) => {
				return [...prev, response.data];
			});
		} catch (err: any) {
			console.log(`Error ${err.message}`);
		}
	};
	const addProductToDietHandler = (product: ProductType) => {
		setDietList((prev) => {
			return [...prev, product];
		});
	};
	const deleteFromDietHandler = (product: ProductType) => {
		setDietList((prev) => {
			const itemId = prev.findIndex((item) => item.id === product.id);
			console.log(itemId);
			if (itemId !== -1) {
				prev.splice(itemId, 1);
				return [...prev];
			} else {
				return [...prev];
			}
		});
	};
	const DietComponent = (
		<DietList
			dietList={dietList}
			onDeleteDiet={deleteFromDietHandler}
		></DietList>
	);

	const ProductsComponent = (
		<ProductList
			products={productList}
			onAddProduct={addProductToDietHandler}
		></ProductList>
	);
	const AddProductComponent = (
		<Validate
			products={productList}
			onAddProduct={addProductHandler}
		></Validate>
	);
	return (
		<>
			<Navbar></Navbar>
			<div className={styles.app}>
				<Routes>
					<Route path='/' element={<Card>{DietComponent}</Card>}></Route>
					<Route path='/diet' element={<Card>{DietComponent}</Card>}></Route>
					<Route
						path='/products'
						element={<Card>{ProductsComponent}</Card>}
					></Route>
					<Route
						path='/add-product'
						element={<Card>{AddProductComponent}</Card>}
					></Route>
				</Routes>
			</div>
		</>
	);
}
export default App;
