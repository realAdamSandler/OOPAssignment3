package reusaxcorp;

import java.util.ArrayList;

public class Director extends Manager{

	private String department;
	//private static Double benefit = 0.0;
	
	public Director(String name, String id, Double grossSalary, String degree, String department) {
		super(name, id, grossSalary, degree);
		this.department = department;
	}
	
	@Override
	public String toString() {
		final String endOfLine = System.lineSeparator();
        String printThis = "ID: " + getId() + endOfLine;
        printThis += "Name: " + getName() + endOfLine;
        printThis += "Position: Director" + endOfLine;
        printThis += "Degree: " + getDegree() + endOfLine;
        printThis += "Department: " + getDepartment() + endOfLine;
        printThis += "Gross salary: " + getTotGross() + " SEK" + endOfLine;
        printThis += "Net salary: " + getNetSalary() + " SEK" +endOfLine;
        return printThis;
	}
	
	public static Director registerDirector() {
	   	 
        //parameters to read for the Employee-constructor
        String name, id, degree = null, department = null;
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

        int choice1;

    		printStart = " Enter the department of your new employee: "+ endOfLine;
    		printStart += " ➤ 1. Human Resources " + endOfLine;
    		printStart += " ➤ 2. Technical " + endOfLine;
    		printStart += " ➤ 3. Business " + endOfLine;
    		System.out.println(printStart);
    		
            choice1 = ReusaxCorpMain.input.nextInt();
            ReusaxCorpMain.input.nextLine();
        
    			switch (choice1) {
    			
    			case 1:
                    department = "Human Resources";
    				break;
    				
    			case 2:
    				department = "Technical";
    				break;
    				
    			case 3:
    				department = "Business";
    				break;
    				
    			default:
    				System.out.println("Option "+choice1+" is not valid.");
                    System.out.println();
                    break;
    			}
 
        //Creating an object of Employee with given input and returning it
        Director newDirector = new Director(name, id, grossSalary, degree, department);
        
		return newDirector;
	}
	
	@Override
	public Double getNetSalary() {
		Double netSalary;
		Double tempTotGross = this.totGross();
		
		if ( tempTotGross < 30000) {
			netSalary = tempTotGross - (tempTotGross * 0.10);
			return netSalary;
			
		} else if ( 30000 <= tempTotGross && tempTotGross <= 50000 ) {
			netSalary = tempTotGross - (tempTotGross * 0.20);
			return netSalary;
			
		} else if ( tempTotGross > 50000 ) {
			Double grossSalaryOver30 = tempTotGross - 30000;
			netSalary = ( grossSalaryOver30 - ( grossSalaryOver30 * 0.40 ) ) + ( 30000 - ( 30000 * 0.20 ) );
			return netSalary;
		} else {
			return null;
		}
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
