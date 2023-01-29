using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using Observer.Domain.Bank.Abstract;
using Observer.Domain.Currency;
using Observer.Domain.Store.Abstract;

namespace Observer.Domain.Store
{
    internal class Store : IStore
    {

        private readonly IReadOnlyCollection<IProduct> _products;

        private readonly CurrencyType _localCurrency;

        public IReadOnlyCollection<CurrencyType> RegistredCurrencyTypes
        {
            get
            {
                return _products.Select(x => x.OrginalPrice.Currency)
                    .Distinct()
                    .ToList()
                    .AsReadOnly();
            }
        }


        public Store(IReadOnlyCollection<IProduct> products,
            CurrencyType localCurrencyType)
        {
            _products = products ?? throw new ArgumentNullException(nameof(products));

            _localCurrency = localCurrencyType;
        }


        public void Update(BankBase bank)
        {
            foreach (var product in this._products)
            {
                decimal  newCurrencyRate =  bank.GetCurrency(product.OrginalPrice.Currency);

                product.RecalculateFromOrginalToLocal(newCurrencyRate);
            }
        }

        public void DisplayProducts()
        {
            foreach (var product in this._products)
            {
                Console.WriteLine($"{product.Name}: {product.LocalPrice.Value} {product.LocalPrice.Currency}");
            }
        }
    }
}
