package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class PanelCliente extends JPanel {

	private final String COMANDO_VERMASCOTA = "VERMASCOTA";
	private final String COMANDO_AGREGARMASCOTA = "AGREGARMASCOTA";
	private final String COMANDO_VERINFO = "VERINFOCLIENTE";
	private final String COMANDO_BORRAR = "BORRARMASCOTA";
	private final String COMANDO_EDITAR = "EDITARMASCOTA";
	private final String COMANDO_VOLVER = "VOLVER3";
	private JButton btnVerMascota;
	private JButton btnAgregarMascota;
	private JButton btnVerInfoCliente;
	private JButton btnVolver;
	private PanelTablas panelTablaMascota;
	private PanelFiltroMascotaC panelFiltro;
	private PanelCrearMascota panelCrearMascota;
	private PanelClienteInformacion panelClienteInformacion;
	private PanelInicioCliente panelInicioCliente;
	private PanelEditarMascotaC panelEditarMascota;
	private JSplitPane splitPane;
	private JPanel panel;
	private JPanel panelFiltroMascota;
	private JPanel panelInformacionMascota;
	private JPanel panelBotones;
	private JButton btnEliminar;
	private JButton btnEditar;

	public PanelCliente() {
		setLayout(new GridLayout(1, 1));
		btnVerMascota = new JButton("Ver mascotas");
		btnAgregarMascota = new JButton("Agregar mascota");
		btnVerMascota.setActionCommand(COMANDO_VERMASCOTA);
		btnAgregarMascota.setActionCommand(COMANDO_AGREGARMASCOTA);
		btnVerInfoCliente = new JButton("Ver mi información");
		btnVerInfoCliente.setActionCommand(COMANDO_VERINFO);
		btnVolver = new JButton("Cerrar sesion");
		btnVolver.setActionCommand(COMANDO_VOLVER);
		panelTablaMascota = new PanelTablas();
		panelCrearMascota = new PanelCrearMascota();
		panelClienteInformacion = new PanelClienteInformacion();
		panelEditarMascota = new PanelEditarMascotaC();
		panelFiltro = new PanelFiltroMascotaC();
		panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(1, 2));
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setActionCommand(COMANDO_BORRAR);
		btnEditar = new JButton("Editar");
		btnEditar.setActionCommand(COMANDO_EDITAR);
		panelBotones.add(btnEditar);
		panelBotones.add(btnEliminar);
		panelInformacionMascota = new JPanel();
		panelInformacionMascota.setLayout(new BorderLayout());
		panelInformacionMascota.add(panelTablaMascota, BorderLayout.CENTER);
		panelInformacionMascota.add(panelBotones, BorderLayout.PAGE_END);
		panelFiltroMascota = new JPanel();
		panelFiltroMascota.setLayout(new GridLayout(2, 1));
		panelFiltroMascota.add(panelFiltro);
		panel = new JPanel();
		panel.setLayout(new GridLayout(4, 1));
		panel.add(btnVerMascota);
		panel.add(btnAgregarMascota);
		panel.add(btnVerInfoCliente);
		panel.add(btnVolver);
		panelInicioCliente = new PanelInicioCliente();
		splitPane = new JSplitPane();
		splitPane.setLeftComponent(panel);
		splitPane.setRightComponent(panelInicioCliente);
		add(splitPane);
	}

	public JButton getBtnVerMascota() {
		return btnVerMascota;
	}

	public void setBtnVerMascota(JButton btnVerMascota) {
		this.btnVerMascota = btnVerMascota;
	}

	public JButton getBtnAgregarMascota() {
		return btnAgregarMascota;
	}

	public void setBtnAgregarMascota(JButton btnAgregarMascota) {
		this.btnAgregarMascota = btnAgregarMascota;
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

	public String getCOMANDO_AGREGARMASCOTA() {
		return COMANDO_AGREGARMASCOTA;
	}

	public PanelTablas getPanelTablaMascota() {
		return panelTablaMascota;
	}

	public void setPanelTablaMascota(PanelTablas panelTablaMascota) {
		this.panelTablaMascota = panelTablaMascota;
	}

	public PanelCrearMascota getPanelCrearMascota() {
		return panelCrearMascota;
	}

	public void setPanelCrearMascota(PanelCrearMascota panelCrearMascota) {
		this.panelCrearMascota = panelCrearMascota;
	}

	public JButton getBtnVerInfoCliente() {
		return btnVerInfoCliente;
	}

	public void setBtnVerInfoCliente(JButton btnVerInfoCliente) {
		this.btnVerInfoCliente = btnVerInfoCliente;
	}

	public String getCOMANDO_VERINFO() {
		return COMANDO_VERINFO;
	}

	public PanelClienteInformacion getPanelClienteInformacion() {
		return panelClienteInformacion;
	}

	public void setPanelClienteInformacion(PanelClienteInformacion panelClienteInformacion) {
		this.panelClienteInformacion = panelClienteInformacion;
	}

	public PanelFiltroMascotaC getPanelFiltro() {
		return panelFiltro;
	}

	public void setPanelFiltro(PanelFiltroMascotaC panelFiltro) {
		this.panelFiltro = panelFiltro;
	}

	public JPanel getPanelFiltroMascota() {
		return panelFiltroMascota;
	}

	public void setPanelFiltroMascota(JPanel panelFiltroMascota) {
		this.panelFiltroMascota = panelFiltroMascota;
	}

	public PanelInicioCliente getPanelInicioCliente() {
		return panelInicioCliente;
	}

	public void setPanelInicioCliente(PanelInicioCliente panelInicioCliente) {
		this.panelInicioCliente = panelInicioCliente;
	}

	public JPanel getPanelInformacionMascota() {
		return panelInformacionMascota;
	}

	public void setPanelInformacionMascota(JPanel panelInformacionMascota) {
		this.panelInformacionMascota = panelInformacionMascota;
	}

	public JPanel getPanelBotones() {
		return panelBotones;
	}

	public void setPanelBotones(JPanel panelBotones) {
		this.panelBotones = panelBotones;
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

	public PanelEditarMascotaC getPanelEditarMascota() {
		return panelEditarMascota;
	}

	public void setPanelEditarMascota(PanelEditarMascotaC panelEditarMascota) {
		this.panelEditarMascota = panelEditarMascota;
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
	
}
