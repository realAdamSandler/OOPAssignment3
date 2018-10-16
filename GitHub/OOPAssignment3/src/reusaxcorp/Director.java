package reusaxcorp;

public class Director extends Employee{

	private String department;
	private String degree;
	//private static Double benefit = 0.0;
	
	public Director(String name, String id, Double grossSalary, String degree, String department) {
		super(name, id, grossSalary);
		this.degree = degree;
		this.department = department;
		this.bonusSalary();
	}
	
	@Override
	public String toString() {
		final String endOfLine = System.lineSeparator();
        String printThis = "ID: " + getId() + endOfLine;
        printThis += "Name: " + getName() + endOfLine;
        printThis += "Position: Director" + endOfLine;
        printThis += "Degree: " + getDegree() + endOfLine;
        printThis += "Department: " + getDepartment() + endOfLine;
        printThis += "Gross salary: " + getTotGross() + " SEK" + endOfLine;
        printThis += "Net salary: " + getNetSalary() + " SEK" +endOfLine;
        return printThis;
	}
	
	public void bonusSalary() {
		
		degree = this.getDegree();
		
		switch (degree) {
		
		case "BSc.":
			this.setTotGross(this.getGrossSalary() + this.getGrossSalary() * 0.10);
			break;
			
		case "MSc.":
			this.setTotGross(this.getGrossSalary() + this.getGrossSalary() * 0.20);
			break;
			
		case "PhD":
			this.setTotGross(this.getGrossSalary() + this.getGrossSalary() * 0.35);
			break;	
		}
	}
	
	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getDegree() {
		return degree;
	}

	public Double getTotGross() {
		return totGross + directorsBenefit;
	}
	
	@Override
	public Double getNetSalary() {
		Double netSalary;
		Double tempTotGross = this.getTotGross();
		
		if ( tempTotGross < 30000) {
			netSalary = tempTotGross - (tempTotGross * 0.10);
			return netSalary;
			
		} else if ( 30000 <= tempTotGross && tempTotGross <= 50000 ) {
			netSalary = tempTotGross - (tempTotGross * 0.20);
			return netSalary;
			
		} else if ( tempTotGross > 50000 ) {
			Double grossSalaryOver30 = tempTotGross - 30000;
			netSalary = ( grossSalaryOver30 - ( grossSalaryOver30 * 0.40 ) ) + ( 30000 - ( 30000 * 0.20 ) );
			return netSalary;
		} else {
			return null;
		}
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
