package org.agilar.csd.oop.naming;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class GoodNaming { 
	
	private static int STATUS_VALUE = 0;
	private static int FLAGGED = 4;

	int elapsedTimeInDays = 3;
	List<int[]> gameBoard;
	Set players = new HashSet();
	
	public List<int[]> getFlaggedCells(){
		List<int[]> flaggedCells = new ArrayList<int[]>();
		for(int[] cell : gameBoard){
			if(cell[STATUS_VALUE] == FLAGGED){
				flaggedCells.add(cell);
			}
		}
		return flaggedCells;
	}
	
	public static void copyAllCharacters(char source[], char destination[]){
		for(int i=0; i<source.length; i++){
			destination[i] = source[i];
		}
	}

	// Pronounceable names
	private Date generationTimestamp;
	
	// Make it easy to search for terms
	int[] taskEstimate;
	int NUMBER_OF_TASKS = 34;
	public int calculateWorkForRetailCustomer(){
		int realDaysPerIdealDay = 4;
		int WORK_DAYS_PER_WEEK = 5;
		int sum = 0;
		for(int j=0; j<NUMBER_OF_TASKS; j++){
			int realTaskDays = taskEstimate[j] * realDaysPerIdealDay;
			int realTaskWeeks = realTaskDays / WORK_DAYS_PER_WEEK;
			sum += realTaskWeeks;
		}
		return sum;
	}
	
	public void computeRootsOfQuadraticEquation(double a, double b, double c, double[] roots){
		double discriminant = Math.sqrt(b*b - 4*a*c);
		roots[0] = (-b + discriminant)/(2*a);
		roots[1] = (-b - discriminant)/(2*a);
		
		swapValues(roots);
	}

	private void swapValues(double[] roots) {
		double oldRoot = roots[0];
		roots[0] = roots[1];
		roots[1] = oldRoot;
	}
	
	//Variables names should have all context necessary;
	String addressFirstName, addressLastName, addressStreet, addressHouseNumber, addressCity, addressState, addressZipCode;
	
	//Or even better;
	class Address{
		String firstName, LastName, street, houseNumber, city, state, zipCode;		
	}

	
	// Class names should not contain verbs
	// Method names should contain verbs
}
