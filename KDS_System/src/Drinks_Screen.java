import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Toolkit;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;


public class Drinks_Screen {
	int item_id = 0;
	double item_price = 0;
	JFrame frmDrinks;
	String item_name = "";
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Drinks_Screen window = new Drinks_Screen();
					window.frmDrinks.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Drinks_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDrinks = new JFrame();
		frmDrinks.getContentPane().setBackground(Color.WHITE);
		frmDrinks.setTitle("Drinks");
		frmDrinks.setIconImage(Toolkit.getDefaultToolkit().getImage(Drinks_Screen.class.getResource("/General_images/GI_icon.png")));
		frmDrinks.setBounds(100, 100, 400, 600);
		frmDrinks.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDrinks.getContentPane().setLayout(null);
		
		JButton button = new JButton("Back");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				exitScreen();
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 20));
		button.setBounds(132, 0, 114, 43);
		frmDrinks.getContentPane().add(button);
		
		JButton btnSoftDrink = new JButton("Soft Drink");
		btnSoftDrink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 901;
				item_price = Query.PriceQuery(item_id);
				//Add a soft drink to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmDrinks.dispose();
			}
		});
		btnSoftDrink.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSoftDrink.setBounds(68, 75, 258, 51);
		frmDrinks.getContentPane().add(btnSoftDrink);
		
		JButton btnCoffee = new JButton("Coffee");
		btnCoffee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 902;
				item_price = Query.PriceQuery(item_id);
				//Add a coffee to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmDrinks.dispose();
			}
		});
		btnCoffee.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCoffee.setBounds(68, 151, 258, 51);
		frmDrinks.getContentPane().add(btnCoffee);
		
		JButton btnHotTea = new JButton("Hot Tea");
		btnHotTea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 903;
				item_price = Query.PriceQuery(item_id);
				//Add hot tea to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmDrinks.dispose();
			}
		});
		btnHotTea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHotTea.setBounds(68, 236, 258, 51);
		frmDrinks.getContentPane().add(btnHotTea);
		
		JButton btnIcedTea = new JButton("Iced Tea");
		btnIcedTea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 904;
				item_price = Query.PriceQuery(item_id);
				//Add iced tea to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmDrinks.dispose();
			}
		});
		btnIcedTea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnIcedTea.setBounds(68, 307, 258, 51);
		frmDrinks.getContentPane().add(btnIcedTea);
		
		JButton btnSmMilk = new JButton("Sm Milk");
		btnSmMilk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 905;
				item_price = Query.PriceQuery(item_id);
				//Add a small milk to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmDrinks.dispose();
			}
		});
		btnSmMilk.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSmMilk.setBounds(68, 401, 122, 51);
		frmDrinks.getContentPane().add(btnSmMilk);
		
		JButton btnLgMilk = new JButton("Lg Milk");
		btnLgMilk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 905;
				item_price = Query.PriceQuery(item_id);
				// Add a large milk to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmDrinks.dispose();
			}
		});
		btnLgMilk.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLgMilk.setBounds(204, 401, 122, 51);
		frmDrinks.getContentPane().add(btnLgMilk);
		
		JButton btnSmOj = new JButton("Sm OJ");
		btnSmOj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 906;
				item_price = Query.PriceQuery(item_id);
				// Add a small OJ to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmDrinks.dispose();
			}
		});
		btnSmOj.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSmOj.setBounds(68, 482, 122, 51);
		frmDrinks.getContentPane().add(btnSmOj);
		
		JButton btnLgOj = new JButton("Lg OJ");
		btnLgOj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 906;
				item_price = Query.PriceQuery(item_id);
				// Add a large OJ to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmDrinks.dispose();
			}
		});
		btnLgOj.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLgOj.setBounds(204, 482, 122, 51);
		frmDrinks.getContentPane().add(btnLgOj);
	}

	protected void exitScreen() {
		
		frmDrinks.dispose();
	}

}
