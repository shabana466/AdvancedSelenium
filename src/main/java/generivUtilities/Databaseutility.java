package generivUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

public class Databaseutility {
	private Connection connection;
	//db initialization
	public void databaseInitialization(String JdbcUrl, String username, String password)  {
		Driver dbDriver=null;
		try {
			dbDriver=new Driver();
		} catch (SQLException e) {
	       e.printStackTrace();
		}//register database
		try {
			DriverManager.registerDriver(dbDriver);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//to establish data base connection
		
		try {
			connection=DriverManager.getConnection(JdbcUrl,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<String> getDataFromDatabase(String JdbcUrl, String username, String password, String query, String colName) throws SQLException {
		//create statament 
	Statement statement=connection.createStatement();
	     //to store result in db doubt.....
	 ResultSet result =statement.executeQuery(query);
	List<String> list=new ArrayList<>();
	while(result.next())
		list.add(result.getString(colName));
	
	return list;
	}
	
	//to modify data in db
	public int modifyDatabase(String query) {
		//create statament 
		Statement statement=null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		     //to store result in db;
		int result=0;
		  try {
			result= statement.executeUpdate(query);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		  return result;
	}
	
	//close db connections
	public void closeDatabase() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
	
		
	
