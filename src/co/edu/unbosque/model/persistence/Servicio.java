package co.edu.unbosque.model.persistence;

public class Servicio {
	
	private int idServicio;
	private String nombre = "";
	private String descripcion = "";
	private int precio;
	private int descuento;
	private int precioTotal;
	private String estado = "";
	
	public Servicio() {
		
	}
	
	public Servicio(int idServicio, String nombre, String descripcion, int precio, int descuento, int precioTotal,
			String estado) {
		this.idServicio = idServicio;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.descuento = descuento;
		this.precioTotal = precioTotal;
		this.estado = estado;
	}
	
	

	public Servicio(String nombre, String descripcion, int precio, int precioTotal, String estado) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.precioTotal = precioTotal;
		this.estado = estado;
	}

	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
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

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public int getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(int precioTotal) {
		this.precioTotal = precioTotal;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
