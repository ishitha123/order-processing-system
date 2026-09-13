import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    @Test 
    public void placeValidOrderTest() throws ProductAlreadyAddedException, InsufficientStockException, ProductNotFoundException, IllegalQuantityException{
        Order o = new Order();
        Product p = new Product("Shoes", new BigDecimal("150"), 10);
        Product p1 = new Product("Shirt", new BigDecimal("20"), 18);
        o.addToOrder(p);
        o.addToOrder(p1);
        o.editQuantity(p1, 18);
        OrderService orderServ = new OrderService();
        orderServ.placeOrder(o);
        assertEquals(9, p.getStock());
        assertEquals(0, p1.getStock());
    }
    @Test 
    public void placeNullOrderTest(){
        Order o = null;
        OrderService orderServ = new OrderService();
        assertThrows(IllegalArgumentException.class, () -> {
            orderServ.placeOrder(o);
        });
    }
    @Test 
    public void placeEmptyOrderTest(){
        Order o = new Order();
        OrderService orderServ = new OrderService();
        assertThrows(IllegalStateException.class, () -> {
            orderServ.placeOrder(o);
        });
    }
    @Test 
    public void placeOrderDoesNotReduceAnyStockWhenOneProductIsInsufficient() throws ProductAlreadyAddedException, ProductNotFoundException, IllegalQuantityException{
        Order o = new Order();
        Product p = new Product("Shoes", new BigDecimal("150"), 10);
        Product p1 = new Product("Shirt", new BigDecimal("20"), 18);
        o.addToOrder(p1);
        o.addToOrder(p);
        o.editQuantity(p, 11);
        OrderService orderServ = new OrderService();
        assertThrows(InsufficientStockException.class, () -> {
            orderServ.placeOrder(o);
        });
        assertEquals(10, p.getStock());
        assertEquals(18, p1.getStock());
    }
}
