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

import co.edu.unbosque.model.persistence.Color;
import co.edu.unbosque.model.persistence.Especie;
import co.edu.unbosque.model.persistence.Raza;

public class PanelFiltroMascotaC extends JPanel {

	private final String COMANDO_FILTRO = "FILTRO";
	private JLabel labelNombre;
	private JLabel labelEspecie;
	private JLabel labelRaza;
	private JLabel labelColor;
	private JLabel labelFecha;
	private JDateChooser fechaNaci;
	private JTextField txtNombre;
	private JComboBox<String> comboEspecie;
	private JComboBox<String> comboRaza;
	private JComboBox<String> comboColor;
	private JButton btnConfirmar;
	private JPanel panel;

	public PanelFiltroMascotaC() {
		setBorder(new TitledBorder("Filtro de mascotas"));
		setLayout(new BorderLayout());
		labelNombre = new JLabel("Nombre: ");
		labelEspecie = new JLabel("Especie: ");
		labelRaza = new JLabel("Raza: ");
		labelColor = new JLabel("Color: ");
		labelFecha = new JLabel("Fecha: ");
		fechaNaci = new JDateChooser();
		txtNombre = new JTextField();
		comboEspecie = new JComboBox<String>();
		comboRaza = new JComboBox<String>();
		comboColor = new JComboBox<String>();
		btnConfirmar = new JButton("Filtrar");
		btnConfirmar.setActionCommand(COMANDO_FILTRO);
		panel = new JPanel();
		panel.setLayout(new GridLayout(5, 5));
		panel.add(labelNombre);
		panel.add(txtNombre);
		panel.add(labelEspecie);
		panel.add(comboEspecie);
		panel.add(labelRaza);
		panel.add(comboRaza);
		panel.add(labelColor);
		panel.add(comboColor);
		panel.add(labelFecha);
		panel.add(fechaNaci);
		add(panel, BorderLayout.CENTER);
		add(btnConfirmar, BorderLayout.PAGE_END);
	}

	public String[][] verificarCampos() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String[][] entradas = new String[6][2];
		entradas[0][0] = "0";

		if ("".equals(txtNombre.getText()) && "Seleccione".equals(comboEspecie.getSelectedItem().toString())
				&& "Seleccione".equals(comboRaza.getSelectedItem().toString())
				&& "Seleccione".equals(comboColor.getSelectedItem().toString()) && fechaNaci.getDate() == null) {
			entradas[0][0] = "1";
			entradas[0][1] = "Llene al menos un campo a filtrar";
		} else {
			if (fechaNaci.getDate() == null) {
				entradas[1][0] = "a.nombre";
				entradas[1][1] = txtNombre.getText();
				entradas[2][0] = "b.nombre";
				entradas[2][1] = comboEspecie.getSelectedItem().toString();
				entradas[3][0] = "c.nombre";
				entradas[3][1] = comboRaza.getSelectedItem().toString();
				entradas[4][0] = "d.nombre";
				entradas[4][1] = comboColor.getSelectedItem().toString();
				entradas[5][0] = "a.añonacimiento";
				entradas[5][1] = "";
			} else {
				entradas[1][0] = "a.nombre";
				entradas[1][1] = txtNombre.getText();
				entradas[2][0] = "b.nombre";
				entradas[2][1] = comboEspecie.getSelectedItem().toString();
				entradas[3][0] = "c.nombre";
				entradas[3][1] = comboRaza.getSelectedItem().toString();
				entradas[4][0] = "d.nombre";
				entradas[4][1] = comboColor.getSelectedItem().toString();
				entradas[5][0] = "a.añonacimiento";
				entradas[5][1] = formato.format(fechaNaci.getDate());
			}
		}

		return entradas;
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
	
	public void limpiarCampos() {
		txtNombre.setText("");
		fechaNaci.setDate(null);
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

	public JDateChooser getFechaNaci() {
		return fechaNaci;
	}

	public void setFechaNaci(JDateChooser fechaNaci) {
		this.fechaNaci = fechaNaci;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}

	public void setBtnConfirmar(JButton btnConfirmar) {
		this.btnConfirmar = btnConfirmar;
	}

	public String getCOMANDO_FILTRO() {
		return COMANDO_FILTRO;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JComboBox<String> getComboEspecie() {
		return comboEspecie;
	}

	public void setComboEspecie(JComboBox<String> comboEspecie) {
		this.comboEspecie = comboEspecie;
	}

	public JComboBox<String> getComboRaza() {
		return comboRaza;
	}

	public void setComboRaza(JComboBox<String> comboRaza) {
		this.comboRaza = comboRaza;
	}

	public JComboBox<String> getComboColor() {
		return comboColor;
	}

	public void setComboColor(JComboBox<String> comboColor) {
		this.comboColor = comboColor;
	}

}
