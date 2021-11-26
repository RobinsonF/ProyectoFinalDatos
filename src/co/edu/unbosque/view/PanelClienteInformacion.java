package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import co.edu.unbosque.model.persistence.Color;
import co.edu.unbosque.model.persistence.Especie;
import co.edu.unbosque.model.persistence.Raza;
import co.edu.unbosque.model.persistence.Telefono;
import co.edu.unbosque.model.persistence.Usuario;

public class PanelClienteInformacion extends JPanel {

	private final String COMANDO_EDITAR = "EDITARC";
	private JLabel labelNombres;
	private JLabel labelApellidos;
	private JLabel labelCedula;
	private JLabel labelCorreo;
	private JLabel labelDirrecion;
	private JLabel labelTelefono;
	private JLabel labelSexo;
	private JLabel labelEdad;
	private JLabel labelNombres2;
	private JLabel labelApellidos2;
	private JLabel labelCedula2;
	private JLabel labelCorreo2;
	private JLabel labelDirrecion2;
	private JComboBox<String> comboTelefono;
	private JLabel labelSexo2;
	private JLabel labelEdad2;
	private JButton btnEditarInfo;
	private JPanel panel;

	public PanelClienteInformacion() {
		setBorder(new TitledBorder("Aqui puedes ver toda tu informacion"));
		setLayout(new BorderLayout());
		labelNombres = new JLabel("Nombres: ");
		labelApellidos = new JLabel("Apellidos: ");
		labelCedula = new JLabel("Cedula: ");
		labelCorreo = new JLabel("Correo: ");
		labelDirrecion = new JLabel("Dirección: ");
		labelTelefono = new JLabel("Telefono: ");
		labelSexo = new JLabel("Sexo: ");
		labelEdad = new JLabel("Edad: ");
		labelNombres2 = new JLabel();
		labelApellidos2 = new JLabel();
		labelCedula2 = new JLabel();
		labelCorreo2 = new JLabel();
		labelDirrecion2 = new JLabel();
		comboTelefono = new JComboBox<String>();
		labelSexo2 = new JLabel();
		labelEdad2 = new JLabel();
		btnEditarInfo = new JButton("Modificar datos");
		btnEditarInfo.setActionCommand(COMANDO_EDITAR);
		btnEditarInfo.setSize(10, 10);
		panel = new JPanel();
		panel.setLayout(new GridLayout(8, 8));
		panel.add(labelNombres);
		panel.add(labelNombres2);
		panel.add(labelApellidos);
		panel.add(labelApellidos2);
		panel.add(labelCedula);
		panel.add(labelCedula2);
		panel.add(labelCorreo);
		panel.add(labelCorreo2);
		panel.add(labelDirrecion);
		panel.add(labelDirrecion2);
		panel.add(labelTelefono);
		panel.add(comboTelefono);
		panel.add(labelSexo);
		panel.add(labelSexo2);
		panel.add(labelEdad);
		panel.add(labelEdad2);
		add(panel, BorderLayout.CENTER);
		add(btnEditarInfo, BorderLayout.PAGE_END);

	}

	public void recibirInfo(Usuario usuario) {
		labelNombres2.setText(usuario.getNombres());
		labelApellidos2.setText(usuario.getApellidos());
		labelCedula2.setText(usuario.getCedula());
		labelCorreo2.setText(usuario.getCorreo());
		labelDirrecion2.setText(usuario.getDirreccion());
		labelSexo2.setText(usuario.getSexo());
		labelEdad2.setText("" + usuario.getEdad());
	}

	public void cargarComboBox(ArrayList<Telefono> telefonos) {
		comboTelefono.removeAllItems();
		for (int i = 0; i < telefonos.size(); i++) {
			comboTelefono.addItem(telefonos.get(i).getNumeroTelefono());
		}

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

	public JLabel getLabelCorreo() {
		return labelCorreo;
	}

	public void setLabelCorreo(JLabel labelCorreo) {
		this.labelCorreo = labelCorreo;
	}

	public JLabel getLabelDirrecion() {
		return labelDirrecion;
	}

	public void setLabelDirrecion(JLabel labelDirrecion) {
		this.labelDirrecion = labelDirrecion;
	}

	public JLabel getLabelTelefono() {
		return labelTelefono;
	}

	public void setLabelTelefono(JLabel labelTelefono) {
		this.labelTelefono = labelTelefono;
	}

	public JLabel getLabelSexo() {
		return labelSexo;
	}

	public void setLabelSexo(JLabel labelSexo) {
		this.labelSexo = labelSexo;
	}

	public JLabel getLabelEdad() {
		return labelEdad;
	}

	public void setLabelEdad(JLabel labelEdad) {
		this.labelEdad = labelEdad;
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

	public JLabel getLabelCedula2() {
		return labelCedula2;
	}

	public void setLabelCedula2(JLabel labelCedula2) {
		this.labelCedula2 = labelCedula2;
	}

	public JLabel getLabelCorreo2() {
		return labelCorreo2;
	}

	public void setLabelCorreo2(JLabel labelCorreo2) {
		this.labelCorreo2 = labelCorreo2;
	}

	public JLabel getLabelDirrecion2() {
		return labelDirrecion2;
	}

	public void setLabelDirrecion2(JLabel labelDirrecion2) {
		this.labelDirrecion2 = labelDirrecion2;
	}

	public JComboBox<String> getComboTelefono() {
		return comboTelefono;
	}

	public void setComboTelefono(JComboBox<String> comboTelefono) {
		this.comboTelefono = comboTelefono;
	}

	public JLabel getLabelSexo2() {
		return labelSexo2;
	}

	public void setLabelSexo2(JLabel labelSexo2) {
		this.labelSexo2 = labelSexo2;
	}

	public JLabel getLabelEdad2() {
		return labelEdad2;
	}

	public void setLabelEdad2(JLabel labelEdad2) {
		this.labelEdad2 = labelEdad2;
	}

	public JButton getBtnEditarInfo() {
		return btnEditarInfo;
	}

	public void setBtnEditarInfo(JButton btnEditarInfo) {
		this.btnEditarInfo = btnEditarInfo;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public String getCOMANDO_EDITAR() {
		return COMANDO_EDITAR;
	}
}
