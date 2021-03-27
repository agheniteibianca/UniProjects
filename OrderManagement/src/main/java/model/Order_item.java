package model;
public class Order_item {

    private String product_name;
    private String client_name;
    private int quantity_ordered;
    private float price;

    public Order_item() {
    }

    public Order_item(String product_name, String client_name, int quantity_ordered, float price) {
        this.product_name = product_name;
        this.client_name = client_name;
        this.quantity_ordered = quantity_ordered;
        this.price = price;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public int getQuantity_ordered() {
        return quantity_ordered;
    }

    public void setQuantity_ordered(int quantity_ordered) {
        this.quantity_ordered = quantity_ordered;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order_item{" +
                "product_name='" + product_name + '\'' +
                ", client_name='" + client_name + '\'' +
                ", quantity_ordered=" + quantity_ordered +
                ", price=" + price +
                '}';
    }
}