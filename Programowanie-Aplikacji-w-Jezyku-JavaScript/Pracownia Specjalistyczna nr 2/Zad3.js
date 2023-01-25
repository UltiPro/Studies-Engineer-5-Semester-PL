let array;

function Zad31(target) {
    array = generateRandom();
    target.innerText = array;
}

function Zad32(target) {
    array.splice(array.indexOf(Math.min(...array)), 1);
    target.innerText = array;
}

function Zad33(target) {
    array.splice(array.lastIndexOf(Math.max(...array)), 1);
    target.innerText = array;
}

function Zad34(target) {
    const answer = array.reduce((a, b) => (a[b] ??= 0, a[b] += 1, a), {});
    console.log(answer);
    let tempArray = [];
    Object.keys(answer).forEach(element => {
        tempArray.push(element + " => " + Object.values(answer)[element - 1] + " ");
    });
    target.innerText = tempArray;
}

function Zad35(target) {
    array.push(...array.splice(0, 10));
    target.innerText = array;
}

const generateRandom = () => {
    let suma = 0;
    const res = [];
    while (suma < 200) {
        const number = Math.random() * 10 % 10 + 1 ^ 0;
        res.push(number);
        suma += number;
    }
    return res;
}