package co.edu.unbosque.model.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import co.edu.unbosque.model.Conexion;

public class FormaPagoDAO {

	private Conexion conex = new Conexion();

	public ArrayList<FormaPago> consultarFomaPagos() {
		conex.conectarDB();
		ArrayList<FormaPago> listaFormaPago = new ArrayList<FormaPago>();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM formapago");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				FormaPago formaPago = new FormaPago(res.getInt("idpago"), res.getString("nombre"),
						res.getString("descripcion"), res.getString("estado"));
				listaFormaPago.add(formaPago);
			}
			res.close();
			consulta.execute();
			consulta.close();
			conex.cerrarDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaFormaPago;
	}
}
