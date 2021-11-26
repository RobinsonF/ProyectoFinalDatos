package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

public class Usuario {

	private String correo = "";
	private int idRol;
	private String cedula = "";
	private String contraseña = "";
	private String nombres = "";
	private String apellidos = "";
	private String dirreccion = "";
	private int edad;
	private String sexo = "";
	private String estado = "";
	private ArrayList<Mascota> mascotas = null;
	private ArrayList<Telefono> telefonos = null;

	public Usuario() {
		
	}
	
	public Usuario(String correo, int idRol, String cedula, String contraseña, String nombres, String apellidos,
			String dirreccion, int edad, String sexo, String estado) {
		this.correo = correo;
		this.idRol = idRol;
		this.cedula = cedula;
		this.contraseña = contraseña;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dirreccion = dirreccion;
		this.edad = edad;
		this.sexo = sexo;
		this.estado = estado;
	}
		
	public Usuario(String correo, String cedula, String nombres, String apellidos, String dirreccion, int edad,
			String sexo) {
		this.correo = correo;
		this.cedula = cedula;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dirreccion = dirreccion;
		this.edad = edad;
		this.sexo = sexo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDirreccion() {
		return dirreccion;
	}

	public void setDirreccion(String dirreccion) {
		this.dirreccion = dirreccion;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public ArrayList<Mascota> getMascotas() {
		return mascotas;
	}

	public void setMascotas(ArrayList<Mascota> mascotas) {
		this.mascotas = mascotas;
	}

	public ArrayList<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(ArrayList<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

}
