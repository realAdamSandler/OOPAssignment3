package reusaxcorp;

public class Employee {
	
	private String name;
	private String id;
	private Double grossSalary;
	protected Double totGross;
	
	public Employee(String name, String id, Double grossSalary) {
		this.name = name;
		this.id = id;
		this.grossSalary = grossSalary;
		totGross = grossSalary;
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
        printThis += "Gross salary: " + getTotGross() + " SEK" + endOfLine;
        printThis += "Net salary: " + getNetSalary() + " SEK" + endOfLine;
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
