public class Client {
	public static void main(String[] args) {
		Employee employee = new EmployeeProxy("Shiva");
		employee.work();
		employee.work();
	}
}

class EmployeeProxy implements Employee {
    private final String name;
    private RealEmployee realEmployee;

    public EmployeeProxy(String name) {
        this.name = name;
    }

    @Override
    public void work() {
        if (realEmployee == null) {
            realEmployee = new RealEmployee(name);
        }
        realEmployee.work();
    }
}

class RealEmployee implements Employee {
    private final String name;

    public RealEmployee(String name) {
        this.name = name;
        loadFromDatabase(name);
    }

    private void loadFromDatabase(String name) {
        // load employee details from database
        System.out.println("Loading employee " + name + " from database...");
        // simulate time-consuming operation
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Employee " + name + " loaded from database.");
    }

    @Override
    public void work() {
        System.out.println(name + " is working...");
    }
}

interface Employee {
    void work();
}