package reusaxcorp;

public class Manager extends Employee{

	private String degree;
	
	public Manager(String name, String id, Double grossSalary, String degree) {
		super(name, id, grossSalary);
		this.degree = degree;
		this.bonusSalary(degree);
	}

	public void bonusSalary(String degree) {
		
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
	
	public static Manager registerManager() {
   	 
        //parameters to read for the Employee-constructor
        String name, id, degree;
        double grossSalary;
 
        System.out.println("Enter the name of your new employee:");
        name = ReusaxCorpMain.input.nextLine();
        
        System.out.println("Enter the ID of your new employee");
        id = ReusaxCorpMain.input.nextLine();
        
        System.out.println("Enter the salary of your new employee:");
        grossSalary = ReusaxCorpMain.input.nextDouble();
        ReusaxCorpMain.input.nextLine();
        
        System.out.println("Enter the degree of your new employee: ");
        degree = ReusaxCorpMain.input.nextLine();
 
        //Creating an object of Employee with given input and returning it
        Manager newManager = new Manager(name, id, grossSalary, degree);
        
		return newManager;
	}
	
	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	
}
