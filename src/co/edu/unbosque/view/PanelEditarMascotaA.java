package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import co.edu.unbosque.model.persistence.Color;
import co.edu.unbosque.model.persistence.Especie;
import co.edu.unbosque.model.persistence.Raza;

public class PanelEditarMascotaA extends JPanel {

	private final String COMANDO_EDITARMASCOTA = "EDITARMASCOTAA";
	private final String COMANDO_VOLVER = "VOLVER13";
	private final String COMANDO_DATOEDITAR = "CAMBIARPANEL";
	private JLabel labelId;
	private JLabel labelNombre;
	private JLabel labelEspecie;
	private JLabel labelRaza;
	private JLabel labelColor;
	private JLabel labelFecha;
	private JLabel labelId2;
	private JLabel labelNombre2;
	private JLabel labelEspecie2;
	private JLabel labelRaza2;
	private JLabel labelColor2;
	private JLabel labelFecha2;
	private JLabel labelOpcion;
	private JLabel labelCombo;
	private JLabel labelDatoEspecie;
	private JComboBox<String> comboEspecie;
	private JLabel labelDatoRaza;
	private JComboBox<String> comboRaza;
	private JLabel labelDatoColor;
	private JComboBox<String> comboColor;
	private JComboBox<String> comboOpcion;
	private JTextField txtDato;
	private JButton btnConfirmar;
	private JButton btnVolver;
	private JPanel panel;
	private JPanel panelBotones;
	private JSplitPane splitPane;
	private JPanel panelEspecie;
	private JPanel panelRaza;
	private JPanel panelColor;
	private JPanel panelNombre;

	public PanelEditarMascotaA() {
		setBorder(new TitledBorder("Editar Mascota"));
		setLayout(new BorderLayout());
		labelId = new JLabel("Id: ");
		labelNombre = new JLabel("Nombre: ");
		labelEspecie = new JLabel("Especie: ");
		labelRaza = new JLabel("Raza: ");
		labelColor = new JLabel("Color: ");
		labelFecha = new JLabel("Fecha: ");
		labelId2 = new JLabel("Id: ");
		labelNombre2 = new JLabel();
		labelEspecie2 = new JLabel();
		labelRaza2 = new JLabel();
		labelColor2 = new JLabel();
		labelFecha2 = new JLabel();
		labelCombo = new JLabel("Selecciona el dato a editar: ");
		labelOpcion = new JLabel("Escriba el nuevo nombre: ");
		comboOpcion = new JComboBox<String>();
		comboOpcion.addItem("Seleccione");
		comboOpcion.addItem("Nombre");
		comboOpcion.addItem("Especie");
		comboOpcion.addItem("Raza");
		comboOpcion.addItem("Color");
		comboOpcion.setActionCommand(COMANDO_DATOEDITAR);
		txtDato = new JTextField();
		btnConfirmar = new JButton("Editar");
		btnConfirmar.setActionCommand(COMANDO_EDITARMASCOTA);
		btnVolver = new JButton("Volver");
		btnVolver.setActionCommand(COMANDO_VOLVER);
		panel = new JPanel();
		panel.setLayout(new GridLayout(7, 7));
		panel.add(labelId);
		panel.add(labelId2);
		panel.add(labelNombre);
		panel.add(labelNombre2);
		panel.add(labelEspecie);
		panel.add(labelEspecie2);
		panel.add(labelRaza);
		panel.add(labelRaza2);
		panel.add(labelColor);
		panel.add(labelColor2);
		panel.add(labelFecha);
		panel.add(labelFecha2);
		panel.add(labelCombo);
		panel.add(comboOpcion);
		panelNombre = new JPanel();
		panelNombre.setLayout(new GridLayout(1, 2));
		panelNombre.add(labelOpcion);
		panelNombre.add(txtDato);
		panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(1, 2));
		panelBotones.add(btnConfirmar);
		panelBotones.add(btnVolver);
		splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPane.setEnabled(false);
		splitPane.setTopComponent(panel);
		panelEspecie = new JPanel();
		panelEspecie.setLayout(new GridLayout(1, 2));
		labelDatoEspecie = new JLabel("Elija la especie");
		panelRaza = new JPanel();
		panelRaza.setLayout(new GridLayout(1, 2));
		labelDatoRaza = new JLabel("Elija la Raza");
		panelColor = new JPanel();
		panelColor.setLayout(new GridLayout(1, 2));
		labelDatoColor = new JLabel("Elija el color");
		comboEspecie = new JComboBox<String>();
		comboColor = new JComboBox<String>();
		comboRaza = new JComboBox<String>();
		panelEspecie.add(labelDatoEspecie);
		panelEspecie.add(comboEspecie);
		panelRaza.add(labelDatoRaza);
		panelRaza.add(comboRaza);
		panelColor.add(labelDatoColor);
		panelColor.add(comboColor);

