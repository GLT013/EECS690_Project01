import java.io.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;

public class Connection {
	public static String username;
	public static String password;
	public static String url;
	public static Statement stmt;
	public static String pw;
	public static String name;
	public static String url2;
	public static java.sql.Connection con;

	
	

	private static void ReadFile(){
	  try{	 		  
		  FileInputStream fstream = new FileInputStream("ConnectionInfo.txt");	  
		  DataInputStream in = new DataInputStream(fstream);
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));  
		  
		  username = br.readLine(); //First line is username
		  password = br.readLine(); //Second line is password
		  url = br.readLine(); 	    //Third line is connection url		  
		  in.close(); 				//Close the buffer (Writes to the file)
		  
		  String[] split = username.split(": ");
			name = split[1];
			split = password.split(": ");
			pw = split[1];
			split = url.split(" ");
			url2 = split[1];
	    }catch (Exception e)
		{
			System.err.println("Error: " + e.getMessage());
		} 	  

	  }
	
		/**	 
		 * The Connect() method is used to create the connection with the SQL server.
		 * 
		 */		
	public static boolean Connect(){
		//CreateFile();
		ReadFile();	
		
		try {
				Class.forName("com.mysql.jdbc.Driver");
			} 
		catch (ClassNotFoundException e) 
			{
				System.out.println(e.getMessage());
				return false;
			}
			
		try {
				con = DriverManager.getConnection(url2,name,pw); //creates a connection with the server
						
				
			} 
			catch (SQLException e) 
			{
				System.out.println(e.getMessage());
				return false;
			}
		
		return true;
		
	}
	
}

