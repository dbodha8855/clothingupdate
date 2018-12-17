package com.cg.clothing.bean;

public class Shirt implements IClothing
{
	private String shirtId;
	private double shirtPrice;
	private String shirtSize;
	private String shirtColour;
	public String getShirtId() {
		return shirtId;
	}
	public void setShirtId(String shirtId) {
		this.shirtId = shirtId;
	}
	public double getShirtPrice() {
		return shirtPrice;
	}
	public void setShirtPrice(double shirtPrice) {
		this.shirtPrice = shirtPrice;
	}
	public String getShirtSize() {
		return shirtSize;
	}
	public void setShirtSize(String shirtSize) {
		this.shirtSize = shirtSize;
	}
	public String getShirtColour() {
		return shirtColour;
	}
	public void setShirtColour(String shirtColour) {
		this.shirtColour = shirtColour;
	}
	@Override
	public String toString() {
		return "Shirt [shirtId=" + shirtId + ", shirtPrice=" + shirtPrice + ", shirtSize=" + shirtSize
				+ ", shirtColour=" + shirtColour + "]";
	}
	
	
	
}
