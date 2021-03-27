package dao;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import connection.ConnectionFactory;
import model.Product;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;

public class ProductDAO extends AbstractDAO<Product> {



public void update_quantity(int n, String name){

    Connection connection = null;
    PreparedStatement statement = null;
    String query= "update product set available_quantity=? where product_name=?;";
    try {
        connection = ConnectionFactory.getConnection();
        statement = connection.prepareStatement(query);
        statement.setInt(1, n);
        statement.setString(2, name);
        statement.executeUpdate();

    } catch (SQLException e) {
        LOGGER.log(Level.WARNING,  " ProductDAO:update " + e.getMessage());
    } finally {
        ConnectionFactory.close(statement);
        //ConnectionFactory.close(connection);
    }
}

}