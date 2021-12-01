package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.TitledBorder;

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
	private final String COMANDO_REGISTRARSERVICIO = "REGISTRARSERVICIO";
	private final String COMANDO_EDITARSERVICIO = "EDITARSERVICIO";
	private final String COMANDO_ELIMINARSERVICIO = "ELIMINARSERVICIO";
	private final String COMANDO_AGREGARSERVICIO = "AGREGARSERVICIO23";
	private JButton btnVerMascota;
	private JButton btnVerUsuarios;
	private JButton btnVolver;
	private JButton btnRegistrarServicio;
	private JButton btnCrearEmpleado;
	private JButton btnEditarServicio;
	private JButton btnEliminarServicio;
	private JButton btnAgregarServicio;
	private PanelFiltroMascotaA panelFiltroMascotaA;
	private PanelFiltroUsuario panelFiltroUsuario;
	private PanelFiltroServicio panelFiltroServicio;
	private PanelCrearServicio panelAdministradorServicio;
	private PanelTablas panelTablaMascota;
	private PanelTablas panelTablaUsuario;
	private PanelTablas panelTablaServicios;
	private JSplitPane splitPane;
	private JSplitPane splitPane2;
	private JPanel panel;
	private JPanel panelFiltroMascota;
	private PanelInicioAdmin panelInicioAdmin;
	private PanelEditarUsuarioA panelEditarUsuario;
	private PanelEditarMascotaA panelEditarMascota;
	private PanelEditarServicio panelEditarServicio;
	private PanelCrearEmpleado panelCrearEmpleado;
	private JPanel panelInfoUsuario;
	private JPanel panelInformacionMascota;
	private JPanel panelBotones;
	private JPanel panelBotones2;
	private JPanel panelFiltroU;
	private JPanel panelTodoM;
	private JPanel panelTodoFiltroServicio;
	private JPanel panelBotones3;
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
		btnRegistrarServicio = new JButton("Ver servicios");
		btnRegistrarServicio.setActionCommand(COMANDO_REGISTRARSERVICIO);
		btnVolver = new JButton("Cerrar sesion");
		btnVolver.setActionCommand(COMANDO_VOLVER);
		btnEditarServicio = new JButton("Editar");
		btnEditarServicio.setActionCommand(COMANDO_EDITARSERVICIO);
		btnEliminarServicio = new JButton("Eliminar");
		btnEliminarServicio.setActionCommand(COMANDO_ELIMINARSERVICIO);
		btnAgregarServicio = new JButton("Agregar servicio");
		btnAgregarServicio.setActionCommand(COMANDO_AGREGARSERVICIO);
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
		panelBotones3 = new JPanel();
		panelBotones3.setLayout(new GridLayout(1, 3));
		panelBotones3.add(btnEditarServicio);
		panelBotones3.add(btnEliminarServicio);
		panelBotones3.add(btnAgregarServicio);
		panelFiltroMascotaA = new PanelFiltroMascotaA();
		panelFiltroServicio = new PanelFiltroServicio();
		panelFiltroUsuario = new PanelFiltroUsuario();
		panelEditarUsuario = new PanelEditarUsuarioA();
		panelEditarServicio = new PanelEditarServicio();
		panelEditarMascota = new PanelEditarMascotaA();
		panelCrearEmpleado = new PanelCrearEmpleado();
		panelTablaMascota = new PanelTablas();
		panelTablaUsuario = new PanelTablas();
		panelTablaServicios = new PanelTablas();
		panelFiltroMascota = new JPanel();
		panelFiltroMascota.setLayout(new GridLayout(2, 1));
		panelFiltroMascota.add(panelFiltroMascotaA);
		panelInfoUsuario = new JPanel();
		panelAdministradorServicio = new PanelCrearServicio();
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
		panel.setLayout(new GridLayout(5, 1));
		panel.add(btnVerMascota);
		panel.add(btnVerUsuarios);
		panel.add(btnRegistrarServicio);
		panel.add(btnCrearEmpleado);
		panel.add(btnVolver);
		panelInicioAdmin = new PanelInicioAdmin();
		panelTodoFiltroServicio = new JPanel();
		panelTodoFiltroServicio.setBorder(new TitledBorder("Información de servicio"));
		panelTodoFiltroServicio.setLayout(new BorderLayout());
		panelTodoFiltroServicio.add(panelTablaServicios, BorderLayout.CENTER);
		panelTodoFiltroServicio.add(panelBotones3, BorderLayout.PAGE_END);
		splitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPane2.setTopComponent(panelFiltroServicio);
		splitPane2.setBottomComponent(panelTodoFiltroServicio);
		splitPane2.setDividerLocation(150);
		splitPane2.setEnabled(false);
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

	public JButton getBtnRegistrarServicio() {
		return btnRegistrarServicio;
	}

	public void setBtnRegistrarServicio(JButton btnRegistrarServicio) {
		this.btnRegistrarServicio = btnRegistrarServicio;
	}

	public String getCOMANDO_REGISTRARSERVICIO() {
		return COMANDO_REGISTRARSERVICIO;
	}

	public PanelCrearServicio getPanelAdministradorServicio() {
		return panelAdministradorServicio;
	}

	public void setPanelAdministradorServicio(PanelCrearServicio panelAdministradorServicio) {
		this.panelAdministradorServicio = panelAdministradorServicio;
	}

	public PanelFiltroServicio getPanelFiltroServicio() {
		return panelFiltroServicio;
	}

	public void setPanelFiltroServicio(PanelFiltroServicio panelFiltroServicio) {
		this.panelFiltroServicio = panelFiltroServicio;
	}

	public PanelTablas getPanelTablaServicios() {
		return panelTablaServicios;
	}

	public void setPanelTablaServicios(PanelTablas panelTablaServicios) {
		this.panelTablaServicios = panelTablaServicios;
	}

	public JSplitPane getSplitPane2() {
		return splitPane2;
	}

	public void setSplitPane2(JSplitPane splitPane2) {
		this.splitPane2 = splitPane2;
	}

	public JButton getBtnEditarServicio() {
		return btnEditarServicio;
	}

	public void setBtnEditarServicio(JButton btnEditarServicio) {
		this.btnEditarServicio = btnEditarServicio;
	}

	public JButton getBtnEliminarServicio() {
		return btnEliminarServicio;
	}

	public void setBtnEliminarServicio(JButton btnEliminarServicio) {
		this.btnEliminarServicio = btnEliminarServicio;
	}

	public JButton getBtnAgregarServicio() {
		return btnAgregarServicio;
	}

	public void setBtnAgregarServicio(JButton btnAgregarServicio) {
		this.btnAgregarServicio = btnAgregarServicio;
	}

	public JPanel getPanelTodoFiltroServicio() {
		return panelTodoFiltroServicio;
	}

	public void setPanelTodoFiltroServicio(JPanel panelTodoFiltroServicio) {
		this.panelTodoFiltroServicio = panelTodoFiltroServicio;
	}

	public JPanel getPanelBotones3() {
		return panelBotones3;
	}

	public void setPanelBotones3(JPanel panelBotones3) {
		this.panelBotones3 = panelBotones3;
	}

	public String getCOMANDO_EDITARSERVICIO() {
		return COMANDO_EDITARSERVICIO;
	}

	public String getCOMANDO_ELIMINARSERVICIO() {
		return COMANDO_ELIMINARSERVICIO;
	}

	public String getCOMANDO_AGREGARSERVICIO() {
		return COMANDO_AGREGARSERVICIO;
	}

	public PanelEditarServicio getPanelEditarServicio() {
		return panelEditarServicio;
	}

	public void setPanelEditarServicio(PanelEditarServicio panelEditarServicio) {
		this.panelEditarServicio = panelEditarServicio;
	}
	
}
