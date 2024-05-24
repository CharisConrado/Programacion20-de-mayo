
package parcial.ejercicios1.clases;

public class Sales {
    private String name;
    private int quantity;
    private double price; 

    public Sales(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Sales{" + "name=" + name + ", quantity=" + quantity + ", price=" + price + '}';
    }
}
