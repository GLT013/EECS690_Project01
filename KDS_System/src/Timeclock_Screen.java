import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Toolkit;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Timeclock_Screen {

	JFrame frmTimeclock;
	private JTextField ID_Field;
	private java.sql.Timestamp start;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				if(Connection.Connect() == false){
					JOptionPane.showMessageDialog(null, "ERROR connecting to Database");
				}
				else{
				try {
					Timeclock_Screen window = new Timeclock_Screen();
					window.frmTimeclock.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Timeclock_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTimeclock = new JFrame();
		frmTimeclock.getContentPane().setBackground(Color.WHITE);
		frmTimeclock.setIconImage(Toolkit.getDefaultToolkit().getImage(Timeclock_Screen.class.getResource("/General_images/GI_icon.png")));
		frmTimeclock.setTitle("Clock In /Out Screen");
		frmTimeclock.setBounds(100, 100, 800, 600);
		frmTimeclock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTimeclock.getContentPane().setLayout(null);
		
		JLabel lblPunchCard = new JLabel("Punch Card");
		lblPunchCard.setFont(new Font("Dialog", Font.BOLD, 50));
		lblPunchCard.setBounds(226, 11, 286, 60);
		frmTimeclock.getContentPane().add(lblPunchCard);
		
		JLabel lblId = new JLabel("ID#:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblId.setBounds(142, 241, 97, 44);
		frmTimeclock.getContentPane().add(lblId);
		
		ID_Field = new JTextField();
		ID_Field.setBounds(249, 241, 263, 44);
		frmTimeclock.getContentPane().add(ID_Field);
		ID_Field.setColumns(10);
		
		JButton btnPunchButton = new JButton("Add Punch");
		btnPunchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//Attempt to log in
				login();
				
			}
		});
		btnPunchButton.setFont(new Font("Dialog", Font.BOLD, 20));
		btnPunchButton.setBounds(290, 296, 174, 44);
		frmTimeclock.getContentPane().add(btnPunchButton);
		
		JButton btnManagerSwitch = new JButton("Back To Manager");
		btnManagerSwitch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ID_Field.setText(null);
				Manager_Screen Manager_GUI_Instance = new Manager_Screen();
				Manager_GUI_Instance.frmManagerMain.setVisible(true);
				frmTimeclock.dispose();	
			}
		});
		btnManagerSwitch.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnManagerSwitch.setBounds(249, 493, 263, 44);
		frmTimeclock.getContentPane().add(btnManagerSwitch);
		
		JButton btnLoginSwitch = new JButton("Switch To Login");
		btnLoginSwitch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ID_Field.setText(null);
				Login_Screen Login_GUI_Instance = new Login_Screen();
				Login_GUI_Instance.frmKds.setVisible(true);
				frmTimeclock.dispose();
			}
		});
		btnLoginSwitch.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnLoginSwitch.setBounds(522, 493, 252, 44);
		frmTimeclock.getContentPane().add(btnLoginSwitch);
	}
	
	private void login()
	{
		//check that both fields are filled
		if(!ID_Field.getText().isEmpty()){
			int ID = Integer.valueOf(ID_Field.getText());
			int ID2 = -1;
			ResultSet rs;
			
			//this will be used often in this.
			String CommandText = "SELECT * from Employee WHERE ID = " + ID;
			
			try{
				rs = SQL.ExecuteResultSet(CommandText);
				
				while (rs.next()) {
					ID2 = rs.getInt("ID");
					
					//I don't know if this needs to be here, but I'm reusing a lot of code from Login_Screen
					Login_Screen.EmployeeName = rs.getString("FirstName") + " " + rs.getString("LastName");
				}
			}
			catch (SQLException e){
				System.out.println(e.getMessage());
			}
			
			//Server instance check
			//Does the ID match a server ID?
			//then check the rest of the info
			if(ID == ID2){
				boolean logOut = false;
				CommandText = "SELECT ID from EmployeeTime WHERE ID = " + ID2 +
						" and IsClockedIn = 1";
				//if the search returns a result the user needs to logout
				try{
					rs = SQL.ExecuteResultSet(CommandText);
						
					if(rs.next()){
						logOut = true;
					}
				}
				catch (SQLException e){
					System.out.println(e.getMessage());
				}
					
				//If logOut has been set it will punchOut otherwise it'll punchin
				if(logOut){
					//I don't like not using the password, but "shiniest turd"
					addPunchout(ID2);
				}
				else{
					addPunchin(ID2);
				}
			}
			else{
				ID_Field.setText(null);
				JOptionPane.showMessageDialog(null, "User ID not recognized.");
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "The ID field is empty. Please try again.");
		}
	}
	
	private void addPunchout(int id){
		
		
		ResultSet rs;
		//set record to clocked out I'm not removing because I think that this is used for report
		java.util.Date currentTime = new java.util.Date();
		java.sql.Timestamp timestamp = new java.sql.Timestamp(currentTime.getTime());
		start = null;
		double tips = 0;
		float hours = 0;
		
		//Log user out for this shift
		String commandText = "UPDATE `EmployeeTime` SET "
				+ "`Clock Out`= '"+ timestamp + "',`IsClockedIn`= 0"
				+ " WHERE ID = " + id + " and IsClockedIn = 1";
		
		SQL.UpdateResultSet(commandText);
		
		try{
			//get hours worked and tips for this shift
			commandText = "SELECT * from `EmployeeTime` WHERE "
					+ "`ID` = "+ id + " and `Clock Out` >= '" + timestamp + "' - INTERVAL 5 SECOND";
			rs = SQL.ExecuteResultSet(commandText);
			
			while(rs.next()){
				start = rs.getTimestamp("Clock In");
				tips = rs.getDouble("Tips");
			}
			hours = compareTwoTimeStamps(timestamp, start);
		}
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
		
		//now collect current hours and tips for employee
		try{
			commandText = "SELECT WeeklyHour, TipTotal from Employee"
					+ " WHERE ID = " + id;
			rs = SQL.ExecuteResultSet(commandText);
			
			while(rs.next()){
				hours = hours + rs.getFloat("WeeklyHour");
				tips = tips + rs.getFloat("TipTotal");
			}
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
		
		//Finally Update values
		commandText = "UPDATE `Employee` SET `WeeklyHour` = "
				+ hours + ", TipTotal = " + tips + " WHERE ID = "
				+ id;
		SQL.UpdateResultSet(commandText);

		//Clear fields and show message say you have successfully logged out
		ID_Field.setText(null);
		JOptionPane.showMessageDialog(null, "You have have successfully logged out.");
	}
	
	private void addPunchin(int id){
		ResultSet rs;
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
		
		if ((30 > hours) && (hours >= 28) && (!isFullTime)){
			JOptionPane.showMessageDialog(null, "Warning! Part-time employee, " + curEmp + ", is currently over 28 hours.");
		}
		
		if ((hours >= 30) && (!isFullTime)){
			JOptionPane.showMessageDialog(null, "Warning! Warning! Part-Time Employee, " + curEmp + ", Is Currently Overtime.");
		}
		
		//Clock Out is a place holder here
		commandText = "INSERT INTO `EmployeeTime`(`ID`, `Tips`, `Clock Out`, `IsClockedIn`) VALUES ("+id+", 0, 0,1)";
		SQL.UpdateResultSet(commandText);
		
		ID_Field.setText(null);
		JOptionPane.showMessageDialog(null, "You have been successfully logged in.");
	}
	
	//Got this from stack overflow I am making it public so you can use timestamps to when checking hourly
	public static float compareTwoTimeStamps(java.sql.Timestamp currentTime, java.sql.Timestamp oldTime)
	{
	  float milliseconds1 = oldTime.getTime();
	  float milliseconds2 = currentTime.getTime();

	  float diff = milliseconds2 - milliseconds1;
	  float diffHours = diff / (60 * 60 * 1000);

	    return diffHours;
	}
}