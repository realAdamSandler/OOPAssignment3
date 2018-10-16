package reusaxcorp;

import java.util.ArrayList;
import java.util.Scanner;

public class ReusaxCorp {
    
    private ArrayList<Employee> employees;
    
    public ReusaxCorp() {
    	this.employees = new ArrayList<Employee>();
        //this.directors = new ArrayList<Director>();
//    	input = new Scanner(System.in);
    	
    	//Delete this when done testing
    	Employee employee1 = new Employee("John", "ABC", 123.0);
    	employees.add(employee1);
    }
    
    public static Employee registerEmployee() {
   	 
        //parameters to read for the Employee-constructor
        String name, id;
        double grossSalary;
        
        name = Print.enterName();
        id = Print.enterId();
        grossSalary = Print.enterGrossSalary();
 
        //Creating an object of Employee with given input and returning it
        Employee employeeRegistered = new Employee(name, id, grossSalary);
        
        return employeeRegistered;
    }
    
    public static Manager registerManager() {
      	 
        //parameters to read for the Employee-constructor
        String name, id, degree = null;
        double grossSalary;
 
        name = Print.enterName();
        id = Print.enterId();
        grossSalary = Print.enterGrossSalary();
        
        int choice;
     		
             choice = Print.enterDegree();
         
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
     				Print.printString("Option "+choice+" is not valid.");
                    break;
     			}
 
        //Creating an object of Employee with given input and returning it
        Manager newManager = new Manager(name, id, grossSalary, degree);
        
