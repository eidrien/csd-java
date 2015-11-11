package org.agilar.csd.oop.naming;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class BadNaming { 
	
	
	int days = 3; //elapsed time in days
	List<int[]> theList;
	Set playerList = new HashSet();
	
	public List<int[]> getThem(){
		List<int[]> list1 = new ArrayList<int[]>();
		for(int[] x : theList){
			if(x[0] == 4){
				list1.add(x);
			}
		}
		return list1;
	}
	
	//Meaningfull names??
	public static void copyChars (char a1[], char a2[]){
		for(int i=0; i<a1.length; i++){
			a2[i] = a1[i];
		}
	}
	
	public abstract String getPlayerInfo();
	public abstract String getPlayerDetails();
	public abstract String getAllPlayerInfo();
	public abstract String getPlayerDataFast();

	//Noise words
	List<int[]> gameBoardInfo;
	String aPlayer;
	String playerStr;
	
	//Unpronounceable Names
	private Date genymdhms; //generation year, month, day, hour, minute, seconds --> no one can read this
	
	//Non-searchable names
	int[] t;
	public int calculateWork(String customerType){
		int s=0;
		if(customerType.equals("G")){
			for(int h=0; h<34; h++){
				s += t[h]*4/5;
			}
		}
		return 0;
	}
	
	//Use variable names for a single purpose
	public void computeRoots(double a, double b, double c, double[] roots){
		double tmp = Math.sqrt(b*b - 4*a*c);
		roots[0] = (-b + tmp)/(2*a);
		roots[1] = (-b - tmp)/(2*a);
		
		//swap roots
		tmp = roots[0];
		roots[0] = roots[1];
		roots[1] = tmp;
	}
	
	//Variables names should have all context necessary;
	String firstName, LastName, street, houseNumber, city, state, zipCode;
	
}
