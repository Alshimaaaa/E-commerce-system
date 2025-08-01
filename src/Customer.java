public class Customer {
    private String name;
    private double balance;
    private Cart cart;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.cart = new Cart(this);
    }

    public String getName() {
        return name;
    }
    public double getBalance() { return balance; }
    public Cart getCart() { return cart; }
    public void reduceBalance(double amount) { balance -= amount; }
}
