public class FactoryInvoiceForFirm implements AbstractFactoryReceipt {
    @Override
    public InvoiceForFirm CreateFactory(){
        return new InvoiceForFirm();
    }
}
