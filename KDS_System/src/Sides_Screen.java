import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Toolkit;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;


public class Sides_Screen {

	JFrame frmSides;
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
					Sides_Screen window = new Sides_Screen();
					window.frmSides.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Sides_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSides = new JFrame();
		frmSides.getContentPane().setBackground(Color.WHITE);
		frmSides.setTitle("Sides");
		frmSides.setIconImage(Toolkit.getDefaultToolkit().getImage(Sides_Screen.class.getResource("/General_images/GI_icon.png")));
		frmSides.setBounds(100, 100, 400, 600);
		frmSides.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSides.getContentPane().setLayout(null);
		
		JButton button = new JButton("Back");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				exitScreen();
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 20));
		button.setBounds(142, 0, 114, 43);
		frmSides.getContentPane().add(button);
		
		JButton btnHashBrowns = new JButton("Hash Browns");
		btnHashBrowns.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 801;
				item_price = Query.PriceQuery(item_id);
				//Add hash browns to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmSides.dispose();
			}
		});
		btnHashBrowns.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHashBrowns.setBounds(67, 83, 258, 51);
		frmSides.getContentPane().add(btnHashBrowns);
		
		JButton btnCinnamonRoll = new JButton("Cinnamon Roll");
		btnCinnamonRoll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 802;
				item_price = Query.PriceQuery(item_id);
				//Add a cinnamon roll to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmSides.dispose();
			}
		});
		btnCinnamonRoll.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCinnamonRoll.setBounds(67, 169, 258, 51);
		frmSides.getContentPane().add(btnCinnamonRoll);
		
		JButton btnBaconOrSausage = new JButton("Bacon or Sausage");
		btnBaconOrSausage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 803;
				item_price = Query.PriceQuery(item_id);
				//Add bacon or sausage to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmSides.dispose();
			}
			
		});
		btnBaconOrSausage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBaconOrSausage.setBounds(67, 253, 258, 51);
		frmSides.getContentPane().add(btnBaconOrSausage);
		
		JButton btnBiscuitNGravy = new JButton("Biscuit n' Gravy");
		btnBiscuitNGravy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 804;
				item_price = Query.PriceQuery(item_id);
				//Add Biscut n' Gravy to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmSides.dispose();
			}
		});
		btnBiscuitNGravy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBiscuitNGravy.setBounds(67, 341, 258, 51);
		frmSides.getContentPane().add(btnBiscuitNGravy);
		
		JButton btnToast = new JButton("Toast");
		btnToast.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 805;
				item_price = Query.PriceQuery(item_id);
				//Add toast to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmSides.dispose();
			}
		});
		btnToast.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnToast.setBounds(67, 424, 258, 51);
		frmSides.getContentPane().add(btnToast);
	}

	protected void exitScreen() {
		
		frmSides.dispose();
	}

}
