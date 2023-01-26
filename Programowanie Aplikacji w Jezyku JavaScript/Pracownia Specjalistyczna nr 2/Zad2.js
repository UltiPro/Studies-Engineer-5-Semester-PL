function Zad2(value, target) {
    value = value.replace(',', '.');
    if (isNaN(value) || value == '') target.innerText = "Promeiń nie jest numerem!";
    else target.innerText = "Przy promieniu " + value + ", pole koła wynosi " + Zad2Pole(value).toFixed(2) + ", a obwód wynosi " + Zad2Obwod(value).toFixed(2) + ".";
}

const Zad2Pole = (r) => Math.PI * r * r;

const Zad2Obwod = (r) => 2 * Math.PI * r;