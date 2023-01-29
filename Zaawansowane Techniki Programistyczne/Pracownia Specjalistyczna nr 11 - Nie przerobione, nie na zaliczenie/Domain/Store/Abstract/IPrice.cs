using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Observer.Domain.Currency;

namespace Observer.Domain.Store.Abstract
{
    internal interface IPrice
    {
        decimal Value { get; }

        CurrencyType Currency { get; }

        void RecalculateLocalPrice(decimal newLocalCurrencyRatio);
    }
}
