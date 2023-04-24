//Example usage
public class Main {
    public static void main(String[] args) {
        // Create the chain of responsibility
        Employee supervisor = new Supervisor();
        Employee manager = new Manager();
        Employee director = new Director();
   
        supervisor.setNextEmployee(manager);
        manager.setNextEmployee(director);
   
        // Process requests
        supervisor.processRequest(new Request(RequestType.LEAVE, 2));
        supervisor.processRequest(new Request(RequestType.LEAVE, 7));
        supervisor.processRequest(new Request(RequestType.LEAVE, 14));
        supervisor.processRequest(new Request(RequestType.TRAVEL, 5));
    }
   }

   //Enum class representing the types of requests that can be handled
enum RequestType {
    LEAVE,
    TRAVEL,
    EXPENSE
   }

   //Request class that holds information about the request to be processed
class Request {
	private RequestType type;
	private int days;

	public Request(RequestType type, int days) {
		this.type = type;
		this.days = days;
	}

	public RequestType getType() {
		return type;
	}

	public int getDays() {
		return days;
	}
}

abstract class Employee {
	private Employee nextEmployee;

	public void setNextEmployee(Employee nextEmployee) {
		this.nextEmployee = nextEmployee;
	}

	public void processRequest(Request request) {
		if (canHandleRequest(request)) {
			handleRequest(request);
		} else if (nextEmployee != null) {
			nextEmployee.processRequest(request);
		}
	}

	protected abstract boolean canHandleRequest(Request request);

	protected abstract void handleRequest(Request request);
}

//Concrete Employee classes that represent different levels of authority in the chain
class Supervisor extends Employee {
	@Override
	protected boolean canHandleRequest(Request request) {
		return request.getType() == RequestType.LEAVE && request.getDays() <= 3;
	}

	@Override
	protected void handleRequest(Request request) {
		System.out
				.println("Supervisor approved a " + request.getType() + " request for " + request.getDays() + " days.");
	}
}

class Manager extends Employee {
	@Override
	protected boolean canHandleRequest(Request request) {
		return request.getType() == RequestType.LEAVE && request.getDays() <= 10;
	}

	@Override
	protected void handleRequest(Request request) {
		System.out.println("Manager approved a " + request.getType() + " request for " + request.getDays() + " days.");
	}
}

class Director extends Employee {
	@Override
	protected boolean canHandleRequest(Request request) {
		return request.getType() == RequestType.LEAVE && request.getDays() <= 30;
	}

	@Override
	protected void handleRequest(Request request) {
		System.out.println("Director approved a " + request.getType() + " request for " + request.getDays() + " days.");
	}
}