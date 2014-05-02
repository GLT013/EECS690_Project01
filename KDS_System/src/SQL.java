import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;



public class SQL {

public static java.sql.Connection connection;
public static Statement statement;


public static void ExecuteQuery(String query){
		connection = Connection.con;
		statement = Connection.stmt;
		
		try {
			statement = (Statement) ((java.sql.Connection) connection).createStatement();	
			statement.executeUpdate(query);
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	
	}


	
	public static ResultSet ExecuteResultSet(String query){
		ResultSet rs = null;	
		connection = Connection.con;
		statement = Connection.stmt;
		try{
			statement = (Statement) ((java.sql.Connection) connection).createStatement();
			rs = statement.executeQuery(query);			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}	
		
		
		
		return rs;
		
		
	}
	
	
	
	public static void UpdateResultSet(String query){
			
		connection = Connection.con;
		statement = Connection.stmt;
		try{
			statement = (Statement) ((java.sql.Connection) connection).createStatement();
			statement.executeUpdate(query);			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		

		
	}
	
	
}
