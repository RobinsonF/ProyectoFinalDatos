package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelEditarUsuarioA extends JPanel {

	private final String COMANDO_EDITARMASCOTA = "EDITARCLIENTEA";
	private final String COMANDO_VOLVER = "VOLVER12";
	private JLabel labelNombres;
	private JLabel labelApellidos;
	private JLabel labelcorreo;
	private JLabel labelCedula;
	private JLabel labelDireccion;
	private JLabel labelEdad;
	private JLabel labelSexo;
	private JLabel labelNombres2;
	private JLabel labelApellidos2;
	private JLabel labelcorreo2;
	private JLabel labelCedula2;
	private JLabel labelDireccion2;
	private JLabel labelEdad2;
	private JLabel labelSexo2;
	private JLabel labelOpcion;
	private JComboBox<String> comboOpcion;
	private JButton btnConfirmar;
	private JButton btnVolver;
	private JPanel panel;
	private JPanel panelBotones;
	private JLabel labelDato;
	private JTextField txtDato;

	public PanelEditarUsuarioA() {
		setBorder(new TitledBorder("Editar Usuario"));
		setLayout(new BorderLayout());
		labelNombres = new JLabel("Nombres: ");
		labelApellidos = new JLabel("Apellidos: ");
		labelcorreo = new JLabel("Correo: ");
		labelCedula = new JLabel("Cedula: ");
		labelDireccion = new JLabel("Dirección: ");
		labelEdad = new JLabel("Edad: ");
		labelSexo = new JLabel("Sexo: ");
		labelNombres2 = new JLabel();
		labelApellidos2 = new JLabel();
		labelcorreo2 = new JLabel();
		labelCedula2 = new JLabel();
		labelDireccion2 = new JLabel();
		labelEdad2 = new JLabel();
		labelSexo2 = new JLabel();
		labelOpcion = new JLabel("Seleccione el dato a editar");
		comboOpcion = new JComboBox<String>();
		comboOpcion.addItem("Seleccione");
		comboOpcion.addItem("Nombres");
		comboOpcion.addItem("Apellidos");
		comboOpcion.addItem("Direccion");
//		comboOpcion.addItem("Cedula");
		labelDato = new JLabel("Escriba el nuevo dato");
		txtDato = new JTextField();
		btnConfirmar = new JButton("Editar");
		btnConfirmar.setActionCommand(COMANDO_EDITARMASCOTA);
		btnVolver = new JButton("Volver");
		btnVolver.setActionCommand(COMANDO_VOLVER);
		panel = new JPanel();
		panel.setLayout(new GridLayout(9, 9));
		panel.add(labelNombres);
		panel.add(labelNombres2);
		panel.add(labelApellidos);
		panel.add(labelApellidos2);
		panel.add(labelcorreo);
		panel.add(labelcorreo2);
		panel.add(labelCedula);
		panel.add(labelCedula2);
		panel.add(labelDireccion);
		panel.add(labelDireccion2);
		panel.add(labelEdad);
		panel.add(labelEdad2);
		panel.add(labelSexo);
		panel.add(labelSexo2);
		panel.add(labelOpcion);
		panel.add(comboOpcion);
		panel.add(labelDato);
		panel.add(txtDato);
		panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(1, 2));
		panelBotones.add(btnConfirmar);
		panelBotones.add(btnVolver);
		add(panel, BorderLayout.CENTER);
		add(panelBotones, BorderLayout.PAGE_END);
	}

	public String[][] verificarCampos() {
		String[][] entradas = new String[2][3];
		entradas[0][0] = "0";
		if (!"Seleccione".equals(comboOpcion.getSelectedItem().toString())) {
			if (!"".equals(txtDato.getText())) {
				if ("Nombres".equals(comboOpcion.getSelectedItem().toString())) {
					entradas[1][0] = "nombres";
					entradas[1][1] = txtDato.getText();
					entradas[1][2] = labelCedula2.getText();
				}
				if ("Apellidos".equals(comboOpcion.getSelectedItem().toString())) {
					entradas[1][0] = "apellidos";
					entradas[1][1] = txtDato.getText();
					entradas[1][2] = labelCedula2.getText();
				}
				if ("Direccion".equals(comboOpcion.getSelectedItem().toString())) {
					entradas[1][0] = "direccion";
					entradas[1][1] = txtDato.getText();
					entradas[1][2] = labelCedula2.getText();
				}
				if ("Cedula".equals(comboOpcion.getSelectedItem().toString())) {
					entradas[1][0] = "cedula";
					entradas[1][1] = txtDato.getText();
					entradas[1][2] = labelCedula2.getText();
				}

			} else {
				entradas[0][0] = "1";
				entradas[0][1] = "Complete el campo";
			}
		} else {
			entradas[0][0] = "1";
			entradas[0][1] = "Seleccione el dato a editar";
		}
		return entradas;
	}

	public void recibirDatosUsuario(String nombres, String apellidos, String correo, String cedula, String direccion,
			String edad, String sexo) {
		labelNombres2.setText(nombres);
		labelApellidos2.setText(apellidos);
		labelcorreo2.setText(correo);
		labelCedula2.setText(cedula);
		labelDireccion2.setText(direccion);
		labelEdad2.setText(edad);
		labelSexo2.setText(sexo);
	}
	
	public void limpiarCampos() {
		txtDato.setText("");
		comboOpcion.setSelectedIndex(0);
	}

	public JLabel getLabelNombres() {
		return labelNombres;
	}

	public void setLabelNombres(JLabel labelNombres) {
		this.labelNombres = labelNombres;
	}

	public JLabel getLabelApellidos() {
		return labelApellidos;
	}

	public void setLabelApellidos(JLabel labelApellidos) {
		this.labelApellidos = labelApellidos;
	}

	public JLabel getLabelcorreo() {
		return labelcorreo;
	}

	public void setLabelcorreo(JLabel labelcorreo) {
		this.labelcorreo = labelcorreo;
	}

	public JLabel getLabelCedula() {
		return labelCedula;
	}

	public void setLabelCedula(JLabel labelCedula) {
		this.labelCedula = labelCedula;
	}

	public JLabel getLabelDireccion() {
		return labelDireccion;
	}

	public void setLabelDireccion(JLabel labelDireccion) {
		this.labelDireccion = labelDireccion;
	}

	public JLabel getLabelEdad() {
		return labelEdad;
	}

	public void setLabelEdad(JLabel labelEdad) {
		this.labelEdad = labelEdad;
	}

	public JLabel getLabelSexo() {
		return labelSexo;
	}

	public void setLabelSexo(JLabel labelSexo) {
		this.labelSexo = labelSexo;
	}

	public JLabel getLabelNombres2() {
		return labelNombres2;
	}

	public void setLabelNombres2(JLabel labelNombres2) {
		this.labelNombres2 = labelNombres2;
	}

	public JLabel getLabelApellidos2() {
		return labelApellidos2;
	}

	public void setLabelApellidos2(JLabel labelApellidos2) {
		this.labelApellidos2 = labelApellidos2;
	}

	public JLabel getLabelcorreo2() {
		return labelcorreo2;
	}

	public void setLabelcorreo2(JLabel labelcorreo2) {
		this.labelcorreo2 = labelcorreo2;
	}

	public JLabel getLabelCedula2() {
		return labelCedula2;
	}

	public void setLabelCedula2(JLabel labelCedula2) {
		this.labelCedula2 = labelCedula2;
	}

	public JLabel getLabelDireccion2() {
		return labelDireccion2;
	}

	public void setLabelDireccion2(JLabel labelDireccion2) {
		this.labelDireccion2 = labelDireccion2;
	}

	public JLabel getLabelEdad2() {
		return labelEdad2;
	}

	public void setLabelEdad2(JLabel labelEdad2) {
		this.labelEdad2 = labelEdad2;
	}

	public JLabel getLabelSexo2() {
		return labelSexo2;
	}

	public void setLabelSexo2(JLabel labelSexo2) {
		this.labelSexo2 = labelSexo2;
	}

	public JLabel getLabelOpcion() {
		return labelOpcion;
	}

	public void setLabelOpcion(JLabel labelOpcion) {
		this.labelOpcion = labelOpcion;
	}

	public JComboBox<String> getComboOpcion() {
		return comboOpcion;
	}

	public void setComboOpcion(JComboBox<String> comboOpcion) {
		this.comboOpcion = comboOpcion;
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

	public JLabel getLabelDato() {
		return labelDato;
	}

	public void setLabelDato(JLabel labelDato) {
		this.labelDato = labelDato;
	}

	public JTextField getTxtDato() {
		return txtDato;
	}

	public void setTxtDato(JTextField txtDato) {
		this.txtDato = txtDato;
	}

	public String getCOMANDO_EDITARMASCOTA() {
		return COMANDO_EDITARMASCOTA;
	}

	public String getCOMANDO_VOLVER() {
		return COMANDO_VOLVER;
	}
}
