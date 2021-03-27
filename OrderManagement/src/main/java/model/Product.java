package model;
public class Product {
    private String product_name;
    private float price_per_unit;
    private int available_quantity;


    public Product() {
    }

    public Product(String product_name, float price_per_unit, int available_quantity) {
        this.product_name = product_name;
        this.price_per_unit = price_per_unit;
        this.available_quantity = available_quantity;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public float getPrice_per_unit() {
        return price_per_unit;
    }

    public void setPrice_per_unit(float price_per_unit) {
        this.price_per_unit = price_per_unit;
    }

    public int getAvailable_quantity() {
        return available_quantity;
    }

    public void setAvailable_quantity(int available_quantity) {
        this.available_quantity = available_quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_name='" + product_name + '\'' +
                ", price_per_unit=" + price_per_unit +
                ", available_quantity=" + available_quantity +
                '}';
    }
}