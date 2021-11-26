package co.edu.unbosque.model.persistence;

public class Telefono {
	
	private int idTelefono;
	private String idUsuario = "";
	private String numeroTelefono = "";
	private String estado = "";
	
	public Telefono() {
		
	}
	
	public Telefono(int idTelefono, String idUsuario, String numeroTelefono, String estado) {
		this.idTelefono = idTelefono;
		this.idUsuario = idUsuario;
		this.numeroTelefono = numeroTelefono;
		this.estado = estado;
	}

	public Telefono(String idUsuario, String numeroTelefono, String estado) {
		this.idUsuario = idUsuario;
		this.numeroTelefono = numeroTelefono;
		this.estado = estado;
	}

	public int getIdTelefono() {
		return idTelefono;
	}

	public void setIdTelefono(int idTelefono) {
		this.idTelefono = idTelefono;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
