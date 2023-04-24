import java.util.Date;

class Customer {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Customer(String name) {
		this.name = name;
	}

	public void sendMessage(String message) {
		CustomerCare.sendMessage(this, message);
	}
}

class CustomerCare {

	public static void sendMessage(Customer user, String message) {
		System.out.println(new Date().toString() + " [" + user.getName() + "] : " + message);
	}
}

public class MediatorClient {
	public static void main(String[] args) {
		Customer rakesh = new Customer("Rakesh");
		Customer lenin = new Customer("Lenin");

		rakesh.sendMessage("Laptop is generating more heat");
		lenin.sendMessage("Please check the battery");
	}
}