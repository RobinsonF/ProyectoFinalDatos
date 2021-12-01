package co.edu.unbosque.model.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import co.edu.unbosque.model.Conexion;

public class ServicioDAO {

	private Conexion conex = new Conexion();

	public ArrayList<Servicio> consultarServicios() {
		conex.conectarDB();
		ArrayList<Servicio> listaServicio = new ArrayList<Servicio>();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM servicio WHERE estado = 'A'");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				Servicio servicio = new Servicio(res.getInt("idservicio"), res.getString("nombre"),
						res.getString("descripcion"), res.getInt("preciototal"), res.getInt("descuento"),
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

	public ArrayList<Servicio> consultarServicios(String[][] matriz, int posicion1) {
		conex.conectarDB();
		ArrayList<Servicio> listaServicio = new ArrayList<Servicio>();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement(
					"SELECT * FROM servicio WHERE " + matriz[posicion1][0] + " = '" + matriz[posicion1][1] + "' and estado = 'A'");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				Servicio servicio = new Servicio(res.getInt("idservicio"), res.getString("nombre"),
						res.getString("descripcion"), res.getInt("preciototal"), res.getInt("descuento"),
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

	public ArrayList<Servicio> consultarServicios(String[][] matriz) {
		conex.conectarDB();
		ArrayList<Servicio> listaServicio = new ArrayList<Servicio>();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM servicio WHERE "
					+ matriz[1][0] + " = '" + matriz[1][1] + "' and " + matriz[2][0] + " = '" + matriz[2][1] + "' and estado = 'A'");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				Servicio servicio = new Servicio(res.getInt("idservicio"), res.getString("nombre"),
						res.getString("descripcion"), res.getInt("preciototal"), res.getInt("descuento"),
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

	public boolean crearServicio(Servicio servicio) {
		boolean verificar = false;
		try {
			conex.conectarDB();
			Statement smt = conex.getConnection().createStatement();
			smt.executeUpdate("INSERT INTO servicio (nombre, descripcion, precio, preciototal, estado) values ('"
					+ servicio.getNombre() + "'," + "'" + servicio.getDescripcion() + "'," + servicio.getPrecio() + ","
					+ servicio.getPrecioTotal() + ", '" + servicio.getEstado() + "')");
			verificar = true;
			smt.close();
			conex.cerrarDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return verificar;
	}
	
	public boolean editarServicio(String[][] matriz) {
		boolean verificar = false;
		try {
			System.out.println("UPDATE servicio SET " + matriz[1][0] + " = '" + matriz[1][1] + "'  WHERE idservicio = " + matriz[1][2]);
			conex.conectarDB();
			Statement smt = conex.getConnection().createStatement();
			smt.executeUpdate("UPDATE servicio SET " + matriz[1][0] + " = '" + matriz[1][1] + "'  WHERE idservicio = " + matriz[1][2]);
			verificar = true;
			smt.close();
			conex.cerrarDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return verificar;
	}
	
	public boolean eliminarServicio(String id) {
		boolean verificar = false;
		try {
			conex.conectarDB();
			Statement smt = conex.getConnection().createStatement();
			smt.executeUpdate("UPDATE servicio SET estado = 'I' WHERE idservicio = " + id);
			verificar = true;
			smt.close();
			conex.cerrarDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return verificar;
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

	public String[][] mostarInfoServicio(ArrayList<Servicio> listaServicio) {

		String[][] infoMascotas = new String[listaServicio.size()][3];
		for (int i = 0; i < listaServicio.size(); i++) {
			infoMascotas[i][0] = String.valueOf(listaServicio.get(i).getIdServicio());
			infoMascotas[i][1] = listaServicio.get(i).getNombre();
			infoMascotas[i][2] = String.valueOf(listaServicio.get(i).getPrecioTotal());
		}
		return infoMascotas;
	}

}
