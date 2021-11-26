package co.edu.unbosque.view;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Graphics;

public class PanelInfoLogin extends JPanel {

	private Image imagen;

	public PanelInfoLogin() {
		setLayout(new GridLayout(1, 1));
	}
	public void paint(Graphics g) {
		imagen = new ImageIcon(getClass().getResource("/imagenes/mascotas-trabajo.jpg")).getImage();
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paint(g);
	}
	public Image getImagen() {
		return imagen;
	}
	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}
}
