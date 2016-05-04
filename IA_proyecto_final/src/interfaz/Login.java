package interfaz;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Login extends JPanel {
	private JTextField txtUser;
	private JTextField txtContrase�a;
	private JPanel panel;
	private JLabel lblCrearCuenta;
	private JLabel lblNewLabel_1;
	private JTextField txtNuevoUsuario;
	private JLabel lblNewLabel_2;
	private JTextField txtContrase�a_nueva;
	private JButton btnIngresar;
	private JButton btnCrearNuevaCuenta;

	/**
	 * Create the panel.
	 */
	public Login() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Login", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		setBackground(new Color(25, 25, 112));
		setLayout(new GridLayout(2, 2, 5, 5));
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblUsuario);
		
		txtUser = new JTextField();
		add(txtUser);
		txtUser.setColumns(10);
		
		panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		add(panel);
		
		lblCrearCuenta = new JLabel("Crear cuenta:");
		lblCrearCuenta.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(lblCrearCuenta);
		
		lblNewLabel_1 = new JLabel("Usuario");
		panel.add(lblNewLabel_1);
		
		txtNuevoUsuario = new JTextField();
		panel.add(txtNuevoUsuario);
		txtNuevoUsuario.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Contrase\u00F1a");
		panel.add(lblNewLabel_2);
		
		txtContrase�a_nueva = new JTextField();
		panel.add(txtContrase�a_nueva);
		txtContrase�a_nueva.setColumns(10);
		
		btnCrearNuevaCuenta = new JButton("Crear nueva cuenta");
		panel.add(btnCrearNuevaCuenta);
		
		JLabel lblNewLabel = new JLabel("Contrase\u00F1a");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		add(lblNewLabel);
		
		txtContrase�a = new JTextField();
		add(txtContrase�a);
		txtContrase�a.setColumns(10);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(btnIngresar);

	}

}
