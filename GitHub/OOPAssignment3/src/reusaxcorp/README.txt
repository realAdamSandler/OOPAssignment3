to do list:
- What to put in Main and what to put in ReusaxCorp?
- create methods for inputs etc? (print class)
- check copies of code and make into methods & reuse inheritance for methods?
- task5 obv

promoteToManager("ID", "degree") {
	String employeeID = readEmployeeID();     
	Employee foundEmployee = retrieveEmployee(employeeID);
	
	name = foundEmployee.getName();
	totGross = foundEmployee.getTotGross();

	if (foundEmployee.getClass() == Director.class) {
		degree = ((Director) foundEmployee).getDegree();
		department = ((Director) foundEmployee).getDepartment();
	}
	
	if else (foundEmployee.getClass() == Intern.class) {
		GPA = ((Intern) foundEmployee).getGPA();
	} else {

	}

promoteToDirector("ID", "degree", "department") {
	String employeeID = readEmployeeID();     
	Employee foundEmployee = retrieveEmployee(employeeID);

	name = foundEmployee.getName();
	totGross = foundEmployee.getTotGross();

	if (foundEmployee.getClass() == Manager.class) {
		degree = ((Manager) foundEmployee).getDegree();
	}
	
	if else (foundEmployee.getClass() == Intern.class) {
		GPA = ((Intern) foundEmployee).getGPA();
	} else {

	}

promoteToIntern("ID", "GPA") {
	String employeeID = readEmployeeID();     
	Employee foundEmployee = retrieveEmployee(employeeID);

	name = foundEmployee.getName();
	totGross = foundEmployee.getTotGross();

	if (foundEmployee.getClass() == Manager.class) {
		degree = ((Manager) foundEmployee).getDegree();
	}

	if else (foundEmployee.getClass() == Director.class) {
		degree = ((Director) foundEmployee).getDegree();
		department = ((Director) foundEmployee).getDepartment();
	} else {

	}

promoteToEmployee("ID) {
	String employeeID = readEmployeeID();     
	Employee foundEmployee = retrieveEmployee(employeeID);
	
	name = foundEmployee.getName();
	totGross = foundEmployee.getTotGross();

	if (foundEmployee.getClass() == Manager.class) {
		degree = ((Manager) foundEmployee).getDegree();
	}

	if else (foundEmployee.getClass() == Director.class) {
		degree = ((Director) foundEmployee).getDegree();
		department = ((Director) foundEmployee).getDepartment();
	}
	
	if else (foundEmployee.getClass() == Intern.class) {
		GPA = ((Intern) foundEmployee).getGPA();
	} else {

	}
