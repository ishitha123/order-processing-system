# Order Processing System

## Project Overview
This application simulates an online ordering system. Users can add or remove products from an order, edit the quantity of each product in an order, and place an order. The `Product` class provides the methods that modify a product's stock. However, `OrderService` coordinates when stock gets reduced during order placement. The functionality for adding products to an order, removing products from an order, and editing the quantities of products in an order are all implemented in `Order`. 

## Business Rules
- Products must contain valid information (name can't be null or blank, price can't be null or less than or equal to 0, and stock can't be less than 0). 
- The same product cannot be added to an order more than once.
- The quantities of products in an order must be greater than 0.
- An empty or null order cannot be placed.
- An order cannot be placed if at least one product's requested quantity exceeds its available stock.

## Error Handling
This project uses exceptions to signal invalid operations and allow calling code to handle failures appropriately.

The custom exceptions that were created for this project are the following:

`IllegalQuantityException`: Triggered when the user enters a value less than or equal to 0 when editing the quantity of a product in an order.

`InsufficientStockException`: Triggered when the user tries to place an order, and the quantity of a product in an order exceeds its available stock.

`ProductAlreadyAddedException`: Triggered when a duplicate product is added to an order.

`ProductNotFoundException`: Triggered when the user tries to edit the quantity of or remove a product that was not added to the order.

## Transactional Order Processing
An order is not placed until it's verified that each product's requested quantity does not exceed its available stock. 

The program uses a 2-pass approach to execute this. When the method for placing an order is called, the program iterates through each product in the order and checks whether the requested quantity for that product exceeds its available stock. If at least one product's requested quantity exceeds its available stock, the program does not proceed with reducing the stock of each product in the order. If none of the products' requested quantities exceed their available stocks, then the program iterates through all the products again, this time, reducing their stocks by the requested quantities.

## Testing
JUnit was used for testing this project. `ProductTest`, `OrderTest`, and `OrderServiceTest` contain the JUnit tests.

`ProductTest` tests the functionalities for increasing and decreasing the stock of a product, as well as the `InsufficientStockException`. `OrderTest` covers the successful and failure scenarios for adding and removing a product from an order and editing a product's quantity. `OrderServiceTest` covers the successful and failure scenarios for placing an order, including the test that when one product has insufficient inventory, none of the products have their stock reduced.

## Technologies
This program was developed using Java 17, Maven, and JUnit.

## Running the Tests
Please use the command `mvn test` to run the JUnit tests for this project.
