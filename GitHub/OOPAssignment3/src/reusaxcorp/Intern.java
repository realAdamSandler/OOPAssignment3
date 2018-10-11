package reusaxcorp;

public class Intern extends Employee{

	private int GPA;
	
	public Intern(String name, String id, Double grossSalary, int GPA) {
		super(name, id, grossSalary);
		this.GPA = GPA;
		this.GPASalary(GPA);
	}

	public void GPASalary(int GPA) {
		if (GPA <= 5) {
			this.setTotGross(0.0);
		} else if (5 < GPA && GPA > 8 ) {
			this.setTotGross(this.getGrossSalary());
		} else if (GPA >= 8) {
			this.setTotGross(this.getGrossSalary() + 1000.0);
		}
	}
	
	public static Intern registerIntern() {
	   	 
        //parameters to read for the Employee-constructor
        String name, id;
        double grossSalary;
        int GPA;
 
        System.out.println("Enter the name of your new employee:");
        name = ReusaxCorpMain.input.nextLine();
        
        System.out.println("Enter the ID of your new employee");
        id = ReusaxCorpMain.input.nextLine();
        
        System.out.println("Enter the salary of your new employee:");
        grossSalary = ReusaxCorpMain.input.nextDouble();
        ReusaxCorpMain.input.nextLine();
        
        System.out.println("Enter the GPA of your new employee: ");
        GPA = ReusaxCorpMain.input.nextInt();
        ReusaxCorpMain.input.nextLine();
 
        //Creating an object of Employee with given input and returning it
        Intern newIntern = new Intern(name, id, grossSalary, GPA);
        
		return newIntern;
	}
	
	public int getGPA() {
		return GPA;
	}

	public void setGPA(int gPA) {
		GPA = gPA;
	}

}
