package com.cg.clothing.pl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.cg.clothing.bean.IClothing;
import com.cg.clothing.bean.Shirt;
import com.cg.clothing.bean.Trouser;
import com.cg.clothing.exception.ClothingException;
import com.cg.clothing.service.ClothingServiceImpl;
import com.cg.clothing.service.IClothingService;


public class ClothingMain {
	 static IClothingService ics=null;
	static ClothingServiceImpl cimpl=null;
	 static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws SQLException, IOException, ClothingException
	{
		IClothing iclothingShirt=new Shirt();
		IClothing iclothingTrouser=new Trouser();
		Shirt shirt=null;
		String shirtId=null;
		Trouser trouser=null;
		String trouserId=null;
		
		
		
		
		
		System.out.println("----------------->CLOTHING<--------------------\n");
		System.out.println("1.Shirt");
		System.out.println("2.Trouser");
		System.out.println("Select an option");
		
		int option=sc.nextInt();
		
		switch(option)
		{
		case 1:
			System.out.println("1.Add Shirt");
			System.out.println("2.Retrive Shirt");
			System.out.println("3.Delete Shirt");
			System.out.println("4.Exit");
			System.out.println("enter the option to perform the action..");
			int optionInner=sc.nextInt();
		switch(optionInner)
		{
		case 1:
			while (shirt==null)
		{
			shirt=populateShirt();
		}
		ics=new ClothingServiceImpl();
		System.out.println(shirt);
		String shirt1=ics.addShirt(shirt);
		
		System.out.println("shirt id is: "+shirtId);
		break;
		case 2:
			System.out.println("Enter the id of shirt to fetch details..");
			String sid=sc.next();
			 cimpl= new ClothingServiceImpl();
			if(cimpl.validateShirtId(sid))
			{
				
				Shirt s=cimpl.selectShirt(sid);
				System.out.println(s);
				
			}
			break;
		case 3:
			System.out.println("Enter the id to be deleted:");
			String sidd=sc.next();
			cimpl= new ClothingServiceImpl();
			if(cimpl.validateTrouserId(shirtId));
			{
				Shirt s =cimpl.deleteShirt(sidd);
				System.out.println(s);
			}
			break;
		case 4:
			System.exit(0);
			break;
		}
		case 2:
			System.out.println("1.Add Trouser");
			System.out.println("2.Retrive Trouser");
			System.out.println("3.Delete Trouser");
			System.out.println("4.Exit");
			System.out.println("enter the option to perform the action..");	
			
			int optionInner2=sc.nextInt();
			switch(optionInner2)
			{
			case 1:
				while (trouser==null)
				{
					trouser=populateTrouser();
				}
				ics=new ClothingServiceImpl();
				String trouser1=ics.addTrouser(trouser);
				System.out.println("trouser id is: "+trouserId);
				break;
				case 2:
					System.out.println("Enter the id of trouser to fetch details..");
					String tid=sc.next();
					if(cimpl.validateShirtId(tid))
					{
						Trouser t=cimpl.selectTrouser(tid);
						System.out.println(t);
					}
					break;
				case 3:
					System.out.println("Enter the id to be deleted:");
					String sidd=sc.next();
					if(cimpl.validateTrouserId(shirtId));
					{
						Shirt s =cimpl.deleteShirt(sidd);
						System.out.println(s);
					}
					break;
				case 4:
					System.exit(0);
					break;
				}
			}
			
			
		}
	
		
		private static Shirt populateShirt() throws ClothingException 
		{
			Shirt shirt = new Shirt();
			System.out.println("Enter shirt details:");
			
			System.out.println("Enter the shirt price:");
			shirt.setShirtPrice(sc.nextDouble());
			
			System.out.println("enter shirt size:");
			shirt.setShirtSize(sc.next());
			
			System.out.println("Enter shirt colour:");
			shirt.setShirtColour(sc.next());
			
			
			
			IClothingService cimpl=new ClothingServiceImpl();
			
			((ClothingServiceImpl) cimpl).validateShirt(shirt);
			System.out.println(shirt);
				return shirt;
			
		}
		private static Trouser populateTrouser() throws ClothingException 
		{
			Trouser trouser = new Trouser();
			System.out.println("Enter trouser details:");
			
			System.out.println("Enter the trouser price:");
			trouser.setTrouserPrice(sc.nextDouble());
			
			System.out.println("enter trouser size:");
			trouser.setTrouserSize(sc.next());
			
			System.out.println("Enter trouser colour:");
			trouser.setTrouserColour(sc.next());
			
			
			
			IClothingService cimpl=new ClothingServiceImpl();
			
			((ClothingServiceImpl) cimpl).validateTrouser(trouser);
				return trouser;
			
		}
}
