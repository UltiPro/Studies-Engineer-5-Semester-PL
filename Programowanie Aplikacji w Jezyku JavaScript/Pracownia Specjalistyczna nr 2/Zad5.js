const Zad5 = (products) => {
    const priceTable = products.split(",").map(p => ({ name: p, price: (Math.random() * 10).toFixed(2) }));
    console.table(priceTable);

    const orderList = [];
    while (orderList.length < (priceTable.length / 2)) {
        const i = Math.random() * priceTable.length ^ 0;
        if (orderList.some(({ name }) => name == priceTable[i].name)) continue;
        const tempRand = Math.random() * 10 + 1 ^ 0;
        const { name, price } = orderList.push({
            ...priceTable[i], count: tempRand, fullPrice: (priceTable[i].price * tempRand).toFixed(2)
        })
    }

    console.table(orderList);
}