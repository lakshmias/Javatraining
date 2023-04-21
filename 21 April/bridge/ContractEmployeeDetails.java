package bridge;

//Refined Abstraction
public class ContractEmployeeDetails implements EmployeeDetails {
	private Employee employee;

	public ContractEmployeeDetails(Employee employee) {
		this.employee = employee;
	}

	@Override
	public void displayDetails() {
		System.out.println("Name: " + employee.getName());
		System.out.println("Age: " + employee.getAge());
		System.out.println("Rate: " + employee.getRate());
		System.out.println("Hours: " + employee.getHours());
	}
}