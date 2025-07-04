public class ShippingProduct extends Product implements Shippable {
    private double weight; // in kg

    public ShippingProduct(String name, double price, int quantity, double weight, int expiredUnits) {
        super(name, price, quantity, expiredUnits);
        this.weight = weight;
    }

    public boolean isShippable() { return true; }

    public double getWeight() { return weight; }
    public String getName() { return name; }
}
