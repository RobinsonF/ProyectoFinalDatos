package co.edu.unbosque.model.persistence;

import java.util.Date;

public class Factura {

	private int idFactura;
	private String idUsuario = "";
	private String idFormaPago = "";
	private String formaPago = "";
	private Date fechaGeneracion;
	private String estado = "";
	
	public Factura() {
		
	}
	
	public Factura(int idFactura, String idUsuario, String formaPago, Date fechaGeneracion, String estado) {
		this.idFactura = idFactura;
		this.idUsuario = idUsuario;
		this.formaPago = formaPago;
		this.fechaGeneracion = fechaGeneracion;
		this.estado = estado;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getIdFormaPago() {
		return idFormaPago;
	}

	public void setIdFormaPago(String idFormaPago) {
		this.idFormaPago = idFormaPago;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}

	public void setFechaGeneracion(Date fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}	
		
}
