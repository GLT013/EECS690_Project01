import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;


public class Sandwiches_Screen {

	JFrame frmSandwiches;
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
					Sandwiches_Screen window = new Sandwiches_Screen();
					window.frmSandwiches.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Sandwiches_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSandwiches = new JFrame();
		frmSandwiches.getContentPane().setBackground(Color.WHITE);
		frmSandwiches.setTitle("Sandwiches");
		frmSandwiches.setIconImage(Toolkit.getDefaultToolkit().getImage(Sandwiches_Screen.class.getResource("/General_images/GI_icon.png")));
		frmSandwiches.setBounds(100, 100, 400, 600);
		frmSandwiches.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSandwiches.getContentPane().setLayout(null);
		
		JButton button = new JButton("Back");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				exitScreen();
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 20));
		button.setBounds(141, 0, 114, 43);
		frmSandwiches.getContentPane().add(button);
		
		JButton btnTunaMelt = new JButton("Tuna Melt");
		btnTunaMelt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 301;
				item_price = Query.PriceQuery(item_id);
				//Add a tuna melt to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmSandwiches.dispose();
			}
		});
		btnTunaMelt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTunaMelt.setBounds(21, 91, 143, 51);
		frmSandwiches.getContentPane().add(btnTunaMelt);
		
		JButton btnGrillChic = new JButton("Grill Chic");
		btnGrillChic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 302;
				item_price = Query.PriceQuery(item_id);
				//Add grilled chicken sandwich to ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmSandwiches.dispose();
			}
		});
		btnGrillChic.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGrillChic.setBounds(21, 165, 143, 51);
		frmSandwiches.getContentPane().add(btnGrillChic);
		
		JButton btnPhilly = new JButton("Philly");
		btnPhilly.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 303;
				item_price = Query.PriceQuery(item_id);
				//Add regular philly cheesesteak to ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmSandwiches.dispose();
			}
		});
		btnPhilly.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPhilly.setBounds(21, 245, 143, 51);
		frmSandwiches.getContentPane().add(btnPhilly);
		
		JButton btnChicPhilly = new JButton("Chic Philly");
		btnChicPhilly.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 304;
				item_price = Query.PriceQuery(item_id);
				//Add chicken philly to ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmSandwiches.dispose();
			}
		});
		btnChicPhilly.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnChicPhilly.setBounds(21, 324, 143, 51);
		frmSandwiches.getContentPane().add(btnChicPhilly);
		
		JButton btnVeggie = new JButton("Veggie");
		btnVeggie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 305;
				item_price = Query.PriceQuery(item_id);
				//Add veggie sandwich to ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmSandwiches.dispose();
			}
		});
		btnVeggie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVeggie.setBounds(21, 409, 143, 51);
		frmSandwiches.getContentPane().add(btnVeggie);
		
		JButton btnTurkSand = new JButton("Turk Sand");
		btnTurkSand.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 403;
				item_price = Query.PriceQuery(item_id);
				//add turkey sandwich to ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmSandwiches.dispose();
			}
		});
		btnTurkSand.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTurkSand.setBounds(227, 409, 143, 51);
		frmSandwiches.getContentPane().add(btnTurkSand);
		
		JButton btnClub = new JButton("Club");
		btnClub.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 402;
				item_price = Query.PriceQuery(item_id);
				//add a club to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmSandwiches.dispose();
			}
		});
		btnClub.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnClub.setBounds(227, 324, 143, 51);
		frmSandwiches.getContentPane().add(btnClub);
		
		JButton btnRoastBeef = new JButton("Roast Beef");
		btnRoastBeef.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 401;
				item_price = Query.PriceQuery(item_id);
				//add roast beef to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmSandwiches.dispose();
			}
		});
		btnRoastBeef.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRoastBeef.setBounds(227, 245, 143, 51);
		frmSandwiches.getContentPane().add(btnRoastBeef);
		
		JButton btnHamChee = new JButton("Grill H&C");
		btnHamChee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 307;
				item_price = Query.PriceQuery(item_id);
				//add grilled ham and cheese to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmSandwiches.dispose();
			}
		});
		btnHamChee.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHamChee.setBounds(227, 165, 143, 51);
		frmSandwiches.getContentPane().add(btnHamChee);
		
		JButton btnFishSand = new JButton("Fish Sand");
		btnFishSand.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 306;
				item_price = Query.PriceQuery(item_id);
				//add a fish sandwich to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmSandwiches.dispose();
			}
		});
		btnFishSand.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFishSand.setBounds(227, 91, 143, 51);
		frmSandwiches.getContentPane().add(btnFishSand);
		
		JButton btnChicSalad = new JButton("Chic Salad");
		btnChicSalad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 404;
				item_price = Query.PriceQuery(item_id);
				//add a chicken salad sandwich to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmSandwiches.dispose();
			}
		});
		btnChicSalad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnChicSalad.setBounds(122, 489, 143, 51);
		frmSandwiches.getContentPane().add(btnChicSalad);
	}

	protected void exitScreen() {
				
		frmSandwiches.dispose();
	}

}
