import java.awt.EventQueue;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import javax.swing.SwingConstants;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.Color;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Toolkit;


public class Login_Screen {

	JFrame frmKds;
	private JTextField Pin_Field;
	private JTextField ID_Field;
	public static String EmployeeName;
	public static int ID2;
	
	//Test logins for ...testing
	//int test_ID_1 = 1234;
	//int test_PIN_1 = 1234;
	//boolean One_Logged_in = true;
	
	
	//int test_ID_2 = 5678;
	//int test_PIN_2 = 5678;
	boolean Two_Logged_in = true;
	
	String commandText;
	ResultSet rs;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				if(Connection.Connect() == false) {
					JOptionPane.showMessageDialog(null, "Error connecting to the database.");					
				}
				else
					
				try {
					
					Login_Screen window = new Login_Screen();
					window.frmKds.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_Screen() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmKds = new JFrame();
		frmKds.setIconImage(Toolkit.getDefaultToolkit().getImage(Login_Screen.class.getResource("/General_images/GI_icon.png")));
		frmKds.getContentPane().setBackground(new Color(255, 255, 255));
		frmKds.getContentPane().setForeground(new Color(255, 255, 255));
		frmKds.setTitle("KDS_1.0");
		frmKds.setBounds(100, 100, 800, 600);
		frmKds.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmKds.getContentPane().setLayout(null);
		
		JLabel lblUserId = new JLabel("User ID:");
		lblUserId.setToolTipText("Your User ID goes here!");
		lblUserId.setVerticalAlignment(SwingConstants.TOP);
		lblUserId.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblUserId.setBounds(226, 120, 132, 62);
		frmKds.getContentPane().add(lblUserId);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setToolTipText("Your password or pin goes here!");
		lblPassword.setVerticalAlignment(SwingConstants.TOP);
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblPassword.setBounds(226, 173, 164, 36);
		frmKds.getContentPane().add(lblPassword);
		
		Pin_Field = new JPasswordField();
		Pin_Field.setBounds(397, 175, 193, 34);
		
		frmKds.getContentPane().add(Pin_Field);
		Pin_Field.setColumns(10);
		
		ID_Field = new JTextField();
		ID_Field.setColumns(10);
		ID_Field.setBounds(397, 120, 193, 34);
		frmKds.getContentPane().add(ID_Field);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setToolTipText("Click here to login!");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				check_login();
			}


		});
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		btnLogin.setBounds(304, 245, 225, 52);
		frmKds.getContentPane().add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("Dinner_image");
		lblNewLabel.setIcon(new ImageIcon(Login_Screen.class.getResource("/Login_Images/Diner_image.jpg")));
		lblNewLabel.setToolTipText("It's food!");
		lblNewLabel.setBounds(150, 35, 504, 68);		
		try
		{
			Image diner_banner = ImageIO.read(getClass().getResource("/Login_Images/Diner_image.jpg"));
			lblNewLabel.setIcon(new ImageIcon(diner_banner));
			
		}
		catch(IOException ex) {}
		frmKds.getContentPane().add(lblNewLabel);
		
		
		
	}
	
	
	//Check the login information from the pin_field and ID_Field against the database
	private void check_login() {
		
		// TODO Add error checking if the fields are blank
		int ID = Integer.valueOf(ID_Field.getText());
		ID2 = -1;
		int PIN = Integer.valueOf(Pin_Field.getText());
		int Pin2 = -1;
		int manager = -1;
		boolean clocked_in = false;
		
		commandText = "SELECT * from Employee WHERE ID = " + ID;
		
		try{
			//Execute command
			rs = SQL.ExecuteResultSet(commandText); 
		
			while (rs.next()) {
				Pin2 = rs.getInt("Password");	
				manager = rs.getInt("Manager");
				ID2 = rs.getInt("ID");
				EmployeeName = rs.getString("FirstName") +" " + rs.getString("LastName");
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		//Server instance check		
		//Does the ID match a server ID? 
		//then check the rest of the info
		if(ID == ID2){
			
			//Is this the correct PIN for that ID?
			if(PIN == Pin2){
				
				if (manager == 10)
				{
					//We don't check for logged-inness because managers can clock themselves in or they get salary or whatever
					//All checks passed launch the manager screen
					clearAllFields();
					Manager_Screen Manager_GUI_Instance = new Manager_Screen();
					Manager_GUI_Instance.frmManagerMain.setVisible(true);
					frmKds.dispose();					
					
				}				
				//ELse if owner
				else if(manager == 100){
					
					clearAllFields();
					Owner_Screen Owner_GUI_Instance = new Owner_Screen();
					Owner_GUI_Instance.frmOwnerMain.setVisible(true);
					frmKds.dispose();								
					
				}
				//else if cook
				else if(manager == 5){
				
					clearAllFields();
					Cook_Screen Cook_GUI_Instance = new Cook_Screen();
					Cook_GUI_Instance.frmCooksView.setVisible(true);
					frmKds.dispose();				
					
				}
				
				else
				{
					//I'm just going to reuse the rs and commandText
					//see if user is clocked in if rs.next() is false then user is not logged in
					commandText = "SELECT ID from EmployeeTime WHERE ID = " + ID2 + " and IsClockedIn = 1";
					rs = SQL.ExecuteResultSet(commandText);
					
					try {
						if(rs.next()){
							clocked_in = true;
						}
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					
					//Is the Server currently logged in? (note we may skip this check for managers)
					if(clocked_in){
											
						//All checks passed launch the server screen
						clearAllFields();
						//Server_Screen Server_GUI_Instance = new Server_Screen();
						//Server_GUI_Instance.frmServerMain.setVisible(true);
						Server_Screen.run();
						frmKds.dispose();
						}
					
					//Server was not logged in clear fields and display error message.
					else{
						
						clearAllFields();					
						JOptionPane.showMessageDialog(null, "User not logged in, see a manager to clock in.");
						}
					}
			}
			//The pin is incorrect clear fields and display error
			else{
				
				clearAllFields();					
				JOptionPane.showMessageDialog(null, "Incorrect Password used, try again.");
				
				}
			}	
		else
		{
			pinNotFound();
		}
		//End server check section
		
	
		
	}//end check_login() method
	
	
	//If the pin was not found at all clear fields and display message
	private void pinNotFound() {
		
	clearAllFields();					
	JOptionPane.showMessageDialog(null, "User ID not recognized, see a manager for help.");
	
	}

	//Method to clear the fields as needed
	private void clearAllFields() {
		
	Pin_Field.setText(null);
	ID_Field.setText(null);
		
	}
		

}//end Class Login Screen




