package interfaz;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class Recommendation extends JPanel {
	private JTable table;
	private JTable table_1;

	/**
	 * Create the panel.
	 */
	public Recommendation() {
		setBorder(new TitledBorder(null, "Recommendation", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setBackground(new Color(152, 251, 152));
		setLayout(new GridLayout(2, 2, 20, 20));
		
		JLabel lblSeleccioneElTipo = new JLabel("Seleccione el tipo de recommendacion que necesita");
		lblSeleccioneElTipo.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(lblSeleccioneElTipo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Recomendaci\u00F3n primaria", "Recomendaci\u00F3n por similitud", "Recomendaci\u00F3n por aprendizaje"}));
		add(comboBox);
		
		JButton btnGenerarRecomendacin = new JButton("Generar Recomendaci\u00F3n");
		btnGenerarRecomendacin.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(btnGenerarRecomendacin);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, "", null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"T\u00EDtulo", "Autor(es)", "Edici\u00F3n", "A\u00F1o de publicaci\u00F3n", "Resumen", "Categor\u00EDa(s)", "Palabra(s) clave"
			}
		));
		table.setColumnSelectionAllowed(true);
		table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		scrollPane.setViewportView(table);
		

	}

}
