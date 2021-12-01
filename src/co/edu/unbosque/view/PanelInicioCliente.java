package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelInicioCliente extends JPanel {

	private ImageIcon imagen2;
	private JLabel labelImagen;

	public PanelInicioCliente() {
		setLayout(null);
		setBackground(new Color(117, 121, 121));
		imagen2 = new ImageIcon(getClass().getResource("/imagenes/mascota.jpeg"));
		labelImagen = new JLabel();
		labelImagen.setIcon(imagen2);
		labelImagen.setBounds(20, 10, 620, 428);
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
