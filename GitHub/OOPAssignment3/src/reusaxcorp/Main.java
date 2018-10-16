package reusaxcorp;

public class Main {
	
	private static final int REGISTER_EMPLOYEE = 1;
    private static final int REMOVE_EMPLOYEE = 2;
    private static final int PRINT_EMPLOYEE = 3;
    private static final int UPDATE_EMPLOYEES = 4;
    private static final int GROSS_SALARIES = 5;
    private static final int NET_SALARIES = 6;
    private static final int TOTAL_EMPLOYEES = 7;
    private static final int UPDATE_BENEFIT = 8;
    private static final int PROMOTION = 9;
    private static final int QUIT = 10;
	
	ReusaxCorp company = new ReusaxCorp();
	
    public void run() {
        int option;
        do {
            printMenuOptions();
            Print.printString(" Type the option number: ");
             
            option = Print.readInt();
            
            switch (option) {
            
            case REGISTER_EMPLOYEE:
                company.register();
                break;
            
            case REMOVE_EMPLOYEE:
            	company.removeEmployee();
                break;

            case PRINT_EMPLOYEE:
            	company.printEmployee();
            	break;

            case UPDATE_EMPLOYEES:
            	company.updateEmployee();
                break;

            case GROSS_SALARIES:
            	company.totalGrossSalaries();
                break;
                
            case NET_SALARIES:
            	company.totalNetSalaries();
                break;
                
            case TOTAL_EMPLOYEES:
            	company.totalEmployees();
                break;
                
            case UPDATE_BENEFIT:
	 			Employee.setDirectorsBenefit(Print.updatingBenefit());
                break;  
                
            case PROMOTION:
            	company.promote();
            	break;
                
            case QUIT://Fix this??
            	Print.printString("\n Thank you for using ReusaxCorp Employee Management System. See you soon!");
            	break;
        
            default:
                Print.printString("Option "+option+" is not valid.");
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
            printStart += " ➤ 8. Update director's benefit " + endOfLine;
            printStart += " ➤ 9. Promote an employee " + endOfLine;
            printStart += " ➤ 10. Quit this program " + endOfLine;

            System.out.println(printStart);

    }
    
    public static void main(String[] args) {
		Main program = new Main();
    	program.run();
	}

}
