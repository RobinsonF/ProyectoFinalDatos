package co.edu.unbosque.view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelInicioAdmin extends JPanel{
	private ImageIcon imagen2;
	private JLabel labelImagen;

	public PanelInicioAdmin() {
		setLayout(null);
		imagen2 = new ImageIcon(getClass().getResource("/imagenes/mascota1.jpg"));
		labelImagen = new JLabel();
		labelImagen.setIcon(imagen2);
		labelImagen.setBounds(20, 20, 648, 400);
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
