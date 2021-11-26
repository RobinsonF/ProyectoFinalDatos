package co.edu.unbosque.model.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import co.edu.unbosque.model.Conexion;

public class ColorDAO {
	
	private Conexion conex = new Conexion();

	public boolean crearColor(Color color) {
		boolean verificar = false;
		try {
			conex.conectarDB();
			Statement smt = conex.getConnection().createStatement();
			smt.executeUpdate("INSERT INTO color VALUES(" + color.getIdColor() + ",'" + color.getNombre() + "'" + ")");
			verificar = true;
			smt.close();
			conex.cerrarDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return verificar;
	}
	
	public Color consultarColor(int id) {
		conex.conectarDB();
		Color color = new Color();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM color WHERE idcolor = " + id);
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				color.setIdColor(res.getInt("idcolor"));
				color.setNombre(res.getString("nombre"));
			}
			res.close();
			consulta.execute();
			consulta.close();
			conex.cerrarDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return color;
	}
	
	public ArrayList<Color> consultarColores(){
		conex.conectarDB();
		ArrayList<Color> listaColor = new ArrayList<Color>();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT nombre FROM color");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				Color color = new Color(res.getString("nombre"));
				listaColor.add(color);
			}
			res.close();
			consulta.execute();
			consulta.close();
			conex.cerrarDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaColor;
	}
	
	public boolean editarColor(int id, String nombreColor) {
		boolean verificar = false;
		try {
			conex.conectarDB();
			Statement smt = conex.getConnection().createStatement();
			smt.executeUpdate("UPDATE color set nombre = '" + nombreColor +"' WHERE idcolor = " + id);
			verificar = true;
			smt.close();
			conex.cerrarDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return verificar;
	}
		
}
