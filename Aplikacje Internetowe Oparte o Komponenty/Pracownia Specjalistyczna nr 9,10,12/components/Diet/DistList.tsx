import { useState } from 'react';
import { ProductType } from '../../types/Product';
import DeleteBox from '../UI/DeleteBox';
import DietItem from './DietItem';
import classes from './DietList.module.css';

type MyProps = {
	dietList: ProductType[];
	onDeleteDiet: (product: ProductType) => void;
};

const DietList = (props: MyProps) => {
	const [isDeleting, setIsDeleting] = useState(false);
	const [productToDelete, setProductToDelete] = useState(props.dietList[0]);
	const deleteFromDietHandler = (product: ProductType) => {
		setIsDeleting(true);
		setProductToDelete(product);
	};
	const confirmDeleteHandler = () => {
		setIsDeleting(false);
		props.onDeleteDiet(productToDelete);
	};
	const cancelDeleteHandler = () => {
		setIsDeleting(false);
	};

	return (
		<>
			<div className={classes['product-list-box']}>
				<h2 className={classes.heading}>Twoja dzisiejsza diata</h2>
				<ul className={classes['product-list']}>
					{props.dietList.map((prod: ProductType) => {
						return (
							<li key={Math.round(Math.random() * 1000)}>
								<DietItem
									product={prod}
									onDelete={deleteFromDietHandler}
								></DietItem>
							</li>
						);
					})}
				</ul>
			</div>
			{isDeleting && (
				<DeleteBox
					onConfirm={confirmDeleteHandler}
					onCancel={cancelDeleteHandler}
				></DeleteBox>
			)}
		</>
	);
};
export default DietList;