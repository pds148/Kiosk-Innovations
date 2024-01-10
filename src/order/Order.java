package order;

import product.Product;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

public class Order {

    int orderNumber;
    String message;
    List<Product> items;
    public Double totalPrice;
    public Boolean complete;
    LocalDateTime orderDate;
    public LocalDateTime completeDate;
    int quantity;

    public Order(int orderNumber, String message, List<Product> items, int quantity) {
        this.orderNumber = orderNumber;
        this.message = message;
        this.items = items;
        this.quantity = quantity;
        this.totalPrice = this.calculateTotalPrice();
        this.orderDate = LocalDateTime.now();
    }

    public int getOrderNumber() {
        return this.orderNumber;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
        this.completeDate = LocalDateTime.now();
    }

    private Double calculateTotalPrice() {
        double total = 0.0;

        Product item;
        for(Iterator var3 = this.items.iterator(); var3.hasNext(); total += item.calculatePrice(this.quantity)) {
            item = (Product)var3.next();
        }

        return total;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void display() {
        System.out.println("\t주문번호 : " + this.orderNumber);
        System.out.println("\t요구사항 : " + this.message);
        System.out.println("\t주문시각 : " + this.orderDate);
        System.out.println("\t주문 상품 목록 : ");
        Iterator var1 = this.items.iterator();

        while(var1.hasNext()) {
            Product item = (Product)var1.next();
            System.out.println("\t\t" + item.name + "   | " + item.price + " | " + item.description);
        }

        System.out.println("\t총 가격 : " + this.totalPrice);
    }
}