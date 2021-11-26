package co.edu.unbosque.model.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import co.edu.unbosque.model.Conexion;

public class TelefonoDAO {

	private Conexion conex = new Conexion();

	public boolean crearTelefono(Telefono telefono) {
		boolean verificar = false;
		try {
			conex.conectarDB();
			Statement smt = conex.getConnection().createStatement();
			smt.executeUpdate(
					"INSERT INTO telefono (idusuario, numerotelefono, estado) VALUES('" + telefono.getIdUsuario()
							+ "','" + telefono.getNumeroTelefono() + "','" + telefono.getEstado() + "')");
			verificar = true;
			smt.close();
			conex.cerrarDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return verificar;
	}

	public Telefono consultarTelefono(int numeroTelefono) {
		conex.conectarDB();
		Telefono telefono = new Telefono();
		try {
			PreparedStatement consulta = conex.getConnection()
					.prepareStatement("SELECT * FROM telefono WHERE numerotelefono = " + numeroTelefono);
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				telefono.setNumeroTelefono(res.getString("numerotelefono"));
				telefono.setIdUsuario(res.getString("idusuario"));
				telefono.setEstado(res.getString("estado"));
			}
			res.close();
			consulta.execute();
			consulta.close();
			conex.cerrarDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return telefono;
	}

	public ArrayList<Telefono> consultarTelefonos(String correo) {
		conex.conectarDB();
		ArrayList<Telefono> listaTelefono = new ArrayList<Telefono>();
		try {
			PreparedStatement consulta = conex.getConnection()
					.prepareStatement("SELECT * FROM telefono WHERE idusuario = '" + correo + "'");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				Telefono telefono = new Telefono(res.getInt("idtelefono"), res.getString("idusuario"),
						res.getString("numerotelefono"), res.getString("estado"));
				listaTelefono.add(telefono);
			}
			res.close();
			consulta.execute();
			consulta.close();
			conex.cerrarDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaTelefono;
	}

	public boolean editarTelefono(int idAutor, String numeroCelular) {
		boolean verificar = false;
		try {
			conex.conectarDB();
			Statement smt = conex.getConnection().createStatement();
			smt.executeUpdate("UPDATE telefono set nombre = '" + numeroCelular + "' WHERE idusuario = " + idAutor);
			verificar = true;
			smt.close();
			conex.cerrarDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return verificar;
	}

}
