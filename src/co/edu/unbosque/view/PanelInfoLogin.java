package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelInfoLogin extends JPanel {

	private ImageIcon imagen;
	private JLabel labelImagen;

	public PanelInfoLogin() {
		setLayout(null);
		setBackground(new Color(117, 121, 121));
		imagen = new ImageIcon(getClass().getResource("/imagenes/logoPerro.jpg"));
		labelImagen = new JLabel();
		labelImagen.setIcon(imagen);
		labelImagen.setBounds(14, 50, 366, 352);
		add(labelImagen);

	}

	public ImageIcon getImagen() {
		return imagen;
	}

	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}

	public JLabel getLabelImagen() {
		return labelImagen;
	}

	public void setLabelImagen(JLabel labelImagen) {
		this.labelImagen = labelImagen;
	}
	
}
