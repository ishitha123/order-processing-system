import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.math.BigDecimal;

public class ProductTest {
    @Test
    public void increaseStockTest(){
        Product p = new Product("Shoes", new BigDecimal("35"), 15);
        p.increaseStock(1);
        assertEquals(16, p.getStock());
    } 

    // Happy path: exception would be unexpected
    @Test
    public void reduceStockTest() throws InsufficientStockException{
        //Arrange
        Product p = new Product("Dress", new BigDecimal("50"), 15);

        //Act
        p.reduceStock(4);

        //Assert
        assertEquals(11, p.getStock());
    }

    // Failure path: exception is the behavior we're verifying
    @Test
    public void InsufficientStockExceptionTest(){
        //Arrange
        Product p = new Product("Phone", new BigDecimal("1000"), 15);
        
        //Assert
        assertThrows(InsufficientStockException.class, () -> {
            p.reduceStock(20);
        });
        assertEquals(15, p.getStock());
    }
}
