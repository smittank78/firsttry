
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class loginConnection
{
	private static String url = "jdbc:postgresql://ec2-35-168-145-180.compute-1.amazonaws.com/dbsd9bkuio2lsc";
	private static String userName = "ikkmonatkfjmuj";
	private static String pass = "2d58550542e6a77a21f3574602a38029e3a135c7902a518164c26e8237840ff3";
	public static String driverClass = "org.postgresql.Driver";
	
	public static Connection getConnection()
	{	
		Connection con = null;
		try
		{
			Class.forName(driverClass);
			con = DriverManager.getConnection(url, userName, pass);
			if(con != null)
			{
				System.out.println("Connection Established");
			}
			else
			{
				System.out.println("Connection failed");
			}
		}
		catch (ClassNotFoundException e) 
		{
			System.out.println("ClassNotFound : try/catch at connection");
		}
		catch (SQLException e)
		{
			System.out.println("SQL Exception Occured at Connection class");
		}
		return con;
	}
	public static void main(String[] args)
	{
		loginConnection.getConnection();
	}

}
