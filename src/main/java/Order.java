import java.util.HashMap;
import java.util.Objects;

public class Order {
    private final int id;
    private static int nextId = 1;
    private final HashMap<Product, Integer> quantities; //Product, quantity

    public Order(){
        quantities = new HashMap<>();
        id = nextId++;
    }

    public void addToOrder(Product p) throws ProductAlreadyAddedException{
        if(p==null){
            throw new IllegalArgumentException("Can't add a null product.");
        }
        if(quantities.containsKey(p)){
            throw new ProductAlreadyAddedException("The product " + p.getName() + " was already added to the order.");
        }
        //1 is the default quantity, but this can be edited using the editQuantity method.
        quantities.put(p, 1);
    }
    public void removeFromOrder(Product p) throws ProductNotFoundException{
        if(p==null){
            throw new IllegalArgumentException("Can't remove a null product.");
        }
        if(!quantities.containsKey(p)){
            throw new ProductNotFoundException("The product " + p.getName() + " was not found in order.");
        }
        quantities.remove(p);
    }
    public void editQuantity(Product p, int newAmount) throws ProductNotFoundException, IllegalQuantityException{
        if(p==null){
            throw new IllegalArgumentException("Can't edit a null product's quantity.");
        }
        if(!quantities.containsKey(p)){
            throw new ProductNotFoundException("Product " + p.getName() + " not found in order.");
        }
        if(newAmount <= 0){
            throw new IllegalQuantityException("Quantity must be greater than 0.");
        }
        quantities.put(p, newAmount);
    }
    public HashMap<Product, Integer> getQuantities(){
        return new HashMap<>(quantities);
    }
    public int getId(){
        return id;
    }

    public void displayQuantities(){
        for(Product p : quantities.keySet()){
            System.out.println("Product: " + p.getName());
            System.out.println("Quantity: " + quantities.get(p));
            System.out.println();
        }
    }

    @Override
    public boolean equals(Object o){
        if(this==o){
            return true;
        }
        if(!(o instanceof Order)){
            return false;
        }
        Order order = (Order)o;
        return this.id==order.id;
    }
    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
