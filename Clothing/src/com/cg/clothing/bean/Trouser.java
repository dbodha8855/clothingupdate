package com.cg.clothing.bean;

public class Trouser implements IClothing
{
	private String trouserId;
	private double trouserPrice;
	private String trouserSize;
	private String trouserColour;
	public String getTrouserId() {
		return trouserId;
	}
	public void setTrouserId(String trouserId) {
		this.trouserId = trouserId;
	}
	public double getTrouserPrice() {
		return trouserPrice;
	}
	public void setTrouserPrice(double trouserPrice) {
		this.trouserPrice = trouserPrice;
	}
	public String getTrouserSize() {
		return trouserSize;
	}
	public void setTrouserSize(String trouserSize) {
		this.trouserSize = trouserSize;
	}
	public String getTrouserColour() {
		return trouserColour;
	}
	public void setTrouserColour(String trouserColour) {
		this.trouserColour = trouserColour;
	}
	@Override
	public String toString() {
		return "Trouser [trouserId=" + trouserId + ", trouserPrice=" + trouserPrice + ", trouserSize=" + trouserSize
				+ ", trouserColour=" + trouserColour + "]";
	}
	
	
}
