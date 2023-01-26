console.log("Zadanie 2 --------------------------------------------");

const skarbonka = (_imie, _stan = 0) => {
    return fun = (value) => {
        if (isNaN(value)) {
            console.log(_imie + " get " + _stan);
            return _stan;
        }
        else {
            _stan += value;
            console.log(_imie + " set " + _stan);
        }
    };
}

let s = skarbonka("Piotr", 100);
s(20); // wypisuje "Piotr set 120"
let ile = s(); // zwraca 120, wypisuje do konsoli "Piotr get 120"

s(50);

console.log(ile);

const s2 = skarbonka("Ania", 50);
s2(40);
let ile2 = s2();

console.log(ile2);

s = skarbonka("Piotr", 100);
s(-100);
ile = s();

console.log(ile);