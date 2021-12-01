package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelReporte extends JPanel{
	
	private final String COMANDO_FACTURA = "REPORTEFACTURA";
	private final String COMANDO_CLIENTE = "REPORTECLIENTE";
	private final String COMANDO_MASCOTA = "REPORTEMASCOTA";
	private ImageIcon imagen2;
	private JLabel labelImagen;
	private JButton btnFactura;
	private JButton btnClientes;
	private JButton btnMascotas;

	
	public PanelReporte() {
		setLayout(null);
		setBackground(new Color(117, 121, 121));
		imagen2 = new ImageIcon(getClass().getResource("/imagenes/reporte.png"));
		labelImagen = new JLabel();
		labelImagen.setIcon(imagen2);
		labelImagen.setBounds(200, 60, 225, 225);
		btnFactura = new JButton("Facturas");
		btnFactura.setActionCommand(COMANDO_FACTURA);
		btnFactura.setBounds(100, 350, 100, 50);
		btnClientes = new JButton("Clientes");
		btnClientes.setActionCommand(COMANDO_CLIENTE);
		btnClientes.setBounds(400, 350, 100, 50);
		btnMascotas = new JButton("Mascotas");
		btnMascotas.setActionCommand(COMANDO_MASCOTA);
		btnMascotas.setBounds(250, 350, 100, 50);
		add(labelImagen);
		add(btnFactura);
		add(btnClientes);
		add(btnMascotas);

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

	public JButton getBtnFactura() {
		return btnFactura;
	}

	public void setBtnFactura(JButton btnFactura) {
		this.btnFactura = btnFactura;
	}

	public JButton getBtnClientes() {
		return btnClientes;
	}

	public void setBtnClientes(JButton btnClientes) {
		this.btnClientes = btnClientes;
	}

	public String getCOMANDO_FACTURA() {
		return COMANDO_FACTURA;
	}

	public String getCOMANDO_CLIENTE() {
		return COMANDO_CLIENTE;
	}

	public JButton getBtnMascotas() {
		return btnMascotas;
	}

	public void setBtnMascotas(JButton btnMascotas) {
		this.btnMascotas = btnMascotas;
	}

	public String getCOMANDO_MASCOTA() {
		return COMANDO_MASCOTA;
	}

	
}
