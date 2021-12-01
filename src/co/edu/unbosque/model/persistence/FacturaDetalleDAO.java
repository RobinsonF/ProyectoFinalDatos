package co.edu.unbosque.model.persistence;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import co.edu.unbosque.model.Conexion;

public class FacturaDetalleDAO {

	private Conexion conex = new Conexion();
	private ServicioDAO servicioDAO;

	public FacturaDetalleDAO() {
		servicioDAO = new ServicioDAO();
	}

	public boolean crearFacturaDetalle(String idFactua, String nombreServicio, int cantidad) {
		boolean verificar = false;
		int idServicio = Integer.parseInt(servicioDAO.consultarIdServicio(nombreServicio));
		int precioUnitario = Integer.parseInt(servicioDAO.consultarPrecioTotal(idServicio + ""));
		int subtotal = precioUnitario * cantidad;
		int total = (int) ((subtotal * 0.19) + subtotal);
		try {
			conex.conectarDB();
			Statement smt = conex.getConnection().createStatement();
			smt.executeUpdate(
					"insert into facturadetalle (idservicio, idfactura, cantidad, valorunitario, subtotal, iva_19, total, estado) values ("
							+ idServicio + ", " + idFactua + "," + cantidad + "," + precioUnitario + "," + subtotal
							+ ", 19," + total + ", 'A')");
			verificar = true;
			smt.close();
			conex.cerrarDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return verificar;
	}

}
