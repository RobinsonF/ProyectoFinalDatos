package co.edu.unbosque.view;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
	private JLabel labelIdFactura;
	private JLabel labelCedula;
	private JLabel labelServicio;
	private JLabel labelPago;
	private JLabel labelCantidad;
	private JLabel labelDescuento;
	private JTextField txtCedula;
	private JComboBox<String> comboServicio;
	private JComboBox<String> comboPago;
	private JTextField txtCantidad;
	private JTextField txtDescuento;
	private JTextField txtIdFactura;
	private JButton btnConfirmar;
	private JPanel panel;

	public PanelEmpleadoServicio() {
		setBorder(new TitledBorder("Servicio"));
		setLayout(new BorderLayout());
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
		comboServicio = new JComboBox<String>();
		comboPago = new JComboBox<String>();
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setActionCommand(COMANDO_REGISTRARFACTURA);
		panel = new JPanel();
		panel.setLayout(new GridLayout(6, 6));
		panel.add(labelIdFactura);
		panel.add(txtIdFactura);
		panel.add(labelCedula);
		panel.add(txtCedula);
		panel.add(labelServicio);
		panel.add(comboServicio);
		panel.add(labelPago);
		panel.add(comboPago);
		panel.add(labelCantidad);
		panel.add(txtCantidad);
		panel.add(labelDescuento);
		panel.add(txtDescuento);
		add(panel, BorderLayout.CENTER);
		add(btnConfirmar, BorderLayout.PAGE_END);
	}

	public String[] verificarCampos() {
		String[] entradas = new String[7];
		entradas[0] = "0";
		if (!"".equals(txtCedula.getText()) && !"".equals(txtCantidad.getText()) && !"".equals(txtDescuento.getText())
				&& !"Seleccione".equals(comboPago.getSelectedItem().toString())
				&& !"Seleccione".equals(comboServicio.getSelectedItem().toString()) && !"".equals(txtIdFactura.getText())) {
			entradas[1] = txtCedula.getText();
			entradas[2] = txtCantidad.getText();
			entradas[3] = txtDescuento.getText();
			entradas[4] = comboPago.getSelectedItem().toString();
			entradas[5] = comboServicio.getSelectedItem().toString();
			entradas[6] = txtIdFactura.getText();

		} else {
			entradas[0] = "1";
			entradas[1] = "Por favor complete todos los campos";
		}
		return entradas;
			
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

}
