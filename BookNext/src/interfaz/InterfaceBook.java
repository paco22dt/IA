package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JPasswordField;

public class InterfaceBook extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private Recommendation recommendation;
	public int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login nuevo = new Login();
					nuevo.setVisible(true);
					
					//InterfaceBook frame = new InterfaceBook();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfaceBook(int id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1283, 711);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		InsertBook insertBook = new InsertBook(id);
		GridLayout flowLayout = (GridLayout) insertBook.getLayout();
		flowLayout.setVgap(20);
		flowLayout.setHgap(20);
		contentPane.add(insertBook, BorderLayout.NORTH);
		
		passwordField = new JPasswordField();
		insertBook.add(passwordField);
		
		recommendation = new Recommendation();
		contentPane.add(recommendation, BorderLayout.CENTER);
		this.id = id;
	}

}
