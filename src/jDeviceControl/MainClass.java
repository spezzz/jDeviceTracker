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
 * @author user
 *
 */

public class MainClass 
{

	private static final String DB_DRIVER = "org.sqlite.JDBC";
	private static final String DB_CONNECTION = "jdbc:sqlite:test.db";
	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	
	public static void main(String[] argv) 
	{
		if (argv.length == 0)
		{
			System.out.println("No arguments");
			
		}
		else
		{
			System.out.println("Arguments " + argv[0]);
		}
		
		
		
		WorkSQLite work_sql = new WorkSQLite();
		try {
			work_sql.insertRecordIntoDbUserTable();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Ошибка: " + e.getMessage());
		}
 
	}	

	
}
