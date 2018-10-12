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
    //private ArrayList<Director> directors;
    
    public ReusaxCorpMain() {
    	this.employees = new ArrayList<Employee>();
        //this.directors = new ArrayList<Director>();
    	input = new Scanner(System.in);
    	
    	//Delete this when done testing
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
    				//directors.add(newDirector);
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
    		final String endOfLine = System.lineSeparator();
    		String printStart = " Choose what you want to update: "+ endOfLine;
    		printStart += " ➤ 1. Name " + endOfLine;
    		printStart += " ➤ 2. Gross salary " + endOfLine;
    		printStart += " ➤ 3. GPA of an Intern " + endOfLine;
    		printStart += " ➤ 4. Degree of a Manager/Director " + endOfLine;
    		printStart += " ➤ 5. Department of a Director " + endOfLine;
    		printStart += " ➤ 6. Director's benefit " + endOfLine;
    		printStart += " ➤ 7. Return to main menu " + endOfLine;
    		System.out.println(printStart);
    		
            choice = input.nextInt();
            input.nextLine();
	 		
	 		switch (choice) {
	 		
	 		case 1://Name
	 			System.out.println("Edit name: ");
	 			foundEmployee.setName(input.nextLine());
	 			break;
	 			
	 		case 2://Gross Salary
	 			System.out.println("Edit gross salary: ");
	 			foundEmployee.setGrossSalary(input.nextDouble());
	 			input.nextLine();
	 			break;
	 			
	 		case 3://GPA
	 			if (foundEmployee.getClass() == Intern.class) {
	 				System.out.println("Edit GPA: ");
	 				((Intern) foundEmployee).setGPA(input.nextInt());
	 				input.nextLine();
	 				((Intern) foundEmployee).GPASalary();
	 			} else {
	 				System.out.println("This option is only available for Interns");
	 			}
	 			break;
	 			
	 		case 4://Degree
	 			if (foundEmployee.getClass() == Manager.class || foundEmployee.getClass() == Director.class) {
	 				System.out.println("Edit degree: ");
	 				((Manager) foundEmployee).setDegree(input.nextLine());
	 				((Manager) foundEmployee).bonusSalary();
	 			} else {
	 				System.out.println("This option is only available for Interns");
	 			}
	 			break;
	 			
	 		case 5://Department
	 			if (foundEmployee.getClass() == Director.class) {
	 				System.out.println("Edit Department: ");
	 				((Director) foundEmployee).setDepartment(input.nextLine());
	 			} else {
	 				System.out.println("This option is only available for Interns");
	 			}
	 			break;
	 			
	 		case 6://Benefit
	 			System.out.println("Enter benefit: ");
	 			Employee.setDirectorsBenefit(input.nextDouble());
	 			input.nextLine();
	 			break;
	 			
	 		case 7://Quit
	 			System.out.println();
	 			break;	
	 			
	 		default:
	 			System.out.println("Option "+choice+" is not valid.");
                System.out.println();
                break;
	 		}
	} while (choice != 7);
}
	
	public void totalEmployees() {
		System.out.println("Total number of employees at Reusax Corp: " + employees.size());
	}
	
	public void totalGrossSalaries() {
		Double totalGross = 0.0;
		
		for (int i = 0; i < this.employees.size(); i++) {
			totalGross += employees.get(i).getTotGross();
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
