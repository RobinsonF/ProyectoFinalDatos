package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelFiltroUsuario extends JPanel {
	private final String COMANDO_FILTRO = "FILTROUSUARIO34";
	private JLabel labelNombres;
	private JLabel labelApellidos;
	private JLabel labelCedula;
	private JLabel labelEdad;
	private JLabel labelSexo;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtCedula;
	private JTextField txtEdad;
	private JComboBox<String> txtSexo;
	private JButton btnFiltrar;
	private JPanel panel;

	public PanelFiltroUsuario() {
		setBorder(new TitledBorder("Filtro de usuarios"));
		setLayout(new BorderLayout());
		labelNombres = new JLabel("Nombres: ");
		labelApellidos = new JLabel("Apellidos: ");
		labelCedula = new JLabel("Cedula: ");
		labelEdad = new JLabel("Edad: ");
		labelSexo = new JLabel("Sexo: ");
		txtNombres = new JTextField();
		txtApellidos = new JTextField();
		txtCedula = new JTextField();
		txtEdad = new JTextField("");
		txtSexo = new JComboBox<String>();
		txtSexo.addItem("Seleccione");
		txtSexo.addItem("M");
		txtSexo.addItem("F");
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setActionCommand(COMANDO_FILTRO);
		panel = new JPanel();
		panel.setLayout(new GridLayout(5, 5));
		panel.add(labelNombres);
		panel.add(txtNombres);
		panel.add(labelApellidos);
		panel.add(txtApellidos);
		panel.add(labelCedula);
		panel.add(txtCedula);
		panel.add(labelEdad);
		panel.add(txtEdad);
		panel.add(labelSexo);
		panel.add(txtSexo);
		add(panel, BorderLayout.CENTER);
		add(btnFiltrar, BorderLayout.PAGE_END);
	}

	public String[][] verificarCampos() {
		String[][] entradas = new String[6][2];
		entradas[0][0] = "0";
		if ("".equals(txtNombres.getText()) && "".equals(txtApellidos.getText()) && "".equals(txtCedula.getText())
				&& "".equals(txtEdad.getText()) && "Seleccione".equals(txtSexo.getSelectedItem().toString())) {
			entradas[0][0] = "1";
			entradas[0][1] = "Llene al menos un campo a filtrar";
		} else {
			entradas[1][0] = "nombres";
			entradas[1][1] = txtNombres.getText();
			entradas[2][0] = "apellidos";
			entradas[2][1] = txtApellidos.getText();
			entradas[3][0] = "cedula";
			entradas[3][1] = txtCedula.getText();
			entradas[4][0] = "edad";
			entradas[4][1] = txtEdad.getText();
			entradas[5][0] = "sexo";
			entradas[5][1] = txtSexo.getSelectedItem().toString();
		}
		return entradas;
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

	public JLabel getLabelCedula() {
		return labelCedula;
	}

	public void setLabelCedula(JLabel labelCedula) {
		this.labelCedula = labelCedula;
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

	public JTextField getTxtNombres() {
		return txtNombres;
	}

	public void setTxtNombres(JTextField txtNombres) {
		this.txtNombres = txtNombres;
	}

	public JTextField getTxtApellidos() {
		return txtApellidos;
	}

	public void setTxtApellidos(JTextField txtApellidos) {
		this.txtApellidos = txtApellidos;
	}

	public JTextField getTxtCedula() {
		return txtCedula;
	}

	public void setTxtCedula(JTextField txtCedula) {
		this.txtCedula = txtCedula;
	}

	public JTextField getTxtEdad() {
		return txtEdad;
	}

	public void setTxtEdad(JTextField txtEdad) {
		this.txtEdad = txtEdad;
	}

	public JComboBox<String> getTxtSexo() {
		return txtSexo;
	}

	public void setTxtSexo(JComboBox<String> txtSexo) {
		this.txtSexo = txtSexo;
	}

	public JButton getBtnFiltrar() {
		return btnFiltrar;
	}

	public void setBtnFiltrar(JButton btnFiltrar) {
		this.btnFiltrar = btnFiltrar;
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
