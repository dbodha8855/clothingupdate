package com.cg.clothing.dao;

import java.io.IOException;
import java.sql.SQLException;

import com.cg.clothing.bean.Shirt;

public interface IShirtDao 
{
	public String addShirt(Shirt shirt) throws SQLException, IOException;
	Shirt selectShirt(String sid) throws SQLException, IOException;
	Shirt deleteShirt(String sid) throws SQLException, IOException;
	
}
