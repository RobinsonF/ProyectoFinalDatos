package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

public class PanelTablas extends JPanel {

	private JTable tableMascotas;
	private JTable tableClientes;

	public PanelTablas() {
		setLayout(new GridLayout(1, 1));
		setBackground(new Color(117, 121, 121));
		tableMascotas = new JTable();
	}

	public void limpiarPanel() {
		this.removeAll();
		this.repaint();
	}
	
	public void mostrarTablaServicios(String[][] infoServicios) {
		setBorder(new TitledBorder("Información de servicios"));
		JButton btn1 = new JButton("Modificar");
		String[] titulos = { "ID", "Nombre", "Precios"};
		tableMascotas = new JTable(infoServicios, titulos);
		JScrollPane sp = new JScrollPane(tableMascotas);
		tableMascotas.setDefaultEditor(tableMascotas.getColumnClass(0), null);
		tableMascotas.setRowHeight(20);
		tableMascotas.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		sp.setViewportView(tableMascotas);
		tableMascotas.getTableHeader().setForeground(Color.black);
		tableMascotas.getTableHeader().isBackgroundSet();
		tableMascotas.getTableHeader().setEnabled(false);
		Font font = new Font("SansSerif", Font.BOLD, 12);
		tableMascotas.setFont(font);
		tableMascotas.getTableHeader().setFont(font);
		tableMascotas.setGridColor(Color.white);
		add(sp);
		validate();
		tableMascotas.repaint();
		sp.repaint();
	}

	public void mostrarTablaMascotas(String[][] infoMascotas) {
		setBorder(new TitledBorder("Información de mascotas"));
		JButton btn1 = new JButton("Modificar");
		String[] titulos = { "ID", "Nombre", "Especie", "Raza", "Color", "Año nacimiento" };
		tableMascotas = new JTable(infoMascotas, titulos);
		JScrollPane sp = new JScrollPane(tableMascotas);
		tableMascotas.setDefaultEditor(tableMascotas.getColumnClass(0), null);
		tableMascotas.setRowHeight(20);
		tableMascotas.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		sp.setViewportView(tableMascotas);
		tableMascotas.getTableHeader().setForeground(Color.black);
		tableMascotas.getTableHeader().isBackgroundSet();
		tableMascotas.getTableHeader().setEnabled(false);
		Font font = new Font("SansSerif", Font.BOLD, 12);
		tableMascotas.setFont(font);
		tableMascotas.getTableHeader().setFont(font);
		tableMascotas.setGridColor(Color.white);
		add(sp);
		validate();
		tableMascotas.repaint();
		sp.repaint();
	}
	
	public void mostrarTablaFactura(String[][] infoFactura) {
		setBorder(new TitledBorder("Información de tus facturas"));
		JButton btn1 = new JButton("Modificar");
		String[] titulos = { "ID_Factura", "Forma de pago", "Fecha de generacion"};
		tableMascotas = new JTable(infoFactura, titulos);
		JScrollPane sp = new JScrollPane(tableMascotas);
		tableMascotas.setDefaultEditor(tableMascotas.getColumnClass(0), null);
		tableMascotas.setRowHeight(20);
		tableMascotas.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		sp.setViewportView(tableMascotas);
		tableMascotas.getTableHeader().setForeground(Color.black);
		tableMascotas.getTableHeader().isBackgroundSet();
		tableMascotas.getTableHeader().setEnabled(false);
		Font font = new Font("SansSerif", Font.BOLD, 12);
		tableMascotas.setFont(font);
		tableMascotas.getTableHeader().setFont(font);
		tableMascotas.setGridColor(Color.white);
		add(sp);
		validate();
		tableMascotas.repaint();
		sp.repaint();
	}

	public void mostrarTablaTodasMascotas(String[][] infoMascotas) {
		setBorder(new TitledBorder("Información de mascotas"));
		String[] titulos = { "ID", "Nombre", "Especie", "Raza", "Color", "Año nacimiento", "Dueño" };
		tableMascotas = new JTable(infoMascotas, titulos);
		JScrollPane sp = new JScrollPane(tableMascotas);
		tableMascotas.setDefaultEditor(tableMascotas.getColumnClass(0), null);
		tableMascotas.setRowHeight(20);
		tableMascotas.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		sp.setViewportView(tableMascotas);
		tableMascotas.getTableHeader().setForeground(Color.black);
		tableMascotas.getTableHeader().isBackgroundSet();
		tableMascotas.getTableHeader().setEnabled(false);
		Font font = new Font("SansSerif", Font.BOLD, 12);
		tableMascotas.setFont(font);
		tableMascotas.getTableHeader().setFont(font);
		tableMascotas.setGridColor(Color.white);
		add(sp);
		validate();
		tableMascotas.repaint();
		sp.repaint();
	}

	public void mostrarTablaClientes(String[][] infoClientes) {
		setBorder(new TitledBorder("Información de clientes"));
		String[] titulos = { "Nombres", "Apellidos", "Correo", "Cedula", "Dirección", "edad", "Sexo" };
		tableMascotas = new JTable(infoClientes, titulos);
		JScrollPane sp = new JScrollPane(tableMascotas);
		tableMascotas.setDefaultEditor(tableMascotas.getColumnClass(0), null);
		tableMascotas.setRowHeight(20);
		tableMascotas.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		sp.setViewportView(tableMascotas);
		tableMascotas.getTableHeader().setForeground(Color.black);
		tableMascotas.getTableHeader().isBackgroundSet();
		tableMascotas.getTableHeader().setEnabled(false);
		Font font = new Font("SansSerif", Font.BOLD, 12);
		tableMascotas.setFont(font);
		tableMascotas.getTableHeader().setFont(font);
		tableMascotas.setGridColor(Color.white);
		add(sp);
		validate();
		tableMascotas.repaint();
		sp.repaint();
	}

