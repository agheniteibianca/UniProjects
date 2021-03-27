package dao;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;
import model.Client;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 * @Source http://www.java-blog.com/mapping-javaobjects-database-reflection-generics
 */
public class AbstractDAO<T> {
	protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

	private final Class<T> type;

	@SuppressWarnings("unchecked")
	public AbstractDAO() {
		this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

	}

	private String createInsertStatement(T toBeAdded) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO ");
		sb.append(type.getSimpleName());
		sb.append(" VALUES (");
		for (Field field : toBeAdded.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			Object value;
			try {
				value = field.get(toBeAdded);
				if(value instanceof String){
					sb.append("'");
					sb.append(value);
					sb.append("'");
				}
				else{
					sb.append(value);
				}

				sb.append(",");

			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		//avem o virgula in plus
		sb.deleteCharAt(sb.length()-1);
		sb.append(");");
		System.out.println(sb);

		return sb.toString();
	}

	private String createSelectQuery(String field) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append(" * ");
		sb.append(" FROM ");
		sb.append(type.getSimpleName());
		sb.append(" WHERE " + field + " =?");
		return sb.toString();
	}

	private String createBasicSelectQuery() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append(" * ");
		sb.append(" FROM ");
		sb.append(type.getSimpleName());
		return sb.toString();
	}


	private String createDeleteStatement(String field) {
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE ");
		sb.append(" FROM ");
		sb.append(type.getSimpleName());
		sb.append(" WHERE " + field + " =?");
		return sb.toString();
	}

	public List<T> selectQuery() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		String query=createBasicSelectQuery();
		System.out.println(query);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			return createObjects(resultSet);
		} catch (SQLException e) {
			//LOGGER.log(Level.WARNING, type.getName() + " DAO:findById " + e.getMessage());
		} catch (IndexOutOfBoundsException e){
			System.out.println("nu s-a gasit");
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			//ConnectionFactory.close(connection);
		}
		return null;
	}


	public T findByName(String name) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		String query=null;
		if(type.getSimpleName().equals("Client")){
			query = createSelectQuery("client_name");
		}
		else if(type.getSimpleName().equals("Product")){
			query = createSelectQuery("product_name");
		}
		else if(type.getSimpleName().equals("Orders")){
			query = createSelectQuery("client_name");
		}

		System.out.println(query);


		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, name);

			resultSet = statement.executeQuery();

			return createObjects(resultSet).get(0);
		} catch (SQLException e) {
			//LOGGER.log(Level.WARNING, type.getName() + " DAO:findById " + e.getMessage());
		} catch (IndexOutOfBoundsException e){
			System.out.println("nu s-a gasit");
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			//ConnectionFactory.close(connection);
		}
		return null;
	}


	public void insert(T t) {
		Connection connection = null;
		PreparedStatement statement = null;
		String query = createInsertStatement(t);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.executeUpdate();

		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + " DAO:insert " + e.getMessage());
		} finally {
			ConnectionFactory.close(statement);
			//ConnectionFactory.close(connection);
		}
	}
	public void deleteByClientName(String name) {
		Connection connection = null;
		PreparedStatement statement = null;
		String del=null;
		if(type.getSimpleName().equals("Client")){
			del = createDeleteStatement("client_name");
		}
		else if(type.getSimpleName().equals("Orders")){
			del = createDeleteStatement("client_name");
		}
		else if(type.getSimpleName().equals("Order_item")){
			del = createDeleteStatement("client_name");
		}

		System.out.println(del);

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(del);
			statement.setString(1, name);
			statement.executeUpdate();

		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + " DAO:delete " + e.getMessage());
		} finally {
			ConnectionFactory.close(statement);
			//ConnectionFactory.close(connection);
		}
	}

	public void deleteByProductName(String name) {
		Connection connection = null;
		PreparedStatement statement = null;
		String del=null;

		if(type.getSimpleName().equals("Order_item")){
			del = createDeleteStatement("product_name");
		}
		else if(type.getSimpleName().equals("Product")){
			del = createDeleteStatement("product_name");
		}
		System.out.println(del);

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(del);
			statement.setString(1, name);
			statement.executeUpdate();

		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + " DAO:delete " + e.getMessage());
		} finally {
			ConnectionFactory.close(statement);
			//ConnectionFactory.close(connection);
		}
	}



	private List<T> createObjects(ResultSet resultSet) {
		List<T> list = new ArrayList<T>();

		try {
			while (resultSet.next()) {
				T instance = type.newInstance();
				for (Field field : type.getDeclaredFields()) {
					Object value = resultSet.getObject(field.getName());
					PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), type);
					Method method = propertyDescriptor.getWriteMethod();
					method.invoke(instance, value);
				}
				list.add(instance);
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
		return list;
	}



	public static void retrieveProperties(Object object) {

		for (Field field : object.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			Object value;
			try {
				value = field.get(object);
				System.out.println(field.getName() + "=" + value);

			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}

		}
	}

	public T update(T t) {
		// TODO:
		return t;
	}
}
