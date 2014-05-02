import java.sql.ResultSet;
import java.sql.SQLException;


public class Query {

	public static String ItemQuery(int id)
	{
		
		String commandText = "SELECT * from MainMenu WHERE ID = " + id;
		ResultSet rs;
		String name = "";
		try{
			//Execute command
			rs = SQL.ExecuteResultSet(commandText); 
		
			while (rs.next()) {				
				name = rs.getString("Name");				
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return name;
		
	}
	
	public static double PriceQuery(int id)
	{
		String commandText = "SELECT * from MainMenu WHERE ID = " + id;
		ResultSet rs;
		double price = 0;
		try{
			//Execute command
			rs = SQL.ExecuteResultSet(commandText); 
		
			while (rs.next()) {				
				price = rs.getDouble("Price");
				
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return price;
		
		
	}
	
}
