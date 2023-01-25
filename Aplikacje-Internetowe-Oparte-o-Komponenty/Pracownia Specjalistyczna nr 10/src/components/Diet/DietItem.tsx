
import { ProductType } from "../../types/Product";
import classes from './DietItem.module.css'

type ProductProps = {
	product: ProductType;
    onDelete:(product:ProductType)=>void;
};
const DietItem = (props: ProductProps) => {
	const deleteDietItemHandler=()=>{
        props.onDelete(props.product)
        // console.log(props.product)
    }
	return (
		<div className={classes.product}>
			<p>{props.product.name}: </p>
            <p><span>E:</span>{props.product.kcal}kcal </p>
            <p><span>W:</span>{props.product.carbo}g </p>
            <p><span>T:</span>{props.product.fat}g </p>
            <p><span>B:</span>{props.product.protein}g</p>
            <button onClick={deleteDietItemHandler}>Usuń</button>
            {/* <button onClick={deleteDietItemHandler} >usuń</button> */}
		</div>
	);
};
export default DietItem;
