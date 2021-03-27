package presentation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.stream.Stream;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import dao.ClientDAO;
import dao.OrderDAO;
import dao.Order_itemDAO;
import dao.ProductDAO;
import model.Client;
import model.Orders;
import model.Product;

public class PdfGenerator
{

    private String clasa;
    private static int nr_raport=0;
    private ClientDAO clientDAO;
    private OrderDAO orderDAO;
    private Order_itemDAO order_itemDAO;
    private ProductDAO productDAO;


    public PdfGenerator(String clasa){
        clientDAO=new ClientDAO();
        orderDAO=new OrderDAO();
        order_itemDAO=new Order_itemDAO();
        productDAO=new ProductDAO();
        nr_raport++;
        this.clasa=clasa;

    }

    public void generateNormalRaport(){
        insertTable();
    }
    public void generateErrorRaport(){
        String filename="error"+nr_raport+".pdf";
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filename));
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        Chunk chunk = new Chunk("Failed prcessing the order! Low on "+clasa+"s :(", font);

        try {
            document.add(chunk);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        document.close();
    }

    public void insertTable(){
        String filename="report"+nr_raport+".pdf";
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filename));
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        document.open();
        PdfPTable table = new PdfPTable(2);
        addTableHeader(table);
        addRows(table);

        try {
            document.add(table);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        document.close();

    }
    private void addTableHeader(PdfPTable table) {
        String head1=null,head2=null,head3=null;
        if(clasa.equals("product")){
            head1="product_name";
            head2="available_quantity";
        }
        else if(clasa.equals("client")){
            head1="name";
            head2="address";
        }
        else if(clasa.equals("order")){
            head1="client_name";
            head2="total_price";
        }

        Stream.of(head1, head2)
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });
    }

    private void addRows(PdfPTable table) {

        if(clasa.equals("product")){
            for (Product product : productDAO.selectQuery()) {
                table.addCell(product.getProduct_name());
                table.addCell(product.getAvailable_quantity()+"");
            }

        }
        else if(clasa.equals("client")){
            for (Client client : clientDAO.selectQuery()) {
                table.addCell(client.getClient_name());
                table.addCell(client.getAddress());
            }
        }
        else if(clasa.equals("order")){
            for (Orders order : orderDAO.selectQuery()) {
                table.addCell(order.getClient_name());
                table.addCell(order.getTotal_price()+"");
            }
        }

    }

}