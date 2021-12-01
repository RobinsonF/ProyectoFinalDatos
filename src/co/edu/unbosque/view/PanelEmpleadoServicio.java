package co.edu.unbosque.view;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;

import co.edu.unbosque.model.persistence.FormaPago;
import co.edu.unbosque.model.persistence.Servicio;

public class PanelEmpleadoServicio extends JPanel {
	private final String COMANDO_REGISTRARFACTURA = "REGISTRARFACTURA2";
	private final String COMANDO_AGREARSERVICIO = "AGREGARSERVICIO43";
	private JLabel labelIdFactura;
	private JLabel labelCantidadServicio;
	private JLabel labelAgregarServicio;
	private JLabel labelCedula;
	private JLabel labelServicio;
	private JLabel labelPago;
	private JLabel labelCantidad;
	private JLabel labelDescuento;
	private JTextField txtCedula;
	private JComboBox<String> comboServicio;
	private JComboBox<String> comboPago;
	private JTextField txtCantidad;
	private JTextField txtCantidadServicio;
	private JTextField txtDescuento;
	private JTextField txtIdFactura;
	private JButton btnConfirmar;
	private JButton btnAgregarServicio;
	private JPanel panel;
	private JPanel panelServicio;
	private JPanel panelDivisor;
	private JSplitPane splitPane;
	private int contadorServicios = 0;

	public PanelEmpleadoServicio() {
		setBorder(new TitledBorder("Servicio"));
		setLayout(new BorderLayout());
		labelCantidadServicio = new JLabel("Cantidad de servicios");
		labelIdFactura = new JLabel("IdFactura: ");
		labelCedula = new JLabel("Cedula: ");
		labelServicio = new JLabel("Servicio: ");
		labelPago = new JLabel("Forma de pago: ");
		labelCantidad = new JLabel("Cantidad: ");
		labelDescuento = new JLabel("Descuento: ");
		txtIdFactura = new JTextField();
		txtCedula = new JTextField();
		txtCantidad = new JTextField();
		txtDescuento = new JTextField();
		txtCantidadServicio = new JTextField();
		btnAgregarServicio = new JButton("Agregar");
		btnAgregarServicio.setActionCommand(COMANDO_AGREARSERVICIO);
		comboServicio = new JComboBox<String>();
		comboPago = new JComboBox<String>();
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setActionCommand(COMANDO_REGISTRARFACTURA);
		panel = new JPanel();
		panel.setLayout(new GridLayout(4, 4));
		panel.add(labelIdFactura);
		panel.add(txtIdFactura);
		panel.add(labelCedula);
		panel.add(txtCedula);
		panel.add(labelPago);
		panel.add(comboPago);
		panel.add(labelCantidadServicio);
		panel.add(txtCantidadServicio);
		panelServicio = new JPanel();
		panelServicio.setLayout(new GridLayout(2, 2));
		panelServicio.add(labelServicio);
		panelServicio.add(comboServicio);
		panelServicio.add(labelCantidad);
		panelServicio.add(txtCantidad);
		panelDivisor = new JPanel();
		panelDivisor.setBorder(new TitledBorder("Agrega servicios"));
		panelDivisor.setLayout(new BorderLayout());
		panelDivisor.add(panelServicio, BorderLayout.CENTER);
		panelDivisor.add(btnAgregarServicio, BorderLayout.PAGE_END);
		splitPane = new JSplitPane();
		splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPane.setTopComponent(panel);
		add(splitPane, BorderLayout.CENTER);
		add(btnConfirmar, BorderLayout.PAGE_END);
	}

	public String[] verificarCampos() {
		String[] entradas = new String[8];
		entradas[0] = "0";
		if (!"".equals(txtCedula.getText()) && !"Seleccione".equals(comboPago.getSelectedItem().toString())
				&& !"".equals(txtIdFactura.getText()) && !"".equals(txtCantidadServicio.getText())) {
			entradas[1] = txtCedula.getText();
			entradas[2] = txtCantidad.getText();
			entradas[3] = txtDescuento.getText();
			entradas[4] = comboPago.getSelectedItem().toString();
			entradas[5] = comboServicio.getSelectedItem().toString();
			entradas[6] = txtIdFactura.getText();
			entradas[7] = txtCantidadServicio.getText();

		} else {
			entradas[0] = "1";
			entradas[1] = "Por favor complete todos los campos";
		}
		return entradas;

	}
	
	public String[] verificarCampos2() {
		String[] entradas = new String[3];
		entradas[0] = "0";
		if (!"".equals(txtCantidad.getText()) && !"Seleccione".equals(comboServicio.getSelectedItem().toString())) {
			entradas[1] = txtCantidad.getText();
			entradas[2] = comboServicio.getSelectedItem().toString();
		} else {
			entradas[0] = "1";
			entradas[1] = "Por favor complete todos los campos";
		}
		return entradas;

	}
	
	public void desabilitarCampos() {
		txtCedula.setEnabled(false);
		comboPago.setEnabled(false);
		txtIdFactura.setEnabled(false);
		txtCantidadServicio.setEnabled(false);
		btnConfirmar.setEnabled(false);
		btnAgregarServicio.setEnabled(true);
	}
	
