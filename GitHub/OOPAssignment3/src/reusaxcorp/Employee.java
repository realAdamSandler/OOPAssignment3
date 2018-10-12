package reusaxcorp;

public class Employee {
	
	private String name;
	private String id;
	private Double grossSalary;
	private Double totGross;
	private static Double directorsBenefit = 0.0;
	
	public Employee(String name, String id, Double grossSalary) {
		this.name = name;
		this.id = id;
		this.grossSalary = grossSalary;
		totGross = grossSalary;
	}

	
    public static Double getDirectorsBenefit() {
		return directorsBenefit;
	}

	public static void setDirectorsBenefit(Double directorsBenefit) {
		Employee.directorsBenefit = directorsBenefit;
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
	
	public Double totGross() {
		return totGross;
	}
	
	public Double getTotGross() {
		if (this.getClass() != Director.class) {
			return totGross;
		} else {
			totGross = this.totGross() + directorsBenefit;
			return totGross;
		}
	}

	public void setTotGross(Double totGross) {
		this.totGross = totGross;
	}

	public String toString() {
		final String endOfLine = System.lineSeparator();
        String printThis = "ID: " + id + endOfLine;
        printThis += "Name: " + name + endOfLine;
        printThis += "Gross salary: " + this.getTotGross() + endOfLine;
        printThis += "Net salary: " + this.getNetSalary() + endOfLine;
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
		Double netSalary = this.totGross - (this.totGross * 0.10);
		return netSalary;
	}
	
}
