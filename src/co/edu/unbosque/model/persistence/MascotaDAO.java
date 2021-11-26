package co.edu.unbosque.model.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import co.edu.unbosque.model.Conexion;

public class MascotaDAO {

	private Conexion conex = new Conexion();
	private ColorDAO colorDAO;
	private EspecieDAO especieDAO;
	private RazaDAO razaDAO;

	public MascotaDAO() {
		colorDAO = new ColorDAO();
		especieDAO = new EspecieDAO();
		razaDAO = new RazaDAO();
	}

	public boolean crearMascota(Mascota mascota) {
		boolean verificar = false;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		try {
			conex.conectarDB();
			Statement smt = conex.getConnection().createStatement();
			smt.executeUpdate("INSERT INTO mascota VALUES(" + "" + mascota.getIdMascota() + ",'" + mascota.getIdDueño()
					+ "','" + mascota.getNombre() + "',(SELECT idespecie FROM especie WHERE nombre = '"
					+ mascota.getIdEspecie() + "'),(SELECT idraza FROM raza WHERE nombre  = '" + mascota.getIdRaza()
					+ "'),(SELECT idcolor FROM color WHERE nombre = '" + mascota.getIdColor() + "'),'"
					+ formato.format(mascota.getAñoNacimiento()) + "','" + mascota.getEstado() + "')");
			verificar = true;
			smt.close();
			conex.cerrarDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return verificar;
	}

	public ArrayList<Mascota> consultarMascotas(String idUsuario) {
		conex.conectarDB();
		ArrayList<Mascota> listaMascota = new ArrayList<Mascota>();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement(
					"SELECT a.idmascota as idmascota, a.nombre as nombremascosa, b.nombre as nombreespecie, c.nombre as nombreraza, d.nombre as nombrecolor, a.añonacimiento FROM mascota a, especie b, raza c, color d WHERE a.idespecie = b.idespecie and a.idraza = c.idraza and a.idcolor = d.idcolor and idusuario = '"
							+ idUsuario + "' and a.estado = 'A'");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				Mascota mascota = new Mascota(res.getInt("idmascota"), res.getString("nombremascosa"),
						res.getString("nombreespecie"), res.getString("nombreraza"), res.getString("nombrecolor"),
						res.getDate("añonacimiento"));
				listaMascota.add(mascota);
			}
			res.close();
			consulta.execute();
			consulta.close();
			conex.cerrarDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaMascota;
	}

