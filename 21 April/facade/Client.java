public class Client {
    public static void main(String[] args) {
        EmployeeFacade employeeFacade = new EmployeeFacade("John", "Manager", 50000);

        System.out.println("Employee Details:\n" + employeeFacade.getEmployeeDetails());
        System.out.println("Salary: " + employeeFacade.getSalary());

        employeeFacade.increaseSalary(10000);

        System.out.println("Employee Details:\n" + employeeFacade.getEmployeeDetails());
        System.out.println("Salary: " + employeeFacade.getSalary());
    }
}

// Complex System Classes
class Employee {
	private String name;
    private String designation;
    private int salary;

    public Employee(String name, String designation, int salary) {
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public int getSalary() {
        return salary;
    }
}
class EmployeeFacade {
	private Employee employee;

    public EmployeeFacade(String name, String designation, int salary) {
        employee = new Employee(name, designation, salary);
    }

    public String getEmployeeDetails() {
        String employeeDetails = "Name: " + employee.getName() + "\nDesignation: " + employee.getDesignation() + "\nSalary: " + employee.getSalary();
        return employeeDetails;
    }

    public int getSalary() {
        return employee.getSalary();
    }

    public void increaseSalary(int amount) {
        int newSalary = employee.getSalary() + amount;
        employee = new Employee(employee.getName(), employee.getDesignation(), newSalary);
        System.out.println("Salary increased to: " + newSalary);
    }
}

