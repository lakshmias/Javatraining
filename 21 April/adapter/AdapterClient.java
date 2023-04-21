

//Client code
class Client {
    public static void main(String[] args) {
        Employee employee = new Employee("Shiva", "Priya", 30);
        Person person = new EmployeeAdapter(employee);

        System.out.println("Person full name: " + person.getFullName());
        System.out.println("Person age: " + person.getAge());
    }
}


interface Bird {
	public void makeSound();
}

class Duck implements Bird {

	@Override
	public void makeSound() {
		System.out.println("Duck says quack quack");
	}
}

class BirdAdapter implements Bird {

	private WhiteDuck whiteDuck;

	public BirdAdapter(WhiteDuck duck) {
		this.whiteDuck =duck;
	}

	@Override
	public void makeSound() {
		this.whiteDuck.squeak();
	}

}

//Adaptee
class WhiteDuck {
	public void squeak() {
		System.out.println("Squeaking");
	}
}

//Client
public class AdapterClient {

	public static void main(String[] args) {
		Bird duck = new Duck();
		duck.makeSound();

		Bird toyBird = new BirdAdapter(new WhiteDuck());
		toyBird.makeSound();
	}

}

/*
Adapter Pattern: Converts the interface of a class into another interface that clients expect, 
allowing classes with incompatible interfaces to work together.

In this example, Employee is the Adaptee class, which has an existing interface 
that is not compatible with the Person interface. The EmployeeAdapter class is the Adapter, 
which adapts the Employee interface to the Person interface.

The Client class uses the EmployeeAdapter to create a Person object 
from an Employee object and calls the methods defined by the Person interface.

*/
