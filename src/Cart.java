import java.util.*;

public class Cart{
    private List<CartItem> items = new ArrayList<>();
    private Customer customer;

    public Cart(Customer customer) {
        this.customer= customer;
    }

    public void add(Product product, Integer quantity){
        CartItem item = new CartItem(product, quantity);
        items.add(item);
    }
    public Customer getOwner() {
        return customer;
    }
    public List<CartItem> getItems() { return items; }
    public boolean isEmpty() { return items.isEmpty(); }
}