using System;
using System.Collections.Concurrent;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using Observer.Domain.Bank.Abstract;
using Observer.Domain.Currency;
using Observer.Domain.Store.Abstract;

namespace Observer.Domain.Bank
{
    internal class Bank : BankBase
    {
        private readonly IList<IStore> _stores;
        private IDictionary<CurrencyType, decimal> _currencies;

        public Bank(IDictionary<CurrencyType, decimal> currencies)
        {
            _currencies = currencies ?? throw new ArgumentNullException(nameof(currencies));
            this._stores = new List<IStore>();
        }

        internal override void Attach(IStore store)
        {
            if (store == null) throw new ArgumentNullException(nameof(store));
            _stores.Add(store);
        }

        internal override void Detach(IStore store)
        {
            if (store == null) throw new ArgumentNullException(nameof(store));
            _stores.Remove(store);
        }

        internal override decimal GetCurrency(CurrencyType currencyType)
        {
            decimal currentRate = this._currencies[currencyType];

            if (currentRate > 0)
                return currentRate;

            throw new Exception("Given currency type is not being served by this bank");
        }

        protected override void Notify()
        {
            foreach (IStore store in this._stores)
                store.Update(this);
        }

        // metoda tylko do zmiany wartosci obecnych kursow
        // trudno powiedziec jak faktycznie banki wyliczaja te kursy
        // ale w tym programie raczej nie chodzi o to aby to jakos dokladnie wyliczac

        internal override void TryChangeRate(CurrencyType type)
        {
            foreach (var currency in this._currencies.ToList())
            {
                _currencies[currency.Key] = currency.Value * 1.0221223112m;
            }
            this.Notify();
        }
    }
}