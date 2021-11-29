package co.edu.unbosque.model.persistence;

public class FacturaDetalle {
	
	private int idFacturaDetalle;
	private int idServicio;
	private int idFactura;
	private int cantidad;
	private int valorUnitario;
	private int subTotal;
	private int iva19;
	private int total;
	private String estado = "";
	
	public FacturaDetalle() {
		
	}
	
	public FacturaDetalle(int idServicio, int idFactura, int cantidad, int valorUnitario, int subTotal, int iva19,
			int total, String estado) {
		this.idServicio = idServicio;
		this.idFactura = idFactura;
		this.cantidad = cantidad;
		this.valorUnitario = valorUnitario;
		this.subTotal = subTotal;
		this.iva19 = iva19;
		this.total = total;
		this.estado = estado;
	}

	public FacturaDetalle(int idFacturaDetalle, int idServicio, int idFactura, int cantidad, int valorUnitario,
			int subTotal, int iva19, int total, String estado) {
		this.idFacturaDetalle = idFacturaDetalle;
		this.idServicio = idServicio;
		this.idFactura = idFactura;
		this.cantidad = cantidad;
		this.valorUnitario = valorUnitario;
		this.subTotal = subTotal;
		this.iva19 = iva19;
		this.total = total;
		this.estado = estado;
	}

	public int getIdFacturaDetalle() {
		return idFacturaDetalle;
	}

	public void setIdFacturaDetalle(int idFacturaDetalle) {
		this.idFacturaDetalle = idFacturaDetalle;
	}

	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(int valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public int getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(int subTotal) {
		this.subTotal = subTotal;
	}

	public int getIva19() {
		return iva19;
	}

	public void setIva19(int iva19) {
		this.iva19 = iva19;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
