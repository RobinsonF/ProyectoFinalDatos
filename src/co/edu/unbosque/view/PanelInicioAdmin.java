package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelInicioAdmin extends JPanel{
	private ImageIcon imagen2;
	private JLabel labelImagen;

	public PanelInicioAdmin() {
		setLayout(null);
		setBackground(new Color(117, 121, 121));
		imagen2 = new ImageIcon(getClass().getResource("/imagenes/mascota1.jpg"));
		labelImagen = new JLabel();
		labelImagen.setIcon(imagen2);
		labelImagen.setBounds(10, 20, 625, 400);
		add(labelImagen);
	}
	
	public ImageIcon getImagen2() {
		return imagen2;
	}

	public void setImagen2(ImageIcon imagen2) {
		this.imagen2 = imagen2;
	}

	public JLabel getLabelImagen() {
		return labelImagen;
	}

	public void setLabelImagen(JLabel labelImagen) {
		this.labelImagen = labelImagen;
	}
}
