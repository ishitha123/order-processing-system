import java.math.BigDecimal;

public class Main {
    public static void main(String[] args){
        // Testing the Product class

        //Happy Path
        //Product p = new Product("Brush", new BigDecimal("15"), 30);

        // Sad Path
        //Product p1 = new Product(null, new BigDecimal("15"), 30);
        //Product p = new Product("Brush", new BigDecimal("-1"), 30);

        // Testing reduceStock()
        //Product p = new Product("Brush", new BigDecimal("20"), 30);
        //p.reduceStock(10); // 20 left
        //System.out.println(p.getStock());
        //p.reduceStock(20); // 0 left
        //System.out.println(p.getStock());
        
        // System.out.println(p.getId());
        // System.out.println(p.getName());
        // System.out.println(p.getPrice());

        // Testing Order
        /* 
        Order o = new Order();
        Product p1 = new Product("Brush", new BigDecimal("10"), 10);
        Product p2 = new Product("dress", new BigDecimal("20"), 20);
        Product p3 = new Product("shoes", new BigDecimal("25"), 25);
        
        try {
        o.addToOrder(p1);
        o.addToOrder(p2);
        } catch (ProductAlreadyAddedException e) {
            System.out.println(e.getMessage());
        }

        try {
            o.addToOrder(p1); // should throw
        } catch (ProductAlreadyAddedException e) {
            System.out.println(e.getMessage());
        }

        try {
            o.addToOrder(p2); // should also throw
        } catch (ProductAlreadyAddedException e) {
            System.out.println(e.getMessage());
        }
        try{
            o.editQuantity(p1, 3);
            o.editQuantity(p2, 21);
            o.editQuantity(p2, -1);
            //o.editQuantity(p3, 4);
        }catch(ProductNotFoundException e){
            System.out.println(e.getMessage());
        }catch(IllegalQuantityException e){
            System.out.println(e.getMessage());
        }
        //o.displayQuantities();
        try{
            //o.removeFromOrder(p3);
            o.removeFromOrder(p2);
        }catch(ProductNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            o.editQuantity(p3, 4);
        } catch (ProductNotFoundException | IllegalQuantityException e) {
            System.out.println(e.getMessage());
        }
        o.displayQuantities();
        */

        //Testing Product
        // Need to test reduceStock() and increaseStock()

        //reduceStock() happy path
        /* 
        Product p = new Product("Computer", new BigDecimal("2000"), 15);
        try{
            p.reduceStock(4);
        }catch(InsufficientStockException e){
            System.out.println(e.getMessage());
        }
        System.out.println(p.getStock()); // 11 is expected
        */

        //reduceStock() sad path
        /* 
        Product p = new Product("Computer", new BigDecimal("2000"), 15);
        try{
            //p.reduceStock(15);
            //p.reduceStock(1);
            p.reduceStock(16);
        }catch(InsufficientStockException e){
            System.out.println(e.getMessage());
        }
        */
       // increaseStock happy path
       /* 
       Product p = new Product("Computer", new BigDecimal("2000"), 15);
       p.increaseStock(1);
       System.out.println(p.getStock()); // should display 16
       */

       // Entering 0 for reduceStock() and increaseStock()
       Product p = new Product("Computer", new BigDecimal("2000"), 15);
       
       try{
            p.reduceStock(0);
       }catch(InsufficientStockException | IllegalArgumentException e){
        System.out.println(e.getMessage());
       }
       
       //p.increaseStock(0); // should throw an error
    }
}
