package co.edu.unbosque.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	String login = "postgres";
	String password = "camino32";
	String url = "jdbc:postgresql://localhost:5432/ubosquedb";
	private Connection connection;

	public Conexion() {

	}

	public void conectarDB() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(url, login, password);

			if (connection != null) {
				System.out.println("Conexion establecida");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void cerrarDB() {
		try {
			connection.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
