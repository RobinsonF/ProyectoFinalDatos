package co.edu.unbosque.model.persistence;

public class Especie {
	
	private int idEspecie;
	private String nombre = "";
	
	public Especie() {
		
	}
	
	public Especie(int idEspecie, String nombre) {
		this.idEspecie = idEspecie;
		this.nombre = nombre;
	}
	
	public Especie(String nombre) {
		this.nombre = nombre;
	}



	public int getIdEspecie() {
		return idEspecie;
	}

	public void setIdEspecie(int idEspecie) {
		this.idEspecie = idEspecie;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
