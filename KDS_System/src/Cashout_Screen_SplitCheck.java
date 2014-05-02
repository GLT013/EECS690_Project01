import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.ListModel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;


public class Cashout_Screen_SplitCheck {

	JFrame frmCashoutTableSplit;
	private static JTextField tipAmount;
	private static JTextField tipAmount2;
	public static DefaultListModel<Tickets> ticketListModel2;
	public static DefaultListModel<Tickets> ticketListModel;	
	public static double total;
	public static JList<Tickets> list;
	public static JList<Tickets> list_1;
	public static JTextPane textPane_1;
	public static JTextPane textPane;
	public static JButton btnCash;
	public static JButton btnCc;
	public static JButton btnDiscount;
	public static JButton btnCheck;
	public static JButton button;
	public static JButton button_1;
	public static JButton button_2;
	public static JButton button_3;
	public static JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	
	public static void run() {
		try {
			Cashout_Screen_SplitCheck window = new Cashout_Screen_SplitCheck();
			window.frmCashoutTableSplit.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the application.
	 */
	public Cashout_Screen_SplitCheck() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCashoutTableSplit = new JFrame();
		frmCashoutTableSplit.setIconImage(Toolkit.getDefaultToolkit().getImage(Cashout_Screen_SplitCheck.class.getResource("/General_images/GI_icon.png")));
		frmCashoutTableSplit.getContentPane().setBackground(Color.WHITE);
		frmCashoutTableSplit.getContentPane().setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Exit cashout screen without closing ticket
				frmCashoutTableSplit.dispose();
				Split_Check.run();
				//RemoveFromDatabase();
				
				
			}
		});
		btnBack.setBounds(280, 0, 117, 25);
		frmCashoutTableSplit.getContentPane().add(btnBack);
		
		JLabel lblTicket = new JLabel("Ticket 1");
		lblTicket.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTicket.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTicket.setBounds(59, 47, 117, 25);
		frmCashoutTableSplit.getContentPane().add(lblTicket);
		
		textPane_1 = new JTextPane();
		textPane_1.setBackground(Color.LIGHT_GRAY);
		textPane_1.setBounds(147, 290, 144, 41);
		frmCashoutTableSplit.getContentPane().add(textPane_1);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTotal.setBounds(59, 301, 70, 15);
		frmCashoutTableSplit.getContentPane().add(lblTotal);
		
		tipAmount = new JTextField();
		tipAmount.setText("0");
		tipAmount.setBackground(Color.LIGHT_GRAY);
		tipAmount.setBounds(147, 362, 114, 19);
		frmCashoutTableSplit.getContentPane().add(tipAmount);
		tipAmount.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Tip Total:");
		lblNewLabel.setBounds(59, 364, 70, 15);
		frmCashoutTableSplit.getContentPane().add(lblNewLabel);
		
		btnDiscount = new JButton("Discount");
		btnDiscount.setFont(new Font("Dialog", Font.BOLD, 20));
		btnDiscount.setBounds(70, 494, 191, 40);
		frmCashoutTableSplit.getContentPane().add(btnDiscount);
		
		btnCc = new JButton("CC");
		btnCc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				InsertTip1();
				DisableButtons();
			}
		});
		btnCc.setFont(new Font("Dialog", Font.BOLD, 20));
		btnCc.setBounds(115, 409, 86, 42);
		frmCashoutTableSplit.getContentPane().add(btnCc);
		
		btnCheck = new JButton("Check");
		btnCheck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InsertTip1();
				DisableButtons();
			}
		});
		btnCheck.setFont(new Font("Dialog", Font.BOLD, 20));
		btnCheck.setBounds(211, 410, 97, 40);
		frmCashoutTableSplit.getContentPane().add(btnCheck);
		
		btnCash = new JButton("Cash");
		btnCash.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				InsertTip1();
				DisableButtons();
			}
		});
		btnCash.setFont(new Font("Dialog", Font.BOLD, 20));
		btnCash.setBounds(12, 409, 93, 43);
		frmCashoutTableSplit.getContentPane().add(btnCash);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 83, 294, 196);
		frmCashoutTableSplit.getContentPane().add(scrollPane);
		
		list = new JList<Tickets>();
		scrollPane.setViewportView(list);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setModel(Split_Check.ticketListModel);
		
		
		frmCashoutTableSplit.setTitle("Cashout Table");
		frmCashoutTableSplit.setBounds(100, 100, 706, 600);
		frmCashoutTableSplit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JLabel lblTicket_1 = new JLabel("Ticket 2");
		lblTicket_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTicket_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTicket_1.setBounds(385, 47, 117, 25);
		frmCashoutTableSplit.getContentPane().add(lblTicket_1);
		
		textPane = new JTextPane();
		textPane.setText("0");
		textPane.setBackground(Color.LIGHT_GRAY);
		textPane.setBounds(450, 290, 144, 41);
		frmCashoutTableSplit.getContentPane().add(textPane);
		
		JLabel label_1 = new JLabel("Total:");
		label_1.setFont(new Font("Dialog", Font.BOLD, 20));
		label_1.setBounds(362, 301, 70, 15);
		frmCashoutTableSplit.getContentPane().add(label_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(352, 83, 294, 196);
		frmCashoutTableSplit.getContentPane().add(scrollPane_1);
		
		list_1 = new JList<Tickets>();
		scrollPane_1.setViewportView(list_1);
		list_1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list_1.setModel(Split_Check.ticketListModel2);
		
		JLabel label = new JLabel("Tip Total:");
		label.setBounds(362, 364, 70, 15);
		frmCashoutTableSplit.getContentPane().add(label);
		
		tipAmount2 = new JTextField();
		tipAmount2.setText("0");
		tipAmount2.setColumns(10);
		tipAmount2.setBackground(Color.LIGHT_GRAY);
		tipAmount2.setBounds(450, 362, 114, 19);
		frmCashoutTableSplit.getContentPane().add(tipAmount2);
		
		button = new JButton("Cash");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InsertTip2();
				DisableButtons2();
			}
		});
		button.setFont(new Font("Dialog", Font.BOLD, 20));
		button.setBounds(362, 409, 93, 43);
		frmCashoutTableSplit.getContentPane().add(button);
		
		button_1 = new JButton("CC");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InsertTip2();
				DisableButtons2();
			}
		});
		button_1.setFont(new Font("Dialog", Font.BOLD, 20));
		button_1.setBounds(462, 409, 86, 42);
		frmCashoutTableSplit.getContentPane().add(button_1);
		
		button_2 = new JButton("Check");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InsertTip2();
				DisableButtons2();
			}
		});
		button_2.setFont(new Font("Dialog", Font.BOLD, 20));
		button_2.setBounds(558, 410, 97, 40);
		frmCashoutTableSplit.getContentPane().add(button_2);
		
		button_3 = new JButton("Discount");
		button_3.setFont(new Font("Dialog", Font.BOLD, 20));
		button_3.setBounds(450, 494, 178, 40);
		frmCashoutTableSplit.getContentPane().add(button_3);
		
		btnNewButton = new JButton("Done");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RemoveFromDatabase();
				Server_Screen.run();
				frmCashoutTableSplit.dispose();
			}
		});
		btnNewButton.setEnabled(false);
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 20));
		btnNewButton.setBounds(295, 494, 117, 41);
		frmCashoutTableSplit.getContentPane().add(btnNewButton);
		
		GetTotal();
		
	
	}
	
	public static void GetTotal()
	{
		double tmpPrice = 0;
		ListModel<Tickets> model = Split_Check.ticketList.getModel();
		Tickets tmp;
		for (int i =0; i<model.getSize(); i++)
		{
			tmp = model.getElementAt(i);
			tmpPrice = tmpPrice + tmp.getprice();
						
		}
		tmpPrice = tmpPrice + (tmpPrice *.08);
		String tmp2 = new DecimalFormat("#.##").format(tmpPrice);
		textPane_1.setText(tmp2);
		
		
		double tmpPrice2 = 0;
		ListModel<Tickets> model2 = new DefaultListModel<Tickets>();
		model2 = Split_Check.ticketList2.getModel();	
		for (int j = 0; j<model2.getSize(); j++)
		{
			double price = model2.getElementAt(j).getprice();
			//System.out.println(price);
			tmpPrice2 = tmpPrice2 + price;
						
		}
		tmpPrice2 = tmpPrice2 + (tmpPrice2 *.08);
		String tmp3 = new DecimalFormat("#.##").format(tmpPrice2);
		textPane.setText(tmp3);
		
	}
	
	public static void InsertTip1()
	{
		int ID = Login_Screen.ID2;
		double tip = 0;
		
		String commandText = "SELECT * FROM employee WHERE ID = " + ID;
		
		ResultSet rs = SQL.ExecuteResultSet(commandText);
		try
		{
			while ((rs!=null) && (rs.next()))
			{
				tip = rs.getDouble("TipTotal");
			}
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.toString());		
		}
		String tmp = tipAmount.getText();
		double tipTotal = tip + Double.parseDouble(tmp);
		
		commandText = "UPDATE employee SET TipTotal = " + "'" + tipTotal + "'" + "WHERE ID = " + ID;
		SQL.UpdateResultSet(commandText);
		
	}
	
	
	public static void InsertTip2()
	{
		int ID = Login_Screen.ID2;
		double tip = 0;
		
		String commandText = "SELECT * FROM employee WHERE ID = " + ID;
		
		ResultSet rs = SQL.ExecuteResultSet(commandText);
		try
		{
			while ((rs!=null) && (rs.next()))
			{
				tip = rs.getDouble("TipTotal");
			}
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.toString());		
		}
		String tmp = tipAmount2.getText();
		double tipTotal = tip + Double.parseDouble(tmp);
		
		commandText = "UPDATE employee SET TipTotal = " + "'" + tipTotal + "'" + "WHERE ID = " + ID;
		SQL.UpdateResultSet(commandText);
		
	}
	
	public static void DisableButtons()
	{
		
		btnCash.setEnabled(false);
		btnCc.setEnabled(false);
		btnCheck.setEnabled(false);
		btnDiscount.setEnabled(false);	
		if (!button.isEnabled())
		{
			btnNewButton.setEnabled(true);
		}
		
	}
	
	
	public static void DisableButtons2()
	{
		
		button.setEnabled(false);
		button_1.setEnabled(false);
		button_2.setEnabled(false);
		button_3.setEnabled(false);
		if (!btnCash.isEnabled())
		{
			btnNewButton.setEnabled(true);
		}
			
		
		
	}
	
	public static void RemoveFromDatabase()
	{
		int ID = Server_Screen.tableID;
		String commandText = "SET SQL_SAFE_UPDATES=0;";
		SQL.UpdateResultSet(commandText);
		commandText = "DELETE FROM tableorders WHERE ID = " + ID;
		SQL.UpdateResultSet(commandText);
		
	}
}
