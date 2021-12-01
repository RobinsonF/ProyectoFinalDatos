package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelFiltroServicio extends JPanel {

	private final String COMANDO_FILTRO = "FILTRO101";
	private JLabel labelId;
	private JLabel labelNombre;
	private JTextField txtId;
	private JTextField txtNombre;
	private JButton btnConfirmar;
	private JPanel panel;

	public PanelFiltroServicio() {
		setBorder(new TitledBorder("Filtro de servicios"));
		setLayout(new BorderLayout());
		labelId = new JLabel("Id: ");
		labelNombre = new JLabel("Nombre");
		txtId = new JTextField();
		txtNombre = new JTextField();
		btnConfirmar = new JButton("Filtrar");
		btnConfirmar.setActionCommand(COMANDO_FILTRO);
		panel = new JPanel();
		panel.setLayout(new GridLayout(2, 2));
		panel.add(labelId);
		panel.add(txtId);
		panel.add(labelNombre);
		panel.add(txtNombre);
		add(panel, BorderLayout.CENTER);
		add(btnConfirmar, BorderLayout.PAGE_END);
	}

	public String[][] verificarCampos() {
		String[][] entradas = new String[3][2];
		entradas[0][0] = "0";
		if ("".equals(txtId.getText()) && "".equals(txtNombre.getText())) {
			entradas[0][0] = "1";
			entradas[0][1] = "Seleccione al menos un dato a filtar";
		} else {
			entradas[1][0] = "idservicio";
			entradas[1][1] = txtId.getText();
			entradas[2][0] = "nombre";
			entradas[2][1] = txtNombre.getText();
		}
		return entradas;
	}

	public JLabel getLabelId() {
		return labelId;
	}

	public void setLabelId(JLabel labelId) {
		this.labelId = labelId;
	}

	public JLabel getLabelNombre() {
		return labelNombre;
	}

	public void setLabelNombre(JLabel labelNombre) {
		this.labelNombre = labelNombre;
	}

	public JTextField getTxtId() {
		return txtId;
	}

	public void setTxtId(JTextField txtId) {
		this.txtId = txtId;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}

	public void setBtnConfirmar(JButton btnConfirmar) {
		this.btnConfirmar = btnConfirmar;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public String getCOMANDO_FILTRO() {
		return COMANDO_FILTRO;
	}

}
