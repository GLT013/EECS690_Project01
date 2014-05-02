import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.Color;


public class Apps_Screen {
	int item_id = 0;
	double item_price = 0;
	String item_name = "";	
	JFrame frmAppetizers;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apps_Screen window = new Apps_Screen();
					window.frmAppetizers.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Apps_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAppetizers = new JFrame();
		frmAppetizers.getContentPane().setBackground(Color.WHITE);
		frmAppetizers.setTitle("Appetizers");
		frmAppetizers.setIconImage(Toolkit.getDefaultToolkit().getImage(Apps_Screen.class.getResource("/General_images/GI_icon.png")));
		frmAppetizers.setBounds(100, 100, 400, 600);
		frmAppetizers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAppetizers.getContentPane().setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				exitScreen();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBounds(138, 11, 114, 43);
		frmAppetizers.getContentPane().add(btnBack);
		
		JButton btnSpinDip = new JButton("Spin Dip");
		btnSpinDip.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 101;
				item_price = Query.PriceQuery(item_id);
				//Add Spin dip to ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem( Server_Screen.tableID, item_name, item_price);
				frmAppetizers.dispose();
				
			}
		});
		btnSpinDip.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSpinDip.setBounds(104, 152, 181, 53);
		frmAppetizers.getContentPane().add(btnSpinDip);
		
		JButton btnMozzSticks = new JButton("Mozz Sticks");
		btnMozzSticks.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 102;
				item_price = Query.PriceQuery(item_id);
				//Add mozz sticks to ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem( Server_Screen.tableID, item_name, item_price);
				frmAppetizers.dispose();
			}
		});
		btnMozzSticks.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMozzSticks.setBounds(104, 301, 181, 53);
		frmAppetizers.getContentPane().add(btnMozzSticks);
		
		JButton btnChicFing = new JButton("Chic Fing");
		btnChicFing.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 103;
				item_price = Query.PriceQuery(item_id);
				//Add chicken fingers to ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem( Server_Screen.tableID, item_name, item_price);
				frmAppetizers.dispose();
			}
		});
		btnChicFing.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnChicFing.setBounds(104, 450, 181, 53);
		frmAppetizers.getContentPane().add(btnChicFing);
	}

	protected void exitScreen() {
		
		frmAppetizers.dispose();
		
	}
}
