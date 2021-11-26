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
		setBackground(Color.white);
		tableMascotas = new JTable();
	}

	public void limpiarPanel() {
		this.removeAll();
		this.repaint();
	}

	public void mostrarTablaMascotas(String[][] infoMascotas) {
		setBorder(new TitledBorder("Información de mascotas"));
		JButton btn1 = new JButton("Modificar");
		String[] titulos = { "Nombre", "Especie", "Raza", "Color", "Año nacimiento" };
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

	public void mostrarTablaTodasMascotas(String[][] infoMascotas) {
		setBorder(new TitledBorder("Información de mascotas"));
		String[] titulos = { "Nombre", "Especie", "Raza", "Color", "Año nacimiento", "Dueño" };
		tableMascotas = new JTable(infoMascotas, titulos);
		JScrollPane sp = new JScrollPane(tableMascotas);
		tableMascotas.setEnabled(false);
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
		tableMascotas.setEnabled(false);
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
			String[] cont = String.valueOf(tableMascotas.getValueAt(tableMascotas.getSelectedRow(), 2)).split("-");
			if (cont.length == 6) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return -1;
		}
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
