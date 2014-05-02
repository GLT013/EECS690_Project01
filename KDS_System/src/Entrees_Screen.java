import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Toolkit;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;


public class Entrees_Screen {

	JFrame frmEntrees;
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
					Entrees_Screen window = new Entrees_Screen();
					window.frmEntrees.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Entrees_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEntrees = new JFrame();
		frmEntrees.getContentPane().setBackground(Color.WHITE);
		frmEntrees.setIconImage(Toolkit.getDefaultToolkit().getImage(Entrees_Screen.class.getResource("/General_images/GI_icon.png")));
		frmEntrees.setTitle("Entrees");
		frmEntrees.setBounds(100, 100, 400, 600);
		frmEntrees.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEntrees.getContentPane().setLayout(null);
		
		JButton button = new JButton("Back");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				exitScreen();
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 20));
		button.setBounds(134, 0, 114, 43);
		frmEntrees.getContentPane().add(button);
		
		JButton btnCFriedSteak = new JButton("C Fried Stk");
		btnCFriedSteak.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 601;
				item_price = Query.PriceQuery(item_id);
				//Add country fried steak to ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmEntrees.dispose();
			}
		});
		btnCFriedSteak.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCFriedSteak.setBounds(21, 99, 158, 51);
		frmEntrees.getContentPane().add(btnCFriedSteak);
		
		JButton btnRibeye = new JButton("Ribeye");
		btnRibeye.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 605;
				item_price = Query.PriceQuery(item_id);
				//Add a ribeye to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmEntrees.dispose();
			}
		});
		btnRibeye.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRibeye.setBounds(213, 99, 158, 51);
		frmEntrees.getContentPane().add(btnRibeye);
		
		JButton btnChicStrDin = new JButton("Chic Str Din");
		btnChicStrDin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 602;
				item_price = Query.PriceQuery(item_id);
				//Add a chicken strip dinner to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmEntrees.dispose();
			}
		});
		btnChicStrDin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnChicStrDin.setBounds(21, 186, 158, 51);
		frmEntrees.getContentPane().add(btnChicStrDin);
		
		JButton btnFishNChip = new JButton("Fish n' Chip");
		btnFishNChip.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 606;
				item_price = Query.PriceQuery(item_id);
				//Add catfish and chips to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmEntrees.dispose();
			}
		});
		btnFishNChip.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFishNChip.setBounds(213, 186, 158, 51);
		frmEntrees.getContentPane().add(btnFishNChip);
		
		JButton btnCodFilets = new JButton("Cod Filets");
		btnCodFilets.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 603;
				item_price = Query.PriceQuery(item_id);
				//Add cod filets to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmEntrees.dispose();
			}
		});
		btnCodFilets.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCodFilets.setBounds(21, 276, 158, 51);
		frmEntrees.getContentPane().add(btnCodFilets);
		
		JButton btnChicParm = new JButton("Chic Parm");
		btnChicParm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 607;
				item_price = Query.PriceQuery(item_id);
				//Add chicken parmesan to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmEntrees.dispose();
			}
		});
		btnChicParm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnChicParm.setBounds(213, 276, 158, 51);
		frmEntrees.getContentPane().add(btnChicParm);
		
		JButton btnKcStrip = new JButton("KC Strip");
		btnKcStrip.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 604;
				item_price = Query.PriceQuery(item_id);
				//Add a KC strip to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmEntrees.dispose();
			}
		});
		btnKcStrip.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnKcStrip.setBounds(21, 378, 158, 51);
		frmEntrees.getContentPane().add(btnKcStrip);
		
		JButton btnMeatloaf = new JButton("Meatloaf");
		btnMeatloaf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 608;
				item_price = Query.PriceQuery(item_id);
				//Add a meatloaf to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmEntrees.dispose();
			}
		});
		btnMeatloaf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMeatloaf.setBounds(213, 378, 158, 51);
		frmEntrees.getContentPane().add(btnMeatloaf);
		
		JButton btnFettAlf = new JButton("Fett Alf");
		btnFettAlf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 609;
				item_price = Query.PriceQuery(item_id);
				//Add a fettuccine Alfredo to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmEntrees.dispose();
			}
		});
		btnFettAlf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFettAlf.setBounds(122, 456, 158, 51);
		frmEntrees.getContentPane().add(btnFettAlf);
	}

	protected void exitScreen() {
		
		frmEntrees.dispose();
	}

}
