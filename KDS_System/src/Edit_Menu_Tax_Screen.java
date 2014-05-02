import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;


public class Edit_Menu_Tax_Screen {

	JFrame frmEditMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Edit_Menu_Tax_Screen window = new Edit_Menu_Tax_Screen();
					window.frmEditMenu.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Edit_Menu_Tax_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEditMenu = new JFrame();
		frmEditMenu.setTitle("Edit Menu /  Tax");
		frmEditMenu.setIconImage(Toolkit.getDefaultToolkit().getImage(Edit_Menu_Tax_Screen.class.getResource("/General_images/GI_icon.png")));
		frmEditMenu.setBounds(100, 100,800, 600);
		frmEditMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEditMenu.getContentPane().setLayout(null);
		
		JLabel lblNotFinished = new JLabel("Not Finished");
		lblNotFinished.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNotFinished.setBounds(394, 176, 272, 98);
		frmEditMenu.getContentPane().add(lblNotFinished);
	}
}
