import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Toolkit;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JEditorPane;


public class EOD_Screen {

	JFrame frmEodReport;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EOD_Screen window = new EOD_Screen();
					window.frmEodReport.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EOD_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEodReport = new JFrame();
		frmEodReport.getContentPane().setBackground(Color.WHITE);
		frmEodReport.setIconImage(Toolkit.getDefaultToolkit().getImage(EOD_Screen.class.getResource("/General_images/GI_icon.png")));
		frmEodReport.setTitle("EOD Report");
		frmEodReport.setBounds(100, 100, 800, 600);
		frmEodReport.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEodReport.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Back To Manager");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//return to the manager screen
				frmEodReport.dispose();
				
			}
		});
		
		JScrollPane scrollReport = new JScrollPane();
		scrollReport.setBounds(10, 11, 764, 485);
		frmEodReport.getContentPane().add(scrollReport);
		
		final JEditorPane ReportEditor = new JEditorPane();
		ReportEditor.setEditable(false);
		scrollReport.setViewportView(ReportEditor);
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 20));
		btnNewButton.setBounds(10, 507, 250, 44);
		frmEodReport.getContentPane().add(btnNewButton);
		
		JButton btnRunReport = new JButton("Report Last 20 Hours");
		btnRunReport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//I don't want to create spaghetti code, but I don't have
				//the time or patients right now to make this look pretty.
				
				//Write the table as an HTML table JEditorPane can interpret the code.
				
				String Report = "<html><head><style>"
								+ "table,th,td {border:2px solid black;"+
								"border-collapse:collapse;}th,td{padding:1px;}"
								+"</style></head><body><table style=\"width:300px\">"
								+"<tr>"+
								"<th>ID</th>"
								+"<th>Last, First</th>"		
								+"<th>Tips</th>"
								+"<th>Hours</th>"
								+"<th>Clock In</th>"
								+"<th>Clock Out</th>"
								+"</tr>";

				String EmployeeTime_cmd = "SELECT * FROM `EmployeeTime`,"
						+ " `Employee` WHERE `EmployeeTime`.`ID` = `Employee`.`ID` and "
						+ "`EmployeeTime`.`Clock In` >= NOW() - INTERVAL 20 HOUR ORDER BY"
						+ "`EmployeeTime`.`ID` ASC";
				String Name = "";
				ResultSet rs1 = SQL.ExecuteResultSet(EmployeeTime_cmd);
				int id;
				int tips;
				int clockedIn;
				java.sql.Timestamp start;
				java.sql.Timestamp finish;
				double hours;
				
				try {
					//Go though the EmployeeTime Table and concat the HTML to the report
					while(rs1.next()){
						id = rs1.getInt("Employee.ID");
						tips = rs1.getInt("EmployeeTime.Tips");
						clockedIn = rs1.getInt("EmployeeTime.IsClockedIn");
						start = rs1.getTimestamp("EmployeeTime.Clock In");
						finish = rs1.getTimestamp("EmployeeTime.Clock Out");
						hours = -1;
						
						//If the user is clocked in it will be treated different
						if(clockedIn != 1){
							hours = compareTwoTimeStamps(finish, start);
						}
						
						Name = rs1.getString("Employee.LastName");
						Name.concat(", ");
						Name.concat(rs1.getString("Employee.FirstName"));
						
						//now concatenate the information to the HTML
						Report = Report.concat("<tr>");
						Report = Report.concat("<td>"+ Integer.toString(id) +"</td>");
						Report = Report.concat("<td>"+Name+"</td>");
						Report = Report.concat("<td>"+Double.toString(tips)+"</td>");
						
						//if user is clocked in it won't report the out or hours yet.
						if(hours == -1){
							Report = Report.concat("<td> N/A </td>");
							Report = Report.concat("<td>" + start.toString() + "</td>");
							Report = Report.concat("<td> N/A </td>");
						}
						else{
							Report = Report.concat("<td>" + Double.toString(hours) + "</td>");
							Report = Report.concat("<td>" + start.toString() + "</td>");
							Report = Report.concat("<td>" + finish.toString() + "</td>");
						}
						Report = Report.concat("</tr>");
						
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				
				
				//append the end tags to report and then turn the ReportEditor into an HTML interpeter.
				Report = Report.concat("</table></body></html>");
				ReportEditor.setText(null);
				ReportEditor.setContentType("text/html");
				ReportEditor.setText(Report);
				
				
			}
		});
		btnRunReport.setFont(new Font("Dialog", Font.BOLD, 19));
		btnRunReport.setBounds(543, 507, 231, 44);
		frmEodReport.getContentPane().add(btnRunReport);
		

	}
	
	public static float compareTwoTimeStamps(java.sql.Timestamp currentTime, java.sql.Timestamp oldTime)
	{
	  float milliseconds1 = oldTime.getTime();
	  float milliseconds2 = currentTime.getTime();

	  float diff = milliseconds2 - milliseconds1;
	  float diffHours = diff / (60 * 60 * 1000);

	    return diffHours;
	}

}
