package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import co.edu.unbosque.controller.Controller;

public class PanelAdministrador extends JPanel{
	
	private final String COMANDO_VERMASCOTA = "VERMASCOTAS";
	private final String COMANDO_VERUSUARIOS = "VERUSUARIOS";
	private final String COMANDO_VOLVER = "VOLVER4";
	private final String COMANDO_BORRAR = "BORRARUSUARIO12345";
	private final String COMANDO_EDITAR = "EDITARUSUARIO";
	private final String COMANDO_BORRARM = "BORRARM";
	private final String COMANDO_EDITARM = "EDITARM";
	private final String COMANDO_CREAREMPLEADO = "CREAREMPLEADO";
	private JButton btnVerMascota;
	private JButton btnVerUsuarios;
	private JButton btnVolver;
	private JButton btnCrearEmpleado;
	private PanelFiltroMascotaA panelFiltroMascotaA;
	private PanelFiltroUsuario panelFiltroUsuario;
	private PanelTablas panelTablaMascota;
	private PanelTablas panelTablaUsuario;
	private JSplitPane splitPane;
	private JPanel panel;
	private JPanel panelFiltroMascota;
	private PanelInicioAdmin panelInicioAdmin;
	private PanelEditarUsuarioA panelEditarUsuario;
	private PanelEditarMascotaA panelEditarMascota;
	private PanelCrearEmpleado panelCrearEmpleado;
	private JPanel panelInfoUsuario;
	private JPanel panelInformacionMascota;
	private JPanel panelBotones;
	private JPanel panelBotones2;
	private JPanel panelFiltroU;
	private JPanel panelTodoM;
	private JButton btnEliminar;
	private JButton btnEditar;
	private JButton btnEliminar2;
	private JButton btnEditar2;

