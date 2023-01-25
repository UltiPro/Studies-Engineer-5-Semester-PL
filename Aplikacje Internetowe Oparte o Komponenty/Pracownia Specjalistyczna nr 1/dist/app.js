const string = "aaa";
const array = [];
const countOfSamogloski = (v) => {
    const count = v.match(/[aeiouóyęą]/gi).length;
    return count;
};
function isSorted(v) {
    let value = true;
    if (v.length == 0) {
        value = false;
        return value;
    }
    else {
        for (let i = 0; i < v.length; i++) {
            if (v[i] > v[i + 1]) {
                value = false;
                break;
            }
        }
        return value;
    }
}
const sortedAnswear = (v) => {
    return v ? "sorted" : "not sorted";
};
const a1 = document.getElementById("Answear1");
const a2 = document.getElementById("Answear2");
a1.innerHTML = "String <b>" + string + "</b> has " + countOfSamogloski(string).toString() + " samoglosek.";
a2.innerHTML = "The array <b>" + array.toString() + "</b> is " + sortedAnswear(isSorted(array)) + ".";
