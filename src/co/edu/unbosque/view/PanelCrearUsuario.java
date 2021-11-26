package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class PanelCrearUsuario extends JPanel {

	private final String COMANDO_CREAR = "CREAR";
	private final String COMANDO_VOLVER = "VOLVER4";
	private JLabel labelDatos;
	private JLabel labelCorreo;
	private JLabel labelCedula;
	private JLabel labelContra;
	private JLabel labelPrimerNombre;
	private JLabel labelSegundoNombre;
	private JLabel labelPrimerApellido;
	private JLabel labelSegundoApellido;
	private JLabel labelDirrecion;
	private JLabel labelTelefono;
	private JLabel labelEdad;
	private JLabel labelSexo;
	private JTextField txtCorreo;
	private JTextField txtCedula;
	private JPasswordField passContra;
	private JTextField txtPrimerNombre;
	private JTextField txtSegundoNombre;
	private JTextField txtPrimerApellido;
	private JTextField txtSegundoApellido;
	private JTextField txtDirrecion;
	private JTextField txtTelefono;
	private JTextField txtEdad;
	private JComboBox<String> comboSexo;
	private JButton btnCrear;
	private JButton btnVolver;
	private JPanel panel;
	private JPanel panelBotones;

	public PanelCrearUsuario() {
		setBorder(new TitledBorder("Registro de usuario"));
		setLayout(new BorderLayout());
		Font font1 = new Font("SansSerif", Font.BOLD, 30);
		Font font2 = new Font("SansSerif", Font.BOLD, 18);
		labelDatos = new JLabel("Ingrese los datos del usuario");
		labelDatos.setFont(font1);
		labelDatos.setBorder(BorderFactory.createLineBorder(new Color(5, 5, 5)));
		labelDatos.setHorizontalAlignment(SwingConstants.CENTER);
		labelCorreo = new JLabel("Correo: ");
		labelCorreo.setFont(font2);
		labelCorreo.setBorder(BorderFactory.createLineBorder(new Color(5, 5, 5)));
		labelCedula = new JLabel("Cedula: ");
		labelCedula.setFont(font2);
		labelCedula.setBorder(BorderFactory.createLineBorder(new Color(5, 5, 5)));
		labelContra = new JLabel("Contraseña: ");
		labelContra.setFont(font2);
		labelContra.setBorder(BorderFactory.createLineBorder(new Color(5, 5, 5)));
		labelPrimerNombre = new JLabel("Primer nombre: ");
		labelPrimerNombre.setFont(font2);
		labelPrimerNombre.setBorder(BorderFactory.createLineBorder(new Color(5, 5, 5)));
		labelSegundoNombre = new JLabel("Segundo nombre: ");
		labelSegundoNombre.setFont(font2);
		labelSegundoNombre.setBorder(BorderFactory.createLineBorder(new Color(5, 5, 5)));
		labelPrimerApellido = new JLabel("Primer apellido: ");
		labelPrimerApellido.setFont(font2);
		labelPrimerApellido.setBorder(BorderFactory.createLineBorder(new Color(5, 5, 5)));
		labelSegundoApellido = new JLabel("Segundo apellido: ");
		labelSegundoApellido.setFont(font2);
		labelSegundoApellido.setBorder(BorderFactory.createLineBorder(new Color(5, 5, 5)));
		labelDirrecion = new JLabel("Dirección: ");
		labelDirrecion.setFont(font2);
		labelDirrecion.setBorder(BorderFactory.createLineBorder(new Color(5, 5, 5)));
		labelTelefono = new JLabel("Telefono: ");
		labelTelefono.setFont(font2);
		labelTelefono.setBorder(BorderFactory.createLineBorder(new Color(5, 5, 5)));
		labelEdad = new JLabel("Edad: ");
		labelEdad.setFont(font2);
		labelEdad.setBorder(BorderFactory.createLineBorder(new Color(5, 5, 5)));
		labelSexo = new JLabel("Sexo: ");
		labelSexo.setFont(font2);
		labelSexo.setBorder(BorderFactory.createLineBorder(new Color(5, 5, 5)));
		txtCorreo = new JTextField();
		txtCedula = new JTextField();
		passContra = new JPasswordField();
		txtPrimerNombre = new JTextField();
		txtSegundoNombre = new JTextField();
		txtPrimerApellido = new JTextField();
		txtSegundoApellido = new JTextField();
		txtDirrecion = new JTextField();
		txtTelefono = new JTextField();
		txtEdad = new JTextField();
		comboSexo = new JComboBox<String>();
		comboSexo.addItem("Seleccione");
		comboSexo.addItem("M");
		comboSexo.addItem("F");
		btnCrear = new JButton("Crear usuario");
		btnCrear.setActionCommand(COMANDO_CREAR);
		btnVolver = new JButton("Volver");
		btnVolver.setActionCommand(COMANDO_VOLVER);
		panel = new JPanel();
		panel.setLayout(new GridLayout(11, 11));
		panel.add(labelCorreo);
		panel.add(txtCorreo);
		panel.add(labelCedula);
		panel.add(txtCedula);
		panel.add(labelContra);
		panel.add(passContra);
		panel.add(labelPrimerNombre);
		panel.add(txtPrimerNombre);
		panel.add(labelSegundoNombre);
		panel.add(txtSegundoNombre);
		panel.add(labelPrimerApellido);
		panel.add(txtPrimerApellido);
		panel.add(labelSegundoApellido);
		panel.add(txtSegundoApellido);
		panel.add(labelDirrecion);
		panel.add(txtDirrecion);
		panel.add(labelTelefono);
		panel.add(txtTelefono);
		panel.add(labelEdad);
		panel.add(txtEdad);
		panel.add(labelSexo);
		panel.add(comboSexo);
		panelBotones = new JPanel();
		panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(1, 2));
		panelBotones.add(btnCrear);
		panelBotones.add(btnVolver);
		add(labelDatos, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		add(panelBotones, BorderLayout.PAGE_END);

	}

	public String[] verificarEntradas() {
		String[] entradas = new String[12];
		entradas[0] = "0";
		if (!"".equals(txtCorreo.getText()) && !"".equals(txtCedula.getText()) && !"".equals(passContra.getText())
				&& !"".equals(txtPrimerNombre.getText()) && !"".equals(txtSegundoNombre.getText())
				&& !"".equals(txtPrimerApellido.getText()) && !"".equals(txtSegundoApellido.getText())
				&& !"".equals(txtDirrecion.getText()) && !"".equals(txtEdad.getText())
				&& !"Seleccione".equals(comboSexo.getSelectedItem().toString()) && !"".equals(txtTelefono.getText())) {
			entradas[1] = txtCorreo.getText();
			entradas[2] = txtCedula.getText();
			entradas[3] = passContra.getText();
			entradas[4] = txtPrimerNombre.getText();
			entradas[5] = txtSegundoNombre.getText();
			entradas[6] = txtPrimerApellido.getText();
			entradas[7] = txtSegundoApellido.getText();
			entradas[8] = txtDirrecion.getText();
			entradas[9] = txtEdad.getText();
			entradas[10] = comboSexo.getSelectedItem().toString();
			entradas[11] = txtTelefono.getText();
		} else {
			entradas[0] = "1";
			entradas[1] = "Por favor complete todos los campos";
		}
		return entradas;
	}

	public void limpiarCampos() {
		txtCorreo.setText("");
		txtCedula.setText("");
		passContra.setText("");
		txtPrimerNombre.setText("");
		txtSegundoNombre.setText("");
		txtPrimerApellido.setText("");
		txtSegundoApellido.setText("");
		txtDirrecion.setText("");
		txtTelefono.setText("");
		txtEdad.setText("");
		comboSexo.setSelectedIndex(0);
	}

	public JLabel getLabelDatos() {
		return labelDatos;
	}

	public void setLabelDatos(JLabel labelDatos) {
		this.labelDatos = labelDatos;
	}

	public JLabel getLabelCorreo() {
		return labelCorreo;
	}

	public void setLabelCorreo(JLabel labelCorreo) {
		this.labelCorreo = labelCorreo;
	}

	public JLabel getLabelCedula() {
		return labelCedula;
	}

	public void setLabelCedula(JLabel labelCedula) {
		this.labelCedula = labelCedula;
	}

	public JLabel getLabelContra() {
		return labelContra;
	}

	public void setLabelContra(JLabel labelContra) {
		this.labelContra = labelContra;
	}

	public JLabel getLabelPrimerNombre() {
		return labelPrimerNombre;
	}

	public void setLabelPrimerNombre(JLabel labelPrimerNombre) {
		this.labelPrimerNombre = labelPrimerNombre;
	}

	public JLabel getLabelSegundoNombre() {
		return labelSegundoNombre;
	}

	public void setLabelSegundoNombre(JLabel labelSegundoNombre) {
		this.labelSegundoNombre = labelSegundoNombre;
	}

	public JLabel getLabelPrimerApellido() {
		return labelPrimerApellido;
	}

	public void setLabelPrimerApellido(JLabel labelPrimerApellido) {
		this.labelPrimerApellido = labelPrimerApellido;
	}

	public JLabel getLabelSegundoApellido() {
		return labelSegundoApellido;
	}

	public void setLabelSegundoApellido(JLabel labelSegundoApellido) {
		this.labelSegundoApellido = labelSegundoApellido;
	}

	public JLabel getLabelDirrecion() {
		return labelDirrecion;
	}

	public void setLabelDirrecion(JLabel labelDirrecion) {
		this.labelDirrecion = labelDirrecion;
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

	public JTextField getTxtCorreo() {
		return txtCorreo;
	}

	public void setTxtCorreo(JTextField txtCorreo) {
		this.txtCorreo = txtCorreo;
	}

	public JTextField getTxtCedula() {
		return txtCedula;
	}

	public void setTxtCedula(JTextField txtCedula) {
		this.txtCedula = txtCedula;
	}

	public JTextField getTxtContra() {
		return passContra;
	}

	public void setTxtContra(JPasswordField txtContra) {
		this.passContra = txtContra;
	}

	public JTextField getTxtPrimerNombre() {
		return txtPrimerNombre;
	}

	public void setTxtPrimerNombre(JTextField txtPrimerNombre) {
		this.txtPrimerNombre = txtPrimerNombre;
	}

	public JTextField getTxtSegundoNombre() {
		return txtSegundoNombre;
	}

	public void setTxtSegundoNombre(JTextField txtSegundoNombre) {
		this.txtSegundoNombre = txtSegundoNombre;
	}

	public JTextField getTxtPrimerApellido() {
		return txtPrimerApellido;
	}

	public void setTxtPrimerApellido(JTextField txtPrimerApellido) {
		this.txtPrimerApellido = txtPrimerApellido;
	}

	public JTextField getTxtSegundoApellido() {
		return txtSegundoApellido;
	}

	public void setTxtSegundoApellido(JTextField txtSegundoApellido) {
		this.txtSegundoApellido = txtSegundoApellido;
	}

	public JTextField getTxtDirrecion() {
		return txtDirrecion;
	}

	public void setTxtDirrecion(JTextField txtDirrecion) {
		this.txtDirrecion = txtDirrecion;
	}

	public JTextField getTxtEdad() {
		return txtEdad;
	}

	public void setTxtEdad(JTextField txtEdad) {
		this.txtEdad = txtEdad;
	}

	public JComboBox<String> getComboSexo() {
		return comboSexo;
	}

	public void setTxtSexo(JComboBox<String> comboSexo) {
		this.comboSexo = comboSexo;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public String getCOMANDO_CREAR() {
		return COMANDO_CREAR;
	}

	public JButton getBtnCrear() {
		return btnCrear;
	}

	public void setBtnCrear(JButton btnCrear) {
		this.btnCrear = btnCrear;
	}

	public JLabel getLabelTelefono() {
		return labelTelefono;
	}

	public void setLabelTelefono(JLabel labelTelefono) {
		this.labelTelefono = labelTelefono;
	}

	public JPasswordField getPassContra() {
		return passContra;
	}

	public void setPassContra(JPasswordField passContra) {
		this.passContra = passContra;
	}

	public JTextField getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(JTextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	public void setComboSexo(JComboBox<String> comboSexo) {
		this.comboSexo = comboSexo;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	public JPanel getPanelBotones() {
		return panelBotones;
	}

	public void setPanelBotones(JPanel panelBotones) {
		this.panelBotones = panelBotones;
	}

	public String getCOMANDO_VOLVER() {
		return COMANDO_VOLVER;
	}
	
}
