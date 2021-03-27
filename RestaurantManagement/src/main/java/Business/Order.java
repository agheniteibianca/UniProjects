package Business;

import java.util.ArrayList;
import java.util.List;

public class Order {

    int orderId;
    int tableNo;

    public Order(int orderId, int tableNo) {
        System.out.println(orderId);
        System.out.println(tableNo);
        this.orderId = orderId;
        this.tableNo = tableNo;
    }

    @Override
    public int hashCode() {
        int result=(orderId+tableNo)%100;
        return result;
    }


}
