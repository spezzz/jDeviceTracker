/**
 * 
 */
package jDeviceControl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @author Mikhail
 *
 */
public class WorkSQLite 
{
	private static final String DB_DRIVER = "org.sqlite.JDBC";
	private static final String DB_CONNECTION = "jdbc:sqlite:test.db";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";
	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	

	
	public static Boolean CreateDataBase()
	{
		Connection cnnctn = null;
		Statement stmt = null;
		try 
		{
		      Class.forName(DB_DRIVER);
		      cnnctn = DriverManager.getConnection(DB_CONNECTION);
		      System.out.println("Opened database successfully");
		      stmt = cnnctn.createStatement();
				String sql ="CREATE TABLE PG100Config ("+
				" Field1     TEXT,"+
				" Field2     TEXT,"+
				" Field3     TEXT,"+
				" Field4     TEXT,"+
				" Field5     TEXT,"+
				" Field6     TEXT,"+
				" Field7     TEXT,"+
				" Field8     TEXT,"+
				" Field9     TEXT,"+
				" Field10    TEXT"+
				");";
		      stmt.executeUpdate(sql);
		      stmt.close();
		      cnnctn.close();
		      return true;
		} 
		catch ( Exception e ) 
		{
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			return false;
		}
	}
	
	
	
	
	public static void insertRecordIntoDbUserTable() throws SQLException 
	{
		 
		Connection dbConnection = null;
		Statement statement = null;
 
		String insertTableSQL = "INSERT INTO DBUSER"
				+ "(USER_ID, USERNAME, CREATED_BY, CREATED_DATE) " + "VALUES"
				+ "(1,'mkyong','system', " + "to_date('"
				+ getCurrentTimeStamp() + "', 'yyyy/mm/dd hh24:mi:ss'))";
 
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
 
			System.out.println(insertTableSQL);
 
			// execute insert SQL stetement
			statement.executeUpdate(insertTableSQL);
 
			System.out.println("Record is inserted into DBUSER table!");
 
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
 
		} finally {
 
			if (statement != null) {
				statement.close();
			}
 
			if (dbConnection != null) {
				dbConnection.close();
			}
 
		}
 
	}
	
	
	
	private static Connection getDBConnection() 
	{
		System.out.println("[getDBConnection] Start");
		Connection dbConnection = null;
		try 
		{
			Class.forName(DB_DRIVER);
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println(e.getMessage());
		}
		try 
		{
			dbConnection = DriverManager.getConnection(DB_CONNECTION);
			return dbConnection;
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		System.out.println("[getDBConnection] Complete");
		return dbConnection;
 
	}
	
	
	
	
	
	public static String getCurrentTimeStamp() 
	{
		java.util.Date today = new java.util.Date();
		return dateFormat.format(today.getTime());
	}
	
}
