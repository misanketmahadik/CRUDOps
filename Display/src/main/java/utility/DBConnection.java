package utility;

import java.sql.*;

public class DBConnection 
{
	static Connection con;
	static String url="jdbc:mysql://localhost:3306/";
	static String Driver="com.mysql.jdbc.Driver";
	static String database="studentdata";
	static String path=url+database;
	public static Connection getConnection()
	{
		try
		{
			Class.forName(Driver);
			System.out.println("Driver Registered");
			con=DriverManager.getConnection(path,"root","");
			System.out.println("Connection Established...");
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return con;
	}

}