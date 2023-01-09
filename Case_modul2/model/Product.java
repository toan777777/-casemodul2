package Case_modul2.model;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;
    private int quantity;
    private double price;
    private Category category;

    public Product() {
    }

    public Product(int id, String name, int quantity, double price, Category category) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
    }

    public Product(int id, String name, int quantity, double price) {
        this.id =id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public Product(Product product) {
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product setQuantity(int quantity) {
        this.quantity = quantity;
        return null;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +"||"+
                  category +
                '}';

    }
}
