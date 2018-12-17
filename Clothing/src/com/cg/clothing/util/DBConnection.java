package com.cg.clothing.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection 
{
	public static Connection getConnection() throws SQLException, IOException, ClassNotFoundException
	{
		FileInputStream fis=new FileInputStream("resources/DB.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url=prop.getProperty("url");
		String username=prop.getProperty("username");
		String password=prop.getProperty("password");
		String driver=prop.getProperty("driver");
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
		
		return conn;


	}
}
