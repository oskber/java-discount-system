public class Product {
    private final String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String name() {
        return name;
    }

    public double price() {
        return price;
    }

    public int quantity() {
        return quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Product[name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
    }
}