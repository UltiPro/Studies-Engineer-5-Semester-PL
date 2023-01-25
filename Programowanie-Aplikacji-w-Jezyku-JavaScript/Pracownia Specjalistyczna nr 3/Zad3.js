console.log("Zadanie 3 --------------------------------------------");

let studentList = [{ imię: "Piotr", nazwisko: "Nowak", punkty: 63 },
{ imię: "Tomasz", nazwisko: "Kowalski", punkty: 88 },
{ imię: "Julia", nazwisko: "Bagińska", punkty: 75 },
{ imię: "Patryk", nazwisko: "Wójtowicz", punkty: 100 },
{ imię: "Magda", nazwisko: "Zaborowska", punkty: 2 },
{ imię: "Michał", nazwisko: "Wołosewicz", punkty: 3 },
{ imię: "Dawid", nazwisko: "Majewski", punkty: 50 },
{ imię: "Kacper", nazwisko: "Sokół", punkty: 69 }]

const avgPunkty = studentList.map(e => e.punkty).reduce((p, n) => p + n, 0) / studentList.length;

console.log(avgPunkty);

console.table(studentList.filter(e => e.punkty > avgPunkty).map(e => e.imię + " " + e.nazwisko));

console.table(studentList.filter(e => e.punkty > avgPunkty).sort((a, b) => a.punkty - b.punkty).reverse().filter((e, i) => i < 3));

const gradeFun = (points) => points < 50 ? "ndst" : (points < 60 ? "dst" : (points < 70 ? "dst+" : (points < 80 ? "db" : (points < 90 ? "db+" : "bdb"))));

const newStudentList = studentList.map(({ imię, nazwisko, punkty }) => ({ imię, nazwisko, punkty, ocena: gradeFun(punkty) }));

console.table(newStudentList);

console.table(newStudentList.map(e => [e.nazwisko, e.ocena]).sort());

let gradeArray = [{ ocena: "ndst", ilość: 0 }, { ocena: "dst", ilość: 0 }, { ocena: "dst+", ilość: 0 }, { ocena: "db", ilość: 0 }, { ocena: "db+", ilość: 0 }, { ocena: "bdb", ilość: 0 }];

newStudentList.map((e) => (e.ocena == "ndst" ? gradeArray[0].ilość++ : (e.ocena == "dst" ? gradeArray[1].ilość++ : (e.ocena == "dst+" ? gradeArray[2].ilość++ : (e.ocena == "db" ? gradeArray[3].ilość++ : (e.ocena == "db+" ? gradeArray[4].ilość++ : gradeArray[5].ilość++)))))); // : (e.ocena == "dst" ? gradeArray[1].ilość++ : (e.ocena == "dst+" ? gradeArray[2].ilość++ : (e.ocena == "db" ? gradeArray[3].ilość++ : (e.ocena == "db+" ? gradeArray[4].ilość++ : gradeArray[5].ilość++))))));

console.table(gradeArray);