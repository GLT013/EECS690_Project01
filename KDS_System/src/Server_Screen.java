import javax.swing.JFrame;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Font;
import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;


public class Server_Screen {

	JFrame frmServerMain;
	public Object frame;
	public static int tableID = 0;

	/**
	 * Launch the application.
	 */

			public static void run() {
				try {
					Server_Screen window = new Server_Screen();
					window.frmServerMain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		

	/**
	 * Create the application.
	 */
	public Server_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmServerMain = new JFrame();
		frmServerMain.setTitle("Server Main");
		frmServerMain.setIconImage(Toolkit.getDefaultToolkit().getImage(Server_Screen.class.getResource("/General_images/GI_icon.png")));
		frmServerMain.setBounds(100, 100, 800, 600);
		frmServerMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmServerMain.getContentPane().setLayout(null);
		
		JButton table25btn = new JButton("Table 25");
		table25btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableID = 25;
				checkIfTableExsists();
			}
		});
		table25btn.setHorizontalAlignment(SwingConstants.LEFT);
		table25btn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		table25btn.setBackground(UIManager.getColor("Button.background"));
		table25btn.setBounds(665, 464, 74, 87);
		frmServerMain.getContentPane().add(table25btn);
		
		JButton table24btn = new JButton("Table 24");
		table24btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableID = 24;
				checkIfTableExsists();
			}
		});
		table24btn.setHorizontalAlignment(SwingConstants.LEFT);
		table24btn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		table24btn.setBackground(UIManager.getColor("Button.background"));
		table24btn.setBounds(664, 360, 75, 87);
		frmServerMain.getContentPane().add(table24btn);
		
		JButton table23btn = new JButton("Table 23");
		table23btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableID = 23;
				checkIfTableExsists();
			}
		});
		table23btn.setHorizontalAlignment(SwingConstants.LEFT);
		table23btn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		table23btn.setBackground(UIManager.getColor("Button.background"));
		table23btn.setBounds(663, 251, 74, 87);
		frmServerMain.getContentPane().add(table23btn);
		
		JButton table22btn = new JButton("Table 22");
		table22btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableID = 22;
				checkIfTableExsists();
			}
		});
		table22btn.setHorizontalAlignment(SwingConstants.LEFT);
		table22btn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		table22btn.setBackground(UIManager.getColor("Button.background"));
		table22btn.setBounds(663, 148, 75, 83);
		frmServerMain.getContentPane().add(table22btn);
		
		JButton table21btn = new JButton("Table 21");
		table21btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableID = 21;
				checkIfTableExsists();
			}
		});
		table21btn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		table21btn.setHorizontalAlignment(SwingConstants.LEFT);
		table21btn.setBackground(UIManager.getColor("Button.background"));
		table21btn.setBounds(663, 52, 75, 83);
		frmServerMain.getContentPane().add(table21btn);
		
		JButton table20btn = new JButton("20");
		table20btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableID = 20;
				checkIfTableExsists();
			}
		});
		table20btn.setBounds(540, 448, 53, 51);
		frmServerMain.getContentPane().add(table20btn);
		
		JButton table19btn = new JButton("19");
		table19btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableID = 19;
				checkIfTableExsists();
			}
		});
		table19btn.setBounds(540, 268, 53, 51);
		frmServerMain.getContentPane().add(table19btn);
		
		JButton table18btn = new JButton("18");
		table18btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableID = 18;
				checkIfTableExsists();
			}
		});
		table18btn.setBounds(540, 93, 53, 51);
		frmServerMain.getContentPane().add(table18btn);
		
		JButton table17btn = new JButton("17");
		table17btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableID = 17; 
				checkIfTableExsists();
			}
		});
		table17btn.setBounds(457, 448, 53, 51);
		frmServerMain.getContentPane().add(table17btn);
		
		JButton table16btn = new JButton("16");
		table16btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableID = 16;
				checkIfTableExsists();
			}
		});
		table16btn.setBounds(457, 268, 53, 51);
		frmServerMain.getContentPane().add(table16btn);
		
		JButton table15btn = new JButton("15");
		table15btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableID = 15;
				checkIfTableExsists();
			}
		});
		table15btn.setBounds(457, 93, 53, 51);
		frmServerMain.getContentPane().add(table15btn);
		
		JButton table14btn = new JButton("14");
		table14btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableID = 14;
				checkIfTableExsists();
			}
		});
		table14btn.setBounds(374, 448, 53, 51);
		frmServerMain.getContentPane().add(table14btn);
		
		JButton table13btn = new JButton("13");
		table13btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableID = 13;
				checkIfTableExsists();
			}
		});
		table13btn.setBounds(375, 268, 53, 51);
		frmServerMain.getContentPane().add(table13btn);
		
		JButton table12btn = new JButton("12");
		table12btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableID = 12;
				checkIfTableExsists();
			}
		});
		table12btn.setBounds(370, 93, 52, 51);
		frmServerMain.getContentPane().add(table12btn);
		
		JButton table11btn = new JButton("11");
		table11btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableID = 11;
				checkIfTableExsists();
			}
		});
		table11btn.setBounds(285, 448, 53, 51);
		frmServerMain.getContentPane().add(table11btn);
		
		JButton table10btn = new JButton("10");
		table10btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableID = 10;
				checkIfTableExsists();
			}
		});
		table10btn.setBounds(285, 269, 53, 51);
		frmServerMain.getContentPane().add(table10btn);
		
		JButton table9btn = new JButton("9");
		table9btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableID = 9;
				checkIfTableExsists();
			}
		});
		table9btn.setBounds(290, 92, 48, 51);
		frmServerMain.getContentPane().add(table9btn);
		
		JButton table8btn = new JButton("8");
		table8btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableID = 8;
				checkIfTableExsists();
			}
		});
		table8btn.setBounds(210, 448, 48, 51);
		frmServerMain.getContentPane().add(table8btn);
		
		JButton table7btn = new JButton("7");
		table7btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableID = 7;
				checkIfTableExsists();
			}
		});
		table7btn.setBounds(210, 269, 48, 51);
		frmServerMain.getContentPane().add(table7btn);
		
		JButton table6btn = new JButton("6");
		table6btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableID = 6;
				checkIfTableExsists();
			}
		});
		table6btn.setBounds(210, 93, 48, 51);
		frmServerMain.getContentPane().add(table6btn);
		
		JButton table5btn = new JButton("Table 5");
		table5btn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		table5btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableID = 5;
				checkIfTableExsists();
			}
		});
		table5btn.setBackground(UIManager.getColor("Button.background"));
		table5btn.setBounds(45, 466, 74, 84);
		frmServerMain.getContentPane().add(table5btn);
		
		JButton table4btn = new JButton("Table 4");
		table4btn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		table4btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableID = 4;
				checkIfTableExsists();
			}
		});
		table4btn.setBackground(UIManager.getColor("Button.background"));
		table4btn.setBounds(48, 363, 70, 83);
		frmServerMain.getContentPane().add(table4btn);
		
		JButton table3btn = new JButton("Table 3");
		table3btn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		table3btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableID = 3; 
				checkIfTableExsists();
			}
		});
		table3btn.setBackground(UIManager.getColor("Button.background"));
		table3btn.setBounds(48, 257, 70, 85);
		frmServerMain.getContentPane().add(table3btn);
		
		JButton table2btn = new JButton("Table 2");
		table2btn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		table2btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableID = 2;
				checkIfTableExsists();
			}
		});
		table2btn.setBackground(UIManager.getColor("Button.background"));
		table2btn.setBounds(47, 153, 70, 84);
		frmServerMain.getContentPane().add(table2btn);
		
		JButton table1btn = new JButton("Table 1");
		table1btn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		table1btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableID = 1;
				checkIfTableExsists();
			}
		});
		table1btn.setBackground(UIManager.getColor("Button.background"));
		table1btn.setBounds(49, 48, 70, 83);
		frmServerMain.getContentPane().add(table1btn);
		
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
		frmServerMain.getContentPane().add(logoutbtn);
		
		JLabel lblNewLabel_1 = new JLabel(Login_Screen.EmployeeName);
		lblNewLabel_1.setBounds(582, 12, 135, 15);
		frmServerMain.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Server_Screen.class.getResource("/Server_images/Server_main.png")));
		lblNewLabel.setBounds(0, 0, 800, 600);
		frmServerMain.getContentPane().add(lblNewLabel);

	}
	
	protected void exitServerScreen() {
		
		//If this is a manager then just go back to the manager screen
		if(Manager_Screen.managerLoggedIn){
			
			Manager_Screen.managerLoggedIn = false;
			frmServerMain.dispose();
		}
		
		//If this is not a manager then go back to the login screen
		else{
		
			Login_Screen Login_GUI_Instance = new Login_Screen();
			Login_GUI_Instance.frmKds.setVisible(true);
			frmServerMain.dispose();
					
		}
	}//End exit server screen
		


	//This method will check to see if the table already exists locally and either create it or
	//pull it's data as needed
	public void checkIfTableExsists() {
		//Table_Edit_Screen Table_GUI_Instance = new Table_Edit_Screen();
		//Table_GUI_Instance.frmTableEdit.setVisible(true);
		Table_Edit_Screen.run();
		frmServerMain.dispose();
	}
		
		
}