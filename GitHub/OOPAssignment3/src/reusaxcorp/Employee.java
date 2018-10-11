package reusaxcorp;

public class Employee {
	
	private String name;
	private String id;
	private Double grossSalary;
	private Double totGross;
	
	public Employee(String name, String id, Double grossSalary) {
		this.name = name;
		this.id = id;
		this.grossSalary = grossSalary;
		totGross = grossSalary;
	}

	
    public static Employee registerEmployee() {
    	 
        //parameters to read for the Employee-constructor
        String name, id;
        double grossSalary;
 
        System.out.println("Enter the name of your new employee:");
        name = ReusaxCorpMain.input.nextLine();
        
        System.out.println("Enter the ID of your new employee");
        id = ReusaxCorpMain.input.nextLine();
        
        System.out.println("Enter the salary of your new employee:");
        grossSalary = ReusaxCorpMain.input.nextDouble();
        ReusaxCorpMain.input.nextLine();
 
        //Creating an object of Employee with given input and returning it
        Employee employeeRegistered = new Employee(name, id, grossSalary);
        
        return employeeRegistered;
    }
	
	public Double getTotGross() {
		return totGross;
	}

	public void setTotGross(Double totGross) {
		this.totGross = totGross;
	}

	public String toString() {
		final String endOfLine = System.lineSeparator();
        String printThis = "ID: " + id + endOfLine;
        printThis += "Name: " + name + endOfLine;
        printThis += "Salary: " + totGross + endOfLine;
            
        return printThis;
	}

	public String getEmployeeSalary() {
		String result = ( this.name + "’s gross salary is of " + this.grossSalary + " SEK per month.");
		return result;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(Double grossSalary) {
		this.grossSalary = grossSalary;
	}

	public String getId() {
		return id;
	}
	
	public Double getNetSalary() {
		Double netSalary = this.grossSalary - (this.grossSalary * 0.1);
		return netSalary;
	}
	
}
