package model;
public class Client {
    private String client_name;
    private String address;

    public Client() {
    }

    public Client(String client_name, String address) {
        this.client_name = client_name;
        this.address = address;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "client_name='" + client_name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
