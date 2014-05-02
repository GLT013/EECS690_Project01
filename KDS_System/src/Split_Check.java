import javax.swing.JFrame;

import java.awt.Toolkit;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ListSelectionModel;


public class Split_Check {
	JFrame frmTableEditSplit;
	public static JList<Tickets> ticketList;
	public static DefaultListModel<Tickets> ticketListModel;
	public static JList<Tickets> ticketList2;
	public static DefaultListModel<Tickets> ticketListModel2;
	
	/**
	 * Launch the application.
	 */

			public static void run() {
			
				try {
					Split_Check window = new Split_Check();
					window.frmTableEditSplit.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}


	/**
	 * Create the application.
	 */
	public Split_Check() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTableEditSplit = new JFrame();
		frmTableEditSplit.getContentPane().setBackground(Color.WHITE);
		frmTableEditSplit.setIconImage(Toolkit.getDefaultToolkit().getImage(Split_Check.class.getResource("/General_images/GI_icon.png")));
		frmTableEditSplit.setTitle("Table Edit");
		frmTableEditSplit.setBounds(100, 100, 800, 600);
		frmTableEditSplit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTableEditSplit.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 108, 268, 379);
		frmTableEditSplit.getContentPane().add(scrollPane);		
		
		ticketList = new JList<Tickets>();
		ticketList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(ticketList);
		JLabel lblCurrentTicket = new JLabel("Ticket 1");
		lblCurrentTicket.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCurrentTicket.setBounds(70, 52, 186, 45);
		frmTableEditSplit.getContentPane().add(lblCurrentTicket);
		
		JButton btnBackToTables = new JButton("Back to Tables");
		btnBackToTables.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//*****************************************
				//         Save Table Data Here ?
				//*****************************************
				
				
				frmTableEditSplit.dispose();
			}
		});
		btnBackToTables.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBackToTables.setBounds(283, 0, 236, 49);
		frmTableEditSplit.getContentPane().add(btnBackToTables);
		
		JButton btnCashout = new JButton("Cashout");
		btnCashout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//Go to a cashout screen
				Cashout_Screen_SplitCheck.run();
				frmTableEditSplit.dispose();
				
			}
		});
		btnCashout.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCashout.setBounds(530, 492, 152, 61);
		frmTableEditSplit.getContentPane().add(btnCashout);
		
		JButton btnEditRemove = new JButton("Edit / Remove");
		btnEditRemove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				RemoveFromTicket();
			}
		});
		btnEditRemove.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEditRemove.setBounds(70, 498, 178, 49);
		frmTableEditSplit.getContentPane().add(btnEditRemove);
		
		JLabel lblTicket = new JLabel("Ticket 2");
		lblTicket.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTicket.setBounds(487, 60, 186, 45);
		frmTableEditSplit.getContentPane().add(lblTicket);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(434, 108, 268, 379);
		frmTableEditSplit.getContentPane().add(scrollPane_1);
		
		ticketList2 = new JList<Tickets>();
		ticketList2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(ticketList2);
		
		JButton button = new JButton(">");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MoveTicket();
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button.setBounds(319, 262, 105, 45);
		frmTableEditSplit.getContentPane().add(button);
		
		JButton button_1 = new JButton("<");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button_1.setBounds(319, 328, 105, 45);
		frmTableEditSplit.getContentPane().add(button_1);
		PopulateTicket();
	}

public static void RemoveFromTicket()
{
	Tickets tmp = ticketList.getSelectedValue();
	String name = tmp.getitem();
	String commandText = "DELETE FROM tableorders WHERE Item = " + "'" + name + "' LIMIT 1";
	SQL.UpdateResultSet(commandText);
	PopulateTicket();
}

public static void InsertItem(int table_ID, String item_name, double item_price)
{
	String commandText = "INSERT INTO tableorders (ID,Item,Price)" +
			"VALUES ('" + table_ID + "', '" +
			item_name + "', '" + item_price +
			"')";
	SQL.UpdateResultSet(commandText);
	PopulateTicket();
	
}

public static void MoveTicket()
{
	
	Tickets tmp = ticketList.getSelectedValue();	
	
	ticketListModel2.addElement(tmp);;
	ticketListModel.removeElement(tmp);
	ticketList.setModel(ticketListModel);
	ticketList2.setModel(ticketListModel2);
}


public static void MoveTicketReverse()
{
	
	Tickets tmp = ticketList.getSelectedValue();	
	
	ticketListModel2.addElement(tmp);;
	ticketListModel.removeElement(tmp);
	ticketList.setModel(ticketListModel);
	ticketList2.setModel(ticketListModel2);
}

public static void PopulateTicket()
{
	ticketListModel2 = new DefaultListModel<Tickets>();
	ticketListModel = new DefaultListModel<Tickets>();
	String commandText = "SELECT * from tableorders WHERE ID = " + Server_Screen.tableID;
	ResultSet rs = SQL.ExecuteResultSet(commandText); 
	double price = 0;
	String name = "";
	try {
		while ((rs!=null) && (rs.next()))
		{			
			name = rs.getString("Item");
			price = rs.getDouble("price");
			Tickets tick = new Tickets(name,price);			
			ticketListModel.addElement(tick);
			
		}
	}
	catch (SQLException e)
	{
		JOptionPane.showMessageDialog(null, e.toString());
	}
	
	ticketList.setModel(ticketListModel);
	
	
}
}