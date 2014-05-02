import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Cook_Screen {

	JFrame frmCooksView;
	private JList<Tickets> ticketLst1;
	private JList<Tickets> ticketLst2;
	private JList<Tickets> ticketLst3;
	private JList<Tickets> ticketLst4;
	private JList<Tickets> ticketLst5;
	private JList<Tickets> ticketLst6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cook_Screen window = new Cook_Screen();
					window.frmCooksView.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Cook_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCooksView = new JFrame();
		frmCooksView.setTitle("Cook's View");
		frmCooksView.setIconImage(Toolkit.getDefaultToolkit().getImage(Cook_Screen.class.getResource("/General_images/GI_icon.png")));
		frmCooksView.setBounds(100, 100, 800, 600);
		frmCooksView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCooksView.getContentPane().setLayout(null);
		
		ticketLst1 = new JList<Tickets>();
		ticketLst1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ticketLst1.setBounds(10, 35, 205, 190);
		frmCooksView.getContentPane().add(ticketLst1);
		
		ticketLst2 = new JList<Tickets>();
		ticketLst2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ticketLst2.setBounds(293, 35, 205, 190);
		frmCooksView.getContentPane().add(ticketLst2);
		
		ticketLst3 = new JList<Tickets>();
		ticketLst3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ticketLst3.setBounds(569, 35, 205, 190);
		frmCooksView.getContentPane().add(ticketLst3);
		
		ticketLst4 = new JList<Tickets>();
		ticketLst4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ticketLst4.setBounds(10, 307, 205, 190);
		frmCooksView.getContentPane().add(ticketLst4);
		
		ticketLst5 = new JList<Tickets>();
		ticketLst5.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ticketLst5.setBounds(293, 307, 205, 190);
		frmCooksView.getContentPane().add(ticketLst5);
		
		ticketLst6 = new JList<Tickets>();
		ticketLst6.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ticketLst6.setBounds(569, 307, 205, 190);
		frmCooksView.getContentPane().add(ticketLst6);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Login_Screen Login_GUI_Instance = new Login_Screen();
				Login_GUI_Instance.frmKds.setVisible(true);
				frmCooksView.dispose();
				
				
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnExit.setBounds(338, 0, 114, 24);
		frmCooksView.getContentPane().add(btnExit);
		
		JButton btnClear1 = new JButton("Clear");
		btnClear1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				clearTicket(1);
				
			}
		});
		btnClear1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnClear1.setBounds(52, 236, 114, 24);
		frmCooksView.getContentPane().add(btnClear1);
		
		JButton btnClear4 = new JButton("Clear");
		btnClear4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				clearTicket(4);
			}
		});
		btnClear4.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnClear4.setBounds(52, 508, 114, 24);
		frmCooksView.getContentPane().add(btnClear4);
		
		JButton btnClear2 = new JButton("Clear");
		btnClear2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				clearTicket(2);
			}
		});
		btnClear2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnClear2.setBounds(338, 236, 114, 24);
		frmCooksView.getContentPane().add(btnClear2);
		
		JButton btnClear3 = new JButton("Clear");
		btnClear3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				clearTicket(3);
			}
		});
		btnClear3.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnClear3.setBounds(626, 236, 114, 24);
		frmCooksView.getContentPane().add(btnClear3);
		
		JButton btnClear5 = new JButton("Clear");
		btnClear5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				clearTicket(5);
			}
		});
		btnClear5.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnClear5.setBounds(338, 508, 114, 24);
		frmCooksView.getContentPane().add(btnClear5);
		
		JButton btnClear6 = new JButton("Clear");
		btnClear6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				clearTicket(6);
			}
		});
		btnClear6.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnClear6.setBounds(626, 508, 114, 24);
		frmCooksView.getContentPane().add(btnClear6);
		
		ticketLst1.setModel(Table_Edit_Screen.ticketListModel);
	}

	protected void clearTicket(int i) {
		// TODO Auto-generated method stub
		// Clears the ticket in the appropriate jList
		
		switch(i){
		
		case 1: ticketLst1.setListData(new Tickets[0]);
				break;
				
		case 2: ticketLst2.setListData(new Tickets[0]);
				break;
		
		case 3: ticketLst3.setListData(new Tickets[0]);
				break;
		
		case 4: ticketLst4.setListData(new Tickets[0]);
				break;
		
		case 5: ticketLst5.setListData(new Tickets[0]);
				break;
		
		case 6: ticketLst6.setListData(new Tickets[0]);
				break;
				
		default: 
				break;		
		}
			

	}
}
