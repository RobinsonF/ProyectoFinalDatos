package co.edu.unbosque.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.unbosque.model.persistence.ConexionProperties;

public class Conexion {
	
	ConexionProperties conexionProperties;
	String login = "";
	String password = "";
	String url = "";
	private Connection connection;

	public Conexion() {
		conexionProperties = new ConexionProperties();
		String[] datos = conexionProperties.leerInfoBD();
		login = datos[0];
		password = datos[1];
		url = datos[2];
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
