package co.edu.unbosque.model.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
			smt.executeUpdate("INSERT INTO factura (idfactura,idusuario, idformapago, fechageneracion, estado) VALUES("
					+ factura.getIdFactura() + ", (SELECT correo FROM usuario WHERE cedula = '" + factura.getIdUsuario()
					+ "'), (select idpago from formapago where nombre = '" + factura.getFormaPago() + "'),'"
					+ formato.format(factura.getFechaGeneracion()) + "', '" + factura.getEstado() + "')");
			verificar = true;
			smt.close();
			conex.cerrarDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return verificar;
	}

	public ArrayList<Factura> consultarFacturas(String usuario) {
		conex.conectarDB();
		ArrayList<Factura> listaFactura = new ArrayList<Factura>();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement(
					"SELECT a.idfactura as idfactura , b.nombre as nombrepago, a.fechageneracion as fecha FROM factura a, formapago b WHERE a.idformapago = b.idpago AND a.idusuario = '"
							+ usuario + "' ORDER BY a.idfactura");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				Factura factura = new Factura(res.getString("idfactura"), res.getString("nombrepago"),
						res.getDate("fecha"));
				listaFactura.add(factura);
			}
			res.close();
			consulta.execute();
			consulta.close();
			conex.cerrarDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaFactura;
	}
	

	public ArrayList<Factura> consultarFactura(String[][] matriz, String usuario) {
		conex.conectarDB();
		ArrayList<Factura> listaFactura = new ArrayList<Factura>();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement(
					"SELECT a.idfactura as idfactura, b.nombre as nombre, a.fechageneracion as fecha FROM factura a, formapago b WHERE a.idformapago = b.idpago and "
							+ matriz[1][0] + " = '" + matriz[1][1] + "'" + " and " + matriz[2][0] + " = '" + matriz[2][1] + "' and " + matriz[3][0] + " = '" + matriz[3][1] + "' and a.idusuario = '" + usuario +"'" );
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				Factura factura = new Factura(res.getString("idfactura"), res.getString("nombre"),
						res.getDate("fecha"));
				listaFactura.add(factura);
			}
			res.close();
			consulta.execute();
			consulta.close();
			conex.cerrarDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaFactura;
	}

	public ArrayList<Factura> consultarFactura(String[][] matriz, int posicion, String usuario) {
		conex.conectarDB();
		ArrayList<Factura> listaFactura = new ArrayList<Factura>();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement(
					"SELECT a.idfactura as idfactura, b.nombre as nombre, a.fechageneracion as fecha FROM factura a, formapago b WHERE a.idformapago = b.idpago and "
							+ matriz[posicion][0] + " = '" + matriz[posicion][1] + "' and a.idusuario = '" + usuario +"'" );
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				Factura factura = new Factura(res.getString("idfactura"), res.getString("nombre"),
						res.getDate("fecha"));
				listaFactura.add(factura);
			}
			res.close();
			consulta.execute();
			consulta.close();
			conex.cerrarDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaFactura;
	}
	
	public ArrayList<Factura> consultarFactura(String[][] matriz, int posicion1, int posicion2, String usuario) {
		conex.conectarDB();
		ArrayList<Factura> listaFactura = new ArrayList<Factura>();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement(
					"SELECT a.idfactura as idfactura, b.nombre as nombre, a.fechageneracion as fecha FROM factura a, formapago b WHERE a.idformapago = b.idpago and "
							+ matriz[posicion1][0] + " = '" + matriz[posicion1][1] + "' and " + matriz[posicion2][0]
							+ " = '" + matriz[posicion2][1] + "' and a.idusuario = '" + usuario + "'");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				Factura factura = new Factura(res.getString("idfactura"), res.getString("nombre"),
						res.getDate("fecha"));
				listaFactura.add(factura);
			}
			res.close();
			consulta.execute();
			consulta.close();
			conex.cerrarDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaFactura;
	}

	public String[][] mostarInfoFactura(ArrayList<Factura> listaFactura) {
		String[][] infoFacturas = new String[listaFactura.size()][3];
		for (int i = 0; i < listaFactura.size(); i++) {
			infoFacturas[i][0] = "" + listaFactura.get(i).getIdFactura();
			infoFacturas[i][1] = listaFactura.get(i).getFormaPago();
			infoFacturas[i][2] = String.valueOf(listaFactura.get(i).getFechaGeneracion());
		}
		return infoFacturas;
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
