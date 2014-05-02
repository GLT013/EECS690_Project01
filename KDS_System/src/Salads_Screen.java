import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Font;

import java.awt.Toolkit;
import java.awt.Color;


public class Salads_Screen {

	JFrame frmSalads;
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
					Salads_Screen window = new Salads_Screen();
					window.frmSalads.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Salads_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSalads = new JFrame();
		frmSalads.getContentPane().setBackground(Color.WHITE);
		frmSalads.setTitle("Salads");
		frmSalads.setIconImage(Toolkit.getDefaultToolkit().getImage(Salads_Screen.class.getResource("/General_images/GI_icon.png")));
		frmSalads.setBounds(100, 100, 400, 600);
		frmSalads.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSalads.getContentPane().setLayout(null);
		
		JButton button = new JButton("Back");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				exitScreen();
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 20));
		button.setBounds(143, 0, 114, 43);
		frmSalads.getContentPane().add(button);
		
		JButton btnNewButton = new JButton("Chic Strip Sal");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 201;
				item_price = Query.PriceQuery(item_id);
				//Add Chicken Strip Salad to ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmSalads.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(113, 103, 176, 55);
		frmSalads.getContentPane().add(btnNewButton);
		
		JButton btnChefSalad = new JButton("Chef Salad");
		btnChefSalad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 202;
				item_price = Query.PriceQuery(item_id);
				//Add Chef Salad to ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmSalads.dispose();
			}
		});
		btnChefSalad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnChefSalad.setBounds(113, 194, 176, 55);
		frmSalads.getContentPane().add(btnChefSalad);
		
		JButton btnCeaserSalad = new JButton("Ceaser Salad");
		btnCeaserSalad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 203;
				item_price = Query.PriceQuery(item_id);
				//Add ceaser salad to ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmSalads.dispose();
			}
		});
		btnCeaserSalad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCeaserSalad.setBounds(113, 291, 176, 55);
		frmSalads.getContentPane().add(btnCeaserSalad);
		
		JButton btnSideSalad = new JButton("Side Salad");
		btnSideSalad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 204;
				item_price = Query.PriceQuery(item_id);
				//Add side salad to ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmSalads.dispose();
			}
		});
		btnSideSalad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSideSalad.setBounds(113, 376, 176, 55);
		frmSalads.getContentPane().add(btnSideSalad);
	}

	protected void exitScreen() {

		frmSalads.dispose();
		
	}
}
