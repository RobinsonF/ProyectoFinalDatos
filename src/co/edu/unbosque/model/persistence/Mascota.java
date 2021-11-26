package co.edu.unbosque.model.persistence;

import java.util.Date;

public class Mascota {
	
	private int idMascota;
	private String idDueño = "";
	private String nombre = "";
	private String idEspecie;
	private String idRaza;
	private String idColor;
	private Date añoNacimiento;
	private String estado;
	private String nombreUsuario;
	
	public Mascota() {
		
	}
	
	public Mascota(int idMascota, String idDueño, String nombre, String idEspecie, String idRaza, String idColor,
			Date añoNacimiento, String estado) {
		this.idMascota = idMascota;
		this.idDueño = idDueño;
		this.nombre = nombre;
		this.idEspecie = idEspecie;
		this.idRaza = idRaza;
		this.idColor = idColor;
		this.añoNacimiento = añoNacimiento;
		this.estado = estado;
	}
	
	
	
	public Mascota(String nombre, String idEspecie, String idRaza, String idColor, Date añoNacimiento) {
		this.nombre = nombre;
		this.idEspecie = idEspecie;
		this.idRaza = idRaza;
		this.idColor = idColor;
		this.añoNacimiento = añoNacimiento;
	}
	
	public Mascota(String nombre, String idEspecie, String idRaza, String idColor, Date añoNacimiento, String nombreUsuario) {
		this.nombre = nombre;
		this.idEspecie = idEspecie;
		this.idRaza = idRaza;
		this.idColor = idColor;
		this.añoNacimiento = añoNacimiento;
		this.nombreUsuario = nombreUsuario;
	}
	
	
	
	public Mascota(int idMascota, String nombre, String idEspecie, String idRaza, String idColor, Date añoNacimiento) {
		this.idMascota = idMascota;
		this.nombre = nombre;
		this.idEspecie = idEspecie;
		this.idRaza = idRaza;
		this.idColor = idColor;
		this.añoNacimiento = añoNacimiento;
	}

	public int getIdMascota() {
		return idMascota;
	}
	public void setIdMascota(int idMascota) {
		this.idMascota = idMascota;
	}
	public String getIdDueño() {
		return idDueño;
	}
	public void setIdDueño(String idDueño) {
		this.idDueño = idDueño;
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
	public Date getAñoNacimiento() {
		return añoNacimiento;
	}
	public void setAñoNacimiento(Date añoNacimiento) {
		this.añoNacimiento = añoNacimiento;
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
