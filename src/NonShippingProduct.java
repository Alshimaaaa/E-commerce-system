public class NonShippingProduct extends Product {
    public NonShippingProduct(String name, double price, int quantity, int expiredUnits) {
        super(name, price, quantity, expiredUnits);
    }

    public boolean isShippable() { return false; }
}