		add(splitPane);
		add(panelBotones, BorderLayout.PAGE_END);
	}

	public String[][] verificarCampos() {
		String[][] entradas = new String[2][5];
		entradas[0][0] = "0";
		if (!"Seleccione".equals(comboOpcion.getSelectedItem().toString())) {
			if ("Nombre".equals(comboOpcion.getSelectedItem().toString())) {
				if (!"".equals(txtDato.getText())) {
					entradas[1][0] = "nombre";
					entradas[1][1] = txtDato.getText();
					entradas[1][2] = labelId2.getText();
					entradas[1][3] = "nombre";
					entradas[1][4] = "nombre";

				} else {
					entradas[0][0] = "1";
					entradas[0][1] = "Complete el campo";
				}
			}
			if ("Especie".equals(comboOpcion.getSelectedItem().toString())) {
				if (!"Seleccione".equals(comboEspecie.getSelectedItem().toString())) {
					entradas[1][0] = "especie";
					entradas[1][1] = comboEspecie.getSelectedItem().toString();
					entradas[1][2] = labelId2.getText();
					entradas[1][3] = "idespecie";
					entradas[1][4] = "nombre";

				} else {
					entradas[0][0] = "1";
					entradas[0][1] = "Seleccione la especie";
				}
			}
			if ("Raza".equals(comboOpcion.getSelectedItem().toString())) {
				if (!"Seleccione".equals(comboRaza.getSelectedItem().toString())) {
					entradas[1][0] = "raza";
					entradas[1][1] = comboRaza.getSelectedItem().toString();
					entradas[1][2] = labelId2.getText();
					entradas[1][3] = "idraza";
					entradas[1][4] = "nombre";

				} else {
					entradas[0][0] = "1";
					entradas[0][1] = "Seleccione la raza";
				}
			}
			if ("Color".equals(comboOpcion.getSelectedItem().toString())) {
				if (!"Seleccione".equals(comboColor.getSelectedItem().toString())) {
					entradas[1][0] = "color";
					entradas[1][1] = comboColor.getSelectedItem().toString();
					entradas[1][2] = labelId2.getText();
					entradas[1][3] = "idcolor";
					entradas[1][4] = "nombre";
				} else {
					entradas[0][0] = "1";
					entradas[0][1] = "Seleccione el color";
				}
			}
		} else {
			entradas[0][0] = "1";
			entradas[0][1] = "Seleccione el dato a editar";
		}
		return entradas;
	}

	public void recibirDatosMascota(String id, String nombre, String especie, String raza, String color, String fecha) {
		labelId2.setText(id);
		labelNombre2.setText(nombre);
		labelEspecie2.setText(especie);
		labelRaza2.setText(raza);
		labelColor2.setText(color);
		labelFecha2.setText(fecha);
	}

	public void cargarComboBox(ArrayList<Color> colores, ArrayList<Especie> especies, ArrayList<Raza> razas) {
		comboColor.removeAllItems();
		comboColor.addItem("Seleccione");
		comboRaza.removeAllItems();
		comboRaza.addItem("Seleccione");
		comboEspecie.removeAllItems();
		comboEspecie.addItem("Seleccione");
		for (int i = 0; i < colores.size(); i++) {
			comboColor.addItem(colores.get(i).getNombre());
		}
		for (int i = 0; i < razas.size(); i++) {
			comboRaza.addItem(razas.get(i).getNombre());
		}
		for (int i = 0; i < especies.size(); i++) {
			comboEspecie.addItem(especies.get(i).getNombre());
		}
	}

	public void cambiarPanel() {
		if ("Especie".equals(comboOpcion.getSelectedItem().toString())) {
			splitPane.setBottomComponent(panelEspecie);
			splitPane.setDividerLocation(350);
		}
		if ("Raza".equals(comboOpcion.getSelectedItem().toString())) {
			splitPane.setBottomComponent(panelRaza);
			splitPane.setDividerLocation(350);
		}
		if ("Color".equals(comboOpcion.getSelectedItem().toString())) {
			splitPane.setBottomComponent(panelColor);
			splitPane.setDividerLocation(350);
		}
		if ("Nombre".equals(comboOpcion.getSelectedItem().toString())) {
			splitPane.setBottomComponent(panelNombre);
			splitPane.setDividerLocation(350);
		}
	}

	public void limpiarCampos() {
		txtDato.setText("");
		comboOpcion.setSelectedIndex(0);
	}

	public JLabel getLabelId() {
		return labelId;
	}

	public void setLabelId(JLabel labelId) {
		this.labelId = labelId;
	}

	public JLabel getLabelNombre() {
		return labelNombre;
	}

	public void setLabelNombre(JLabel labelNombre) {
		this.labelNombre = labelNombre;
	}

	public JLabel getLabelEspecie() {
		return labelEspecie;
	}

	public void setLabelEspecie(JLabel labelEspecie) {
		this.labelEspecie = labelEspecie;
	}

	public JLabel getLabelRaza() {
		return labelRaza;
	}

	public void setLabelRaza(JLabel labelRaza) {
		this.labelRaza = labelRaza;
	}

	public JLabel getLabelColor() {
		return labelColor;
	}

	public void setLabelColor(JLabel labelColor) {
		this.labelColor = labelColor;
	}

	public JLabel getLabelFecha() {
		return labelFecha;
	}

	public void setLabelFecha(JLabel labelFecha) {
		this.labelFecha = labelFecha;
	}

	public JLabel getLabelId2() {
		return labelId2;
	}

	public void setLabelId2(JLabel labelId2) {
		this.labelId2 = labelId2;
	}

	public JLabel getLabelNombre2() {
		return labelNombre2;
	}

	public void setLabelNombre2(JLabel labelNombre2) {
		this.labelNombre2 = labelNombre2;
	}

	public JLabel getLabelEspecie2() {
		return labelEspecie2;
	}

	public void setLabelEspecie2(JLabel labelEspecie2) {
		this.labelEspecie2 = labelEspecie2;
	}

	public JLabel getLabelRaza2() {
		return labelRaza2;
	}

	public void setLabelRaza2(JLabel labelRaza2) {
		this.labelRaza2 = labelRaza2;
	}

	public JLabel getLabelColor2() {
		return labelColor2;
	}

	public void setLabelColor2(JLabel labelColor2) {
		this.labelColor2 = labelColor2;
	}

	public JLabel getLabelFecha2() {
		return labelFecha2;
	}

	public void setLabelFecha2(JLabel labelFecha2) {
		this.labelFecha2 = labelFecha2;
	}

	public JLabel getLabelOpcion() {
		return labelOpcion;
	}

	public void setLabelOpcion(JLabel labelOpcion) {
		this.labelOpcion = labelOpcion;
	}

	public JLabel getLabelCombo() {
		return labelCombo;
	}

	public void setLabelCombo(JLabel labelCombo) {
		this.labelCombo = labelCombo;
	}

	public JComboBox<String> getComboOpcion() {
		return comboOpcion;
	}

	public void setComboOpcion(JComboBox<String> comboOpcion) {
		this.comboOpcion = comboOpcion;
	}

	public JTextField getTxtDato() {
		return txtDato;
	}

	public void setTxtDato(JTextField txtDato) {
		this.txtDato = txtDato;
	}

	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}

	public void setBtnConfirmar(JButton btnConfirmar) {
		this.btnConfirmar = btnConfirmar;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JPanel getPanelBotones() {
		return panelBotones;
	}

	public void setPanelBotones(JPanel panelBotones) {
		this.panelBotones = panelBotones;
	}

	public String getCOMANDO_EDITARMASCOTA() {
		return COMANDO_EDITARMASCOTA;
	}

	public String getCOMANDO_VOLVER() {
		return COMANDO_VOLVER;
	}

	public JLabel getLabelDatoEspecie() {
		return labelDatoEspecie;
	}

	public void setLabelDatoEspecie(JLabel labelDatoEspecie) {
		this.labelDatoEspecie = labelDatoEspecie;
	}

	public JComboBox<String> getComboEspecie() {
		return comboEspecie;
	}

	public void setComboEspecie(JComboBox<String> comboEspecie) {
		this.comboEspecie = comboEspecie;
	}

	public JLabel getLabelDatoRaza() {
		return labelDatoRaza;
	}

	public void setLabelDatoRaza(JLabel labelDatoRaza) {
		this.labelDatoRaza = labelDatoRaza;
	}

	public JComboBox<String> getComboRaza() {
		return comboRaza;
	}

	public void setComboRaza(JComboBox<String> comboRaza) {
		this.comboRaza = comboRaza;
	}

	public JLabel getLabelDatoColor() {
		return labelDatoColor;
	}

	public void setLabelDatoColor(JLabel labelDatoColor) {
		this.labelDatoColor = labelDatoColor;
	}

	public JComboBox<String> getComboColor() {
		return comboColor;
	}

	public void setComboColor(JComboBox<String> comboColor) {
		this.comboColor = comboColor;
	}

	public JSplitPane getSplitPane() {
		return splitPane;
	}

	public void setSplitPane(JSplitPane splitPane) {
		this.splitPane = splitPane;
	}

	public JPanel getPanelEspecie() {
		return panelEspecie;
	}

	public void setPanelEspecie(JPanel panelEspecie) {
		this.panelEspecie = panelEspecie;
	}

	public String getCOMANDO_DATOEDITAR() {
		return COMANDO_DATOEDITAR;
	}

	public JPanel getPanelRaza() {
		return panelRaza;
	}

	public void setPanelRaza(JPanel panelRaza) {
		this.panelRaza = panelRaza;
	}

	public JPanel getPanelColor() {
		return panelColor;
	}

	public void setPanelColor(JPanel panelColor) {
		this.panelColor = panelColor;
	}

	public JPanel getPanelNombre() {
		return panelNombre;
	}

	public void setPanelNombre(JPanel panelNombre) {
		this.panelNombre = panelNombre;
	}
	

}
