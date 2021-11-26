package co.edu.unbosque.model.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import co.edu.unbosque.model.Conexion;

public class RazaDAO {
	
	private Conexion conex = new Conexion();

	public boolean crearRaza(Raza raza) {
		boolean verificar = false;
		try {
			conex.conectarDB();
			Statement smt = conex.getConnection().createStatement();
			smt.executeUpdate("INSERT INTO raza VALUES(" + raza.getIdRaza() + ",'" + raza.getNombre() + "'" + ")");
			verificar = true;
			smt.close();
			conex.cerrarDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return verificar;
	}
	
	public Raza consultarRaza(int id) {
		conex.conectarDB();
		Raza raza = new Raza();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM raza WHERE idraza = " + id);
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				raza.setIdRaza(res.getInt("idraza"));
				raza.setNombre(res.getString("nombre"));
			}
			res.close();
			consulta.execute();
			consulta.close();
			conex.cerrarDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return raza;
	}
	
	public ArrayList<Raza> consultarRazas(){
		conex.conectarDB();
		ArrayList<Raza> listaRaza = new ArrayList<Raza>();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT nombre FROM raza");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				Raza raza = new Raza(res.getString("nombre"));
				listaRaza.add(raza);
			}
			res.close();
			consulta.execute();
			consulta.close();
			conex.cerrarDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRaza;
	}
	
	public boolean editarRaza(int id, String nombreRaza) {
		boolean verificar = false;
		try {
			conex.conectarDB();
			Statement smt = conex.getConnection().createStatement();
			smt.executeUpdate("UPDATE raza set nombre = '" + nombreRaza +"' WHERE idraza = " + id);
			verificar = true;
			smt.close();
			conex.cerrarDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return verificar;
	}
		
}
