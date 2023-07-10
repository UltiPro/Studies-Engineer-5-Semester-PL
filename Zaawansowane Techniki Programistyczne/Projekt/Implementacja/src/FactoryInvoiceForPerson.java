public class FactoryInvoiceForPerson implements AbstractFactoryReceipt {
    @Override
    public InvoiceForPerson CreateFactory() {
        return new InvoiceForPerson();
    }
}