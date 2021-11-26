package co.edu.unbosque.model.persistence;

public class Raza {

	private int idRaza;
	private String nombre = "";

	public Raza() {

	}

	public Raza(int idRaza, String nombre) {
		this.idRaza = idRaza;
		this.nombre = nombre;
	}

	public Raza(String nombre) {
		this.nombre = nombre;
	}

	public int getIdRaza() {
		return idRaza;
	}

	public void setIdRaza(int idRaza) {
		this.idRaza = idRaza;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
