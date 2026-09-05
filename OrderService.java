import java.util.HashMap;

public class OrderService {
    public void placeOrder(Order o) throws InsufficientStockException{
        if(o==null){
            throw new IllegalArgumentException("Order cannot be null.");
        }
        HashMap<Product, Integer> q = o.getQuantities();
        if(q.isEmpty()){
            throw new IllegalStateException("Cannot place an empty order.");
        }
        for(Product p : q.keySet()){
            int amount = q.get(p);
            if(amount > p.getStock()){
                throw new InsufficientStockException("Available stock: " + p.getStock()+". Please select a different quantity.");
            }
        }
        for(Product p : q.keySet()){
            int amount = q.get(p);
            p.reduceStock(amount);
        }
    }
}
