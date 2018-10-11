package reusaxcorp;

import java.util.ArrayList;
import java.util.Scanner;

public class ReusaxCorpMain {
	
	private static final int REGISTER_EMPLOYEE = 1;
    private static final int REMOVE_EMPLOYEE = 2;
    private static final int RETRIEVE_EMPLOYEE = 3;
    private static final int UPDATE_EMPLOYEES = 4;
    private static final int GROSS_SALARIES = 5;
    private static final int NET_SALARIES = 6;
    private static final int TOTAL_EMPLOYEES = 7;
    private static final int QUIT = 8;
    	
    private Scanner input;
    private ArrayList<Employee> employees;
    
    public ReusaxCorpMain() {
    	this.employees = new ArrayList<Employee>();
    	input = new Scanner(System.in);
    }
    
    
    
    public void run() {
        int option;
        do {
            printMenuOptions();
            System.out.print(" Type the option number: ");
             
            option = input.nextInt();
            input.nextLine(); 
            
            switch (option) {
            
            case REGISTER_EMPLOYEE:
                
                break;
            
            case REMOVE_EMPLOYEE:
                              
                break;

            case RETRIEVE_EMPLOYEE:
                
            	break;

            case UPDATE_EMPLOYEES:
                
                break;

            case GROSS_SALARIES:
                
                break;
                
            case NET_SALARIES:
                
                break;
                
            case TOTAL_EMPLOYEES:
                
                break;
                
            case QUIT://Fix this??
            	System.out.println("\n Thank you for using ReusaxCorp Employee Management System. See you soon!");
				System.out.println();
            	break;
        
            default:
                System.out.println("Option "+option+" is not valid.");
                System.out.println();
                break;
            }
        } while (option != QUIT);
    }

    private void printMenuOptions() {
        final String endOfLine = System.lineSeparator();
            String printStart = " === ReusaxCorp === "+ endOfLine;
            printStart += " ➤ 1. Register an employee " + endOfLine;
            printStart += " ➤ 2. Remove an employee " + endOfLine;
            printStart += " ➤ 3. Retrieve an employee " + endOfLine;
            printStart += " ➤ 4. Update employees " + endOfLine;
            printStart += " ➤ 5. Calculate gross salaries " + endOfLine;
            printStart += " ➤ 6. Calculate net salaries " + endOfLine;
            printStart += " ➤ 7. View total number of employees " + endOfLine;
            printStart += " ➤ 8. Quit this program " + endOfLine;

            System.out.println(printStart);

    }
    
    public static void main(String[] args) {
		ReusaxCorpMain program = new ReusaxCorpMain();
		program.run();
	}

}
