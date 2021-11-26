package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import co.edu.unbosque.model.persistence.Color;
import co.edu.unbosque.model.persistence.Especie;
import co.edu.unbosque.model.persistence.Raza;

import com.toedter.calendar.JDateChooser;

public class PanelCrearMascota extends JPanel {

	private final String COMANDO_CREAR = "CREARMASCOTA";
	private JLabel labelDatos;
	private JLabel labelIdMascota;
	private JLabel labelNombre;
	private JLabel labelEspecie;
	private JLabel labelRaza;
	private JLabel labelColor;
	private JLabel labelFecha;
	private JTextField txtIdMascota;
	private JTextField txtNombre;
	private JComboBox<String> comboEspecie;
	private JComboBox<String> comboRaza;
	private JComboBox<String> comboColor;
	private JDateChooser fechaNaci;
	private JButton btnConfirmar;
	private JPanel panel1;

	public PanelCrearMascota() {
		setBorder(new TitledBorder("Aqui puedes registrar a tus mascotas"));
		setLayout(new BorderLayout());		
		labelDatos = new JLabel("Ingrese los datos de la mascota");
		labelIdMascota = new JLabel("ID: ");
		labelNombre = new JLabel("Nombre: ");
		labelEspecie = new JLabel("Especie: ");
		labelRaza = new JLabel("Raza: ");
		labelColor = new JLabel("Color: ");
		labelFecha = new JLabel("Fecha nacimiento: ");
		txtIdMascota = new JTextField();
		txtNombre = new JTextField();
		comboEspecie = new JComboBox<String>();
		comboRaza = new JComboBox<String>();
		comboColor = new JComboBox<String>();
		fechaNaci = new JDateChooser();
		btnConfirmar = new JButton("Registrar");
		btnConfirmar.setActionCommand(COMANDO_CREAR);
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(7, 7));
		panel1.add(labelIdMascota);
		panel1.add(txtIdMascota);
		panel1.add(labelNombre);
		panel1.add(txtNombre);
		panel1.add(labelEspecie);
		panel1.add(comboEspecie);
		panel1.add(labelRaza);
		panel1.add(comboRaza);
		panel1.add(labelColor);
		panel1.add(comboColor);
		panel1.add(labelFecha);
		panel1.add(fechaNaci);
		add(labelDatos, BorderLayout.NORTH);
		add(panel1, BorderLayout.CENTER);
		add(btnConfirmar, BorderLayout.PAGE_END);

	}

	public String[] verificarEntradas() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date date = fechaNaci.getDate();
		Date fechaHoy = new Date();
		String[] entradas = new String[7];
		entradas[0] = "0";
		if (!"".equals(txtIdMascota.getText()) && !"".equals(txtNombre.getText())
				&& !"Seleccione".equals(comboColor.getSelectedItem().toString())
				&& !"Seleccione".equals(comboEspecie.getSelectedItem().toString())
				&& !"Seleccione".equals(comboRaza.getSelectedItem().toString()) && date != null) {
			if (date.after(fechaHoy)) {
				entradas[0] = "1";
				entradas[1] = "Fecha incorrecta";
			} else {
				entradas[1] = txtIdMascota.getText();
				entradas[2] = txtNombre.getText();
				entradas[3] = comboEspecie.getSelectedItem().toString();
				entradas[4] = comboRaza.getSelectedItem().toString();
				entradas[5] = comboColor.getSelectedItem().toString();
				entradas[6] = formato.format(date);
			}
		} else {
			entradas[0] = "1";
			entradas[1] = "Complete todos los campos";
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
		txtIdMascota.setText("");
		txtNombre.setText("");
		comboEspecie.setSelectedIndex(0);
		comboRaza.setSelectedIndex(0);
		comboColor.setSelectedIndex(0);
		fechaNaci.setDate(null);
	}

	public JLabel getLabelDatos() {
		return labelDatos;
	}

	public void setLabelDatos(JLabel labelDatos) {
		this.labelDatos = labelDatos;
	}

	public JLabel getLabelNombre() {
		return labelNombre;
	}

	public void setLabelNombre(JLabel labelNombre) {
		this.labelNombre = labelNombre;
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

	public JDateChooser getFechaNaci() {
		return fechaNaci;
	}

	public void setFechaNaci(JDateChooser fechaNaci) {
		this.fechaNaci = fechaNaci;
	}

	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}

	public void setBtnConfirmar(JButton btnConfirmar) {
		this.btnConfirmar = btnConfirmar;
	}

	public JPanel getPanel() {
		return panel1;
	}

	public void setPanel(JPanel panel) {
		this.panel1 = panel;
	}

	public String getCOMANDO_CREAR() {
		return COMANDO_CREAR;
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

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

}
