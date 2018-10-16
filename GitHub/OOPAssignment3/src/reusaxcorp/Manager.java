package reusaxcorp;

public class Manager extends Employee{

	private String degree;
	
	public Manager(String name, String id, Double grossSalary, String degree) {
		super(name, id, grossSalary);
		this.degree = degree;
		this.bonusSalary();
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
	
	@Override
	public String toString() {
		final String endOfLine = System.lineSeparator();
        String printThis = "ID: " + getId() + endOfLine;
        printThis += "Name: " + getName() + endOfLine;
        printThis += "Position: Manager" + endOfLine;
        printThis += "Degree: " + getDegree() + endOfLine;
        printThis += "Gross salary: " + getTotGross() + " SEK" + endOfLine;
        printThis += "Net salary: " + getNetSalary() + " SEK" + endOfLine;
        return printThis;
	}
	
	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}
	
}
