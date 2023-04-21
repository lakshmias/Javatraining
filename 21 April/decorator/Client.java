public class Client {
	// Usage example
	public static void main(String[] args) {
		Employee employee = new BaseEmployee("Shiva Priya", 50000);
		Employee bonusEmployee = new BonusEmployee(employee, 10000);
		Employee commissionEmployee = new CommissionEmployee(bonusEmployee, 0.05, 50000);

		System.out.println("Name: " + commissionEmployee.getName());
		System.out.println("Salary: " + commissionEmployee.getSalary());
	}
}

class CommissionEmployee extends EmployeeDecorator {
	private double commissionRate;
	private double sales;

	public CommissionEmployee(Employee employee, double commissionRate, double sales) {
		super(employee);
		this.commissionRate = commissionRate;
		this.sales = sales;
	}

	public double getSalary() {
		return employee.getSalary() + commissionRate * sales;
	}
}
/*
 * 
The decorator pattern is a design pattern used in object-oriented programming to add behavior 
to an individual object dynamically, without affecting the behavior of other objects from the same class.

The decorator pattern is often used in situations where you want to add functionality to an existing class, 
but don't want to modify the original class. By using decorators, 
you can add new behavior to an object by wrapping it with one or more decorator objects that add specific behaviors.

Some common examples of where the decorator pattern is used include:

User interfaces: Decorators can be used to add new features to a user interface 
without changing the underlying code.

Web applications: Decorators can be used to add security or logging features to a web application 
without modifying the original code.

Text processing: Decorators can be used to add formatting or markup to text 
without changing the original text.

Game development: Decorators can be used to add new abilities or powers to game characters 
without modifying the original character classes.

Overall, the decorator pattern is a powerful tool for adding new behavior to an existing class, 
without changing the behavior of other objects from the same class,
 making it a useful tool for software developers


*/

//Define concrete decorator classes
class BonusEmployee extends EmployeeDecorator {
	private double bonus;

	public BonusEmployee(Employee employee, double bonus) {
		super(employee);
		this.bonus = bonus;
	}

	public double getSalary() {
		return employee.getSalary() + bonus;
	}
}

//Define the base Employee class
class BaseEmployee implements Employee {
	private String name;
	private double salary;

	public BaseEmployee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}
}

//Define the base Employee interface
interface Employee {
	String getName();

	double getSalary();
}

//Define the base decorator class
abstract class EmployeeDecorator implements Employee {
	protected Employee employee;

	public EmployeeDecorator(Employee employee) {
		this.employee = employee;
	}

	public String getName() {
		return employee.getName();
	}

	public double getSalary() {
		return employee.getSalary();
	}
}