import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Add_Employee_Screen {

	JFrame frmAddEmployee;
	private JTextField FirstNameText;
	private JTextField LastNameText;
	private JTextField ID_Text;
	private JPasswordField PasswordText;
	private final ButtonGroup FullTimeGroup = new ButtonGroup();
	private final ButtonGroup ManagerGroup = new ButtonGroup();
	private JPasswordField ConfPassText;

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
						Add_Employee_Screen window = new Add_Employee_Screen();
						window.frmAddEmployee.setVisible(true);
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
	public Add_Employee_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddEmployee = new JFrame();
		frmAddEmployee.getContentPane().setBackground(Color.WHITE);
		frmAddEmployee.setTitle("Add Employee");
		frmAddEmployee.setIconImage(Toolkit.getDefaultToolkit().getImage(Manager_Screen.class.getResource("/General_images/GI_icon.png")));
		frmAddEmployee.setBounds(100, 100, 800, 600);
		frmAddEmployee.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddEmployee.getContentPane().setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Dialog", Font.BOLD, 20));
		lblFirstName.setBounds(36, 35, 115, 25);
		frmAddEmployee.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Dialog", Font.BOLD, 20));
		lblLastName.setBounds(36, 115, 115, 25);
		frmAddEmployee.getContentPane().add(lblLastName);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblId.setBounds(111, 189, 40, 25);
		frmAddEmployee.getContentPane().add(lblId);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 20));
		lblPassword.setBounds(46, 263, 105, 25);
		frmAddEmployee.getContentPane().add(lblPassword);
		
		JLabel lblFullTime = new JLabel("Full Time?:");
		lblFullTime.setFont(new Font("Dialog", Font.BOLD, 20));
		lblFullTime.setBounds(46, 368, 105, 25);
		frmAddEmployee.getContentPane().add(lblFullTime);
		
		JLabel lblManager = new JLabel("Type");
		lblManager.setFont(new Font("Dialog", Font.BOLD, 20));
		lblManager.setBounds(29, 453, 65, 25);
		frmAddEmployee.getContentPane().add(lblManager);
		
		FirstNameText = new JTextField();
		FirstNameText.setBounds(161, 36, 397, 25);
		frmAddEmployee.getContentPane().add(FirstNameText);
		FirstNameText.setColumns(10);
		
		LastNameText = new JTextField();
		LastNameText.setBounds(161, 116, 397, 25);
		frmAddEmployee.getContentPane().add(LastNameText);
		LastNameText.setColumns(10);
		
		ID_Text = new JTextField();
		ID_Text.setBounds(161, 190, 86, 25);
		frmAddEmployee.getContentPane().add(ID_Text);
		ID_Text.setColumns(10);
		
		PasswordText = new JPasswordField();
		PasswordText.setBounds(161, 264, 86, 25);
		frmAddEmployee.getContentPane().add(PasswordText);
		PasswordText.setColumns(10);
		
		ConfPassText = new JPasswordField();
		ConfPassText.setBounds(161, 320, 86, 23);
		frmAddEmployee.getContentPane().add(ConfPassText);
		
		JRadioButton rdbtnNotFull = new JRadioButton("No");
		rdbtnNotFull.setSelected(true);
		rdbtnNotFull.setFont(new Font("Dialog", Font.BOLD, 20));
		FullTimeGroup.add(rdbtnNotFull);
		rdbtnNotFull.setBackground(Color.WHITE);
		rdbtnNotFull.setBounds(161, 366, 65, 28);
		frmAddEmployee.getContentPane().add(rdbtnNotFull);
		
		final JRadioButton rdbtnFull = new JRadioButton("Yes");
		FullTimeGroup.add(rdbtnFull);
		rdbtnFull.setBackground(Color.WHITE);
		rdbtnFull.setFont(new Font("Dialog", Font.BOLD, 20));
		rdbtnFull.setBounds(228, 369, 100, 23);
		frmAddEmployee.getContentPane().add(rdbtnFull);
		
		JRadioButton rdbtnNotManager = new JRadioButton("Server");
		ManagerGroup.add(rdbtnNotManager);
		rdbtnNotManager.setSelected(true);
		rdbtnNotManager.setFont(new Font("Dialog", Font.BOLD, 20));
		rdbtnNotManager.setBackground(Color.WHITE);
		rdbtnNotManager.setBounds(111, 451, 100, 28);
		frmAddEmployee.getContentPane().add(rdbtnNotManager);
		
		final JRadioButton rdbtnManager = new JRadioButton("Manager");
		ManagerGroup.add(rdbtnManager);
		rdbtnManager.setBackground(Color.WHITE);
		rdbtnManager.setFont(new Font("Dialog", Font.BOLD, 20));
		rdbtnManager.setBounds(111, 486, 115, 23);
		frmAddEmployee.getContentPane().add(rdbtnManager);
		
		final JRadioButton rdbtnOwner = new JRadioButton("Owner");
		ManagerGroup.add(rdbtnOwner);
		rdbtnOwner.setFont(new Font("Dialog", Font.BOLD, 20));
		rdbtnOwner.setBackground(Color.WHITE);
		rdbtnOwner.setBounds(245, 486, 92, 23);
		frmAddEmployee.getContentPane().add(rdbtnOwner);
		
		final JRadioButton rdbtnCook = new JRadioButton("Cook");
		ManagerGroup.add(rdbtnCook);
		rdbtnCook.setFont(new Font("Dialog", Font.BOLD, 20));
		rdbtnCook.setBackground(Color.WHITE);
		rdbtnCook.setBounds(245, 454, 75, 23);
		frmAddEmployee.getContentPane().add(rdbtnCook);
		
		JButton btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				//check if the Fields are filled
				if(checkFieldsFilled()){
					
					//confirm that the new ID is a unique one.
					int ID = Integer.valueOf(ID_Text.getText());
					if(confirmUniqueId(ID)){
						
						//Make sure password and confirm password match
						if(PasswordText.getText().equals(ConfPassText.getText())){
							
							String FirstName = FirstNameText.getText();
							String LastName = LastNameText.getText();
							int password = Integer.valueOf(PasswordText.getText());
							
							int fullTime = fullTimeBTNCheck();
							int manager = managerBTNCheck();
							String commandText = "INSERT INTO `Employee`(`ID`, `FirstName`, `LastName`, `WorkStatus`,"
									+ " `Manager`, `Password`, `WeeklyHour`, `TipTotal`)"
									+ " VALUES (" + ID + ", '"+ FirstName +"', '"+ LastName + "', "
									+ fullTime + ", " + manager + ", " + password + ", 0, 0)";
							SQL.UpdateResultSet(commandText);
							
							FirstNameText.setText(null);
							LastNameText.setText(null);
							ID_Text.setText(null);
							PasswordText.setText(null);
							ConfPassText.setText(null);
						}
						else{
							PasswordText.setText(null);
							ConfPassText.setText(null);
							JOptionPane.showMessageDialog(null, "Passwords do not match. Please try again.");
						}
						
					}
					else {
						ID_Text.setText(null);
						JOptionPane.showMessageDialog(null, "The ID is already used");
					}
				}
			}

			private int fullTimeBTNCheck() {
				if(rdbtnFull.isSelected()){
					return 1;
				}
				else{
					return 0;
				}
			}

			private int managerBTNCheck() {
				if(rdbtnOwner.isSelected()){
					return 100;
				}				
				else if(rdbtnManager.isSelected()){
					return 10;
				}
				else if (rdbtnCook.isSelected())
				{
					return 5;
				}
				else{
					return 0;
				}
			}
			
			private boolean confirmUniqueId(int id){
				String CommandText = "SELECT * from `Employee` WHERE ID ="+ id;
				ResultSet res_set = null; 
				
				
				try {
					res_set = SQL.ExecuteResultSet(CommandText); ;
					if(res_set.next()){
						return false;
					}
					else{
						return true;
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
					return false;
				}
			}
		});
		btnAddEmployee.setFont(new Font("Dialog", Font.BOLD, 20));
		btnAddEmployee.setBounds(520, 489, 227, 43);
		frmAddEmployee.getContentPane().add(btnAddEmployee);
		
		JLabel lblConfirmnPassword = new JLabel("Confirm \n Password:");
		lblConfirmnPassword.setFont(new Font("Dialog", Font.BOLD, 15));
		lblConfirmnPassword.setBounds(10, 310, 141, 39);
		frmAddEmployee.getContentPane().add(lblConfirmnPassword);
		
		JButton btnManagerMenu = new JButton("Back to Manager Menu");
		btnManagerMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ID_Text.setText(null);
				PasswordText.setText(null);
				ConfPassText.setText(null);
				FirstNameText.setText(null);
				LastNameText.setText(null);
				Manager_Screen Manager_GUI_Instance = new Manager_Screen();
				Manager_GUI_Instance.frmManagerMain.setVisible(true);
				frmAddEmployee.dispose();	
			}
		});
		btnManagerMenu.setFont(new Font("Dialog", Font.BOLD, 17));
		btnManagerMenu.setBounds(520, 431, 227, 43);
		frmAddEmployee.getContentPane().add(btnManagerMenu);
		
	
	}
	
	@SuppressWarnings("deprecation")
	private boolean checkFieldsFilled(){
		if(ID_Text.getText().isEmpty() || PasswordText.getText().isEmpty() || FirstNameText.getText().isEmpty() || LastNameText.getText().isEmpty() || ConfPassText.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "At least one field is empty.");
			return false;
		}
		else{
			return true;
		}
	}
}
