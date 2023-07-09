const rndColor = () => {
    switch (Math.floor(Math.random() * 4)) {
        case 0:
            return "red";
        case 1:
            return "orange";
        case 2:
            return "green";
        case 3:
            return "blue";
    }
}

const tempName = (element, index) => {
    element.style.color = rndColor();
    element.title = "Paragraf o numerze " + index + " i ilości znaków " + element.textContent.length;
    element.addEventListener("click", () => {
        allP.forEach(element => {
            element.style.border = "";
            element.style.backgroundColor = "";
        })
        element.style.border = "green 1px solid";
        try {
            element.nextElementSibling.nextElementSibling.style.border = "blue 1px solid";
            element.previousElementSibling.previousElementSibling.style.border = "orange 1px solid";
        } catch (e) {
            console.log("Brak elementu następnego lub poprzedniego!");
        }
        if (index % 2 == 0) element.style.backgroundColor = "lightgrey";
        else element.style.backgroundColor = "darkgrey";
    });
    const h6 = document.createElement("h4");
    h6.textContent = "Paragraf " + (index + 1);
    h6.addEventListener("click", () => {
        if (h6.nextElementSibling.style.display === "none") h6.nextElementSibling.style.display = "block";
        else h6.nextElementSibling.style.display = "none";
    })
    element.parentNode.insertBefore(h6, element);
}

let allP = document.querySelectorAll('p');

allP.forEach((element, index) => {
    tempName(element, index);
});

document.getElementById("pButton").addEventListener("click", () => {
    const p = document.createElement('p');
    p.textContent = document.getElementById("pName").value;
    document.getElementById("pName").parentNode.insertBefore(p, document.getElementById("pName"));
    tempName(p, allP.length);
    allP = document.querySelectorAll('p');
});