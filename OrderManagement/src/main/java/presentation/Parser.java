package presentation;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import dao.ClientDAO;
import dao.OrderDAO;
import dao.Order_itemDAO;
import dao.ProductDAO;
import model.Client;
import model.Order_item;
import model.Orders;
import model.Product;

public class Parser {
    private String command;
    private String[] command_tokens;
    private ClientDAO clientDAO;
    private OrderDAO orderDAO;
    private Order_itemDAO order_itemDAO;
    private ProductDAO productDAO;





    public Parser(String command) {
        this.command = command;
        command_tokens = command.split(" ");

        clientDAO=new ClientDAO();
        orderDAO=new OrderDAO();
        order_itemDAO=new Order_itemDAO();
        productDAO=new ProductDAO();
    }

    public void check_comand (){
        if(command_tokens[0].equals("Insert")){
            call_insert();
        }
        else if(command_tokens[0].equals("Order:")){
            call_order();
        }
        else if(command_tokens[0].equals("Delete")){
            call_delete();
        }
        else if(command_tokens[0].equals("Report")){
            call_report();
        }

    }

    private void call_insert(){


        if(command_tokens[1].equals("client:")){
             Client newClient =new Client(command_tokens[2]+" "+command_tokens[3].substring(0,command_tokens[3].length()-1),command_tokens[4]);


             clientDAO.insert(newClient);

        }
        else if(command_tokens[1].equals("product:")){

            Product newProduct =new Product(command_tokens[2].substring(0,command_tokens[2].length()-1),Float.parseFloat(command_tokens[4]),Integer.parseInt(command_tokens[3].substring(0,command_tokens[3].length()-1)));

            String product_name=command_tokens[2].substring(0,command_tokens[2].length()-1);
            Product existingProduct= productDAO.findByName(product_name);
            if(existingProduct==null){
                productDAO.insert(newProduct);
            }
            else{
                int newQuantity=existingProduct.getAvailable_quantity()+Integer.parseInt(command_tokens[3].substring(0,command_tokens[3].length()-1));
                productDAO.update_quantity(newQuantity,product_name);
            }

        }

    }
    //Order: Luca George, apple, 5
    private void call_order(){
        String client_name=command_tokens[1]+ " "+command_tokens[2].substring(0,command_tokens[2].length()-1);
        String product_name=command_tokens[3].substring(0,command_tokens[3].length()-1);
        int wanted=Integer.parseInt(command_tokens[4]);
        Product wantedProduct= new Product();
        wantedProduct=productDAO.findByName(product_name);
        int available =wantedProduct.getAvailable_quantity();

        System.out.println(available+" "+wanted);
        if(available<wanted){
            System.out.println("Not enough stock");
            PdfGenerator gen=new PdfGenerator(product_name);
            gen.generateErrorRaport();
        }
        else{
            int quantity_left=available-wanted;
            productDAO.update_quantity(quantity_left,product_name);
            float total_price=wantedProduct.getPrice_per_unit()*wanted;
            Orders newOrder=new Orders(client_name,total_price);
            Orders existingOrder= orderDAO.findByName(client_name);
            if(existingOrder==null){
                orderDAO.insert(newOrder);
            }
            else{
                float newTotal=existingOrder.getTotal_price()+total_price;
                orderDAO.update_price(newTotal,client_name);
            }
            Order_item newOrder_item=new Order_item(product_name,client_name,wanted,total_price);
            order_itemDAO.insert(newOrder_item);

        }
    }


    private void call_delete(){
        if(command_tokens[1].equals("Product:")){
            String product=command_tokens[2];
            order_itemDAO.deleteByProductName(product);
            productDAO.deleteByProductName(product);

        }
        //Delete client: Ion Popescu, Bucuresti
        else if(command_tokens[1].equals("client:")){
            String client_name=command_tokens[2]+ " "+command_tokens[3].substring(0,command_tokens[3].length()-1);
            System.out.println(client_name);
            order_itemDAO.deleteByClientName(client_name);
            clientDAO.deleteByClientName(client_name);

        }
    }


    public void call_report(){
        String category=command_tokens[1];
        PdfGenerator gen=new PdfGenerator(category);
        gen.generateNormalRaport();
    }

    public void setCommand(String command) {
        this.command = command;
        command_tokens = command.split(" ");
    }
}
