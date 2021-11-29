package co.edu.unbosque.model.persistence;

public class FormaPago {
	
	private int idPago;
	private String nombre = "";
	private String descripcion = "";
	private String estado = "";
	
	public FormaPago() {
		
	}
	
	public FormaPago(int idPago, String nombre, String descripcion, String estado) {
		this.idPago = idPago;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	public int getIdPago() {
		return idPago;
	}

	public void setIdPago(int idPago) {
		this.idPago = idPago;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}	

}