	public PanelAdministrador() {
		setLayout(new GridLayout(1, 1));
		btnVerMascota = new JButton("Ver mascotas");
		btnVerMascota.setActionCommand(COMANDO_VERMASCOTA);
		btnVerUsuarios = new JButton("Ver usuarios");
		btnVerUsuarios.setActionCommand(COMANDO_VERUSUARIOS);
		btnVolver = new JButton("Cerrar sesion");
		btnVolver.setActionCommand(COMANDO_VOLVER);
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setActionCommand(COMANDO_BORRAR);
		btnEditar = new JButton("Editar");
		btnEditar.setActionCommand(COMANDO_EDITAR);
		btnEliminar2 = new JButton("Eliminar");
		btnEliminar2.setActionCommand(COMANDO_BORRARM);
		btnEditar2 = new JButton("Editar");
		btnEditar2.setActionCommand(COMANDO_EDITARM);
		btnCrearEmpleado = new JButton("Registrar empleado");
		btnCrearEmpleado.setActionCommand(COMANDO_CREAREMPLEADO);
		panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(1, 2));
		panelBotones.add(btnEditar);
		panelBotones.add(btnEliminar);
		panelBotones2 = new JPanel();
		panelBotones2.setLayout(new GridLayout(1, 2));
		panelBotones2.add(btnEditar2);
		panelBotones2.add(btnEliminar2);
		panelFiltroMascotaA = new PanelFiltroMascotaA();
		panelFiltroUsuario = new PanelFiltroUsuario();
		panelEditarUsuario = new PanelEditarUsuarioA();
		panelEditarMascota = new PanelEditarMascotaA();
		panelCrearEmpleado = new PanelCrearEmpleado();
		panelTablaMascota = new PanelTablas();
		panelTablaUsuario = new PanelTablas();
		panelFiltroMascota = new JPanel();
		panelFiltroMascota.setLayout(new GridLayout(2, 1));
		panelFiltroMascota.add(panelFiltroMascotaA);
		panelInfoUsuario = new JPanel();
		panelInfoUsuario.setLayout(new BorderLayout());
		panelInformacionMascota = new JPanel();
		panelInformacionMascota.setLayout(new BorderLayout());
		panelTodoM = new JPanel();
		panelTodoM.setLayout(new GridLayout(2, 1));
		panelTodoM.add(panelFiltroMascotaA);
		panelFiltroU = new JPanel();
		panelFiltroU.setLayout(new GridLayout(2, 1));
		panelFiltroU.add(panelFiltroUsuario);
		panel = new JPanel();
		panel.setLayout(new GridLayout(4, 1));
		panel.add(btnVerMascota);
		panel.add(btnVerUsuarios);
		panel.add(btnCrearEmpleado);
		panel.add(btnVolver);
		panelInicioAdmin = new PanelInicioAdmin();
		splitPane = new JSplitPane();
		splitPane.setLeftComponent(panel);
		splitPane.setRightComponent(panelInicioAdmin);
		add(splitPane);
	}

	public JButton getBtnVerMascota() {
		return btnVerMascota;
	}

	public void setBtnVerMascota(JButton btnVerMascota) {
		this.btnVerMascota = btnVerMascota;
	}

	public JButton getBtnVerUsuarios() {
		return btnVerUsuarios;
	}

	public void setBtnVerUsuarios(JButton btnVerUsuarios) {
		this.btnVerUsuarios = btnVerUsuarios;
	}

	public PanelTablas getPanelTablaMascota() {
		return panelTablaMascota;
	}

	public void setPanelTablaMascota(PanelTablas panelTablaMascota) {
		this.panelTablaMascota = panelTablaMascota;
	}

	public PanelTablas getPanelTablaUsuario() {
		return panelTablaUsuario;
	}

	public void setPanelTablaUsuario(PanelTablas panelTablaUsuario) {
		this.panelTablaUsuario = panelTablaUsuario;
	}

	public JSplitPane getSplitPane() {
		return splitPane;
	}

	public void setSplitPane(JSplitPane splitPane) {
		this.splitPane = splitPane;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public String getCOMANDO_VERMASCOTA() {
		return COMANDO_VERMASCOTA;
	}

	public String getCOMANDO_VERUSUARIOS() {
		return COMANDO_VERUSUARIOS;
	}

	public PanelFiltroMascotaA getPanelFiltroMascotaA() {
		return panelFiltroMascotaA;
	}

	public void setPanelFiltroMascotaA(PanelFiltroMascotaA panelFiltroMascotaA) {
		this.panelFiltroMascotaA = panelFiltroMascotaA;
	}

	public JPanel getPanelFiltroMascota() {
		return panelFiltroMascota;
	}

	public void setPanelFiltroMascota(JPanel panelFiltroMascota) {
		this.panelFiltroMascota = panelFiltroMascota;
	}


	public PanelInicioAdmin getPanelInicioAdmin() {
		return panelInicioAdmin;
	}

	public void setPanelInicioAdmin(PanelInicioAdmin panelInicioAdmin) {
		this.panelInicioAdmin = panelInicioAdmin;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	public String getCOMANDO_VOLVER() {
		return COMANDO_VOLVER;
	}

	public PanelFiltroUsuario getPanelFiltroUsuario() {
		return panelFiltroUsuario;
	}

	public void setPanelFiltroUsuario(PanelFiltroUsuario panelFiltroUsuario) {
		this.panelFiltroUsuario = panelFiltroUsuario;
	}

	public JPanel getPanelInfoUsuario() {
		return panelInfoUsuario;
	}

	public void setPanelInfoUsuario(JPanel panelInfoUsuario) {
		this.panelInfoUsuario = panelInfoUsuario;
	}

	public JPanel getPanelBotones() {
		return panelBotones;
	}

	public void setPanelBotones(JPanel panelBotones) {
		this.panelBotones = panelBotones;
	}

	public JPanel getPanelFiltroU() {
		return panelFiltroU;
	}

	public void setPanelFiltroU(JPanel panelFiltroU) {
		this.panelFiltroU = panelFiltroU;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public JButton getBtnEditar() {
		return btnEditar;
	}

	public void setBtnEditar(JButton btnEditar) {
		this.btnEditar = btnEditar;
	}
	
	public String getCOMANDO_BORRAR() {
		return COMANDO_BORRAR;
	}

	public String getCOMANDO_EDITAR() {
		return COMANDO_EDITAR;
	}

	public JPanel getPanelInformacionMascota() {
		return panelInformacionMascota;
	}

	public void setPanelInformacionMascota(JPanel panelInformacionMascota) {
		this.panelInformacionMascota = panelInformacionMascota;
	}

	public JPanel getPanelBotones2() {
		return panelBotones2;
	}

	public void setPanelBotones2(JPanel panelBotones2) {
		this.panelBotones2 = panelBotones2;
	}

	public JButton getBtnEliminar2() {
		return btnEliminar2;
	}

	public void setBtnEliminar2(JButton btnEliminar2) {
		this.btnEliminar2 = btnEliminar2;
	}

	public JButton getBtnEditar2() {
		return btnEditar2;
	}

	public void setBtnEditar2(JButton btnEditar2) {
		this.btnEditar2 = btnEditar2;
	}

	public String getCOMANDO_BORRARM() {
		return COMANDO_BORRARM;
	}

	public String getCOMANDO_EDITARM() {
		return COMANDO_EDITARM;
	}

	public JPanel getPanelTodoM() {
		return panelTodoM;
	}

	public void setPanelTodoM(JPanel panelTodoM) {
		this.panelTodoM = panelTodoM;
	}

	public PanelEditarUsuarioA getPanelEditarUsuario() {
		return panelEditarUsuario;
	}

	public void setPanelEditarUsuario(PanelEditarUsuarioA panelEditarUsuario) {
		this.panelEditarUsuario = panelEditarUsuario;
	}

	public PanelEditarMascotaA getPanelEditarMascota() {
		return panelEditarMascota;
	}

	public void setPanelEditarMascota(PanelEditarMascotaA panelEditarMascota) {
		this.panelEditarMascota = panelEditarMascota;
	}

	public JButton getBtnCrearEmpleado() {
		return btnCrearEmpleado;
	}

	public void setBtnCrearEmpleado(JButton btnCrearEmpleado) {
		this.btnCrearEmpleado = btnCrearEmpleado;
	}

	public String getCOMANDO_CREAREMPLEADO() {
		return COMANDO_CREAREMPLEADO;
	}

	public PanelCrearEmpleado getPanelCrearEmpleado() {
		return panelCrearEmpleado;
	}

	public void setPanelCrearEmpleado(PanelCrearEmpleado panelCrearEmpleado) {
		this.panelCrearEmpleado = panelCrearEmpleado;
	}
	
	
}
