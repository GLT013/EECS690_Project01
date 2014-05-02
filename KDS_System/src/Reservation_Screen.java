import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.UIManager;


public class Reservation_Screen {

	JFrame frmReserveMain;
	public Object frame;
	public static int tableID = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservation_Screen window = new Reservation_Screen();
					window.frmReserveMain.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Reservation_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmReserveMain = new JFrame();
		frmReserveMain.setTitle("Reservation Main");
		frmReserveMain.setIconImage(Toolkit.getDefaultToolkit().getImage(Reservation_Screen.class.getResource("/General_images/GI_icon.png")));
		frmReserveMain.setBounds(100, 100, 800, 600);
		frmReserveMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmReserveMain.getContentPane().setLayout(null);
		
		JButton table25btn = new JButton("Table 25");
		table25btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				reserveTable(25);
			}
		});
		table25btn.setHorizontalAlignment(SwingConstants.LEFT);
		table25btn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		if (isReserved(25)){		
			
			table25btn.setBackground(Color.BLUE);
			
		}
		else if(isInUse(25)){
			
			table25btn.setBackground(Color.RED);
		}
		else{
			
			table25btn.setBackground(UIManager.getColor("Button.background"));
		}
		table25btn.setBounds(665, 464, 74, 87);
		frmReserveMain.getContentPane().add(table25btn);
		
		JButton table24btn = new JButton("Table 24");
		table24btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				reserveTable(24);
			}
		});
		table24btn.setHorizontalAlignment(SwingConstants.LEFT);
		table24btn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		if (isReserved(24)){		
			
			table24btn.setBackground(Color.BLUE);
			
		}
		else if(isInUse(24)){
			
			table24btn.setBackground(Color.RED);
		}
		else{
			
			table24btn.setBackground(UIManager.getColor("Button.background"));
		}
		table24btn.setBounds(664, 360, 75, 87);
		frmReserveMain.getContentPane().add(table24btn);
		
		JButton table23btn = new JButton("Table 23");
		table23btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				reserveTable(23);
			}
		});
		table23btn.setHorizontalAlignment(SwingConstants.LEFT);
		table23btn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		if (isReserved(23)){		
			
			table23btn.setBackground(Color.BLUE);
			
		}
		else if(isInUse(23)){
			
			table23btn.setBackground(Color.RED);
		}
		else{
			
			table23btn.setBackground(UIManager.getColor("Button.background"));
		}
		table23btn.setBounds(663, 251, 74, 87);
		frmReserveMain.getContentPane().add(table23btn);
		
		JButton table22btn = new JButton("Table 22");
		table22btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				reserveTable(22);
			}
		});
		table22btn.setHorizontalAlignment(SwingConstants.LEFT);
		table22btn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		if (isReserved(22)){		
			
			table22btn.setBackground(Color.BLUE);
			
		}
		else if(isInUse(22)){
			
			table22btn.setBackground(Color.RED);
		}
		else{
			
			table22btn.setBackground(UIManager.getColor("Button.background"));
		}
		table22btn.setBounds(663, 148, 75, 83);
		frmReserveMain.getContentPane().add(table22btn);
		
		JButton table21btn = new JButton("Table 21");
		table21btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				reserveTable(21);
			}
		});
		table21btn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		table21btn.setHorizontalAlignment(SwingConstants.LEFT);
		if (isReserved(21)){		
			
			table21btn.setBackground(Color.BLUE);
			
		}
		else if(isInUse(21)){
			
			table21btn.setBackground(Color.RED);
		}
		else{
			
			table21btn.setBackground(UIManager.getColor("Button.background"));
		}
		table21btn.setBounds(663, 52, 75, 83);
		frmReserveMain.getContentPane().add(table21btn);
		
		JButton table20btn = new JButton("20");
		table20btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				reserveTable(20);
			}
		});
		table20btn.setBounds(540, 448, 53, 51);
		frmReserveMain.getContentPane().add(table20btn);
		if (isReserved(20)){		
			
			table20btn.setBackground(Color.BLUE);
			
		}
		else if(isInUse(20)){
			
			table20btn.setBackground(Color.RED);
		}
		else{
			
			table20btn.setBackground(UIManager.getColor("Button.background"));
		}
		
		JButton table19btn = new JButton("19");
		table19btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				reserveTable(19);
			}
		});
		table19btn.setBounds(540, 268, 53, 51);
		frmReserveMain.getContentPane().add(table19btn);
		if (isReserved(19)){		
			
			table19btn.setBackground(Color.BLUE);
			
		}
		else if(isInUse(19)){
			
			table19btn.setBackground(Color.RED);
		}
		else{
			
			table19btn.setBackground(UIManager.getColor("Button.background"));
		}
		
		
		JButton table18btn = new JButton("18");
		table18btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				reserveTable(18);
			}
		});
		table18btn.setBounds(540, 93, 53, 51);
		frmReserveMain.getContentPane().add(table18btn);
		if (isReserved(18)){		
			
			table18btn.setBackground(Color.BLUE);
			
		}
		else if(isInUse(18)){
			
			table18btn.setBackground(Color.RED);
		}
		else{
			
			table18btn.setBackground(UIManager.getColor("Button.background"));
		}
		
		JButton table17btn = new JButton("17");
		table17btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				reserveTable(17);
			}
		});
		table17btn.setBounds(457, 448, 53, 51);
		frmReserveMain.getContentPane().add(table17btn);
		if (isReserved(17)){		
			
			table17btn.setBackground(Color.BLUE);
			
		}
		else if(isInUse(17)){
			
			table17btn.setBackground(Color.RED);
		}
		else{
			
			table17btn.setBackground(UIManager.getColor("Button.background"));
		}
		
		JButton table16btn = new JButton("16");
		table16btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				reserveTable(16);
			}
		});
		table16btn.setBounds(457, 268, 53, 51);
		frmReserveMain.getContentPane().add(table16btn);
		if (isReserved(16)){		
			
			table16btn.setBackground(Color.BLUE);
			
		}
		else if(isInUse(16)){
			
			table16btn.setBackground(Color.RED);
		}
		else{
			
			table16btn.setBackground(UIManager.getColor("Button.background"));
		}
		
		JButton table15btn = new JButton("15");
		table15btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				reserveTable(15);
			}
		});
		table15btn.setBounds(457, 93, 53, 51);
		frmReserveMain.getContentPane().add(table15btn);
		if (isReserved(15)){		
			
			table15btn.setBackground(Color.BLUE);
			
		}
		else if(isInUse(15)){
			
			table15btn.setBackground(Color.RED);
		}
		else{
			
			table15btn.setBackground(UIManager.getColor("Button.background"));
		}
		
		JButton table14btn = new JButton("14");
		table14btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				reserveTable(14);
			}
		});
		table14btn.setBounds(374, 448, 53, 51);
		frmReserveMain.getContentPane().add(table14btn);
		if (isReserved(14)){		
			
			table14btn.setBackground(Color.BLUE);
			
		}
		else if(isInUse(14)){
			
			table14btn.setBackground(Color.RED);
		}
		else{
			
			table14btn.setBackground(UIManager.getColor("Button.background"));
		}
		
		JButton table13btn = new JButton("13");
		table13btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				reserveTable(13);
			}
		});
		table13btn.setBounds(375, 268, 53, 51);
		frmReserveMain.getContentPane().add(table13btn);
		if (isReserved(13)){		
			
			table13btn.setBackground(Color.BLUE);
			
		}
		else if(isInUse(13)){
			
			table13btn.setBackground(Color.RED);
		}
		else{
			
			table13btn.setBackground(UIManager.getColor("Button.background"));
		}
		
		JButton table12btn = new JButton("12");
		table12btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				reserveTable(12);
			}
		});
		table12btn.setBounds(370, 93, 52, 51);
		frmReserveMain.getContentPane().add(table12btn);
		if (isReserved(12)){		
			
			table12btn.setBackground(Color.BLUE);
			
		}
		else if(isInUse(12)){
			
			table12btn.setBackground(Color.RED);
		}
		else{
			
			table12btn.setBackground(UIManager.getColor("Button.background"));
		}
		
		JButton table11btn = new JButton("11");
		table11btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				reserveTable(11);
			}
		});
		table11btn.setBounds(285, 448, 53, 51);
		frmReserveMain.getContentPane().add(table11btn);
		if (isReserved(11)){		
			
			table11btn.setBackground(Color.BLUE);
			
		}
		else if(isInUse(11)){
			
			table11btn.setBackground(Color.RED);
		}
		else{
			
			table11btn.setBackground(UIManager.getColor("Button.background"));
		}
		
		JButton table10btn = new JButton("10");
		table10btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				reserveTable(10);
			}
		});
		table10btn.setBounds(285, 269, 53, 51);
		frmReserveMain.getContentPane().add(table10btn);
		if (isReserved(10)){		
			
			table10btn.setBackground(Color.BLUE);
			
		}
		else if(isInUse(10)){
			
			table10btn.setBackground(Color.RED);
		}
		else{
			
			table10btn.setBackground(UIManager.getColor("Button.background"));
		}
		
		JButton table9btn = new JButton("9");
		table9btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				reserveTable(9);
			}
		});
		table9btn.setBounds(290, 92, 48, 51);
		frmReserveMain.getContentPane().add(table9btn);
		if (isReserved(9)){		
			
			table9btn.setBackground(Color.BLUE);
			
		}
		else if(isInUse(9)){
			
			table9btn.setBackground(Color.RED);
		}
		else{
			
			table9btn.setBackground(UIManager.getColor("Button.background"));
		}
		
		JButton table8btn = new JButton("8");
		table8btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				reserveTable(8);
			}
		});
		table8btn.setBounds(210, 448, 48, 51);
		frmReserveMain.getContentPane().add(table8btn);
		if (isReserved(8)){		
			
			table8btn.setBackground(Color.BLUE);
			
		}
		else if(isInUse(8)){
			
			table8btn.setBackground(Color.RED);
		}
		else{
			
			table8btn.setBackground(UIManager.getColor("Button.background"));
		}
		
		JButton table7btn = new JButton("7");
		table7btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				reserveTable(7);
			}
		});
		table7btn.setBounds(210, 269, 48, 51);
		frmReserveMain.getContentPane().add(table7btn);
		if (isReserved(7)){		
			
			table7btn.setBackground(Color.BLUE);
			
		}
		else if(isInUse(7)){
			
			table7btn.setBackground(Color.RED);
		}
		else{
			
			table7btn.setBackground(UIManager.getColor("Button.background"));
		}
		
		JButton table6btn = new JButton("6");
		table6btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				reserveTable(6);
			}
		});
		table6btn.setBounds(210, 93, 48, 51);
		frmReserveMain.getContentPane().add(table6btn);
		if (isReserved(6)){		
			
			table6btn.setBackground(Color.BLUE);
			
		}
		else if(isInUse(6)){
			
			table6btn.setBackground(Color.RED);
		}
		else{
			
			table6btn.setBackground(UIManager.getColor("Button.background"));
		}
		
		JButton table5btn = new JButton("Table 5");
		table5btn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		table5btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				reserveTable(5);
			}
		});

		table5btn.setBounds(45, 466, 74, 84);
		frmReserveMain.getContentPane().add(table5btn);
		if (isReserved(5)){		
			
			table5btn.setBackground(Color.BLUE);
			
		}
		else if(isInUse(5)){
			
			table5btn.setBackground(Color.RED);
		}
		else{
			
			table5btn.setBackground(UIManager.getColor("Button.background"));
		}
		
		JButton table4btn = new JButton("Table 4");
		table4btn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		table4btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				reserveTable(4);
			}
		});
		
		table4btn.setBounds(48, 363, 70, 83);
		frmReserveMain.getContentPane().add(table4btn);
		if (isReserved(4)){		
			
			table4btn.setBackground(Color.BLUE);
			
		}
		else if(isInUse(4)){
			
			table4btn.setBackground(Color.RED);
		}
		else{
			
			table4btn.setBackground(UIManager.getColor("Button.background"));
		}
		
		JButton table3btn = new JButton("Table 3");
		table3btn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		table3btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
							
				reserveTable(3);
			}
		});
		
		table3btn.setBounds(48, 257, 70, 85);
		frmReserveMain.getContentPane().add(table3btn);
		if (isReserved(3)){		
			
			table3btn.setBackground(Color.BLUE);
			
		}
		else if(isInUse(3)){
			
			table3btn.setBackground(Color.RED);
		}
		else{
			
			table3btn.setBackground(UIManager.getColor("Button.background"));
		}
		
		JButton table2btn = new JButton("Table 2");
		table2btn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		table2btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				reserveTable(2);
			}
		});
		
		table2btn.setBounds(47, 153, 70, 84);
		frmReserveMain.getContentPane().add(table2btn);
		if (isReserved(2)){		
			
			table2btn.setBackground(Color.BLUE);
			
		}
		else if(isInUse(2)){
			
			table2btn.setBackground(Color.RED);
		}
		else{
			
			table2btn.setBackground(UIManager.getColor("Button.background"));
		}
		
		JButton table1btn = new JButton("Table 1");
		table1btn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		table1btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				reserveTable(1);
			}
		});
		
		table1btn.setBounds(49, 48, 70, 83);
		frmReserveMain.getContentPane().add(table1btn);
		if (isReserved(1)){		
			
			table1btn.setBackground(Color.BLUE);
			
		}
		else if(isInUse(1)){
			
			table1btn.setBackground(Color.RED);
		}
		else{
			
			table1btn.setBackground(UIManager.getColor("Button.background"));
		}
		
		JButton logoutbtn = new JButton("Logout");
		//If coming from the manager login display Back button
		if(Manager_Screen.managerLoggedIn ){
			
			logoutbtn.setText("Back");
		}
		
		logoutbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				exitServerScreen();
				
			}
		});
		logoutbtn.setFont(new Font("Dialog", Font.PLAIN, 20));
		logoutbtn.setBounds(328, 0, 135, 33);
		frmReserveMain.getContentPane().add(logoutbtn);
		
		JLabel lblNewLabel_1 = new JLabel(Login_Screen.EmployeeName);
		lblNewLabel_1.setBounds(582, 12, 135, 15);
		frmReserveMain.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Reservation_Screen.class.getResource("/Server_images/Server_main.png")));
		lblNewLabel.setBounds(0, 0, 800, 600);
		frmReserveMain.getContentPane().add(lblNewLabel);

	}
	
	private boolean isInUse(int i) {
		// Determine if the table is in use
		
		
		
		return false;
	}

	private boolean isReserved(int i) {
		// Determine if the table is reserved
		
		
		return false;
	}

	protected void reserveTable(int i) {
		//This function should check if the table is reserved or not
		//and allow the table to be reserved if it is not and throw an error
		//if it is.
		if(!isReserved(i)){
			
			
			
		}
		//Else throw an error
		else{
			
			
			
		}
		
		
		
		
	}		
		


	protected void exitServerScreen() {
		
		//If this is a manager then just go back to the manager screen
		if(Manager_Screen.managerLoggedIn){
			
			Manager_Screen.managerLoggedIn = false;
			frmReserveMain.dispose();
		}
		
		//If this is not a manager then go back to the login screen
		else{
		
			Login_Screen Login_GUI_Instance = new Login_Screen();
			Login_GUI_Instance.frmKds.setVisible(true);
			frmReserveMain.dispose();
					
		}
	}//End exit server screen
		
}
	