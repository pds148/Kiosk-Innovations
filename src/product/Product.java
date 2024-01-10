package product;

import menu.Menu;

import java.util.List;

public class Product extends Menu {

    public Double price;

    public Product(String name, Double price, String description) {
        super(name, description);
        this.price = price;
    }

    public double calculatePrice(int quantity) {
        return this.price * (double) quantity;
    }

    public void addToCart(Product menuItem) {
        // Implement the logic to add the menu item to the cart
    }
}

