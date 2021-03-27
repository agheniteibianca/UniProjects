package model;
public class Orders {
    private String client_name;
    private float total_price;


    public Orders() {
    }

    public Orders(String client_name, float total_price) {
        this.client_name = client_name;
        this.total_price = total_price;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "client_name='" + client_name + '\'' +
                ", total_price=" + total_price +
                '}';
    }
}