console.log("Zadanie 1 --------------------------------------------");

const combine = (fun, array1, array2) => array1.map((element, index) => fun(element, array2[index]));

console.log(combine((a, b) => a + b, [4, 5, 6], [10, 20, 30]));

console.log(combine((x, y) => ({ x, y }), [1, 2, 3], [7, 8, 9]));

const combineMoreArrays = (fun, ...arrays) => arrays[0].map((_, index) => fun(...arrays.map(array => array[index])));

console.log(combineMoreArrays((a, b, c) => a + b + c, [1, 2, 3], [5, 6, 7], [10, 20, 30]));

console.log(combineMoreArrays((a, b, c, d) => a + b + c + d, [1, 2, 3], [5, 6, 7], [10, 20, 30], [10, 20, 30]));