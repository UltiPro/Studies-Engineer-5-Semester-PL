using System;
using Observer.Domain.Currency;
using Observer.Domain.Store.Abstract;

namespace Observer.Domain.Store
{
    internal class Product : IProduct
    {
        private readonly IPrice _orginalPrice;
        private IPrice _localPrice;
        private string _name;

        public Product(IPrice price, string name, decimal currentOrginalCurrencyRate, CurrencyType localCurrencyType)
        {
            this._orginalPrice = price;
            this._localPrice = new Price(_orginalPrice.Value * currentOrginalCurrencyRate, localCurrencyType);

            _name = name;
        }

        public string Name { get; }
        public IPrice OrginalPrice => new Price(this._orginalPrice.Value, this._orginalPrice.Currency);
        public IPrice LocalPrice => new Price(this._localPrice.Value, this._localPrice.Currency);

        public void RecalculateFromOrginalToLocal(decimal newRateOfOrginalPrice)
        {
            this._localPrice = new Price(_orginalPrice.Value * newRateOfOrginalPrice, _localPrice.Currency);
        }
    }
}