	public void limpiarCampos() {
		btnAgregarServicio.setEnabled(false);
		txtCedula.setEnabled(true);
		comboPago.setEnabled(true);
		txtIdFactura.setEnabled(true);
		btnConfirmar.setEnabled(true);
		txtCantidadServicio.setEnabled(true);
		txtCantidadServicio.setText("");
		txtCedula.setText("");
		comboPago.setSelectedIndex(0);
		comboServicio.setSelectedIndex(0);
		txtCantidad.setText("");
		txtIdFactura.setText("");
		
	}

	public void activarPanelServicio() {
		splitPane.setBottomComponent(panelDivisor);
		splitPane.setDividerLocation(240);

	}

	public void cargarComboBox(ArrayList<Servicio> servicios, ArrayList<FormaPago> formaPagos) {
		comboServicio.removeAllItems();
		comboServicio.addItem("Seleccione");
		comboPago.removeAllItems();
		comboPago.addItem("Seleccione");

		for (int i = 0; i < servicios.size(); i++) {
			comboServicio.addItem(servicios.get(i).getNombre());
		}

		for (int i = 0; i < formaPagos.size(); i++) {
			comboPago.addItem(formaPagos.get(i).getNombre());
		}
	}

	public JLabel getLabelCedula() {
		return labelCedula;
	}

	public void setLabelCedula(JLabel labelCedula) {
		this.labelCedula = labelCedula;
	}

	public JLabel getLabelServicio() {
		return labelServicio;
	}

	public void setLabelServicio(JLabel labelServicio) {
		this.labelServicio = labelServicio;
	}

	public JLabel getLabelPago() {
		return labelPago;
	}

	public void setLabelPago(JLabel labelPago) {
		this.labelPago = labelPago;
	}

	public JLabel getLabelCantidad() {
		return labelCantidad;
	}

	public void setLabelCantidad(JLabel labelCantidad) {
		this.labelCantidad = labelCantidad;
	}

	public JLabel getLabelDescuento() {
		return labelDescuento;
	}

	public void setLabelDescuento(JLabel labelDescuento) {
		this.labelDescuento = labelDescuento;
	}

	public JTextField getTxtCedula() {
		return txtCedula;
	}

	public void setTxtCedula(JTextField txtCedula) {
		this.txtCedula = txtCedula;
	}

	public JComboBox<String> getComboServicio() {
		return comboServicio;
	}

	public void setComboServicio(JComboBox<String> comboServicio) {
		this.comboServicio = comboServicio;
	}

	public JComboBox<String> getComboPago() {
		return comboPago;
	}

	public void setComboPago(JComboBox<String> comboPago) {
		this.comboPago = comboPago;
	}

	public JTextField getTxtCantidad() {
		return txtCantidad;
	}

	public void setTxtCantidad(JTextField txtCantidad) {
		this.txtCantidad = txtCantidad;
	}

	public JTextField getTxtDescuento() {
		return txtDescuento;
	}

	public void setTxtDescuento(JTextField txtDescuento) {
		this.txtDescuento = txtDescuento;
	}

	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}

	public void setBtnConfirmar(JButton btnConfirmar) {
		this.btnConfirmar = btnConfirmar;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public String getCOMANDO_REGISTRARFACTURA() {
		return COMANDO_REGISTRARFACTURA;
	}

	public JLabel getLabelIdFactura() {
		return labelIdFactura;
	}

	public void setLabelIdFactura(JLabel labelIdFactura) {
		this.labelIdFactura = labelIdFactura;
	}

	public JLabel getLabelAgregarServicio() {
		return labelAgregarServicio;
	}

	public void setLabelAgregarServicio(JLabel labelAgregarServicio) {
		this.labelAgregarServicio = labelAgregarServicio;
	}

	public JTextField getTxtIdFactura() {
		return txtIdFactura;
	}

	public void setTxtIdFactura(JTextField txtIdFactura) {
		this.txtIdFactura = txtIdFactura;
	}

	public JButton getBtnAgregarServicio() {
		return btnAgregarServicio;
	}

	public void setBtnAgregarServicio(JButton btnAgregarServicio) {
		this.btnAgregarServicio = btnAgregarServicio;
	}

	public JPanel getPanelServicio() {
		return panelServicio;
	}

	public void setPanelServicio(JPanel panelServicio) {
		this.panelServicio = panelServicio;
	}

	public String getCOMANDO_AGREARSERVICIO() {
		return COMANDO_AGREARSERVICIO;
	}

	public JPanel getPanelDivisor() {
		return panelDivisor;
	}

	public void setPanelDivisor(JPanel panelDivisor) {
		this.panelDivisor = panelDivisor;
	}

	public JSplitPane getSplitPane() {
		return splitPane;
	}

	public void setSplitPane(JSplitPane splitPane) {
		this.splitPane = splitPane;
	}

	public int getContadorServicios() {
		return contadorServicios;
	}

	public void setContadorServicios(int contadorServicios) {
		this.contadorServicios = contadorServicios;
	}

}
