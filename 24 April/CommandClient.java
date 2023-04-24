public class CommandClient {
	public static void main(String[] args) {
		// Create the Receiver object
		Employee employee = new Employee("Shiva Priya", 123);

		// Create the Command objects
		AddEmployeeCommand addCommand = new AddEmployeeCommand(employee);
		RemoveEmployeeCommand removeCommand = new RemoveEmployeeCommand(employee);

		// Create the Invoker object
		EmployeeManagement management = new EmployeeManagement();

		// Set and execute the AddEmployeeCommand
		management.setCommand(addCommand);
		management.executeCommand();

		// Set and execute the RemoveEmployeeCommand
		management.setCommand(removeCommand);
		management.executeCommand();
	}
}

//Define the Receiver class
class Employee {
    private String name;
    private int id;
   
    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }
   
    public String getName() {
        return name;
    }
   
    public int getId() {
        return id;
    }
   }

   //Define the Invoker class
class EmployeeManagement {
    private Command command;
   
    public void setCommand(Command command) {
        this.command = command;
    }
   
    public void executeCommand() {
        command.execute();
    }
   }
   class RemoveEmployeeCommand implements Command {
    private Employee employee;

    public RemoveEmployeeCommand(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void execute() {
        // Code to remove the employee from the system
        System.out.println("Removing employee " + employee.getName() + " from the system...");
    }
}

//Define the concrete Command classes
class AddEmployeeCommand implements Command {
    private Employee employee;
   
    public AddEmployeeCommand(Employee employee) {
        this.employee = employee;
    }
   
    @Override
    public void execute() {
        // Code to add the employee to the system
        System.out.println("Adding employee " + employee.getName() + " to the system...");
    }
   }

   //Define the Command interface
interface Command {
    void execute();
   }