package reusaxcorp;

public class Employee {
	
	private String name;
	private String id;
	private Double grossSalary;
	
	public Employee(String name, String id, Double grossSalary) {
		this.name = name;
		this.id = id;
		this.grossSalary = grossSalary;
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
	
	public Double netSalary() {
		Double netSalary = this.grossSalary - (this.grossSalary * 0.1);
		return netSalary;
	}
	
}
