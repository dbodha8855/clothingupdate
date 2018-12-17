package com.cg.clothing.service;

import java.io.IOException;
import java.sql.SQLException;

import com.cg.clothing.bean.Shirt;
import com.cg.clothing.bean.Trouser;

public interface IClothingService 
{
	public String addShirt(Shirt shirt) throws SQLException, IOException;
	public String addTrouser(Trouser trouser) throws SQLException, IOException;
	public Shirt selectShirt(String sid) throws SQLException, IOException;
	public Shirt deleteShirt(String sid) throws SQLException, IOException;
	public Trouser selectTrouser(String tid) throws SQLException, IOException;
	public Trouser deleteTrouser(String tid) throws SQLException, IOException;

}
