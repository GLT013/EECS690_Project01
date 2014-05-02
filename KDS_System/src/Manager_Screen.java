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
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextPane;
import javax.swing.JList;


public class Manager_Screen {

	
	JFrame frmManagerMain;
	public static Boolean managerLoggedIn = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager_Screen window = new Manager_Screen();
					window.frmManagerMain.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Manager_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmManagerMain = new JFrame();
		frmManagerMain.getContentPane().setBackground(Color.WHITE);
		frmManagerMain.setTitle("Manager Main");
		frmManagerMain.setIconImage(Toolkit.getDefaultToolkit().getImage(Manager_Screen.class.getResource("/General_images/GI_icon.png")));
		frmManagerMain.setBounds(100, 100, 800, 600);
		frmManagerMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmManagerMain.getContentPane().setLayout(null);
		
		JButton logoutbtn = new JButton("Logout");
		logoutbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				exitManagerScreen();
			}
		});
		logoutbtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		logoutbtn.setBounds(323, 11, 135, 33);
		frmManagerMain.getContentPane().add(logoutbtn);
		
		JLabel lblNewLabel = new JLabel(Login_Screen.EmployeeName);
		lblNewLabel.setBounds(643, 22, 70, 15);
		frmManagerMain.getContentPane().add(lblNewLabel);
		
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
		frmManagerMain.getContentPane().add(btnNewButton);
		
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
		frmManagerMain.getContentPane().add(btnEodReport);
		
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
		frmManagerMain.getContentPane().add(btnEmplyeeManagement);
		
		JButton btnClockIn = new JButton("Clock In / Out");
		btnClockIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//Open timeclock screen
				Timeclock_Screen Timeclock_GUI_Instance = new Timeclock_Screen();
				Timeclock_GUI_Instance.frmTimeclock.setVisible(true);
				
				
			}
		});
		btnClockIn.setFont(new Font("Dialog", Font.BOLD, 20));
		btnClockIn.setBounds(43, 55, 205, 113);
		frmManagerMain.getContentPane().add(btnClockIn);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(Color.LIGHT_GRAY);
		textPane.setBounds(563, 73, 188, 262);
		frmManagerMain.getContentPane().add(textPane);
		
		JList list = new JList();
		list.setBounds(563, 74, 188, 261);
		frmManagerMain.getContentPane().add(list);
		/*ResultSet rs;
		String commandText = " ";
		float hours = 0;
		String curEmp = " ";
		boolean isFullTime = true;
		
		try{
			commandText = "SELECT WorkStatus, WeeklyHour, FirstName, LastName from Employee"
					+ " WHERE ID = " + id;
			rs = SQL.ExecuteResultSet(commandText);
			
			while(rs.next()){
				hours = rs.getFloat("WeeklyHour");
				curEmp = rs.getNString("FirstName") + " " + rs.getNString("LastName");
				isFullTime = rs.getBoolean("WorkStatus");
			}
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
		*/
		//for each in talamb.employeetime
			//if isclockedin
				//check ID with workstatus in talamb.employee
				//if !workstatus
					//curHours =  current time - clock in time
					// if curHours + talamb.employee.weeklyhour > 28
						//Employee name appended to list
		
		
		JLabel lblNewLabel_1 = new JLabel("Alerts:");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(570, 28, 90, 33);
		frmManagerMain.getContentPane().add(lblNewLabel_1);
		
		JButton btnCashoutParty = new JButton("Cashout Party");
		btnCashoutParty.setFont(new Font("Dialog", Font.BOLD, 20));
		btnCashoutParty.setBounds(297, 277, 205, 113);
		frmManagerMain.getContentPane().add(btnCashoutParty);
		
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
		frmManagerMain.getContentPane().add(btnReserveTables);
		
		JButton btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Add_Employee_Screen Add_Employee_GUI_Instance = new Add_Employee_Screen();
				Add_Employee_GUI_Instance.frmAddEmployee.setVisible(true);
				frmManagerMain.dispose();
			}
		});
		btnAddEmployee.setFont(new Font("Dialog", Font.BOLD, 20));
		btnAddEmployee.setBounds(43, 276, 205, 114);
		frmManagerMain.getContentPane().add(btnAddEmployee);
	}
	
	//This method will restart the loging screen and destory this instance of the manager screen
	private void exitManagerScreen() {
		
		
		Login_Screen Login_GUI_Instance = new Login_Screen();
		Login_GUI_Instance.frmKds.setVisible(true);
		frmManagerMain.dispose();
		
		
	}
}
