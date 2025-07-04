public abstract class Product {
    protected String name;
    protected double price;
    protected int quantity;
    protected int expiredUnits;

    public Product(String name, double price, int quantity, int expiredUnits) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expiredUnits = expiredUnits;
    }
    public int getUnexpiredStock() {
        return quantity - expiredUnits;
    }
    public abstract boolean isShippable();

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void reduceQuantity(int amount){
        quantity-=amount;
    }
}
