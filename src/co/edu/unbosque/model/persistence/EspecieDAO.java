package co.edu.unbosque.model.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import co.edu.unbosque.model.Conexion;

public class EspecieDAO {
	
	private Conexion conex = new Conexion();

	public boolean crearEspecie(Especie especie) {
		boolean verificar = false;
		try {
			conex.conectarDB();
			Statement smt = conex.getConnection().createStatement();
			smt.executeUpdate("INSERT INTO especie VALUES(" + especie.getIdEspecie() + ",'" + especie.getNombre() + "'" + ")");
			verificar = true;
			smt.close();
			conex.cerrarDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return verificar;
	}
	
	public Especie consultarEspecie(int id) {
		conex.conectarDB();
		Especie especie = new Especie();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM especie WHERE idespecie = " + id);
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				especie.setIdEspecie(res.getInt("idespecie"));
				especie.setNombre(res.getString("nombre"));
			}
			res.close();
			consulta.execute();
			consulta.close();
			conex.cerrarDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return especie;
	}
	
	public ArrayList<Especie> consultarEspecies(){
		conex.conectarDB();
		ArrayList<Especie> listaEspecie = new ArrayList<Especie>();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT nombre FROM especie");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				Especie especie = new Especie(res.getString("nombre"));
				listaEspecie.add(especie);
			}
			res.close();
			consulta.execute();
			consulta.close();
			conex.cerrarDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaEspecie;
	}
	
	public boolean editarEspecie(int id, String nombreEspecie) {
		boolean verificar = false;
		try {
			conex.conectarDB();
			Statement smt = conex.getConnection().createStatement();
			smt.executeUpdate("UPDATE especie set nombre = '" + nombreEspecie +"' WHERE idespecie = " + id);
			verificar = true;
			smt.close();
			conex.cerrarDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return verificar;
	}
		
}
