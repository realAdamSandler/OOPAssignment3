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
	
	private ReusaxCorp company = new ReusaxCorp();
	
    public void run() {
        int option;
        do {
            printMenuOptions();
            Print.printString(" Type the option number: ");
             
            option = Print.readInt();
            
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
            	promote();
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
 
    //Registering
    public void register() {
       
    	String name, id, degree, department;
        double grossSalary;
    	int GPA, choice;
    	
    	do {

            choice = Print.registerMenu();
        
    			switch (choice) {
    			
    			case 1:
    		        name = Print.enterName();
    		        id = Print.enterId();
    		        grossSalary = Print.enterGrossSalary();

    		        company.registerEmployee(name, id, grossSalary);
    				break;
    				
    			case 2:
    		        name = Print.enterName();
    		        id = Print.enterId();
    		        grossSalary = Print.enterGrossSalary();
    		        GPA = Print.enterGPA();
    		 
    		        company.registerIntern(name, id, grossSalary, GPA);
    				break;
    				
    			case 3:
    		        name = Print.enterName();
    		        id = Print.enterId();
    		        grossSalary = Print.enterGrossSalary();
    		        degree = Print.enterDegree();
    		 
    		        company.registerManager(name, id, grossSalary, degree);
    				break;
    				
    			case 4:
    				 name = Print.enterName();
    			     id = Print.enterId();
    			     grossSalary = Print.enterGrossSalary();
    			     degree = Print.enterDegree();
    			     department = Print.enterDepartment();
    			 
    			     company.registerDirector(name, id, grossSalary, degree, department);
    				break;
    				
    			case 5:
    				System.out.println();
    				break;
    				
    			default:
    				Print.printString("Option "+choice+" is not valid.");
                    break;
    			}
    	} while (choice != 5);
    }

    //EmployeeSpecific
    public void removeEmployee() {
    	String employeeID = Print.readEmployeeID();
    	Employee foundEmployee = company.retrieveEmployee(employeeID);
    	
    	if(foundEmployee != null) {
    		company.removeEmployee(foundEmployee);
    		System.out.println("Employee " + foundEmployee.getName() + " with ID " + foundEmployee.getId() + " has been removed.");
    	} else {
    		System.out.println("An employee of " + employeeID + " is not registered in the system.");
    	}
    }
    
	public void printEmployee() {
		String employeeID = Print.readEmployeeID();
		Employee foundEmployee = company.retrieveEmployee(employeeID);
		
		if (foundEmployee != null) {
			company.printEmployee(foundEmployee);
		} else {
			System.out.println("An employee of " + employeeID + " is not registered in the system.");
		}
		
	}
	
	public void updateEmployee() {
	 	String employeeID = Print.readEmployeeID();     
	 	Employee foundEmployee = company.retrieveEmployee(employeeID);
     
	 	int choice;
	 	do {
    		
            choice = Print.updatingEmployee();
	 		
	 		switch (choice) {
	 		
	 		case 1://Name
	 			company.updateName(foundEmployee, Print.enterName());
	 			break;
	 			
	 		case 2://Gross Salary
	 			company.updateGrossSalary(foundEmployee, Print.enterGrossSalary());
	 			break;
	 			
	 		case 3://GPA
	 			if (foundEmployee.getClass() == Intern.class) {
	 				company.updateGPA(foundEmployee, Print.enterGPA());
	 			} else {
	 				Print.printString("This option is only available for Interns");
	 			}
	 			break;
	 			
	 		case 4://Degree
	 			
	 			if (foundEmployee.getClass() == Manager.class || foundEmployee.getClass() == Director.class) {
	 				company.updateDegree(foundEmployee, Print.enterDegree());
	 			} else {
	 				Print.printString("This option is only available for Managers or Directors");
	 			}	
	 			break;
	 			
	 		case 5://Department
	 			
	 			if (foundEmployee.getClass() == Director.class) {
	 				company.updateDepartment(foundEmployee, Print.enterDepartment());
	 			} else {
	 				Print.printString("This option is only available for Directors");
                }
	 			break;

	 		case 6://Quit
	 			System.out.println();
	 			break;	
	 			
	 		default:
	 			Print.printString("Option "+choice+" is not valid.");
                break;
	 		}
	} while (choice != 6);
}

	//Promotion
	public void promote() {
    	String name, id, degree, department;
        double totGross;
    	int GPA, choice;
		
		String employeeID = Print.readEmployeeID();  
		if (company.retrieveEmployee(employeeID) == null) {
			Print.printString("This employee does not exist");
		} else {
			Employee foundEmployee = company.retrieveEmployee(employeeID);
		
			do {
    		
				choice = Print.enterPromotion();
	 		
				switch (choice) {
				case 1:
					name = foundEmployee.getName();
					totGross = foundEmployee.getTotGross();
	 			
					company.promoteToEmployee(foundEmployee, name, employeeID, totGross);
					break;
	 			
				case 2:
					if (foundEmployee.getClass() == Intern.class) {
						Print.printString("Employee with ID " + employeeID + " is already an Intern");
					} else {
						name = foundEmployee.getName();
						totGross = foundEmployee.getTotGross();

						if (foundEmployee.getClass() == Intern.class) {
							GPA = ((Intern) foundEmployee).getGPA();
						} else {
							GPA = Print.enterGPA();
						}
						company.promoteToIntern(foundEmployee, name, employeeID, totGross, GPA);
					}
					break;
	 			
				case 3:
					if (foundEmployee.getClass() == Manager.class) {
						Print.printString("Employee with ID " + employeeID + " is already a Manager");
					} else {
						name = foundEmployee.getName();
						totGross = foundEmployee.getTotGross();

						if (foundEmployee.getClass() == Director.class) {
							degree = ((Director) foundEmployee).getDegree();
						} else {
							degree = Print.enterDegree();
						}
						company.promoteToManager(foundEmployee, name, employeeID, totGross, degree);
					}
					break;
	 			
				case 4:
					if (foundEmployee.getClass() == Director.class) {
						Print.printString("Employee with ID " + employeeID + " is already a Director");
					} else {
						name = foundEmployee.getName();
						totGross = foundEmployee.getTotGross();
						department = Print.enterDepartment();
	 			
						if (foundEmployee.getClass() == Manager.class) {
							degree = ((Manager) foundEmployee).getDegree();
						} else {
							degree = Print.enterDegree();	
						}
						company.promoteToDirector(foundEmployee, name, employeeID, totGross, degree, department);
					}
					break;
	 			
				case 5://Quit
					System.out.println();
					break;
	 			
				default:
					Print.printString("Option "+choice+" is not valid.");
					break;
				}
			} while (choice != 5);
		}
	}   
}