	public int verificarDatosTabla() {
		if (tableMascotas.getSelectedRows().length == 1) {
			String[] cont = String.valueOf(tableMascotas.getValueAt(tableMascotas.getSelectedRow(), 3)).split("-");
			System.out.println(cont.length);
			if (cont.length == 1) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return -1;
		}
	}
	
	public int verificarDatosTablaFactura() {
		if (tableMascotas.getSelectedRows().length == 1) {
			String[] cont = String.valueOf(tableMascotas.getValueAt(tableMascotas.getSelectedRow(), 1)).split("-");
			if (cont.length == 1) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return -1;
		}
	}


	public String[] obtenerDatosTabla() {
		String[] salida = new String[9];
		salida[0] = "0";
		if (tableMascotas.getSelectedRows().length == 1) {
			salida[1] = String.valueOf(this.tableMascotas.getValueAt(this.tableMascotas.getSelectedRow(), 3));
			salida[2] = "Se ha borrado exitosamente el usuario";
			salida[3] = String.valueOf(this.tableMascotas.getValueAt(this.tableMascotas.getSelectedRow(), 0));
			salida[4] = String.valueOf(this.tableMascotas.getValueAt(this.tableMascotas.getSelectedRow(), 1));
			salida[5] = String.valueOf(this.tableMascotas.getValueAt(this.tableMascotas.getSelectedRow(), 2));
			salida[6] = String.valueOf(this.tableMascotas.getValueAt(this.tableMascotas.getSelectedRow(), 4));
			salida[7] = String.valueOf(this.tableMascotas.getValueAt(this.tableMascotas.getSelectedRow(), 5));
			salida[8] = String.valueOf(this.tableMascotas.getValueAt(this.tableMascotas.getSelectedRow(), 6));
		} else {
			salida[0] = "1";
			salida[1] = "Seleccione un solo usuario";
		}
		return salida;
	}
	
	public String[] obtenerDatosFactura() {
		String[] salida = new String[2];
		salida[0] = "0";
		if (tableMascotas.getSelectedRows().length == 1) {
			salida[1] = String.valueOf(this.tableMascotas.getValueAt(this.tableMascotas.getSelectedRow(), 0));
		} else {
			salida[0] = "1";
			salida[1] = "Seleccione una sola factura";
		}
		return salida;
	}
	
	public String[] obtenerDatosServicio() {
		String[] salida = new String[4];
		salida[0] = "0";
		if (tableMascotas.getSelectedRows().length == 1) {
			salida[1] = String.valueOf(this.tableMascotas.getValueAt(this.tableMascotas.getSelectedRow(), 0));
			salida[2] = String.valueOf(this.tableMascotas.getValueAt(this.tableMascotas.getSelectedRow(), 1));
			salida[3] = String.valueOf(this.tableMascotas.getValueAt(this.tableMascotas.getSelectedRow(), 2));

		} else {
			salida[0] = "1";
			salida[1] = "Seleccione un solo servicio";
		}
		return salida;
	}

	public String[] obtenerDatosTablaMascota() {
		String[] salida = new String[8];
		salida[0] = "0";
		if (tableMascotas.getSelectedRows().length == 1) {
			salida[1] = String.valueOf(this.tableMascotas.getValueAt(this.tableMascotas.getSelectedRow(), 0));
			salida[2] = "Se ha borrado exitosamente la mascota";
			salida[3] = String.valueOf(this.tableMascotas.getValueAt(this.tableMascotas.getSelectedRow(), 1));
			salida[4] = String.valueOf(this.tableMascotas.getValueAt(this.tableMascotas.getSelectedRow(), 2));
			salida[5] = String.valueOf(this.tableMascotas.getValueAt(this.tableMascotas.getSelectedRow(), 3));
			salida[6] = String.valueOf(this.tableMascotas.getValueAt(this.tableMascotas.getSelectedRow(), 4));
			salida[7] = String.valueOf(this.tableMascotas.getValueAt(this.tableMascotas.getSelectedRow(), 5));

		} else {
			salida[0] = "1";
			salida[1] = "Seleccione una sola mascota";
		}
		return salida;
	}

	public String[] obtenerDatosTablaMascotaUsuario() {
		String[] salida = new String[8];
		salida[0] = "0";
		if (tableMascotas.getSelectedRows().length == 1) {
			salida[1] = String.valueOf(this.tableMascotas.getValueAt(this.tableMascotas.getSelectedRow(), 0));
			salida[2] = "Se ha borrado exitosamente la mascota";
			salida[3] = String.valueOf(this.tableMascotas.getValueAt(this.tableMascotas.getSelectedRow(), 1));
			salida[4] = String.valueOf(this.tableMascotas.getValueAt(this.tableMascotas.getSelectedRow(), 2));
			salida[5] = String.valueOf(this.tableMascotas.getValueAt(this.tableMascotas.getSelectedRow(), 3));
			salida[6] = String.valueOf(this.tableMascotas.getValueAt(this.tableMascotas.getSelectedRow(), 4));
			salida[7] = String.valueOf(this.tableMascotas.getValueAt(this.tableMascotas.getSelectedRow(), 5));
		} else {
			salida[0] = "1";
			salida[1] = "Seleccione una sola mascota";
		}
		return salida;
	}

	public JTable getTableMascotas() {
		return tableMascotas;
	}

	public void setTableMascotas(JTable tableMascotas) {
		this.tableMascotas = tableMascotas;
	}

	public JTable getTableClientes() {
		return tableClientes;
	}

	public void setTableClientes(JTable tableClientes) {
		this.tableClientes = tableClientes;
	}

}
