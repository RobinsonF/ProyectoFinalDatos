package co.edu.unbosque.model.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import co.edu.unbosque.model.Conexion;

public class ServicioDAO {

	private Conexion conex = new Conexion();

	public ArrayList<Servicio> consultarServicios() {
		conex.conectarDB();
		ArrayList<Servicio> listaServicio = new ArrayList<Servicio>();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM servicio");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				Servicio servicio = new Servicio(res.getInt("idservicio"), res.getString("nombre"),
						res.getString("descripcion"), res.getInt("precio"), res.getInt("descuento"),
						res.getInt("preciototal"), res.getString("estado"));
				listaServicio.add(servicio);
			}
			res.close();
			consulta.execute();
			consulta.close();
			conex.cerrarDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaServicio;
	}

	public String consultarIdServicio(String nombre) {
		conex.conectarDB();
		String idServicio = "";
		try {
			PreparedStatement consulta = conex.getConnection()
					.prepareStatement("SELECT idservicio FROM servicio WHERE nombre = '" + nombre + "'");
			ResultSet res = consulta.executeQuery();
			if (res.next()) {
				idServicio = res.getString("idservicio");
			}
			res.close();
			consulta.execute();
			consulta.close();
			conex.cerrarDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return idServicio;
	}

	public String consultarPrecioTotal(String idServicio) {
		conex.conectarDB();
		String precioTotal = "";
		try {
			PreparedStatement consulta = conex.getConnection()
					.prepareStatement("SELECT preciototal FROM servicio WHERE idservicio = " + idServicio);
			ResultSet res = consulta.executeQuery();
			if (res.next()) {
				precioTotal = "" + res.getInt("preciototal");
			}
			res.close();
			consulta.execute();
			consulta.close();
			conex.cerrarDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return precioTotal;
	}
}
