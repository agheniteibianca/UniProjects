
package start;

		import java.sql.Connection;
		import java.sql.PreparedStatement;
		import java.sql.ResultSet;
		import java.sql.SQLException;
		import java.util.logging.Level;
		import java.util.logging.Logger;

		import connection.ConnectionFactory;
		import dao.ClientDAO;
		import dao.ProductDAO;
		import model.Client;
		import model.Product;
		import presentation.FileReader;
		import presentation.Parser;
		import presentation.PdfGenerator;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 */
public class Start {
	protected static final Logger LOGGER = Logger.getLogger(Start.class.getName());

	public static void main(String[] args) throws SQLException {


//		Client myClient= new Client(4,"cristi","acasa");
//		try {
//			ClientDAO.insert(myClient);
//
//		} catch (Exception ex) {
//			LOGGER.log(Level.INFO, ex.getMessage());
//		}



//		Connection connection = null;
//		PreparedStatement statement = null;
//		String query = "insert into client values(1,'cristi','tgjiu');"  ;
//		try {
//			connection = ConnectionFactory.getConnection();
//			statement = connection.prepareStatement(query);
//			statement.executeUpdate();
//
//		} catch (SQLException e) {
//			System.out.println("nu e bine");
//		}


//find
//		ProductDAO productDAO = new ProductDAO();
//		Product p = null;
//		try {
//			p = productDAO.findByName("apple");
//			productDAO.retrieveProperties(p);
//
//		} catch (Exception ex) {
//			LOGGER.log(Level.INFO, ex.getMessage());
//		}



		//insert
//		StudentDAO studentDAO = new StudentDAO();
//		Student mihaita= new Student(1,"mihaita","acasa","ceva",7);
//		try {
//			studentDAO.insert(mihaita);
//
//		} catch (Exception ex) {
//			LOGGER.log(Level.INFO, ex.getMessage());
//		}


		//find
//		ClientDAO studentDAO = new ClientDAO();
//		Client student1 = null;
//		try {
//			student1 = studentDAO.findById(1);
//			studentDAO.retrieveProperties(student1);
//
//		} catch (Exception ex) {
//			LOGGER.log(Level.INFO, ex.getMessage());
//		}



	Parser myParser= new Parser("Insert client: Luca George, Bucuresti");


//     	myParser.check_comand();
////
//		myParser= new Parser("Insert product: apple, 20, 1");
//		myParser.check_comand();
////
//        myParser= new Parser("Insert product: lemon, 70, 2");
//		myParser.check_comand();
//
//		myParser= new Parser("Order: Luca George, lemon, 5 ");
//		myParser.check_comand();
//
//		myParser= new Parser("Order: Luca George, apple, 5");
//		myParser.check_comand();
//
//		myParser= new Parser("Order: Luca George, apple, 100");
//		myParser.check_comand();

//		myParser= new Parser("Insert client: Ion Popescu, Bucuresti");
//		myParser.check_comand();

//		myParser= new Parser("Delete client: Ion Popescu, Bucuresti");
//		myParser.check_comand();

//		myParser= new Parser("Report order");
//		myParser.check_comand();

		FileReader myFileRead =new FileReader("commands.txt");



//




	}
}
