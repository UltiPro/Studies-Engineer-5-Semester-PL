public class FactoryBill implements AbstractFactoryReceipt {
    @Override
    public Bill CreateFactory(){
        return new Bill();
    }
}