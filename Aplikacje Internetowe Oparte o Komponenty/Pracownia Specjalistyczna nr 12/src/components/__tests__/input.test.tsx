import React from "react";
import { render, screen, fireEvent } from "@testing-library/react";
import Input from "../UI/Input";
import Validate from "../UI/Validate";
// label: string;
// type: string;
// id: string;
// value: string;
// onChange: (e: React.FormEvent<HTMLInputElement>) => void;
describe("Input Component", () => {
	it("Should render value in input", () => {
		render(<Validate products={[]} onAddProduct={() => {}}></Validate>);
		const idInputElement = screen.getByPlaceholderText("...");
		console.log(idInputElement);
		// fireEvent.change(inputElement, { target: { value: "Mleko" } });
		// console.log(inputElement);
	});
});
