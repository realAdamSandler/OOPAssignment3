package reusaxcorp;

import java.util.ArrayList;

public class Manager extends Employee{

	private String degree;
	
	public Manager(String name, String id, Double grossSalary, String degree) {
		super(name, id, grossSalary);
		this.degree = degree;
		this.bonusSalary();
	}

	public void bonusSalary() {
		
		degree = this.getDegree();
		
		switch (degree) {
		
		case "BSc.":
			this.setTotGross(this.getGrossSalary() + this.getGrossSalary() * 0.10);
			break;
			
		case "MSc.":
			this.setTotGross(this.getGrossSalary() + this.getGrossSalary() * 0.20);
			break;
			
		case "PhD":
			this.setTotGross(this.getGrossSalary() + this.getGrossSalary() * 0.35);
			break;	
		}
	}
	
	@Override
	public String toString() {
		final String endOfLine = System.lineSeparator();
        String printThis = "ID: " + getId() + endOfLine;
        printThis += "Name: " + getName() + endOfLine;
        printThis += "Position: Manager" + endOfLine;
        printThis += "Degree: " + getDegree() + endOfLine;
        printThis += "Gross salary: " + getTotGross() + " SEK" + endOfLine;
        printThis += "Net salary: " + getNetSalary() + " SEK" + endOfLine;
        return printThis;
	}
	
	
	public static Manager registerManager() {
   	 
        //parameters to read for the Employee-constructor
        String name, id, degree = null;
        double grossSalary;
 
        System.out.println("Enter the name of your new employee:");
        name = ReusaxCorpMain.input.nextLine();
        
        System.out.println("Enter the ID of your new employee");
        id = ReusaxCorpMain.input.nextLine();
        
        System.out.println("Enter the salary of your new employee:");
        grossSalary = ReusaxCorpMain.input.nextDouble();
        ReusaxCorpMain.input.nextLine();
        
        int choice;
    	
     		final String endOfLine = System.lineSeparator();
     		String printStart = " Enter the degree of your new employee: "+ endOfLine;
     		printStart += " ➤ 1. BSc. " + endOfLine;
     		printStart += " ➤ 2. MSc. " + endOfLine;
     		printStart += " ➤ 3. PhD " + endOfLine;
     		System.out.println(printStart);
     		
             choice = ReusaxCorpMain.input.nextInt();
             ReusaxCorpMain.input.nextLine();
         
     			switch (choice) {
     			
     			case 1:
                     degree = "BSc.";
     				break;
     				
     			case 2:
     				degree = "MSc.";
     				break;
     				
     			case 3:
     				degree = "PhD";
     				break;
     				
     			default:
     				System.out.println("Option "+choice+" is not valid.");
                     System.out.println();
                     break;
     			}
 
        //Creating an object of Employee with given input and returning it
        Manager newManager = new Manager(name, id, grossSalary, degree);
        
		return newManager;
	}
	
	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	
}
