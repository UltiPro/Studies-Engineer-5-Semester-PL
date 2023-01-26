document.getElementById("start1").addEventListener("click", function () {
    document.getElementById("odp1").innerText = Zad1(100);
});

document.getElementById("start2").addEventListener("click", function () {
    Zad2(document.getElementById("start2input").value, document.getElementById("odp2"));
});

document.getElementById("start31").addEventListener("click", function () {
    Zad31(document.getElementById("odp31"));
});

document.getElementById("start32").addEventListener("click", function () {
    Zad32(document.getElementById("odp32"));
});

document.getElementById("start33").addEventListener("click", function () {
    Zad33(document.getElementById("odp33"));
});

document.getElementById("start34").addEventListener("click", function () {
    Zad34(document.getElementById("odp34"));
});

document.getElementById("start35").addEventListener("click", function () {
    Zad35(document.getElementById("odp35"));
});

const imionaTable = ["Patryk", "Magda", "Michał", "Janek", "Kacper", "Kazimierz"];

document.getElementById("start4").addEventListener("click", function () {
    const output = Zad4(imionaTable);
    document.getElementById("odp4").innerText = output;
    console.log(output);
});

const products = "Jajka,Chleb,Masło,Majonez,Cebula,Frytki";

document.getElementById("start5").addEventListener("click", function () {
    Zad5(products);
});