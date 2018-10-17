package reusaxcorp;

import java.util.ArrayList;

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
 
    //Registering
    public void registerEmployee(String name, String id, Double grossSalary) {
    	//Creating an object of Employee with given input and returning it
        Employee newEmployee = new Employee(name, id, grossSalary);
        employees.add(newEmployee);
    }
    
    public void registerManager(String name, String id, Double grossSalary, String degree) {
      
        Manager newManager = new Manager(name, id, grossSalary, degree);
        employees.add(newManager);
	}
    
    public void registerDirector(String name, String id, Double grossSalary, String degree, String department) {
    	
        Director newDirector = new Director(name, id, grossSalary, degree, department);
        employees.add(newDirector);
	}
    
    public void registerIntern(String name, String id, Double grossSalary, int GPA) {

        Intern newIntern = new Intern(name, id, grossSalary, GPA);
        employees.add(newIntern);
	}
 
    //EmployeeSpecific
    public void removeEmployee(Employee foundEmployee) {
    		employees.remove(foundEmployee);
    }
 
	public Employee retrieveEmployee(String employeeID) {
		for (int i = 0; i < this.employees.size(); i++) {
			if(employees.get(i) != null && employees.get(i).getId().equals(employeeID)) {
				return employees.get(i);
			}
		}return null;
	}
    
	public void printEmployee(Employee foundEmployee) {
		System.out.println(foundEmployee);	
	}

	//Updating
	public void updateName(Employee foundEmployee, String name) {
		foundEmployee.setName(name);
	}
	
	public void updateGPA(Employee foundEmployee, int GPA) {
		((Intern) foundEmployee).setGPA(GPA);
		((Intern) foundEmployee).GPASalary();
	}
	
	public void updateGrossSalary(Employee foundEmployee, Double grossSalary) {
		foundEmployee.setGrossSalary(grossSalary);
	}
	
	public void updateDegreeManager(Employee foundEmployee, String degree) {
		((Manager) foundEmployee).setDegree(degree);
        ((Manager) foundEmployee).bonusSalary();
	}
	
	public void updateDegreeDirector(Employee foundEmployee, String degree) {
		((Director) foundEmployee).setDegree(degree);
		((Director) foundEmployee).bonusSalary();
	}
	
	public void updateDepartment(Employee foundEmployee, String department) {
		((Director) foundEmployee).setDepartment(department);
        ((Director) foundEmployee).bonusSalary();
	}

	//Totals
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

	//Promotion
	public void promoteToManager(Employee foundEmployee, String name, String employeeID, Double totGross, String degree) {
		Manager newManager = new Manager(name, employeeID, totGross, degree);
		employees.add(newManager);
		employees.remove(foundEmployee);
	}

	public void promoteToDirector(Employee foundEmployee, String name, String employeeID, Double totGross, String degree, String department) {
		Director newDirector = new Director(name, employeeID, totGross, degree, department);
		employees.add(newDirector);
		employees.remove(foundEmployee);
	}

	public void promoteToIntern(Employee foundEmployee, String name, String employeeID, Double totGross, int GPA) {
		Intern newIntern = new Intern(name, employeeID, totGross, GPA);
		employees.add(newIntern);
		employees.remove(foundEmployee);
	}
		
	public void promoteToEmployee(Employee foundEmployee, String name, String employeeID, Double totGross) {
		Employee newEmployee = new Employee(name, employeeID, totGross);
		employees.add(newEmployee);
		employees.remove(foundEmployee);
	}
	
}