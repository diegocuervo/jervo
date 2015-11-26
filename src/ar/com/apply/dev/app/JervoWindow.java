package ar.com.apply.dev.app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class JervoWindow {

	private JFrame frmJervo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JervoWindow window = new JervoWindow();
					window.frmJervo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JervoWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJervo = new JFrame();
		frmJervo.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\DESARROLLO\\creative-rat-icon-169046.jpg"));
		frmJervo.setTitle("Jervo  Maintenance Tool 1.0");
		frmJervo.setBounds(100, 100, 450, 300);
		frmJervo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JToolBar toolBar = new JToolBar();
		frmJervo.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\DESARROLLO\\creative-rat-icon-169046.jpg"));
		toolBar.add(btnNewButton);
	}

}