	public ArrayList<Mascota> consultarMascotas(String[][] matriz, int posicion1) {
		conex.conectarDB();
		ArrayList<Mascota> listaMascota = new ArrayList<Mascota>();

		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement(
					"SELECT a.nombre as nombremascosa, b.nombre as nombreespecie, c.nombre as nombreraza, d.nombre as nombrecolor, a.añonacimiento, e.nombres as usuario FROM mascota a, especie b, raza c, color d, usuario "
							+ " e WHERE a.idespecie = b.idespecie and a.idraza = c.idraza and a.idcolor = d.idcolor and e.correo = a.idusuario and "
							+ matriz[posicion1][0] + " = '" + matriz[posicion1][1] + "' and a.estado = 'A'");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				Mascota mascota = new Mascota(res.getString("nombremascosa"), res.getString("nombreespecie"),
						res.getString("nombreraza"), res.getString("nombrecolor"), res.getDate("añonacimiento"),
						res.getString("usuario"));
				listaMascota.add(mascota);
			}
			res.close();
			consulta.execute();
			consulta.close();
			conex.cerrarDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaMascota;
	}

	public ArrayList<Mascota> consultarMascotas(String[][] matriz, int posicion1, int posicion2) {
		conex.conectarDB();
		ArrayList<Mascota> listaMascota = new ArrayList<Mascota>();

		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement(
					"SELECT a.nombre as nombremascosa, b.nombre as nombreespecie, c.nombre as nombreraza, d.nombre as nombrecolor, a.añonacimiento, e.nombres as usuario FROM mascota a, especie b, raza c, color d, usuario "
							+ " e WHERE a.idespecie = b.idespecie and a.idraza = c.idraza and a.idcolor = d.idcolor and e.correo = a.idusuario and "
							+ matriz[posicion1][0] + " = '" + matriz[posicion1][1] + "' and " + matriz[posicion2][0]
							+ " = '" + matriz[posicion2][1] + "' and a.estado = 'A'");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				Mascota mascota = new Mascota(res.getString("nombremascosa"), res.getString("nombreespecie"),
						res.getString("nombreraza"), res.getString("nombrecolor"), res.getDate("añonacimiento"),
						res.getString("usuario"));
				listaMascota.add(mascota);
			}
			res.close();
			consulta.execute();
			consulta.close();
			conex.cerrarDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaMascota;
	}

	public ArrayList<Mascota> consultarMascotas(String[][] matriz, int posicion1, int posicion2, int posicion3) {
		conex.conectarDB();
		ArrayList<Mascota> listaMascota = new ArrayList<Mascota>();

		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement(
					"SELECT a.nombre as nombremascosa, b.nombre as nombreespecie, c.nombre as nombreraza, d.nombre as nombrecolor, a.añonacimiento, e.nombres as usuario FROM mascota a, especie b, raza c, color d, usuario "
							+ " e WHERE a.idespecie = b.idespecie and a.idraza = c.idraza and a.idcolor = d.idcolor and e.correo = a.idusuario and "
							+ matriz[posicion1][0] + " = '" + matriz[posicion1][1] + "' and " + matriz[posicion2][0]
							+ " = '" + matriz[posicion2][1] + "' and " + matriz[posicion3][0] + " = '"
							+ matriz[posicion3][1] + "' and a.estado = 'A'");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				Mascota mascota = new Mascota(res.getString("nombremascosa"), res.getString("nombreespecie"),
						res.getString("nombreraza"), res.getString("nombrecolor"), res.getDate("añonacimiento"),
						res.getString("usuario"));
				listaMascota.add(mascota);
			}
			res.close();
			consulta.execute();
			consulta.close();
			conex.cerrarDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaMascota;
	}

	public ArrayList<Mascota> consultarMascotas(String[][] matriz, int posicion1, int posicion2, int posicion3,
			int posicion4) {
		conex.conectarDB();
		ArrayList<Mascota> listaMascota = new ArrayList<Mascota>();

		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement(
					"SELECT a.nombre as nombremascosa, b.nombre as nombreespecie, c.nombre as nombreraza, d.nombre as nombrecolor, a.añonacimiento, e.nombres as usuario FROM mascota a, especie b, raza c, color d, usuario "
							+ " e WHERE a.idespecie = b.idespecie and a.idraza = c.idraza and a.idcolor = d.idcolor and e.correo = a.idusuario and "
							+ matriz[posicion1][0] + " = '" + matriz[posicion1][1] + "' and " + matriz[posicion2][0]
							+ " = '" + matriz[posicion2][1] + "' and " + matriz[posicion3][0] + " = '"
							+ matriz[posicion3][1] + "' and " + matriz[posicion4][0] + " = '" + matriz[posicion4][1]
							+ "' and a.estado = 'A'");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				Mascota mascota = new Mascota(res.getString("nombremascosa"), res.getString("nombreespecie"),
						res.getString("nombreraza"), res.getString("nombrecolor"), res.getDate("añonacimiento"),
						res.getString("usuario"));
				listaMascota.add(mascota);
			}
			res.close();
			consulta.execute();
			consulta.close();
			conex.cerrarDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaMascota;
	}

	public ArrayList<Mascota> consultarMascotas(String[][] matriz, int posicion1, int posicion2, int posicion3,
			int posicion4, int posicion5) {
		conex.conectarDB();
		ArrayList<Mascota> listaMascota = new ArrayList<Mascota>();

		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement(
					"SELECT a.nombre as nombremascosa, b.nombre as nombreespecie, c.nombre as nombreraza, d.nombre as nombrecolor, a.añonacimiento, e.nombres as usuario FROM mascota a, especie b, raza c, color d, usuario "
							+ " e WHERE a.idespecie = b.idespecie and a.idraza = c.idraza and a.idcolor = d.idcolor and e.correo = a.idusuario and "
							+ matriz[posicion1][0] + " = '" + matriz[posicion1][1] + "' and " + matriz[posicion2][0]
							+ " = '" + matriz[posicion2][1] + "' and " + matriz[posicion3][0] + " = '"
							+ matriz[posicion3][1] + "' and " + matriz[posicion4][0] + " = '" + matriz[posicion4][1]
							+ "' and " + matriz[posicion5][0] + " = '" + matriz[posicion5][1] + "' and a.estado = 'A'");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				Mascota mascota = new Mascota(res.getString("nombremascosa"), res.getString("nombreespecie"),
						res.getString("nombreraza"), res.getString("nombrecolor"), res.getDate("añonacimiento"),
						res.getString("usuario"));
				listaMascota.add(mascota);
			}
			res.close();
			consulta.execute();
			consulta.close();
			conex.cerrarDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaMascota;
	}

	public ArrayList<Mascota> consultarMascotas(String[][] matriz) {
		conex.conectarDB();
		ArrayList<Mascota> listaMascota = new ArrayList<Mascota>();
		System.out.println(
					"SELECT a.nombre as nombremascosa, b.nombre as nombreespecie, c.nombre as nombreraza, d.nombre as nombrecolor, a.añonacimiento, e.nombres as usuario FROM mascota a, especie b, raza c, color d, usuario "
							+ " e WHERE a.idespecie = b.idespecie and a.idraza = c.idraza and a.idcolor = d.idcolor and e.correo = a.idusuario and "
							+ matriz[1][0] + " = '" + matriz[1][1] + "' and " + matriz[2][0] + " = '" + matriz[2][1]
							+ "' and " + matriz[3][0] + " = '" + matriz[3][1] + "' and " + matriz[4][0] + " = '"
							+ matriz[4][1] + "' and " + matriz[5][0] + " = '" + matriz[5][1] + "' and " + matriz[6][0]
							+ " = '" + matriz[6][1] + "' and a.estado = 'A'");
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement(
					"SELECT a.nombre as nombremascosa, b.nombre as nombreespecie, c.nombre as nombreraza, d.nombre as nombrecolor, a.añonacimiento, e.nombres as usuario FROM mascota a, especie b, raza c, color d, usuario "
							+ " e WHERE a.idespecie = b.idespecie and a.idraza = c.idraza and a.idcolor = d.idcolor and e.correo = a.idusuario and "
							+ matriz[1][0] + " = '" + matriz[1][1] + "' and " + matriz[2][0] + " = '" + matriz[2][1]
							+ "' and " + matriz[3][0] + " = '" + matriz[3][1] + "' and " + matriz[4][0] + " = '"
							+ matriz[4][1] + "' and " + matriz[5][0] + " = '" + matriz[5][1] + "' and " + matriz[6][0]
							+ " = '" + matriz[6][1] + "' and a.estado = 'A'");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				Mascota mascota = new Mascota(res.getString("nombremascosa"), res.getString("nombreespecie"),
						res.getString("nombreraza"), res.getString("nombrecolor"), res.getDate("añonacimiento"),
						res.getString("usuario"));
				listaMascota.add(mascota);
			}
			res.close();
			consulta.execute();
			consulta.close();
			conex.cerrarDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaMascota;
	}

	public ArrayList<Mascota> consultarMascotas(String idUsuario, String[][] matriz, int posicion) {
		conex.conectarDB();
		ArrayList<Mascota> listaMascota = new ArrayList<Mascota>();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement(
					"SELECT a.nombre as nombremascosa, b.nombre as nombreespecie, c.nombre as nombreraza, d.nombre as nombrecolor, a.añonacimiento FROM mascota a, especie b, raza c, color d WHERE a.idespecie = b.idespecie and a.idraza = c.idraza and a.idcolor = d.idcolor and idusuario = '"
							+ idUsuario + "' and " + matriz[posicion][0] + " = '" + matriz[posicion][1]
							+ "' and a.estado = 'A'");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				Mascota mascota = new Mascota(res.getString("nombremascosa"), res.getString("nombreespecie"),
						res.getString("nombreraza"), res.getString("nombrecolor"), res.getDate("añonacimiento"));
				listaMascota.add(mascota);
			}
			res.close();
			consulta.execute();
			consulta.close();
			conex.cerrarDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaMascota;
	}

	public ArrayList<Mascota> consultarMascotas(String idUsuario, String[][] matriz, int posicion1, int posicion2) {
		conex.conectarDB();
		ArrayList<Mascota> listaMascota = new ArrayList<Mascota>();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement(
					"SELECT a.nombre as nombremascosa, b.nombre as nombreespecie, c.nombre as nombreraza, d.nombre as nombrecolor, a.añonacimiento FROM mascota a, especie b, raza c, color d WHERE a.idespecie = b.idespecie and a.idraza = c.idraza and a.idcolor = d.idcolor and idusuario = '"
							+ idUsuario + "' and " + matriz[posicion1][0] + " = '" + matriz[posicion1][1] + "' and "
							+ matriz[posicion2][0] + " = '" + matriz[posicion2][1] + "' and a.estado = 'A'");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				Mascota mascota = new Mascota(res.getString("nombremascosa"), res.getString("nombreespecie"),
						res.getString("nombreraza"), res.getString("nombrecolor"), res.getDate("añonacimiento"));
				listaMascota.add(mascota);
			}
			res.close();
			consulta.execute();
			consulta.close();
			conex.cerrarDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaMascota;
	}

	public ArrayList<Mascota> consultarMascotas(String idUsuario, String[][] matriz, int posicion1, int posicion2,
			int posicion3) {
		conex.conectarDB();
		ArrayList<Mascota> listaMascota = new ArrayList<Mascota>();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement(
					"SELECT a.nombre as nombremascosa, b.nombre as nombreespecie, c.nombre as nombreraza, d.nombre as nombrecolor, a.añonacimiento FROM mascota a, especie b, raza c, color d WHERE a.idespecie = b.idespecie and a.idraza = c.idraza and a.idcolor = d.idcolor and idusuario = '"
							+ idUsuario + "' and " + matriz[posicion1][0] + " = '" + matriz[posicion1][1] + "' and "
							+ matriz[posicion2][0] + " = '" + matriz[posicion2][1] + "' and " + matriz[posicion3][0]
							+ " = '" + matriz[posicion3][1] + "' and a.estado = 'A'");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				Mascota mascota = new Mascota(res.getString("nombremascosa"), res.getString("nombreespecie"),
						res.getString("nombreraza"), res.getString("nombrecolor"), res.getDate("añonacimiento"));
				listaMascota.add(mascota);
			}
			res.close();
			consulta.execute();
			consulta.close();
			conex.cerrarDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaMascota;
	}

	public ArrayList<Mascota> consultarMascotas(String idUsuario, String[][] matriz, int posicion1, int posicion2,
			int posicion3, int posicion4) {
		conex.conectarDB();
		ArrayList<Mascota> listaMascota = new ArrayList<Mascota>();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement(
					"SELECT a.nombre as nombremascosa, b.nombre as nombreespecie, c.nombre as nombreraza, d.nombre as nombrecolor, a.añonacimiento FROM mascota a, especie b, raza c, color d WHERE a.idespecie = b.idespecie and a.idraza = c.idraza and a.idcolor = d.idcolor and idusuario = '"
							+ idUsuario + "' and " + matriz[posicion1][0] + " = '" + matriz[posicion1][1] + "' and "
							+ matriz[posicion2][0] + " = '" + matriz[posicion2][1] + "' and " + matriz[posicion3][0]
							+ " = '" + matriz[posicion3][1] + "' and " + matriz[posicion4][0] + " = '"
							+ matriz[posicion4][1] + "' and a.estado = 'A'");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				Mascota mascota = new Mascota(res.getString("nombremascosa"), res.getString("nombreespecie"),
						res.getString("nombreraza"), res.getString("nombrecolor"), res.getDate("añonacimiento"));
				listaMascota.add(mascota);
			}
			res.close();
			consulta.execute();
			consulta.close();
			conex.cerrarDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaMascota;
	}

	public ArrayList<Mascota> consultarMascotas(String idUsuario, String[][] matriz) {
		conex.conectarDB();
		ArrayList<Mascota> listaMascota = new ArrayList<Mascota>();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement(
					"SELECT a.nombre as nombremascosa, b.nombre as nombreespecie, c.nombre as nombreraza, d.nombre as nombrecolor, a.añonacimiento FROM mascota a, especie b, raza c, color d WHERE a.idespecie = b.idespecie and a.idraza = c.idraza and a.idcolor = d.idcolor and idusuario = '"
							+ idUsuario + "' and " + matriz[1][0] + " = '" + matriz[1][1] + "' and " + matriz[2][0]
							+ " = '" + matriz[2][1] + "' and " + matriz[3][0] + " = '" + matriz[3][1] + "' and "
							+ matriz[4][0] + " = '" + matriz[4][1] + "' and " + matriz[5][0] + " = '" + matriz[5][1]
							+ "' and a.estado = 'A'");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				Mascota mascota = new Mascota(res.getString("nombremascosa"), res.getString("nombreespecie"),
						res.getString("nombreraza"), res.getString("nombrecolor"), res.getDate("añonacimiento"));
				listaMascota.add(mascota);
			}
			res.close();
			consulta.execute();
			consulta.close();
			conex.cerrarDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaMascota;
	}

	public ArrayList<Mascota> consultarMascotas() {
		conex.conectarDB();
		ArrayList<Mascota> listaMascota = new ArrayList<Mascota>();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement(
					"SELECT a.nombre as nombremascosa, b.nombre as nombreespecie, c.nombre as nombreraza, d.nombre as nombrecolor, a.añonacimiento, e.nombres as usuario FROM mascota a, especie b, raza c, color d, usuario e WHERE a.idespecie = b.idespecie and a.idraza = c.idraza and a.idcolor = d.idcolor and e.correo = a.idusuario and a.estado = 'A'");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				Mascota mascota = new Mascota(res.getString("nombremascosa"), res.getString("nombreespecie"),
						res.getString("nombreraza"), res.getString("nombrecolor"), res.getDate("añonacimiento"),
						res.getString("usuario"));
				listaMascota.add(mascota);
			}
			res.close();
			consulta.execute();
			consulta.close();
			conex.cerrarDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaMascota;
	}

	public boolean editarMascota(String idUsuario, String[][] matriz, int posicion1) {
		boolean verificar = false;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		try {
			conex.conectarDB();
			Statement smt = conex.getConnection().createStatement();
			smt.executeUpdate("UPDATE mascota SET " + matriz[posicion1][0] + " = (SELECT " + matriz[posicion1][0]
					+ " FROM " + matriz[posicion1][2] + " WHERE " + matriz[posicion1][3] + " = '" + matriz[posicion1][1]
					+ "') WHERE idmascota = " + matriz[6][1]);
			verificar = true;
			smt.close();
			conex.cerrarDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return verificar;
	}

	public boolean editarMascota2(String idUsuario, String[][] matriz, int posicion1) {
		boolean verificar = false;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		if (posicion1 == 5) {
			try {
				conex.conectarDB();
				Statement smt = conex.getConnection().createStatement();
				smt.executeUpdate("UPDATE mascota SET " + matriz[posicion1][0] + "= '"
						+ formato.parse(matriz[posicion1][1]) + "' WHERE idmascota = " + matriz[6][1]);
				verificar = true;
				smt.close();
				conex.cerrarDB();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			try {
				conex.conectarDB();
				Statement smt = conex.getConnection().createStatement();
				smt.executeUpdate("UPDATE mascota SET " + matriz[posicion1][0] + "= '" + matriz[posicion1][1]
						+ "' WHERE idmascota = " + matriz[6][1]);
				verificar = true;
				smt.close();
				conex.cerrarDB();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return verificar;
	}

	public boolean editarMascota(String idUsuario, String[][] matriz, int posicion1, int posicion2) {
		boolean verificar = false;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		try {
			conex.conectarDB();
			Statement smt = conex.getConnection().createStatement();
			smt.executeUpdate("UPDATE mascota SET " + matriz[posicion1][0] + " = (SELECT " + matriz[posicion1][0]
					+ " FROM " + matriz[posicion1][2] + " WHERE " + matriz[posicion1][3] + " = '" + matriz[posicion1][1]
					+ "'), " + matriz[posicion2][0] + " = (SELECT " + matriz[posicion2][0] + " FROM "
					+ matriz[posicion2][2] + " WHERE " + matriz[posicion2][3] + " = '" + matriz[posicion2][1] + "')"
					+ " WHERE idmascota = " + matriz[6][1]);
			verificar = true;
			smt.close();
			conex.cerrarDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return verificar;
	}

	public boolean editarMascota2(String idUsuario, String[][] matriz, int posicion1, int posicion2) {
		boolean verificar = false;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		try {
			conex.conectarDB();
			Statement smt = conex.getConnection().createStatement();
			smt.executeUpdate("UPDATE mascota SET " + matriz[posicion1][0] + "= '" + matriz[posicion1][1] + "',"
					+ matriz[posicion2][0] + " = '" + formato.parse(matriz[posicion2][1]) + "' WHERE idmascota = "
					+ matriz[6][1]);
			verificar = true;
			smt.close();
			conex.cerrarDB();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return verificar;
	}

	public boolean editarMascota3(String idUsuario, String[][] matriz, int posicion1, int posicion2) {
		boolean verificar = false;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		try {
			conex.conectarDB();
			Statement smt = conex.getConnection().createStatement();
			smt.executeUpdate("UPDATE mascota SET " + matriz[posicion1][0] + "= '" + matriz[posicion1][1] + "',"
					+ matriz[posicion2][0] + " = (SELECT " + matriz[posicion2][0] + " FROM " + matriz[posicion2][2]
					+ " WHERE " + matriz[posicion2][3] + " = '" + matriz[posicion2][1] + "') WHERE idmascota = "
					+ matriz[6][1]);
			verificar = true;
			smt.close();
			conex.cerrarDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return verificar;
	}

	public boolean eliminarMascota(String usuario, String id) {
		String idMascota = "";
		boolean verificar = false;
		try {
			conex.conectarDB();

			PreparedStatement consulta = conex.getConnection()
					.prepareStatement("SELECT * FROM mascota WHERE idmascota = " + id + " and idusuario = '" + usuario
							+ "' and estado = 'A'");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				idMascota = "" + res.getInt("idmascota");
			}
			if (idMascota.equals(id)) {
				Statement smt = conex.getConnection().createStatement();
				smt.executeUpdate("UPDATE mascota set estado = 'I' WHERE idmascota = " + id + " and idusuario = '"
						+ usuario + "'");
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

	public boolean verificarIdMascota(int id) {
		boolean verificar = false;
		int idMascota = 0;
		try {
			conex.conectarDB();
			PreparedStatement consulta = conex.getConnection()
					.prepareStatement("SELECT idmascota FROM mascota WHERE idmascota = " + id);
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				idMascota = res.getInt("idmascota");
			}
			if (idMascota == id) {
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

	public String[][] mostarInfoMascota(ArrayList<Mascota> listaMascotas) {

		String[][] infoMascotas = new String[listaMascotas.size()][6];
		for (int i = 0; i < listaMascotas.size(); i++) {
			infoMascotas[i][0] = listaMascotas.get(i).getNombre();
			infoMascotas[i][1] = String.valueOf(listaMascotas.get(i).getIdEspecie());
			infoMascotas[i][2] = String.valueOf(listaMascotas.get(i).getIdRaza());
			infoMascotas[i][3] = String.valueOf(listaMascotas.get(i).getIdColor());
			infoMascotas[i][4] = String.valueOf(listaMascotas.get(i).getAñoNacimiento());
			infoMascotas[i][5] = String.valueOf(listaMascotas.get(i).getNombreUsuario());
		}
		return infoMascotas;
	}

	public Conexion getConex() {
		return conex;
	}

	public void setConex(Conexion conex) {
		this.conex = conex;
	}

	public ColorDAO getColorDAO() {
		return colorDAO;
	}

	public void setColorDAO(ColorDAO colorDAO) {
		this.colorDAO = colorDAO;
	}

	public EspecieDAO getEspecieDAO() {
		return especieDAO;
	}

	public void setEspecieDAO(EspecieDAO especieDAO) {
		this.especieDAO = especieDAO;
	}

	public RazaDAO getRazaDAO() {
		return razaDAO;
	}

	public void setRazaDAO(RazaDAO razaDAO) {
		this.razaDAO = razaDAO;
	}
}
