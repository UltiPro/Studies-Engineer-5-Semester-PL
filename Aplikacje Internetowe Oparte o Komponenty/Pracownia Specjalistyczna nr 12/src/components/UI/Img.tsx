

type ImgProps = {
	src: string;
	alt: string;
};
const Img = (props: ImgProps) => {
	return (
		<div>
			<img src={props.src} alt={props.alt}></img>
		</div>
	);
};
export default Img;
