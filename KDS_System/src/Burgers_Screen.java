import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;


public class Burgers_Screen {
	int item_id = 0;
	double item_price = 0;
	String item_name = "";
	

	JFrame frmBurgers;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Burgers_Screen window = new Burgers_Screen();
					window.frmBurgers.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Burgers_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBurgers = new JFrame();
		frmBurgers.getContentPane().setBackground(Color.WHITE);
		frmBurgers.setTitle("Burgers");
		frmBurgers.setIconImage(Toolkit.getDefaultToolkit().getImage(Burgers_Screen.class.getResource("/General_images/GI_icon.png")));
		frmBurgers.setBounds(100, 100, 400, 600);
		frmBurgers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBurgers.getContentPane().setLayout(null);
		
		JButton button = new JButton("Back");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				exitScreen();
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 20));
		button.setBounds(134, 0, 114, 43);
		frmBurgers.getContentPane().add(button);
		
		JButton btnTheClassic = new JButton("The Classic");
		btnTheClassic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 501;
				item_price = Query.PriceQuery(item_id);
				//Add the classic to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmBurgers.dispose();
			}
		});
		btnTheClassic.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTheClassic.setBounds(85, 101, 218, 51);
		frmBurgers.getContentPane().add(btnTheClassic);
		
		JButton btnAmtrac = new JButton("AMTRAC");
		btnAmtrac.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 502;
				item_price = Query.PriceQuery(item_id);
				//Add the AMTRAC to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmBurgers.dispose();
			}
		});
		btnAmtrac.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAmtrac.setBounds(85, 189, 218, 51);
		frmBurgers.getContentPane().add(btnAmtrac);
		
		JButton btnSantaFe = new JButton("Santa Fe");
		btnSantaFe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 503;
				item_price = Query.PriceQuery(item_id);
				//Add the Santa Fe to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmBurgers.dispose();
			}
		});
		btnSantaFe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSantaFe.setBounds(85, 286, 218, 51);
		frmBurgers.getContentPane().add(btnSantaFe);
		
		JButton btnBnsf = new JButton("BNSF");
		btnBnsf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item_id = 504;
				item_price = Query.PriceQuery(item_id);
				//Add the PNSF to the ticket
				item_name = Query.ItemQuery(item_id);			
				Table_Edit_Screen.InsertItem(Server_Screen.tableID, item_name, item_price);
				frmBurgers.dispose();
			}
		});
		btnBnsf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBnsf.setBounds(85, 381, 218, 51);
		frmBurgers.getContentPane().add(btnBnsf);
	}

	protected void exitScreen() {
		
		frmBurgers.dispose();
		
	}

}
