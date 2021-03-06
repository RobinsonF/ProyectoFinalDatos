package co.edu.unbosque.controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.WindowConstants;

import co.edu.unbosque.model.Clinica;
import co.edu.unbosque.model.ExceptionCedula;
import co.edu.unbosque.model.ExceptionNumero;
import co.edu.unbosque.model.ExceptionTelefono;
import co.edu.unbosque.model.persistence.Color;
import co.edu.unbosque.model.persistence.Especie;
import co.edu.unbosque.model.persistence.Factura;
import co.edu.unbosque.model.persistence.FormaPago;
import co.edu.unbosque.model.persistence.Mascota;
import co.edu.unbosque.model.persistence.Raza;
import co.edu.unbosque.model.persistence.Servicio;
import co.edu.unbosque.model.persistence.Telefono;
import co.edu.unbosque.model.persistence.Usuario;
import co.edu.unbosque.view.Vista;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class Controller implements ActionListener {

	private Vista vista;
	private Clinica clinica;
	private String usuario = "";
	int contador = 0;

	public Controller() {
		vista = new Vista(this);
		clinica = new Clinica();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		if (comando.equals(vista.getPanelLogin().getCOMANDO_CREARUSUARIO())) {
			vista.getPanelLogin().setVisible(false);
			vista.getPanelCrearUsuario().setVisible(true);
			vista.getPanelUsuario().setVisible(false);
			vista.getPanelAdministrador().setVisible(false);
			vista.getPanelEmpleado().setVisible(false);

		}
		if (comando.equals(vista.getPanelUsuario().getCOMANDO_VOLVER())) {
			volverPanelLogin();
		}
		if (comando.equals(vista.getPanelCrearUsuario().getCOMANDO_VOLVER())) {
			volverPanelLogin();
		}
		if (comando.equals(vista.getPanelAdministrador().getCOMANDO_VOLVER())) {
			volverPanelLogin();
		}
		if (comando.equals(vista.getPanelUsuario().getCOMANDO_VERMASCOTA())) {
			String[][] info = clinica.getUsuarioDAO().mostarInfoMascota(usuario);
			ArrayList<Color> colores = clinica.getUsuarioDAO().getMascotaDAO().getColorDAO().consultarColores();
			ArrayList<Especie> especies = clinica.getUsuarioDAO().getMascotaDAO().getEspecieDAO().consultarEspecies();
			ArrayList<Raza> razas = clinica.getUsuarioDAO().getMascotaDAO().getRazaDAO().consultarRazas();
			vista.getPanelUsuario().getPanelFiltro().cargarComboBox(colores, especies, razas);
			vista.getPanelUsuario().getPanelTablaMascota().limpiarPanel();
			vista.getPanelUsuario().getPanelTablaMascota().mostrarTablaMascotas(info);
			vista.getPanelUsuario().getPanelFiltroMascota().add(vista.getPanelUsuario().getPanelInformacionMascota());
			vista.getPanelUsuario().getSplitPane().setRightComponent(vista.getPanelUsuario().getPanelFiltroMascota());
			vista.getPanelUsuario().getPanelFiltro().limpiarCampos();
		}
		if (comando.equals(vista.getPanelAdministrador().getCOMANDO_VERMASCOTA())) {
			ArrayList<Mascota> listaMascota = clinica.getUsuarioDAO().getMascotaDAO().consultarMascotas();
			String[][] info = clinica.getUsuarioDAO().getMascotaDAO().mostarInfoMascota(listaMascota);
			ArrayList<Color> colores = clinica.getUsuarioDAO().getMascotaDAO().getColorDAO().consultarColores();
			ArrayList<Especie> especies = clinica.getUsuarioDAO().getMascotaDAO().getEspecieDAO().consultarEspecies();
			ArrayList<Raza> razas = clinica.getUsuarioDAO().getMascotaDAO().getRazaDAO().consultarRazas();
			vista.getPanelAdministrador().getPanelFiltroMascotaA().cargarComboBox(colores, especies, razas);
			vista.getPanelAdministrador().getPanelTablaMascota().limpiarPanel();
			vista.getPanelAdministrador().getPanelTablaMascota().mostrarTablaTodasMascotas(info);
			vista.getPanelAdministrador().getPanelInformacionMascota()
					.add(vista.getPanelAdministrador().getPanelTablaMascota(), BorderLayout.CENTER);
			vista.getPanelAdministrador().getPanelInformacionMascota()
					.add(vista.getPanelAdministrador().getPanelBotones2(), BorderLayout.PAGE_END);
			vista.getPanelAdministrador().getPanelTodoM()
					.add(vista.getPanelAdministrador().getPanelInformacionMascota());
			vista.getPanelAdministrador().getSplitPane()
					.setRightComponent(vista.getPanelAdministrador().getPanelTodoM());
		}
		if (comando.equals(vista.getPanelAdministrador().getCOMANDO_VERUSUARIOS())) {
			vista.getPanelAdministrador().getSplitPane()
					.setRightComponent(vista.getPanelAdministrador().getPanelTablaUsuario());
			ArrayList<Usuario> listaUsuario = clinica.getUsuarioDAO().consultarUsuarios();
			String[][] infoUsuario = clinica.getUsuarioDAO().mostarInfoUsuarios(listaUsuario);
			vista.getPanelAdministrador().getPanelTablaUsuario().limpiarPanel();
			vista.getPanelAdministrador().getPanelTablaUsuario().mostrarTablaClientes(infoUsuario);
			vista.getPanelAdministrador().getPanelInfoUsuario()
					.add(vista.getPanelAdministrador().getPanelTablaUsuario(), BorderLayout.CENTER);
			vista.getPanelAdministrador().getPanelInfoUsuario().add(vista.getPanelAdministrador().getPanelBotones(),
					BorderLayout.PAGE_END);
			vista.getPanelAdministrador().getPanelFiltroU().add(vista.getPanelAdministrador().getPanelInfoUsuario());
			vista.getPanelAdministrador().getSplitPane()
					.setRightComponent(vista.getPanelAdministrador().getPanelFiltroU());
		}
		if (comando.equals(vista.getPanelUsuario().getCOMANDO_AGREGARMASCOTA())) {
			vista.getPanelUsuario().getSplitPane().setRightComponent(vista.getPanelUsuario().getPanelCrearMascota());
			ArrayList<Color> colores = clinica.getUsuarioDAO().getMascotaDAO().getColorDAO().consultarColores();
			ArrayList<Especie> especies = clinica.getUsuarioDAO().getMascotaDAO().getEspecieDAO().consultarEspecies();
			ArrayList<Raza> razas = clinica.getUsuarioDAO().getMascotaDAO().getRazaDAO().consultarRazas();
			vista.getPanelUsuario().getPanelCrearMascota().cargarComboBox(colores, especies, razas);
		}
		if (comando.equals(vista.getPanelUsuario().getCOMANDO_VERINFO())) {
			vista.getPanelUsuario().getSplitPane()
					.setRightComponent(vista.getPanelUsuario().getPanelClienteInformacion());
			Usuario usuario = clinica.getUsuarioDAO().consultarUsuario(this.usuario);
			vista.getPanelUsuario().getPanelClienteInformacion().recibirInfo(usuario);
			ArrayList<Telefono> telefonos = clinica.getUsuarioDAO().getTelefonoDAO().consultarTelefonos(this.usuario);
			vista.getPanelUsuario().getPanelClienteInformacion().cargarComboBox(telefonos);
		}

		if (comando.equals(vista.getPanelUsuario().getCOMANDO_EDITAR())) {
			if (vista.getPanelUsuario().getPanelTablaMascota().verificarDatosTabla() == 1) {
				ArrayList<Color> colores = clinica.getUsuarioDAO().getMascotaDAO().getColorDAO().consultarColores();
				ArrayList<Especie> especies = clinica.getUsuarioDAO().getMascotaDAO().getEspecieDAO()
						.consultarEspecies();
				ArrayList<Raza> razas = clinica.getUsuarioDAO().getMascotaDAO().getRazaDAO().consultarRazas();
				vista.getPanelUsuario().getPanelEditarMascota().cargarComboBox(colores, especies, razas);
				vista.getPanelUsuario().getSplitPane()
						.setRightComponent(vista.getPanelUsuario().getPanelEditarMascota());
				String[] entradas = vista.getPanelUsuario().getPanelTablaMascota().obtenerDatosTablaMascota();
				vista.getPanelUsuario().getPanelEditarMascota().recibirDatosMascota(entradas[1], entradas[3],
						entradas[4], entradas[5], entradas[6], entradas[7]);
			} else {
				vista.mostrarMensajeAdvertencia("Seleccione un dato");
			}

		}

		if (comando.equals(vista.getPanelUsuario().getPanelFiltro().getCOMANDO_FILTRO())) {
			filtrarMascotaCliente();
		}

		if (comando.equals(vista.getPanelUsuario().getPanelCrearMascota().getCOMANDO_CREAR())) {
			registrarMascota();
		}

		if (comando.equals(vista.getPanelCrearUsuario().getCOMANDO_CREAR())) {
			registrarCliente();
		}

		if (comando.equals(vista.getPanelLogin().getCOMANDO_ENTRAR())) {
			validarUsuario();
		}

		if (comando.equals(vista.getPanelUsuario().getPanelEditarMascota().getCOMANDO_EDITARMASCOTA())) {
			editarInformacionMascotaCliente();
		}

		if (comando.equals(vista.getPanelUsuario().getCOMANDO_BORRAR())) {
			borrarMascotaCliente();
		}

		if (comando.equals(vista.getPanelAdministrador().getPanelFiltroUsuario().getCOMANDO_FILTRO())) {
			filtrarInfoUsuario();
		}

		if (comando.equals(vista.getPanelAdministrador().getPanelFiltroMascotaA().getCOMANDO_FILTRO())) {
			filtrarMascotaAdmin();
		}

		if (comando.equals(vista.getPanelAdministrador().getCOMANDO_BORRAR())) {
			borrarUsuario();
		}

		if (comando.equals(vista.getPanelAdministrador().getCOMANDO_BORRARM())) {
			borrarMascota();
		}

		if (comando.equals(vista.getPanelAdministrador().getCOMANDO_EDITAR())) {
			editarUsuarioAdmin();
		}

		if (comando.equals(vista.getPanelAdministrador().getCOMANDO_EDITARM())) {
			editarMascotaAdmin();
		}

		if (comando.equals(vista.getPanelAdministrador().getPanelEditarUsuario().getCOMANDO_EDITARMASCOTA())) {
			editarUsuarioCon();
		}

		if (comando.equals(vista.getPanelAdministrador().getPanelEditarMascota().getCOMANDO_DATOEDITAR())) {
			vista.getPanelAdministrador().getPanelEditarMascota().cambiarPanel();
		}

		if (comando.equals(vista.getPanelUsuario().getPanelClienteInformacion().getCOMANDO_DATOEDITAR())) {
			vista.getPanelUsuario().getPanelClienteInformacion().cambiarPanel();
		}

		if (comando.equals(vista.getPanelUsuario().getPanelEditarMascota().getCOMANDO_DATOEDITAR())) {
			vista.getPanelUsuario().getPanelEditarMascota().cambiarPanel();
		}

		if (comando.equals(vista.getPanelAdministrador().getPanelEditarMascota().getCOMANDO_EDITARMASCOTA())) {
			editarMascotaCon();
		}

		if (comando.equals(vista.getPanelAdministrador().getCOMANDO_CREAREMPLEADO())) {
			vista.getPanelAdministrador().getSplitPane()
					.setRightComponent(vista.getPanelAdministrador().getPanelCrearEmpleado());
		}

		if (comando.equals(vista.getPanelAdministrador().getPanelCrearEmpleado().getCOMANDO_CREAR())) {
			crearEmpleado();
		}

		if (comando.equals(vista.getPanelEmpleado().getCOMANDO_REGISTRARFACTURA())) {
			ArrayList<Servicio> servicios = clinica.getServicioDAO().consultarServicios();
			ArrayList<FormaPago> formaPagos = clinica.getFacturaDAO().getFormaPagoDAO().consultarFomaPagos();
			vista.getPanelEmpleado().getPanelEmpleadoServicio().cargarComboBox(servicios, formaPagos);
			vista.getPanelEmpleado().getSplitPane()
					.setRightComponent(vista.getPanelEmpleado().getPanelEmpleadoServicio());
		}

		if (comando.equals(vista.getPanelEmpleado().getCOMANDO_CERRARSESION())) {
			volverPanelLogin();
		}

		if (comando.equals(vista.getPanelEmpleado().getPanelEmpleadoServicio().getCOMANDO_REGISTRARFACTURA())) {
			realizarFactura();
		}

		if (comando.equals(vista.getPanelEmpleado().getCOMANDO_REPORTES())) {
			vista.getPanelEmpleado().getSplitPane().setRightComponent(vista.getPanelEmpleado().getPanelReporte());
		}

		if (comando.equals(vista.getPanelCliente().getCOMANDO_VERFACTURA())) {
			ArrayList<Factura> listaFactura = clinica.getFacturaDAO().consultarFacturas(this.usuario);
			ArrayList<FormaPago> listaFormas = clinica.getFacturaDAO().getFormaPagoDAO().consultarFomaPagos();
			vista.getPanelCliente().getPanelFiltroFactura().cargarComboBox(listaFormas);
			String[][] infoFactura = clinica.getFacturaDAO().mostarInfoFactura(listaFactura);
			vista.getPanelCliente().getPanelTablaFactura().limpiarPanel();
			vista.getPanelCliente().getPanelTablaFactura().mostrarTablaFactura(infoFactura);
			vista.getPanelCliente().getPanelFactura().add(vista.getPanelCliente().getPanelTablaFactura(),
					BorderLayout.CENTER);
			vista.getPanelCliente().getPanelFactura().add(vista.getPanelCliente().getBtnVerFacturaDetalle(),
					BorderLayout.PAGE_END);
			vista.getPanelCliente().getSplitPane2().setBottomComponent(vista.getPanelCliente().getPanelFactura());
			vista.getPanelCliente().getSplitPane2().setDividerLocation(150);
			vista.getPanelCliente().getSplitPane().setRightComponent(vista.getPanelCliente().getSplitPane2());
		}

		if (comando.equals(vista.getPanelAdministrador().getCOMANDO_REGISTRARSERVICIO())) {
			ArrayList<Servicio> listaServicios = clinica.getServicioDAO().consultarServicios();
			String[][] infoServicios = clinica.getServicioDAO().mostarInfoServicio(listaServicios);
			vista.getPanelAdministrador().getPanelTablaServicios().limpiarPanel();
			vista.getPanelAdministrador().getPanelTablaServicios().mostrarTablaServicios(infoServicios);
			vista.getPanelAdministrador().getSplitPane()
					.setRightComponent(vista.getPanelAdministrador().getSplitPane2());
		}

		if (comando
				.equals(vista.getPanelAdministrador().getPanelAdministradorServicio().getCOMANDO_REGISTARSERVICIO())) {
			registrarServicio();
		}

		if (comando.equals(vista.getPanelCliente().getCOMANDO_VERFACTURA2())) {
			if (vista.getPanelCliente().getPanelTablaFactura().verificarDatosTablaFactura() == 1) {
				String[] entradas = vista.getPanelCliente().getPanelTablaFactura().obtenerDatosFactura();
				String path = "Reportes\\FacturaCliente.jrxml";
				clinica.getUsuarioDAO().getConex().conectarDB();
				try {
					JasperReport reporte = JasperCompileManager.compileReport(path);
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("facturaid", entradas[1]);
					JasperPrint jPrint = JasperFillManager.fillReport(reporte, map,
							clinica.getUsuarioDAO().getConex().getConnection());
					JasperViewer viewer = new JasperViewer(jPrint, false);
					viewer.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
					viewer.setTitle("Factura");
					viewer.setVisible(true);
				} catch (JRException e1) {
					e1.printStackTrace();
				}
				clinica.getUsuarioDAO().getConex().cerrarDB();
			}

		}

		if (comando.equals(vista.getPanelEmpleado().getPanelReporte().getCOMANDO_CLIENTE())) {
			reporteClientes();
		}

		if (comando.equals(vista.getPanelEmpleado().getPanelEmpleadoServicio().getCOMANDO_AGREARSERVICIO())) {
			try {
				System.out.println(contador);
				String[] entradas = vista.getPanelEmpleado().getPanelEmpleadoServicio().verificarCampos();
				int numeroServicios = Integer.parseInt(entradas[7]);
				if (contador < numeroServicios) {
					String[] entradas2 = vista.getPanelEmpleado().getPanelEmpleadoServicio().verificarCampos2();
					if (entradas2[0].equals("0")) {
						clinica.verificarNumero(entradas[2]);
						if (clinica.getFacturaDAO().getFacturaDetalleDAO().crearFacturaDetalle("" + entradas[6],
								entradas[5], Integer.parseInt(entradas[2]))) {
							vista.mostrarMensajeInformacion("Se ha registrado el servicio");
							contador++;
						} else {
							vista.mostrarMensajeInformacion("No se ha podido generar la factura");
						}
					} else {
						vista.mostrarMensajeAdvertencia(entradas2[1]);
					}
				}
				if (contador == numeroServicios) {
					vista.getPanelEmpleado().getPanelEmpleadoServicio().limpiarCampos();
					vista.mostrarMensajeInformacion("Se ha generado correctamente la factura");
					String path = "Reportes\\FacturaCliente.jrxml";
					clinica.getUsuarioDAO().getConex().conectarDB();
					JasperReport reporte = JasperCompileManager.compileReport(path);
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("facturaid", entradas[6]);
					JasperPrint jPrint = JasperFillManager.fillReport(reporte, map,
							clinica.getUsuarioDAO().getConex().getConnection());
					JasperViewer viewer = new JasperViewer(jPrint, false);
					viewer.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
					viewer.setTitle("Factura");
					viewer.setVisible(true);

					clinica.getUsuarioDAO().getConex().cerrarDB();
					contador = 0;
				}
			} catch (JRException e1) {
				e1.printStackTrace();
			} catch (ExceptionNumero e1) {
				vista.mostrarMensajeError(e1.getMessage());
			}
		}

		if (comando.equals(vista.getPanelEmpleado().getPanelReporte().getCOMANDO_FACTURA())) {
			reporteFacturas();
		}

		if (comando.equals((vista.getPanelEmpleado().getPanelReporte().getCOMANDO_MASCOTA()))) {
			reportesMascotas();
		}

		if (comando.equals(vista.getPanelCliente().getPanelFiltroFactura().getCOMANDO_FILTRO())) {
			filtrarFactura();
		}

		if (comando.equals(vista.getPanelAdministrador().getPanelFiltroServicio().getCOMANDO_FILTRO())) {
			filtrarServicio();
		}

		if (comando.equals(vista.getPanelAdministrador().getCOMANDO_AGREGARSERVICIO())) {
			vista.getPanelAdministrador().getSplitPane()
					.setRightComponent(vista.getPanelAdministrador().getPanelAdministradorServicio());
		}

		if (comando.equals(vista.getPanelAdministrador().getCOMANDO_ELIMINARSERVICIO())) {
			eliminarServicio();
		}

		if (comando.equals(vista.getPanelAdministrador().getPanelEditarServicio().getCOMANDO_EDITAROPCION())) {
			vista.getPanelAdministrador().getPanelEditarServicio().cambiarPanel();
		}

		if (comando.equals(vista.getPanelAdministrador().getPanelEditarServicio().getCOMANDO_EDITARSERVICIO())) {
			editarServicio();
		}

		if (comando.equals(vista.getPanelAdministrador().getCOMANDO_EDITARSERVICIO())) {
			if (vista.getPanelAdministrador().getPanelTablaServicios().verificarDatosTablaFactura() == 1) {
				String[] entradas = vista.getPanelAdministrador().getPanelTablaServicios().obtenerDatosServicio();
				if (entradas[0].equals("0")) {
					vista.getPanelAdministrador().getPanelEditarServicio().recibirDatos(entradas[1], entradas[2],
							entradas[3]);
					vista.getPanelAdministrador().getSplitPane()
							.setRightComponent(vista.getPanelAdministrador().getPanelEditarServicio());
				} else {
					vista.mostrarMensajeInformacion(entradas[1]);
				}
			} else {
				vista.mostrarMensajeInformacion("Seleccione un dato");
			}
		}

	}

	public void registrarCliente() {
		try {
			String[] entradas = vista.getPanelCrearUsuario().verificarEntradas();
			if (entradas[0].equals("0")) {
				clinica.verificarCorreo(entradas[1]);
				clinica.verificarNumero(entradas[9]);
				clinica.verficarCedula(entradas[2]);
				clinica.verficarTelefono(entradas[11]);
				clinica.verificarContra(entradas[3]);
				if (clinica.getUsuarioDAO().verificarIdUsuario(entradas[1])) {
					vista.mostrarMensajeAdvertencia("El correo " + entradas[1] + " ya se encuentra en uso");
				} else {
					String pass = clinica.getUsuarioDAO().getSha().shaEncode(entradas[3]);
					Usuario usuario = new Usuario(entradas[1], 2, entradas[2], pass, entradas[4] + " " + entradas[5],
							entradas[6] + " " + entradas[7], entradas[8], Integer.parseInt(entradas[9]), entradas[10],
							"A");
					if (clinica.getUsuarioDAO().crearUsuario(usuario)) {
						vista.getPanelCrearUsuario().limpiarCampos();
						Telefono telefono = new Telefono(usuario.getCorreo(), entradas[11], "A");
						if (clinica.getUsuarioDAO().getTelefonoDAO().crearTelefono(telefono)) {
							vista.mostrarMensajeInformacion("Se ha registrado el cliente");
						} else {
							vista.mostrarMensajeInformacion(
									"No se ha podido registrar el cliente, verifique el n?mero de telefono");
						}
					} else {
						vista.mostrarMensajeInformacion("No se ha podido registrar el cliente");
					}
				}
			} else {
				vista.mostrarMensajeAdvertencia(entradas[1]);
			}
		} catch (ExceptionNumero e1) {
			vista.mostrarMensajeError(e1.getMessage());
		} catch (ExceptionCedula e1) {
			vista.mostrarMensajeError(e1.getMessage());
		} catch (ExceptionTelefono e1) {
			vista.mostrarMensajeError(e1.getMessage());
		} catch (Exception e1) {

		}
	}

	public void registrarMascota() {
		try {
			String[] entradas = vista.getPanelUsuario().getPanelCrearMascota().verificarEntradas();
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			if (entradas[0].equals("0")) {
				Date date = formato.parse(entradas[5]);
				Mascota mascota = new Mascota(usuario, entradas[1], entradas[2], entradas[3], entradas[4], date, "A");
				if (clinica.getUsuarioDAO().getMascotaDAO().crearMascota(mascota)) {
					vista.getPanelUsuario().getPanelCrearMascota().limpiarCampos();
					vista.mostrarMensajeInformacion("Se ha reistrado tu mascota");
				} else {
					vista.mostrarMensajeInformacion("Lo sentimos no se ha podido realizar el reistro de tu mascota");
				}

			} else {
				vista.mostrarMensajeAdvertencia(entradas[1]);
			}
		} catch (ParseException e1) {
		}
	}

	public void validarUsuario() {
		String[] entradas = vista.getPanelLogin().verificarEntradas();
		if (entradas[0].equals("0")) {
			String[] resultado = clinica.getUsuarioDAO().verificarContra(entradas[1], entradas[2]);
			if (Boolean.parseBoolean(resultado[0])) {
				vista.mostrarMensajeInformacion("Bienvenido " + resultado[2]);
				vista.getPanelLogin().limpiarCampos();
				usuario = entradas[1];
				if (Integer.parseInt(resultado[1]) == 1) {
					vista.getPanelAdministrador().setVisible(true);
					vista.getPanelUsuario().setVisible(false);
					vista.getPanelLogin().setVisible(false);
					vista.getPanelCrearUsuario().setVisible(false);
					vista.getPanelEmpleado().setVisible(false);
				}
				if (Integer.parseInt(resultado[1]) == 2) {
					vista.getPanelUsuario().getSplitPane()
							.setRightComponent(vista.getPanelUsuario().getPanelInicioCliente());
					vista.getPanelAdministrador().setVisible(false);
					vista.getPanelUsuario().setVisible(true);
					vista.getPanelLogin().setVisible(false);
					vista.getPanelCrearUsuario().setVisible(false);
					vista.getPanelEmpleado().setVisible(false);
				}
				if (Integer.parseInt(resultado[1]) == 3) {
					vista.getPanelAdministrador().setVisible(false);
					vista.getPanelUsuario().setVisible(false);
					vista.getPanelLogin().setVisible(false);
					vista.getPanelCrearUsuario().setVisible(false);
					vista.getPanelEmpleado().setVisible(true);
				}

			} else {
				vista.mostrarMensajeInformacion("Usuario no valido");
			}

		} else {
			vista.mostrarMensajeAdvertencia(entradas[1]);
		}
	}

	public void filtrarMascotaCliente() {
//		try {
		String[][] entradas = vista.getPanelUsuario().getPanelFiltro().verificarCampos();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		if (entradas[0][0].equals("0")) {

			int contador = 0;

			for (int i = 1; i < entradas.length; i++) {
				if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
					contador++;
				}
			}

			if (contador == 1) {
				int k = 0;

				for (int i = 1; i < entradas.length; i++) {
					if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
						k = i;
						break;
					}
				}
				ArrayList<Mascota> listaMascota = clinica.getUsuarioDAO().getMascotaDAO()
						.consultarMascotas(this.usuario, entradas, k);
				String[][] info = clinica.getUsuarioDAO().getMascotaDAO().mostarInfoMascota(listaMascota);
				vista.getPanelUsuario().getPanelTablaMascota().limpiarPanel();
				vista.getPanelUsuario().getPanelTablaMascota().mostrarTablaMascotas(info);
				vista.getPanelUsuario().getPanelFiltroMascota()
						.add(vista.getPanelUsuario().getPanelInformacionMascota());
				vista.getPanelUsuario().getSplitPane()
						.setRightComponent(vista.getPanelUsuario().getPanelFiltroMascota());
			}
			if (contador == 2) {
				int j = 0;
				int k = 0;
				for (int i = 1; i < entradas.length; i++) {
					if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
						j = i;
						break;
					}
				}
				for (int i = j + 1; i < entradas.length; i++) {
					if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
						k = i;
						break;
					}
				}
				ArrayList<Mascota> listaMascota = clinica.getUsuarioDAO().getMascotaDAO()
						.consultarMascotas(this.usuario, entradas, j, k);
				String[][] info = clinica.getUsuarioDAO().getMascotaDAO().mostarInfoMascota(listaMascota);
				vista.getPanelUsuario().getPanelTablaMascota().limpiarPanel();
				vista.getPanelUsuario().getPanelTablaMascota().mostrarTablaMascotas(info);
				vista.getPanelUsuario().getPanelFiltroMascota()
						.add(vista.getPanelUsuario().getPanelInformacionMascota());
				vista.getPanelUsuario().getSplitPane()
						.setRightComponent(vista.getPanelUsuario().getPanelFiltroMascota());
			}
			if (contador == 3) {
				int j = 0;
				int k = 0;
				int l = 0;
				for (int i = 1; i < entradas.length; i++) {
					if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
						j = i;
						break;
					}
				}
				for (int i = j + 1; i < entradas.length; i++) {
					if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
						k = i;
						break;
					}
				}
				for (int i = k + 1; i < entradas.length; i++) {
					if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
						l = i;
						break;
					}
				}
				ArrayList<Mascota> listaMascota = clinica.getUsuarioDAO().getMascotaDAO()
						.consultarMascotas(this.usuario, entradas, j, k, l);
				String[][] info = clinica.getUsuarioDAO().getMascotaDAO().mostarInfoMascota(listaMascota);
				vista.getPanelUsuario().getPanelTablaMascota().limpiarPanel();
				vista.getPanelUsuario().getPanelTablaMascota().mostrarTablaMascotas(info);
				vista.getPanelUsuario().getPanelFiltroMascota()
						.add(vista.getPanelUsuario().getPanelInformacionMascota());
				vista.getPanelUsuario().getSplitPane()
						.setRightComponent(vista.getPanelUsuario().getPanelFiltroMascota());
			}
			if (contador == 4) {
				int j = 0;
				int k = 0;
				int l = 0;
				int m = 0;
				for (int i = 1; i < entradas.length; i++) {
					if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
						j = i;
						break;
					}
				}
				for (int i = j + 1; i < entradas.length; i++) {
					if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
						k = i;
						break;
					}
				}
				for (int i = k + 1; i < entradas.length; i++) {
					if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
						l = i;
						break;
					}
				}
				for (int i = l + 1; i < entradas.length; i++) {
					if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
						m = i;
						break;
					}
				}
				ArrayList<Mascota> listaMascota = clinica.getUsuarioDAO().getMascotaDAO()
						.consultarMascotas(this.usuario, entradas, j, k, l, m);
				String[][] info = clinica.getUsuarioDAO().getMascotaDAO().mostarInfoMascota(listaMascota);
				vista.getPanelUsuario().getPanelTablaMascota().limpiarPanel();
				vista.getPanelUsuario().getPanelTablaMascota().mostrarTablaMascotas(info);
				vista.getPanelUsuario().getPanelFiltroMascota()
						.add(vista.getPanelUsuario().getPanelInformacionMascota());
				vista.getPanelUsuario().getSplitPane()
						.setRightComponent(vista.getPanelUsuario().getPanelFiltroMascota());
			}
			if (contador == 5) {
				ArrayList<Mascota> listaMascota = clinica.getUsuarioDAO().getMascotaDAO()
						.consultarMascotas(this.usuario, entradas);
				String[][] info = clinica.getUsuarioDAO().getMascotaDAO().mostarInfoMascota(listaMascota);
				vista.getPanelUsuario().getPanelTablaMascota().limpiarPanel();
				vista.getPanelUsuario().getPanelTablaMascota().mostrarTablaMascotas(info);
				vista.getPanelUsuario().getPanelFiltroMascota()
						.add(vista.getPanelUsuario().getPanelInformacionMascota());
				vista.getPanelUsuario().getSplitPane()
						.setRightComponent(vista.getPanelUsuario().getPanelFiltroMascota());
			}

		} else {
			vista.mostrarMensajeAdvertencia(entradas[0][1]);
		}
