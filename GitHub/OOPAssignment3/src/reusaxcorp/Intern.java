package reusaxcorp;

public class Intern extends Employee{

	private int GPA;
	
	public Intern(String name, String id, Double grossSalary, int GPA) {
		super(name, id, grossSalary);
		this.GPA = GPA;
		this.GPASalary();
	}

	@Override
	public String toString() {
		final String endOfLine = System.lineSeparator();
        String printThis = "ID: " + getId() + endOfLine;
        printThis += "Name: " + getName() + endOfLine;
        printThis += "Position: Intern" + endOfLine;
        printThis += "GPA: " + getGPA() + endOfLine;
        printThis += "Gross salary: " + getTotGross() + " SEK" + endOfLine;
        printThis += "Net salary: " + getNetSalary() + " SEK" + endOfLine;
        return printThis;
	}
	
	public void GPASalary() {
		
		GPA = this.getGPA();
		
		if (GPA <= 5) {
			this.setTotGross(0.0);
		} else if (GPA > 5 && GPA < 8) {
			this.setTotGross(this.getGrossSalary());
		} else if (GPA >= 8) {
			this.setTotGross(this.getGrossSalary() + 1000.0);
		}
	}
	
	public int getGPA() {
		return GPA;
	}

	public void setGPA(int gPA) {
		GPA = gPA;
	}

}
