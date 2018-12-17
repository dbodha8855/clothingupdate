package com.cg.clothing.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.clothing.bean.Shirt;
import com.cg.clothing.bean.Trouser;
import com.cg.clothing.dao.IShirtDao;
import com.cg.clothing.dao.ITrouserDao;
import com.cg.clothing.dao.ShirtDaoImpl;
import com.cg.clothing.dao.TrouserDaoImpl;

public class ClothingServiceImpl implements IClothingService
{
	static IShirtDao is=null;
	static ITrouserDao it = null;
	@Override
	public String addShirt(Shirt shirt) throws SQLException, IOException 
	{
	is=new ShirtDaoImpl();
		String shirtSeq=is.addShirt(shirt);
		return shirtSeq;
	}
	@Override
	public String addTrouser(Trouser trouser) throws SQLException, IOException 
	{
		it=new TrouserDaoImpl();
		String trouserSeq=it.addTrouser(trouser);
		return trouserSeq;
	}
	@Override
	public Shirt deleteShirt(String sid) throws SQLException, IOException 
	{
		Shirt s =new Shirt();
		is=new ShirtDaoImpl();
		s=is.deleteShirt(sid);
		return s;
		
	}

	@Override
	public Shirt selectShirt(String sid) throws SQLException, IOException 
	{
		
		Shirt s = new Shirt();
		is= new ShirtDaoImpl();
	  s=is.selectShirt(sid);
		return s;
		
	}
	@Override
	public Trouser selectTrouser(String tid) throws SQLException, IOException 
	{
		Trouser t = new Trouser();
		it= new TrouserDaoImpl();
		t=it.selectTrouser(tid);
		return t;
		
	}
	@Override
	public Trouser deleteTrouser(String tid) throws SQLException, IOException 
	{
		Trouser t =new Trouser();
		it=new TrouserDaoImpl();
		t=it.deleteTrouser(tid);
		return t;
		
	}
	
	
	public void validateShirt(Shirt shirt)
	{
		List<String> validationErorrs = new ArrayList<String>();
		if(!(isvalidShirtPrice(shirt.getShirtPrice())))
		{
			validationErorrs.add("\n entered shirt price should be greater than 0");		
		}
		if(!(isValidShirtSize(shirt.getShirtSize())))
		{
			validationErorrs.add("\n entered shirt size is not valid");		
		}
		if(!(isValidShirtColour(shirt.getShirtColour())))
		{
			validationErorrs.add("\n entered shirt colour is not in the list");		
		}
	}
	public boolean isvalidShirtPrice(double shirtPrice)
	{
		return shirtPrice>0;
	}
	public boolean isValidShirtSize(String shirtSize)
	{
		Pattern sizePattern=Pattern.compile("\b(S|M)\b");
		Matcher sizeMatcher=sizePattern.matcher(shirtSize);
		return sizeMatcher.matches();
	}
	public boolean isValidShirtColour(String shirtColour)
	{
		Pattern colourPattern=Pattern.compile("\b(Red|Green)\b");
		Matcher colourMatcher=colourPattern.matcher(shirtColour);
		return colourMatcher.matches();
		
	}
	public boolean validateShirtId(String shirtId)
	{
		Pattern idPattern=Pattern.compile("[0-9]*{1,}");
		Matcher idMatcher=idPattern.matcher(shirtId);
		if(idMatcher.matches())
		{
			return true;
		}
		else
			return false;
	}
	
	public void validateTrouser(Trouser trouser)
	{
		List<String> validationErorrs = new ArrayList<String>();
		if(!(isvalidTrouserPrice(trouser.getTrouserPrice())))
		{
			validationErorrs.add("\n entered trouser price should be greater than 0");		
		}
		if(!(isValidTrouserSize(trouser.getTrouserSize())))
		{
			validationErorrs.add("\n entered trouser size is not valid");		
		}
		if(!(isValidTrouserColour(trouser.getTrouserColour())))
		{
			validationErorrs.add("\n entered trouser colour is not in the list");		
		}
	}
	public boolean isvalidTrouserPrice(double trouserPrice)
	{
		return trouserPrice>0;
	}
	public boolean isValidTrouserSize(String trouserSize)
	{
		Pattern sizePattern=Pattern.compile("\b(S|M)\b");
		Matcher sizeMatcher=sizePattern.matcher(trouserSize);
		return sizeMatcher.matches();
	}
	public boolean isValidTrouserColour(String trouserColour)
	{
		Pattern colourPattern=Pattern.compile("\b(Red|Green)\b");
		Matcher colourMatcher=colourPattern.matcher(trouserColour);
		return colourMatcher.matches();
		
	}
	public boolean validateTrouserId(String trouserId)
	{
		Pattern idPattern=Pattern.compile("[0-9]*{1,}");
		Matcher idMatcher=idPattern.matcher(trouserId);
		if(idMatcher.matches())
		{
			return true;
		}
		else
			return false;
	}
	
}
