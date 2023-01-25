function Zad1(count) {
    let output = '';
    for (i = 1; i <= count; i++) {
        if ((i % 2) == 0) {
            if ((i % 3) == 0) output += "FizBuz";
            else output += "Fiz";
        }
        else if ((i % 3) == 0) output += "Buz";
        else output += i;
    }
    console.log(output);
    return output;
}