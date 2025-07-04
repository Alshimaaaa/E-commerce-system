import java.util.ArrayList;
import java.util.List;
public class CheckoutService{
    public static void checkout(Customer customer, Cart cart){
        if(cart.isEmpty()){
            System.out.println("Your cart is empty.");
            return;
        }
        Double balance = customer.getBalance();
        Double subtotal=0.0;
        List<Shippable>shippingList = new ArrayList<>();
        for(CartItem item : cart.getItems()){
            Product product = item.product;
            int quantity = item.quantity;
            //one product is out of stock or expired
            if(product.getUnexpiredStock()<quantity){
                System.out.println("Sorry not enough stock for product: "+ product.getName());
                return;
            }

            if(product.isShippable()){
                for(int i=0; i<quantity;i++){
                    shippingList.add((Shippable) product);
                }
            }
            subtotal+= product.getPrice()*quantity;
            product.reduceQuantity(quantity);
        }
        //Assume shipping cost based on weight summation in kg * 10
        double shippingCost = 0;
        for (Shippable item : shippingList) {
            shippingCost += item.getWeight();
        }
        shippingCost = Math.ceil(shippingCost) * 10;
        double totalAmount = subtotal+shippingCost;
        if(totalAmount>customer.getBalance()){
            System.out.println("Sorry no enough balance in your account.");
            return;
        }
        customer.reduceBalance(totalAmount);
        ShippingService.ship(shippingList);
        System.out.println();
        System.out.println("** Checkout receipt **");
        for(CartItem item: cart.getItems()){
            System.out.println(item.quantity+ "x " + item.product.name + "        "+ (item.product.price* item.quantity));
        }
        System.out.println("---------------");
        System.out.println("Subtotal              "+ subtotal);
        System.out.println("Shipping              "+ shippingCost);
        System.out.println("Amount                "+ totalAmount);
        System.out.println("Your current balance  "+ customer.getBalance());
    }
}
