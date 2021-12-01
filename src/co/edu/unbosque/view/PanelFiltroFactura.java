package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;
import co.edu.unbosque.model.persistence.FormaPago;

public class PanelFiltroFactura extends JPanel {

	private final String COMANDO_FILTRO = "FILTRO100";
	private JLabel labelId;
	private JLabel labelFormaPago;
	private JLabel labelFecha;
	private JTextField txtId;
	private JComboBox<String> comboForma;
	private JDateChooser fecha;
	private JButton btnConfirmar;
	private JPanel panel;

	public PanelFiltroFactura() {
		setBorder(new TitledBorder("Filtro de facturas"));
		setLayout(new BorderLayout());
		labelId = new JLabel("Id: ");
		labelFormaPago = new JLabel("Forma de pago: ");
		labelFecha = new JLabel("Fecha: ");
		txtId = new JTextField();
		comboForma = new JComboBox<String>();
		fecha = new JDateChooser();
		btnConfirmar = new JButton("Filtrar");
		btnConfirmar.setActionCommand(COMANDO_FILTRO);
		panel = new JPanel();
		panel.setLayout(new GridLayout(3, 3));
		panel.add(labelId);
		panel.add(txtId);
		panel.add(labelFormaPago);
		panel.add(comboForma);
		panel.add(labelFecha);
		panel.add(fecha);
		add(panel, BorderLayout.CENTER);
		add(btnConfirmar, BorderLayout.PAGE_END);
	}

	public String[][] verificarCampos() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String[][] entradas = new String[4][2];
		entradas[0][0] = "0";
		if ("".equals(txtId.getText()) && fecha.getDate() == null
				&& "Seleccione".equals(comboForma.getSelectedItem().toString())) {
			entradas[0][1] = "Seleccione al menos un dato";
			entradas[0][0] = "1";
		} else {
			if (fecha.getDate() == null) {
				entradas[1][0] = "a.idfactura";
				entradas[1][1] = txtId.getText();
				entradas[2][0] = "a.fechageneracion";
				entradas[2][1] = "";
				entradas[3][0] = "b.nombre";
				entradas[3][1] = comboForma.getSelectedItem().toString();
			} else {
				entradas[1][0] = "a.idfactura";
				entradas[1][1] = txtId.getText();
				entradas[2][0] = "a.fechageneracion";
				entradas[2][1] = formato.format(fecha.getDate());
				entradas[3][0] = "b.nombre";
				entradas[3][1] = comboForma.getSelectedItem().toString();
			}

		}
		return entradas;
	}

	public void cargarComboBox(ArrayList<FormaPago> formasPago) {
		comboForma.removeAllItems();
		comboForma.addItem("Seleccione");
		for (int i = 0; i < formasPago.size(); i++) {
			comboForma.addItem(formasPago.get(i).getNombre());
		}
	}

	public JLabel getLabelId() {
		return labelId;
	}

	public void setLabelId(JLabel labelId) {
		this.labelId = labelId;
	}

	public JLabel getLabelFecha() {
		return labelFecha;
	}

	public void setLabelFecha(JLabel labelFecha) {
		this.labelFecha = labelFecha;
	}

	public JTextField getTxtId() {
		return txtId;
	}

	public void setTxtId(JTextField txtId) {
		this.txtId = txtId;
	}

	public JDateChooser getFecha() {
		return fecha;
	}

	public void setFecha(JDateChooser fecha) {
		this.fecha = fecha;
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

	public String getCOMANDO_FILTRO() {
		return COMANDO_FILTRO;
	}
}
