package Presentation.Waiter;

import Business.*;
import Data.FileWriterClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model_Waiter implements IRestaurantProcessingWaiter
{
    Restaurant restaurant;
    public ArrayList<MenuItem> orderItems =new ArrayList();
    public Model_Waiter(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    boolean okBill;

    @Override
    public void createOrder() {

        ArrayList<MenuItem> newList =new ArrayList();

        //copiez in comanda obiectele componente din meniu
        for(MenuItem x:orderItems){
            int i=0;
            for(MenuItem a:restaurant.menu){
                if(a.name.equals(x.name)) {
                    newList.add(restaurant.menu.get(i));
                }
            i++;
            }
        }
        Random rn = new Random();
        Order someOrder =new Order(rn.nextInt((100 - 1) + 1) + 1, rn.nextInt((100 - 1) + 1) + 1);
        restaurant.createOrder(someOrder,newList);
        orderItems.clear();

        if(okBill){
            FileWriterClass myFileWriter= new FileWriterClass("\n\n                           BILL no" + someOrder.hashCode()+
                    " \n\n\n Ordered items:"+ newList.toString());
        }


    }


}