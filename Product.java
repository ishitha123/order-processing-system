import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private final int id;
    private static int nextId = 1;
    private final BigDecimal price;
    private int stock;
    private final String name;

    public Product(String name, BigDecimal price, int stock){
        if(name==null || name.isBlank()){
            throw new IllegalArgumentException("Product name cannot be null or blank.");
        }
        if(price==null){
            throw new IllegalArgumentException("Price cannot be null.");
        }
        if(price.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Price cannot be less than or equal to 0.");
        }
        if(stock < 0){
            throw new IllegalArgumentException("Stock cannot be less than 0.");
        }
        id = nextId++;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    public void reduceStock(int amount) throws InsufficientStockException{
        if(amount <= 0){
            throw new IllegalArgumentException("Amount must be greater than 0.");
        }
        if(amount > stock){
            throw new InsufficientStockException("Insufficient stock. Available stock: " + stock);
        }
        stock -= amount;
    }
    public void increaseStock(int amount){
        if(amount <= 0){
            throw new IllegalArgumentException("Amount must be greater than 0.");
        }
        stock += amount;
    }
    public String getName(){
        return name;
    }
    public BigDecimal getPrice(){
        return price;
    }
    public int getStock(){
        return stock;
    }
    public int getId(){
        return id;
    }
    @Override
    public boolean equals(Object o){
        if(this==o){
            return true;
        }
        if(!(o instanceof Product)){
            return false;
        }
        Product p = (Product)o;
        return this.id == p.id;
    }
    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
