//Adaptee class
class Employee {
	private String firstName;
	private String lastName;
	private int age;

	public Employee(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}
}
//Adapter class
class EmployeeAdapter implements Person {
    private Employee employee;

    public EmployeeAdapter(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String getFullName() {
        return employee.getFirstName() + " " + employee.getLastName();
    }

    @Override
    public int getAge() {
        return employee.getAge();
    }
}

//Target interface
interface Person {
    public String getFullName();
    public int getAge();
}