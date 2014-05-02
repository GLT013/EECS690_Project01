import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Toolkit;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;


public class Combos_Screen {
	int item_id = -1;
	double item_price = -1;
	String item_name = "";	
	JFrame frmCombinations;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Combos_Screen window = new Combos_Screen();
					window.frmCombinations.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Combos_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCombinations = new JFrame();
		frmCombinations.getContentPane().setBackground(Color.WHITE);
		frmCombinations.setTitle("Combinations");
		frmCombinations.setIconImage(Toolkit.getDefaultToolkit().getImage(Combos_Screen.class.getResource("/General_images/GI_icon.png")));
		frmCombinations.setBounds(100, 100, 400, 600);
		frmCombinations.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCombinations.getContentPane().setLayout(null);
		
		JButton button = new JButton("Back");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				exitScreen();
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 20));
		button.setBounds(133, 0, 114, 43);
		frmCombinations.getContentPane().add(button);
		
		JButton btnBaconsausageNEgg = new JButton("Bacon/Sausage n' Egg");
		btnBaconsausageNEgg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 708;
				item_price = Query.PriceQuery(item_id);				
				//Add a bacon or sausage and eggs to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmCombinations.dispose();
			}
		});
		btnBaconsausageNEgg.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBaconsausageNEgg.setBounds(61, 117, 258, 51);
		frmCombinations.getContentPane().add(btnBaconsausageNEgg);
		
		JButton btnHamNEggs = new JButton("Ham n' Eggs");
		btnHamNEggs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 709;
				item_price = Query.PriceQuery(item_id);
				//Add a ham and eggs to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmCombinations.dispose();
			}
		});
		btnHamNEggs.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHamNEggs.setBounds(61, 220, 258, 51);
		frmCombinations.getContentPane().add(btnHamNEggs);
		
		JButton btnSteakNEggs = new JButton("Steak n' Eggs");
		btnSteakNEggs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 710;
				item_price = Query.PriceQuery(item_id);
				//Add a steak and eggs to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmCombinations.dispose();
			}
		});
		btnSteakNEggs.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSteakNEggs.setBounds(61, 330, 258, 51);
		frmCombinations.getContentPane().add(btnSteakNEggs);
	}

	protected void exitScreen() {


		frmCombinations.dispose();
		
	}
	
	
	
	
	
	

}
