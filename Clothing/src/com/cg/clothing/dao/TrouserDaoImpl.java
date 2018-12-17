package com.cg.clothing.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cg.clothing.bean.Shirt;
import com.cg.clothing.bean.Trouser;
import com.cg.clothing.util.DBConnection;

public class TrouserDaoImpl implements ITrouserDao 
{

	@Override
	public String addTrouser(Trouser trouser) throws SQLException, IOException 
	{
		String trouserId=null;
		try
		{
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = null;
			ResultSet resultSet=null;
			Statement stmt=conn.createStatement();
			
			pstmt=conn.prepareStatement("insert into trouser_details values(trouserId_sequence.nextval,?,?,?)");
			pstmt.setString(1, trouser.getTrouserSize());
			pstmt.setString(2, trouser.getTrouserColour());
			pstmt.setDouble(3, trouser.getTrouserPrice());
			pstmt.executeUpdate();
			resultSet=stmt.executeQuery("select max(trouser_id) from trouser_details");
			while(resultSet.next())
			{
				System.out.println(resultSet.getString(1));
				//System.out.println(resultSet.getString(2));
				//System.out.println(resultSet.getString(3));
				//System.out.println(resultSet.getDouble(4));
			}
			
		}
		catch(ClassNotFoundException e) 
		{
			System.out.println(e);
		}
		
		
		return trouserId;	
	}
	@Override
	public Trouser selectTrouser(String tid) throws SQLException, IOException 
	{
		Trouser s = new Trouser();
		try
		{
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = null;
			ResultSet resultSet=null;
			Statement stmt=conn.createStatement();
			
			
			resultSet=pstmt.executeQuery("select * from trouser_details where trouser_id=?");
			pstmt.setString(1, tid);
			while(resultSet.next())
			{
	
				s.setTrouserId(resultSet.getString(1));
				s.setTrouserColour(resultSet.getString(2));
				s.setTrouserPrice(resultSet.getDouble(3));
				s.setTrouserSize(resultSet.getString(4));
			}
			
		}
		catch(ClassNotFoundException e) 
		{
			System.out.println(e);
		}
		
		return s;
		
	}
	@Override
	public Trouser deleteTrouser(String tid) throws SQLException, IOException 
	{
		Trouser t = new Trouser();
		try
		{
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = null;
			ResultSet resultSet=null;
			Statement stmt=conn.createStatement();
			
			pstmt=conn.prepareStatement("delete from trouser_details where trouser_id=?");
			
			pstmt.setString(1, tid);
			
		}
		catch(ClassNotFoundException e) 
		{
			System.out.println(e);
		}
		
		return t;
	}


	

	

	

}
