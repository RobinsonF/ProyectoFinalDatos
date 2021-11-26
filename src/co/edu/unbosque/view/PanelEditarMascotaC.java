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
import co.edu.unbosque.model.persistence.Mascota;
import co.edu.unbosque.model.persistence.Raza;

public class PanelEditarMascotaC extends JPanel {

	private final String COMANDO_EDITARMASCOTA = "EDITARMASCOTA2";
	private final String COMANDO_VOLVER = "VOLVER";
	private JLabel labelBienvenida;
	private JLabel labelIdMascota;
	private JLabel labelNombre;
	private JLabel labelEspecie;
	private JLabel labelRaza;
	private JLabel labelColor;
	private JLabel labelFecha;
	private JComboBox<String> comboID;
	private JTextField txtNombre;
	private JComboBox<String> comboEspecie;
	private JComboBox<String> comboRaza;
	private JComboBox<String> comboColor;
	private JDateChooser fecha;
	private JButton btnConfirmar;
	private JButton btnVolver;
	private JPanel panel;
	private JPanel panelBotones;
	private JPanel panel2;

	public PanelEditarMascotaC() {
		setBorder(new TitledBorder("Editar Mascotas"));
		setLayout(new BorderLayout());
		labelIdMascota = new JLabel("Seleccione el id de la mascota a editar: ");
		labelNombre = new JLabel("Nombre: ");
		labelEspecie = new JLabel("Especie: ");
		labelRaza = new JLabel("Raza: ");
		labelColor = new JLabel("Color: ");
		labelFecha = new JLabel("Fecha: ");
		comboID = new JComboBox<String>();
		txtNombre = new JTextField();
		comboEspecie = new JComboBox<String>();
		comboRaza = new JComboBox<String>();
		comboColor = new JComboBox<String>();
		fecha = new JDateChooser();
		btnConfirmar = new JButton("Editar mascota");
		btnConfirmar.setActionCommand(COMANDO_EDITARMASCOTA);
		btnVolver = new JButton("Volver");
		btnVolver.setActionCommand(COMANDO_VOLVER);
		panel = new JPanel();
		panel.setLayout(new GridLayout(6, 6));
		panel.add(labelIdMascota);
		panel.add(comboID);
		panel.add(labelNombre);
		panel.add(txtNombre);
		panel.add(labelEspecie);
		panel.add(comboEspecie);
		panel.add(labelRaza);
		panel.add(comboRaza);
		panel.add(labelColor);
		panel.add(comboColor);
		panel.add(labelFecha);
		panel.add(fecha);
		panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(1, 2));
		panelBotones.add(btnConfirmar);
		panelBotones.add(btnVolver);
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1, 1));
		labelBienvenida = new JLabel("Aqui puedes editar la informacion de tus mascotas");
		panel2.add(labelBienvenida);
		add(panel2, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		add(panelBotones, BorderLayout.PAGE_END);
	}

	public String[][] verificarCampos() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String[][] entradas = new String[7][4];
		entradas[0][0] = "0";
		if (!"Seleccione".equals(comboID.getSelectedItem().toString())) {
			if ("".equals(txtNombre.getText()) && "Seleccione".equals(comboEspecie.getSelectedItem().toString())
					&& "Seleccione".equals(comboRaza.getSelectedItem().toString())
					&& "Seleccione".equals(comboColor.getSelectedItem().toString()) && fecha.getDate() == null) {
				entradas[0][0] = "1";
				entradas[0][1] = "Seleccione al menos un dato a editar";
			} else {
				if (fecha.getDate() == null) {
					entradas[1][0] = "nombre";
					entradas[1][1] = txtNombre.getText();
					entradas[1][2] = "mascota";
					entradas[1][3] = "nombre";
					entradas[2][0] = "idespecie";
					entradas[2][1] = comboEspecie.getSelectedItem().toString();
					entradas[2][2] = "especie";
					entradas[2][3] = "nombre";
					entradas[3][0] = "idraza";
					entradas[3][1] = comboRaza.getSelectedItem().toString();
					entradas[3][2] = "raza";
					entradas[3][3] = "nombre";
					entradas[4][0] = "idcolor";
					entradas[4][1] = comboColor.getSelectedItem().toString();
					entradas[4][2] = "color";
					entradas[4][3] = "nombre";
					entradas[5][0] = "añonacimiento";
					entradas[5][1] = "";
					entradas[5][2] = "mascota";
					entradas[5][3] = "nombre";
					entradas[6][0] = "idmascota";
					entradas[6][1] = comboID.getSelectedItem().toString();
					entradas[6][2] = "mascota";
					entradas[6][3] = "nombre";

				} else {
					entradas[1][0] = "nombre";
					entradas[1][1] = txtNombre.getText();
					entradas[1][2] = "mascota";
					entradas[1][3] = "nombre";
					entradas[2][0] = "idespecie";
					entradas[2][1] = comboEspecie.getSelectedItem().toString();
					entradas[2][2] = "especie";
					entradas[2][3] = "nombre";
					entradas[3][0] = "idraza";
					entradas[3][1] = comboRaza.getSelectedItem().toString();
					entradas[3][2] = "raza";
					entradas[3][3] = "nombre";
					entradas[4][0] = "idcolor";
					entradas[4][1] = comboColor.getSelectedItem().toString();
					entradas[4][2] = "color";
					entradas[4][3] = "nombre";
					entradas[5][0] = "añonacimiento";
					entradas[5][1] = formato.format(fecha.getDate());
					entradas[5][2] = "mascota";
					entradas[5][3] = "nombre";
					entradas[6][0] = "idmascota";
					entradas[6][1] = comboID.getSelectedItem().toString();
					entradas[6][2] = "mascota";
					entradas[6][3] = "nombre";
				}
			}
		} else {
			entradas[0][0] = "1";
			entradas[0][1] = "Seleccione el id de  la mascota a editar";
		}
		return entradas;
	}

	public void cargarComboBox(ArrayList<Mascota> ids, ArrayList<Color> colores, ArrayList<Especie> especies,
			ArrayList<Raza> razas) {
		comboID.removeAllItems();
		comboID.addItem("Seleccione");
		comboColor.removeAllItems();
		comboColor.addItem("Seleccione");
		comboRaza.removeAllItems();
		comboRaza.addItem("Seleccione");
		comboEspecie.removeAllItems();
		comboEspecie.addItem("Seleccione");
		for (int i = 0; i < ids.size(); i++) {
			comboID.addItem("" + ids.get(i).getIdMascota());
		}
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

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
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

}
