package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelCrearServicio extends JPanel {

	private final String COMANDO_REGISTARSERVICIO = "CREARSERVICIO";
	private JLabel labelNombre;
	private JLabel labelDescripcion;
	private JLabel labelPrecio;
	private JTextField txtNombre;
	private JTextField txtDescripcion;
	private JTextField txtPrecio;
	private JButton btnConfirmar;
	private JPanel panel;

	public PanelCrearServicio() {
		setBorder(new TitledBorder("Aqui puedes registrar un nuevo servicio"));
		setLayout(new BorderLayout());
		labelNombre = new JLabel("Nombre: ");
		labelDescripcion = new JLabel("Descripción: ");
		labelPrecio = new JLabel("Precio: ");
		txtNombre = new JTextField();
		txtDescripcion = new JTextField();
		txtPrecio = new JTextField();
		btnConfirmar = new JButton("Crear servicio");
		btnConfirmar.setActionCommand(COMANDO_REGISTARSERVICIO);
		panel = new JPanel();
		panel.setLayout(new GridLayout(3, 3));
		panel.add(labelNombre);
		panel.add(txtNombre);
		panel.add(labelDescripcion);
		panel.add(txtDescripcion);
		panel.add(labelPrecio);
		panel.add(txtPrecio);
		add(panel, BorderLayout.CENTER);
		add(btnConfirmar, BorderLayout.PAGE_END);
	}

	public String[] verificarCampos() {
		String[] entradas = new String[4];
		entradas[0] = "0";
		if (!"".equals(txtNombre.getText()) && !"".equals(txtDescripcion.getText())
				&& !"".equals(txtPrecio.getText())) {
			entradas[1] = txtNombre.getText();
			entradas[2] = txtDescripcion.getText();
			entradas[3] = txtPrecio.getText();
		}else {
			entradas[0] = "1";
			entradas[1] = "Complete los campos";
		}
		return entradas;
	}

	public JLabel getLabelNombre() {
		return labelNombre;
	}

	public void setLabelNombre(JLabel labelNombre) {
		this.labelNombre = labelNombre;
	}

	public JLabel getLabelDescripcion() {
		return labelDescripcion;
	}

	public void setLabelDescripcion(JLabel labelDescripcion) {
		this.labelDescripcion = labelDescripcion;
	}

	public JLabel getLabelPrecio() {
		return labelPrecio;
	}

	public void setLabelPrecio(JLabel labelPrecio) {
		this.labelPrecio = labelPrecio;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtDescripcion() {
		return txtDescripcion;
	}

	public void setTxtDescripcion(JTextField txtDescripcion) {
		this.txtDescripcion = txtDescripcion;
	}

	public JTextField getTxtPrecio() {
		return txtPrecio;
	}

	public void setTxtPrecio(JTextField txtPrecio) {
		this.txtPrecio = txtPrecio;
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

	public String getCOMANDO_REGISTARSERVICIO() {
		return COMANDO_REGISTARSERVICIO;
	}
}
