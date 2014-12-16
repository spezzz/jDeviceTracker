/**
 * 
 */
package jDeviceControl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author user
 *
 */
public class MainClass 
{


/***
 *     _____                _        ____________ 
 *    /  __ \              | |       |  _  \ ___ \
 *    | /  \/_ __ ___  __ _| |_ ___  | | | | |_/ /
 *    | |   | '__/ _ \/ _` | __/ _ \ | | | | ___ \
 *    | \__/\ | |  __/ (_| | ||  __/ | |/ /| |_/ /
 *     \____/_|  \___|\__,_|\__\___| |___/ \____/                                           
 */
	public static Boolean CreateDataBase()
	{
		Connection cnnctn = null;
		Statement stmt = null;
		try 
		{
		      Class.forName("org.sqlite.JDBC");
		      cnnctn = DriverManager.getConnection("jdbc:sqlite:Config.db");
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
	


/***
 *     _   _           _       _        ____________ 
 *    | | | |         | |     | |       |  _  \ ___ \
 *    | | | |_ __   __| | __ _| |_ ___  | | | | |_/ /
 *    | | | | '_ \ / _` |/ _` | __/ _ \ | | | | ___ \
 *    | |_| | |_) | (_| | (_| | ||  __/ | |/ /| |_/ /
 *     \___/| .__/ \__,_|\__,_|\__\___| |___/ \____/ 
 *          | |                                      
 *          |_|                                      
 */
	public static Boolean UpdateDataBase(String[] values)
	{
		Connection cnnctn = null;
		Statement stmt = null;
		if (values.length != 10)
		{
			System.out.println("Error! Wrong number of parameters!");
			return false;
		}
		try 
		{
			Class.forName("org.sqlite.JDBC");
			cnnctn = DriverManager.getConnection("jdbc:sqlite:test.db");
			cnnctn.setAutoCommit(false);	
			System.out.println("Opened database successfully");
			stmt = cnnctn.createStatement();
			String sql = "INSERT INTO PG100Config ("
		               + "Field1,Field2,Field3,Field4,Field5,"
		               + "Field6,Field7,Field8,Field9,Field10,) "
		               + "VALUES (" + values[0] + "," + values[1] + ","+ values[2] + ","+ 
		               values[3] + ","+ values[4] + ","+ values[5] + ","+ 
		               values[6] + ","+ values[7] + ","+ values[8] + ","+
		               values[9] + ");"; 
		    stmt.executeUpdate(sql);
		    stmt.close();
		    cnnctn.close();
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
		}

	      return true;
	}
	
	
	

/***
 *    ___  ___  ___  _____ _   _ 
 *    |  \/  | / _ \|_   _| \ | |
 *    | .  . |/ /_\ \ | | |  \| |
 *    | |\/| ||  _  | | | | . ` |
 *    | |  | || | | |_| |_| |\  |
 *    \_|  |_/\_| |_/\___/\_| \_/
 */
	public static void main(String[] args) 
	{
		if (args.length == 0)
		{
			System.out.println("No arguments");
			if (CreateDataBase())
				System.out.println("Create database successfully");
			else
				System.out.println("Create database failed");
			String [] values = new String[10];
			values[0] = "1";
			values[1] = "1";
			values[2] = "1";
			values[3] = "1";
			values[4] = "1";
			values[5] = "1";
			values[6] = "1";
			values[7] = "1";
			values[8] = "1";
			values[9] = "1";
			if (UpdateDataBase(values))
			{
				System.out.println("Update DB successfully");
			}
			else
			{
				System.out.println("Update DB failed");
			}
			
		}
		else
		{
			System.out.println("Arguments " + args[0]);
		}
		// TODO Auto-generated method stub

	}
	
	
	

}
