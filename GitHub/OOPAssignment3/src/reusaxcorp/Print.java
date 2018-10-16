package reusaxcorp;

import java.util.Scanner;

public class Print {
	
	private static String printStart;
	private static final String endOfLine = System.lineSeparator();
	
	private static Scanner input = new Scanner(System.in);
	
	public static String enterName() {
        System.out.println("Enter the name of your new employee:");
        return input.nextLine();
	}

	public static String enterId() {
        System.out.println("Enter the ID of your new employee");
        return input.nextLine();
	}
	
	public static Double enterGrossSalary() {
        System.out.println("Enter the salary of your new employee:");
        Double x = input.nextDouble();
        input.nextLine();
        return x;
	}
	
	public static int enterGPA() {
		 System.out.println("Enter the GPA of your new employee (0 - 10) : ");
        int GPA = input.nextInt();
        input.nextLine();
        
        return GPA;
	}
	
	public static int enterDegree() {
		printStart = " Enter the degree of your new employee: "+ endOfLine;
		printStart += " ➤ 1. BSc. " + endOfLine;
		printStart += " ➤ 2. MSc. " + endOfLine;
		printStart += " ➤ 3. PhD " + endOfLine;
		System.out.println(printStart);
	
		int choice = input.nextInt();
    	input.nextLine();
    
    	return choice;
	}
	
	public static int enterPromotion() {
		printStart = " Enter what you want to promote to: "+ endOfLine;
		printStart += " ➤ 1. Employee " + endOfLine;
		printStart += " ➤ 2. Intern " + endOfLine;
		printStart += " ➤ 3. Manager " + endOfLine;
		printStart += " ➤ 4. Director " + endOfLine;
		printStart += " ➤ 5. Go back to main menu " + endOfLine;
		System.out.println(printStart);
	
		int choice = input.nextInt();
    	input.nextLine();
    
    	return choice;
	}
	
	public static int enterDepartment() {
		printStart = " Enter the department of your new employee: "+ endOfLine;
		printStart += " ➤ 1. Human Resources " + endOfLine;
		printStart += " ➤ 2. Technical " + endOfLine;
		printStart += " ➤ 3. Business " + endOfLine;
		System.out.println(printStart);
	
		int choice1 = input.nextInt();
		input.nextLine();
    
		return choice1;
	}
	
	public static int updatingEmployee() {
		printStart = " Choose what you want to update: "+ endOfLine;
		printStart += " ➤ 1. Name " + endOfLine;
		printStart += " ➤ 2. Gross salary " + endOfLine;
		printStart += " ➤ 3. GPA of an Intern " + endOfLine;
		printStart += " ➤ 4. Degree of a Manager/Director " + endOfLine;
		printStart += " ➤ 5. Department of a Director " + endOfLine;
		printStart += " ➤ 6. Return to main menu " + endOfLine;
		System.out.println(printStart);
		
        int choice = input.nextInt();
        input.nextLine();
        
        return choice;
	}

	public static int registerMenu() {
		printStart = " Choose what you want to register: "+ endOfLine;
		printStart += " ➤ 1. Employee " + endOfLine;
		printStart += " ➤ 2. Intern " + endOfLine;
		printStart += " ➤ 3. Manager " + endOfLine;
		printStart += " ➤ 4. Director " + endOfLine;
		printStart += " ➤ 5. Back to main menu " + endOfLine;
		System.out.println(printStart);
		
        int choice = input.nextInt();
        input.nextLine();
        
        return choice;
	}

	public static void printString(String string) {
		System.out.println(string);
        System.out.println();
	}
	
	public static String readId() {
        System.out.print("Enter ID of employee: ");
        String employeeID = input.nextLine();
        return employeeID;
	}

	public static int readInt() {
        int option = input.nextInt();
        input.nextLine(); 
        return option;
	}
	
	public static Double updatingBenefit() {
    	System.out.println("Enter benefit: ");
		Double benefit = input.nextDouble();
		input.nextLine();
		
		return benefit;
	}
}
