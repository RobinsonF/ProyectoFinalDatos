package co.edu.unbosque.model.persistence;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import co.edu.unbosque.model.Conexion;

public class FacturaDAO {

	private Conexion conex = new Conexion();
	private FormaPagoDAO formaPagoDAO;
	private FacturaDetalleDAO facturaDetalleDAO;

	public FacturaDAO() {
		formaPagoDAO = new FormaPagoDAO();
		facturaDetalleDAO = new FacturaDetalleDAO();
	}

	public boolean crearFactura(Factura factura) {
		boolean verificar = false;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		try {
			conex.conectarDB();
			Statement smt = conex.getConnection().createStatement();
			smt.executeUpdate("INSERT INTO factura (idusuario, idformapago, fechageneracion, estado) VALUES"
					+ factura.getIdUsuario() + "', (select idpago from formapago where nombre = '"
					+ factura.getFormaPago() + "'),'" + formato.format(factura.getFechaGeneracion()) + "', '"
					+ factura.getEstado() + "'");
			verificar = true;
			smt.close();
			conex.cerrarDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return verificar;
	}

	public FormaPagoDAO getFormaPagoDAO() {
		return formaPagoDAO;
	}

	public void setFormaPagoDAO(FormaPagoDAO formaPagoDAO) {
		this.formaPagoDAO = formaPagoDAO;
	}

	public FacturaDetalleDAO getFacturaDetalleDAO() {
		return facturaDetalleDAO;
	}

	public void setFacturaDetalleDAO(FacturaDetalleDAO facturaDetalleDAO) {
		this.facturaDetalleDAO = facturaDetalleDAO;
	}

}