		return newManager;
	}
    
    public static Director registerDirector() {
	   	 
        //parameters to read for the Employee-constructor
        String name, id, degree = null, department = null;
        double grossSalary;
 
        name = Print.enterName();
        id = Print.enterId();
        grossSalary = Print.enterGrossSalary();
        
        int choice;
    		
            choice = Print.enterDegree();
        
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
    		
            choice1 = Print.enterDepartment();
        
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
    
    public static Intern registerIntern() {
	   	 
        //parameters to read for the Employee-constructor
        String name, id;
        double grossSalary;
        int GPA;
 
        name = Print.enterName();
        id = Print.enterId();
        grossSalary = Print.enterGrossSalary();
        GPA = Print.enterGPA();
 
        //Creating an object of Employee with given input and returning it
        Intern newIntern = new Intern(name, id, grossSalary, GPA);
        
		return newIntern;
	}
    
    public void register() {
       
    	int choice;
    	do {

            choice = Print.registerMenu();
        
    			switch (choice) {
    			
    			case 1:
                    Employee newEmployee = registerEmployee();
                    employees.add(newEmployee);
    				break;
    				
    			case 2:
    				Intern newIntern = registerIntern();
    				employees.add(newIntern);
    				break;
    				
    			case 3:
    				Manager newManager = registerManager();
    				employees.add(newManager);
    				break;
    				
    			case 4:
    				Director newDirector = registerDirector();
    				employees.add(newDirector);
    				//directors.add(newDirector);
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
    
    public String readEmployeeID() {
        String employeeID = Print.readId();
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
    		
            choice = Print.updatingEmployee();
	 		
	 		switch (choice) {
	 		
	 		case 1://Name
	 			foundEmployee.setName(Print.enterName());
	 			break;
	 			
	 		case 2://Gross Salary
	 			foundEmployee.setGrossSalary(Print.enterGrossSalary());
	 			break;
	 			
	 		case 3://GPA
	 			if (foundEmployee.getClass() == Intern.class) {
	 				((Intern) foundEmployee).setGPA(Print.enterGPA());
	 				((Intern) foundEmployee).GPASalary();
	 			} else {
	 				Print.printString("This option is only available for Interns");
	 			}
	 			break;
	 			
	 		case 4://Degree
	 			
	 			if (foundEmployee.getClass() == Manager.class || foundEmployee.getClass() == Director.class) {
                
                choice = Print.enterDegree();

                switch (choice) {

                        case 1:
                                 ((Manager) foundEmployee).setDegree("BSc.");
                                 ((Manager) foundEmployee).bonusSalary();
                        case 2:
                                 ((Manager) foundEmployee).setDegree("MSc.");
                                 ((Manager) foundEmployee).bonusSalary();
                        case 3:
                                 ((Manager) foundEmployee).setDegree("PhD.");
                                 ((Manager) foundEmployee).bonusSalary();
                }
	 				} else {
                 Print.printString("This option is only available for Managers or Directors");
	 			}	
	 			break;
	 			
	 		case 5://Department
	 			
	 			if (foundEmployee.getClass() == Director.class) {

                choice = Print.enterDepartment();

                switch (choice) {

                        case 1:
                                 ((Director) foundEmployee).setDepartment("Human Resources");
                                 ((Director) foundEmployee).bonusSalary();
                        case 2:
                                 ((Director) foundEmployee).setDepartment("Technical");
                                 ((Director) foundEmployee).bonusSalary();
                        case 3:
                                 ((Director) foundEmployee).setDepartment("Business");
                                 ((Director) foundEmployee).bonusSalary();
                 }
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
	
	public void totalEmployees() {
		Print.printString("Total number of employees at Reusax Corp: " + employees.size());
	}
	
	public void totalGrossSalaries() {
		Double totalGross = 0.0;
		
		for (int i = 0; i < this.employees.size(); i++) {
			totalGross += employees.get(i).getTotGross();
		}
		
		Print.printString("The total gross salary expense is: " + totalGross);
	}
	
	public void totalNetSalaries() {
		Double totalNet = 0.0;
		
		for (int i = 0; i < this.employees.size(); i++) {
			totalNet += employees.get(i).getNetSalary();
		}
		
		Print.printString("The total net salary expense is: " + totalNet);
	}

	public void promote() {
		
		int choice;
		
		String employeeID = readEmployeeID();  
		if (retrieveEmployee(employeeID) == null) {
			Print.printString("This employee does not exist");
		} else {
		
		do {
    		
            choice = Print.enterPromotion();
	 		
	 		switch (choice) {
	 		case 1:
	 			promoteToEmployee(employeeID);
	 			break;
	 			
	 		case 2:
	 			promoteToIntern(employeeID);
	 			break;
	 			
	 		case 3:
	 			promoteToManager(employeeID);
	 			break;
	 			
	 		case 4:
	 			promoteToDirector(employeeID);
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
	
	public void promoteToManager(String employeeID) {
		 
		String degree = null;
		
		Employee foundEmployee = retrieveEmployee(employeeID);
		
		if (foundEmployee.getClass() == Manager.class) {
			Print.printString("Employee with ID " + employeeID + " is already a Manager");
		} else {
		
		String name = foundEmployee.getName();
		Double totGross = foundEmployee.getTotGross();

		if (foundEmployee.getClass() == Director.class) {
			degree = ((Director) foundEmployee).getDegree();
		} else {
			
			int choice;
     		
            choice = Print.enterDegree();
        
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
    				Print.printString("Option "+choice+" is not valid.");
                   break;
    			}
			
		}
		
		Manager newManager = new Manager(name, employeeID, totGross, degree);
		employees.add(newManager);
		employees.remove(foundEmployee);
		}
	}

	public void promoteToDirector(String employeeID) {
		 
		String department = null;
		String degree = null;
		
		Employee foundEmployee = retrieveEmployee(employeeID);

		if (foundEmployee.getClass() == Director.class) {
			Print.printString("Employee with ID " + employeeID + " is already a Director");
		} else {
		
		String name = foundEmployee.getName();
		Double totGross = foundEmployee.getTotGross();

		if (foundEmployee.getClass() == Manager.class) {
			degree = ((Manager) foundEmployee).getDegree();
		} else {
			
			int choice;
     		
            choice = Print.enterDegree();
        
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
    				Print.printString("Option "+choice+" is not valid.");
                   break;
    			}
			
		}
		
        int choice1;
		
        choice1 = Print.enterDepartment();
    
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
		
			Director newDirector = new Director(name, employeeID, totGross, degree, department);
			employees.add(newDirector);
			employees.remove(foundEmployee);
		}
	}

	public void promoteToIntern(String employeeID) {
		int GPA = 0;
		   
		Employee foundEmployee = retrieveEmployee(employeeID);

		if (foundEmployee.getClass() == Intern.class) {
			Print.printString("Employee with ID " + employeeID + " is already an Intern");
		} else {
		
		String name = foundEmployee.getName();
		Double totGross = foundEmployee.getTotGross();

		if (foundEmployee.getClass() == Intern.class) {
			GPA = ((Intern) foundEmployee).getGPA();
		} else {
			GPA = Print.enterGPA();
		}

		Intern newIntern = new Intern(name, employeeID, totGross, GPA);
		employees.add(newIntern);
		employees.remove(foundEmployee);
		}
	}
		
	public void promoteToEmployee(String employeeID) {
		    
		Employee foundEmployee = retrieveEmployee(employeeID);
		
		String name = foundEmployee.getName();
		Double totGross = foundEmployee.getTotGross();
		
		Employee newEmployee = new Employee(name, employeeID, totGross);
		employees.add(newEmployee);
		employees.remove(foundEmployee);
	}
	
}