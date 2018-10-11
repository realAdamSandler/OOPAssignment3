package reusaxcorp;

import java.util.ArrayList;
import java.util.Scanner;

public class ReusaxCorpMain {
	
	private static final int REGISTER_EMPLOYEE = 1;
    private static final int REMOVE_EMPLOYEE = 2;
    private static final int PRINT_EMPLOYEE = 3;
    private static final int UPDATE_EMPLOYEES = 4;
    private static final int GROSS_SALARIES = 5;
    private static final int NET_SALARIES = 6;
    private static final int TOTAL_EMPLOYEES = 7;
    private static final int QUIT = 8;
    	
    public static Scanner input;
    private ArrayList<Employee> employees;
    
    public ReusaxCorpMain() {
    	this.employees = new ArrayList<Employee>();
    	input = new Scanner(System.in);
    	
    	
    	Employee employee1 = new Employee("John", "ABC", 123.0);
    	employees.add(employee1);
    	
    }
    
    public void register() {
       
    	int choice;
    	do {
    	
    		final String endOfLine = System.lineSeparator();
    		String printStart = " Choose what you want to register: "+ endOfLine;
    		printStart += " ➤ 1. Employee " + endOfLine;
    		printStart += " ➤ 2. Intern " + endOfLine;
    		printStart += " ➤ 3. Manager " + endOfLine;
    		printStart += " ➤ 4. Director " + endOfLine;
    		printStart += " ➤ 5. Back to main menu " + endOfLine;
    		System.out.println(printStart);
    		
            choice = input.nextInt();
            input.nextLine();
    		
        
    			switch (choice) {
    			
    			case 1:
                    Employee newEmployee = Employee.registerEmployee();
                    employees.add(newEmployee);
    				break;
    				
    			case 2:
    				Intern newIntern = Intern.registerIntern();
    				employees.add(newIntern);
    				break;
    				
    			case 3:
    				Manager newManager = Manager.registerManager();
    				employees.add(newManager);
    				break;
    				
    			case 4:
    				Director newDirector = Director.registerDirector();
    				employees.add(newDirector);
    				break;
    				
    			case 5:
    				System.out.println();
    				break;
    				
    			default:
    				System.out.println("Option "+choice+" is not valid.");
                    System.out.println();
                    break;
        
    			}
        
        
    	} while (choice != 5);
        
    }
    
    public String readEmployeeID() {
        System.out.print("Enter ID of employee: ");
        String employeeID = input.nextLine();
        return employeeID;
    }
    
    public void removeEmployee() {
    	String employeeID = readEmployeeID();
    	Employee foundEmployee = retrieveEmployee(employeeID);
    	
    	if(foundEmployee != null) {
    		employees.remove(foundEmployee);
    		System.out.println("Employee " + foundEmployee.getName() + " with ID " + foundEmployee.getId() + " has been removed.");
    	} else {
    		System.out.println("An employee of " + employeeID + " is not registered in the system.");
    	}
    }
    
	public Employee retrieveEmployee(String employeeID) {
		for (int i = 0; i < this.employees.size(); i++) {
			if(employees.get(i) != null && employees.get(i).getId().equals(employeeID)) {
				return employees.get(i);
			}
			
		}return null;
	}
    
	public void printEmployee() {
		String employeeID = readEmployeeID();
		Employee foundEmployee = retrieveEmployee(employeeID);
		
		if (foundEmployee != null) {
			System.out.println(foundEmployee);
		} else {
			System.out.println("An employee of " + employeeID + " is not registered in the system.");
		}
		
	}
	
	public void updateEmployee() {
	 	String employeeID = readEmployeeID();     
	 	Employee foundEmployee = retrieveEmployee(employeeID);
     
	 	int choice;
	 	do {
	 		System.out.println("1. Change name \n2. Change gross salary \n3. Return to main menu");
	 		choice = input.nextInt();
	 		input.nextLine();
	 		
	 		switch (choice) {
	 		
	 		case 1:
	 			System.out.println("Edit name: ");
	 			foundEmployee.setName(input.nextLine());
	 			break;
	 			
	 		case 2:
	 			System.out.println("Edit gross salary: ");
	 			foundEmployee.setGrossSalary(input.nextDouble());
	 			input.nextLine();
	 			break;
	 			
	 		case 3:
	 			System.out.println();
	 			break;
	 			
	 		default:
	 			System.out.println("Option "+choice+" is not valid.");
                System.out.println();
                break;
	 		}
	} while (choice != 3);
}
	
	public void totalEmployees() {
		System.out.println("Total number of employees at Reusax Corp: " + employees.size());
	}
	
	public void totalGrossSalaries() {
		Double totalGross = 0.0;
		
		for (int i = 0; i < this.employees.size(); i++) {
			totalGross += employees.get(i).getGrossSalary();
		}
		
		System.out.println("The total gross salary expense is: " + totalGross);
	}
	
	public void totalNetSalaries() {
		Double totalNet = 0.0;
		
		for (int i = 0; i < this.employees.size(); i++) {
			totalNet += employees.get(i).getNetSalary();
		}
		
		System.out.println("The total net salary expense is: " + totalNet);
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
                register();
                break;
            
            case REMOVE_EMPLOYEE:
                removeEmployee();
                break;

            case PRINT_EMPLOYEE:
            	printEmployee();
            	break;

            case UPDATE_EMPLOYEES:
                updateEmployee();
                break;

            case GROSS_SALARIES:
                totalGrossSalaries();
                break;
                
            case NET_SALARIES:
                totalNetSalaries();
                break;
                
            case TOTAL_EMPLOYEES:
                totalEmployees();
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
