import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Toolkit;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;


public class Omelets_Screen {

	JFrame frmOmelets;
	int item_id = 0;
	double item_price = 0;
	String item_name = "";
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Omelets_Screen window = new Omelets_Screen();
					window.frmOmelets.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Omelets_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOmelets = new JFrame();
		frmOmelets.getContentPane().setBackground(Color.WHITE);
		frmOmelets.setTitle("Omelets");
		frmOmelets.setIconImage(Toolkit.getDefaultToolkit().getImage(Omelets_Screen.class.getResource("/General_images/GI_icon.png")));
		frmOmelets.setBounds(100, 100, 400, 600);
		frmOmelets.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOmelets.getContentPane().setLayout(null);
		
		JButton button = new JButton("Back");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				exitScreen();
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 20));
		button.setBounds(138, 0, 114, 43);
		frmOmelets.getContentPane().add(button);
		
		JButton btnDenverOmelet = new JButton("Denver Omelet");
		btnDenverOmelet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				item_id = 711;
				item_price = Query.PriceQuery(item_id);
				//Add Denver omelet to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmOmelets.dispose();
			}
		});
		btnDenverOmelet.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDenverOmelet.setBounds(61, 92, 258, 51);
		frmOmelets.getContentPane().add(btnDenverOmelet);
		
		JButton btnCheeseOmelet = new JButton("Cheese Omelet");
		btnCheeseOmelet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 712;
				item_price = Query.PriceQuery(item_id);
				//Add Cheese Omelet to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmOmelets.dispose();
			}
		});
		btnCheeseOmelet.setToolTipText("Omelette du fromage!");
		btnCheeseOmelet.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCheeseOmelet.setBounds(61, 191, 258, 51);
		frmOmelets.getContentPane().add(btnCheeseOmelet);
		
		JButton btnVeggieOmelet = new JButton("Veggie Omelet");
		btnVeggieOmelet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 713;
				item_price = Query.PriceQuery(item_id);
				//Add Veggie Omelet to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmOmelets.dispose();
			}
		});
		btnVeggieOmelet.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVeggieOmelet.setBounds(61, 295, 258, 51);
		frmOmelets.getContentPane().add(btnVeggieOmelet);
		
		JButton btnSouthwestOmelet = new JButton("Southwest Omelet");
		btnSouthwestOmelet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 714;
				item_price = Query.PriceQuery(item_id);
				//Add Southwest Omelet to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmOmelets.dispose();
			}
		});
		btnSouthwestOmelet.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSouthwestOmelet.setBounds(61, 409, 258, 51);
		frmOmelets.getContentPane().add(btnSouthwestOmelet);
	}

	protected void exitScreen() {


		frmOmelets.dispose();
		
	}

}
