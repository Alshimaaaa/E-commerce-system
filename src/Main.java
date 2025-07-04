public class Main {
    public static void main(String[] args) {

        Product cheese = new ShippingProduct("Cheese", 100, 5, 0.2, 2);
        Product biscuits = new ShippingProduct("Biscuits", 150, 2, 0.7, 1);
        Product tv = new ShippingProduct("TV", 1000, 3, 5.0, 0);
        Product scratchCard = new NonShippingProduct("Scratch card", 50, 10, 0);

        Customer customer = new Customer("Ahmed", 600);
        customer.getCart().add(cheese,3);
        customer.getCart().add(biscuits,1);
        customer.getCart().add(scratchCard,1);
        CheckoutService.checkout(customer, customer.getCart());

    }
}