package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import co.edu.unbosque.controller.Controller;

public class Vista extends JFrame {

	private final String COMANDO_CUSUARIO = "CUSUARIO";
	private PanelLogin panelLogin;
	private PanelCrearUsuario panelCrearUsuario;
	private PanelCliente panelCliente;
	private PanelAdministrador panelAdministrador;
	private PanelEmpleado panelEmpleado;
	private JPanel panelPrincipal;

	public Vista(Controller controller) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800, 500);
		this.setLayout(null);
		this.setTitle("BD");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		panelPrincipal = new JPanel();
		panelPrincipal.setSize(800, 500);
		panelPrincipal.setLayout(null);
		panelCliente = new PanelCliente();
		panelCliente.setVisible(false);
		panelLogin = new PanelLogin();
		panelLogin.setVisible(true);
		panelCrearUsuario = new PanelCrearUsuario();
		panelCrearUsuario.setVisible(false);
		panelAdministrador = new PanelAdministrador();
		panelAdministrador.setVisible(false);
		panelEmpleado = new PanelEmpleado();
		panelEmpleado .setVisible(false);
		panelPrincipal.add(panelEmpleado);
		panelEmpleado.setBounds(0, 0, 785, 462);
		panelPrincipal.add(panelLogin);
		panelLogin.setBounds(0, 0, 785, 462);
		panelPrincipal.add(panelCrearUsuario);
		panelCrearUsuario.setBounds(0, 0, 785, 462);
		panelPrincipal.add(panelCliente);
		panelCliente.setBounds(0, 0, 785, 462);
		panelPrincipal.add(panelAdministrador);
		panelAdministrador.setBounds(0, 0, 785, 462);
		add(panelPrincipal);
		asignarOyentes(controller);
		repaint();
		revalidate();
	}

	public void asignarOyentes(Controller controller) {
		panelLogin.getBtnConfirmar().addActionListener(controller);
		panelLogin.getBtnCrearUsuario().addActionListener(controller);
		panelCrearUsuario.getBtnCrear().addActionListener(controller);
		panelCrearUsuario.getBtnVolver().addActionListener(controller);
		panelCliente.getBtnAgregarMascota().addActionListener(controller);
		panelCliente.getBtnVerMascota().addActionListener(controller);
		panelCliente.getPanelCrearMascota().getBtnConfirmar().addActionListener(controller);
		panelCliente.getBtnAgregarMascota().addActionListener(controller);
		panelCliente.getBtnVerInfoCliente().addActionListener(controller);
		panelCliente.getPanelClienteInformacion().getBtnEditarInfo().addActionListener(controller);
		panelCliente.getPanelFiltro().getBtnConfirmar().addActionListener(controller);
		panelCliente.getBtnEditar().addActionListener(controller);
		panelCliente.getBtnEliminar().addActionListener(controller);
		panelCliente.getPanelEditarMascota().getBtnConfirmar().addActionListener(controller);
		panelCliente.getPanelEditarMascota().getBtnVolver().addActionListener(controller);
		panelCliente.getBtnVolver().addActionListener(controller);
		panelCliente.getPanelEditarMascota().getComboOpcion().addActionListener(controller);
		panelCliente.getPanelClienteInformacion().getComboOpcion().addActionListener(controller);
		panelAdministrador.getBtnVerMascota().addActionListener(controller);
		panelAdministrador.getBtnVerUsuarios().addActionListener(controller);
		panelAdministrador.getBtnVolver().addActionListener(controller);
		panelAdministrador.getBtnEditar().addActionListener(controller);
		panelAdministrador.getBtnEditar2().addActionListener(controller);
		panelAdministrador.getBtnEliminar().addActionListener(controller);
		panelAdministrador.getBtnEliminar2().addActionListener(controller);
		panelAdministrador.getPanelFiltroUsuario().getBtnFiltrar().addActionListener(controller);
		panelAdministrador.getPanelFiltroMascotaA().getBtnConfirmar().addActionListener(controller);
		panelAdministrador.getPanelEditarUsuario().getBtnConfirmar().addActionListener(controller);
		panelAdministrador.getPanelEditarUsuario().getBtnVolver().addActionListener(controller);
		panelAdministrador.getPanelEditarMascota().getComboOpcion().addActionListener(controller);
		panelAdministrador.getPanelEditarMascota().getBtnConfirmar().addActionListener(controller);
		panelAdministrador.getBtnCrearEmpleado().addActionListener(controller);
		panelAdministrador.getPanelCrearEmpleado().getBtnCrear().addActionListener(controller);
		panelEmpleado.getBtnFactura().addActionListener(controller);
		panelEmpleado.getBtnCerrar().addActionListener(controller);
		panelEmpleado.getPanelEmpleadoServicio().getBtnConfirmar().addActionListener(controller);
		panelEmpleado.getBtnVerFacturas().addActionListener(controller);
	}

	/**
	 * Método encargado de mostrar un mensaje de advertencia.
	 * 
	 * @param mensaje
	 */
	public void mostrarMensajeAdvertencia(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Mensaje de advertencia", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Método encargado de mostrar un mensaje informativo.
	 * 
	 * @param mensaje
	 */
	public void mostrarMensajeInformacion(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Método encargado de mostrar un mensaje de error.
	 * 
	 * @param mensaje
	 */
	public void mostrarMensajeError(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}

	public String pedirDato(String mensaje) {
		String n = JOptionPane.showInputDialog(mensaje);
		if (n == null) {
			n = "Accion Cancelada";
		} else if ("".equals(n)) {
			n = "Por favor digite un valor";
		}
		return n;
	}

	public int mostarMensajeConfirmar(String mensaje) {
		int verificar = JOptionPane.showConfirmDialog(null, mensaje);
		return verificar;
	}

	public JPanel getPanelPrincipal() {
		return panelPrincipal;
	}

	public void setPanelPrincipal(JPanel panelPrincipal) {
		this.panelPrincipal = panelPrincipal;
	}

	public PanelLogin getPanelLogin() {
		return panelLogin;
	}

	public void setPanelLogin(PanelLogin panelLogin) {
		this.panelLogin = panelLogin;
	}

	public PanelCrearUsuario getPanelCrearUsuario() {
		return panelCrearUsuario;
	}

	public void setPanelCrearUsuario(PanelCrearUsuario panelCrearUsuario) {
		this.panelCrearUsuario = panelCrearUsuario;
	}

	public String getCOMANDO_CUSUARIO() {
		return COMANDO_CUSUARIO;
	}

	public PanelCliente getPanelUsuario() {
		return panelCliente;
	}

	public void setPanelUsuario(PanelCliente panelUsuario) {
		this.panelCliente = panelUsuario;
	}

	public PanelAdministrador getPanelAdministrador() {
		return panelAdministrador;
	}

	public void setPanelAdministrador(PanelAdministrador panelAdministrador) {
		this.panelAdministrador = panelAdministrador;
	}

	public PanelCliente getPanelCliente() {
		return panelCliente;
	}

	public void setPanelCliente(PanelCliente panelCliente) {
		this.panelCliente = panelCliente;
	}

	public PanelEmpleado getPanelEmpleado() {
		return panelEmpleado;
	}

	public void setPanelEmpleado(PanelEmpleado panelEmpleado) {
		this.panelEmpleado = panelEmpleado;
	}

}
