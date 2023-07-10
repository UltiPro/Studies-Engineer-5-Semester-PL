using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace Observer.Domain.Currency
{
    internal class Currency : ICurrency
    {
        private readonly CurrencyType _type;
        internal CurrencyType Type => this._type;
        internal Currency(CurrencyType type)
        {
            _type = type;
        }
    }
}