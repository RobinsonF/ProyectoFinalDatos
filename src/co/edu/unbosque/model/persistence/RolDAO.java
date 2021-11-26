package co.edu.unbosque.model.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import co.edu.unbosque.model.Conexion;

public class RolDAO {
	
	private Conexion conex = new Conexion();

	public boolean crearRol(Rol rol) {
		boolean verificar = false;
		try {
			conex.conectarDB();
			Statement smt = conex.getConnection().createStatement();
			smt.executeUpdate("INSERT INTO rol VALUES(" + rol.getIdRol() + ",'" + rol.getNombre() + "'" + ")");
			verificar = true;
			smt.close();
			conex.cerrarDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return verificar;
	}
	
	public Rol consultarRol(int id) {
		conex.conectarDB();
		Rol rol = new Rol();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM rol WHERE idrol = " + id);
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				rol.setIdRol(res.getInt("idrol"));
				rol.setNombre(res.getString("nombre"));
			}
			res.close();
			consulta.execute();
			consulta.close();
			conex.cerrarDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rol;
	}
	
	public ArrayList<Rol> consultarRoles(){
		conex.conectarDB();
		ArrayList<Rol> listaRol = new ArrayList<Rol>();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM rol");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				Rol raza = new Rol(res.getInt("idrol"), res.getString("nombre"));
				listaRol.add(raza);
			}
			res.close();
			consulta.execute();
			consulta.close();
			conex.cerrarDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRol;
	}
	
	public boolean editarRol(int id, String nombreRol) {
		boolean verificar = false;
		try {
			conex.conectarDB();
			Statement smt = conex.getConnection().createStatement();
			smt.executeUpdate("UPDATE rol set nombre = '" + nombreRol +"' WHERE idrol = " + id);
			verificar = true;
			smt.close();
			conex.cerrarDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return verificar;
	}
		
}
