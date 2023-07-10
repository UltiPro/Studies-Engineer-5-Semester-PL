using System;
using Observer.Domain.Currency;
using Observer.Domain.Store.Abstract;

namespace Observer.Domain.Bank.Abstract
{
    internal abstract class BankBase
    {
        internal abstract void Attach(IStore store);
        internal abstract void Detach(IStore store);
        internal abstract decimal GetCurrency(CurrencyType currencyType);
        protected abstract void Notify();
        internal abstract void TryChangeRate(CurrencyType type);
    }
}