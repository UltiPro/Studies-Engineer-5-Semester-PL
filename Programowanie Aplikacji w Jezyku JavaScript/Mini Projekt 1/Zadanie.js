class Product {
    #name;
    #price;
    #count;
    constructor(name, price = 1, count = 1) {
        this.#name = name;
        this.#price = price;
        this.#count = count;
    }
    Name = () => this.#name;
    SetName = (name) => this.#name = name;
    Price = () => this.#price;
    SetPrice = (price) => this.#price = price;
    Count = () => this.#count;
    SetCount = (count) => this.#count = count;
    GetToJSON = () => {
        return { name: this.#name, price: this.#price, count: this.#count };
    }
}

class Receipt {
    #products = [];
    constructor() {
        this.DownloadInstance();
    }
    AddProduct(product) {
        if (product.Name() == "" || isNaN(product.Count()) || isNaN(product.Price())) return;
        const id = this.#products.findIndex(p => p.Name() === product.Name());
        if (id != -1 && this.#products[id].Price() == product.Price()) this.#products[id].SetCount(this.#products[id].Count() + product.Count());
        else this.#products.push(product);
        this.SaveInstance();
    }
    EditProduct(id, newProduct) {
        try {
            this.#products[id].SetName(newProduct.Name() || this.#products[id].Name());
            this.#products[id].SetPrice(newProduct.Price() || this.#products[id].Price());
            this.#products[id].SetCount(newProduct.Count() || this.#products[id].Count());
        }
        catch (e) {
            console.error(`Nie odnaleziono produktu! Błąd: ${e}`);
        }
        this.SaveInstance();
    }
    DeleteProduct(id) {
        try {
            this.#products.splice(id, 1);
        }
        catch (e) {
            console.error(`Nie odnaleziono produktu! Błąd: ${e}`);
        }
        this.SaveInstance();
    }
    ChangeNumbering(idFrom, idTo) {
        try {
            const temp = this.#products[idFrom];
            this.#products[idFrom] = this.#products[idTo];
            this.#products[idTo] = temp;
        }
        catch (e) {
            console.error(`Nie odnaleziono produktów ${idFrom}, ${idTo}! Błąd: ${e}`);
        }
        this.SaveInstance();
    }
    GetProducts = () => this.#products;
    SaveInstance() {
        window.localStorage.clear();
        this.#products.forEach((p, i) => {
            window.localStorage.setItem(i, JSON.stringify(p.GetToJSON()));
        });
    }
    DownloadInstance() {
        Object.keys(localStorage).forEach(k => {
            const tempObj = JSON.parse(window.localStorage.getItem(k));
            this.#products[parseInt(k)] = new Product(tempObj.name, tempObj.price, tempObj.count);
        })
    }
}

const receipt = new Receipt();

function refreshTable() {
    while (document.getElementById("paragonTable").firstElementChild.nextElementSibling) {
        document.getElementById("paragonTable").removeChild(document.getElementById("paragonTable").firstElementChild.nextElementSibling);
    }
    let summaryPrice = 0;
    if (receipt.GetProducts().length > 0) {
        receipt.GetProducts().forEach((e, index) => {
            const tr = document.createElement("tr");
            const liID = document.createElement("td");
            liID.innerText = index;
            tr.appendChild(liID);
            const liName = document.createElement("td");
            liName.innerText = e.Name();
            tr.appendChild(liName);
            const liPrice = document.createElement("td");
            liPrice.innerText = e.Price();
            tr.appendChild(liPrice);
            const liCount = document.createElement("td");
            liCount.innerHTML = e.Count();
            tr.appendChild(liCount);
            const liSummary = document.createElement("td");
            liSummary.innerHTML = e.Count() * e.Price();
            summaryPrice += e.Count() * e.Price();
            tr.appendChild(liSummary);
            const liOperations = document.createElement("td");
            liOperations.innerHTML = `<button onClick="onEdit(${index})">Edit</button> <button onClick="onDelete(${index})">Delete</button> `;
            liOperations.innerHTML += `<button onClick="onChangeDiretion(${index},${index - 1})" ${index != 0 ? "" : "disabled"}>↑</button> `;
            liOperations.innerHTML += `<button onClick="onChangeDiretion(${index},${index + 1})" ${index != receipt.GetProducts().length - 1 ? "" : "disabled"}>↓</button>`;
            tr.appendChild(liOperations);
            document.getElementById("paragonTable").appendChild(tr);
        });
        const liSummaryPrice = document.createElement("tfoot");
        const empty = document.createElement("td");
        empty.colSpan = 3;
        liSummaryPrice.appendChild(empty);
        const SummaryMessage = document.createElement("td");
        SummaryMessage.innerHTML = "<b/>Suma Całkowita:<b/>";
        liSummaryPrice.appendChild(SummaryMessage);
        const SummaryPrice = document.createElement("td");
        SummaryPrice.innerHTML = `<b>${summaryPrice}</b>`;
        liSummaryPrice.appendChild(SummaryPrice);
        const emptyLast = document.createElement("td");
        liSummaryPrice.appendChild(emptyLast);
        document.getElementById("paragonTable").appendChild(liSummaryPrice);
    }
}

function onEdit(index) {
    document.getElementById("idEditProduct").value = index;
    document.getElementById("editBox").style.display = "block";
}

function onDelete(index) {
    receipt.DeleteProduct(index);
    refreshTable();
}

function onChangeDiretion(idFrom, idTo) {
    receipt.ChangeNumbering(idFrom, idTo);
    refreshTable();
}

document.getElementById("submitAddProduct").addEventListener("click", () => {
    receipt.AddProduct(new Product(
        document.getElementById("nameAddProduct").value,
        parseInt(document.getElementById("priceAddProduct").value),
        parseInt(document.getElementById("countAddProduct").value)
    ));
    refreshTable();
});

document.getElementById("submitEditProduct").addEventListener("click", () => {
    receipt.EditProduct(parseInt(document.getElementById("idEditProduct").value),
        new Product(document.getElementById("nameEditProduct").value,
            parseInt(document.getElementById("priceEditProduct").value),
            parseInt(document.getElementById("countEditProduct").value)
        ));
    document.getElementById("editBox").style.display = "none";
    refreshTable();
});

document.getElementById("cancelEditProduct").addEventListener("click", () => {
    document.getElementById("editBox").style.display = "none";
});

refreshTable();