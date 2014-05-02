import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Toolkit;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;


public class Specials_Screen {

	JFrame frmSpecialties;
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
					Specials_Screen window = new Specials_Screen();
					window.frmSpecialties.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Specials_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSpecialties = new JFrame();
		frmSpecialties.getContentPane().setBackground(Color.WHITE);
		frmSpecialties.setTitle("Specialties");
		frmSpecialties.setIconImage(Toolkit.getDefaultToolkit().getImage(Specials_Screen.class.getResource("/General_images/GI_icon.png")));
		frmSpecialties.setBounds(100, 100, 400, 600);
		frmSpecialties.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSpecialties.getContentPane().setLayout(null);
		
		JButton button = new JButton("Back");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				exitScreen();
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 20));
		button.setBounds(138, 0, 114, 43);
		frmSpecialties.getContentPane().add(button);
		
		JButton btnExpress = new JButton("Express");
		btnExpress.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 701;
				item_price = Query.PriceQuery(item_id);
				//Add the express to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmSpecialties.dispose();
			}
		});
		btnExpress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExpress.setBounds(28, 103, 158, 51);
		frmSpecialties.getContentPane().add(btnExpress);
		
		JButton btnFreToast = new JButton("French Toast");
		btnFreToast.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 702;
				item_price = Query.PriceQuery(item_id);
				//Add french toast to the ticket.
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmSpecialties.dispose();
			}
		});
		btnFreToast.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFreToast.setBounds(28, 208, 158, 51);
		frmSpecialties.getContentPane().add(btnFreToast);
		
		JButton btnEarlyBird = new JButton("Early Bird");
		btnEarlyBird.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 703;
				item_price = Query.PriceQuery(item_id);
				//Add the early bird to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmSpecialties.dispose();
			}
		});
		btnEarlyBird.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEarlyBird.setBounds(28, 315, 158, 51);
		frmSpecialties.getContentPane().add(btnEarlyBird);
		
		JButton btnBelgianW = new JButton("Belgian Waf");
		btnBelgianW.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 706;
				item_price = Query.PriceQuery(item_id);
				//Add belgian waffles to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmSpecialties.dispose();
			}
		});
		btnBelgianW.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBelgianW.setBounds(206, 315, 158, 51);
		frmSpecialties.getContentPane().add(btnBelgianW);
		
		JButton btnBiscNGrav = new JButton("Bisc n' Grav");
		btnBiscNGrav.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 705;
				item_price = Query.PriceQuery(item_id);
				//Add biscuits and gravy to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmSpecialties.dispose();
			}
		});
		btnBiscNGrav.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBiscNGrav.setBounds(206, 208, 158, 51);
		frmSpecialties.getContentPane().add(btnBiscNGrav);
		
		JButton btnTripleStack = new JButton("Triple Stack");
		btnTripleStack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 704;
				item_price = Query.PriceQuery(item_id);
				//Add the triple stack to the ticket.
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmSpecialties.dispose();
			}
		});
		btnTripleStack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTripleStack.setBounds(206, 103, 158, 51);
		frmSpecialties.getContentPane().add(btnTripleStack);
		
		JButton btnHalfWCombo = new JButton("Half Waffle Combo");
		btnHalfWCombo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 707;
				item_price = Query.PriceQuery(item_id);
				//Add a half waffle combo to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmSpecialties.dispose();
			}
		});
		btnHalfWCombo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHalfWCombo.setBounds(28, 407, 336, 51);
		frmSpecialties.getContentPane().add(btnHalfWCombo);
	}

	protected void exitScreen() {


		frmSpecialties.dispose();
		
	}

}
