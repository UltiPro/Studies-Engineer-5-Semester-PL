const cenaEnergii = 2.5;

class Produkt {
    constructor(id, nazwa, model, rokProdukcji, cena, zuzycieEnergii) {
        for (const [key, value] of Object.entries({ id, nazwa, model, cena, zuzycieEnergii })) this[key] = value;
        this.rokProdukcji = new Date(rokProdukcji);
    }
    koszt = () => this.cena;
    kosztEnergii = () => this.zuzycieEnergii * cenaEnergii;
    wiekProduktu = () => this.rokProdukcji;
    wiekProduktuLata = () => new Intl.RelativeTimeFormat('pl').format(new Date().getFullYear() - this.wiekProduktu().getFullYear(), "year").slice(3);
    toString = () => `Produkt o id: ${this.id}, Nazwa: ${this.nazwa}, Model: ${this.model}, Cena: ${this.cena}, Zużycie energii: ${this.zuzycieEnergii}.`;
}

class ListaProdukty {
    #listaProduktow = {};
    wypiszProdukt = (idProduktu) => this.#listaProduktow[idProduktu].toString();
    wypiszWszystkieProdukty() {
        let wyjscieString = "";
        for (const produktId in this.#listaProduktow) wyjscieString += this.wypiszProdukt(produktId) + "\n";
        return wyjscieString;
    };
    dodajProdukt(produkt) {
        if (produkt.id in this.#listaProduktow) throw new Error(`Produkt o ${produkt.id} jest już na liście!`);
        this.#listaProduktow[produkt.id] = produkt;
    }
    zmienProdukt(idProduktu, product) {
        if (!(idProduktu in this.#listaProduktow)) throw new Error(`Produkt ${idProduktu} nie znajduje się na liście!`);
        for (const [key, value] of Object.entries(product)) if (!(value instanceof Function)) this.#listaProduktow[idProduktu][key] = value;
        this.#listaProduktow[idProduktu]["id"] = idProduktu;
    }
    pobierzProdukt(idProduktuOrNazwa) {
        if (!isNaN(idProduktuOrNazwa)) {
            if (!(idProduktuOrNazwa in this.#listaProduktow)) throw new Error(`Produkt o id ${idProduktuOrNazwa} nie znajduje się na liście!`);
            return this.#listaProduktow[idProduktuOrNazwa];
        }
        else {
            for (const idProduktu in this.#listaProduktow) if (this.#listaProduktow[idProduktu].nazwa === idProduktuOrNazwa) return this.#listaProduktow[idProduktu];
            throw new Error(`Product o nazwie ${idProduktuOrNazwa} nie znajduje się na liście!`);
        }
    }
    pobierzWielkosc() {
        let ilosc = 0;
        for (const productId in this.#listaProduktow) ilosc++;
        return ilosc;
    }
}

class Magazyn extends ListaProdukty {
    #magazynIlosc = {};
    dodajProdukt(produkt, ilosc = 1) {
        try {
            super.dodajProdukt(produkt);
        } catch (e) { console.error(e); }
        this.#magazynIlosc[produkt.id] ??= 0;
        this.#magazynIlosc[produkt.id] += ilosc;
    }
    wezProdukt(idProduktuOrNazwa, ilosc = 1) {
        const produkt = this.pobierzProdukt(idProduktuOrNazwa);
        if (this.#magazynIlosc[produkt.id] < ilosc) throw new Error(`Produkt o id ${produkt.id} ma braki magazynowe!`);
        this.#magazynIlosc[produkt.id] -= ilosc;
        return { ...produkt };
    }
    pobierzIlosc(idProduktuOrNazwa) {
        const produkt = this.wezProdukt(idProduktuOrNazwa);
        return this.#magazynIlosc[produkt.id];
    }
}

class Sklep extends Magazyn {
    #zamowieniaList = {};
    #idOfZamowienie = 0;
    dodajProdukt(...parametry) {
        switch (parametry.length) {
            case 1:
                super.dodajProdukt(parametry[0]);
                break;
            case 2:
                super.dodajProdukt(parametry[0], parametry[1]);
                break;
            case 4:
                super.dodajProdukt(new Produkt(this.pobierzWielkosc() + 1, parametry[0], parametry[1], Date.now(), parametry[2], parametry[3]));
                break;
            case 5:
                super.dodajProdukt(new Produkt(parametry[0], parametry[1], parametry[2], Date.now(), parametry[3], parametry[4]));
                break;
            default:
                throw new Error(`Nie ma takiej funkcji!`);
        }
    }
    zlozZamowienie(idProduktuOrNazwa, iloscProduktu = 1) {
        this.#zamowieniaList[this.#idOfZamowienie] = { produkt: this.wezProdukt(idProduktuOrNazwa, iloscProduktu), ilosc: iloscProduktu };
        this.#idOfZamowienie++;
    }
    pobierzZamowienia = () => this.#zamowieniaList;
}

// Przykładowe użycie

const produkt1 = new Produkt(1, "Chleb", "Zwykły", Date.now(), 2.5, 0);
const produkt2 = new Produkt(2, "Komputer", "Gamingowy", Date.now(), 2500, 0.450);
const produkt3 = new Produkt(3, "Laptop", "Gamingowy", Date.now(), 3500, 0.350);

console.log(produkt1.wiekProduktuLata());

const sklep = new Sklep();

sklep.dodajProdukt(produkt1, 4);

sklep.dodajProdukt(produkt2, 5);

sklep.dodajProdukt(produkt3, 7);

sklep.dodajProdukt("cos", "modelik", 52, 2);

sklep.dodajProdukt(5, "cos2", "modelik2", 53, 2);

sklep.zlozZamowienie(1, 2);

sklep.zlozZamowienie(2, 3);

sklep.zlozZamowienie(3, 7);

sklep.zlozZamowienie(4);

sklep.zlozZamowienie(5);

console.log(sklep.pobierzZamowienia());