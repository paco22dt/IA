package interfaz;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;

import files.DataBase;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertBook extends JPanel {
	private JTextField textField;
	private JTextField txtAutor;
	private JLabel lblEdicin;
	private JTextField textField_2;
	private JLabel lblAoDePublicacion;
	private JTextField textField_3;
	private JLabel lblResumen;
	private JTextField textField_4;
	private JLabel lblCategoras;
	private JTextField txtCategoria;
	private JLabel lblPalabrasClave;
	private JTextField txtPalabraClave;
	private JButton btnGuardarEIniciar;
	public int id;

	/**
	 * Create the panel.
	 */
	public InsertBook(int id) {
		setBackground(new Color(50, 205, 50));
		setBorder(new TitledBorder(null, "Insertar datos del libro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(8, 2, 20, 20));
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo");
		add(lblTtulo);
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(10);
		
		JLabel lblAutores = new JLabel("Autor(es)");
		add(lblAutores);
		
		txtAutor = new JTextField();
		add(txtAutor);
		txtAutor.setColumns(10);
		
		lblEdicin = new JLabel("Edici\u00F3n");
		add(lblEdicin);
		
		textField_2 = new JTextField();
		add(textField_2);
		textField_2.setColumns(10);
		
		lblAoDePublicacion = new JLabel("A\u00F1o de publicacion");
		add(lblAoDePublicacion);
		
		textField_3 = new JTextField();
		add(textField_3);
		textField_3.setColumns(10);
		
		lblResumen = new JLabel("Resumen");
		add(lblResumen);
		
		textField_4 = new JTextField();
		add(textField_4);
		textField_4.setColumns(10);
		
		lblCategoras = new JLabel("Categor\u00EDa(s)");
		add(lblCategoras);
		
		txtCategoria = new JTextField();
		add(txtCategoria);
		txtCategoria.setColumns(10);
		
		lblPalabrasClave = new JLabel("Palabra(s) Clave");
		add(lblPalabrasClave);
		
		txtPalabraClave = new JTextField();
		add(txtPalabraClave);
		txtPalabraClave.setColumns(10);
		this.id=id;
		
		btnGuardarEIniciar = new JButton("Guardar e iniciar recomendacion");
		btnGuardarEIniciar.addActionListener(new ActionListener() {
			//Guardar recomendacion
			public void actionPerformed(ActionEvent arg0) {
				String categorias =  txtCategoria.getText();
				String autores = txtAutor.getText();
				String palabraclave = txtPalabraClave.getText();
				DataBase db = new DataBase();
				try
				{
					db.connectToDB();
					if(!categorias.equals(""))
					{
						String [] vector = categorias.split("\\|");
						db.IngresarCategorias(id, vector);
					}
					if(!autores.equals(""))
					{
						String [] vector = categorias.split("\\|");
						db.IngresarAutores(id, vector);
					}
					if(!palabraclave.equals(""))
					{
						String [] vector = categorias.split("\\|");
						db.IngresarPalabrasClaves(id, vector);
					}
				}
				catch (Exception ex)
				{
					JOptionPane.showMessageDialog(getRootPane(), ex.getMessage());
				}
			}
		});
		add(btnGuardarEIniciar);

	}

}
