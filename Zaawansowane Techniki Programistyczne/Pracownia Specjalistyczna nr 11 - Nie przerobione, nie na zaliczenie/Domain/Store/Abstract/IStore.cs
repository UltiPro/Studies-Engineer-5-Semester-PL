using System.Collections.Generic;
using Observer.Domain.Bank.Abstract;
using Observer.Domain.Currency;

namespace Observer.Domain.Store.Abstract
{
    internal interface IStore
    {
        IReadOnlyCollection<CurrencyType> RegistredCurrencyTypes { get; }
        
        void Update(BankBase bank);

        void DisplayProducts();


    }
}
