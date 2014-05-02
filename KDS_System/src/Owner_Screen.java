import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Toolkit;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;

import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Owner_Screen {

	
	JFrame frmOwnerMain;
	public static Boolean managerLoggedIn = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Owner_Screen window = new Owner_Screen();
					window.frmOwnerMain.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Owner_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOwnerMain = new JFrame();
		frmOwnerMain.getContentPane().setBackground(Color.WHITE);
		frmOwnerMain.setTitle("Owner Main");
		frmOwnerMain.setIconImage(Toolkit.getDefaultToolkit().getImage(Owner_Screen.class.getResource("/General_images/GI_icon.png")));
		frmOwnerMain.setBounds(100, 100, 800, 600);
		frmOwnerMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOwnerMain.getContentPane().setLayout(null);
		
		JButton logoutbtn = new JButton("Logout");
		logoutbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				exitManagerScreen();
			}
		});
		logoutbtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		logoutbtn.setBounds(323, 11, 135, 33);
		frmOwnerMain.getContentPane().add(logoutbtn);
		
		JLabel lblNewLabel = new JLabel(Login_Screen.EmployeeName);
		lblNewLabel.setBounds(643, 22, 70, 15);
		frmOwnerMain.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Tables");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//Takes us to the tables view but doesn't dispose of the manager screen
				managerLoggedIn = true;
				Server_Screen Server_GUI_Instance = new Server_Screen();
				Server_GUI_Instance.frmServerMain.setVisible(true);					
				
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 20));
		btnNewButton.setBounds(552, 415, 205, 113);
		frmOwnerMain.getContentPane().add(btnNewButton);
		
		JButton btnEodReport = new JButton("EOD Report");
		btnEodReport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//Go to the EOD report section
				EOD_Screen EOD_GUI_Instance = new EOD_Screen();
				EOD_GUI_Instance.frmEodReport.setVisible(true);
				
			}
		});
		btnEodReport.setFont(new Font("Dialog", Font.BOLD, 20));
		btnEodReport.setBounds(297, 415, 205, 113);
		frmOwnerMain.getContentPane().add(btnEodReport);
		
		JButton btnEmplyeeManagement = new JButton();
		btnEmplyeeManagement.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//Open Employee management screen
				Employee_Screen Employee_GUI_Instance = new Employee_Screen();
				Employee_GUI_Instance.frmEmployeeScreen.setVisible(true);
				
			}
		});
		btnEmplyeeManagement.setText("<html><center>"+"Employee"+"<br>"+"Management"+"</center></html>");
		btnEmplyeeManagement.setFont(new Font("Dialog", Font.BOLD, 20));
		btnEmplyeeManagement.setBounds(43, 415, 205, 113);
		frmOwnerMain.getContentPane().add(btnEmplyeeManagement);
		
		JButton btnClockIn = new JButton("Clock In / Out");
		btnClockIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnClockIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//Open timeclock screen
				Timeclock_Screen Timeclock_GUI_Instance = new Timeclock_Screen();
				Timeclock_GUI_Instance.frmTimeclock.setVisible(true);
				
				
			}
		});
		btnClockIn.setFont(new Font("Dialog", Font.BOLD, 20));
		btnClockIn.setBounds(43, 43, 205, 113);
		frmOwnerMain.getContentPane().add(btnClockIn);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(Color.LIGHT_GRAY);
		textPane.setBounds(563, 73, 188, 262);
		frmOwnerMain.getContentPane().add(textPane);
		
		JLabel lblNewLabel_1 = new JLabel("Alerts:");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(570, 28, 90, 33);
		frmOwnerMain.getContentPane().add(lblNewLabel_1);
		
		JButton btnCashoutParty = new JButton("Cashout Party");
		btnCashoutParty.setFont(new Font("Dialog", Font.BOLD, 20));
		btnCashoutParty.setBounds(297, 277, 205, 113);
		frmOwnerMain.getContentPane().add(btnCashoutParty);
		
		JButton btnReserveTables = new JButton("Reserve Tables");
		btnReserveTables.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				managerLoggedIn = true;
				Reservation_Screen Reservation_GUI_Instance = new Reservation_Screen();
				Reservation_GUI_Instance.frmReserveMain.setVisible(true);
				
			}
		});
		btnReserveTables.setFont(new Font("Dialog", Font.BOLD, 20));
		btnReserveTables.setBounds(297, 138, 205, 113);
		frmOwnerMain.getContentPane().add(btnReserveTables);
		
		JButton btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Add_Employee_Screen Add_Employee_GUI_Instance = new Add_Employee_Screen();
				Add_Employee_GUI_Instance.frmAddEmployee.setVisible(true);
				frmOwnerMain.dispose();
			}
		});
		btnAddEmployee.setFont(new Font("Dialog", Font.BOLD, 20));
		btnAddEmployee.setBounds(43, 290, 205, 114);
		frmOwnerMain.getContentPane().add(btnAddEmployee);
		
		JButton btnEditMenu = new JButton();
		btnEditMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Edit_Menu_Tax_Screen Edit_Menu_Tax_Screen_Instance = new Edit_Menu_Tax_Screen();
				Edit_Menu_Tax_Screen_Instance.frmEditMenu.setVisible(true);
				frmOwnerMain.dispose();
			}
		});
		btnEditMenu.setText("<html><center>"+"Edit Menu / "+"<br>"+"Tax Rate"+"</center></html>");
		btnEditMenu.setFont(new Font("Dialog", Font.BOLD, 20));
		btnEditMenu.setBounds(43, 167, 205, 114);
		frmOwnerMain.getContentPane().add(btnEditMenu);
	}
	
	//This method will restart the loging screen and destory this instance of the manager screen
	private void exitManagerScreen() {
		
		
		Login_Screen Login_GUI_Instance = new Login_Screen();
		Login_GUI_Instance.frmKds.setVisible(true);
		frmOwnerMain.dispose();
		
		
	}
}
