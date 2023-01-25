import React from "react";
import Img from "../UI/Img";
import { render, screen } from "@testing-library/react";

describe("Card Component", () => {
	it("Should render Card component", () => {
		render(
			<Img
				src="https://cdn.wamiz.fr/cdn-cgi/image/format=auto,quality=80,width=1200,height=1200,fit=cover/article/main-picture/5d91e23c6a1ec530822617.jpg"
				alt="piesek"></Img>
		);
		const imgElement = screen.getByRole("img");
		expect(imgElement).toHaveAttribute(
			"src",
			"https://cdn.wamiz.fr/cdn-cgi/image/format=auto,quality=80,width=1200,height=1200,fit=cover/article/main-picture/5d91e23c6a1ec530822617.jpg"
		);
	});
});
