package co.edu.unbosque.controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.Clinica;
import co.edu.unbosque.model.ExceptionCedula;
import co.edu.unbosque.model.ExceptionNumero;
import co.edu.unbosque.model.ExceptionTelefono;
import co.edu.unbosque.model.persistence.Color;
import co.edu.unbosque.model.persistence.Especie;
import co.edu.unbosque.model.persistence.Mascota;
import co.edu.unbosque.model.persistence.Raza;
import co.edu.unbosque.model.persistence.Telefono;
import co.edu.unbosque.model.persistence.Usuario;
import co.edu.unbosque.view.Vista;

public class Controller implements ActionListener {

	private Vista vista;
	private Clinica clinica;
	private String usuario = "";

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
			ArrayList<Mascota> listaMascota = clinica.getUsuarioDAO().getMascotaDAO().consultarMascotas(this.usuario);
			ArrayList<Color> colores = clinica.getUsuarioDAO().getMascotaDAO().getColorDAO().consultarColores();
			ArrayList<Especie> especies = clinica.getUsuarioDAO().getMascotaDAO().getEspecieDAO().consultarEspecies();
			ArrayList<Raza> razas = clinica.getUsuarioDAO().getMascotaDAO().getRazaDAO().consultarRazas();
			vista.getPanelUsuario().getPanelEditarMascota().cargarComboBox(listaMascota, colores, especies, razas);
			vista.getPanelUsuario().getSplitPane().setRightComponent(vista.getPanelUsuario().getPanelEditarMascota());
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

	}

	public void registrarCliente() {
		try {
			String[] entradas = vista.getPanelCrearUsuario().verificarEntradas();
			if (entradas[0].equals("0")) {
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
									"No se ha podido registrar el cliente, verifique el número de telefono");
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
				if (clinica.getUsuarioDAO().getMascotaDAO().verificarIdMascota(Integer.parseInt(entradas[1]))) {
					vista.mostrarMensajeAdvertencia("El id " + entradas[1] + " ya se encuentra en uso");
				} else {
					clinica.verificarNumero(entradas[1]);
					Date date = formato.parse(entradas[6]);
					Mascota mascota = new Mascota(Integer.parseInt(entradas[1]), usuario, entradas[2], entradas[3],
							entradas[4], entradas[5], date, "A");
					if (clinica.getUsuarioDAO().getMascotaDAO().crearMascota(mascota)) {
						vista.getPanelUsuario().getPanelCrearMascota().limpiarCampos();
						vista.mostrarMensajeInformacion("Se ha reistrado tu mascota");
					} else {
						vista.mostrarMensajeInformacion(
								"Lo sentimos no se ha podido realizar el reistro de tu mascota");
					}
				}
			} else {
				vista.mostrarMensajeAdvertencia(entradas[1]);
			}
		} catch (ExceptionNumero e1) {
			vista.mostrarMensajeError(e1.getMessage());
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
				}
				if (Integer.parseInt(resultado[1]) == 2) {
					vista.getPanelUsuario().getSplitPane()
							.setRightComponent(vista.getPanelUsuario().getPanelInicioCliente());
					vista.getPanelAdministrador().setVisible(false);
					vista.getPanelUsuario().setVisible(true);
					vista.getPanelLogin().setVisible(false);
					vista.getPanelCrearUsuario().setVisible(false);
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

	public void editarInformacionMascotaCliente() {
		String[][] entradas = vista.getPanelUsuario().getPanelEditarMascota().verificarCampos();
		if (entradas[0][0].equals("0")) {
			int contador = 0;

			for (int i = 1; i < entradas.length - 1; i++) {
				if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
					contador++;
				}
			}

			if (contador == 1) {
				int k = 0;

				for (int i = 1; i < entradas.length - 1; i++) {
					if (!entradas[i][1].equals("") && !entradas[i][1].equals("Seleccione")) {
						k = i;
						break;
					}
				}

				if (k == 1 || k == 5) {

					if (clinica.getUsuarioDAO().getMascotaDAO().editarMascota2(this.usuario, entradas, k)) {
						vista.mostrarMensajeInformacion("Se ha editado la informacion de tu mascota");
					} else {
						vista.mostrarMensajeInformacion("No se ha podido actualizar la informacion de tu mascota");
					}

				} else {
					if (clinica.getUsuarioDAO().getMascotaDAO().editarMascota(this.usuario, entradas, k)) {
						vista.mostrarMensajeInformacion("Se ha editado la informacion de tu mascota");
					} else {
						vista.mostrarMensajeInformacion("No se ha podido actualizar la informacion de tu mascota");
					}
				}

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

				if (j == 1 && k == 5) {
					if (clinica.getUsuarioDAO().getMascotaDAO().editarMascota2(usuario, entradas, j, k)) {
						vista.mostrarMensajeInformacion("Se ha editado la informacion de tu mascota");
					} else {
						vista.mostrarMensajeInformacion("No se ha podido actualizar la informacion de tu mascota");
					}
				} else if ((j == 2 || j == 3 || j == 4) && (k == 2 || k == 3 || k == 4)) {

					if (clinica.getUsuarioDAO().getMascotaDAO().editarMascota(this.usuario, entradas, j, k)) {
						vista.mostrarMensajeInformacion("Se ha editado la informacion de tu mascota");
					} else {
						vista.mostrarMensajeInformacion("No se ha podido actualizar la informacion de tu mascota");
					}
				} else {
					if (clinica.getUsuarioDAO().getMascotaDAO().editarMascota3(this.usuario, entradas, j, k)) {
						vista.mostrarMensajeInformacion("Se ha editado la informacion de tu mascota");
					} else {
						vista.mostrarMensajeInformacion("No se ha podido actualizar la informacion de tu mascota");
					}
				}

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
						j = i;
						break;
					}
				}
				System.out.println("j: " + j);
				System.out.println("k: " + k);
				System.out.println("l: " + l);

				if (j == 1 && l == 5) {
					if (clinica.getUsuarioDAO().getMascotaDAO().editarMascota2(usuario, entradas, j, k)) {
						vista.mostrarMensajeInformacion("Se ha editado la informacion de tu mascota");
					} else {
						vista.mostrarMensajeInformacion("No se ha podido actualizar la informacion de tu mascota");
					}
				} else if ((j == 2 || j == 3 || j == 4) && (k == 2 || k == 3 || k == 4)
						&& (l == 2 || l == 3 || l == 4)) {

					if (clinica.getUsuarioDAO().getMascotaDAO().editarMascota(usuario, entradas, j, k)) {
						vista.mostrarMensajeInformacion("Se ha editado la informacion de tu mascota");
					} else {
						vista.mostrarMensajeInformacion("No se ha podido actualizar la informacion de tu mascota");
					}
				} else {
					if (clinica.getUsuarioDAO().getMascotaDAO().editarMascota3(usuario, entradas, j, k)) {
						vista.mostrarMensajeInformacion("Se ha editado la informacion de tu mascota");
					} else {
						vista.mostrarMensajeInformacion("No se ha podido actualizar la informacion de tu mascota");
					}
				}

			}

		} else {
			vista.mostrarMensajeAdvertencia(entradas[0][1]);
		}
	}

	public void borrarMascotaCliente() {
		String id = vista.pedirDato("Ingrese el id de la mascota que desea eliminar");
		if (clinica.getUsuarioDAO().getMascotaDAO().eliminarMascota(this.usuario, id)) {
			String[][] info = clinica.getUsuarioDAO().mostarInfoMascota(usuario);
			vista.getPanelUsuario().getPanelTablaMascota().limpiarPanel();
			vista.getPanelUsuario().getPanelTablaMascota().mostrarTablaMascotas(info);
			vista.getPanelUsuario().getPanelFiltroMascota().add(vista.getPanelUsuario().getPanelInformacionMascota());
			vista.getPanelUsuario().getSplitPane().setRightComponent(vista.getPanelUsuario().getPanelFiltroMascota());
			vista.getPanelUsuario().getPanelFiltro().limpiarCampos();
			vista.mostrarMensajeInformacion("Se ha eliminado la mascota");
		} else {
			vista.mostrarMensajeInformacion("No se ha encontrado la mascota que intenta eliminar");
		}
	}

	public void volverPanelLogin() {
		vista.getPanelLogin().setVisible(true);
		vista.getPanelCrearUsuario().setVisible(false);
		vista.getPanelUsuario().setVisible(false);
		vista.getPanelAdministrador().setVisible(false);
	}

	public void filtrarInfoUsuario() {
		String[][] entradas = vista.getPanelAdministrador().getPanelFiltroUsuario().verificarCampos();
		if (entradas[0][0].equals("0")) {
			try {
				clinica.verificarNumero(entradas[4][1]);
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
}
