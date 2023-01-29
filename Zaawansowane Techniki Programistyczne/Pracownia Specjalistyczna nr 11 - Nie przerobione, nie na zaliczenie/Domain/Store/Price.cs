using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Observer.Domain.Currency;
using Observer.Domain.Store.Abstract;

namespace Observer.Domain.Store
{
    public class Price : IPrice
    {
        private readonly decimal _value;
        private readonly CurrencyType _currency;

        internal Price(decimal value, CurrencyType currency)
        {
            _currency = currency;
            _value = value;
        }

        public decimal Value => this._value;
        public CurrencyType Currency => this._currency;

        public void RecalculateLocalPrice(decimal newLocalCurrencyRatio)
        {
            if (newLocalCurrencyRatio <= 0) throw new ArgumentOutOfRangeException(nameof(newLocalCurrencyRatio));

        }
    }
}
