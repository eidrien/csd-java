package org.agilar.csd.register;

public class Fruit {

	private String name;
	private int cost;

	public Fruit(String name, int cost){
		this.name = name;
		this.cost = cost;
	}
	
	public String getName(){
		return name;
	}

	public int getCost(){
		return cost;
	}

}
