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
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ListSelectionModel;


public class Table_Edit_Screen {
public JFrame frmTableEdit;
public static JList<Tickets> ticketList;
public static DefaultListModel<Tickets> ticketListModel;

/**
* Launch the application.
*/
public static void run()
{
	try {
			Table_Edit_Screen window = new Table_Edit_Screen();
			window.frmTableEdit.setVisible(true);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
}

/**
* Create the application.
*/
public Table_Edit_Screen() {
initialize();

}

/**
* Initialize the contents of the frame.
*/
private void initialize() {
frmTableEdit = new JFrame();
frmTableEdit.getContentPane().setBackground(Color.WHITE);
frmTableEdit.setIconImage(Toolkit.getDefaultToolkit().getImage(Table_Edit_Screen.class.getResource("/General_images/GI_icon.png")));
frmTableEdit.setTitle("Table Edit");
frmTableEdit.setBounds(100, 100, 800, 600);
frmTableEdit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frmTableEdit.getContentPane().setLayout(null);

JScrollPane scrollPane = new JScrollPane();
scrollPane.setBounds(29, 108, 268, 379);
frmTableEdit.getContentPane().add(scrollPane);	

ticketList = new JList<Tickets>();
ticketList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
scrollPane.setViewportView(ticketList);
JLabel lblCurrentTicket = new JLabel("Current Ticket:");
lblCurrentTicket.setFont(new Font("Tahoma", Font.BOLD, 20));
lblCurrentTicket.setBounds(70, 52, 186, 45);
frmTableEdit.getContentPane().add(lblCurrentTicket);

JButton btnNewButton = new JButton("Appetizers");
btnNewButton.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent e) {

//Display the Appetizer screen
Apps_Screen Apps_GUI_Instance = new Apps_Screen();
Apps_GUI_Instance.frmAppetizers.setVisible(true);

}
});
btnNewButton.setBackground(Color.YELLOW);
btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
btnNewButton.setBounds(368, 95, 152, 61);
frmTableEdit.getContentPane().add(btnNewButton);

JButton btnSalads = new JButton("Salads");
btnSalads.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent e) {

//Display the Salad Screen
Salads_Screen Salads_GUI_Instance = new Salads_Screen();
Salads_GUI_Instance.frmSalads.setVisible(true);
}
});
btnSalads.setBackground(Color.GREEN);
btnSalads.setFont(new Font("Tahoma", Font.PLAIN, 20));
btnSalads.setBounds(368, 167, 152, 61);
frmTableEdit.getContentPane().add(btnSalads);

JButton btnSandwiches = new JButton("Sandwiches");
btnSandwiches.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent e) {

//Display the Sandwiches screen
Sandwiches_Screen Sandwiches_GUI_Instance = new Sandwiches_Screen();
Sandwiches_GUI_Instance.frmSandwiches.setVisible(true);
}
});
btnSandwiches.setBackground(Color.CYAN);
btnSandwiches.setFont(new Font("Tahoma", Font.PLAIN, 20));
btnSandwiches.setBounds(368, 239, 152, 61);
frmTableEdit.getContentPane().add(btnSandwiches);

JButton btnBurgers = new JButton("Burgers");
btnBurgers.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent e) {

//Display the Burgers screen
Burgers_Screen Burgers_GUI_Instance = new Burgers_Screen();
Burgers_GUI_Instance.frmBurgers.setVisible(true);

}
});
btnBurgers.setFont(new Font("Tahoma", Font.PLAIN, 20));
btnBurgers.setBounds(368, 311, 152, 61);
frmTableEdit.getContentPane().add(btnBurgers);

JButton btnEntrees = new JButton("Entrees");
btnEntrees.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent e) {

//Display the Entrees screen
Entrees_Screen Entrees_GUI_Instance = new Entrees_Screen();
Entrees_GUI_Instance.frmEntrees.setVisible(true);
}
});
btnEntrees.setBackground(Color.RED);
btnEntrees.setFont(new Font("Tahoma", Font.PLAIN, 20));
btnEntrees.setBounds(368, 383, 152, 61);
frmTableEdit.getContentPane().add(btnEntrees);

JButton btnSpecialties = new JButton("Specialties");	
btnSpecialties.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent e) {

//Display the Specials screen
Specials_Screen Specials_GUI_Instance = new Specials_Screen();
Specials_GUI_Instance.frmSpecialties.setVisible(true);
}
});
btnSpecialties.setBackground(SystemColor.textHighlight);
btnSpecialties.setFont(new Font("Tahoma", Font.PLAIN, 20));
btnSpecialties.setBounds(530, 95, 152, 61);
frmTableEdit.getContentPane().add(btnSpecialties);

