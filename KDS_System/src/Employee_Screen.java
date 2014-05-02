import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;


public class Employee_Screen {

	JFrame frmEmployeeScreen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee_Screen window = new Employee_Screen();
					window.frmEmployeeScreen.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Employee_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEmployeeScreen = new JFrame();
		frmEmployeeScreen.getContentPane().setBackground(Color.WHITE);
		frmEmployeeScreen.setIconImage(Toolkit.getDefaultToolkit().getImage(Employee_Screen.class.getResource("/General_images/GI_icon.png")));
		frmEmployeeScreen.setTitle("Employee Screen");
		frmEmployeeScreen.setBounds(100, 100, 800, 600);
		frmEmployeeScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEmployeeScreen.getContentPane().setLayout(null);
		
		JLabel lblComingSoon = new JLabel("Coming Soon...");
		lblComingSoon.setFont(new Font("Dialog", Font.BOLD, 20));
		lblComingSoon.setBounds(314, 85, 243, 60);
		frmEmployeeScreen.getContentPane().add(lblComingSoon);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//return to the manager screen
				frmEmployeeScreen.dispose();
				
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 20));
		btnNewButton.setBounds(327, 0, 117, 44);
		frmEmployeeScreen.getContentPane().add(btnNewButton);
	}

}
