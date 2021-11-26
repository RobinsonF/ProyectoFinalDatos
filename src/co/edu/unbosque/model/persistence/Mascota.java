package co.edu.unbosque.model.persistence;

import java.util.Date;

public class Mascota {
	
	private int idMascota;
	private String idDue�o = "";
	private String nombre = "";
	private String idEspecie;
	private String idRaza;
	private String idColor;
	private Date a�oNacimiento;
	private String estado;
	private String nombreUsuario;
	
	public Mascota() {
		
	}
	
	public Mascota(int idMascota, String idDue�o, String nombre, String idEspecie, String idRaza, String idColor,
			Date a�oNacimiento, String estado) {
		this.idMascota = idMascota;
		this.idDue�o = idDue�o;
		this.nombre = nombre;
		this.idEspecie = idEspecie;
		this.idRaza = idRaza;
		this.idColor = idColor;
		this.a�oNacimiento = a�oNacimiento;
		this.estado = estado;
	}
	
	
	
	public Mascota(String nombre, String idEspecie, String idRaza, String idColor, Date a�oNacimiento) {
		this.nombre = nombre;
		this.idEspecie = idEspecie;
		this.idRaza = idRaza;
		this.idColor = idColor;
		this.a�oNacimiento = a�oNacimiento;
	}
	
	public Mascota(String nombre, String idEspecie, String idRaza, String idColor, Date a�oNacimiento, String nombreUsuario) {
		this.nombre = nombre;
		this.idEspecie = idEspecie;
		this.idRaza = idRaza;
		this.idColor = idColor;
		this.a�oNacimiento = a�oNacimiento;
		this.nombreUsuario = nombreUsuario;
	}
	
	
	
	public Mascota(int idMascota, String nombre, String idEspecie, String idRaza, String idColor, Date a�oNacimiento) {
		this.idMascota = idMascota;
		this.nombre = nombre;
		this.idEspecie = idEspecie;
		this.idRaza = idRaza;
		this.idColor = idColor;
		this.a�oNacimiento = a�oNacimiento;
	}

	public int getIdMascota() {
		return idMascota;
	}
	public void setIdMascota(int idMascota) {
		this.idMascota = idMascota;
	}
	public String getIdDue�o() {
		return idDue�o;
	}
	public void setIdDue�o(String idDue�o) {
		this.idDue�o = idDue�o;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIdEspecie() {
		return idEspecie;
	}
	public void setIdEspecie(String idEspecie) {
		this.idEspecie = idEspecie;
	}
	public String getIdRaza() {
		return idRaza;
	}
	public void setIdRaza(String idRaza) {
		this.idRaza = idRaza;
	}
	public String getIdColor() {
		return idColor;
	}
	public void setIdColor(String idColor) {
		this.idColor = idColor;
	}
	public Date getA�oNacimiento() {
		return a�oNacimiento;
	}
	public void setA�oNacimiento(Date a�oNacimiento) {
		this.a�oNacimiento = a�oNacimiento;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
}
