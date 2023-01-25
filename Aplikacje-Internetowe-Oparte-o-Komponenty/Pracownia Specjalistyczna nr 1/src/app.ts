const string: string = "aaa";
const array: number[] = [];

const countOfSamogloski = (v: string): number => {
    const count: number = v.match(/[aeiouóyęą]/gi).length;
    return count;
}

function isSorted(v: number[]): boolean {
    let value: boolean = true;
    if(v.length==0)
    {
        value= false;
        return value;
    }
    else
    {
        
    for (let i = 0; i < v.length; i++) {
        if (v[i] > v[i + 1]) {
            value = false;
            break;
        }
    }
    return value;
    }
    
}

const sortedAnswear = (v: boolean): string => {
    return v ? "sorted" : "not sorted";
}

const a1: HTMLElement = document.getElementById("Answear1");
const a2: HTMLElement = document.getElementById("Answear2");

a1.innerHTML = "String <b>" + string + "</b> has " + countOfSamogloski(string).toString() + " samoglosek.";
a2.innerHTML = "The array <b>" + array.toString() + "</b> is " + sortedAnswear(isSorted(array)) + ".";