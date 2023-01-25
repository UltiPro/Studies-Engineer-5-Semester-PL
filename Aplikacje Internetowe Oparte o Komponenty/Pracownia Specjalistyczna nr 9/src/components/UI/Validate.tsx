//import Error from './../UI/Error'
import { useState } from "react";
import { ProductType } from "../../types/Product";
import Input from "./Input";
import Error from "./Error";
import classes from "./Validate.module.css";

type validateProps = {
	// items:{message: string;
	//     status: boolean;}[]
	products: ProductType[];
	onAddProduct: (prod: ProductType) => void;
};

const Validate = (props: validateProps) => {
	const [id, setId] = useState("");
	const [name, setName] = useState("");
	const [kcal, setKcal] = useState("");
	const [carbo, setCarbo] = useState("");
	const [fat, setFat] = useState("");
	const [protein, setProtein] = useState("");

	const [idIsValid, setIdIsValid] = useState(false);
	const [nameIsValid, setNameIsValid] = useState(false);
	const [kcalIsValid, setKcalIsValid] = useState(false);
	const [carboIsValid, setCarboIsValid] = useState(false);
	const [fatIsValid, setFatIsValid] = useState(false);
	const [proteinIsValid, setProteinIsValid] = useState(false);

	const idHandler = (e: React.FormEvent<HTMLInputElement>) => {
		setId(e.currentTarget.value);
		if (props.products.find((p) => +p.id === +e.currentTarget.value))
			setIdIsValid(false);
		else setIdIsValid(true);
	};
	const nameHandler = (e: React.FormEvent<HTMLInputElement>) => {
		setName(e.currentTarget.value);
		if (
			e.currentTarget.value.trim().length !== 0 &&
			/^[a-zA-Z]+$/.test(e.currentTarget.value)
		)
			setNameIsValid(true);
		else setNameIsValid(false);
	};
	const kcalHandler = (e: React.FormEvent<HTMLInputElement>) => {
		setKcal(e.currentTarget.value);
		if (+e.currentTarget.value < 0 || +e.currentTarget.value > 1000)
			setKcalIsValid(false);
		else setKcalIsValid(true);
	};
	const carboHandler = (e: React.FormEvent<HTMLInputElement>) => {
		setCarbo(e.currentTarget.value);
		if (+e.currentTarget.value < 0 || +e.currentTarget.value > 100)
			setCarboIsValid(false);
		else setCarboIsValid(true);
	};
	const fatHandler = (e: React.FormEvent<HTMLInputElement>) => {
		setFat(e.currentTarget.value);
		if (+e.currentTarget.value < 0 || +e.currentTarget.value > 100)
			setFatIsValid(false);
		else setFatIsValid(true);
	};
	const proteinHandler = (e: React.FormEvent<HTMLInputElement>) => {
		setProtein(e.currentTarget.value);
		if (+e.currentTarget.value < 0 || +e.currentTarget.value > 100)
			setProteinIsValid(false);
		else setProteinIsValid(true);
	};
	const addProductHandler = (e: any) => {
		e.preventDefault();
		if (
			idIsValid &&
			nameIsValid &&
			kcalIsValid &&
			carboIsValid &&
			fatIsValid &&
			proteinIsValid
		) {
			props.onAddProduct({
				id: id,
				name: name,
				kcal: +kcal,
				carbo: +carbo,
				fat: +fat,
				protein: +protein,
			});
			setId("");
			setName("");
			setKcal("");
			setCarbo("");
			setFat("");
			setProtein("");
			setIdIsValid(false);
			setNameIsValid(false);
			setKcalIsValid(false);
			setCarboIsValid(false);
			setFatIsValid(false);
			setProteinIsValid(false);
		}
		console.log(id, name, kcal, carbo, fat, protein);
	};

	return (
		<div className={classes["form-group"]}>
			<form onSubmit={addProductHandler}>
				<Input
					id="id"
					type="text"
					label="Id"
					value={id}
					onChange={idHandler}></Input>
				<Error message="Unikalny klucz" status={idIsValid}></Error>
				<Input
					id="name"
					type="text"
					label="Nazwa"
					value={name}
					onChange={nameHandler}></Input>
				<Error message="Wymagany" status={nameIsValid}></Error>
				<Input
					id="kcal"
					type="number"
					label="Kcal"
					value={kcal}
					onChange={kcalHandler}></Input>
				<Error message="<0,1000>" status={kcalIsValid}></Error>
				<Input
					id="carbo"
					type="number"
					label="Węglowodany"
					value={carbo}
					onChange={carboHandler}></Input>
				<Error message="<0,1000>" status={carboIsValid}></Error>
				<Input
					id="fat"
					type="number"
					label="Tłuszcz"
					value={fat}
					onChange={fatHandler}></Input>
				<Error message="<0,1000>" status={fatIsValid}></Error>
				<Input
					id="protein"
					type="number"
					label="Białko"
					value={protein}
					onChange={proteinHandler}></Input>
				<Error message="<0,1000>" status={proteinIsValid}></Error>
				<button type="submit">Dodaj</button>
			</form>
		</div>
	);
};
export default Validate;
