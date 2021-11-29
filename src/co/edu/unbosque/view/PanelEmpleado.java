package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class PanelEmpleado extends JPanel{
	
	private final String COMANDO_REGISTRARFACTURA = "REGISTRARFACTURA";
	private final String COMANDO_CERRARSESION = "CERRARSESION";
	private final String COMANDO_VERFACTURA = "VERFACTURA";
	private JButton btnFactura;
	private JButton btnCerrar;
	private JButton btnVerFacturas;
	private PanelEmpleadoServicio panelEmpleadoServicio;
	private JPanel panelBotones;
	private JPanel panel;
	private JSplitPane splitPane;
	
	public PanelEmpleado() {
		setLayout(new GridLayout(1, 1));
		btnFactura = new JButton("Realizar servicio");
		btnFactura.setActionCommand(COMANDO_REGISTRARFACTURA);
		btnCerrar = new JButton("Cerrar sesion");
		btnCerrar.setActionCommand(COMANDO_CERRARSESION);
		btnVerFacturas = new JButton("Ver Facturas");
		btnVerFacturas.setActionCommand(COMANDO_VERFACTURA);
		panelEmpleadoServicio = new PanelEmpleadoServicio();
		panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(3, 1));
		panelBotones.add(btnFactura);
		panelBotones.add(btnVerFacturas);
		panelBotones.add(btnCerrar);
		panel = new JPanel();
		splitPane = new JSplitPane();
		splitPane.setLeftComponent(panelBotones);
		splitPane.setRightComponent(panel);
		add(splitPane);
	}

	public JButton getBtnFactura() {
		return btnFactura;
	}

	public void setBtnFactura(JButton btnFactura) {
		this.btnFactura = btnFactura;
	}

	public JButton getBtnCerrar() {
		return btnCerrar;
	}

	public void setBtnCerrar(JButton btnCerrar) {
		this.btnCerrar = btnCerrar;
	}

	public JPanel getPanelBotones() {
		return panelBotones;
	}

	public void setPanelBotones(JPanel panelBotones) {
		this.panelBotones = panelBotones;
	}

	public JSplitPane getSplitPane() {
		return splitPane;
	}

	public void setSplitPane(JSplitPane splitPane) {
		this.splitPane = splitPane;
	}

	public String getCOMANDO_REGISTRARFACTURA() {
		return COMANDO_REGISTRARFACTURA;
	}

	public String getCOMANDO_CERRARSESION() {
		return COMANDO_CERRARSESION;
	}

	public PanelEmpleadoServicio getPanelEmpleadoServicio() {
		return panelEmpleadoServicio;
	}

	public void setPanelEmpleadoServicio(PanelEmpleadoServicio panelEmpleadoServicio) {
		this.panelEmpleadoServicio = panelEmpleadoServicio;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JButton getBtnVerFacturas() {
		return btnVerFacturas;
	}

	public void setBtnVerFacturas(JButton btnVerFacturas) {
		this.btnVerFacturas = btnVerFacturas;
	}

	public String getCOMANDO_VERFACTURA() {
		return COMANDO_VERFACTURA;
	}	

}