//		} catch (ParseException e1) {
//		}
	}

	public void borrarMascotaCliente() {
		if (vista.getPanelUsuario().getPanelTablaMascota().verificarDatosTabla() == 1) {
			String[] entradas = vista.getPanelUsuario().getPanelTablaMascota().obtenerDatosTablaMascotaUsuario();
			int confirmar = vista.mostarMensajeConfirmar("Seguro desea eliminar a esta mascota");
			if (confirmar == 0) {
				if (clinica.getUsuarioDAO().getMascotaDAO().eliminarMascota(this.usuario, entradas[1])) {
					String[][] info = clinica.getUsuarioDAO().mostarInfoMascota(usuario);
					vista.getPanelUsuario().getPanelTablaMascota().limpiarPanel();
					vista.getPanelUsuario().getPanelTablaMascota().mostrarTablaMascotas(info);
					vista.getPanelUsuario().getPanelFiltroMascota()
							.add(vista.getPanelUsuario().getPanelInformacionMascota());
					vista.getPanelUsuario().getSplitPane()
							.setRightComponent(vista.getPanelUsuario().getPanelFiltroMascota());
					vista.getPanelUsuario().getPanelFiltro().limpiarCampos();
					vista.mostrarMensajeInformacion(entradas[2]);
				} else {
					vista.mostrarMensajeInformacion("No se ha podido eliminar al usuario seleccionado");
				}
			} else if (confirmar == 1) {
				vista.mostrarMensajeInformacion("Gracias por confirmar");
			} else {
				vista.mostrarMensajeInformacion("Gracias");
			}

		} else {
			vista.mostrarMensajeAdvertencia("Seleccione al menos un dato");
		}
	}

	public void volverPanelLogin() {
		vista.getPanelLogin().setVisible(true);
		vista.getPanelCrearUsuario().setVisible(false);
		vista.getPanelUsuario().setVisible(false);
		vista.getPanelAdministrador().setVisible(false);
		vista.getPanelEmpleado().setVisible(false);
	}

	public void filtrarInfoUsuario() {
		String[][] entradas = vista.getPanelAdministrador().getPanelFiltroUsuario().verificarCampos();
		if (entradas[0][0].equals("0")) {
			try {
				clinica.verificarNumero(entradas[4][1]);
				clinica.verificarNumero(entradas[3][1]);
				int contador = 0;

				for (int i = 1; i < entradas.length; i++) {
					if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
						contador++;
					}
				}

				if (contador == 1) {
					int k = 0;

					for (int i = 1; i < entradas.length; i++) {
						if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
							k = i;
							break;
						}
					}
					ArrayList<Usuario> listaUsuario = clinica.getUsuarioDAO().consultarUsuarios(entradas, k);
					String[][] info = clinica.getUsuarioDAO().mostarInfoUsuarios(listaUsuario);
					vista.getPanelAdministrador().getPanelTablaUsuario().limpiarPanel();
					vista.getPanelAdministrador().getPanelTablaUsuario().mostrarTablaClientes(info);
					vista.getPanelAdministrador().getPanelInfoUsuario()
							.add(vista.getPanelAdministrador().getPanelTablaUsuario(), BorderLayout.CENTER);
					vista.getPanelAdministrador().getPanelInfoUsuario()
							.add(vista.getPanelAdministrador().getPanelBotones(), BorderLayout.PAGE_END);
					vista.getPanelAdministrador().getPanelFiltroU()
							.add(vista.getPanelAdministrador().getPanelInfoUsuario());
					vista.getPanelAdministrador().getSplitPane()
							.setRightComponent(vista.getPanelAdministrador().getPanelFiltroU());
				}
				if (contador == 2) {
					int j = 0;
					int k = 0;

					for (int i = 1; i < entradas.length; i++) {
						if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
							j = i;
							break;
						}
					}
					for (int i = j + 1; i < entradas.length; i++) {
						if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
							k = i;
							break;
						}
					}
					ArrayList<Usuario> listaUsuario = clinica.getUsuarioDAO().consultarUsuarios(entradas, j, k);
					String[][] info = clinica.getUsuarioDAO().mostarInfoUsuarios(listaUsuario);
					vista.getPanelAdministrador().getPanelTablaUsuario().limpiarPanel();
					vista.getPanelAdministrador().getPanelTablaUsuario().mostrarTablaClientes(info);
					vista.getPanelAdministrador().getPanelInfoUsuario()
							.add(vista.getPanelAdministrador().getPanelTablaUsuario(), BorderLayout.CENTER);
					vista.getPanelAdministrador().getPanelInfoUsuario()
							.add(vista.getPanelAdministrador().getPanelBotones(), BorderLayout.PAGE_END);
					vista.getPanelAdministrador().getPanelFiltroU()
							.add(vista.getPanelAdministrador().getPanelInfoUsuario());
					vista.getPanelAdministrador().getSplitPane()
							.setRightComponent(vista.getPanelAdministrador().getPanelFiltroU());
				}
				if (contador == 3) {
					int j = 0;
					int k = 0;
					int l = 0;

					for (int i = 1; i < entradas.length; i++) {
						if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
							j = i;
							break;
						}
					}
					for (int i = j + 1; i < entradas.length; i++) {
						if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
							k = i;
							break;
						}
					}
					for (int i = k + 1; i < entradas.length; i++) {
						if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
							l = i;
							break;
						}
					}
					ArrayList<Usuario> listaUsuario = clinica.getUsuarioDAO().consultarUsuarios(entradas, j, k, l);
					String[][] info = clinica.getUsuarioDAO().mostarInfoUsuarios(listaUsuario);
					vista.getPanelAdministrador().getPanelTablaUsuario().limpiarPanel();
					vista.getPanelAdministrador().getPanelTablaUsuario().mostrarTablaClientes(info);
					vista.getPanelAdministrador().getPanelInfoUsuario()
							.add(vista.getPanelAdministrador().getPanelTablaUsuario(), BorderLayout.CENTER);
					vista.getPanelAdministrador().getPanelInfoUsuario()
							.add(vista.getPanelAdministrador().getPanelBotones(), BorderLayout.PAGE_END);
					vista.getPanelAdministrador().getPanelFiltroU()
							.add(vista.getPanelAdministrador().getPanelInfoUsuario());
					vista.getPanelAdministrador().getSplitPane()
							.setRightComponent(vista.getPanelAdministrador().getPanelFiltroU());
				}
				if (contador == 4) {
					int j = 0;
					int k = 0;
					int l = 0;
					int m = 0;

					for (int i = 1; i < entradas.length; i++) {
						if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
							j = i;
							break;
						}
					}
					for (int i = j + 1; i < entradas.length; i++) {
						if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
							k = i;
							break;
						}
					}
					for (int i = k + 1; i < entradas.length; i++) {
						if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
							l = i;
							break;
						}
					}
					for (int i = l + 1; i < entradas.length; i++) {
						if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
							m = i;
							break;
						}
					}
					ArrayList<Usuario> listaUsuario = clinica.getUsuarioDAO().consultarUsuarios(entradas, j, k, l, m);
					String[][] info = clinica.getUsuarioDAO().mostarInfoUsuarios(listaUsuario);
					vista.getPanelAdministrador().getPanelTablaUsuario().limpiarPanel();
					vista.getPanelAdministrador().getPanelTablaUsuario().mostrarTablaClientes(info);
					vista.getPanelAdministrador().getPanelInfoUsuario()
							.add(vista.getPanelAdministrador().getPanelTablaUsuario(), BorderLayout.CENTER);
					vista.getPanelAdministrador().getPanelInfoUsuario()
							.add(vista.getPanelAdministrador().getPanelBotones(), BorderLayout.PAGE_END);
					vista.getPanelAdministrador().getPanelFiltroU()
							.add(vista.getPanelAdministrador().getPanelInfoUsuario());
					vista.getPanelAdministrador().getSplitPane()
							.setRightComponent(vista.getPanelAdministrador().getPanelFiltroU());
				}

				if (contador == 5) {
					ArrayList<Usuario> listaUsuario = clinica.getUsuarioDAO().consultarUsuarios(entradas);
					String[][] info = clinica.getUsuarioDAO().mostarInfoUsuarios(listaUsuario);
					vista.getPanelAdministrador().getPanelTablaUsuario().limpiarPanel();
					vista.getPanelAdministrador().getPanelTablaUsuario().mostrarTablaClientes(info);
					vista.getPanelAdministrador().getPanelInfoUsuario()
							.add(vista.getPanelAdministrador().getPanelTablaUsuario(), BorderLayout.CENTER);
					vista.getPanelAdministrador().getPanelInfoUsuario()
							.add(vista.getPanelAdministrador().getPanelBotones(), BorderLayout.PAGE_END);
					vista.getPanelAdministrador().getPanelFiltroU()
							.add(vista.getPanelAdministrador().getPanelInfoUsuario());
					vista.getPanelAdministrador().getSplitPane()
							.setRightComponent(vista.getPanelAdministrador().getPanelFiltroU());
				}
			} catch (ExceptionNumero e1) {
				vista.mostrarMensajeError(e1.getMessage());
			}
		} else {
			vista.mostrarMensajeAdvertencia(entradas[0][1]);
		}
	}

	public void filtrarMascotaAdmin() {
		String[][] entradas = vista.getPanelAdministrador().getPanelFiltroMascotaA().verificarCampos();
		if (entradas[0][0].equals("0")) {
			int contador = 0;

			for (int i = 1; i < entradas.length; i++) {
				if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
					contador++;
				}
			}

			if (contador == 1) {
				int k = 0;

				for (int i = 1; i < entradas.length; i++) {
					if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
						k = i;
						break;
					}
				}
				ArrayList<Mascota> listaMascota = clinica.getUsuarioDAO().getMascotaDAO().consultarMascotas(entradas,
						k);
				String[][] info = clinica.getUsuarioDAO().getMascotaDAO().mostarInfoMascota(listaMascota);
				vista.getPanelAdministrador().getPanelTablaMascota().limpiarPanel();
				vista.getPanelAdministrador().getPanelTablaMascota().mostrarTablaTodasMascotas(info);
				vista.getPanelAdministrador().getPanelInformacionMascota()
						.add(vista.getPanelAdministrador().getPanelTablaMascota(), BorderLayout.CENTER);
				vista.getPanelAdministrador().getPanelInformacionMascota()
						.add(vista.getPanelAdministrador().getPanelBotones2(), BorderLayout.PAGE_END);
				vista.getPanelAdministrador().getPanelTodoM()
						.add(vista.getPanelAdministrador().getPanelInformacionMascota());
				vista.getPanelAdministrador().getSplitPane()
						.setRightComponent(vista.getPanelAdministrador().getPanelTodoM());
			}

			if (contador == 2) {
				int j = 0;
				int k = 0;

				for (int i = 1; i < entradas.length; i++) {
					if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
						j = i;
						break;
					}
				}

				for (int i = j + 1; i < entradas.length; i++) {
					if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
						k = i;
						break;
					}
				}
				ArrayList<Mascota> listaMascota = clinica.getUsuarioDAO().getMascotaDAO().consultarMascotas(entradas, j,
						k);
				String[][] info = clinica.getUsuarioDAO().getMascotaDAO().mostarInfoMascota(listaMascota);
				vista.getPanelAdministrador().getPanelTablaMascota().limpiarPanel();
				vista.getPanelAdministrador().getPanelTablaMascota().mostrarTablaTodasMascotas(info);
				vista.getPanelAdministrador().getPanelInformacionMascota()
						.add(vista.getPanelAdministrador().getPanelTablaMascota(), BorderLayout.CENTER);
				vista.getPanelAdministrador().getPanelInformacionMascota()
						.add(vista.getPanelAdministrador().getPanelBotones2(), BorderLayout.PAGE_END);
				vista.getPanelAdministrador().getPanelTodoM()
						.add(vista.getPanelAdministrador().getPanelInformacionMascota());
				vista.getPanelAdministrador().getSplitPane()
						.setRightComponent(vista.getPanelAdministrador().getPanelTodoM());
			}

			if (contador == 3) {
				int j = 0;
				int k = 0;
				int l = 0;

				for (int i = 1; i < entradas.length; i++) {
					if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
						j = i;
						break;
					}
				}

				for (int i = j + 1; i < entradas.length; i++) {
					if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
						k = i;
						break;
					}
				}

				for (int i = k + 1; i < entradas.length; i++) {
					if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
						l = i;
						break;
					}
				}
				ArrayList<Mascota> listaMascota = clinica.getUsuarioDAO().getMascotaDAO().consultarMascotas(entradas, j,
						k, l);
				String[][] info = clinica.getUsuarioDAO().getMascotaDAO().mostarInfoMascota(listaMascota);
				vista.getPanelAdministrador().getPanelTablaMascota().limpiarPanel();
				vista.getPanelAdministrador().getPanelTablaMascota().mostrarTablaTodasMascotas(info);
				vista.getPanelAdministrador().getPanelInformacionMascota()
						.add(vista.getPanelAdministrador().getPanelTablaMascota(), BorderLayout.CENTER);
				vista.getPanelAdministrador().getPanelInformacionMascota()
						.add(vista.getPanelAdministrador().getPanelBotones2(), BorderLayout.PAGE_END);
				vista.getPanelAdministrador().getPanelTodoM()
						.add(vista.getPanelAdministrador().getPanelInformacionMascota());
				vista.getPanelAdministrador().getSplitPane()
						.setRightComponent(vista.getPanelAdministrador().getPanelTodoM());
			}

			if (contador == 4) {
				int j = 0;
				int k = 0;
				int l = 0;
				int m = 0;

				for (int i = 1; i < entradas.length; i++) {
					if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
						j = i;
						break;
					}
				}

				for (int i = j + 1; i < entradas.length; i++) {
					if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
						k = i;
						break;
					}
				}

				for (int i = k + 1; i < entradas.length; i++) {
					if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
						l = i;
						break;
					}
				}

				for (int i = l + 1; i < entradas.length; i++) {
					if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
						m = i;
						break;
					}
				}
				ArrayList<Mascota> listaMascota = clinica.getUsuarioDAO().getMascotaDAO().consultarMascotas(entradas, j,
						k, l, m);
				String[][] info = clinica.getUsuarioDAO().getMascotaDAO().mostarInfoMascota(listaMascota);
				vista.getPanelAdministrador().getPanelTablaMascota().limpiarPanel();
				vista.getPanelAdministrador().getPanelTablaMascota().mostrarTablaTodasMascotas(info);
				vista.getPanelAdministrador().getPanelInformacionMascota()
						.add(vista.getPanelAdministrador().getPanelTablaMascota(), BorderLayout.CENTER);
				vista.getPanelAdministrador().getPanelInformacionMascota()
						.add(vista.getPanelAdministrador().getPanelBotones2(), BorderLayout.PAGE_END);
				vista.getPanelAdministrador().getPanelTodoM()
						.add(vista.getPanelAdministrador().getPanelInformacionMascota());
				vista.getPanelAdministrador().getSplitPane()
						.setRightComponent(vista.getPanelAdministrador().getPanelTodoM());
			}

			if (contador == 5) {
				int j = 0;
				int k = 0;
				int l = 0;
				int m = 0;
				int n = 0;

				for (int i = 1; i < entradas.length; i++) {
					if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
						j = i;
						break;
					}
				}

				for (int i = j + 1; i < entradas.length; i++) {
					if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
						k = i;
						break;
					}
				}

				for (int i = k + 1; i < entradas.length; i++) {
					if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
						l = i;
						break;
					}
				}

				for (int i = l + 1; i < entradas.length; i++) {
					if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
						m = i;
						break;
					}
				}

				for (int i = m + 1; i < entradas.length; i++) {
					if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
						n = i;
						break;
					}
				}
				ArrayList<Mascota> listaMascota = clinica.getUsuarioDAO().getMascotaDAO().consultarMascotas(entradas, j,
						k, l, m, n);
				String[][] info = clinica.getUsuarioDAO().getMascotaDAO().mostarInfoMascota(listaMascota);
				vista.getPanelAdministrador().getPanelTablaMascota().limpiarPanel();
				vista.getPanelAdministrador().getPanelTablaMascota().mostrarTablaTodasMascotas(info);
				vista.getPanelAdministrador().getPanelInformacionMascota()
						.add(vista.getPanelAdministrador().getPanelTablaMascota(), BorderLayout.CENTER);
				vista.getPanelAdministrador().getPanelInformacionMascota()
						.add(vista.getPanelAdministrador().getPanelBotones2(), BorderLayout.PAGE_END);
				vista.getPanelAdministrador().getPanelTodoM()
						.add(vista.getPanelAdministrador().getPanelInformacionMascota());
				vista.getPanelAdministrador().getSplitPane()
						.setRightComponent(vista.getPanelAdministrador().getPanelTodoM());
			}

			if (contador == 6) {

				ArrayList<Mascota> listaMascota = clinica.getUsuarioDAO().getMascotaDAO().consultarMascotas(entradas);
				String[][] info = clinica.getUsuarioDAO().getMascotaDAO().mostarInfoMascota(listaMascota);
				vista.getPanelAdministrador().getPanelTablaMascota().limpiarPanel();
				vista.getPanelAdministrador().getPanelTablaMascota().mostrarTablaTodasMascotas(info);
				vista.getPanelAdministrador().getPanelInformacionMascota()
						.add(vista.getPanelAdministrador().getPanelTablaMascota(), BorderLayout.CENTER);
				vista.getPanelAdministrador().getPanelInformacionMascota()
						.add(vista.getPanelAdministrador().getPanelBotones2(), BorderLayout.PAGE_END);
				vista.getPanelAdministrador().getPanelTodoM()
						.add(vista.getPanelAdministrador().getPanelInformacionMascota());
				vista.getPanelAdministrador().getSplitPane()
						.setRightComponent(vista.getPanelAdministrador().getPanelTodoM());
			}

		} else {
			vista.mostrarMensajeAdvertencia(entradas[0][1]);
		}
	}

	public void borrarUsuario() {
		if (vista.getPanelAdministrador().getPanelTablaUsuario().verificarDatosTabla() == 1) {
			String[] entradas = vista.getPanelAdministrador().getPanelTablaUsuario().obtenerDatosTabla();
			int confirmar = vista.mostarMensajeConfirmar("Seguro desea eliminar a este usuario");
			if (confirmar == 0) {
				if (clinica.getUsuarioDAO().eliminarUsuario(entradas[1])) {
					ArrayList<Usuario> listaUsuario = clinica.getUsuarioDAO().consultarUsuarios();
					String[][] infoUsuario = clinica.getUsuarioDAO().mostarInfoUsuarios(listaUsuario);
					vista.getPanelAdministrador().getPanelTablaUsuario().limpiarPanel();
					vista.getPanelAdministrador().getPanelTablaUsuario().mostrarTablaClientes(infoUsuario);
					vista.getPanelAdministrador().getPanelInfoUsuario()
							.add(vista.getPanelAdministrador().getPanelTablaUsuario(), BorderLayout.CENTER);
					vista.getPanelAdministrador().getPanelInfoUsuario()
							.add(vista.getPanelAdministrador().getPanelBotones(), BorderLayout.PAGE_END);
					vista.getPanelAdministrador().getPanelFiltroU()
							.add(vista.getPanelAdministrador().getPanelInfoUsuario());
					vista.getPanelAdministrador().getSplitPane()
							.setRightComponent(vista.getPanelAdministrador().getPanelFiltroU());
					vista.mostrarMensajeInformacion(entradas[2]);
				} else {
					vista.mostrarMensajeInformacion("No se ha podido eliminar al usuario seleccionado");
				}
			} else if (confirmar == 1) {
				vista.mostrarMensajeInformacion("Gracias por confirmar");
			} else {
				vista.mostrarMensajeInformacion("Gracias");
			}

		} else {
			vista.mostrarMensajeAdvertencia("Seleccione al menos un dato");
		}
	}

	public void borrarMascota() {
		if (vista.getPanelAdministrador().getPanelTablaMascota().verificarDatosTabla() == 1) {
			String[] entradas = vista.getPanelAdministrador().getPanelTablaMascota().obtenerDatosTablaMascota();
			int confirmar = vista.mostarMensajeConfirmar("Seguro desea eliminar a esta mascota");
			if (confirmar == 0) {
				if (clinica.getUsuarioDAO().getMascotaDAO().eliminarMascota(entradas[1])) {
					ArrayList<Mascota> listaMascota = clinica.getUsuarioDAO().getMascotaDAO().consultarMascotas();
					String[][] info = clinica.getUsuarioDAO().getMascotaDAO().mostarInfoMascota(listaMascota);
					vista.getPanelAdministrador().getPanelTablaMascota().limpiarPanel();
					vista.getPanelAdministrador().getPanelTablaMascota().mostrarTablaTodasMascotas(info);
					vista.getPanelAdministrador().getPanelInformacionMascota()
							.add(vista.getPanelAdministrador().getPanelTablaMascota(), BorderLayout.CENTER);
					vista.getPanelAdministrador().getPanelInformacionMascota()
							.add(vista.getPanelAdministrador().getPanelBotones2(), BorderLayout.PAGE_END);
					vista.getPanelAdministrador().getPanelTodoM()
							.add(vista.getPanelAdministrador().getPanelInformacionMascota());
					vista.getPanelAdministrador().getSplitPane()
							.setRightComponent(vista.getPanelAdministrador().getPanelTodoM());
					vista.mostrarMensajeInformacion(entradas[2]);
				} else {
					vista.mostrarMensajeInformacion("No se ha podido eliminar la mascota seleccionado");
				}
			} else if (confirmar == 1) {
				vista.mostrarMensajeInformacion("Gracias por confirmar");
			} else {
				vista.mostrarMensajeInformacion("Gracias");
			}
		} else {
			vista.mostrarMensajeAdvertencia("Seleccione al menos un dato");
		}
	}

	public void editarUsuarioAdmin() {
		if (vista.getPanelAdministrador().getPanelTablaUsuario().verificarDatosTabla() == 1) {
			vista.getPanelAdministrador().getSplitPane()
					.setRightComponent(vista.getPanelAdministrador().getPanelEditarUsuario());
			String[] entradas = vista.getPanelAdministrador().getPanelTablaUsuario().obtenerDatosTabla();
			vista.getPanelAdministrador().getPanelEditarUsuario().recibirDatosUsuario(entradas[3], entradas[4],
					entradas[5], entradas[1], entradas[6], entradas[7], entradas[8]);
		} else {
			vista.mostrarMensajeAdvertencia("Seleccione al menos un dato");
		}
	}

	public void editarMascotaAdmin() {
		if (vista.getPanelAdministrador().getPanelTablaMascota().verificarDatosTabla() == 1) {
			vista.getPanelAdministrador().getSplitPane()
					.setRightComponent(vista.getPanelAdministrador().getPanelEditarMascota());
			String[] entradas = vista.getPanelAdministrador().getPanelTablaMascota().obtenerDatosTablaMascota();
			vista.getPanelAdministrador().getPanelEditarMascota().recibirDatosMascota(entradas[1], entradas[3],
					entradas[4], entradas[5], entradas[6], entradas[7]);
			ArrayList<Color> colores = clinica.getUsuarioDAO().getMascotaDAO().getColorDAO().consultarColores();
			ArrayList<Especie> especies = clinica.getUsuarioDAO().getMascotaDAO().getEspecieDAO().consultarEspecies();
			ArrayList<Raza> razas = clinica.getUsuarioDAO().getMascotaDAO().getRazaDAO().consultarRazas();
			vista.getPanelAdministrador().getPanelEditarMascota().cargarComboBox(colores, especies, razas);
		} else {
			vista.mostrarMensajeAdvertencia("Seleccione al menos un dato");
		}
	}

	public void editarUsuarioCon() {
		String[][] entradas = vista.getPanelAdministrador().getPanelEditarUsuario().verificarCampos();
		if (entradas[0][0].equals("0")) {
			if (clinica.getUsuarioDAO().editarUsuario(entradas)) {
				vista.getPanelAdministrador().getPanelEditarUsuario().limpiarCampos();
				vista.mostrarMensajeInformacion("El usuario se editado correctamente");
			} else {
				vista.mostrarMensajeInformacion("No se ha podido editar la informaci?n solicitada");
			}
		} else {
			vista.mostrarMensajeAdvertencia(entradas[0][1]);
		}
	}

	public void editarMascotaCon() {
		String[][] entradas = vista.getPanelAdministrador().getPanelEditarMascota().verificarCampos();
		if (entradas[0][0].equals("0")) {
			if ("nombre".equals(entradas[1][0])) {
				if (clinica.getUsuarioDAO().getMascotaDAO().editarMascota2(entradas)) {
					vista.mostrarMensajeInformacion("Se ha editado correctamente la informaci?n");
				} else {
					vista.mostrarMensajeInformacion("No se ha podido actualizar la informaci?n");
				}
			} else {
				if (clinica.getUsuarioDAO().getMascotaDAO().editarMascota(entradas)) {
					vista.mostrarMensajeInformacion("Se ha editado correctamente la informaci?n");
				} else {
					vista.mostrarMensajeInformacion("No se ha podido actualizar la informaci?n");
				}
			}
		} else {
			vista.mostrarMensajeAdvertencia(entradas[0][1]);
		}
	}

	public void editarInformacionMascotaCliente() {
		String[][] entradas = vista.getPanelUsuario().getPanelEditarMascota().verificarCampos();
		if (entradas[0][0].equals("0")) {
			if ("nombre".equals(entradas[1][0])) {
				if (clinica.getUsuarioDAO().getMascotaDAO().editarMascota2(this.usuario, entradas)) {
					vista.mostrarMensajeInformacion("Se ha editado correctamente la informaci?n");
				} else {
					vista.mostrarMensajeInformacion("No se ha podido actualizar la informaci?n");
				}
			} else {
				if (clinica.getUsuarioDAO().getMascotaDAO().editarMascota(this.usuario, entradas)) {
					vista.mostrarMensajeInformacion("Se ha editado correctamente la informaci?n");
				} else {
					vista.mostrarMensajeInformacion("No se ha podido actualizar la informaci?n");
				}
			}
		} else {
			vista.mostrarMensajeAdvertencia(entradas[0][1]);
		}
	}

	public void crearEmpleado() {
		String[] entradas = vista.getPanelAdministrador().getPanelCrearEmpleado().verificarEntradas();
		if (entradas[0].equals("0")) {
			try {
				clinica.verificarNumero(entradas[9]);
				clinica.verficarCedula(entradas[2]);
				clinica.verficarTelefono(entradas[11]);
				clinica.verificarContra(entradas[3]);
				if (clinica.getUsuarioDAO().verificarIdUsuario(entradas[1])) {
					vista.mostrarMensajeAdvertencia("El correo " + entradas[1] + " ya se encuentra en uso");
				} else {
					String pass = clinica.getUsuarioDAO().getSha().shaEncode(entradas[3]);
					Usuario usuario = new Usuario(entradas[1], 3, entradas[2], pass, entradas[4] + " " + entradas[5],
							entradas[6] + " " + entradas[7], entradas[8], Integer.parseInt(entradas[9]), entradas[10],
							"A");
					if (clinica.getUsuarioDAO().crearUsuario(usuario)) {
						vista.getPanelAdministrador().getPanelCrearEmpleado().limpiarCampos();
						Telefono telefono = new Telefono(usuario.getCorreo(), entradas[11], "A");
						if (clinica.getUsuarioDAO().getTelefonoDAO().crearTelefono(telefono)) {
							vista.mostrarMensajeInformacion("Se ha registrado el empleado");
						} else {
							vista.mostrarMensajeInformacion(
									"No se ha podido registrar el empleado, verifique el n?mero de telefono");
						}
					} else {
						vista.mostrarMensajeInformacion("No se ha podido registrar el cliente");
					}
				}
			} catch (ExceptionNumero e) {
				vista.mostrarMensajeError(e.getMessage());
			} catch (ExceptionCedula e) {
				vista.mostrarMensajeError(e.getMessage());
			} catch (ExceptionTelefono e) {
				vista.mostrarMensajeError(e.getMessage());
			} catch (Exception e) {
			}

		} else {
			vista.mostrarMensajeAdvertencia(entradas[1]);
		}
	}

	public void realizarFactura() {
		String[] entradas = vista.getPanelEmpleado().getPanelEmpleadoServicio().verificarCampos();
		try {
			if (entradas[0].equals("0")) {
				clinica.verficarCedula(entradas[1]);
				clinica.verificarNumero(entradas[7]);
				if (clinica.getUsuarioDAO().consultarCedulaUsuario(entradas[1])) {
					Factura factura = new Factura(entradas[6], entradas[1], entradas[4], new Date(), "A");
					if (clinica.getFacturaDAO().crearFactura(factura)) {
						vista.getPanelEmpleado().getPanelEmpleadoServicio().activarPanelServicio();
						vista.getPanelEmpleado().getPanelEmpleadoServicio().desabilitarCampos();
					} else {
						vista.mostrarMensajeInformacion("No se ha podido generar la factura");
					}
				} else {
					vista.mostrarMensajeInformacion("La c?dula no se encuentra registrada");
				}

			} else {
				vista.mostrarMensajeAdvertencia(entradas[1]);
			}
		} catch (ExceptionNumero e) {
			vista.mostrarMensajeError(e.getMessage());
		} catch (ExceptionCedula e) {
			vista.mostrarMensajeError(e.getMessage());
		}
	}

	public void registrarServicio() {
		try {
			String[] entradas = vista.getPanelAdministrador().getPanelAdministradorServicio().verificarCampos();
			if (entradas[0].equals("0")) {
				clinica.verificarNumero(entradas[3]);
				Servicio servicio = new Servicio(entradas[1], entradas[2], Integer.parseInt(entradas[3]),
						Integer.parseInt(entradas[3]), "A");
				if (clinica.getServicioDAO().crearServicio(servicio)) {
					vista.mostrarMensajeInformacion("Se ha registrado correctamente el servicio");
				} else {
					vista.mostrarMensajeInformacion("No se ha podido rergistrar el servicio");
				}
			} else {
				vista.mostrarMensajeAdvertencia(entradas[1]);
			}
		} catch (ExceptionNumero e) {
			vista.mostrarMensajeError(e.getMessage());
		}
	}

	public void reporteFacturas() {
		String path = "Reportes\\InformacionFacturas.jrxml";
		clinica.getUsuarioDAO().getConex().conectarDB();
		try {
			JasperReport reporte = JasperCompileManager.compileReport(path);
			JasperPrint jPrint = JasperFillManager.fillReport(reporte, null,
					clinica.getUsuarioDAO().getConex().getConnection());
			JasperViewer viewer = new JasperViewer(jPrint, false);
			viewer.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			viewer.setTitle("Facturas");
			viewer.setVisible(true);
		} catch (JRException e1) {
			e1.printStackTrace();
		}
		clinica.getUsuarioDAO().getConex().cerrarDB();
	}

	public void reporteClientes() {
		String path = "Reportes\\Clientes.jrxml";
		clinica.getUsuarioDAO().getConex().conectarDB();
		try {
			JasperReport reporte = JasperCompileManager.compileReport(path);
			JasperPrint jPrint = JasperFillManager.fillReport(reporte, null,
					clinica.getUsuarioDAO().getConex().getConnection());
			JasperViewer viewer = new JasperViewer(jPrint, false);
			viewer.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			viewer.setTitle("Lista de clientes");
			viewer.setVisible(true);
		} catch (JRException e1) {
			e1.printStackTrace();
		}
		clinica.getUsuarioDAO().getConex().cerrarDB();
	}

	public void reportesMascotas() {
		String path = "Reportes\\Mascotas.jrxml";
		clinica.getUsuarioDAO().getConex().conectarDB();
		try {
			JasperReport reporte = JasperCompileManager.compileReport(path);
			JasperPrint jPrint = JasperFillManager.fillReport(reporte, null,
					clinica.getUsuarioDAO().getConex().getConnection());
			JasperViewer viewer = new JasperViewer(jPrint, false);
			viewer.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			viewer.setTitle("Lista de mascotas");
			viewer.setVisible(true);
		} catch (JRException e1) {
			e1.printStackTrace();
		}
		clinica.getUsuarioDAO().getConex().cerrarDB();
	}

	public void filtrarFactura() {
		String[][] entradas = vista.getPanelCliente().getPanelFiltroFactura().verificarCampos();
		if (entradas[0][0].equals("0")) {
			int contador = 0;

			for (int i = 1; i < entradas.length; i++) {
				if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
					contador++;
				}
			}

			if (contador == 1) {
				int j = 0;
				for (int i = 1; i < entradas.length; i++) {
					if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
						j = i;
						break;
					}
				}
				ArrayList<Factura> listaFactura = clinica.getFacturaDAO().consultarFactura(entradas, j, this.usuario);
				String[][] infoFactura = clinica.getFacturaDAO().mostarInfoFactura(listaFactura);
				vista.getPanelCliente().getPanelTablaFactura().limpiarPanel();
				vista.getPanelCliente().getPanelTablaFactura().mostrarTablaFactura(infoFactura);
				vista.getPanelCliente().getPanelFactura().add(vista.getPanelCliente().getPanelTablaFactura(),
						BorderLayout.CENTER);
				vista.getPanelCliente().getPanelFactura().add(vista.getPanelCliente().getBtnVerFacturaDetalle(),
						BorderLayout.PAGE_END);
				vista.getPanelCliente().getSplitPane2().setBottomComponent(vista.getPanelCliente().getPanelFactura());
				vista.getPanelCliente().getSplitPane2().setDividerLocation(150);
				vista.getPanelCliente().getSplitPane().setRightComponent(vista.getPanelCliente().getSplitPane2());
			}

			if (contador == 2) {
				int j = 0;
				int k = 0;
				for (int i = 1; i < entradas.length; i++) {
					if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
						j = i;
						break;
					}
				}

				for (int i = j + 1; i < entradas.length; i++) {
					if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
						k = i;
						break;
					}
				}
				ArrayList<Factura> listaFactura = clinica.getFacturaDAO().consultarFactura(entradas, j, k,
						this.usuario);
				String[][] infoFactura = clinica.getFacturaDAO().mostarInfoFactura(listaFactura);
				vista.getPanelCliente().getPanelTablaFactura().limpiarPanel();
				vista.getPanelCliente().getPanelTablaFactura().mostrarTablaFactura(infoFactura);
				vista.getPanelCliente().getPanelFactura().add(vista.getPanelCliente().getPanelTablaFactura(),
						BorderLayout.CENTER);
				vista.getPanelCliente().getPanelFactura().add(vista.getPanelCliente().getBtnVerFacturaDetalle(),
						BorderLayout.PAGE_END);
				vista.getPanelCliente().getSplitPane2().setBottomComponent(vista.getPanelCliente().getPanelFactura());
				vista.getPanelCliente().getSplitPane2().setDividerLocation(150);
				vista.getPanelCliente().getSplitPane().setRightComponent(vista.getPanelCliente().getSplitPane2());
			}

			if (contador == 3) {
				ArrayList<Factura> listaFactura = clinica.getFacturaDAO().consultarFactura(entradas, this.usuario);
				String[][] infoFactura = clinica.getFacturaDAO().mostarInfoFactura(listaFactura);
				vista.getPanelCliente().getPanelTablaFactura().limpiarPanel();
				vista.getPanelCliente().getPanelTablaFactura().mostrarTablaFactura(infoFactura);
				vista.getPanelCliente().getPanelFactura().add(vista.getPanelCliente().getPanelTablaFactura(),
						BorderLayout.CENTER);
				vista.getPanelCliente().getPanelFactura().add(vista.getPanelCliente().getBtnVerFacturaDetalle(),
						BorderLayout.PAGE_END);
				vista.getPanelCliente().getSplitPane2().setBottomComponent(vista.getPanelCliente().getPanelFactura());
				vista.getPanelCliente().getSplitPane2().setDividerLocation(150);
				vista.getPanelCliente().getSplitPane().setRightComponent(vista.getPanelCliente().getSplitPane2());
			}

		} else {
			vista.mostrarMensajeAdvertencia(entradas[0][1]);
		}
	}

	public void filtrarServicio() {
		String[][] entradas = vista.getPanelAdministrador().getPanelFiltroServicio().verificarCampos();
		if (entradas[0][0].equals("0")) {
			try {
				if (!entradas[1][1].equals("")) {
					clinica.verificarNumero(entradas[1][1]);
				}
				int contador = 0;

				for (int i = 1; i < entradas.length; i++) {
					if (!entradas[i][1].equals("")) {
						contador++;
					}
				}

				if (contador == 1) {
					int j = 0;
					for (int i = 1; i < entradas.length; i++) {
						if (!entradas[i][1].equals("")) {
							j = i;
							break;
						}
					}
					ArrayList<Servicio> listaServicio = clinica.getServicioDAO().consultarServicios(entradas, j);
					String[][] infoServicios = clinica.getServicioDAO().mostarInfoServicio(listaServicio);
					vista.getPanelAdministrador().getPanelTablaServicios().limpiarPanel();
					vista.getPanelAdministrador().getPanelTablaServicios().mostrarTablaServicios(infoServicios);
					vista.getPanelAdministrador().getSplitPane()
							.setRightComponent(vista.getPanelAdministrador().getSplitPane2());
				}

				if (contador == 2) {
					int j = 0;
					for (int i = 1; i < entradas.length; i++) {
						if (!entradas[i][1].equals("")) {
							j = i;
							break;
						}
					}
					ArrayList<Servicio> listaServicio = clinica.getServicioDAO().consultarServicios(entradas);
					String[][] infoServicios = clinica.getServicioDAO().mostarInfoServicio(listaServicio);
					vista.getPanelAdministrador().getPanelTablaServicios().limpiarPanel();
					vista.getPanelAdministrador().getPanelTablaServicios().mostrarTablaServicios(infoServicios);
					vista.getPanelAdministrador().getSplitPane()
							.setRightComponent(vista.getPanelAdministrador().getSplitPane2());
				}
			} catch (ExceptionNumero e) {
				vista.mostrarMensajeError(e.getMessage());
			}

		} else {
			vista.mostrarMensajeAdvertencia(entradas[0][1]);
		}
	}

	public void eliminarServicio() {
		if (vista.getPanelAdministrador().getPanelTablaServicios().verificarDatosTablaFactura() == 1) {
			String[] entradas = vista.getPanelAdministrador().getPanelTablaServicios().obtenerDatosServicio();
			if (entradas[0].equals("0")) {
				int confirmar = vista.mostarMensajeConfirmar("Seguro desea eliminar este servicio");
				if (confirmar == 0) {
					if (clinica.getServicioDAO().eliminarServicio(entradas[1])) {
						vista.mostrarMensajeInformacion("Se ha eliminado el servicio");
						ArrayList<Servicio> listaServicio = clinica.getServicioDAO().consultarServicios();
						String[][] infoServicios = clinica.getServicioDAO().mostarInfoServicio(listaServicio);
						vista.getPanelAdministrador().getPanelTablaServicios().limpiarPanel();
						vista.getPanelAdministrador().getPanelTablaServicios().mostrarTablaServicios(infoServicios);
						vista.getPanelAdministrador().getSplitPane()
								.setRightComponent(vista.getPanelAdministrador().getSplitPane2());
					} else {
						vista.mostrarMensajeInformacion("No se ha podido eliminar el servicio");
					}
				} else if (confirmar == 1) {
					vista.mostrarMensajeInformacion("Gracias por confirmar");
				} else {
					vista.mostrarMensajeInformacion("Gracias");
				}
			} else {
				vista.mostrarMensajeInformacion(entradas[1]);
			}
		} else {
			vista.mostrarMensajeAdvertencia("Seleccione un dato");
		}
	}

	public void editarServicio() {
		try {
			String[][] entradas = vista.getPanelAdministrador().getPanelEditarServicio().verificarCampos();
			if (entradas[0][0].equals("0")) {
				if (entradas[1][3].equals("Precio")) {
					clinica.verificarNumero(entradas[1][1]);
					if (clinica.getServicioDAO().editarServicio(entradas)) {
						vista.mostrarMensajeInformacion("Se ha editado el servicio");
						vista.getPanelAdministrador().getPanelEditarServicio().limpiarCampos();
					} else {
						vista.mostrarMensajeInformacion("No se ha podifo editar el servicio");
					}
				} else {
					if (clinica.getServicioDAO().editarServicio(entradas)) {
						vista.mostrarMensajeInformacion("Se ha editado el servicio");
						vista.getPanelAdministrador().getPanelEditarServicio().limpiarCampos();
					} else {
						vista.mostrarMensajeInformacion("No se ha podifo editar el servicio");
					}
				}
			} else {
				vista.mostrarMensajeAdvertencia(entradas[0][1]);
			}
		} catch (ExceptionNumero e) {
			vista.mostrarMensajeError(e.getMessage());
		}

	}
}
