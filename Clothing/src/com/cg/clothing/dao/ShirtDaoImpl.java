package com.cg.clothing.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.xml.sax.HandlerBase;

import com.cg.clothing.bean.Shirt;
import com.cg.clothing.util.DBConnection;

public class ShirtDaoImpl implements IShirtDao
{

	@Override
	public String addShirt(Shirt shirt) throws SQLException, IOException 
	{
		System.out.println(shirt);
		String shirtId=null;
		try
		{
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = null;
			ResultSet resultSet=null;
			Statement stmt=conn.createStatement();
			System.out.println("i");
			pstmt=conn.prepareStatement("insert into shirt_details values(sequence_shirtid.nextval,?,?,?)");
			pstmt.setDouble(1, shirt.getShirtPrice());
			pstmt.setString(2, shirt.getShirtSize());
			pstmt.setString(3, shirt.getShirtColour());
			pstmt.executeUpdate();
			System.out.println("i");
			resultSet=pstmt.executeQuery("select Max(shirt_id) from shirt_details");
			while(resultSet.next())
			{
				System.out.println(resultSet.getString(1));
//				System.out.println(resultSet.getDouble(2));
//				System.out.println(resultSet.getString(3));
//				System.out.println(resultSet.getString(4));
			}
			
		}
		catch(ClassNotFoundException e) 
		{
			System.out.println(e);
		}
		
		
		return shirtId;
	}
	@Override
	public Shirt selectShirt(String sid) throws SQLException, IOException 
	{
		Shirt s = new Shirt();
		try
		{
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = null;
			ResultSet resultSet=null;
			Statement stmt=conn.createStatement();
		
			pstmt=conn.prepareStatement("select * from shirt_details where shirt_id=?");
			pstmt.setString(1, sid);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
	
				s.setShirtId(resultSet.getString(1));
				s.setShirtColour(resultSet.getString(4));
				s.setShirtPrice(resultSet.getDouble(2));
				s.setShirtSize(resultSet.getString(3));
			}
			
		}
		catch(ClassNotFoundException e) 
		{
			System.out.println(e);
		}
		
		return s;
		
	}
	
	@Override
	public Shirt deleteShirt(String sid) throws SQLException, IOException 
	{
		Shirt s = new Shirt();
		try
		{
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = null;
			ResultSet resultSet=null;
			Statement stmt=conn.createStatement();
			
			pstmt=conn.prepareStatement("delete from shirt_details where shirt_id=?");
			
			pstmt.setString(1, sid);
			
		}
		catch(ClassNotFoundException e) 
		{
			System.out.println(e);
		}
		
		return s;
	}

	
	
}
