package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.UsuarioDAO;

public class Clinica {

	private UsuarioDAO usuarioDAO;

	public Clinica() {
		usuarioDAO = new UsuarioDAO();
	}

	public boolean soloNumeros(String numero) {
		for (int i = 0; i < numero.length(); i++) {
			char aux = numero.charAt(i);
			int digito = aux - '0';
			if (digito > 9 || digito < 0) {
				return false;
			}
		}
		return true;
	}

	public void verificarNumero(String numero) throws ExceptionNumero {
		if (!soloNumeros(numero)) {
			throw new ExceptionNumero("Caracter no permitido en campo num�rico");
		}
	}

	public void verificarContra(String numero) throws ExceptionNumero {
		if (soloNumeros(numero)) {
			if (numero.length() < 8) {
				throw new ExceptionNumero("M�nimo 8 caractares para la contrase�a");
			}
		}
	}

	public void verficarCedula(String cedula) throws ExceptionCedula {
		if (!soloNumeros(cedula)) {
			throw new ExceptionCedula("Solo se permiten n�meros en el campo de la c�dula");
		} else {
			if (cedula.length() > 10 || cedula.length() < 8) {
				throw new ExceptionCedula("Verifique la cantidad de d�gitos de la c�dula");
			}
		}
	}

	public void verficarTelefono(String telefono) throws ExceptionTelefono {
		if (!soloNumeros(telefono)) {
			throw new ExceptionTelefono("Solo se permiten n�meros en el campo del telefono");
		} else {
			if (telefono.length() > 10 || telefono.length() < 10) {
				throw new ExceptionTelefono("N�mero de tel�fono invalido");
			}
		}
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

}
