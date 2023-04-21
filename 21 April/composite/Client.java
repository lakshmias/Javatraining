import java.util.List;
import java.util.ArrayList;
import java.util.List;
//Client code
public class Client {
	public static void main(String[] args) {
		Employee john = new RegularEmployee("John", "Sales", 5000);
		Employee jane = new RegularEmployee("Jane", "Marketing", 6000);

		Employee bob = new Manager("Bob", "Sales", 10000);
		bob.add(john);

		Employee sarah = new Manager("Sarah", "Marketing", 12000);
		sarah.add(jane);

		Employee alice = new Manager("Alice", "CEO", 20000);
		alice.add(bob);
		alice.add(sarah);

		System.out.println("Employee details:");
		System.out.println(alice.getName() + ", " + alice.getDepartment() + ", " + alice.getSalary());

		List<Employee> subordinates = alice.getSubordinates();
		for (Employee subordinate : subordinates) {
			System.out.println(
					"\t" + subordinate.getName() + ", " + subordinate.getDepartment() + ", " + subordinate.getSalary());
			List<Employee> subSubordinates = subordinate.getSubordinates();
			if (subSubordinates != null) {
				for (Employee subSubordinate : subSubordinates) {
					System.out.println("\t\t" + subSubordinate.getName() + ", " + subSubordinate.getDepartment() + ", "
							+ subSubordinate.getSalary());
				}
			}
		}
	}
}
// Component interface
interface Employee {
    public void add(Employee employee);
    public void remove(Employee employee);
    public List<Employee> getSubordinates();
    public String getName();
    public String getDepartment();
    public double getSalary();
}

//Composite class
class Manager implements Employee {
	private String name;
	private String department;
	private double salary;
	private List<Employee> subordinates;

	public Manager(String name, String department, double salary) {
		this.name = name;
		this.department = department;
		this.salary = salary;
		subordinates = new ArrayList<>();
	}

	@Override
	public void add(Employee employee) {
		subordinates.add(employee);
	}

	@Override
	public void remove(Employee employee) {
		subordinates.remove(employee);
	}

	@Override
	public List<Employee> getSubordinates() {
		return subordinates;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDepartment() {
		return department;
	}

	@Override
	public double getSalary() {
		double totalSalary = salary;
		for (Employee subordinate : subordinates) {
			totalSalary += subordinate.getSalary();
		}
		return totalSalary;
	}
}

//Leaf class
class RegularEmployee implements Employee {
	private String name;
	private String department;
	private double salary;

	public RegularEmployee(String name, String department, double salary) {
		this.name = name;
		this.department = department;
		this.salary = salary;
	}

	@Override
	public void add(Employee employee) {
		// Leaf node cannot have subordinates
	}

	@Override
	public void remove(Employee employee) {
		// Leaf node cannot have subordinates
	}

	@Override
	public List<Employee> getSubordinates() {
		// Leaf node does not have subordinates
		return null;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDepartment() {
		return department;
	}

	@Override
	public double getSalary() {
		return salary;
	}
}