package co.edu.unbosque.model.persistence;

import java.util.Date;

public class Factura {

	private int idFactura;
	private String idUsuario = "";
	private int idFormaPago;
	private String formaPago;
	private Date fechaGeneracion;
	private String estado = "";
	
	public Factura() {
		
	}
	
	public Factura(int idFactura, String idUsuario, int idFormaPago, Date fechaGeneracion, String estado) {
		this.idFactura = idFactura;
		this.idUsuario = idUsuario;
		this.idFormaPago = idFormaPago;
		this.fechaGeneracion = fechaGeneracion;
		this.estado = estado;
	}
	

	public Factura(String idUsuario, String formaPago, Date fechaGeneracion, String estado) {
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

	public int getIdFormaPago() {
		return idFormaPago;
	}

	public void setIdFormaPago(int idFormaPago) {
		this.idFormaPago = idFormaPago;
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

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	
		
}
