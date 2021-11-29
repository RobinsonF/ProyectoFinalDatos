package co.edu.unbosque.model.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import co.edu.unbosque.model.Conexion;
import co.edu.unbosque.model.Hash;

public class UsuarioDAO {

	private Conexion conex = new Conexion();
	private MascotaDAO mascotaDAO = new MascotaDAO();
	private TelefonoDAO telefonoDAO = new TelefonoDAO();
	private Hash sha = new Hash();

	public boolean crearUsuario(Usuario usuario) {
		boolean verificar = false;
		try {
			conex.conectarDB();
			Statement smt = conex.getConnection().createStatement();
			smt.executeUpdate("INSERT INTO usuario VALUES(" + "'" + usuario.getCorreo() + "'," + usuario.getIdRol()
					+ ",'" + usuario.getCedula() + "','" + usuario.getContraseña() + "','" + usuario.getNombres()
					+ "','" + usuario.getApellidos() + "','" + usuario.getSexo() + "'," + usuario.getEdad() + ",'"
					+ usuario.getDirreccion() + "','" + usuario.getEstado() + "'" + ")");
			verificar = true;
			smt.close();
			conex.cerrarDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return verificar;
	}
	

	public ArrayList<Usuario> consultarUsuarios() {
		conex.conectarDB();
		ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement(
					"SELECT nombres, apellidos, correo, cedula, direccion, edad, sexo FROM usuario WHERE idrol in (2,3) and estado = 'A'");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				Usuario usuario = new Usuario(res.getString("correo"), res.getString("cedula"),
						res.getString("nombres"), res.getString("apellidos"), res.getString("direccion"),
						res.getInt("edad"), res.getString("sexo"));
				listaUsuario.add(usuario);
			}
			res.close();
			consulta.execute();
			consulta.close();
			conex.cerrarDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaUsuario;
	}

