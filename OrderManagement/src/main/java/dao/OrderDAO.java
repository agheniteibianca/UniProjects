package dao;

import connection.ConnectionFactory;
import model.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;

public class OrderDAO extends AbstractDAO<Orders> {
    public void update_price(float n, String name){
        Connection connection = null;
        PreparedStatement statement = null;
        String query= "update orders set total_price=? where client_name=?;";
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setFloat(1, n);
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
