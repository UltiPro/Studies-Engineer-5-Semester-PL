using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Observer.Domain.Bank;
using Observer.Domain.Bank.Abstract;
using Observer.Domain.Currency;
using Observer.Domain.Store;
using Observer.Domain.Store.Abstract;

namespace Observer
{
    class Program
    {
        static void Main(string[] args)
        {
            IDictionary<CurrencyType, decimal > currentCurrencies = new Dictionary<CurrencyType, decimal>();

            
            currentCurrencies.Add(CurrencyType.DOLLAR, 3.5m);
            currentCurrencies.Add(CurrencyType.EURO, 4.2m);

            BankBase nbpBank = new Bank(currentCurrencies);

            IStore auchan = new Store(new List<IProduct>()
            {
                new Product(new Price(50m, CurrencyType.DOLLAR),  "Razor Mouse",  3.5m, CurrencyType.DOLLAR),
                new Product(new Price(500m, CurrencyType.DOLLAR), "Nvidia 1080 TI",  3.5m, CurrencyType.DOLLAR),
                new Product(new Price(100m, CurrencyType.EURO), "Microsoft scuplet ergonomic",  4.2m, CurrencyType.EURO),

            }, CurrencyType.PLN);

            nbpBank.Attach(auchan);

            auchan.Update(nbpBank);

            //initial
            Console.WriteLine("__INITIAL__ ");
            auchan.DisplayProducts();


            // pierwsza zmiana
            Console.WriteLine("__PIERWSZA ZMIANA____ ");

            nbpBank.TryChangeRate(CurrencyType.EURO);

           auchan.DisplayProducts();


            // druga zmiana
            Console.WriteLine("___DRGUA ZMIANA____ ");

            nbpBank.TryChangeRate(CurrencyType.EURO);

            auchan.DisplayProducts();

            Console.ReadLine();

        }
    }
}
