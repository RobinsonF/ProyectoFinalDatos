package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

public class PanelLogin extends JPanel {

	private final String COMANDO_ENTRAR = "ENTRAR";
	private final String COMANDO_CREARUSUARIO = "CREARUSUARIO";
	private JLabel labelBienvenida;
	private JLabel labelCorreo;
	private JLabel labelPassword;
	private JTextField txtCorreo;
	private JPasswordField txtPassword;
	private JButton btnConfirmar;
	private JButton btnCrearUsuario;
	private JPanel panel1;
	private JPanel panel3;
	private JPanel panel4;
	private PanelInfoLogin panel5;

	public PanelLogin() {
		setLayout(new GridLayout(1, 2));
		Font font1 = new Font("SansSerif", Font.BOLD, 25);
		Font font2 = new Font("SansSerif", Font.BOLD, 18);
		labelBienvenida = new JLabel("Ingrese el correo y contraseña");
		labelBienvenida.setFont(font1);
		labelBienvenida.setBorder(BorderFactory.createLineBorder(new Color(5, 5, 5)));
		labelBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		labelCorreo = new JLabel("Correo: ");
		labelCorreo.setFont(font2);
		labelCorreo.setBorder(BorderFactory.createLineBorder(new Color(5, 5, 5)));
		labelPassword = new JLabel("Contraseña: ");
		labelPassword.setFont(font2);
		labelPassword.setBorder(BorderFactory.createLineBorder(new Color(5, 5, 5)));
		txtCorreo = new JTextField();
		txtPassword = new JPasswordField();
		btnConfirmar = new JButton("Ingresar");
		btnConfirmar.setActionCommand(COMANDO_ENTRAR);
		btnCrearUsuario = new JButton("Registrarse");
		btnCrearUsuario.setActionCommand(COMANDO_CREARUSUARIO);
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(2, 2));
		panel1.add(labelCorreo);
		panel1.add(txtCorreo);
		panel1.add(labelPassword);
		panel1.add(txtPassword);
		panel3 = new JPanel();
		panel3.setLayout(new GridLayout(1, 2));
		panel3.add(btnConfirmar);
		panel3.add(btnCrearUsuario);
		panel4 = new JPanel();
		panel4.setLayout(new GridLayout(3, 1));
		panel4.add(labelBienvenida);
		panel4.add(panel1);
		panel4.add(panel3);
		panel5 = new PanelInfoLogin();
		add(panel5);
		add(panel4);
	}

	public String[] verificarEntradas() {
		String[] entradas = new String[3];
		entradas[0] = "0";
		if (!"".equals(txtCorreo.getText()) && !"".equals(txtPassword.getText())) {
			entradas[1] = txtCorreo.getText();
			entradas[2] = txtPassword.getText();
		} else {
			entradas[0] = "1";
			entradas[1] = "Complete los campos";
		}
		return entradas;
	}

	public void limpiarCampos() {
		txtCorreo.setText("");
		txtPassword.setText("");
	}

	public JLabel getLabelCorreo() {
		return labelCorreo;
	}

	public void setLabelCorreo(JLabel labelCorreo) {
		this.labelCorreo = labelCorreo;
	}

	public JLabel getLabelPassword() {
		return labelPassword;
	}

	public void setLabelPassword(JLabel labelPassword) {
		this.labelPassword = labelPassword;
	}

	public JTextField getTxtCorreo() {
		return txtCorreo;
	}

	public void setTxtCorreo(JTextField txtCorreo) {
		this.txtCorreo = txtCorreo;
	}

	public JPasswordField getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(JPasswordField txtPassword) {
		this.txtPassword = txtPassword;
	}

	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}

	public void setBtnConfirmar(JButton btnConfirmar) {
		this.btnConfirmar = btnConfirmar;
	}

	public String getCOMANDO_ENTRAR() {
		return COMANDO_ENTRAR;
	}

	public JLabel getLabelBienvenida() {
		return labelBienvenida;
	}

	public void setLabelBienvenida(JLabel labelBienvenida) {
		this.labelBienvenida = labelBienvenida;
	}

	public JPanel getPanel() {
		return panel1;
	}

	public void setPanel(JPanel panel) {
		this.panel1 = panel;
	}

	public JButton getBtnCrearUsuario() {
		return btnCrearUsuario;
	}

	public void setBtnCrearUsuario(JButton btnCrearUsuario) {
		this.btnCrearUsuario = btnCrearUsuario;
	}

	public JPanel getPanel1() {
		return panel1;
	}

	public void setPanel1(JPanel panel1) {
		this.panel1 = panel1;
	}

	public JPanel getPanel3() {
		return panel3;
	}

	public void setPanel3(JPanel panel3) {
		this.panel3 = panel3;
	}

	public String getCOMANDO_CREARUSUARIO() {
		return COMANDO_CREARUSUARIO;
	}

}
