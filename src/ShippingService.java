import java.util.*;

public class ShippingService {
    public static void ship(List<Shippable> products) {
        if(products.isEmpty()){
            System.out.println("No shipping fees");
            return;
        }
        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        Map<String, Integer> countProducts = new HashMap<>();
        for(Shippable product: products){
            String name = product.getName();
            if(countProducts.containsKey(name)){
                countProducts.put(name, countProducts.get(name)+1);
            }
            else{
                countProducts.put(name,1);
            }
            totalWeight+=product.getWeight();
        }
        for (Map.Entry<String, Integer> entry : countProducts.entrySet()) {
            String name = entry.getKey();
            Integer count = entry.getValue();
            Double weight = products.stream()
                    .filter(p -> p.getName().equals(name)).findFirst().get().getWeight();
            System.out.println(count+ "x "+ name+ "        "+ weight*1000*count + "g");

        }

        System.out.println("Total package weight " + totalWeight + "kg");
    }
}

