package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.TitledBorder;

public class PanelCliente extends JPanel {

	private final String COMANDO_VERMASCOTA = "VERMASCOTA";
	private final String COMANDO_AGREGARMASCOTA = "AGREGARMASCOTA";
	private final String COMANDO_VERINFO = "VERINFOCLIENTE";
	private final String COMANDO_BORRAR = "BORRARMASCOTA";
	private final String COMANDO_EDITAR = "EDITARMASCOTA";
	private final String COMANDO_VOLVER = "VOLVER3";
	private final String COMANDO_VERFACTURA = "VERFACTURA15";
	private final String COMANDO_VERFACTURA2 = "VERFACTURA16";
	private JButton btnVerMascota;
	private JButton btnAgregarMascota;
	private JButton btnVerInfoCliente;
	private JButton btnVerFactura;
	private JButton btnVolver;
	private JButton btnVerFacturaDetalle;
	private PanelTablas panelTablaMascota;
	private PanelTablas panelTablaFactura;
	private PanelFiltroMascotaC panelFiltro;
	private PanelCrearMascota panelCrearMascota;
	private PanelClienteInformacion panelClienteInformacion;
	private PanelInicioCliente panelInicioCliente;
	private PanelEditarMascotaC panelEditarMascota;
	private PanelFiltroFactura panelFiltroFactura;
	private JSplitPane splitPane;
	private JPanel panel;
	private JPanel panelFiltroMascota;
	private JPanel panelInformacionMascota;
	private JPanel panelBotones;
	private JButton btnEliminar;
	private JButton btnEditar;
	private JPanel panelFactura;
	private JSplitPane splitPane2;

	public PanelCliente() {
		setLayout(new GridLayout(1, 1));
		btnVerMascota = new JButton("Ver mascotas");
		btnAgregarMascota = new JButton("Agregar mascota");
		btnVerMascota.setActionCommand(COMANDO_VERMASCOTA);
		btnAgregarMascota.setActionCommand(COMANDO_AGREGARMASCOTA);
		btnVerInfoCliente = new JButton("Ver mi información");
		btnVerInfoCliente.setActionCommand(COMANDO_VERINFO);
		btnVerFactura = new JButton("Ver factura");
		btnVerFactura.setActionCommand(COMANDO_VERFACTURA);
		btnVolver = new JButton("Cerrar sesion");
		btnVolver.setActionCommand(COMANDO_VOLVER);
		panelTablaFactura = new PanelTablas();
		panelTablaMascota = new PanelTablas();
		panelCrearMascota = new PanelCrearMascota();
		panelClienteInformacion = new PanelClienteInformacion();
		panelFiltroFactura = new PanelFiltroFactura();
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
		panel.setLayout(new GridLayout(5, 1));
		panel.add(btnVerMascota);
		panel.add(btnAgregarMascota);
		panel.add(btnVerInfoCliente);
		panel.add(btnVerFactura);
		panel.add(btnVolver);
		btnVerFacturaDetalle = new JButton("Ver detalles");
		btnVerFacturaDetalle.setActionCommand(COMANDO_VERFACTURA2);
		panelFactura = new JPanel();
		panelFactura.setBorder(new TitledBorder("Facturas"));
		panelFactura.setLayout(new BorderLayout());				
		panelInicioCliente = new PanelInicioCliente();
		splitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPane2.setTopComponent(panelFiltroFactura);
		splitPane2.setEnabled(false);
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

	public PanelTablas getPanelTablaFactura() {
		return panelTablaFactura;
	}

	public void setPanelTablaFactura(PanelTablas panelTablaFactura) {
		this.panelTablaFactura = panelTablaFactura;
	}

	public JButton getBtnVerFactura() {
		return btnVerFactura;
	}

	public void setBtnVerFactura(JButton btnVerFactura) {
		this.btnVerFactura = btnVerFactura;
	}

	public String getCOMANDO_VERFACTURA() {
		return COMANDO_VERFACTURA;
	}

	public JButton getBtnVerFacturaDetalle() {
		return btnVerFacturaDetalle;
	}

	public void setBtnVerFacturaDetalle(JButton btnVerFacturaDetalle) {
		this.btnVerFacturaDetalle = btnVerFacturaDetalle;
	}

	public JPanel getPanelFactura() {
		return panelFactura;
	}

	public void setPanelFactura(JPanel panelFactura) {
		this.panelFactura = panelFactura;
	}

	public String getCOMANDO_VERFACTURA2() {
		return COMANDO_VERFACTURA2;
	}

	public PanelFiltroFactura getPanelFiltroFactura() {
		return panelFiltroFactura;
	}

	public void setPanelFiltroFactura(PanelFiltroFactura panelFiltroFactura) {
		this.panelFiltroFactura = panelFiltroFactura;
	}

	public JSplitPane getSplitPane2() {
		return splitPane2;
	}

	public void setSplitPane2(JSplitPane splitPane2) {
		this.splitPane2 = splitPane2;
	}
}
