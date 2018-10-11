package reusaxcorp;


public class Director extends Manager{

	private String department;
	private Double benefit = 0.0;
	
	public Director(String name, String id, Double grossSalary, String degree, String department) {
		super(name, id, grossSalary, degree);
		this.department = department;
		this.benefit();
	}
	
	public static Director registerDirector() {
	   	 
        //parameters to read for the Employee-constructor
        String name, id, degree, department;
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
        
        System.out.println("Enter the department of your new employee: ");
        department = ReusaxCorpMain.input.nextLine();
 
        //Creating an object of Employee with given input and returning it
        Director newDirector = new Director(name, id, grossSalary, degree, department);
        
		return newDirector;
	}
	
	
	public void benefit() {
		this.setTotGross(this.getTotGross() + benefit);
	}
	
	public Double getBenefit() {
		return benefit;
	}

	public void setBenefit(Double benefit) {
		this.benefit = benefit;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
