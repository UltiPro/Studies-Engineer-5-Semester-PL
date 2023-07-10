namespace Observer.Domain.Store.Abstract
{
    internal interface IProduct
    {
        string Name { get; }
        IPrice OrginalPrice { get; }
        IPrice LocalPrice { get; }
        void RecalculateFromOrginalToLocal(decimal newRateOfOrginalPrice);
    }
}