	public ArrayList<Usuario> consultarUsuarios(String[][] matriz, int posicion) {
		conex.conectarDB();
		ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuario WHERE "
					+ matriz[posicion][0] + " = '" + matriz[posicion][1] + "' and idrol in (2,3) and estado = 'A'");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				Usuario usuario = new Usuario(res.getString("correo"), res.getString("cedula"),
						res.getString("nombres"), res.getString("apellidos"), res.getString("direccion"),
						res.getInt("edad"), res.getString("sexo"));
				listaUsuario.add(usuario);
			}
			res.close();
			consulta.execute();
			consulta.close();
			conex.cerrarDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaUsuario;
	}

	public ArrayList<Usuario> consultarUsuarios(String[][] matriz, int posicion1, int posicion2) {
		conex.conectarDB();
		ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
		try {
			PreparedStatement consulta = conex.getConnection()
					.prepareStatement("SELECT * FROM usuario WHERE " + matriz[posicion1][0] + " = '"
							+ matriz[posicion1][1] + "' and " + matriz[posicion2][0] + " = '" + matriz[posicion2][1]
							+ "' and idrol in (2,3) and estado = 'A'");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				Usuario usuario = new Usuario(res.getString("correo"), res.getString("cedula"),
						res.getString("nombres"), res.getString("apellidos"), res.getString("direccion"),
						res.getInt("edad"), res.getString("sexo"));
				listaUsuario.add(usuario);
			}
			res.close();
			consulta.execute();
			consulta.close();
			conex.cerrarDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaUsuario;
	}

	public ArrayList<Usuario> consultarUsuarios(String[][] matriz, int posicion1, int posicion2, int posicion3) {
		conex.conectarDB();
		ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
		try {
			PreparedStatement consulta = conex.getConnection()
					.prepareStatement("SELECT * FROM usuario WHERE " + matriz[posicion1][0] + " = '"
							+ matriz[posicion1][1] + "' and " + matriz[posicion2][0] + " = '" + matriz[posicion2][1]
							+ "' and " + matriz[posicion3][0] + " = '" + matriz[posicion3][1]
							+ "' and idrol in (2,3) and estado = 'A'");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				Usuario usuario = new Usuario(res.getString("correo"), res.getString("cedula"),
						res.getString("nombres"), res.getString("apellidos"), res.getString("direccion"),
						res.getInt("edad"), res.getString("sexo"));
				listaUsuario.add(usuario);
			}
			res.close();
			consulta.execute();
			consulta.close();
			conex.cerrarDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaUsuario;
	}

	public ArrayList<Usuario> consultarUsuarios(String[][] matriz, int posicion1, int posicion2, int posicion3,
			int posicion4) {
		conex.conectarDB();
		ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuario WHERE "
					+ matriz[posicion1][0] + " = '" + matriz[posicion1][1] + "' and " + matriz[posicion2][0] + " = '"
					+ matriz[posicion2][1] + "' and " + matriz[posicion3][0] + " = '" + matriz[posicion3][1] + "' and "
					+ matriz[posicion4][0] + " = '" + matriz[posicion4][1] + "' and idrol in (2,3) and estado = 'A'");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				Usuario usuario = new Usuario(res.getString("correo"), res.getString("cedula"),
						res.getString("nombres"), res.getString("apellidos"), res.getString("direccion"),
						res.getInt("edad"), res.getString("sexo"));
				listaUsuario.add(usuario);
			}
			res.close();
			consulta.execute();
			consulta.close();
			conex.cerrarDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaUsuario;
	}

	public ArrayList<Usuario> consultarUsuarios(String[][] matriz) {
		conex.conectarDB();
		ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
		try {
			PreparedStatement consulta = conex.getConnection()
					.prepareStatement("SELECT * FROM usuario WHERE " + matriz[1][0] + " = '" + matriz[1][1] + "' and "
							+ matriz[2][0] + " = '" + matriz[2][1] + "' and " + matriz[3][0] + " = '" + matriz[3][1]
							+ "' and " + matriz[4][0] + " = '" + matriz[4][1] + "' and " + matriz[5][0] + " = '"
							+ matriz[5][1] + "' and idrol in (2,3) and estado = 'A'");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				Usuario usuario = new Usuario(res.getString("correo"), res.getString("cedula"),
						res.getString("nombres"), res.getString("apellidos"), res.getString("direccion"),
						res.getInt("edad"), res.getString("sexo"));
				listaUsuario.add(usuario);
			}
			res.close();
			consulta.execute();
			consulta.close();
			conex.cerrarDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaUsuario;
	}

	public Usuario consultarUsuario(String correo) {
		Usuario usuario = new Usuario();

		try {
			conex.conectarDB();
			PreparedStatement consulta = conex.getConnection()
					.prepareStatement("SELECT * FROM usuario WHERE correo = '" + correo + "'");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				usuario.setCorreo(res.getString("correo"));
				usuario.setApellidos(res.getString("apellidos"));
				usuario.setNombres(res.getString("nombres"));
				usuario.setDirreccion(res.getString("direccion"));
				usuario.setEdad(res.getInt("edad"));
				usuario.setCedula(res.getString("cedula"));
				usuario.setSexo(res.getString("sexo"));
			}
			res.close();
			consulta.execute();
			consulta.close();
			conex.cerrarDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	public String[] verificarContra(String correo, String contra) {
		String[] resultado = new String[3];
		boolean verificar = false;
		Usuario usuario = new Usuario();

		try {
			conex.conectarDB();
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuario WHERE correo = '"
					+ correo + "' and contra = '" + sha.shaEncode(contra) + "'");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				usuario.setCorreo(res.getString("correo"));
				usuario.setContraseña(res.getString("contra"));
				usuario.setNombres(res.getString("nombres"));
				usuario.setIdRol(res.getInt("idrol"));
			}

			if (usuario.getCorreo().equals(correo) && usuario.getContraseña().equals(sha.shaEncode(contra))) {
				verificar = true;
				resultado[0] = "" + verificar;
				resultado[1] = "" + usuario.getIdRol();
				resultado[2] = usuario.getNombres();
			}
			res.close();
			consulta.execute();
			consulta.close();
			conex.cerrarDB();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {

		}
		return resultado;
	}

	public boolean verificarIdUsuario(String correo) {
		boolean verificar = false;
		String correoUsuario = "";
		try {
			conex.conectarDB();
			PreparedStatement consulta = conex.getConnection()
					.prepareStatement("SELECT correo FROM usuario WHERE correo = '" + correo + "'");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				correoUsuario = res.getString("correo");
			}
			if (correoUsuario.equals(correo)) {
				verificar = true;
			}
			res.close();
			consulta.execute();
			consulta.close();
			conex.cerrarDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return verificar;
	}

	public boolean eliminarUsuario(String cedula) {
		String cedulaU = "";
		boolean verificar = false;
		try {
			conex.conectarDB();

			PreparedStatement consulta = conex.getConnection()
					.prepareStatement("SELECT * FROM usuario WHERE cedula = '" + cedula + "' and estado = 'A'");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				cedulaU = "" + res.getInt("cedula");
			}
			if (cedulaU.equals(cedula)) {
				Statement smt = conex.getConnection().createStatement();
				smt.executeUpdate("UPDATE usuario set estado = 'I' WHERE cedula = '" + cedula + "'");
				verificar = true;
				smt.close();
				conex.cerrarDB();
			}
			conex.cerrarDB();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return verificar;
	}

	public boolean editarUsuario(String[][] matriz) {
		boolean verificar = false;
		try {
			conex.conectarDB();
			Statement smt = conex.getConnection().createStatement();
			smt.executeUpdate("UPDATE usuario SET " + matriz[1][0] + " = '" + matriz[1][1] + "' WHERE cedula = '"
					+ matriz[1][2] + "'");
			verificar = true;
			smt.close();
			conex.cerrarDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return verificar;
	}

	public String[][] mostarInfoMascota(String idUsuario) {
		ArrayList<Mascota> listaMascotas = mascotaDAO.consultarMascotas(idUsuario);

		String[][] infoMascotas = new String[listaMascotas.size()][6];
		for (int i = 0; i < listaMascotas.size(); i++) {
			infoMascotas[i][0] = String.valueOf(listaMascotas.get(i).getIdMascota());
			infoMascotas[i][1] = listaMascotas.get(i).getNombre();
			infoMascotas[i][2] = String.valueOf(listaMascotas.get(i).getIdEspecie());
			infoMascotas[i][3] = String.valueOf(listaMascotas.get(i).getIdRaza());
			infoMascotas[i][4] = String.valueOf(listaMascotas.get(i).getIdColor());
			infoMascotas[i][5] = String.valueOf(listaMascotas.get(i).getAñoNacimiento());
		}
		return infoMascotas;
	}

	public String[][] mostarInfoUsuarios(ArrayList<Usuario> listaUsuarios) {

		String[][] infoUsuarios = new String[listaUsuarios.size()][7];
		for (int i = 0; i < listaUsuarios.size(); i++) {
			infoUsuarios[i][0] = listaUsuarios.get(i).getNombres();
			infoUsuarios[i][1] = listaUsuarios.get(i).getApellidos();
			infoUsuarios[i][2] = listaUsuarios.get(i).getCorreo();
			infoUsuarios[i][3] = listaUsuarios.get(i).getCedula();
			infoUsuarios[i][4] = listaUsuarios.get(i).getDirreccion();
			infoUsuarios[i][5] = String.valueOf(listaUsuarios.get(i).getEdad());
			infoUsuarios[i][6] = listaUsuarios.get(i).getSexo();
		}
		return infoUsuarios;
	}

	public Conexion getConex() {
		return conex;
	}

	public void setConex(Conexion conex) {
		this.conex = conex;
	}

	public MascotaDAO getMascotaDAO() {
		return mascotaDAO;
	}

	public void setMascotaDAO(MascotaDAO mascotaDAO) {
		this.mascotaDAO = mascotaDAO;
	}

	public TelefonoDAO getTelefonoDAO() {
		return telefonoDAO;
	}

	public void setTelefonoDAO(TelefonoDAO telefonoDAO) {
		this.telefonoDAO = telefonoDAO;
	}

	public Hash getSha() {
		return sha;
	}

	public void setSha(Hash sha) {
		this.sha = sha;
	}

}