JButton btnCombinations = new JButton("Combos");
btnCombinations.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent e) {

//Display the C-C-Combos screen
Combos_Screen Combos_GUI_Instance = new Combos_Screen();
Combos_GUI_Instance.frmCombinations.setVisible(true);
}
});
btnCombinations.setBackground(Color.PINK);
btnCombinations.setFont(new Font("Tahoma", Font.PLAIN, 20));
btnCombinations.setBounds(530, 167, 152, 61);
frmTableEdit.getContentPane().add(btnCombinations);

JButton btnOmelets = new JButton("Omelets");
btnOmelets.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent e) {

//Display the Omelets screen
Omelets_Screen Omelets_GUI_Instance = new Omelets_Screen();
Omelets_GUI_Instance.frmOmelets.setVisible(true);
}
});
btnOmelets.setToolTipText("Omelette du fromage...?");
btnOmelets.setBackground(Color.MAGENTA);
btnOmelets.setFont(new Font("Tahoma", Font.PLAIN, 20));
btnOmelets.setBounds(530, 239, 152, 61);
frmTableEdit.getContentPane().add(btnOmelets);

JButton btnSides = new JButton("Sides");
btnSides.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent e) {

//Display the sides screen
Sides_Screen Sides_GUI_Instance = new Sides_Screen();
Sides_GUI_Instance.frmSides.setVisible(true);
}
});
btnSides.setBackground(Color.ORANGE);
btnSides.setFont(new Font("Tahoma", Font.PLAIN, 20));
btnSides.setBounds(530, 311, 152, 61);
frmTableEdit.getContentPane().add(btnSides);

JButton btnDrinks = new JButton("Drinks");
btnDrinks.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent e) {

//Display the drinks screen
Drinks_Screen Drinks_GUI_Instance = new Drinks_Screen();
Drinks_GUI_Instance.frmDrinks.setVisible(true);
}
});
btnDrinks.setBackground(Color.BLUE);
btnDrinks.setFont(new Font("Tahoma", Font.PLAIN, 20));
btnDrinks.setBounds(530, 383, 152, 61);
frmTableEdit.getContentPane().add(btnDrinks);

JButton btnBackToTables = new JButton("Back to Tables");
btnBackToTables.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent e) {	
Server_Screen.run();
frmTableEdit.dispose();
}
});
btnBackToTables.setFont(new Font("Tahoma", Font.PLAIN, 20));
btnBackToTables.setBounds(284, 0, 236, 49);
frmTableEdit.getContentPane().add(btnBackToTables);

JButton btnCashout = new JButton("Cashout");
btnCashout.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent e) {

//Go to a cashout screen
frmTableEdit.dispose();
Cashout_Screen.run();

}
});
btnCashout.setFont(new Font("Tahoma", Font.PLAIN, 20));
btnCashout.setBounds(378, 490, 152, 61);
frmTableEdit.getContentPane().add(btnCashout);

JButton btnEditRemove = new JButton("Edit / Remove");
btnEditRemove.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent arg0) {
RemoveFromTicket();
}
});
btnEditRemove.setFont(new Font("Tahoma", Font.PLAIN, 20));
btnEditRemove.setBounds(78, 498, 178, 49);
frmTableEdit.getContentPane().add(btnEditRemove);

JButton SplitCheck = new JButton("Split Check");
SplitCheck.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent e) {
frmTableEdit.dispose();
Split_Check.run();
}
});
SplitCheck.setFont(new Font("Tahoma", Font.PLAIN, 20));
SplitCheck.setBounds(540, 490, 152, 61);
frmTableEdit.getContentPane().add(SplitCheck);
PopulateTicket(Server_Screen.tableID);
}

public static void RemoveFromTicket()
{
Tickets tmp = ticketList.getSelectedValue();
String name = tmp.getitem();
String commandText = "DELETE FROM tableorders WHERE Item = " + "'" + name + "' LIMIT 1";
SQL.UpdateResultSet(commandText);
PopulateTicket(Server_Screen.tableID);
}

public static void InsertItem(int table_ID, String item_name, double item_price)
{
String commandText = "INSERT INTO tableorders (ID,Item,Price)" +
"VALUES ('" + table_ID + "', '" +
item_name + "', '" + item_price +
"')";
SQL.UpdateResultSet(commandText);
PopulateTicket(Server_Screen.tableID);

}

public static void PopulateTicket(int ID)
{

ticketListModel = new DefaultListModel<Tickets>();
String commandText = "SELECT * from tableorders WHERE ID = " + ID;
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