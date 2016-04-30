package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JPasswordField;

public class InterfaceBook extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private Recommendation recommendation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceBook frame = new InterfaceBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfaceBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1283, 711);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		InsertBook insertBook = new InsertBook();
		FlowLayout flowLayout = (FlowLayout) insertBook.getLayout();
		flowLayout.setVgap(20);
		flowLayout.setHgap(20);
		contentPane.add(insertBook, BorderLayout.NORTH);
		
		passwordField = new JPasswordField();
		insertBook.add(passwordField);
		
		recommendation = new Recommendation();
		contentPane.add(recommendation, BorderLayout.CENTER);
	}

}
