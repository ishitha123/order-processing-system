import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.math.BigDecimal;

public class OrderTest {
    @Test 
    public void addValidProductTest() throws ProductAlreadyAddedException{
        Order o = new Order();
        Product p = new Product("Shoes", new BigDecimal("150"), 10);
        o.addToOrder(p);
        assertEquals(1, o.getQuantities().get(p));
    }
    @Test 
    public void addNullProductTest(){
        Order o = new Order();
        assertThrows(IllegalArgumentException.class, () -> {
            o.addToOrder(null);
        });
    }
    @Test 
    public void addSameProductTwiceTest() throws ProductAlreadyAddedException{
        Order o = new Order();
        Product p = new Product("dress", new BigDecimal("100"), 15);
        o.addToOrder(p);
        assertThrows(ProductAlreadyAddedException.class, () -> {
            o.addToOrder(p);
        });
    }
    @Test 
    public void removeValidProductTest() throws ProductNotFoundException, ProductAlreadyAddedException{
        Order o = new Order();
        Product p = new Product("brush", new BigDecimal("10"), 15);
        o.addToOrder(p);
        o.removeFromOrder(p);
        assertFalse(o.getQuantities().containsKey(p));
    }
    @Test 
    public void removeNullProductTest(){
        Order o = new Order();
        Product p = null;
        assertThrows(IllegalArgumentException.class, () -> {
            o.removeFromOrder(p);
        });
    }
    @Test 
    public void removeProductNotFoundTest(){
        Order o = new Order();
        Product p = new Product("brush", new BigDecimal("10"), 15);
        assertThrows(ProductNotFoundException.class, () -> {
            o.removeFromOrder(p);
        });
    }
    @Test
    public void editValidQuantityTest() throws ProductNotFoundException, ProductAlreadyAddedException, IllegalQuantityException{
        Order o = new Order();
        Product p = new Product("brush", new BigDecimal("10"), 15);
        o.addToOrder(p); // quantity is 1 here
        o.editQuantity(p, 18);
        assertEquals(18, o.getQuantities().get(p));
    }
    @Test 
    public void editQuantityNullProductTest(){
        Order o = new Order();
        Product p = null;
        assertThrows(IllegalArgumentException.class, () -> {
            o.editQuantity(p, 20);
        });
    }
    @Test 
    public void editQuantityProductNotFoundTest(){
        Order o = new Order();
        Product p = new Product("brush", new BigDecimal("10"), 15);
        assertThrows(ProductNotFoundException.class, () -> {
            o.editQuantity(p, 25);
        });
    }
    @Test 
    public void editZeroQuantityTest() throws ProductAlreadyAddedException{
        Order o = new Order();
        Product p = new Product("brush", new BigDecimal("10"), 15);
        o.addToOrder(p);
        assertThrows(IllegalQuantityException.class, () -> {
            o.editQuantity(p, 0);
        });
        assertEquals(1, o.getQuantities().get(p));
    }
    @Test 
    public void editNegativeQuantityTest() throws ProductAlreadyAddedException{
        Order o = new Order();
        Product p = new Product("brush", new BigDecimal("10"), 15);
        o.addToOrder(p);
        assertThrows(IllegalQuantityException.class, () -> {
            o.editQuantity(p, -1);
        });
        assertEquals(1, o.getQuantities().get(p));
    }
}
