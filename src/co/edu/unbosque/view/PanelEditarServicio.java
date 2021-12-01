package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelEditarServicio extends JPanel {

	private final String COMANDO_EDITARSERVICIO = "EDITARSERVICIO32";
	private final String COMANDO_EDITAROPCION = "EDITAROPCION";
	private JLabel labelOpcion;
	private JLabel labelDato;
	private JLabel labelNombre;
	private JLabel labelId;
	private JLabel labelPrecio;
	private JLabel labelNombre2;
	private JLabel labelId2;
	private JLabel labelPrecio2;
	private JComboBox<String> comboDesicion;
	private JButton btnConfirmar;
	private JPanel panel;
	private JPanel panel2;
	private JSplitPane splitPane;
	private JTextField txtDato;

	public PanelEditarServicio() {
		setBorder(new TitledBorder("Aqui puedes registrar un nuevo servicio"));
		setLayout(new BorderLayout());
		labelOpcion = new JLabel("Elija el dato aeditar");
		labelDato = new JLabel("Escriba el nuevo dato: ");
		labelNombre = new JLabel("Nombre: ");
		labelId = new JLabel("Id: ");
		labelPrecio = new JLabel("Precio: ");
		labelNombre2 = new JLabel();
		labelId2 = new JLabel();
		labelPrecio2 = new JLabel();
		txtDato = new JTextField();
		btnConfirmar = new JButton("Crear servicio");
		btnConfirmar.setActionCommand(COMANDO_EDITARSERVICIO);
		comboDesicion = new JComboBox<String>();
		comboDesicion.addItem("Seleccione");
		comboDesicion.addItem("Nombre");
		comboDesicion.addItem("Descripción");
		comboDesicion.addItem("Precio");
		comboDesicion.setActionCommand(COMANDO_EDITAROPCION);
		panel = new JPanel();
		panel.setLayout(new GridLayout(4, 4));
		panel.add(labelId);
		panel.add(labelId2);
		panel.add(labelNombre);
		panel.add(labelNombre2);
		panel.add(labelPrecio);
		panel.add(labelPrecio2);
		panel.add(labelOpcion);
		panel.add(comboDesicion);
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1, 2));
		panel2.add(labelDato);
		panel2.add(txtDato);
		splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPane.setEnabled(false);
		splitPane.setTopComponent(panel);

		add(splitPane, BorderLayout.CENTER);
		add(btnConfirmar, BorderLayout.PAGE_END);
	}

	public String[][] verificarCampos() {
		String[][] entradas = new String[2][4];
		entradas[0][0] = "0";
		if (!"Seleccione".equals(comboDesicion.getSelectedItem().toString())) {
			if(!"".equals(txtDato.getText())) {
				if(comboDesicion.getSelectedItem().toString().equals("Nombre")){
					entradas[1][0] = "nombre";
					entradas[1][1] = txtDato.getText();
					entradas[1][2] = labelId2.getText();
					entradas[1][3] = comboDesicion.getSelectedItem().toString();

				}
				if(comboDesicion.getSelectedItem().toString().equals("Descripción")){
					entradas[1][0] = "descripcion";
					entradas[1][1] = txtDato.getText();
					entradas[1][2] = labelId2.getText();
					entradas[1][3] = comboDesicion.getSelectedItem().toString();
				}
				if(comboDesicion.getSelectedItem().toString().equals("Precio")){
					entradas[1][0] = "preciototal";
					entradas[1][1] = txtDato.getText();
					entradas[1][2] = labelId2.getText();
					entradas[1][3] = comboDesicion.getSelectedItem().toString();
				}
			}else {
				entradas[0][0] = "1";
				entradas[0][1] = "Complete los campos";
			}
			
		} else {
			entradas[0][0] = "1";
			entradas[0][1] = "Selccione el dato a editar";
		}
		return entradas;
	}
	
	public void limpiarCampos() {
		txtDato.setText("");
		comboDesicion.setSelectedIndex(0);
	}
	
	public void recibirDatos(String id, String nombre, String precio) {
		labelId2.setText(id);
		labelNombre2.setText(nombre);
		labelPrecio2.setText(precio);
	}

	public void cambiarPanel() {
		if ("Nombre".equals(comboDesicion.getSelectedItem().toString())) {
			splitPane.setBottomComponent(panel2);
			splitPane.setDividerLocation(350);
		}
		if ("Descripción".equals(comboDesicion.getSelectedItem().toString())) {
			splitPane.setBottomComponent(panel2);
			splitPane.setDividerLocation(350);
		}
		if ("Precio".equals(comboDesicion.getSelectedItem().toString())) {
			splitPane.setBottomComponent(panel2);
			splitPane.setDividerLocation(350);
		}
	}

	public JLabel getLabelOpcion() {
		return labelOpcion;
	}

	public void setLabelOpcion(JLabel labelOpcion) {
		this.labelOpcion = labelOpcion;
	}

	public JLabel getLabelDato() {
		return labelDato;
	}

	public void setLabelDato(JLabel labelDato) {
		this.labelDato = labelDato;
	}

	public JLabel getLabelNombre() {
		return labelNombre;
	}

	public void setLabelNombre(JLabel labelNombre) {
		this.labelNombre = labelNombre;
	}

	public JLabel getLabelId() {
		return labelId;
	}

	public void setLabelId(JLabel labelId) {
		this.labelId = labelId;
	}

	public JLabel getLabelPrecio() {
		return labelPrecio;
	}

	public void setLabelPrecio(JLabel labelPrecio) {
		this.labelPrecio = labelPrecio;
	}

	public JLabel getLabelNombre2() {
		return labelNombre2;
	}

	public void setLabelNombre2(JLabel labelNombre2) {
		this.labelNombre2 = labelNombre2;
	}

	public JLabel getLabelId2() {
		return labelId2;
	}

	public void setLabelId2(JLabel labelId2) {
		this.labelId2 = labelId2;
	}

	public JLabel getLabelPrecio2() {
		return labelPrecio2;
	}

	public void setLabelPrecio2(JLabel labelPrecio2) {
		this.labelPrecio2 = labelPrecio2;
	}

	public JComboBox<String> getComboDesicion() {
		return comboDesicion;
	}

	public void setComboDesicion(JComboBox<String> comboDesicion) {
		this.comboDesicion = comboDesicion;
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

	public JPanel getPanel2() {
		return panel2;
	}

	public void setPanel2(JPanel panel2) {
		this.panel2 = panel2;
	}

	public JSplitPane getSplitPane() {
		return splitPane;
	}

	public void setSplitPane(JSplitPane splitPane) {
		this.splitPane = splitPane;
	}

	public JTextField getTxtDato() {
		return txtDato;
	}

	public void setTxtDato(JTextField txtDato) {
		this.txtDato = txtDato;
	}

	public String getCOMANDO_EDITARSERVICIO() {
		return COMANDO_EDITARSERVICIO;
	}

	public String getCOMANDO_EDITAROPCION() {
		return COMANDO_EDITAROPCION;
	}

}
