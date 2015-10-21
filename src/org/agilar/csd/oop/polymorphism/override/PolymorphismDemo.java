package org.agilar.csd.oop.polymorphism.override;

public class PolymorphismDemo {

	public static void main(String[] args) {
		Salary s = new Salary("Mohd Mohtashim", "Ambehta, UP", 3, 3600.00);
		Employee e = new Salary("John Adams", "Boston, MA", 2, 2400.00);
		Employee e2 = new Employee("David Jameson", "Miami, FL", 1); 
		System.out.println("Call mailCheck using Salary reference --");
		s.mailCheck();
		System.out.println("\n Call mailCheck using Employee reference--");
		e.mailCheck();
		System.out.println("\n Call mailCheck using Employee reference--");
		e2.mailCheck();
	}
}
